package dev.l2j.tesla.gameserver.network.clientpackets;

import dev.l2j.tesla.Config;
import dev.l2j.tesla.commons.lang.StringUtil;
import dev.l2j.tesla.gameserver.data.ItemTable;
import dev.l2j.tesla.gameserver.data.SkillTable;
import dev.l2j.tesla.gameserver.data.sql.PlayerInfoTable;
import dev.l2j.tesla.gameserver.data.xml.NpcData;
import dev.l2j.tesla.gameserver.data.xml.PlayerData;
import dev.l2j.tesla.gameserver.data.xml.ScriptData;
import dev.l2j.tesla.gameserver.enums.ShortcutType;
import dev.l2j.tesla.gameserver.enums.actors.Sex;
import dev.l2j.tesla.gameserver.idfactory.IdFactory;
import dev.l2j.tesla.gameserver.model.L2Skill;
import dev.l2j.tesla.gameserver.model.Shortcut;
import dev.l2j.tesla.gameserver.model.World;
import dev.l2j.tesla.gameserver.model.actor.Player;
import dev.l2j.tesla.gameserver.model.actor.player.Experience;
import dev.l2j.tesla.gameserver.model.actor.template.PlayerTemplate;
import dev.l2j.tesla.gameserver.model.holder.ItemTemplateHolder;
import dev.l2j.tesla.gameserver.model.holder.skillnode.GeneralSkillNode;
import dev.l2j.tesla.gameserver.model.item.instance.ItemInstance;
import dev.l2j.tesla.gameserver.network.SystemMessageId;
import dev.l2j.tesla.gameserver.network.serverpackets.CharCreateFail;
import dev.l2j.tesla.gameserver.network.serverpackets.CharCreateOk;
import dev.l2j.tesla.gameserver.network.serverpackets.CharSelectInfo;
import dev.l2j.tesla.gameserver.network.serverpackets.SystemMessage;
import dev.l2j.tesla.gameserver.scripting.Quest;

@SuppressWarnings("unused")
public final class CharacterCreate extends L2GameClientPacket
{
	private String _name;
	private int _race;
	private byte _sex;
	private int _classId;
	private int _int;
	private int _str;
	private int _con;
	private int _men;
	private int _dex;
	private int _wit;
	private byte _hairStyle;
	private byte _hairColor;
	private byte _face;

	@Override
	protected void readImpl()
	{
		_name = readS();
		_race = readD();
		_sex = (byte) readD();
		_classId = readD();
		_int = readD();
		_str = readD();
		_con = readD();
		_men = readD();
		_dex = readD();
		_wit = readD();
		_hairStyle = (byte) readD();
		_hairColor = (byte) readD();
		_face = (byte) readD();
	}

	@Override
	protected void runImpl()
	{
		// Invalid race.
		// Invalid face.
		if (_race > 4 || _race < 0 || _face > 2 || _face < 0)
		{
			sendPacket(CharCreateFail.REASON_CREATION_FAILED);
			return;
		}

		// Invalid hair style.
		if (_hairStyle < 0 || (_sex == 0 && _hairStyle > 4) || (_sex != 0 && _hairStyle > 6))
		{
			sendPacket(CharCreateFail.REASON_CREATION_FAILED);
			return;
		}

		// Invalid hair color.
		if (_hairColor > 3 || _hairColor < 0)
		{
			sendPacket(CharCreateFail.REASON_CREATION_FAILED);
			return;
		}

		// Invalid name length, or name typo.
		if (!StringUtil.isValidString(_name, "^[A-Za-z0-9]{3,16}$"))
		{
			sendPacket((_name.length() > 16) ? CharCreateFail.REASON_16_ENG_CHARS : CharCreateFail.REASON_INCORRECT_NAME);
			return;
		}

		// Your name is already taken by a NPC.
		if (NpcData.getInstance().getTemplateByName(_name) != null)
		{
			sendPacket(CharCreateFail.REASON_INCORRECT_NAME);
			return;
		}

		// You already have the maximum amount of characters for this account.
		if (PlayerInfoTable.getInstance().getCharactersInAcc(getClient().getAccountName()) >= 7)
		{
			sendPacket(CharCreateFail.REASON_TOO_MANY_CHARACTERS);
			return;
		}

		// The name already exists.
		if (PlayerInfoTable.getInstance().getPlayerObjectId(_name) > 0)
		{
			sendPacket(CharCreateFail.REASON_NAME_ALREADY_EXISTS);
			return;
		}

		// The class id related to this template is post-newbie.
		final PlayerTemplate template = PlayerData.getInstance().getTemplate(_classId);
		if (template == null || template.getClassBaseLevel() > 1)
		{
			sendPacket(CharCreateFail.REASON_CREATION_FAILED);
			return;
		}

		// Create the player Object.
		final Player player = Player.create(IdFactory.getInstance().getNextId(), template, getClient().getAccountName(), _name, _hairStyle, _hairColor, _face, Sex.values()[_sex]);
		if (player == null)
		{
			sendPacket(CharCreateFail.REASON_CREATION_FAILED);
			return;
		}

		// Set default values.
		player.setCurrentCp(0);
		player.setCurrentHp(player.getMaxHp());
		player.setCurrentMp(player.getMaxMp());

		// send acknowledgement
		sendPacket(CharCreateOk.STATIC_PACKET);

		World.getInstance().addObject(player);

	//	player.getPosition().set(template.getRandomSpawn());
	//	player.setTitle("");
		if (Config.ALLOW_CREATE_LVL)
			player.getStat().addExp(Experience.LEVEL[Config.CHAR_CREATE_LVL]);


		if (Config.SPAWN_CHAR)
			player.setXYZInvisible(Config.SPAWN_X, Config.SPAWN_Y, Config.SPAWN_Z);
		else
			player.setXYZInvisible(template.getRandomSpawn());
		if (Config.CUSTOM_STARTER_ITEMS_ENABLED)
		{
			if (player.isMageClass())
			{
				for (final int[] reward : Config.STARTING_CUSTOM_ITEMS_M)
				{
					if (ItemTable.getInstance().createDummyItem(reward[0]).isStackable())
						player.getInventory().addItem("Starter Items Mage", reward[0], reward[1], player, null);
					else
						for (int i = 0; i < reward[1]; ++i)
							player.getInventory().addItem("Starter Items Mage", reward[0], 1, player, null);
				}
			}
			else
			{
				for (final int[] reward : Config.STARTING_CUSTOM_ITEMS_F)
				{
					if (ItemTable.getInstance().createDummyItem(reward[0]).isStackable())
						player.getInventory().addItem("Starter Items Fighter", reward[0], reward[1], player, null);
					else
						for (int i = 0; i < reward[1]; ++i)
							player.getInventory().addItem("Starter Items Fighter", reward[0], 1, player, null);
				}
			}
		}
		  if (Config.STARTING_BUFFS)
	        {
	           if (!player.isMageClass())
	           {
	              for (int[] buff : Config.STARTING_BUFFS_F) // Custom buffs for fighters
	              {
	                 L2Skill skill = SkillTable.getInstance().getInfo(buff[0], buff[1]);
	                 if (skill != null)
	                 {
	                    skill.getEffects(player, player);
	                    player.sendPacket(SystemMessage.getSystemMessage(SystemMessageId.YOU_FEEL_S1_EFFECT).addSkillName(buff[0]));
	                 }
	              }
	           }
	           else
	           {
	              for (int[] buff : Config.STARTING_BUFFS_M) // Custom buffs for mystics
	              {
	                 L2Skill skill = SkillTable.getInstance().getInfo(buff[0], buff[1]);
	                 if (skill != null)
	                 {
	                    skill.getEffects(player, player);
	                    player.sendPacket(SystemMessage.getSystemMessage(SystemMessageId.YOU_FEEL_S1_EFFECT).addSkillName(buff[0]));
	                 }
	              }
	           }
	        }
		//player.getPosition().set(template.getRandomSpawn());
		if (Config.CHAR_TITLE)
		{
			player.setTitle(Config.ADD_CHAR_TITLE);
		}
		else
		{
			player.setTitle("");
		}


		// Register shortcuts.
		player.getShortcutList().addShortcut(new Shortcut(0, 0, ShortcutType.ACTION, 2, -1, 1)); // attack shortcut
		player.getShortcutList().addShortcut(new Shortcut(3, 0, ShortcutType.ACTION, 5, -1, 1)); // take shortcut
		player.getShortcutList().addShortcut(new Shortcut(10, 0, ShortcutType.ACTION, 0, -1, 1)); // sit shortcut

		// Equip or add items, based on template.
		for (ItemTemplateHolder holder : template.getItems())
		{
			final ItemInstance item = player.getInventory().addItem("Init", holder.getId(), holder.getValue(), player, null);

			// Tutorial book shortcut.
			if (holder.getId() == 5588)
				player.getShortcutList().addShortcut(new Shortcut(11, 0, ShortcutType.ITEM, item.getObjectId(), -1, 1));

			if (item.isEquipable() && holder.isEquipped())
				player.getInventory().equipItemAndRecord(item);
		}

		// Add skills.
		for (GeneralSkillNode skill : player.getAvailableAutoGetSkills())
		{
			if (skill.getId() == 1001 || skill.getId() == 1177)
				player.getShortcutList().addShortcut(new Shortcut(1, 0, ShortcutType.SKILL, skill.getId(), 1, 1), false);

			if (skill.getId() == 1216)
				player.getShortcutList().addShortcut(new Shortcut(9, 0, ShortcutType.SKILL, skill.getId(), 1, 1), false);
		}

		// Tutorial runs here.
		if (!Config.DISABLE_TUTORIAL)
		{
			if (player.getQuestState("Tutorial") == null)
			{
				final Quest quest = ScriptData.getInstance().getQuest("Tutorial");
				if (quest != null)
					quest.newQuestState(player).setState(Quest.STATE_STARTED);
			}
		}

		player.setOnlineStatus(true, false);
		player.deleteMe();

		final CharSelectInfo csi = new CharSelectInfo(getClient().getAccountName(), getClient().getSessionId().playOkID1);
		sendPacket(csi);
		getClient().setCharSelectSlot(csi.getCharacterSlots());
	}
}