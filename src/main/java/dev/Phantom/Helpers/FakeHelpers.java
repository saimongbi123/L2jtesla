package dev.Phantom.Helpers;

import dev.Phantom.FakePlayer;
import dev.Phantom.FakePlayerNameManager;
import dev.Phantom.FakePlayerTitleManager;
import dev.Phantom.Util.*;
import dev.Phantom.ai.*;
import dev.l2j.tesla.Config;
import dev.l2j.tesla.commons.random.Rnd;
import dev.l2j.tesla.gameserver.data.SkillTable;
import dev.l2j.tesla.gameserver.data.sql.ClanTable;
import dev.l2j.tesla.gameserver.data.sql.PlayerInfoTable;
import dev.l2j.tesla.gameserver.data.xml.PlayerData;
import dev.l2j.tesla.gameserver.enums.actors.ClassId;
import dev.l2j.tesla.gameserver.enums.actors.Sex;
import dev.l2j.tesla.gameserver.idfactory.IdFactory;
import dev.l2j.tesla.gameserver.model.L2Skill;
import dev.l2j.tesla.gameserver.model.actor.Creature;
import dev.l2j.tesla.gameserver.model.actor.Player;
import dev.l2j.tesla.gameserver.model.actor.instance.Monster;
import dev.l2j.tesla.gameserver.model.actor.player.Appearance;
import dev.l2j.tesla.gameserver.model.actor.player.Experience;
import dev.l2j.tesla.gameserver.model.actor.template.PlayerTemplate;
import dev.l2j.tesla.gameserver.model.pledge.Clan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeHelpers {

	public static Class<? extends Creature> getTestTargetClass() {
		return Monster.class;
	}

	public static Class<? extends Player> getFlagTargetClass() {
		return Player.class;
	}

	public static int getTestTargetRange() {
		return 3000;
	}

	public static FakePlayer createRandomFakePlayer() {
		int objectId = IdFactory.getInstance().getNextId();
		String accountName = "AutoPilot";
		String playerName = FakePlayerNameManager.INSTANCE.getRandomAvailableName();
		String playerTitle = FakePlayerTitleManager.INSTANCE.getRandomAvailableTitle();
		ClassId classId = getThirdClasses().get(Rnd.get(0, getThirdClasses().size() - 1));
		final PlayerTemplate template = PlayerData.getInstance().getTemplate(classId);
		Appearance app = getRandomAppearance(template.getClass());

		FakePlayer player = new FakePlayer(objectId, template, accountName, app);
		player.setTitle(playerTitle);
		player.setName(playerName);
		player.setAccessLevel(Config.DEFAULT_ACCESS_LEVEL);
		PlayerInfoTable.getInstance().addPlayer(objectId, accountName, playerName, player.getAccessLevel().getLevel());
		player.setBaseClass(player.getClassId());
		setLevel(player, 81);
		player.rewardSkills();

		ArmorFakePlayer.giveArmorByClass(player, true);
		BufferByClass.giveBuffsByClass(player);
		HairHatByClass.giveAcessoryByClass(player);
		InvetoryItemsByClass.giveItemsInventory(player);
		JewelsByClass.giveJewelsByClass(player, true);
		WeaponsByClass.giveWeaponsByClass(player, true);

		player.heal();

		player.getAppearance().setNameColor(Integer.decode("0x" + Config.NAME_COLOR));
		player.getAppearance().setTitleColor(Integer.decode("0x" + Config.TITLE_COLOR));

		player.getAppearance().setNameColor(Integer.decode("0x" + FakeHelpers.getNameColor()));
		player.getAppearance().setTitleColor(Integer.decode("0x" + FakeHelpers.getTitleColor()));

		if (Rnd.get(100) < Config.PHANTOM_CHANCE_MALARIA) {
			L2Skill skill = SkillTable.getInstance().getInfo(4554, 4);
			skill.getEffects(player, player);
		}

		Clan clan = ClanTable.getInstance().getClan(getRandomClan());
		if (clan != null)
		{
			clan.addClanMember(player);
			clan.broadcastClanStatus();
		}
		
		if (Rnd.get(100) < Config.PHANTOM_CHANCE_HERO) {
			player.setHero(true);
			player.isHero();
			player.broadcastUserInfo();
		}
		player.broadcastTitleInfo();
		return player;
	}

	public static List<ClassId> getThirdClasses() {
		// removed summoner classes because fuck those guys
		List<ClassId> classes = new ArrayList<>();

		/*
		 * classes.add(ClassId.EVAS_SAINT); classes.add(ClassId.SHILLIEN_TEMPLAR);
		 * classes.add(ClassId.SPECTRAL_DANCER); classes.add(ClassId.GHOST_HUNTER);
		 * 
		 * classes.add(ClassId.PHOENIX_KNIGHT);
		 * 
		 * 
		 * classes.add(ClassId.HIEROPHANT); classes.add(ClassId.EVAS_TEMPLAR);
		 * classes.add(ClassId.SWORD_MUSE);
		 * 
		 * classes.add(ClassId.DOOMCRYER); classes.add(ClassId.FORTUNE_SEEKER);
		 * classes.add(ClassId.MAESTRO);
		 */

		classes.add(ClassId.ARCANA_LORD);
		classes.add(ClassId.ELEMENTAL_MASTER);
		classes.add(ClassId.SPECTRAL_MASTER);
		classes.add(ClassId.SHILLIEN_SAINT);
		classes.add(ClassId.MAESTRO);
		classes.add(ClassId.HELL_KNIGHT);
		classes.add(ClassId.SAGGITARIUS);
		classes.add(ClassId.ARCHMAGE);
		classes.add(ClassId.SOULTAKER);
		classes.add(ClassId.MYSTIC_MUSE);
		classes.add(ClassId.STORM_SCREAMER);
		classes.add(ClassId.MOONLIGHT_SENTINEL);
		classes.add(ClassId.GHOST_SENTINEL);
		classes.add(ClassId.ADVENTURER);
		classes.add(ClassId.WIND_RIDER);
		classes.add(ClassId.DOMINATOR);
		classes.add(ClassId.TITAN);
		classes.add(ClassId.CARDINAL);
		classes.add(ClassId.DUELIST);
		classes.add(ClassId.GRAND_KHAVATARI);
		classes.add(ClassId.DREADNOUGHT);
		classes.add(ClassId.HIEROPHANT);
		classes.add(ClassId.SWORD_MUSE);
		classes.add(ClassId.SPECTRAL_DANCER);

		return classes;
	}

	public static Map<ClassId, Class<? extends FakePlayerAI>> getAllAIs() {
		Map<ClassId, Class<? extends FakePlayerAI>> ais = new HashMap<>();
		ais.put(ClassId.STORM_SCREAMER, StormScreamerAI.class);
		ais.put(ClassId.MYSTIC_MUSE, MysticMuseAI.class);
		ais.put(ClassId.ARCHMAGE, ArchmageAI.class);
		ais.put(ClassId.SOULTAKER, SoultakerAI.class);
		ais.put(ClassId.SAGGITARIUS, SaggitariusAI.class);
		ais.put(ClassId.MOONLIGHT_SENTINEL, MoonlightSentinelAI.class);
		ais.put(ClassId.GHOST_SENTINEL, GhostSentinelAI.class);
		ais.put(ClassId.ADVENTURER, AdventurerAI.class);
		ais.put(ClassId.WIND_RIDER, WindRiderAI.class);
		ais.put(ClassId.GHOST_HUNTER, GhostHunterAI.class);
		ais.put(ClassId.HELL_KNIGHT, HellKnightAI.class);
		ais.put(ClassId.DOMINATOR, DominatorAI.class);
		ais.put(ClassId.TITAN, TitanAI.class);
		ais.put(ClassId.CARDINAL, CardinalAI.class);
		ais.put(ClassId.DUELIST, DuelistAI.class);
		ais.put(ClassId.GRAND_KHAVATARI, GrandKhavatariAI.class);
		ais.put(ClassId.DREADNOUGHT, DreadnoughtAI.class);
		return ais;
	}

	public static Appearance getRandomAppearance(Class<? extends PlayerTemplate> class1) {

		Sex randomSex = Rnd.get(1, 2) == 1 ? Sex.MALE : Sex.FEMALE;
		int hairStyle = Rnd.get(0, randomSex == Sex.MALE ? 2 : 6);
		int hairColor = Rnd.get(0, 3);
		int faceId = Rnd.get(0, 2);

		return new Appearance((byte) faceId, (byte) hairColor, (byte) hairStyle, randomSex);
	}

	public static void setLevel(FakePlayer player, int level) {
		if (level >= 1 && level <= Experience.MAX_LEVEL) {
			long pXp = player.getExp();
			long tXp = Experience.LEVEL[81];

			if (pXp > tXp)
				player.removeExpAndSp(pXp - tXp, 0);
			else if (pXp < tXp)
				player.addExpAndSp(tXp - pXp, 0);
		}
	}

	public static Class<? extends FakePlayerAI> getAIbyClassId(ClassId classId) {
		Class<? extends FakePlayerAI> ai = getAllAIs().get(classId);
		if (ai == null)
			return FallbackAI.class;

		return ai;
	}

	static String getNameColor() {
		return Config.PHANTOM_PLAYERS_NAME_CLOLORS.get(Rnd.get(Config.PHANTOM_PLAYERS_NAME_CLOLORS.size()));
	}

	static String getTitleColor() {
		return Config.PHANTOM_PLAYERS_TITLE_CLOLORS.get(Rnd.get(Config.PHANTOM_PLAYERS_TITLE_CLOLORS.size()));
	}

	public static void giveWeaponsByClass(FakePlayer _fakePlayer, boolean b) {
		WeaponsByClass.giveWeaponsByClass(_fakePlayer, true);
	}

	public static int getRandomClan()
	{
		return FakePlayerConfig.LIST_CLAN_ID.get(Rnd.get(FakePlayerConfig.LIST_CLAN_ID.size())).intValue();
	}
	
}



