package dev.l2j.tesla;

import dev.l2j.tesla.commons.config.ExProperties;
import dev.l2j.tesla.commons.logging.CLogger;
import dev.l2j.tesla.commons.math.MathUtil;
import dev.l2j.tesla.gameserver.model.holder.IntIntHolder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * This class contains global server configuration.<br>
 * It has static final fields initialized from configuration files.
 */
public final class Config
{
	private static final CLogger LOGGER = new CLogger(Config.class.getName());

	public static final String CLANS_FILE = "./config/clans.properties";
	public static final String EVENTS_FILE = "./config/events.properties";
	public static final String GEOENGINE_FILE = "./config/geoengine.properties";
	public static final String HEXID_FILE = "./config/hexid.txt";
	public static final String LOGIN_CONFIGURATION_FILE = "./config/loginserver.properties";
	public static final String NPCS_FILE = "./config/npcs.properties";
	public static final String PLAYERS_FILE = "./config/players.properties";
	public static final String SERVER_FILE = "./config/server.properties";
	public static final String SIEGE_FILE = "./config/siege.properties";
	public static final String OFFLINEMOD = "./config/CustomMods/OfflineShop.properties";
	public static final String FAKEPLAYER_FILE = "./config/aCis/FakePlayer.properties";
	public static final String FAKE_ARMOR = "./config/aCis/ArmorFakePvP.properties";
	public static final String FAKE_WEAPON = "./config/aCis/WeaponFakePvP.properties";
	public static final String NEWBIECHAR = "./config/CustomMods/NewbieCharacters.properties";

	// Anouncer PvP
	public static boolean ANNOUNCE_KILL;
	public static String ANNOUNCE_PVP_MSG;
	public static String ANNOUNCE_PK_MSG;
	public static boolean ALT_GAME_VIEWNPC;
	// --------------------------------------------------
	// Clans settings
	// --------------------------------------------------

	/** Clans */
	public static int ALT_CLAN_JOIN_DAYS;
	public static int ALT_CLAN_CREATE_DAYS;
	public static int ALT_CLAN_DISSOLVE_DAYS;
	public static int ALT_ALLY_JOIN_DAYS_WHEN_LEAVED;
	public static int ALT_ALLY_JOIN_DAYS_WHEN_DISMISSED;
	public static int ALT_ACCEPT_CLAN_DAYS_WHEN_DISMISSED;
	public static int ALT_CREATE_ALLY_DAYS_WHEN_DISSOLVED;
	public static int ALT_MAX_NUM_OF_CLANS_IN_ALLY;
	public static int ALT_CLAN_MEMBERS_FOR_WAR;
	public static int ALT_CLAN_WAR_PENALTY_WHEN_ENDED;
	public static boolean ALT_MEMBERS_CAN_WITHDRAW_FROM_CLANWH;

	/** Manor */
	public static int ALT_MANOR_REFRESH_TIME;
	public static int ALT_MANOR_REFRESH_MIN;
	public static int ALT_MANOR_APPROVE_TIME;
	public static int ALT_MANOR_APPROVE_MIN;
	public static int ALT_MANOR_MAINTENANCE_MIN;
	public static int ALT_MANOR_SAVE_PERIOD_RATE;

	/** Clan Hall function */
	public static long CH_TELE_FEE_RATIO;
	public static int CH_TELE1_FEE;
	public static int CH_TELE2_FEE;
	public static long CH_ITEM_FEE_RATIO;
	public static int CH_ITEM1_FEE;
	public static int CH_ITEM2_FEE;
	public static int CH_ITEM3_FEE;
	public static long CH_MPREG_FEE_RATIO;
	public static int CH_MPREG1_FEE;
	public static int CH_MPREG2_FEE;
	public static int CH_MPREG3_FEE;
	public static int CH_MPREG4_FEE;
	public static int CH_MPREG5_FEE;
	public static long CH_HPREG_FEE_RATIO;
	public static int CH_HPREG1_FEE;
	public static int CH_HPREG2_FEE;
	public static int CH_HPREG3_FEE;
	public static int CH_HPREG4_FEE;
	public static int CH_HPREG5_FEE;
	public static int CH_HPREG6_FEE;
	public static int CH_HPREG7_FEE;
	public static int CH_HPREG8_FEE;
	public static int CH_HPREG9_FEE;
	public static int CH_HPREG10_FEE;
	public static int CH_HPREG11_FEE;
	public static int CH_HPREG12_FEE;
	public static int CH_HPREG13_FEE;
	public static long CH_EXPREG_FEE_RATIO;
	public static int CH_EXPREG1_FEE;
	public static int CH_EXPREG2_FEE;
	public static int CH_EXPREG3_FEE;
	public static int CH_EXPREG4_FEE;
	public static int CH_EXPREG5_FEE;
	public static int CH_EXPREG6_FEE;
	public static int CH_EXPREG7_FEE;
	public static long CH_SUPPORT_FEE_RATIO;
	public static int CH_SUPPORT1_FEE;
	public static int CH_SUPPORT2_FEE;
	public static int CH_SUPPORT3_FEE;
	public static int CH_SUPPORT4_FEE;
	public static int CH_SUPPORT5_FEE;
	public static int CH_SUPPORT6_FEE;
	public static int CH_SUPPORT7_FEE;
	public static int CH_SUPPORT8_FEE;
	public static long CH_CURTAIN_FEE_RATIO;
	public static int CH_CURTAIN1_FEE;
	public static int CH_CURTAIN2_FEE;
	public static long CH_FRONT_FEE_RATIO;
	public static int CH_FRONT1_FEE;
	public static int CH_FRONT2_FEE;

	// --------------------------------------------------
	// Events settings
	// --------------------------------------------------

	/** Olympiad */
	public static int ALT_OLY_START_TIME;
	public static int ALT_OLY_MIN;
	public static long ALT_OLY_CPERIOD;
	public static long ALT_OLY_BATTLE;
	public static long ALT_OLY_WPERIOD;
	public static long ALT_OLY_VPERIOD;
	public static int ALT_OLY_WAIT_TIME;
	public static int ALT_OLY_WAIT_BATTLE;
	public static int ALT_OLY_WAIT_END;
	public static int ALT_OLY_START_POINTS;
	public static int ALT_OLY_WEEKLY_POINTS;
	public static int ALT_OLY_MIN_MATCHES;
	public static int ALT_OLY_CLASSED;
	public static int ALT_OLY_NONCLASSED;
	public static IntIntHolder[] ALT_OLY_CLASSED_REWARD;
	public static IntIntHolder[] ALT_OLY_NONCLASSED_REWARD;
	public static int ALT_OLY_GP_PER_POINT;
	public static int ALT_OLY_HERO_POINTS;
	public static int ALT_OLY_RANK1_POINTS;
	public static int ALT_OLY_RANK2_POINTS;
	public static int ALT_OLY_RANK3_POINTS;
	public static int ALT_OLY_RANK4_POINTS;
	public static int ALT_OLY_RANK5_POINTS;
	public static int ALT_OLY_MAX_POINTS;
	public static int ALT_OLY_DIVIDER_CLASSED;
	public static int ALT_OLY_DIVIDER_NON_CLASSED;
	public static boolean ALT_OLY_ANNOUNCE_GAMES;

	/** SevenSigns Festival */
	public static boolean ALT_GAME_CASTLE_DAWN;
	public static boolean ALT_GAME_CASTLE_DUSK;
	public static int ALT_FESTIVAL_MIN_PLAYER;
	public static int ALT_MAXIMUM_PLAYER_CONTRIB;
	public static long ALT_FESTIVAL_MANAGER_START;
	public static long ALT_FESTIVAL_LENGTH;
	public static long ALT_FESTIVAL_CYCLE_LENGTH;
	public static long ALT_FESTIVAL_FIRST_SPAWN;
	public static long ALT_FESTIVAL_FIRST_SWARM;
	public static long ALT_FESTIVAL_SECOND_SPAWN;
	public static long ALT_FESTIVAL_SECOND_SWARM;
	public static long ALT_FESTIVAL_CHEST_SPAWN;

	/** Four Sepulchers */
	public static int FS_TIME_ENTRY;
	public static int FS_TIME_END;
	public static int FS_PARTY_MEMBER_COUNT;

	/** dimensional rift */
	public static int RIFT_MIN_PARTY_SIZE;
	public static int RIFT_SPAWN_DELAY;
	public static int RIFT_MAX_JUMPS;
	public static int RIFT_AUTO_JUMPS_TIME_MIN;
	public static int RIFT_AUTO_JUMPS_TIME_MAX;
	public static int RIFT_ENTER_COST_RECRUIT;
	public static int RIFT_ENTER_COST_SOLDIER;
	public static int RIFT_ENTER_COST_OFFICER;
	public static int RIFT_ENTER_COST_CAPTAIN;
	public static int RIFT_ENTER_COST_COMMANDER;
	public static int RIFT_ENTER_COST_HERO;
	public static double RIFT_BOSS_ROOM_TIME_MUTIPLY;

	/** Wedding system */
	public static boolean ALLOW_WEDDING;
	public static int WEDDING_PRICE;
	public static boolean WEDDING_SAMESEX;
	public static boolean WEDDING_FORMALWEAR;

	/** Lottery */
	public static int ALT_LOTTERY_PRIZE;
	public static int ALT_LOTTERY_TICKET_PRICE;
	public static double ALT_LOTTERY_5_NUMBER_RATE;
	public static double ALT_LOTTERY_4_NUMBER_RATE;
	public static double ALT_LOTTERY_3_NUMBER_RATE;
	public static int ALT_LOTTERY_2_AND_1_NUMBER_PRIZE;

	/** Fishing tournament */
	public static boolean ALT_FISH_CHAMPIONSHIP_ENABLED;
	public static int ALT_FISH_CHAMPIONSHIP_REWARD_ITEM;
	public static int ALT_FISH_CHAMPIONSHIP_REWARD_1;
	public static int ALT_FISH_CHAMPIONSHIP_REWARD_2;
	public static int ALT_FISH_CHAMPIONSHIP_REWARD_3;
	public static int ALT_FISH_CHAMPIONSHIP_REWARD_4;
	public static int ALT_FISH_CHAMPIONSHIP_REWARD_5;

	// --------------------------------------------------
	// GeoEngine
	// --------------------------------------------------

	/** Geodata */
	public static String GEODATA_PATH;

	/** Path checking */
	public static int PART_OF_CHARACTER_HEIGHT;
	public static int MAX_OBSTACLE_HEIGHT;

	/** Path finding */
	public static String PATHFIND_BUFFERS;
	public static int BASE_WEIGHT;
	public static int DIAGONAL_WEIGHT;
	public static int HEURISTIC_WEIGHT;
	public static int OBSTACLE_MULTIPLIER;
	public static int MAX_ITERATIONS;
	public static boolean DEBUG_PATH;
	public static boolean DEBUG_GEO_NODE;

	// --------------------------------------------------
	// HexID
	// --------------------------------------------------

	public static int SERVER_ID;
	public static byte[] HEX_ID;

	// --------------------------------------------------
	// Loginserver
	// --------------------------------------------------

	public static String LOGIN_BIND_ADDRESS;
	public static int PORT_LOGIN;

	public static int LOGIN_TRY_BEFORE_BAN;
	public static int LOGIN_BLOCK_AFTER_BAN;
	public static boolean ACCEPT_NEW_GAMESERVER;

	public static boolean SHOW_LICENCE;

	public static boolean AUTO_CREATE_ACCOUNTS;

	public static boolean LOG_LOGIN_CONTROLLER;

	public static boolean FLOOD_PROTECTION;
	public static int FAST_CONNECTION_LIMIT;
	public static int NORMAL_CONNECTION_TIME;
	public static int FAST_CONNECTION_TIME;
	public static int MAX_CONNECTION_PER_IP;
	public static String PASSWORD_HASH_METHOD;

	// --------------------------------------------------
	// NPCs / Monsters
	// --------------------------------------------------

	/** Champion Mod */
	public static int CHAMPION_FREQUENCY;
	public static int CHAMP_MIN_LVL;
	public static int CHAMP_MAX_LVL;
	public static int CHAMPION_HP;
	public static int CHAMPION_REWARDS;
	public static int CHAMPION_ADENAS_REWARDS;
	public static double CHAMPION_HP_REGEN;
	public static double CHAMPION_ATK;
	public static double CHAMPION_SPD_ATK;
	public static int CHAMPION_REWARD;
	public static int CHAMPION_REWARD_ID;
	public static int CHAMPION_REWARD_QTY;

	/** Buffer */
	public static int BUFFER_MAX_SCHEMES;
	public static int BUFFER_STATIC_BUFF_COST;

	/** Misc */
	public static boolean ALLOW_CLASS_MASTERS;
	public static ClassMasterSettings CLASS_MASTER_SETTINGS;
	public static boolean ALLOW_ENTIRE_TREE;
	public static boolean ANNOUNCE_MAMMON_SPAWN;
	public static boolean ALT_MOB_AGRO_IN_PEACEZONE;
	public static boolean SHOW_NPC_LVL;
	public static boolean SHOW_NPC_CREST;
	public static boolean SHOW_SUMMON_CREST;

	/** Wyvern Manager */
	public static boolean WYVERN_ALLOW_UPGRADER;
	public static int WYVERN_REQUIRED_LEVEL;
	public static int WYVERN_REQUIRED_CRYSTALS;

	/** Raid Boss */
	public static double RAID_HP_REGEN_MULTIPLIER;
	public static double RAID_MP_REGEN_MULTIPLIER;
	public static double RAID_DEFENCE_MULTIPLIER;
	public static int RAID_MINION_RESPAWN_TIMER;

	public static boolean RAID_DISABLE_CURSE;

	/** Grand Boss */
	public static int SPAWN_INTERVAL_AQ;
	public static int RANDOM_SPAWN_TIME_AQ;

	public static int SPAWN_INTERVAL_ANTHARAS;
	public static int RANDOM_SPAWN_TIME_ANTHARAS;
	public static int WAIT_TIME_ANTHARAS;

	public static int SPAWN_INTERVAL_BAIUM;
	public static int RANDOM_SPAWN_TIME_BAIUM;

	public static int SPAWN_INTERVAL_CORE;
	public static int RANDOM_SPAWN_TIME_CORE;

	public static int SPAWN_INTERVAL_FRINTEZZA;
	public static int RANDOM_SPAWN_TIME_FRINTEZZA;
	public static int WAIT_TIME_FRINTEZZA;

	public static int SPAWN_INTERVAL_ORFEN;
	public static int RANDOM_SPAWN_TIME_ORFEN;

	public static int SPAWN_INTERVAL_SAILREN;
	public static int RANDOM_SPAWN_TIME_SAILREN;
	public static int WAIT_TIME_SAILREN;

	public static int SPAWN_INTERVAL_VALAKAS;
	public static int RANDOM_SPAWN_TIME_VALAKAS;
	public static int WAIT_TIME_VALAKAS;

	public static int SPAWN_INTERVAL_ZAKEN;
	public static int RANDOM_SPAWN_TIME_ZAKEN;

	/** AI */
	public static boolean GUARD_ATTACK_AGGRO_MOB;
	public static int MAX_DRIFT_RANGE;
	public static int MIN_NPC_ANIMATION;
	public static int MAX_NPC_ANIMATION;
	public static int MIN_MONSTER_ANIMATION;
	public static int MAX_MONSTER_ANIMATION;

	// --------------------------------------------------
	// Players
	// --------------------------------------------------

	/** Misc */
	public static boolean EFFECT_CANCELING;
	public static double HP_REGEN_MULTIPLIER;
	public static double MP_REGEN_MULTIPLIER;
	public static double CP_REGEN_MULTIPLIER;
	public static int PLAYER_SPAWN_PROTECTION;
	public static int PLAYER_FAKEDEATH_UP_PROTECTION;
	public static double RESPAWN_RESTORE_HP;
	public static int MAX_PVTSTORE_SLOTS_DWARF;
	public static int MAX_PVTSTORE_SLOTS_OTHER;
	public static boolean DEEPBLUE_DROP_RULES;
	public static boolean ALT_GAME_DELEVEL;
	public static int DEATH_PENALTY_CHANCE;

	/** Inventory & WH */
	public static int INVENTORY_MAXIMUM_NO_DWARF;
	public static int INVENTORY_MAXIMUM_DWARF;
	public static int INVENTORY_MAXIMUM_QUEST_ITEMS;
	public static int INVENTORY_MAXIMUM_PET;
	public static int MAX_ITEM_IN_PACKET;
	public static double ALT_WEIGHT_LIMIT;
	public static int WAREHOUSE_SLOTS_NO_DWARF;
	public static int WAREHOUSE_SLOTS_DWARF;
	public static int WAREHOUSE_SLOTS_CLAN;
	public static int FREIGHT_SLOTS;
	public static boolean ALT_GAME_FREIGHTS;
	public static int ALT_GAME_FREIGHT_PRICE;

	/** Enchant */
	public static double ENCHANT_CHANCE_WEAPON_MAGIC;
	public static double ENCHANT_CHANCE_WEAPON_MAGIC_15PLUS;
	public static double ENCHANT_CHANCE_WEAPON_NONMAGIC;
	public static double ENCHANT_CHANCE_WEAPON_NONMAGIC_15PLUS;
	public static double ENCHANT_CHANCE_ARMOR;
	public static int ENCHANT_MAX_WEAPON;
	public static int ENCHANT_MAX_ARMOR;
	public static int ENCHANT_SAFE_MAX;
	public static int ENCHANT_SAFE_MAX_FULL;


	/** phantom town */
	// private store fake
	public static boolean PHANTOM_PRIVATE_STORE;
	public static String PHANTOM_PRIVATE_BUY_TITLE_MSG;
	public static List<String> PHANTOM_PRIVATE_BUY_TITLE = new ArrayList<>();
	public static int PHANTOM_PRIVATE_BUY_CHANCE;
	public static String PHANTOM_PRIVATE_BUY;
	public static List<Integer> LIST_PRIVATE_BUY;
	public static String PHANTOM_PRIVATE_SELL_TITLE_MSG;
	public static List<String> PHANTOM_PRIVATE_SELL_TITLE = new ArrayList<>();
	public static int PHANTOM_PRIVATE_SELL_CHANCE;
	public static String PHANTOM_PRIVATE_SELL;
	public static List<Integer> LIST_PRIVATE_SELL;
	public static boolean PHANTOM_PLAYERS_SOULSHOT_ANIM;
	public static int PHANTOM_CHANCE_SIT;
	public static int PHANTOM_PLAYERS_WALK;
	public static boolean ALLOW_PHANTOM_PLAYERS = true;
	public static boolean ALLOW_PHANTOM_PVP = true;
	public static boolean ALLOW_PHANTOM_STORE = false;
	public static int PHANTOM_CHANCE_MALARIA;
	public static String PHANTOM_PLAYERS_ACC_1;
	public static String PHANTOM_PLAYERS_ACC_2;
	public static int PHANTOM_DELAY_SPAWN_FIRST;
	public static long DISCONNETC_DELAY;
	public static boolean PHANTOM_PLAYERS_ARGUMENT_ANIM;
	public static int PHANTOM_PLAYERS_ENCHANT_MIN;
	public static int PHANTOM_PLAYERS_ENCHANT_MAX;

	public static boolean ALLOW_PHANTOM_FACE;
	public static String PHANTOM_FACE;
	public static List<Integer> LIST_PHANTOM_FACE;
	public static boolean ALLOW_PHANTOM_HAIR;
	public static String PHANTOM_HAIR;
	public static List<Integer> LIST_PHANTOM_HAIR;

	public static int PHANTOM_CHANCE_HERO;
	public static String NAME_COLOR;
	public static String TITLE_COLOR;
	public static String PHANTOM_NAME_CLOLORS;
	public static String PHANTOM_TITLE_CLOLORS;
	public static ArrayList<String> PHANTOM_PLAYERS_NAME_CLOLORS;
	public static ArrayList<String> PHANTOM_PLAYERS_TITLE_CLOLORS;

    public static int CLANID;
    public static int CLANIDWALKER;

	/** FAKE PLAYERS Buffer L2jBan**/
	public static String FIGHTER_BUFF;
	public static ArrayList<Integer> FIGHTER_BUFF_LIST;
	public static String MAGE_BUFF;
	public static ArrayList<Integer> MAGE_BUFF_LIST;
	public static boolean ENABLE_GIRAN_TO;
	public static int[] TELE_TO_GIRAN = new int[3];
	public static boolean ENABLE_GODARD_TO;
	public static int[] TELE_TO_GODDARD = new int[3];
	public static boolean ENABLE_ADEN_TO;
	public static int[] TELE_TO_ADEN = new int[3];
	public static boolean ENABLE_GLUDIN_TO;
	public static int[] TELE_TO_GLUDIN = new int[3];
	public static boolean ENABLE_DION_TO;
	public static int[] TELE_TO_DION = new int[3];
	public static boolean ENABLE_SPAWN_TO_50_PLAYER;
	public static int[] TELE_TO_SPWAN50 = new int[3];


	public static boolean CHAR_TITLE;
	public static String ADD_CHAR_TITLE;
	public static boolean STARTING_BUFFS;
	public static List<int[]> STARTING_BUFFS_M = new ArrayList<>();
	public static List<int[]> STARTING_BUFFS_F = new ArrayList<>();
	public static boolean CUSTOM_STARTER_ITEMS_ENABLED;
	public static List<int[]> STARTING_CUSTOM_ITEMS_F = new ArrayList<>();
	public static List<int[]> STARTING_CUSTOM_ITEMS_M = new ArrayList<>();
	public static boolean ALLOW_CREATE_LVL;
	public static int CHAR_CREATE_LVL;
	public static boolean SPAWN_CHAR;
	/** X Coordinate of the SPAWN_CHAR setting. */
	public static int SPAWN_X;
	/** Y Coordinate of the SPAWN_CHAR setting. */
	public static int SPAWN_Y;
	/** Z Coordinate of the SPAWN_CHAR setting. */
	public static int SPAWN_Z;

	public static boolean CONTROLL_FAKE_ON = true;
	public static boolean FAKE_PLAYER_CAN_TARGET_REAL_PLAYER = true;

	public static int FAKE_SPAWN_RANDOM_OFFSET;

	/** Min Max Enchant Fake player L2jBan */
	public static int MIN_ENCHANT_FAKE_ARMOR;
	public static int MAX_ENCHANT_FAKE_ARMOR;
	public static int MIN_ENCHANT_FAKE_WEAPON;
	public static int MAX_ENCHANT_FAKE_WEAPON;
	public static  boolean FAKE_PLAYER_RETURNS_TO_FARM;
	public static  int[] SPAWN_FAKE_LOC2;
	public static int[] SPAWN_FAKE_LOC1;
	/** FAKE Armor L2jBan**/
	public static String FAKE_ARMOR_MYSTIC_MUSE;
	public static List<Integer> ARMOR_MYSTIC_MUSE = new ArrayList<>();
	public static String FAKE_ARMOR_HIEROPHANT;
	public static List<Integer> ARMOR_HIEROPHANT = new ArrayList<>();
	public static String FAKE_ARMOR_ARCANA_LORD;
	public static List<Integer> ARMOR_ARCANA_LORD = new ArrayList<>();
	public static String FAKE_ARMOR_CARDINAL;
	public static List<Integer> ARMOR_CARDINAL = new ArrayList<>();
	public static String FAKE_ARMOR_ELEMENTAL_MASTER;
	public static List<Integer> ARMOR_ELEMENTAL_MASTER = new ArrayList<>();
	public static String FAKE_ARMOR_DOOMCRYER;
	public static List<Integer> ARMOR_DOOMCRYER = new ArrayList<>();
	public static String FAKE_ARMOR_DOMINATOR;
	public static List<Integer> ARMOR_DOMINATOR = new ArrayList<>();
	public static String FAKE_ARMOR_GHOST_SENTINEL;
	public static List<Integer> ARMOR_GHOST_SENTINEL = new ArrayList<>();
	public static String FAKE_ARMOR_ADVENTURER;
	public static List<Integer> ARMOR_ADVENTURER = new ArrayList<>();
	public static String FAKE_ARMOR_SOULTAKER;
	public static List<Integer> ARMOR_SOULTAKER = new ArrayList<>();
	public static String FAKE_ARMOR_ARCHMAGE;
	public static List<Integer> ARMOR_ARCHMAGE = new ArrayList<>();
	public static String FAKE_ARMOR_DUELIST;
	public static List<Integer> ARMOR_DUELIST = new ArrayList<>();
	public static String FAKE_ARMOR_MAESTRO;
	public static List<Integer> ARMOR_MAESTRO = new ArrayList<>();
	public static String FAKE_ARMOR_HELL_KNIGHT;
	public static List<Integer> ARMOR_HELL_KNIGHT = new ArrayList<>();
	public static String FAKE_ARMOR_TITAN;
	public static List<Integer> ARMOR_TITAN = new ArrayList<>();
	public static String FAKE_ARMOR_SAGGITARIUS;
	public static List<Integer> ARMOR_SAGGITARIUS = new ArrayList<>();
	public static String FAKE_ARMOR_WIND_RIDER;
	public static List<Integer> ARMOR_WIND_RIDER = new ArrayList<>();
	public static String FAKE_ARMOR_GRAND_KHAVATARI;
	public static List<Integer> ARMOR_GRAND_KHAVATARI = new ArrayList<>();
	public static String FAKE_ARMOR_STORM_SCREAMER;
	public static List<Integer> ARMOR_STORM_SCREAMER = new ArrayList<>();
	public static String FAKE_ARMOR_EVAS_SAINT;
	public static List<Integer> ARMOR_EVAS_SAINT = new ArrayList<>();
	public static String FAKE_ARMOR_SPECTRAL_MASTER;
	public static List<Integer> ARMOR_SPECTRAL_MASTER = new ArrayList<>();
	public static String FAKE_ARMOR_SHILLIEN_SAINT;
	public static List<Integer> ARMOR_SHILLIEN_SAINT = new ArrayList<>();
	public static String FAKE_ARMOR_DREADNOUGHT;
	public static List<Integer> ARMOR_DREADNOUGHT = new ArrayList<>();
	public static String FAKE_ARMOR_PHOENIX_KNIGHT;
	public static List<Integer> ARMOR_PHOENIX_KNIGHT = new ArrayList<>();
	public static String FAKE_ARMOR_SWORD_MUSE;
	public static List<Integer> ARMOR_SWORD_MUSE = new ArrayList<>();
	public static String FAKE_ARMOR_SPECTRAL_DANCER;
	public static List<Integer> ARMOR_SPECTRAL_DANCER = new ArrayList<>();
	public static String FAKE_ARMOR_EVAS_TEMPLAR;
	public static List<Integer> ARMOR_EVAS_TEMPLAR = new ArrayList<>();
	public static String FAKE_ARMOR_SHILLIEN_TEMPLAR;
	public static List<Integer> ARMOR_SHILLIEN_TEMPLAR = new ArrayList<>();
	public static String FAKE_ARMOR_MOONLIGHT;
	public static List<Integer> ARMOR_MOONLIGHT = new ArrayList<>();
	public static String FAKE_ARMOR_GHOST_HUNTER;
	public static List<Integer> ARMOR_GHOST_HUNTER = new ArrayList<>();
	public static String FAKE_ARMOR_FORTUNE;
	public static List<Integer> ARMOR_FORTUNE = new ArrayList<>();
	/** FINAL ARMOR FAKE PLAYER BAN JUVENIL AMARO-TM **/

	/** FAKE WEAPON e Weapons L2jBan **/
	public static String FAKE_WEAPON_MYSTIC_MUSE;
	public static List<Integer> WEAPON_MYSTIC_MUSE = new ArrayList<>();
	public static String FAKE_WEAPON_HIEROPHANT;
	public static List<Integer> WEAPON_HIEROPHANT = new ArrayList<>();
	public static String FAKE_WEAPON_ARCANA_LORD;
	public static List<Integer> WEAPON_ARCANA_LORD = new ArrayList<>();
	public static String FAKE_WEAPON_CARDINAL;
	public static List<Integer> WEAPON_CARDINAL = new ArrayList<>();
	public static String FAKE_WEAPON_ELEMENTAL_MASTER;
	public static List<Integer> WEAPON_ELEMENTAL_MASTER = new ArrayList<>();
	public static String FAKE_WEAPON_DOOMCRYER;
	public static List<Integer> WEAPON_DOOMCRYER = new ArrayList<>();
	public static String FAKE_WEAPON_DOMINATOR;
	public static List<Integer> WEAPON_DOMINATOR = new ArrayList<>();
	public static String FAKE_WEAPON_GHOST_SENTINEL;
	public static List<Integer> WEAPON_GHOST_SENTINEL = new ArrayList<>();
	public static String FAKE_WEAPON_ADVENTURER;
	public static List<Integer> WEAPON_ADVENTURER = new ArrayList<>();
	public static String FAKE_WEAPON_SOULTAKER;
	public static List<Integer> WEAPON_SOULTAKER = new ArrayList<>();
	public static String FAKE_WEAPON_ARCHMAGE;
	public static List<Integer> WEAPON_ARCHMAGE = new ArrayList<>();
	public static String FAKE_WEAPON_DUELIST;
	public static List<Integer> WEAPON_DUELIST = new ArrayList<>();
	public static String FAKE_WEAPON_MAESTRO;
	public static List<Integer> WEAPON_MAESTRO = new ArrayList<>();
	public static String FAKE_WEAPON_HELL_KNIGHT;
	public static List<Integer> WEAPON_HELL_KNIGHT = new ArrayList<>();
	public static String FAKE_WEAPON_TITAN;
	public static List<Integer> WEAPON_TITAN = new ArrayList<>();
	public static String FAKE_WEAPON_SAGGITARIUS;
	public static List<Integer> WEAPON_SAGGITARIUS = new ArrayList<>();
	public static String FAKE_WEAPON_WIND_RIDER;
	public static List<Integer> WEAPON_WIND_RIDER = new ArrayList<>();
	public static String FAKE_WEAPON_GRAND_KHAVATARI;
	public static List<Integer> WEAPON_GRAND_KHAVATARI = new ArrayList<>();
	public static String FAKE_WEAPON_STORM_SCREAMER;
	public static List<Integer> WEAPON_STORM_SCREAMER = new ArrayList<>();
	public static String FAKE_WEAPON_EVAS_SAINT;
	public static List<Integer> WEAPON_EVAS_SAINT = new ArrayList<>();
	public static String FAKE_WEAPON_SPECTRAL_MASTER;
	public static List<Integer> WEAPON_SPECTRAL_MASTER = new ArrayList<>();
	public static String FAKE_WEAPON_SHILLIEN_SAINT;
	public static List<Integer> WEAPON_SHILLIEN_SAINT = new ArrayList<>();
	public static String FAKE_WEAPON_DREADNOUGHT;
	public static List<Integer> WEAPON_DREADNOUGHT = new ArrayList<>();
	public static String FAKE_WEAPON_PHOENIX_KNIGHT;
	public static List<Integer> WEAPON_PHOENIX_KNIGHT = new ArrayList<>();
	public static String FAKE_WEAPON_SWORD_MUSE;
	public static List<Integer> WEAPON_SWORD_MUSE = new ArrayList<>();
	public static String FAKE_WEAPON_SPECTRAL_DANCER;
	public static List<Integer> WEAPON_SPECTRAL_DANCER = new ArrayList<>();
	public static String FAKE_WEAPON_EVAS_TEMPLAR;
	public static List<Integer> WEAPON_EVAS_TEMPLAR = new ArrayList<>();
	public static String FAKE_WEAPON_SHILLIEN_TEMPLAR;
	public static List<Integer> WEAPON_SHILLIEN_TEMPLAR = new ArrayList<>();
	public static String FAKE_WEAPON_MOONLIGHT_SENTINEL;
	public static List<Integer> WEAPON_MOONLIGHT_SENTINEL = new ArrayList<>();
	public static String FAKE_WEAPON_GHOST_HUNTER;
	public static List<Integer> WEAPON_GHOST_HUNTER = new ArrayList<>();
	public static String FAKE_WEAPON_FORTUNE_SEEKER;
	public static List<Integer> WEAPON_FORTUNE_SEEKER = new ArrayList<>();
	/** FINAL WEAPON WEAPONS FAKE PLAYER BAN JUVENIL AMARO-TM **/


	/** Offline Shop */
	public static boolean OFFLINE_TRADE_ENABLE;
	public static boolean OFFLINE_CRAFT_ENABLE;
	public static boolean OFFLINE_MODE_IN_PEACE_ZONE;
	public static boolean OFFLINE_MODE_NO_DAMAGE;
	public static boolean RESTORE_OFFLINERS;
	public static int OFFLINE_MAX_DAYS;
	public static boolean OFFLINE_DISCONNECT_FINISHED;
	public static boolean OFFLINE_SET_SLEEP;
	/** Augmentations */
	public static int AUGMENTATION_NG_SKILL_CHANCE;
	public static int AUGMENTATION_NG_GLOW_CHANCE;
	public static int AUGMENTATION_MID_SKILL_CHANCE;
	public static int AUGMENTATION_MID_GLOW_CHANCE;
	public static int AUGMENTATION_HIGH_SKILL_CHANCE;
	public static int AUGMENTATION_HIGH_GLOW_CHANCE;
	public static int AUGMENTATION_TOP_SKILL_CHANCE;
	public static int AUGMENTATION_TOP_GLOW_CHANCE;
	public static int AUGMENTATION_BASESTAT_CHANCE;

	/** Karma & PvP */
	public static boolean KARMA_PLAYER_CAN_BE_KILLED_IN_PZ;
	public static boolean KARMA_PLAYER_CAN_SHOP;
	public static boolean KARMA_PLAYER_CAN_USE_GK;
	public static boolean KARMA_PLAYER_CAN_TELEPORT;
	public static boolean KARMA_PLAYER_CAN_TRADE;
	public static boolean KARMA_PLAYER_CAN_USE_WH;

	public static boolean KARMA_DROP_GM;
	public static boolean KARMA_AWARD_PK_KILL;
	public static int KARMA_PK_LIMIT;

	public static String KARMA_NONDROPPABLE_PET_ITEMS;
	public static String KARMA_NONDROPPABLE_ITEMS;
	public static int[] KARMA_LIST_NONDROPPABLE_PET_ITEMS;
	public static int[] KARMA_LIST_NONDROPPABLE_ITEMS;

	public static int PVP_NORMAL_TIME;
	public static int PVP_PVP_TIME;

	/** Party */
	public static String PARTY_XP_CUTOFF_METHOD;
	public static int PARTY_XP_CUTOFF_LEVEL;
	public static double PARTY_XP_CUTOFF_PERCENT;
	public static int PARTY_RANGE;

	/** GMs & Admin Stuff */
	public static int DEFAULT_ACCESS_LEVEL;
	public static boolean GM_HERO_AURA;
	public static boolean GM_STARTUP_INVULNERABLE;
	public static boolean GM_STARTUP_INVISIBLE;
	public static boolean GM_STARTUP_SILENCE;
	public static boolean GM_STARTUP_AUTO_LIST;

	/** petitions */
	public static boolean PETITIONING_ALLOWED;
	public static int MAX_PETITIONS_PER_PLAYER;
	public static int MAX_PETITIONS_PENDING;

	/** Crafting **/
	public static boolean IS_CRAFTING_ENABLED;
	public static int DWARF_RECIPE_LIMIT;
	public static int COMMON_RECIPE_LIMIT;
	public static boolean ALT_BLACKSMITH_USE_RECIPES;

	/** Skills & Classes **/
	public static boolean AUTO_LEARN_SKILLS;
	public static boolean MAGIC_FAILURES;
	public static int PERFECT_SHIELD_BLOCK_RATE;
	public static boolean LIFE_CRYSTAL_NEEDED;
	public static boolean SP_BOOK_NEEDED;
	public static boolean ES_SP_BOOK_NEEDED;
	public static boolean DIVINE_SP_BOOK_NEEDED;
	public static boolean SUBCLASS_WITHOUT_QUESTS;

	/** Buffs */
	public static boolean STORE_SKILL_COOLTIME;
	public static int MAX_BUFFS_AMOUNT;

	// --------------------------------------------------
	// Sieges
	// --------------------------------------------------

	public static int SIEGE_LENGTH;
	public static int MINIMUM_CLAN_LEVEL;
	public static int MAX_ATTACKERS_NUMBER;
	public static int MAX_DEFENDERS_NUMBER;
	public static int ATTACKERS_RESPAWN_DELAY;

	// --------------------------------------------------
	// Server
	// --------------------------------------------------

	public static String GAMESERVER_HOSTNAME;
	public static int PORT_GAME;
	public static String HOSTNAME;
	public static int GAME_SERVER_LOGIN_PORT;
	public static String GAME_SERVER_LOGIN_HOST;
	public static int REQUEST_ID;
	public static boolean ACCEPT_ALTERNATE_ID;

	/** Access to database */
	public static String DATABASE_URL;
	public static String DATABASE_LOGIN;
	public static String DATABASE_PASSWORD;
	public static int DATABASE_MAX_CONNECTIONS;

	/** serverList & Test */
	public static boolean SERVER_LIST_BRACKET;
	public static boolean SERVER_LIST_CLOCK;
	public static int SERVER_LIST_AGE;
	public static boolean SERVER_LIST_TESTSERVER;
	public static boolean SERVER_LIST_PVPSERVER;
	public static boolean SERVER_GMONLY;

	/** clients related */
	public static int DELETE_DAYS;
	public static int MAXIMUM_ONLINE_USERS;

	/** Auto-loot */
	public static boolean AUTO_LOOT;
	public static boolean AUTO_LOOT_HERBS;
	public static boolean AUTO_LOOT_RAID;

	/** Items Management */
	public static boolean ALLOW_DISCARDITEM;
	public static boolean MULTIPLE_ITEM_DROP;
	public static int HERB_AUTO_DESTROY_TIME;
	public static int ITEM_AUTO_DESTROY_TIME;
	public static int EQUIPABLE_ITEM_AUTO_DESTROY_TIME;
	public static Map<Integer, Integer> SPECIAL_ITEM_DESTROY_TIME;
	public static int PLAYER_DROPPED_ITEM_MULTIPLIER;

	/** Rate control */
	public static double RATE_XP;
	public static double RATE_SP;
	public static double RATE_PARTY_XP;
	public static double RATE_PARTY_SP;
	public static double RATE_DROP_ADENA;
	public static double RATE_DROP_ITEMS;
	public static double RATE_DROP_ITEMS_BY_RAID;
	public static double RATE_DROP_SPOIL;
	public static int RATE_DROP_MANOR;

	public static double RATE_QUEST_DROP;
	public static double RATE_QUEST_REWARD;
	public static double RATE_QUEST_REWARD_XP;
	public static double RATE_QUEST_REWARD_SP;
	public static double RATE_QUEST_REWARD_ADENA;

	public static double RATE_KARMA_EXP_LOST;
	public static double RATE_SIEGE_GUARDS_PRICE;

	public static int PLAYER_DROP_LIMIT;
	public static int PLAYER_RATE_DROP;
	public static int PLAYER_RATE_DROP_ITEM;
	public static int PLAYER_RATE_DROP_EQUIP;
	public static int PLAYER_RATE_DROP_EQUIP_WEAPON;

	public static int KARMA_DROP_LIMIT;
	public static int KARMA_RATE_DROP;
	public static int KARMA_RATE_DROP_ITEM;
	public static int KARMA_RATE_DROP_EQUIP;
	public static int KARMA_RATE_DROP_EQUIP_WEAPON;

	public static double PET_XP_RATE;
	public static int PET_FOOD_RATE;
	public static double SINEATER_XP_RATE;

	public static double RATE_DROP_COMMON_HERBS;
	public static double RATE_DROP_HP_HERBS;
	public static double RATE_DROP_MP_HERBS;
	public static double RATE_DROP_SPECIAL_HERBS;

	/** Allow types */
	public static boolean ALLOW_FREIGHT;
	public static boolean ALLOW_WAREHOUSE;
	public static boolean ALLOW_WEAR;
	public static int WEAR_DELAY;
	public static int WEAR_PRICE;
	public static boolean ALLOW_LOTTERY;
	public static boolean ALLOW_WATER;
	public static boolean ALLOW_BOAT;
	public static boolean ALLOW_CURSED_WEAPONS;
	public static boolean ALLOW_MANOR;
	public static boolean ENABLE_FALLING_DAMAGE;

	/** Debug & Dev */
	public static boolean ALT_DEV_NO_SPAWNS;
	public static boolean DEVELOPER;
	public static boolean PACKET_HANDLER_DEBUG;
	public static int DEBUG_MOVEMENT;

	/** Deadlock Detector */
	public static boolean DEADLOCK_DETECTOR;
	public static int DEADLOCK_CHECK_INTERVAL;
	public static boolean RESTART_ON_DEADLOCK;

	/** Logs */
	public static boolean LOG_CHAT;
	public static boolean LOG_ITEMS;
	public static boolean GMAUDIT;

	/** Community Board */
	public static boolean ENABLE_COMMUNITY_BOARD;
	public static String BBS_DEFAULT;

	/** Flood Protectors */
	public static int ROLL_DICE_TIME;
	public static int HERO_VOICE_TIME;
	public static int SUBCLASS_TIME;
	public static int DROP_ITEM_TIME;
	public static int SERVER_BYPASS_TIME;
	public static int MULTISELL_TIME;
	public static int MANUFACTURE_TIME;
	public static int MANOR_TIME;
	public static int SENDMAIL_TIME;
	public static int CHARACTER_SELECT_TIME;
	public static int GLOBAL_CHAT_TIME;
	public static int TRADE_CHAT_TIME;
	public static int SOCIAL_TIME;

	/** ThreadPool */
	public static int SCHEDULED_THREAD_POOL_COUNT;
	public static int THREADS_PER_SCHEDULED_THREAD_POOL;
	public static int INSTANT_THREAD_POOL_COUNT;
	public static int THREADS_PER_INSTANT_THREAD_POOL;

	/** Misc */
	public static boolean L2WALKER_PROTECTION;
	public static boolean SERVER_NEWS;
	public static int ZONE_TOWN;
	public static boolean DISABLE_TUTORIAL;

	// --------------------------------------------------
	// Those "hidden" settings haven't configs to avoid admins to fuck their server
	// You still can experiment changing values here. But don't say I didn't warn you.
	// --------------------------------------------------

	/** Reserve Host on LoginServerThread */
	public static boolean RESERVE_HOST_ON_LOGIN = false; // default false

	/** MMO settings */
	public static int MMO_SELECTOR_SLEEP_TIME = 20; // default 20
	public static int MMO_MAX_SEND_PER_PASS = 80; // default 80
	public static int MMO_MAX_READ_PER_PASS = 80; // default 80
	public static int MMO_HELPER_BUFFER_COUNT = 20; // default 20

	/** Client Packets Queue settings */
	public static int CLIENT_PACKET_QUEUE_SIZE = MMO_MAX_READ_PER_PASS + 2; // default MMO_MAX_READ_PER_PASS + 2
	public static int CLIENT_PACKET_QUEUE_MAX_BURST_SIZE = MMO_MAX_READ_PER_PASS + 1; // default MMO_MAX_READ_PER_PASS + 1
	public static int CLIENT_PACKET_QUEUE_MAX_PACKETS_PER_SECOND = 160; // default 160
	public static int CLIENT_PACKET_QUEUE_MEASURE_INTERVAL = 5; // default 5
	public static int CLIENT_PACKET_QUEUE_MAX_AVERAGE_PACKETS_PER_SECOND = 80; // default 80
	public static int CLIENT_PACKET_QUEUE_MAX_FLOODS_PER_MIN = 2; // default 2
	public static int CLIENT_PACKET_QUEUE_MAX_OVERFLOWS_PER_MIN = 1; // default 1
	public static int CLIENT_PACKET_QUEUE_MAX_UNDERFLOWS_PER_MIN = 1; // default 1
	public static int CLIENT_PACKET_QUEUE_MAX_UNKNOWN_PER_MIN = 5; // default 5

	// --------------------------------------------------

	/**
	 * Initialize {@link ExProperties} from specified configuration file.
	 * @param filename : File name to be loaded.
	 * @return ExProperties : Initialized {@link ExProperties}.
	 */
	public static final ExProperties initProperties(String filename)
	{
		final ExProperties result = new ExProperties();

		try
		{
			result.load(new File(filename));
		}
		catch (Exception e)
		{
			LOGGER.error("An error occured loading '{}' config.", e, filename);
		}

		return result;
	}

	/**
	 * Loads clan and clan hall settings.
	 */
	private static final void loadClans()
	{
		final ExProperties clans = initProperties(CLANS_FILE);
		ALT_CLAN_JOIN_DAYS = clans.getProperty("DaysBeforeJoinAClan", 5);
		ALT_CLAN_CREATE_DAYS = clans.getProperty("DaysBeforeCreateAClan", 10);
		ALT_MAX_NUM_OF_CLANS_IN_ALLY = clans.getProperty("AltMaxNumOfClansInAlly", 3);
		ALT_CLAN_MEMBERS_FOR_WAR = clans.getProperty("AltClanMembersForWar", 15);
		ALT_CLAN_WAR_PENALTY_WHEN_ENDED = clans.getProperty("AltClanWarPenaltyWhenEnded", 5);
		ALT_CLAN_DISSOLVE_DAYS = clans.getProperty("DaysToPassToDissolveAClan", 7);
		ALT_ALLY_JOIN_DAYS_WHEN_LEAVED = clans.getProperty("DaysBeforeJoinAllyWhenLeaved", 1);
		ALT_ALLY_JOIN_DAYS_WHEN_DISMISSED = clans.getProperty("DaysBeforeJoinAllyWhenDismissed", 1);
		ALT_ACCEPT_CLAN_DAYS_WHEN_DISMISSED = clans.getProperty("DaysBeforeAcceptNewClanWhenDismissed", 1);
		ALT_CREATE_ALLY_DAYS_WHEN_DISSOLVED = clans.getProperty("DaysBeforeCreateNewAllyWhenDissolved", 10);
		ALT_MEMBERS_CAN_WITHDRAW_FROM_CLANWH = clans.getProperty("AltMembersCanWithdrawFromClanWH", false);

		ALT_MANOR_REFRESH_TIME = clans.getProperty("AltManorRefreshTime", 20);
		ALT_MANOR_REFRESH_MIN = clans.getProperty("AltManorRefreshMin", 0);
		ALT_MANOR_APPROVE_TIME = clans.getProperty("AltManorApproveTime", 6);
		ALT_MANOR_APPROVE_MIN = clans.getProperty("AltManorApproveMin", 0);
		ALT_MANOR_MAINTENANCE_MIN = clans.getProperty("AltManorMaintenanceMin", 6);
		ALT_MANOR_SAVE_PERIOD_RATE = clans.getProperty("AltManorSavePeriodRate", 2) * 3600000;

		CH_TELE_FEE_RATIO = clans.getProperty("ClanHallTeleportFunctionFeeRatio", 86400000);
		CH_TELE1_FEE = clans.getProperty("ClanHallTeleportFunctionFeeLvl1", 7000);
		CH_TELE2_FEE = clans.getProperty("ClanHallTeleportFunctionFeeLvl2", 14000);
		CH_SUPPORT_FEE_RATIO = clans.getProperty("ClanHallSupportFunctionFeeRatio", 86400000);
		CH_SUPPORT1_FEE = clans.getProperty("ClanHallSupportFeeLvl1", 17500);
		CH_SUPPORT2_FEE = clans.getProperty("ClanHallSupportFeeLvl2", 35000);
		CH_SUPPORT3_FEE = clans.getProperty("ClanHallSupportFeeLvl3", 49000);
		CH_SUPPORT4_FEE = clans.getProperty("ClanHallSupportFeeLvl4", 77000);
		CH_SUPPORT5_FEE = clans.getProperty("ClanHallSupportFeeLvl5", 147000);
		CH_SUPPORT6_FEE = clans.getProperty("ClanHallSupportFeeLvl6", 252000);
		CH_SUPPORT7_FEE = clans.getProperty("ClanHallSupportFeeLvl7", 259000);
		CH_SUPPORT8_FEE = clans.getProperty("ClanHallSupportFeeLvl8", 364000);
		CH_MPREG_FEE_RATIO = clans.getProperty("ClanHallMpRegenerationFunctionFeeRatio", 86400000);
		CH_MPREG1_FEE = clans.getProperty("ClanHallMpRegenerationFeeLvl1", 14000);
		CH_MPREG2_FEE = clans.getProperty("ClanHallMpRegenerationFeeLvl2", 26250);
		CH_MPREG3_FEE = clans.getProperty("ClanHallMpRegenerationFeeLvl3", 45500);
		CH_MPREG4_FEE = clans.getProperty("ClanHallMpRegenerationFeeLvl4", 96250);
		CH_MPREG5_FEE = clans.getProperty("ClanHallMpRegenerationFeeLvl5", 140000);
		CH_HPREG_FEE_RATIO = clans.getProperty("ClanHallHpRegenerationFunctionFeeRatio", 86400000);
		CH_HPREG1_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl1", 4900);
		CH_HPREG2_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl2", 5600);
		CH_HPREG3_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl3", 7000);
		CH_HPREG4_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl4", 8166);
		CH_HPREG5_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl5", 10500);
		CH_HPREG6_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl6", 12250);
		CH_HPREG7_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl7", 14000);
		CH_HPREG8_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl8", 15750);
		CH_HPREG9_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl9", 17500);
		CH_HPREG10_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl10", 22750);
		CH_HPREG11_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl11", 26250);
		CH_HPREG12_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl12", 29750);
		CH_HPREG13_FEE = clans.getProperty("ClanHallHpRegenerationFeeLvl13", 36166);
		CH_EXPREG_FEE_RATIO = clans.getProperty("ClanHallExpRegenerationFunctionFeeRatio", 86400000);
		CH_EXPREG1_FEE = clans.getProperty("ClanHallExpRegenerationFeeLvl1", 21000);
		CH_EXPREG2_FEE = clans.getProperty("ClanHallExpRegenerationFeeLvl2", 42000);
		CH_EXPREG3_FEE = clans.getProperty("ClanHallExpRegenerationFeeLvl3", 63000);
		CH_EXPREG4_FEE = clans.getProperty("ClanHallExpRegenerationFeeLvl4", 105000);
		CH_EXPREG5_FEE = clans.getProperty("ClanHallExpRegenerationFeeLvl5", 147000);
		CH_EXPREG6_FEE = clans.getProperty("ClanHallExpRegenerationFeeLvl6", 163331);
		CH_EXPREG7_FEE = clans.getProperty("ClanHallExpRegenerationFeeLvl7", 210000);
		CH_ITEM_FEE_RATIO = clans.getProperty("ClanHallItemCreationFunctionFeeRatio", 86400000);
		CH_ITEM1_FEE = clans.getProperty("ClanHallItemCreationFunctionFeeLvl1", 210000);
		CH_ITEM2_FEE = clans.getProperty("ClanHallItemCreationFunctionFeeLvl2", 490000);
		CH_ITEM3_FEE = clans.getProperty("ClanHallItemCreationFunctionFeeLvl3", 980000);
		CH_CURTAIN_FEE_RATIO = clans.getProperty("ClanHallCurtainFunctionFeeRatio", 86400000);
		CH_CURTAIN1_FEE = clans.getProperty("ClanHallCurtainFunctionFeeLvl1", 2002);
		CH_CURTAIN2_FEE = clans.getProperty("ClanHallCurtainFunctionFeeLvl2", 2625);
		CH_FRONT_FEE_RATIO = clans.getProperty("ClanHallFrontPlatformFunctionFeeRatio", 86400000);
		CH_FRONT1_FEE = clans.getProperty("ClanHallFrontPlatformFunctionFeeLvl1", 3031);
		CH_FRONT2_FEE = clans.getProperty("ClanHallFrontPlatformFunctionFeeLvl2", 9331);
	}

	/**
	 * Loads event settings.<br>
	 * Such as olympiad, seven signs festival, four sepulchures, dimensional rift, weddings, lottery, fishing championship.
	 */
	private static final void loadEvents()
	{
		final ExProperties events = initProperties(EVENTS_FILE);
		ALT_OLY_START_TIME = events.getProperty("AltOlyStartTime", 18);
		ALT_OLY_MIN = events.getProperty("AltOlyMin", 0);
		ALT_OLY_CPERIOD = events.getProperty("AltOlyCPeriod", 21600000);
		ALT_OLY_BATTLE = events.getProperty("AltOlyBattle", 180000);
		ALT_OLY_WPERIOD = events.getProperty("AltOlyWPeriod", 604800000);
		ALT_OLY_VPERIOD = events.getProperty("AltOlyVPeriod", 86400000);
		ALT_OLY_WAIT_TIME = events.getProperty("AltOlyWaitTime", 30);
		ALT_OLY_WAIT_BATTLE = events.getProperty("AltOlyWaitBattle", 60);
		ALT_OLY_WAIT_END = events.getProperty("AltOlyWaitEnd", 40);
		ALT_OLY_START_POINTS = events.getProperty("AltOlyStartPoints", 18);
		ALT_OLY_WEEKLY_POINTS = events.getProperty("AltOlyWeeklyPoints", 3);
		ALT_OLY_MIN_MATCHES = events.getProperty("AltOlyMinMatchesToBeClassed", 5);
		ALT_OLY_CLASSED = events.getProperty("AltOlyClassedParticipants", 5);
		ALT_OLY_NONCLASSED = events.getProperty("AltOlyNonClassedParticipants", 9);
		ALT_OLY_CLASSED_REWARD = events.parseIntIntList("AltOlyClassedReward", "6651-50");
		ALT_OLY_NONCLASSED_REWARD = events.parseIntIntList("AltOlyNonClassedReward", "6651-30");
		ALT_OLY_GP_PER_POINT = events.getProperty("AltOlyGPPerPoint", 1000);
		ALT_OLY_HERO_POINTS = events.getProperty("AltOlyHeroPoints", 300);
		ALT_OLY_RANK1_POINTS = events.getProperty("AltOlyRank1Points", 100);
		ALT_OLY_RANK2_POINTS = events.getProperty("AltOlyRank2Points", 75);
		ALT_OLY_RANK3_POINTS = events.getProperty("AltOlyRank3Points", 55);
		ALT_OLY_RANK4_POINTS = events.getProperty("AltOlyRank4Points", 40);
		ALT_OLY_RANK5_POINTS = events.getProperty("AltOlyRank5Points", 30);
		ALT_OLY_MAX_POINTS = events.getProperty("AltOlyMaxPoints", 10);
		ALT_OLY_DIVIDER_CLASSED = events.getProperty("AltOlyDividerClassed", 3);
		ALT_OLY_DIVIDER_NON_CLASSED = events.getProperty("AltOlyDividerNonClassed", 5);
		ALT_OLY_ANNOUNCE_GAMES = events.getProperty("AltOlyAnnounceGames", true);

		ALT_GAME_CASTLE_DAWN = events.getProperty("AltCastleForDawn", true);
		ALT_GAME_CASTLE_DUSK = events.getProperty("AltCastleForDusk", true);
		ALT_FESTIVAL_MIN_PLAYER = MathUtil.limit(events.getProperty("AltFestivalMinPlayer", 5), 2, 9);
		ALT_MAXIMUM_PLAYER_CONTRIB = events.getProperty("AltMaxPlayerContrib", 1000000);
		ALT_FESTIVAL_MANAGER_START = events.getProperty("AltFestivalManagerStart", 120000);
		ALT_FESTIVAL_LENGTH = events.getProperty("AltFestivalLength", 1080000);
		ALT_FESTIVAL_CYCLE_LENGTH = events.getProperty("AltFestivalCycleLength", 2280000);
		ALT_FESTIVAL_FIRST_SPAWN = events.getProperty("AltFestivalFirstSpawn", 120000);
		ALT_FESTIVAL_FIRST_SWARM = events.getProperty("AltFestivalFirstSwarm", 300000);
		ALT_FESTIVAL_SECOND_SPAWN = events.getProperty("AltFestivalSecondSpawn", 540000);
		ALT_FESTIVAL_SECOND_SWARM = events.getProperty("AltFestivalSecondSwarm", 720000);
		ALT_FESTIVAL_CHEST_SPAWN = events.getProperty("AltFestivalChestSpawn", 900000);

		FS_TIME_ENTRY = events.getProperty("EntryTime", 55);
		FS_TIME_END = events.getProperty("EndTime", 50);
		FS_PARTY_MEMBER_COUNT = MathUtil.limit(events.getProperty("NeededPartyMembers", 4), 2, 9);

		RIFT_MIN_PARTY_SIZE = events.getProperty("RiftMinPartySize", 2);
		RIFT_MAX_JUMPS = events.getProperty("MaxRiftJumps", 4);
		RIFT_SPAWN_DELAY = events.getProperty("RiftSpawnDelay", 10000);
		RIFT_AUTO_JUMPS_TIME_MIN = events.getProperty("AutoJumpsDelayMin", 480);
		RIFT_AUTO_JUMPS_TIME_MAX = events.getProperty("AutoJumpsDelayMax", 600);
		RIFT_ENTER_COST_RECRUIT = events.getProperty("RecruitCost", 18);
		RIFT_ENTER_COST_SOLDIER = events.getProperty("SoldierCost", 21);
		RIFT_ENTER_COST_OFFICER = events.getProperty("OfficerCost", 24);
		RIFT_ENTER_COST_CAPTAIN = events.getProperty("CaptainCost", 27);
		RIFT_ENTER_COST_COMMANDER = events.getProperty("CommanderCost", 30);
		RIFT_ENTER_COST_HERO = events.getProperty("HeroCost", 33);
		RIFT_BOSS_ROOM_TIME_MUTIPLY = events.getProperty("BossRoomTimeMultiply", 1.);

		ALLOW_WEDDING = events.getProperty("AllowWedding", false);
		WEDDING_PRICE = events.getProperty("WeddingPrice", 1000000);
		WEDDING_SAMESEX = events.getProperty("WeddingAllowSameSex", false);
		WEDDING_FORMALWEAR = events.getProperty("WeddingFormalWear", true);

		ALT_LOTTERY_PRIZE = events.getProperty("AltLotteryPrize", 50000);
		ALT_LOTTERY_TICKET_PRICE = events.getProperty("AltLotteryTicketPrice", 2000);
		ALT_LOTTERY_5_NUMBER_RATE = events.getProperty("AltLottery5NumberRate", 0.6);
		ALT_LOTTERY_4_NUMBER_RATE = events.getProperty("AltLottery4NumberRate", 0.2);
		ALT_LOTTERY_3_NUMBER_RATE = events.getProperty("AltLottery3NumberRate", 0.2);
		ALT_LOTTERY_2_AND_1_NUMBER_PRIZE = events.getProperty("AltLottery2and1NumberPrize", 200);

		ALT_FISH_CHAMPIONSHIP_ENABLED = events.getProperty("AltFishChampionshipEnabled", true);
		ALT_FISH_CHAMPIONSHIP_REWARD_ITEM = events.getProperty("AltFishChampionshipRewardItemId", 57);
		ALT_FISH_CHAMPIONSHIP_REWARD_1 = events.getProperty("AltFishChampionshipReward1", 800000);
		ALT_FISH_CHAMPIONSHIP_REWARD_2 = events.getProperty("AltFishChampionshipReward2", 500000);
		ALT_FISH_CHAMPIONSHIP_REWARD_3 = events.getProperty("AltFishChampionshipReward3", 300000);
		ALT_FISH_CHAMPIONSHIP_REWARD_4 = events.getProperty("AltFishChampionshipReward4", 200000);
		ALT_FISH_CHAMPIONSHIP_REWARD_5 = events.getProperty("AltFishChampionshipReward5", 100000);
	}

	/**
	 * Loads geoengine settings.
	 */
	private static final void loadGeoengine()
	{
		final ExProperties geoengine = initProperties(GEOENGINE_FILE);
		GEODATA_PATH = geoengine.getProperty("GeoDataPath", "./data/geodata/");

		PART_OF_CHARACTER_HEIGHT = geoengine.getProperty("PartOfCharacterHeight", 75);
		MAX_OBSTACLE_HEIGHT = geoengine.getProperty("MaxObstacleHeight", 32);

		PATHFIND_BUFFERS = geoengine.getProperty("PathFindBuffers", "100x6;128x6;192x6;256x4;320x4;384x4;500x2");
		BASE_WEIGHT = geoengine.getProperty("BaseWeight", 10);
		DIAGONAL_WEIGHT = geoengine.getProperty("DiagonalWeight", 14);
		OBSTACLE_MULTIPLIER = geoengine.getProperty("ObstacleMultiplier", 10);
		HEURISTIC_WEIGHT = geoengine.getProperty("HeuristicWeight", 20);
		MAX_ITERATIONS = geoengine.getProperty("MaxIterations", 3500);
		DEBUG_PATH = geoengine.getProperty("DebugPath", false);
		DEBUG_GEO_NODE = geoengine.getProperty("DebugGeoNode", false);
	}

	/**
	 * Loads hex ID settings.
	 */
	private static final void loadHexID()
	{
		final ExProperties hexid = initProperties(HEXID_FILE);
		SERVER_ID = Integer.parseInt(hexid.getProperty("ServerID"));
		HEX_ID = new BigInteger(hexid.getProperty("HexID"), 16).toByteArray();
	}

	/**
	 * Saves hex ID file.
	 * @param serverId : The ID of server.
	 * @param hexId : The hex ID of server.
	 */
	public static final void saveHexid(int serverId, String hexId)
	{
		saveHexid(serverId, hexId, HEXID_FILE);
	}

	/**
	 * Saves hexID file.
	 * @param serverId : The ID of server.
	 * @param hexId : The hexID of server.
	 * @param filename : The file name.
	 */
	public static final void saveHexid(int serverId, String hexId, String filename)
	{
		try
		{
			final File file = new File(filename);
			file.createNewFile();

			final Properties hexSetting = new Properties();
			hexSetting.setProperty("ServerID", String.valueOf(serverId));
			hexSetting.setProperty("HexID", hexId);

			try (OutputStream out = new FileOutputStream(file))
			{
				hexSetting.store(out, "the hexID to auth into login");
			}
		}
		catch (Exception e)
		{
			LOGGER.error("Failed to save hex ID to '{}' file.", e, filename);
		}
	}

	/**
	 * Loads NPC settings.<br>
	 * Such as champion monsters, NPC buffer, class master, wyvern, raid bosses and grand bosses, AI.
	 */
	private static final void loadNpcs()
	{
		final ExProperties npcs = initProperties(NPCS_FILE);
		CHAMPION_FREQUENCY = npcs.getProperty("ChampionFrequency", 0);
		CHAMP_MIN_LVL = npcs.getProperty("ChampionMinLevel", 20);
		CHAMP_MAX_LVL = npcs.getProperty("ChampionMaxLevel", 70);
		CHAMPION_HP = npcs.getProperty("ChampionHp", 8);
		CHAMPION_HP_REGEN = npcs.getProperty("ChampionHpRegen", 1.);
		CHAMPION_REWARDS = npcs.getProperty("ChampionRewards", 8);
		CHAMPION_ADENAS_REWARDS = npcs.getProperty("ChampionAdenasRewards", 1);
		CHAMPION_ATK = npcs.getProperty("ChampionAtk", 1.);
		CHAMPION_SPD_ATK = npcs.getProperty("ChampionSpdAtk", 1.);
		CHAMPION_REWARD = npcs.getProperty("ChampionRewardItem", 0);
		CHAMPION_REWARD_ID = npcs.getProperty("ChampionRewardItemID", 6393);
		CHAMPION_REWARD_QTY = npcs.getProperty("ChampionRewardItemQty", 1);

		BUFFER_MAX_SCHEMES = npcs.getProperty("BufferMaxSchemesPerChar", 4);
		BUFFER_STATIC_BUFF_COST = npcs.getProperty("BufferStaticCostPerBuff", -1);

		ALLOW_CLASS_MASTERS = npcs.getProperty("AllowClassMasters", false);
		ALLOW_ENTIRE_TREE = npcs.getProperty("AllowEntireTree", false);
		if (ALLOW_CLASS_MASTERS)
			CLASS_MASTER_SETTINGS = new ClassMasterSettings(npcs.getProperty("ConfigClassMaster"));

		ANNOUNCE_MAMMON_SPAWN = npcs.getProperty("AnnounceMammonSpawn", true);
		ALT_MOB_AGRO_IN_PEACEZONE = npcs.getProperty("AltMobAgroInPeaceZone", true);
		SHOW_NPC_LVL = npcs.getProperty("ShowNpcLevel", false);
		SHOW_NPC_CREST = npcs.getProperty("ShowNpcCrest", false);
		SHOW_SUMMON_CREST = npcs.getProperty("ShowSummonCrest", false);

		WYVERN_ALLOW_UPGRADER = npcs.getProperty("AllowWyvernUpgrader", true);
		WYVERN_REQUIRED_LEVEL = npcs.getProperty("RequiredStriderLevel", 55);
		WYVERN_REQUIRED_CRYSTALS = npcs.getProperty("RequiredCrystalsNumber", 10);

		RAID_HP_REGEN_MULTIPLIER = npcs.getProperty("RaidHpRegenMultiplier", 1.);
		RAID_MP_REGEN_MULTIPLIER = npcs.getProperty("RaidMpRegenMultiplier", 1.);
		RAID_DEFENCE_MULTIPLIER = npcs.getProperty("RaidDefenceMultiplier", 1.);
		RAID_MINION_RESPAWN_TIMER = npcs.getProperty("RaidMinionRespawnTime", 300000);

		RAID_DISABLE_CURSE = npcs.getProperty("DisableRaidCurse", false);

		SPAWN_INTERVAL_AQ = npcs.getProperty("AntQueenSpawnInterval", 36);
		RANDOM_SPAWN_TIME_AQ = npcs.getProperty("AntQueenRandomSpawn", 17);

		SPAWN_INTERVAL_ANTHARAS = npcs.getProperty("AntharasSpawnInterval", 264);
		RANDOM_SPAWN_TIME_ANTHARAS = npcs.getProperty("AntharasRandomSpawn", 72);
		WAIT_TIME_ANTHARAS = npcs.getProperty("AntharasWaitTime", 30) * 60000;

		SPAWN_INTERVAL_BAIUM = npcs.getProperty("BaiumSpawnInterval", 168);
		RANDOM_SPAWN_TIME_BAIUM = npcs.getProperty("BaiumRandomSpawn", 48);

		SPAWN_INTERVAL_CORE = npcs.getProperty("CoreSpawnInterval", 60);
		RANDOM_SPAWN_TIME_CORE = npcs.getProperty("CoreRandomSpawn", 23);

		SPAWN_INTERVAL_FRINTEZZA = npcs.getProperty("FrintezzaSpawnInterval", 48);
		RANDOM_SPAWN_TIME_FRINTEZZA = npcs.getProperty("FrintezzaRandomSpawn", 8);
		WAIT_TIME_FRINTEZZA = npcs.getProperty("FrintezzaWaitTime", 1) * 60000;

		SPAWN_INTERVAL_ORFEN = npcs.getProperty("OrfenSpawnInterval", 48);
		RANDOM_SPAWN_TIME_ORFEN = npcs.getProperty("OrfenRandomSpawn", 20);

		SPAWN_INTERVAL_SAILREN = npcs.getProperty("SailrenSpawnInterval", 36);
		RANDOM_SPAWN_TIME_SAILREN = npcs.getProperty("SailrenRandomSpawn", 24);
		WAIT_TIME_SAILREN = npcs.getProperty("SailrenWaitTime", 5) * 60000;

		SPAWN_INTERVAL_VALAKAS = npcs.getProperty("ValakasSpawnInterval", 264);
		RANDOM_SPAWN_TIME_VALAKAS = npcs.getProperty("ValakasRandomSpawn", 72);
		WAIT_TIME_VALAKAS = npcs.getProperty("ValakasWaitTime", 30) * 60000;

		SPAWN_INTERVAL_ZAKEN = npcs.getProperty("ZakenSpawnInterval", 60);
		RANDOM_SPAWN_TIME_ZAKEN = npcs.getProperty("ZakenRandomSpawn", 20);

		GUARD_ATTACK_AGGRO_MOB = npcs.getProperty("GuardAttackAggroMob", false);
		MAX_DRIFT_RANGE = npcs.getProperty("MaxDriftRange", 300);
		MIN_NPC_ANIMATION = npcs.getProperty("MinNPCAnimation", 20);
		MAX_NPC_ANIMATION = npcs.getProperty("MaxNPCAnimation", 40);
		MIN_MONSTER_ANIMATION = npcs.getProperty("MinMonsterAnimation", 10);
		MAX_MONSTER_ANIMATION = npcs.getProperty("MaxMonsterAnimation", 40);
	}

	/**
	 * Loads player settings.<br>
	 * Such as stats, inventory/warehouse, enchant, augmentation, karma, party, admin, petition, skill learn.
	 */
	private static final void loadPlayers()
	{
		final ExProperties players = initProperties(PLAYERS_FILE);

		ANNOUNCE_KILL = players.getProperty("AnnounceKill", false);
		ANNOUNCE_PVP_MSG = players.getProperty("AnnouncePvpMsg", "$killer has defeated $target");
		ANNOUNCE_PK_MSG = players.getProperty("AnnouncePkMsg", "$killer has slaughtered $target");
		ALT_GAME_VIEWNPC = Boolean.parseBoolean(players.getProperty("AltGameViewNpc", "False"));

		EFFECT_CANCELING = players.getProperty("CancelLesserEffect", true);
		HP_REGEN_MULTIPLIER = players.getProperty("HpRegenMultiplier", 1.);
		MP_REGEN_MULTIPLIER = players.getProperty("MpRegenMultiplier", 1.);
		CP_REGEN_MULTIPLIER = players.getProperty("CpRegenMultiplier", 1.);
		PLAYER_SPAWN_PROTECTION = players.getProperty("PlayerSpawnProtection", 0);
		PLAYER_FAKEDEATH_UP_PROTECTION = players.getProperty("PlayerFakeDeathUpProtection", 0);
		RESPAWN_RESTORE_HP = players.getProperty("RespawnRestoreHP", 0.7);
		MAX_PVTSTORE_SLOTS_DWARF = players.getProperty("MaxPvtStoreSlotsDwarf", 5);
		MAX_PVTSTORE_SLOTS_OTHER = players.getProperty("MaxPvtStoreSlotsOther", 4);
		DEEPBLUE_DROP_RULES = players.getProperty("UseDeepBlueDropRules", true);
		ALT_GAME_DELEVEL = players.getProperty("Delevel", true);
		DEATH_PENALTY_CHANCE = players.getProperty("DeathPenaltyChance", 20);

		INVENTORY_MAXIMUM_NO_DWARF = players.getProperty("MaximumSlotsForNoDwarf", 80);
		INVENTORY_MAXIMUM_DWARF = players.getProperty("MaximumSlotsForDwarf", 100);
		INVENTORY_MAXIMUM_QUEST_ITEMS = players.getProperty("MaximumSlotsForQuestItems", 100);
		INVENTORY_MAXIMUM_PET = players.getProperty("MaximumSlotsForPet", 12);
		MAX_ITEM_IN_PACKET = Math.max(INVENTORY_MAXIMUM_NO_DWARF, INVENTORY_MAXIMUM_DWARF);
		ALT_WEIGHT_LIMIT = players.getProperty("AltWeightLimit", 1);
		WAREHOUSE_SLOTS_NO_DWARF = players.getProperty("MaximumWarehouseSlotsForNoDwarf", 100);
		WAREHOUSE_SLOTS_DWARF = players.getProperty("MaximumWarehouseSlotsForDwarf", 120);
		WAREHOUSE_SLOTS_CLAN = players.getProperty("MaximumWarehouseSlotsForClan", 150);
		FREIGHT_SLOTS = players.getProperty("MaximumFreightSlots", 20);
		ALT_GAME_FREIGHTS = players.getProperty("AltGameFreights", false);
		ALT_GAME_FREIGHT_PRICE = players.getProperty("AltGameFreightPrice", 1000);

		ENCHANT_CHANCE_WEAPON_MAGIC = players.getProperty("EnchantChanceMagicWeapon", 0.4);
		ENCHANT_CHANCE_WEAPON_MAGIC_15PLUS = players.getProperty("EnchantChanceMagicWeapon15Plus", 0.2);
		ENCHANT_CHANCE_WEAPON_NONMAGIC = players.getProperty("EnchantChanceNonMagicWeapon", 0.7);
		ENCHANT_CHANCE_WEAPON_NONMAGIC_15PLUS = players.getProperty("EnchantChanceNonMagicWeapon15Plus", 0.35);
		ENCHANT_CHANCE_ARMOR = players.getProperty("EnchantChanceArmor", 0.66);
		ENCHANT_MAX_WEAPON = players.getProperty("EnchantMaxWeapon", 0);
		ENCHANT_MAX_ARMOR = players.getProperty("EnchantMaxArmor", 0);
		ENCHANT_SAFE_MAX = players.getProperty("EnchantSafeMax", 3);
		ENCHANT_SAFE_MAX_FULL = players.getProperty("EnchantSafeMaxFull", 4);

		AUGMENTATION_NG_SKILL_CHANCE = players.getProperty("AugmentationNGSkillChance", 15);
		AUGMENTATION_NG_GLOW_CHANCE = players.getProperty("AugmentationNGGlowChance", 0);
		AUGMENTATION_MID_SKILL_CHANCE = players.getProperty("AugmentationMidSkillChance", 30);
		AUGMENTATION_MID_GLOW_CHANCE = players.getProperty("AugmentationMidGlowChance", 40);
		AUGMENTATION_HIGH_SKILL_CHANCE = players.getProperty("AugmentationHighSkillChance", 45);
		AUGMENTATION_HIGH_GLOW_CHANCE = players.getProperty("AugmentationHighGlowChance", 70);
		AUGMENTATION_TOP_SKILL_CHANCE = players.getProperty("AugmentationTopSkillChance", 60);
		AUGMENTATION_TOP_GLOW_CHANCE = players.getProperty("AugmentationTopGlowChance", 100);
		AUGMENTATION_BASESTAT_CHANCE = players.getProperty("AugmentationBaseStatChance", 1);

		KARMA_PLAYER_CAN_BE_KILLED_IN_PZ = players.getProperty("KarmaPlayerCanBeKilledInPeaceZone", false);
		KARMA_PLAYER_CAN_SHOP = players.getProperty("KarmaPlayerCanShop", false);
		KARMA_PLAYER_CAN_USE_GK = players.getProperty("KarmaPlayerCanUseGK", false);
		KARMA_PLAYER_CAN_TELEPORT = players.getProperty("KarmaPlayerCanTeleport", true);
		KARMA_PLAYER_CAN_TRADE = players.getProperty("KarmaPlayerCanTrade", true);
		KARMA_PLAYER_CAN_USE_WH = players.getProperty("KarmaPlayerCanUseWareHouse", true);
		KARMA_DROP_GM = players.getProperty("CanGMDropEquipment", false);
		KARMA_AWARD_PK_KILL = players.getProperty("AwardPKKillPVPPoint", true);
		KARMA_PK_LIMIT = players.getProperty("MinimumPKRequiredToDrop", 5);
		KARMA_NONDROPPABLE_PET_ITEMS = players.getProperty("ListOfPetItems", "2375,3500,3501,3502,4422,4423,4424,4425,6648,6649,6650");
		KARMA_NONDROPPABLE_ITEMS = players.getProperty("ListOfNonDroppableItemsForPK", "1147,425,1146,461,10,2368,7,6,2370,2369");

		String[] array = KARMA_NONDROPPABLE_PET_ITEMS.split(",");
		KARMA_LIST_NONDROPPABLE_PET_ITEMS = new int[array.length];

		for (int i = 0; i < array.length; i++)
			KARMA_LIST_NONDROPPABLE_PET_ITEMS[i] = Integer.parseInt(array[i]);

		array = KARMA_NONDROPPABLE_ITEMS.split(",");
		KARMA_LIST_NONDROPPABLE_ITEMS = new int[array.length];

		for (int i = 0; i < array.length; i++)
			KARMA_LIST_NONDROPPABLE_ITEMS[i] = Integer.parseInt(array[i]);

		// sorting so binarySearch can be used later
		Arrays.sort(KARMA_LIST_NONDROPPABLE_PET_ITEMS);
		Arrays.sort(KARMA_LIST_NONDROPPABLE_ITEMS);

		PVP_NORMAL_TIME = players.getProperty("PvPVsNormalTime", 15000);
		PVP_PVP_TIME = players.getProperty("PvPVsPvPTime", 30000);

		PARTY_XP_CUTOFF_METHOD = players.getProperty("PartyXpCutoffMethod", "level");
		PARTY_XP_CUTOFF_PERCENT = players.getProperty("PartyXpCutoffPercent", 3.);
		PARTY_XP_CUTOFF_LEVEL = players.getProperty("PartyXpCutoffLevel", 20);
		PARTY_RANGE = players.getProperty("PartyRange", 1500);

		DEFAULT_ACCESS_LEVEL = players.getProperty("DefaultAccessLevel", 0);
		GM_HERO_AURA = players.getProperty("GMHeroAura", false);
		GM_STARTUP_INVULNERABLE = players.getProperty("GMStartupInvulnerable", true);
		GM_STARTUP_INVISIBLE = players.getProperty("GMStartupInvisible", true);
		GM_STARTUP_SILENCE = players.getProperty("GMStartupSilence", true);
		GM_STARTUP_AUTO_LIST = players.getProperty("GMStartupAutoList", true);

		PETITIONING_ALLOWED = players.getProperty("PetitioningAllowed", true);
		MAX_PETITIONS_PER_PLAYER = players.getProperty("MaxPetitionsPerPlayer", 5);
		MAX_PETITIONS_PENDING = players.getProperty("MaxPetitionsPending", 25);

		IS_CRAFTING_ENABLED = players.getProperty("CraftingEnabled", true);
		DWARF_RECIPE_LIMIT = players.getProperty("DwarfRecipeLimit", 50);
		COMMON_RECIPE_LIMIT = players.getProperty("CommonRecipeLimit", 50);
		ALT_BLACKSMITH_USE_RECIPES = players.getProperty("AltBlacksmithUseRecipes", true);

		AUTO_LEARN_SKILLS = players.getProperty("AutoLearnSkills", false);
		MAGIC_FAILURES = players.getProperty("MagicFailures", true);
		PERFECT_SHIELD_BLOCK_RATE = players.getProperty("PerfectShieldBlockRate", 5);
		LIFE_CRYSTAL_NEEDED = players.getProperty("LifeCrystalNeeded", true);
		SP_BOOK_NEEDED = players.getProperty("SpBookNeeded", true);
		ES_SP_BOOK_NEEDED = players.getProperty("EnchantSkillSpBookNeeded", true);
		DIVINE_SP_BOOK_NEEDED = players.getProperty("DivineInspirationSpBookNeeded", true);
		SUBCLASS_WITHOUT_QUESTS = players.getProperty("SubClassWithoutQuests", false);

		MAX_BUFFS_AMOUNT = players.getProperty("MaxBuffsAmount", 20);
		STORE_SKILL_COOLTIME = players.getProperty("StoreSkillCooltime", true);
	}


	/**
	 * Loads phantom settings.
	 */
	private static final void loadFakePlayer()
	{
		final ExProperties Phanton = initProperties(Config.FAKEPLAYER_FILE);

		// ------------------------------------
		ALLOW_PHANTOM_PLAYERS = Boolean.parseBoolean(Phanton.getProperty("AllowPhantom", "False"));
		ALLOW_PHANTOM_STORE = Boolean.parseBoolean(Phanton.getProperty("AllowPhantomStore", "False"));

		PHANTOM_PRIVATE_STORE = Boolean.parseBoolean(Phanton.getProperty("PhantomPrivateStore", "True"));
		PHANTOM_PRIVATE_BUY_TITLE_MSG = Phanton.getProperty("PhantomPrivate_Buy_Title", "Lineage 2");
		PHANTOM_PRIVATE_BUY_TITLE = new ArrayList<>();
		for (final String type2 : PHANTOM_PRIVATE_BUY_TITLE_MSG.split(","))
		{
			PHANTOM_PRIVATE_BUY_TITLE.add(type2);
		}
		PHANTOM_PRIVATE_BUY_TITLE_MSG = null;
		PHANTOM_PRIVATE_BUY_CHANCE = Phanton.getProperty("PhantomPrivate_Buy_Chance", 50);
		PHANTOM_PRIVATE_BUY = Phanton.getProperty("PhantomPrivate_Buy", "");
		LIST_PRIVATE_BUY = new ArrayList<>();
		for (final String itemId : PHANTOM_PRIVATE_BUY.split(","))
		{
			Config.LIST_PRIVATE_BUY.add(Integer.parseInt(itemId));
		}
		PHANTOM_PRIVATE_SELL_TITLE_MSG = Phanton.getProperty("PhantomPrivate_Sell_Title", "Lineage 2");
		PHANTOM_PRIVATE_SELL_TITLE = new ArrayList<>();
		for (final String type2 : PHANTOM_PRIVATE_SELL_TITLE_MSG.split(","))
		{
			Config.PHANTOM_PRIVATE_SELL_TITLE.add(type2);
		}
		PHANTOM_PRIVATE_BUY_TITLE_MSG = null;
		PHANTOM_PRIVATE_SELL_CHANCE = Phanton.getProperty("PhantomPrivate_Sell_Chance", 50);
		PHANTOM_PRIVATE_SELL = Phanton.getProperty("PhantomPrivate_Sell", "");
		LIST_PRIVATE_SELL = new ArrayList<>();
		for (final String itemId : PHANTOM_PRIVATE_SELL.split(","))
		{
			LIST_PRIVATE_SELL.add(Integer.parseInt(itemId));
		}

		ALLOW_PHANTOM_FACE = Boolean.parseBoolean(Phanton.getProperty("PhantomFace", "True"));
		PHANTOM_FACE = Phanton.getProperty("PhantomFaceList", "");
		LIST_PHANTOM_FACE = new ArrayList<>();
		for (String itemId : PHANTOM_FACE.trim().split(","))
		{
			LIST_PHANTOM_FACE.add(Integer.valueOf(Integer.parseInt(itemId)));
		}

		ALLOW_PHANTOM_HAIR = Boolean.parseBoolean(Phanton.getProperty("PhantomHair", "True"));

		PHANTOM_HAIR = Phanton.getProperty("PhantomHairList", "0");
		LIST_PHANTOM_HAIR = new ArrayList<>();
		for (String itemId : PHANTOM_HAIR.trim().split(","))
		{
			LIST_PHANTOM_HAIR.add(Integer.valueOf(Integer.parseInt(itemId)));
		}

		PHANTOM_CHANCE_SIT = Integer.parseInt(Phanton.getProperty("Phantom_Chance_sitDown", "10"));
		PHANTOM_PLAYERS_SOULSHOT_ANIM = Boolean.parseBoolean(Phanton.getProperty("PhantomSoulshotAnimation", "True"));

		PHANTOM_PLAYERS_WALK = Phanton.getProperty("PhantomWalkChance", 50);

		PHANTOM_PLAYERS_ACC_1 = Phanton.getProperty("PhantomTownAccount", "l2jmega");

		PHANTOM_PLAYERS_ACC_2 = Phanton.getProperty("PhantomPrivateStoreAccount", "l2jmega2");

		PHANTOM_DELAY_SPAWN_FIRST = (int) TimeUnit.SECONDS.toMillis(Integer.parseInt(Phanton.getProperty("FirstDelaySpawn", "1")));
		DISCONNETC_DELAY = TimeUnit.MINUTES.toMillis(Integer.parseInt(Phanton.getProperty("DisconnectDelay", "15")));

		PHANTOM_PLAYERS_ARGUMENT_ANIM = Boolean.parseBoolean(Phanton.getProperty("PhantomArgumentAnimation", "True"));

		String[] arrayOfString1 = Phanton.getProperty("FakeEnchant", "0,14").split(",");
		PHANTOM_PLAYERS_ENCHANT_MIN = Integer.parseInt(arrayOfString1[0]);
		PHANTOM_PLAYERS_ENCHANT_MAX = Integer.parseInt(arrayOfString1[1]);

		PHANTOM_CHANCE_MALARIA = Phanton.getProperty("Phantom_Chance_MalariaEffect", 60);

		PHANTOM_CHANCE_HERO = Phanton.getProperty("Phantom_Chance_HeroEffect", 60);

        NAME_COLOR = Phanton.getProperty("NameColor", "FFFFFF");
        TITLE_COLOR = Phanton.getProperty("TitleColor", "FFFFFF");
        PHANTOM_NAME_CLOLORS = Phanton.getProperty("FakeNameColors", "FFFFFF");
        PHANTOM_PLAYERS_NAME_CLOLORS = new ArrayList<>();
        for (String type2 : PHANTOM_NAME_CLOLORS.split(",")) {
            PHANTOM_PLAYERS_NAME_CLOLORS.add(type2);
        }
        PHANTOM_NAME_CLOLORS = null;
        PHANTOM_TITLE_CLOLORS = Phanton.getProperty("FakeTitleColors", "FFFFFF");
        PHANTOM_PLAYERS_TITLE_CLOLORS = new ArrayList<>();
        for (String type2 : PHANTOM_TITLE_CLOLORS.split(",")) {
            PHANTOM_PLAYERS_TITLE_CLOLORS.add(type2);
        }
        CLANID = Phanton.getProperty("ClanID", 50);

        CLANIDWALKER = Phanton.getProperty("ClanWalkerID", 50);

        FIGHTER_BUFF = Phanton.getProperty("FighterBuffList", "0");
        FIGHTER_BUFF_LIST = new ArrayList<>();
        for (final String id : Config.FIGHTER_BUFF.trim().split(",")) {
            Config.FIGHTER_BUFF_LIST.add(Integer.parseInt(id.trim()));
        }
        MAGE_BUFF = Phanton.getProperty("MageBuffList", "0");
        MAGE_BUFF_LIST = new ArrayList<>();
        for (final String id : MAGE_BUFF.trim().split(",")) {
            MAGE_BUFF_LIST.add(Integer.parseInt(id.trim()));
        }

    	ENABLE_GIRAN_TO = Phanton.getProperty("EnabledGiranWalker", true);

		String[] TelepropertySplit = Phanton.getProperty("SpwanLocationGiran", "0,0,0").split(",");
		if (TelepropertySplit.length < 3)
			System.out.println("Fake Player Giran Walker [Config.load()]: invalid config property -> SpwanLocationFakePlayer");
		else
		{
			TELE_TO_GIRAN[0] = Integer.parseInt(TelepropertySplit[0]);
			TELE_TO_GIRAN[1] = Integer.parseInt(TelepropertySplit[1]);
			TELE_TO_GIRAN[2] = Integer.parseInt(TelepropertySplit[2]);
		}


		ENABLE_GODARD_TO = Phanton.getProperty("EnabledGoddardWalker", true);

		String[] TelepropertySplit1 = Phanton.getProperty("SpwanLocationGoddard", "0,0,0").split(",");
		if (TelepropertySplit1.length < 3)
			System.out.println("Fake Player Goddard Walker [Config.load()]: invalid config property -> SpwanLocationGoddard");
		else
		{
			TELE_TO_GODDARD[0] = Integer.parseInt(TelepropertySplit1[0]);
			TELE_TO_GODDARD[1] = Integer.parseInt(TelepropertySplit1[1]);
			TELE_TO_GODDARD[2] = Integer.parseInt(TelepropertySplit1[2]);
		}

		ENABLE_SPAWN_TO_50_PLAYER = Phanton.getProperty("Enabled50FakePlayerSpwan", true);

		String[] TelepropertySplit2 = Phanton.getProperty("SpwanFakeCustom50", "0,0,0").split(",");
		if (TelepropertySplit2.length < 3)
			System.out.println("Fake Player Spawn 50 Player [Config.load()]: invalid config property -> SpwanFakeCustom50");
		else
		{
			TELE_TO_SPWAN50[0] = Integer.parseInt(TelepropertySplit2[0]);
			TELE_TO_SPWAN50[1] = Integer.parseInt(TelepropertySplit2[1]);
			TELE_TO_SPWAN50[2] = Integer.parseInt(TelepropertySplit2[2]);
		}


		ENABLE_ADEN_TO = Phanton.getProperty("EnabledGoddardWalker", true);

		String[] TelepropertySplit4 = Phanton.getProperty("SpwanLocationAden", "0,0,0").split(",");
		if (TelepropertySplit4.length < 3)
			System.out.println("Fake Player Aden Walker [Config.load()]: invalid config property -> SpwanLocationGludin");
		else
		{
			TELE_TO_ADEN[0] = Integer.parseInt(TelepropertySplit4[0]);
			TELE_TO_ADEN[1] = Integer.parseInt(TelepropertySplit4[1]);
			TELE_TO_ADEN[2] = Integer.parseInt(TelepropertySplit4[2]);
		}


		ENABLE_GLUDIN_TO = Phanton.getProperty("EnabledGludinWalker", true);

		String[] TelepropertySplit5 = Phanton.getProperty("SpwanLocationGludin", "0,0,0").split(",");
		if (TelepropertySplit5.length < 3)
			System.out.println("Fake Player Gludin Walker [Config.load()]: invalid config property -> SpwanLocationGludin");
		else
		{
			TELE_TO_GLUDIN[0] = Integer.parseInt(TelepropertySplit5[0]);
			TELE_TO_GLUDIN[1] = Integer.parseInt(TelepropertySplit5[1]);
			TELE_TO_GLUDIN[2] = Integer.parseInt(TelepropertySplit5[2]);
		}

		ENABLE_DION_TO = Phanton.getProperty("EnabledDionWalker", true);

		String[] TelepropertySplit6 = Phanton.getProperty("SpwanLocationDion", "0,0,0").split(",");
		if (TelepropertySplit6.length < 3)
			System.out.println("Fake Player Dion Walker [Config.load()]: invalid config property -> SpwanLocationDion");
		else
		{
			TELE_TO_DION[0] = Integer.parseInt(TelepropertySplit6[0]);
			TELE_TO_DION[1] = Integer.parseInt(TelepropertySplit6[1]);
			TELE_TO_DION[2] = Integer.parseInt(TelepropertySplit6[2]);
		}



		CONTROLL_FAKE_ON = Boolean.parseBoolean(Phanton.getProperty("ControlFakeOn", "False"));
		FAKE_PLAYER_CAN_TARGET_REAL_PLAYER = Boolean.parseBoolean(Phanton.getProperty("FakePlayerTargetRealPlayer", "False"));

		FAKE_PLAYER_RETURNS_TO_FARM = Phanton.getProperty("FakePlayerReturnFarm", true);

		SPAWN_FAKE_LOC1 = Phanton.getProperty("FakeSpawnLocation1", new int []
			{53717, 83639, -3540});
		SPAWN_FAKE_LOC2 = Phanton.getProperty("FakeSpawnLocation2", new int []
			{57428, 82020, -3599});

		FAKE_SPAWN_RANDOM_OFFSET = Phanton.getProperty("RandomSpawnOffset", 0);
	}


	private static final void loadArmor1()
	{
		final ExProperties ArmorFakePlayer = initProperties(FAKE_ARMOR);

		MIN_ENCHANT_FAKE_ARMOR = Integer.parseInt(ArmorFakePlayer.getProperty("MinEnchant_Armor", "0"));
		MAX_ENCHANT_FAKE_ARMOR = Integer.parseInt(ArmorFakePlayer.getProperty("MaxEnchant_Armor", "0"));

		/*FAKE ARMOR E WEAPONS BAN*/
		FAKE_ARMOR_MYSTIC_MUSE = ArmorFakePlayer.getProperty("ARMOR_MYSTIC_MUSE", "0");
		ARMOR_MYSTIC_MUSE = new ArrayList<>();
        for (final String listid : FAKE_ARMOR_MYSTIC_MUSE.split(",")) {
        	ARMOR_MYSTIC_MUSE.add(Integer.parseInt(listid));
        }

		FAKE_ARMOR_HIEROPHANT = ArmorFakePlayer.getProperty("ARMOR_HIEROPHANT", "0");
		ARMOR_HIEROPHANT = new ArrayList<>();
        for (final String listid : FAKE_ARMOR_HIEROPHANT.split(",")) {
        	ARMOR_HIEROPHANT.add(Integer.parseInt(listid));
        }

		FAKE_ARMOR_ARCANA_LORD = ArmorFakePlayer.getProperty("ARMOR_ARCANA_LORD", "0");
		ARMOR_ARCANA_LORD = new ArrayList<>();
        for (final String listid : FAKE_ARMOR_ARCANA_LORD.split(",")) {
        	ARMOR_ARCANA_LORD.add(Integer.parseInt(listid));
        }

		FAKE_ARMOR_CARDINAL = ArmorFakePlayer.getProperty("ARMOR_CARDINAL", "0");
		ARMOR_CARDINAL = new ArrayList<>();
        for (final String listid : FAKE_ARMOR_CARDINAL.split(",")) {
        	ARMOR_CARDINAL.add(Integer.parseInt(listid));
        }

		FAKE_ARMOR_ELEMENTAL_MASTER = ArmorFakePlayer.getProperty("ARMOR_ELEMENTAL_MASTER", "0");
		ARMOR_ELEMENTAL_MASTER = new ArrayList<>();
        for (final String listid : FAKE_ARMOR_ELEMENTAL_MASTER.split(",")) {
        	ARMOR_ELEMENTAL_MASTER.add(Integer.parseInt(listid));
        }

		FAKE_ARMOR_DOOMCRYER = ArmorFakePlayer.getProperty("ARMOR_DOOMCRYER", "0");
		ARMOR_DOOMCRYER = new ArrayList<>();
        for (final String listid : FAKE_ARMOR_DOOMCRYER.split(",")) {
        	ARMOR_DOOMCRYER.add(Integer.parseInt(listid));
        }

		FAKE_ARMOR_DOMINATOR = ArmorFakePlayer.getProperty("ARMOR_DOMINATOR", "0");
		ARMOR_DOMINATOR = new ArrayList<>();
        for (final String listid : FAKE_ARMOR_DOMINATOR.split(",")) {
        	ARMOR_DOMINATOR.add(Integer.parseInt(listid));
        }

		FAKE_ARMOR_GHOST_SENTINEL = ArmorFakePlayer.getProperty("ARMOR_GHOST_SENTINEL", "0");
		ARMOR_GHOST_SENTINEL = new ArrayList<>();
        for (final String listid : FAKE_ARMOR_GHOST_SENTINEL.split(",")) {
        	ARMOR_GHOST_SENTINEL.add(Integer.parseInt(listid));
        }

		FAKE_ARMOR_ADVENTURER = ArmorFakePlayer.getProperty("ARMOR_ADVENTURER", "0");
		ARMOR_ADVENTURER = new ArrayList<>();
        for (final String listid : FAKE_ARMOR_ADVENTURER.split(",")) {
        	ARMOR_ADVENTURER.add(Integer.parseInt(listid));
        }

		FAKE_ARMOR_SOULTAKER = ArmorFakePlayer.getProperty("ARMOR_SOULTAKER", "0");
		ARMOR_SOULTAKER = new ArrayList<>();
        for (final String listid : FAKE_ARMOR_SOULTAKER.split(",")) {
        	ARMOR_SOULTAKER.add(Integer.parseInt(listid));
        }

		FAKE_ARMOR_ARCHMAGE = ArmorFakePlayer.getProperty("ARMOR_ARCHMAGE", "0");
		ARMOR_ARCHMAGE = new ArrayList<>();
        for (final String listid : FAKE_ARMOR_ARCHMAGE.split(",")) {
        	ARMOR_ARCHMAGE.add(Integer.parseInt(listid));
        }

		FAKE_ARMOR_DUELIST = ArmorFakePlayer.getProperty("ARMOR_DUELIST", "0");
		ARMOR_DUELIST = new ArrayList<>();
        for (final String listid : FAKE_ARMOR_DUELIST.split(",")) {
        	ARMOR_DUELIST.add(Integer.parseInt(listid));
        }

		FAKE_ARMOR_MAESTRO = ArmorFakePlayer.getProperty("ARMOR_MAESTRO", "0");
		ARMOR_MAESTRO = new ArrayList<>();
        for (final String listid : FAKE_ARMOR_MAESTRO.split(",")) {
        	ARMOR_MAESTRO.add(Integer.parseInt(listid));
        }

		FAKE_ARMOR_HELL_KNIGHT = ArmorFakePlayer.getProperty("ARMOR_HELL_KNIGHT", "0");
		ARMOR_HELL_KNIGHT = new ArrayList<>();
        for (final String listid : FAKE_ARMOR_HELL_KNIGHT.split(",")) {
        	ARMOR_HELL_KNIGHT.add(Integer.parseInt(listid));
        }

		FAKE_ARMOR_TITAN = ArmorFakePlayer.getProperty("ARMOR_TITAN", "0");
		ARMOR_TITAN = new ArrayList<>();
        for (final String listid : FAKE_ARMOR_TITAN.split(",")) {
        	ARMOR_TITAN.add(Integer.parseInt(listid));
        }

		FAKE_ARMOR_SAGGITARIUS = ArmorFakePlayer.getProperty("ARMOR_SAGGITARIUS", "0");
		ARMOR_SAGGITARIUS = new ArrayList<>();
        for (final String listid : FAKE_ARMOR_SAGGITARIUS.split(",")) {
        	ARMOR_SAGGITARIUS.add(Integer.parseInt(listid));
        }

		FAKE_ARMOR_WIND_RIDER = ArmorFakePlayer.getProperty("ARMOR_WIND_RIDER", "0");
		ARMOR_WIND_RIDER = new ArrayList<>();
        for (final String listid : FAKE_ARMOR_WIND_RIDER.split(",")) {
        	ARMOR_WIND_RIDER.add(Integer.parseInt(listid));
        }

		FAKE_ARMOR_GRAND_KHAVATARI = ArmorFakePlayer.getProperty("ARMOR_GRAND_KHAVATARI", "0");
		ARMOR_GRAND_KHAVATARI = new ArrayList<>();
        for (final String listid : FAKE_ARMOR_GRAND_KHAVATARI.split(",")) {
        	ARMOR_GRAND_KHAVATARI.add(Integer.parseInt(listid));
        }

		FAKE_ARMOR_STORM_SCREAMER = ArmorFakePlayer.getProperty("ARMOR_STORM_SCREAMER", "0");
		ARMOR_STORM_SCREAMER = new ArrayList<>();
        for (final String listid : FAKE_ARMOR_STORM_SCREAMER.split(",")) {
        	ARMOR_STORM_SCREAMER.add(Integer.parseInt(listid));
        }

		FAKE_ARMOR_EVAS_SAINT = ArmorFakePlayer.getProperty("ARMOR_EVAS_SAINT", "0");
		ARMOR_EVAS_SAINT = new ArrayList<>();
        for (final String listid : FAKE_ARMOR_EVAS_SAINT.split(",")) {
        	ARMOR_EVAS_SAINT.add(Integer.parseInt(listid));
        }

		FAKE_ARMOR_SPECTRAL_MASTER = ArmorFakePlayer.getProperty("ARMOR_SPECTRAL_MASTER", "0");
		ARMOR_SPECTRAL_MASTER = new ArrayList<>();
        for (final String listid : FAKE_ARMOR_SPECTRAL_MASTER.split(",")) {
        	ARMOR_SPECTRAL_MASTER.add(Integer.parseInt(listid));
        }

		FAKE_ARMOR_SHILLIEN_SAINT = ArmorFakePlayer.getProperty("ARMOR_SHILLIEN_SAINT", "0");
		ARMOR_SHILLIEN_SAINT = new ArrayList<>();
        for (final String listid : FAKE_ARMOR_SHILLIEN_SAINT.split(",")) {
        	ARMOR_SHILLIEN_SAINT.add(Integer.parseInt(listid));
        }

		FAKE_ARMOR_DREADNOUGHT = ArmorFakePlayer.getProperty("ARMOR_DREADNOUGHT", "0");
		ARMOR_DREADNOUGHT = new ArrayList<>();
        for (final String listid : FAKE_ARMOR_DREADNOUGHT.split(",")) {
        	ARMOR_DREADNOUGHT.add(Integer.parseInt(listid));
        }

		FAKE_ARMOR_PHOENIX_KNIGHT = ArmorFakePlayer.getProperty("ARMOR_PHOENIX_KNIGHT", "0");
		ARMOR_PHOENIX_KNIGHT = new ArrayList<>();
        for (final String listid : FAKE_ARMOR_PHOENIX_KNIGHT.split(",")) {
        	ARMOR_PHOENIX_KNIGHT.add(Integer.parseInt(listid));
        }

		FAKE_ARMOR_SWORD_MUSE = ArmorFakePlayer.getProperty("ARMOR_SWORD_MUSE", "0");
		ARMOR_SWORD_MUSE = new ArrayList<>();
        for (final String listid : FAKE_ARMOR_SWORD_MUSE.split(",")) {
        	ARMOR_SWORD_MUSE.add(Integer.parseInt(listid));
        }

		FAKE_ARMOR_SPECTRAL_DANCER = ArmorFakePlayer.getProperty("ARMOR_SPECTRAL_DANCER", "0");
		ARMOR_SPECTRAL_DANCER = new ArrayList<>();
        for (final String listid : FAKE_ARMOR_SPECTRAL_DANCER.split(",")) {
        	ARMOR_SPECTRAL_DANCER.add(Integer.parseInt(listid));
        }

		FAKE_ARMOR_EVAS_TEMPLAR = ArmorFakePlayer.getProperty("ARMOR_EVAS_TEMPLAR", "0");
		ARMOR_EVAS_TEMPLAR = new ArrayList<>();
        for (final String listid : FAKE_ARMOR_EVAS_TEMPLAR.split(",")) {
        	ARMOR_EVAS_TEMPLAR.add(Integer.parseInt(listid));
        }


		FAKE_ARMOR_SHILLIEN_TEMPLAR = ArmorFakePlayer.getProperty("ARMOR_SHILLIEN_TEMPLAR", "0");
		ARMOR_SHILLIEN_TEMPLAR = new ArrayList<>();
        for (final String listid : FAKE_ARMOR_SHILLIEN_TEMPLAR.split(",")) {
        	ARMOR_SHILLIEN_TEMPLAR.add(Integer.parseInt(listid));
        }

		FAKE_ARMOR_MOONLIGHT = ArmorFakePlayer.getProperty("ARMOR_MOONLIGHT", "0");
		ARMOR_MOONLIGHT = new ArrayList<>();
        for (final String listid : FAKE_ARMOR_MOONLIGHT.split(",")) {
        	ARMOR_MOONLIGHT.add(Integer.parseInt(listid));
        }

		FAKE_ARMOR_GHOST_HUNTER = ArmorFakePlayer.getProperty("ARMOR_GHOST_HUNTER", "0");
		ARMOR_GHOST_HUNTER = new ArrayList<>();
        for (final String listid : FAKE_ARMOR_GHOST_HUNTER.split(",")) {
        	ARMOR_GHOST_HUNTER.add(Integer.parseInt(listid));
        }

		FAKE_ARMOR_FORTUNE = ArmorFakePlayer.getProperty("ARMOR_FORTUNE", "0");
		ARMOR_FORTUNE = new ArrayList<>();
        for (final String listid : FAKE_ARMOR_FORTUNE.split(",")) {
        	ARMOR_FORTUNE.add(Integer.parseInt(listid));
        }


	}


	private static final void loadNewChar()
	{
		final ExProperties newChar = initProperties(NEWBIECHAR);
		CHAR_TITLE = Boolean.parseBoolean(newChar.getProperty("CharTitle", "false"));
		ADD_CHAR_TITLE = newChar.getProperty("CharAddTitle", "Welcome");
		ALLOW_CREATE_LVL = Boolean.parseBoolean(newChar.getProperty("CustomStartingLvl", "False"));
		CHAR_CREATE_LVL = Integer.parseInt(newChar.getProperty("CharLvl", "80"));
		SPAWN_CHAR = Boolean.parseBoolean(newChar.getProperty("CustomSpawn", "false"));
		SPAWN_X = Integer.parseInt(newChar.getProperty("SpawnX", ""));
		SPAWN_Y = Integer.parseInt(newChar.getProperty("SpawnY", ""));
		SPAWN_Z = Integer.parseInt(newChar.getProperty("SpawnZ", ""));
		STARTING_BUFFS = Boolean.parseBoolean(newChar.getProperty("StartingBuffs", "True"));
		String[] startingBuffsSplit = newChar.getProperty("StartingBuffsMage", "1204,2").split(";");
		STARTING_BUFFS_M.clear();
		for (String buff : startingBuffsSplit)
		{
			String[] buffSplit = buff.split(",");
			if (buffSplit.length != 2)
				LOGGER.warn("StartingBuffsMage[Config.load()]: invalid config property -> StartingBuffsMage \"" + buff + "\"");
			else
			{
				try
				{
					STARTING_BUFFS_M.add(new int[]
						{
							Integer.parseInt(buffSplit[0]),
							Integer.parseInt(buffSplit[1])
						});
				}
				catch (NumberFormatException nfe)
				{
					if (STARTING_BUFFS_M.equals(""))
						System.out.println("EROOOOOOOOOOOR WITH STARTING BUFS");
				}
			}
		}
		startingBuffsSplit = newChar.getProperty("StartingBuffsFighter", "1204,2").split(";");
		STARTING_BUFFS_F.clear();
		for (String buff : startingBuffsSplit)
		{
			String[] buffSplit = buff.split(",");
			if (buffSplit.length != 2)
				LOGGER.warn("StartingBuffsFighter[Config.load()]: invalid config property -> StartingBuffsFighter \"" + buff + "\"");
			else
			{
				try
				{
					STARTING_BUFFS_F.add(new int[]
						{
							Integer.parseInt(buffSplit[0]),
							Integer.parseInt(buffSplit[1])
						});
				}
				catch (NumberFormatException nfe)
				{
					if (STARTING_BUFFS_F.equals(""))
						System.out.println("EROOOOOOOOOOOR WITH STARTING BUFS");
				}
			}
		}
		CUSTOM_STARTER_ITEMS_ENABLED = Boolean.parseBoolean(newChar.getProperty("CustomStarterItemsEnabled", "False"));
		if (Config.CUSTOM_STARTER_ITEMS_ENABLED)
		{
			String[] propertySplit = newChar.getProperty("StartingCustomItemsMage", "57,0").split(";");
			STARTING_CUSTOM_ITEMS_M.clear();
			for (final String reward : propertySplit)
			{
				final String[] rewardSplit = reward.split(",");
				if (rewardSplit.length != 2)
					LOGGER.warn("StartingCustomItemsMage[Config.load()]: invalid config property -> StartingCustomItemsMage \"" + reward + "\"");
				else
				{
					try
					{
						STARTING_CUSTOM_ITEMS_M.add(new int[]
							{
								Integer.parseInt(rewardSplit[0]),
								Integer.parseInt(rewardSplit[1])
							});
					}
					catch (final NumberFormatException nfe)
					{
							nfe.printStackTrace();
						if (!reward.isEmpty())
							LOGGER.warn("StartingCustomItemsMage[Config.load()]: invalid config property -> StartingCustomItemsMage \"" + reward + "\"");
					}
				}
			}

			propertySplit = newChar.getProperty("StartingCustomItemsFighter", "57,0").split(";");
			STARTING_CUSTOM_ITEMS_F.clear();
			for (final String reward : propertySplit)
			{
				final String[] rewardSplit = reward.split(",");
				if (rewardSplit.length != 2)
					LOGGER.warn("StartingCustomItemsFighter[Config.load()]: invalid config property -> StartingCustomItemsFighter \"" + reward + "\"");
				else
				{
					try
					{
						STARTING_CUSTOM_ITEMS_F.add(new int[]
							{
								Integer.parseInt(rewardSplit[0]),
								Integer.parseInt(rewardSplit[1])
							});
					}
					catch (final NumberFormatException nfe)
					{
							nfe.printStackTrace();

						if (!reward.isEmpty())
							LOGGER.warn("StartingCustomItemsFighter[Config.load()]: invalid config property -> StartingCustomItemsFighter \"" + reward + "\"");
					}
				}
			}
		}
	}


	private static final void loadWeapon()
	{
		final ExProperties WeaponFakePlayer = initProperties(FAKE_WEAPON);

		/*FAKE WEAPONS BAN*/

		MIN_ENCHANT_FAKE_WEAPON = Integer.parseInt(WeaponFakePlayer.getProperty("MinEnchant_Weapon", "0"));
		MAX_ENCHANT_FAKE_WEAPON = Integer.parseInt(WeaponFakePlayer.getProperty("MaxEnchant_Weapon", "0"));

		FAKE_WEAPON_MYSTIC_MUSE = WeaponFakePlayer.getProperty("WEAPON_MYSTIC_MUSE", "0");
		WEAPON_MYSTIC_MUSE = new ArrayList<>();
        for (final String listid : FAKE_WEAPON_MYSTIC_MUSE.split(",")) {
        	WEAPON_MYSTIC_MUSE.add(Integer.parseInt(listid));
        }

		FAKE_WEAPON_HIEROPHANT = WeaponFakePlayer.getProperty("WEAPON_HIEROPHANT", "0");
		WEAPON_HIEROPHANT = new ArrayList<>();
        for (final String listid : FAKE_WEAPON_HIEROPHANT.split(",")) {
        	WEAPON_HIEROPHANT.add(Integer.parseInt(listid));
        }

		FAKE_WEAPON_ARCANA_LORD = WeaponFakePlayer.getProperty("WEAPON_ARCANA_LORD", "0");
		WEAPON_ARCANA_LORD = new ArrayList<>();
        for (final String listid : FAKE_WEAPON_ARCANA_LORD.split(",")) {
        	WEAPON_ARCANA_LORD.add(Integer.parseInt(listid));
        }

		FAKE_WEAPON_CARDINAL = WeaponFakePlayer.getProperty("WEAPON_CARDINAL", "0");
		WEAPON_CARDINAL = new ArrayList<>();
        for (final String listid : FAKE_WEAPON_CARDINAL.split(",")) {
        	WEAPON_CARDINAL.add(Integer.parseInt(listid));
        }

		FAKE_WEAPON_ELEMENTAL_MASTER = WeaponFakePlayer.getProperty("WEAPON_ELEMENTAL_MASTER", "0");
		WEAPON_ELEMENTAL_MASTER = new ArrayList<>();
        for (final String listid : FAKE_WEAPON_ELEMENTAL_MASTER.split(",")) {
        	WEAPON_ELEMENTAL_MASTER.add(Integer.parseInt(listid));
        }

		FAKE_WEAPON_DOOMCRYER = WeaponFakePlayer.getProperty("WEAPON_DOOMCRYER", "0");
		WEAPON_DOOMCRYER = new ArrayList<>();
        for (final String listid : FAKE_WEAPON_DOOMCRYER.split(",")) {
        	WEAPON_DOOMCRYER.add(Integer.parseInt(listid));
        }

		FAKE_WEAPON_DOMINATOR = WeaponFakePlayer.getProperty("WEAPON_DOMINATOR", "0");
		WEAPON_DOMINATOR = new ArrayList<>();
        for (final String listid : FAKE_WEAPON_DOMINATOR.split(",")) {
        	WEAPON_DOMINATOR.add(Integer.parseInt(listid));
        }

		FAKE_WEAPON_GHOST_SENTINEL = WeaponFakePlayer.getProperty("WEAPON_GHOST_SENTINEL", "0");
		WEAPON_GHOST_SENTINEL = new ArrayList<>();
        for (final String listid : FAKE_WEAPON_GHOST_SENTINEL.split(",")) {
        	WEAPON_GHOST_SENTINEL.add(Integer.parseInt(listid));
        }

		FAKE_WEAPON_ADVENTURER = WeaponFakePlayer.getProperty("WEAPON_ADVENTURER", "0");
		WEAPON_ADVENTURER = new ArrayList<>();
        for (final String listid : FAKE_WEAPON_ADVENTURER.split(",")) {
        	WEAPON_ADVENTURER.add(Integer.parseInt(listid));
        }

		FAKE_WEAPON_SOULTAKER = WeaponFakePlayer.getProperty("WEAPON_SOULTAKER", "0");
		WEAPON_SOULTAKER = new ArrayList<>();
        for (final String listid : FAKE_WEAPON_SOULTAKER.split(",")) {
        	WEAPON_SOULTAKER.add(Integer.parseInt(listid));
        }

		FAKE_WEAPON_ARCHMAGE = WeaponFakePlayer.getProperty("WEAPON_ARCHMAGE", "0");
		WEAPON_ARCHMAGE = new ArrayList<>();
        for (final String listid : FAKE_WEAPON_ARCHMAGE.split(",")) {
        	WEAPON_ARCHMAGE.add(Integer.parseInt(listid));
        }

		FAKE_WEAPON_DUELIST = WeaponFakePlayer.getProperty("WEAPON_DUELIST", "0");
		WEAPON_DUELIST = new ArrayList<>();
        for (final String listid : FAKE_WEAPON_DUELIST.split(",")) {
        	WEAPON_DUELIST.add(Integer.parseInt(listid));
        }

		FAKE_WEAPON_MAESTRO = WeaponFakePlayer.getProperty("WEAPON_MAESTRO", "0");
		WEAPON_MAESTRO = new ArrayList<>();
        for (final String listid : FAKE_WEAPON_MAESTRO.split(",")) {
        	WEAPON_MAESTRO.add(Integer.parseInt(listid));
        }

		FAKE_WEAPON_HELL_KNIGHT = WeaponFakePlayer.getProperty("WEAPON_HELL_KNIGHT", "0");
		WEAPON_HELL_KNIGHT = new ArrayList<>();
        for (final String listid : FAKE_WEAPON_HELL_KNIGHT.split(",")) {
        	WEAPON_HELL_KNIGHT.add(Integer.parseInt(listid));
        }

		FAKE_WEAPON_TITAN = WeaponFakePlayer.getProperty("WEAPON_TITAN", "0");
		WEAPON_TITAN = new ArrayList<>();
        for (final String listid : FAKE_WEAPON_TITAN.split(",")) {
        	WEAPON_TITAN.add(Integer.parseInt(listid));
        }

		FAKE_WEAPON_SAGGITARIUS = WeaponFakePlayer.getProperty("WEAPON_SAGGITARIUS", "0");
		WEAPON_SAGGITARIUS = new ArrayList<>();
        for (final String listid : FAKE_WEAPON_SAGGITARIUS.split(",")) {
        	WEAPON_SAGGITARIUS.add(Integer.parseInt(listid));
        }

		FAKE_WEAPON_WIND_RIDER = WeaponFakePlayer.getProperty("WEAPON_WIND_RIDER", "0");
		WEAPON_WIND_RIDER = new ArrayList<>();
        for (final String listid : FAKE_WEAPON_WIND_RIDER.split(",")) {
        	WEAPON_WIND_RIDER.add(Integer.parseInt(listid));
        }

		FAKE_WEAPON_GRAND_KHAVATARI = WeaponFakePlayer.getProperty("WEAPON_GRAND_KHAVATARI", "0");
		WEAPON_GRAND_KHAVATARI = new ArrayList<>();
        for (final String listid : FAKE_WEAPON_GRAND_KHAVATARI.split(",")) {
        	WEAPON_GRAND_KHAVATARI.add(Integer.parseInt(listid));
        }

		FAKE_WEAPON_STORM_SCREAMER = WeaponFakePlayer.getProperty("WEAPON_STORM_SCREAMER", "0");
		WEAPON_STORM_SCREAMER = new ArrayList<>();
        for (final String listid : FAKE_WEAPON_STORM_SCREAMER.split(",")) {
        	WEAPON_STORM_SCREAMER.add(Integer.parseInt(listid));
        }

		FAKE_WEAPON_EVAS_SAINT = WeaponFakePlayer.getProperty("WEAPON_EVAS_SAINT", "0");
		WEAPON_EVAS_SAINT = new ArrayList<>();
        for (final String listid : FAKE_WEAPON_EVAS_SAINT.split(",")) {
        	WEAPON_EVAS_SAINT.add(Integer.parseInt(listid));
        }

		FAKE_WEAPON_SPECTRAL_MASTER = WeaponFakePlayer.getProperty("WEAPON_SPECTRAL_MASTER", "0");
		WEAPON_SPECTRAL_MASTER = new ArrayList<>();
        for (final String listid : FAKE_WEAPON_SPECTRAL_MASTER.split(",")) {
        	WEAPON_SPECTRAL_MASTER.add(Integer.parseInt(listid));
        }

		FAKE_WEAPON_SHILLIEN_SAINT = WeaponFakePlayer.getProperty("WEAPON_SHILLIEN_SAINT", "0");
		WEAPON_SHILLIEN_SAINT = new ArrayList<>();
        for (final String listid : FAKE_WEAPON_SHILLIEN_SAINT.split(",")) {
        	WEAPON_SHILLIEN_SAINT.add(Integer.parseInt(listid));
        }

		FAKE_WEAPON_DREADNOUGHT = WeaponFakePlayer.getProperty("WEAPON_DREADNOUGHT", "0");
		WEAPON_DREADNOUGHT = new ArrayList<>();
        for (final String listid : FAKE_WEAPON_DREADNOUGHT.split(",")) {
        	WEAPON_DREADNOUGHT.add(Integer.parseInt(listid));
        }

		FAKE_WEAPON_PHOENIX_KNIGHT = WeaponFakePlayer.getProperty("WEAPON_PHOENIX_KNIGHT", "0");
		WEAPON_PHOENIX_KNIGHT = new ArrayList<>();
        for (final String listid : FAKE_WEAPON_PHOENIX_KNIGHT.split(",")) {
        	WEAPON_PHOENIX_KNIGHT.add(Integer.parseInt(listid));
        }

		FAKE_WEAPON_SWORD_MUSE = WeaponFakePlayer.getProperty("WEAPON_SWORD_MUSE", "0");
		WEAPON_SWORD_MUSE = new ArrayList<>();
        for (final String listid : FAKE_WEAPON_SWORD_MUSE.split(",")) {
        	WEAPON_SWORD_MUSE.add(Integer.parseInt(listid));
        }

		FAKE_WEAPON_SPECTRAL_DANCER = WeaponFakePlayer.getProperty("WEAPON_SPECTRAL_DANCER", "0");
		WEAPON_SPECTRAL_DANCER = new ArrayList<>();
        for (final String listid : FAKE_WEAPON_SPECTRAL_DANCER.split(",")) {
        	WEAPON_SPECTRAL_DANCER.add(Integer.parseInt(listid));
        }

		FAKE_WEAPON_EVAS_TEMPLAR = WeaponFakePlayer.getProperty("WEAPON_EVAS_TEMPLAR", "0");
		WEAPON_EVAS_TEMPLAR = new ArrayList<>();
        for (final String listid : FAKE_WEAPON_EVAS_TEMPLAR.split(",")) {
        	WEAPON_EVAS_TEMPLAR.add(Integer.parseInt(listid));
        }

		FAKE_WEAPON_SHILLIEN_TEMPLAR = WeaponFakePlayer.getProperty("WEAPON_SHILLIEN_TEMPLAR", "0");
		WEAPON_SHILLIEN_TEMPLAR = new ArrayList<>();
        for (final String listid : FAKE_WEAPON_SHILLIEN_TEMPLAR.split(",")) {
        	WEAPON_SHILLIEN_TEMPLAR.add(Integer.parseInt(listid));
        }

		FAKE_WEAPON_MOONLIGHT_SENTINEL = WeaponFakePlayer.getProperty("WEAPON_MOONLIGHT_SENTINEL", "0");
		WEAPON_MOONLIGHT_SENTINEL = new ArrayList<>();
        for (final String listid : FAKE_WEAPON_MOONLIGHT_SENTINEL.split(",")) {
        	WEAPON_MOONLIGHT_SENTINEL.add(Integer.parseInt(listid));
        }

		FAKE_WEAPON_GHOST_HUNTER = WeaponFakePlayer.getProperty("WEAPON_GHOST_HUNTER", "0");
		WEAPON_GHOST_HUNTER = new ArrayList<>();
        for (final String listid : FAKE_WEAPON_GHOST_HUNTER.split(",")) {
        	WEAPON_GHOST_HUNTER.add(Integer.parseInt(listid));
        }

		FAKE_WEAPON_FORTUNE_SEEKER = WeaponFakePlayer.getProperty("WEAPON_FORTUNE_SEEKER", "0");
		WEAPON_FORTUNE_SEEKER = new ArrayList<>();
        for (final String listid : FAKE_WEAPON_FORTUNE_SEEKER.split(",")) {
        	WEAPON_FORTUNE_SEEKER.add(Integer.parseInt(listid));
        }


	}


		private static final void loadOff()
		{
			final ExProperties offlineshop = initProperties(Config.OFFLINEMOD);
			OFFLINE_TRADE_ENABLE = offlineshop.getProperty("OfflineTradeEnable", false);
			OFFLINE_CRAFT_ENABLE = offlineshop.getProperty("OfflineCraftEnable", false);
			OFFLINE_MODE_IN_PEACE_ZONE = offlineshop.getProperty("OfflineModeInPeaceZone", false);
			OFFLINE_MODE_NO_DAMAGE = offlineshop.getProperty("OfflineModeNoDamage", false);
			OFFLINE_SET_SLEEP = offlineshop.getProperty("OfflineSetSleepEffect", false);
			RESTORE_OFFLINERS = offlineshop.getProperty("RestoreOffliners", false);
			OFFLINE_MAX_DAYS = offlineshop.getProperty("OfflineMaxDays", 10);
			OFFLINE_DISCONNECT_FINISHED = offlineshop.getProperty("OfflineDisconnectFinished", true);

		}
	/**
	 * Loads siege settings.
	 */
	private static final void loadSieges()
	{
		final ExProperties sieges = initProperties(Config.SIEGE_FILE);

		SIEGE_LENGTH = sieges.getProperty("SiegeLength", 120);
		MINIMUM_CLAN_LEVEL = sieges.getProperty("SiegeClanMinLevel", 4);
		MAX_ATTACKERS_NUMBER = sieges.getProperty("AttackerMaxClans", 10);
		MAX_DEFENDERS_NUMBER = sieges.getProperty("DefenderMaxClans", 10);
		ATTACKERS_RESPAWN_DELAY = sieges.getProperty("AttackerRespawn", 10000);
	}

	/**
	 * Loads gameserver settings.<br>
	 * IP addresses, database, rates, feature enabled/disabled, misc.
	 */
	private static final void loadServer()
	{
		final ExProperties server = initProperties(SERVER_FILE);

		GAMESERVER_HOSTNAME = server.getProperty("GameserverHostname");
		PORT_GAME = server.getProperty("GameserverPort", 7777);

		HOSTNAME = server.getProperty("Hostname", "*");

		GAME_SERVER_LOGIN_PORT = server.getProperty("LoginPort", 9014);
		GAME_SERVER_LOGIN_HOST = server.getProperty("LoginHost", "127.0.0.1");

		REQUEST_ID = server.getProperty("RequestServerID", 0);
		ACCEPT_ALTERNATE_ID = server.getProperty("AcceptAlternateID", true);

		DATABASE_URL = server.getProperty("URL", "jdbc:mysql://localhost/l2jtesla?serverTimezone=UTC");
		DATABASE_LOGIN = server.getProperty("Login", "root");
		DATABASE_PASSWORD = server.getProperty("Password", "");
		DATABASE_MAX_CONNECTIONS = server.getProperty("MaximumDbConnections", 10);

		SERVER_LIST_BRACKET = server.getProperty("ServerListBrackets", false);
		SERVER_LIST_CLOCK = server.getProperty("ServerListClock", false);
		SERVER_GMONLY = server.getProperty("ServerGMOnly", false);
		SERVER_LIST_AGE = server.getProperty("ServerListAgeLimit", 0);
		SERVER_LIST_TESTSERVER = server.getProperty("TestServer", false);
		SERVER_LIST_PVPSERVER = server.getProperty("PvpServer", true);

		DELETE_DAYS = server.getProperty("DeleteCharAfterDays", 7);
		MAXIMUM_ONLINE_USERS = server.getProperty("MaximumOnlineUsers", 100);

		AUTO_LOOT = server.getProperty("AutoLoot", false);
		AUTO_LOOT_HERBS = server.getProperty("AutoLootHerbs", false);
		AUTO_LOOT_RAID = server.getProperty("AutoLootRaid", false);

		ALLOW_DISCARDITEM = server.getProperty("AllowDiscardItem", true);
		MULTIPLE_ITEM_DROP = server.getProperty("MultipleItemDrop", true);
		HERB_AUTO_DESTROY_TIME = server.getProperty("AutoDestroyHerbTime", 15) * 1000;
		ITEM_AUTO_DESTROY_TIME = server.getProperty("AutoDestroyItemTime", 600) * 1000;
		EQUIPABLE_ITEM_AUTO_DESTROY_TIME = server.getProperty("AutoDestroyEquipableItemTime", 0) * 1000;
		SPECIAL_ITEM_DESTROY_TIME = new HashMap<>();
		String[] data = server.getProperty("AutoDestroySpecialItemTime", (String[]) null, ",");
		if (data != null)
		{
			for (String itemData : data)
			{
				String[] item = itemData.split("-");
				SPECIAL_ITEM_DESTROY_TIME.put(Integer.parseInt(item[0]), Integer.parseInt(item[1]) * 1000);
			}
		}
		PLAYER_DROPPED_ITEM_MULTIPLIER = server.getProperty("PlayerDroppedItemMultiplier", 1);

		RATE_XP = server.getProperty("RateXp", 1.);
		RATE_SP = server.getProperty("RateSp", 1.);
		RATE_PARTY_XP = server.getProperty("RatePartyXp", 1.);
		RATE_PARTY_SP = server.getProperty("RatePartySp", 1.);
		RATE_DROP_ADENA = server.getProperty("RateDropAdena", 1.);
		RATE_DROP_ITEMS = server.getProperty("RateDropItems", 1.);
		RATE_DROP_ITEMS_BY_RAID = server.getProperty("RateRaidDropItems", 1.);
		RATE_DROP_SPOIL = server.getProperty("RateDropSpoil", 1.);
		RATE_DROP_MANOR = server.getProperty("RateDropManor", 1);
		RATE_QUEST_DROP = server.getProperty("RateQuestDrop", 1.);
		RATE_QUEST_REWARD = server.getProperty("RateQuestReward", 1.);
		RATE_QUEST_REWARD_XP = server.getProperty("RateQuestRewardXP", 1.);
		RATE_QUEST_REWARD_SP = server.getProperty("RateQuestRewardSP", 1.);
		RATE_QUEST_REWARD_ADENA = server.getProperty("RateQuestRewardAdena", 1.);
		RATE_KARMA_EXP_LOST = server.getProperty("RateKarmaExpLost", 1.);
		RATE_SIEGE_GUARDS_PRICE = server.getProperty("RateSiegeGuardsPrice", 1.);
		RATE_DROP_COMMON_HERBS = server.getProperty("RateCommonHerbs", 1.);
		RATE_DROP_HP_HERBS = server.getProperty("RateHpHerbs", 1.);
		RATE_DROP_MP_HERBS = server.getProperty("RateMpHerbs", 1.);
		RATE_DROP_SPECIAL_HERBS = server.getProperty("RateSpecialHerbs", 1.);
		PLAYER_DROP_LIMIT = server.getProperty("PlayerDropLimit", 3);
		PLAYER_RATE_DROP = server.getProperty("PlayerRateDrop", 5);
		PLAYER_RATE_DROP_ITEM = server.getProperty("PlayerRateDropItem", 70);
		PLAYER_RATE_DROP_EQUIP = server.getProperty("PlayerRateDropEquip", 25);
		PLAYER_RATE_DROP_EQUIP_WEAPON = server.getProperty("PlayerRateDropEquipWeapon", 5);
		PET_XP_RATE = server.getProperty("PetXpRate", 1.);
		PET_FOOD_RATE = server.getProperty("PetFoodRate", 1);
		SINEATER_XP_RATE = server.getProperty("SinEaterXpRate", 1.);
		KARMA_DROP_LIMIT = server.getProperty("KarmaDropLimit", 10);
		KARMA_RATE_DROP = server.getProperty("KarmaRateDrop", 70);
		KARMA_RATE_DROP_ITEM = server.getProperty("KarmaRateDropItem", 50);
		KARMA_RATE_DROP_EQUIP = server.getProperty("KarmaRateDropEquip", 40);
		KARMA_RATE_DROP_EQUIP_WEAPON = server.getProperty("KarmaRateDropEquipWeapon", 10);

		ALLOW_FREIGHT = server.getProperty("AllowFreight", true);
		ALLOW_WAREHOUSE = server.getProperty("AllowWarehouse", true);
		ALLOW_WEAR = server.getProperty("AllowWear", true);
		WEAR_DELAY = server.getProperty("WearDelay", 5);
		WEAR_PRICE = server.getProperty("WearPrice", 10);
		ALLOW_LOTTERY = server.getProperty("AllowLottery", true);
		ALLOW_WATER = server.getProperty("AllowWater", true);
		ALLOW_MANOR = server.getProperty("AllowManor", true);
		ALLOW_BOAT = server.getProperty("AllowBoat", true);
		ALLOW_CURSED_WEAPONS = server.getProperty("AllowCursedWeapons", true);

		ENABLE_FALLING_DAMAGE = server.getProperty("EnableFallingDamage", true);

		ALT_DEV_NO_SPAWNS = server.getProperty("NoSpawns", false);
		DEVELOPER = server.getProperty("Developer", false);
		PACKET_HANDLER_DEBUG = server.getProperty("PacketHandlerDebug", false);
		DEBUG_MOVEMENT = server.getProperty("DebugMovement", 0) * 1000;

		DEADLOCK_DETECTOR = server.getProperty("DeadLockDetector", false);
		DEADLOCK_CHECK_INTERVAL = server.getProperty("DeadLockCheckInterval", 20);
		RESTART_ON_DEADLOCK = server.getProperty("RestartOnDeadlock", false);

		LOG_CHAT = server.getProperty("LogChat", false);
		LOG_ITEMS = server.getProperty("LogItems", false);
		GMAUDIT = server.getProperty("GMAudit", false);

		ENABLE_COMMUNITY_BOARD = server.getProperty("EnableCommunityBoard", false);
		BBS_DEFAULT = server.getProperty("BBSDefault", "_bbshome");

		ROLL_DICE_TIME = server.getProperty("RollDiceTime", 4200);
		HERO_VOICE_TIME = server.getProperty("HeroVoiceTime", 10000);
		SUBCLASS_TIME = server.getProperty("SubclassTime", 2000);
		DROP_ITEM_TIME = server.getProperty("DropItemTime", 1000);
		SERVER_BYPASS_TIME = server.getProperty("ServerBypassTime", 500);
		MULTISELL_TIME = server.getProperty("MultisellTime", 100);
		MANUFACTURE_TIME = server.getProperty("ManufactureTime", 300);
		MANOR_TIME = server.getProperty("ManorTime", 3000);
		SENDMAIL_TIME = server.getProperty("SendMailTime", 10000);
		CHARACTER_SELECT_TIME = server.getProperty("CharacterSelectTime", 3000);
		GLOBAL_CHAT_TIME = server.getProperty("GlobalChatTime", 0);
		TRADE_CHAT_TIME = server.getProperty("TradeChatTime", 0);
		SOCIAL_TIME = server.getProperty("SocialTime", 2000);

		SCHEDULED_THREAD_POOL_COUNT = server.getProperty("ScheduledThreadPoolCount", -1);
		THREADS_PER_SCHEDULED_THREAD_POOL = server.getProperty("ThreadsPerScheduledThreadPool", 4);
		INSTANT_THREAD_POOL_COUNT = server.getProperty("InstantThreadPoolCount", -1);
		THREADS_PER_INSTANT_THREAD_POOL = server.getProperty("ThreadsPerInstantThreadPool", 2);

		L2WALKER_PROTECTION = server.getProperty("L2WalkerProtection", false);
		ZONE_TOWN = server.getProperty("ZoneTown", 0);
		SERVER_NEWS = server.getProperty("ShowServerNews", false);
		DISABLE_TUTORIAL = server.getProperty("DisableTutorial", false);
	}

	/**
	 * Loads loginserver settings.<br>
	 * IP addresses, database, account, misc.
	 */
	private static final void loadLogin()
	{
		final ExProperties server = initProperties(LOGIN_CONFIGURATION_FILE);
		HOSTNAME = server.getProperty("Hostname", "localhost");

		LOGIN_BIND_ADDRESS = server.getProperty("LoginserverHostname", "*");
		PORT_LOGIN = server.getProperty("LoginserverPort", 2106);

		GAME_SERVER_LOGIN_HOST = server.getProperty("LoginHostname", "*");
		GAME_SERVER_LOGIN_PORT = server.getProperty("LoginPort", 9014);

		LOGIN_TRY_BEFORE_BAN = server.getProperty("LoginTryBeforeBan", 3);
		LOGIN_BLOCK_AFTER_BAN = server.getProperty("LoginBlockAfterBan", 600);
		ACCEPT_NEW_GAMESERVER = server.getProperty("AcceptNewGameServer", false);

		SHOW_LICENCE = server.getProperty("ShowLicence", true);

		DATABASE_URL = server.getProperty("URL", "jdbc:mysql://localhost/l2jtesla?serverTimezone=UTC");
		DATABASE_LOGIN = server.getProperty("Login", "root");
		DATABASE_PASSWORD = server.getProperty("Password", "");
		DATABASE_MAX_CONNECTIONS = server.getProperty("MaximumDbConnections", 10);

		AUTO_CREATE_ACCOUNTS = server.getProperty("AutoCreateAccounts", true);

		LOG_LOGIN_CONTROLLER = server.getProperty("LogLoginController", false);

		FLOOD_PROTECTION = server.getProperty("EnableFloodProtection", true);
		FAST_CONNECTION_LIMIT = server.getProperty("FastConnectionLimit", 15);
		NORMAL_CONNECTION_TIME = server.getProperty("NormalConnectionTime", 700);
		FAST_CONNECTION_TIME = server.getProperty("FastConnectionTime", 350);
		MAX_CONNECTION_PER_IP = server.getProperty("MaxConnectionPerIP", 50);

		var hashingMethod = server.getProperty("PasswordHashMethod", "SHA1");

		if(!hashingMethod.equalsIgnoreCase("SHA1") && !hashingMethod.equalsIgnoreCase("bcrypt")) {
			LOGGER.error("PasswordHashMethod needs to be either SHA1 or bcrypt. Falling back to SHA1");
			PASSWORD_HASH_METHOD = "SHA1";
		} else {
			PASSWORD_HASH_METHOD = hashingMethod;
		}
	}

	public static final void loadGameServer()
	{
		LOGGER.info("Loading gameserver configuration files.");

		// clans settings
		loadClans();

		// events settings
		loadEvents();

		// geoengine settings
		loadGeoengine();

		// hexID
		loadHexID();

		// NPCs/monsters settings
		loadNpcs();

		// players settings
		loadPlayers();

		// siege settings
		loadSieges();

		// OffShop settings
		loadOff();

		// server settings
		loadServer();

		loadWeapon();
		loadArmor1();
		loadFakePlayer();
		loadNewChar();
	}

	public static final void loadLoginServer()
	{
		LOGGER.info("Loading loginserver configuration files.");

		// login settings
		loadLogin();
	}

	public static final void loadAccountManager()
	{
		LOGGER.info("Loading account manager configuration files.");

		// login settings
		loadLogin();
	}

	public static final void loadGameServerRegistration()
	{
		LOGGER.info("Loading gameserver registration configuration files.");

		// login settings
		loadLogin();
	}

	public static final void loadGeodataConverter()
	{
		LOGGER.info("Loading geodata converter configuration files.");

		// geoengine settings
		loadGeoengine();
	}

	public static final class ClassMasterSettings
	{
		private final Map<Integer, Boolean> _allowedClassChange;
		private final Map<Integer, List<IntIntHolder>> _claimItems;
		private final Map<Integer, List<IntIntHolder>> _rewardItems;

		public ClassMasterSettings(String configLine)
		{
			_allowedClassChange = new HashMap<>(3);
			_claimItems = new HashMap<>(3);
			_rewardItems = new HashMap<>(3);

			if (configLine != null)
				parseConfigLine(configLine.trim());
		}

		private void parseConfigLine(String configLine)
		{
			StringTokenizer st = new StringTokenizer(configLine, ";");
			while (st.hasMoreTokens())
			{
				// Get allowed class change.
				int job = Integer.parseInt(st.nextToken());

				_allowedClassChange.put(job, true);

				List<IntIntHolder> items = new ArrayList<>();

				// Parse items needed for class change.
				if (st.hasMoreTokens())
				{
					StringTokenizer st2 = new StringTokenizer(st.nextToken(), "[],");
					while (st2.hasMoreTokens())
					{
						StringTokenizer st3 = new StringTokenizer(st2.nextToken(), "()");
						items.add(new IntIntHolder(Integer.parseInt(st3.nextToken()), Integer.parseInt(st3.nextToken())));
					}
				}

				// Feed the map, and clean the list.
				_claimItems.put(job, items);
				items = new ArrayList<>();

				// Parse gifts after class change.
				if (st.hasMoreTokens())
				{
					StringTokenizer st2 = new StringTokenizer(st.nextToken(), "[],");
					while (st2.hasMoreTokens())
					{
						StringTokenizer st3 = new StringTokenizer(st2.nextToken(), "()");
						items.add(new IntIntHolder(Integer.parseInt(st3.nextToken()), Integer.parseInt(st3.nextToken())));
					}
				}

				_rewardItems.put(job, items);
			}
		}

		public boolean isAllowed(int job)
		{
			if (_allowedClassChange == null)
				return false;

			if (_allowedClassChange.containsKey(job))
				return _allowedClassChange.get(job);

			return false;
		}

		public List<IntIntHolder> getRewardItems(int job)
		{
			return _rewardItems.get(job);
		}

		public List<IntIntHolder> getRequiredItems(int job)
		{
			return _claimItems.get(job);
		}
	}
}