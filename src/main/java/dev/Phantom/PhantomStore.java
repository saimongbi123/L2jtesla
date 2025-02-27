package dev.Phantom;

import dev.Phantom.Util.*;
import dev.l2j.tesla.Config;
import dev.l2j.tesla.L2DatabaseFactory;
import dev.l2j.tesla.commons.concurrent.ThreadPool;
import dev.l2j.tesla.commons.random.Rnd;
import dev.l2j.tesla.gameserver.data.SkillTable;
import dev.l2j.tesla.gameserver.data.sql.ClanTable;
import dev.l2j.tesla.gameserver.data.sql.PlayerInfoTable;
import dev.l2j.tesla.gameserver.data.xml.PlayerData;
import dev.l2j.tesla.gameserver.enums.actors.ClassId;
import dev.l2j.tesla.gameserver.enums.actors.Sex;
import dev.l2j.tesla.gameserver.enums.actors.StoreType;
import dev.l2j.tesla.gameserver.model.L2Skill;
import dev.l2j.tesla.gameserver.model.World;
import dev.l2j.tesla.gameserver.model.actor.Player;
import dev.l2j.tesla.gameserver.model.actor.player.Appearance;
import dev.l2j.tesla.gameserver.model.actor.player.Experience;
import dev.l2j.tesla.gameserver.model.actor.template.PlayerTemplate;
import dev.l2j.tesla.gameserver.model.item.instance.ItemInstance;
import dev.l2j.tesla.gameserver.model.location.Location;
import dev.l2j.tesla.gameserver.model.pledge.Clan;
import dev.l2j.tesla.gameserver.network.GameClient;
import dev.l2j.tesla.gameserver.network.GameClient.GameClientState;
import dev.l2j.tesla.gameserver.network.serverpackets.PrivateStoreMsgBuy;
import dev.l2j.tesla.gameserver.network.serverpackets.PrivateStoreMsgSell;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhantomStore {
	static final Logger _log = Logger.getLogger(PhantomStore.class.getName());
	static String _phantomAcc = Config.PHANTOM_PLAYERS_ACC_2;
	static int _PhantomsCount = 0;
	static int _PhantomsLimit = 0;
	static int _setsCount = 0;
	static int _setsCountClan = 0;
	volatile int _PhantomsTownTotal = 0;

	static int _setsArcherCount = 0;
	
	static PhantomStore _instance;
	static int _setsOlyCount = 0;
	
	static int _locsCount = 0;
	static ArrayList<Location> _PhantomsTownLoc = new ArrayList<>();

	static int _PhantomsEnchPhsCount = 0;
	static ArrayList<String> _PhantomsEnchPhrases = new ArrayList<>();
	static int _PhantomsLastPhsCount = 0;
	static ArrayList<String> _PhantomsLastPhrases = new ArrayList<>();
	static Map<Integer, ConcurrentLinkedQueue<Player>> _PhantomsTown = new ConcurrentHashMap<>();
	static Map<Integer, ConcurrentLinkedQueue<Player>> _PhantomsTownClan = new ConcurrentHashMap<>();
	static Map<Integer, ConcurrentLinkedQueue<Integer>> _PhantomsTownClanList = new ConcurrentHashMap<>();
	public static ArrayList<Player> _players = new ArrayList<>();

	public static PhantomStore getInstance() {
		return _instance;
	}

	private void load() {

		parceTownLocs();
		//parceArmors();
		cacheFantoms();
		_PhantomsTown.put(Integer.valueOf(1), new ConcurrentLinkedQueue<Player>());
		_PhantomsTown.put(Integer.valueOf(2), new ConcurrentLinkedQueue<Player>());

		FakePlayerNameManager.INSTANCE.initialise();

	}

	public void reload() {
		//parceArmors();
		parceTownLocs();
	}

	public static void init() {
		_instance = new PhantomStore();
		_instance.load();
	}

	static int getFaceEquipe() {
		return Config.LIST_PHANTOM_FACE.get(Rnd.get(Config.LIST_PHANTOM_FACE.size())).intValue();
	}

	static int getPrivateBuy() {
		return Config.LIST_PRIVATE_BUY.get(Rnd.get(Config.LIST_PRIVATE_BUY.size())).intValue();
	}

	static int getPrivateSell() {
		return Config.LIST_PRIVATE_SELL.get(Rnd.get(Config.LIST_PRIVATE_SELL.size())).intValue();
	}

	@SuppressWarnings("null")
	static Location getRandomLoc() {
		Location loc = null;
		if (loc == null) {
			loc = _PhantomsTownLoc.get(Rnd.get(0, _locsCount));
		}
		return loc;
	}

	public static void startWalk(Player paramPlayer) {
		ThreadPool.schedule(new PhantomWalk(paramPlayer), Rnd.get(5200, 48540));
	}

	

	private void cacheFantoms() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				ThreadPool.schedule(new FantomTask(1), 10000);
			}
		}).start();
	}



	static class PhantomWalk implements Runnable {
		Player _phantom;

		public PhantomWalk(Player paramPlayer) {
			_phantom = paramPlayer;
		}

		@Override
		public void run() {
			if (!_phantom.isDead()) {
				if ((Rnd.get(100) < Config.PHANTOM_PRIVATE_BUY_CHANCE) && (Config.PHANTOM_PRIVATE_STORE)) {
					_phantom.addItem(":", 57, 1000000000, _phantom, false);
					_phantom.getBuyList().addItemByItemId(getPrivateBuy(), 1, Rnd.get(1000, 24678));

					_phantom.getBuyList().setTitle(getPrivateBuy_Title());
					_phantom.sitDown(false);
					_phantom.setStoreType(StoreType.BUY);
					// _phantom.setStoreType(Player.StoreType.BUY);
					_phantom.broadcastUserInfo();
					_phantom.broadcastPacket(new PrivateStoreMsgBuy(_phantom));
				} else if ((Rnd.get(100) < Config.PHANTOM_PRIVATE_SELL_CHANCE) && (Config.PHANTOM_PRIVATE_STORE)) {
					_phantom.addItem(":", getPrivateSell(), 1, _phantom, true);
					for (ItemInstance itemDrop : _phantom.getInventory().getItems()) {
						_phantom.getSellList().addItem(itemDrop.getObjectId(), 1, Rnd.get(100456789, 150456789));
					}
					_phantom.getSellList().setTitle(getPrivateSell_Title());
					// _phantom.getSellList().setPackaged(Player.StoreType.SELL ==
					// Player.StoreType.PACKAGE_SELL);
					_phantom.getSellList().setPackaged(StoreType.SELL == StoreType.PACKAGE_SELL);
					_phantom.sitDown(false);
					_phantom.setStoreType(StoreType.SELL);
					// _phantom.setStoreType(Player.StoreType.SELL);

					_phantom.broadcastUserInfo();
					_phantom.broadcastPacket(new PrivateStoreMsgSell(_phantom));
				} else {
					if (_phantom.isSpawnProtected()) {
						_phantom.setSpawnProtection(false);
					}
					_phantom.rndWalk();

					PhantomStore.startWalk(_phantom);
				}
			}
		}
	}



	public static int getPlayersCount() {
		if (_players != null) {
			return _players.size();
		}
		return 0;
	}

	public static void removePlayers(Player spec) {
		if ((_players != null) && (_players.contains(spec))) {
			_players.remove(spec);

		}
	}

	static SimpleDateFormat sdf = new SimpleDateFormat("HH");

	public class FantomTask implements Runnable {
		public int _task;

		public FantomTask(int paramInt) {
			_task = paramInt;
		}

		@SuppressWarnings("resource")
		@Override
		public void run() {
			int i = 0;
			switch (_task) {
			case 1:
				PhantomStore._log.info("PhantomStore: Account " + Config.PHANTOM_PLAYERS_ACC_2 + ", spawn started.");
				try (Connection con = L2DatabaseFactory.getInstance().getConnection()) {
					PreparedStatement stm = con.prepareStatement(
							"SELECT obj_Id,char_name,title,x,y,z,sex,clanid FROM characters WHERE account_name = ?");
					stm.setString(1, PhantomStore._phantomAcc);

					ResultSet rs = stm.executeQuery();
					while (rs.next()) {
						FakePlayer player = null;
						try {

							ClassId classId = getThirdClasses().get(Rnd.get(0, getThirdClasses().size() - 1));
							final PlayerTemplate template = PlayerData.getInstance().getTemplate(classId);
							Appearance app = getRandomAppearance(template.getClass());
							player = new FakePlayer(rs.getInt("obj_Id"), template, Config.PHANTOM_PLAYERS_ACC_2, app);
							GameClient client = new GameClient(null);
							client.setDetached(true);
							player.setClient(client);
							client.setPlayer(player);
							player.setOnlineStatus(false, true);
							World.getInstance().addPlayer(player);
							client.setState(GameClient.GameClientState.IN_GAME);

							client.setAccountName(player.getAccountName());

							String playerName = FakePlayerNameManager.INSTANCE.getRandomAvailableName();
							player.setName(playerName);
							String playertitle = FakePlayerTitleManager.INSTANCE.getRandomAvailableTitle();
							player.setTitle(playertitle);
							player.broadcastTitleInfo();
							PlayerInfoTable.getInstance().updatePlayerData(player, false);

							Clan clan = ClanTable.getInstance().getClan(getRandomClan());
							if (clan != null)
							{
								clan.addClanMember(player);
								clan.broadcastClanStatus();
							}
							
						
							player.getAppearance().setNameColor(Integer.decode("0x" + PhantomStore.getNameColor()));
							player.getAppearance().setTitleColor(Integer.decode("0x" + PhantomStore.getTitleColor()));

							if (Rnd.get(100) < Config.PHANTOM_CHANCE_HERO) {
								player.setHero(true);
								player.isHero();
								player.broadcastUserInfo();
							}

							player.addExpAndSp(Experience.LEVEL[81], 0);
							player.rewardSkills();
							player.broadcastUserInfo();

					

							ArmorFakePlayer.giveArmorByClass(player, true);
							BufferByClass.giveBuffsByClass(player);
							HairHatByClass.giveAcessoryByClass(player);
							InvetoryItemsByClass.giveItemsInventory(player);
							JewelsByClass.giveJewelsByClass(player, true);
							WeaponsByClass.giveWeaponsByClass(player, true);

							Location localLocation = PhantomStore.getRandomLoc();
							player.setXYZInvisible(localLocation.getX(), localLocation.getY(), localLocation.getZ());
							player.spawnMe(localLocation.getX(), localLocation.getY(), localLocation.getZ());
							player.setLastCords(player.getX(), player.getY(), player.getZ());
							if (Config.PLAYER_SPAWN_PROTECTION > 0) {
								player.setSpawnProtection(true);
							}
							player.broadcastUserInfo();

							if (Rnd.get(100) < 15) {
								PhantomStore.startWalk(player);
							} else if (Rnd.get(100) < Config.PHANTOM_PLAYERS_WALK) {
								PhantomStore.startWalk(player);
							}

							if (Rnd.nextInt(45) == 0)
								PhantomPlayerUtils.maybeAnnounce(player);

							PhantomStore._players.add(player);

							if (player.isDead()) {
								player.doRevive();

							}
					
							player.setRunning();

							if (Rnd.get(100) < Config.PHANTOM_CHANCE_MALARIA) {
								L2Skill skill = SkillTable.getInstance().getInfo(4554, 4);
								skill.getEffects(player, player);
							}
			
							PhantomStore._PhantomsTown.get(Integer.valueOf(1)).add(player);
							PhantomStore._players.add(player);

							i++;
						} catch (Exception e) {
							PhantomStore._log.log(Level.WARNING, "FakePlayers: " + player, e);
							if (player != null) {
								player.deleteMe();
							}
						}
						ThreadPool.schedule(new PhantomStore.Disconnection(player), Config.DISCONNETC_DELAY);

					}
					rs.close();
					stm.close();
				} catch (Exception e) {
					PhantomStore._log.log(Level.WARNING, "FakePlayerss: ", e);
				}
				PhantomStore._log.info("Phantom Store: Foi Gerado " + i + " Phantom Store.");
				break;
			}
		}
	}

	public class Disconnection implements Runnable {
		private final Player _activeChar;

		public Disconnection(Player activeChar) {
			_activeChar = activeChar;
		}

		@Override
		public void run() {
			if (_activeChar.isOnline()) {
				PhantomStore.removePlayers(_activeChar);
				final GameClient client = _activeChar.getClient();
				// detach the client from the char so that the connection isnt closed in the
				// deleteMe
				_activeChar.setClient(null);
				// removing player from the world
				_activeChar.deleteMe();
				client.setPlayer(null);
				client.setState(GameClientState.AUTHED);
			}
		}

	}

	@SuppressWarnings("resource")
	private static void parceTownLocs() {
		_PhantomsTownLoc.clear();
		LineNumberReader localLineNumberReader = null;
		BufferedReader localBufferedReader = null;
		FileReader localFileReader = null;
		try {
			File localFile = new File("./config/aCis/Store/store_locs.ini");
			if (!localFile.exists()) {
				return;
			}
			localFileReader = new FileReader(localFile);
			localBufferedReader = new BufferedReader(localFileReader);
			localLineNumberReader = new LineNumberReader(localBufferedReader);
			String str;
			while ((str = localLineNumberReader.readLine()) != null) {
				if ((str.trim().length() != 0) && (!str.startsWith("#"))) {
					String[] arrayOfString = str.split(",");
					_PhantomsTownLoc.add(new Location(Integer.parseInt(arrayOfString[0]),
							Integer.parseInt(arrayOfString[1]), Integer.parseInt(arrayOfString[2])));
				}
			}
			_locsCount = _PhantomsTownLoc.size() - 1;
			_log.info("Load " + _locsCount + " phantom Store Locations");
			return;
		} catch (Exception localException2) {
			localException2.printStackTrace();
		} finally {
			try {
				if (localFileReader != null) {
					localFileReader.close();
				}
				if (localBufferedReader != null) {
					localBufferedReader.close();
				}
				if (localLineNumberReader != null) {
					localLineNumberReader.close();
				}
			} catch (Exception localException5) {
			}
		}
	}

	static final List<String> list_msg_buy = new ArrayList<>();
	static final List<String> list_msg_sell = new ArrayList<>();

	@SuppressWarnings("null")
	static String getPrivateBuy_Title() {
		String msg = null;
		if (msg == null) {
			msg = Config.PHANTOM_PRIVATE_BUY_TITLE.get(Rnd.get(Config.PHANTOM_PRIVATE_BUY_TITLE.size()));
		}
		if (list_msg_buy.contains(msg)) {
			boolean gerar = true;
			while (gerar) {
				msg = Config.PHANTOM_PRIVATE_BUY_TITLE.get(Rnd.get(Config.PHANTOM_PRIVATE_BUY_TITLE.size()));
				if (!list_msg_buy.contains(msg)) {
					list_msg_buy.add(msg);
					gerar = false;
					return msg;
				}
				if (list_msg_buy.size() == Config.PHANTOM_PRIVATE_BUY_TITLE.size()) {
					gerar = false;
					return "";
				}
			}
		} else if (!list_msg_buy.contains(msg)) {
			list_msg_buy.add(msg);
			return msg;
		}
		return msg;
	}

	@SuppressWarnings("null")
	static String getPrivateSell_Title() {
		String msg = null;
		if (msg == null) {
			msg = Config.PHANTOM_PRIVATE_SELL_TITLE.get(Rnd.get(Config.PHANTOM_PRIVATE_SELL_TITLE.size()));
		}
		if (list_msg_sell.contains(msg)) {
			boolean gerar = true;
			while ((list_msg_sell.size() < Config.PHANTOM_PRIVATE_SELL_TITLE.size()) && (gerar)) {
				msg = Config.PHANTOM_PRIVATE_SELL_TITLE.get(Rnd.get(Config.PHANTOM_PRIVATE_SELL_TITLE.size()));
				if (!list_msg_sell.contains(msg)) {
					list_msg_sell.add(msg);
					gerar = false;
					return msg;
				}
				if (list_msg_sell.size() == Config.PHANTOM_PRIVATE_SELL_TITLE.size()) {
					gerar = false;
					return "";
				}
			}
		} else if (!list_msg_sell.contains(msg)) {
			list_msg_sell.add(msg);
			return msg;
		}
		return msg;
	}

	static String getNameColor() {
		return Config.PHANTOM_PLAYERS_NAME_CLOLORS.get(Rnd.get(Config.PHANTOM_PLAYERS_NAME_CLOLORS.size()));
	}

	static String getTitleColor() {
		return Config.PHANTOM_PLAYERS_TITLE_CLOLORS.get(Rnd.get(Config.PHANTOM_PLAYERS_TITLE_CLOLORS.size()));
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

		return classes;
	}

	public static Appearance getRandomAppearance(Class<? extends PlayerTemplate> class1) {

		Sex randomSex = Rnd.get(1, 2) == 1 ? Sex.MALE : Sex.FEMALE;
		int hairStyle = Rnd.get(0, randomSex == Sex.MALE ? 2 : 6);
		int hairColor = Rnd.get(0, 3);
		int faceId = Rnd.get(0, 2);

		return new Appearance((byte) faceId, (byte) hairColor, (byte) hairStyle, randomSex);
	}

	public static int getRandomClan()
	{
		return FakePlayerConfig.LIST_CLAN_ID.get(Rnd.get(FakePlayerConfig.LIST_CLAN_ID.size())).intValue();
	}

}
