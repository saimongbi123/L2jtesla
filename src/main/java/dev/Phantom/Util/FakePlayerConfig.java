package dev.Phantom.Util;

import dev.l2j.tesla.commons.config.ExProperties;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class FakePlayerConfig {

	protected static final Logger _log = Logger.getLogger(FakePlayerConfig.class.getName());

	public static final String PHANTOM_FILE = "./config/aCis/Phantom.properties";

	public static boolean Active_GS_FAKEPLAYER;
	public static int PHANTOM_PRIVATE_BUY_CHANCE;
	public static int PHANTOM_PRIVATE_SELL_CHANCE;

	public static List<int[]> STARTING_PHANTOM_ITEMS = new ArrayList<>();

	public static String PHANTOM_PRIVATE_BUY_TITLE_MSG;
	public static List<String> PHANTOM_PRIVATE_BUY_TITLE = new ArrayList<>();

	public static String PHANTOM_PRIVATE_BUY;
	public static List<Integer> LIST_PRIVATE_BUY;

	public static String PHANTOM_PRIVATE_SELL_TITLE_MSG;
	public static List<String> PHANTOM_PRIVATE_SELL_TITLE = new ArrayList<>();

	public static String PHANTOM_PRIVATE_SELL;
	public static List<Integer> LIST_PRIVATE_SELL;
	// Clan
	public static String CLAN_ID;
	public static List<Integer> LIST_CLAN_ID;

	// Trade
	public static String ARMOR_TRADE_ID;
	public static List<Integer> LIST_ARMOR_TRADE_ID;

	public static String WEAPON_TRADE_ID;
	public static List<Integer> LIST_WEAPON_TRADE_ID;

	public static String JEWEL_TRADE_ID;
	public static List<Integer> LIST_JEWEL_TRADE_ID;

	public static String ETC_TRADE_ID;
	public static List<Integer> LIST_ETC_TRADE_ID;

	// Enchant
	public static int MIN_ENCHANT_ARMOR;
	public static int MAX_ENCHANT_ARMOR;

	public static int MIN_ENCHANT_WEAPON;
	public static int MAX_ENCHANT_WEAPON;

	public static int MIN_ENCHANT_JEWEL;
	public static int MAX_ENCHANT_JEWEL;

	// Armors Robe
	public static String PHANTOM_ROB_ARMOR_1;
	public static List<Integer> LIST_PHANTOM_ROB_ARMOR_1 = new ArrayList<>();

	public static String PHANTOM_ROB_ARMOR_2;
	public static List<Integer> LIST_PHANTOM_ROB_ARMOR_2 = new ArrayList<>();

	public static String PHANTOM_ROB_ARMOR_3;
	public static List<Integer> LIST_PHANTOM_ROB_ARMOR_3 = new ArrayList<>();

	public static String PHANTOM_ROB_ARMOR_4;
	public static List<Integer> LIST_PHANTOM_ROB_ARMOR_4 = new ArrayList<>();

	public static String PHANTOM_ROB_ARMOR_5;
	public static List<Integer> LIST_PHANTOM_ROB_ARMOR_5 = new ArrayList<>();

	public static String PHANTOM_ROB_ARMOR_6;
	public static List<Integer> LIST_PHANTOM_ROB_ARMOR_6 = new ArrayList<>();

	public static String PHANTOM_ROB_ARMOR_7;
	public static List<Integer> LIST_PHANTOM_ROB_ARMOR_7 = new ArrayList<>();

	public static String PHANTOM_ROB_ARMOR_8;
	public static List<Integer> LIST_PHANTOM_ROB_ARMOR_8 = new ArrayList<>();

	public static String PHANTOM_ROB_ARMOR_9;
	public static List<Integer> LIST_PHANTOM_ROB_ARMOR_9 = new ArrayList<>();

	public static String PHANTOM_ROB_ARMOR_10;
	public static List<Integer> LIST_PHANTOM_ROB_ARMOR_10 = new ArrayList<>();

	public static String PHANTOM_ROB_ARMOR_11;
	public static List<Integer> LIST_PHANTOM_ROB_ARMOR_11 = new ArrayList<>();

	public static String PHANTOM_ROB_ARMOR_12;
	public static List<Integer> LIST_PHANTOM_ROB_ARMOR_12 = new ArrayList<>();

	public static String PHANTOM_ROB_ARMOR_13;
	public static List<Integer> LIST_PHANTOM_ROB_ARMOR_13 = new ArrayList<>();

	public static String PHANTOM_ROB_ARMOR_14;
	public static List<Integer> LIST_PHANTOM_ROB_ARMOR_14 = new ArrayList<>();

	public static String PHANTOM_ROB_ARMOR_15;
	public static List<Integer> LIST_PHANTOM_ROB_ARMOR_15 = new ArrayList<>();



	// Armors Heavy
	public static String PHANTOM_HEAVY_ARMOR_1;
	public static List<Integer> LIST_PHANTOM_HEAVY_ARMOR_1 = new ArrayList<>();

	public static String PHANTOM_HEAVY_ARMOR_2;
	public static List<Integer> LIST_PHANTOM_HEAVY_ARMOR_2 = new ArrayList<>();

	public static String PHANTOM_HEAVY_ARMOR_3;
	public static List<Integer> LIST_PHANTOM_HEAVY_ARMOR_3 = new ArrayList<>();

	public static String PHANTOM_HEAVY_ARMOR_4;
	public static List<Integer> LIST_PHANTOM_HEAVY_ARMOR_4 = new ArrayList<>();

	public static String PHANTOM_HEAVY_ARMOR_5;
	public static List<Integer> LIST_PHANTOM_HEAVY_ARMOR_5 = new ArrayList<>();

	public static String PHANTOM_HEAVY_ARMOR_6;
	public static List<Integer> LIST_PHANTOM_HEAVY_ARMOR_6 = new ArrayList<>();

	public static String PHANTOM_HEAVY_ARMOR_7;
	public static List<Integer> LIST_PHANTOM_HEAVY_ARMOR_7 = new ArrayList<>();

	public static String PHANTOM_HEAVY_ARMOR_8;
	public static List<Integer> LIST_PHANTOM_HEAVY_ARMOR_8 = new ArrayList<>();

	public static String PHANTOM_HEAVY_ARMOR_9;
	public static List<Integer> LIST_PHANTOM_HEAVY_ARMOR_9 = new ArrayList<>();

	public static String PHANTOM_HEAVY_ARMOR_10;
	public static List<Integer> LIST_PHANTOM_HEAVY_ARMOR_10 = new ArrayList<>();

	public static String PHANTOM_HEAVY_ARMOR_11;
	public static List<Integer> LIST_PHANTOM_HEAVY_ARMOR_11 = new ArrayList<>();

	public static String PHANTOM_HEAVY_ARMOR_12;
	public static List<Integer> LIST_PHANTOM_HEAVY_ARMOR_12 = new ArrayList<>();

	public static String PHANTOM_HEAVY_ARMOR_13;
	public static List<Integer> LIST_PHANTOM_HEAVY_ARMOR_13 = new ArrayList<>();

	public static String PHANTOM_HEAVY_ARMOR_14;
	public static List<Integer> LIST_PHANTOM_HEAVY_ARMOR_14 = new ArrayList<>();

	public static String PHANTOM_HEAVY_ARMOR_15;
	public static List<Integer> LIST_PHANTOM_HEAVY_ARMOR_15 = new ArrayList<>();

	public static String PHANTOM_HEAVY_ARMOR_16;
	public static List<Integer> LIST_PHANTOM_HEAVY_ARMOR_16 = new ArrayList<>();

	public static String PHANTOM_HEAVY_ARMOR_17;
	public static List<Integer> LIST_PHANTOM_HEAVY_ARMOR_17 = new ArrayList<>();

	public static String PHANTOM_HEAVY_ARMOR_18;
	public static List<Integer> LIST_PHANTOM_HEAVY_ARMOR_18 = new ArrayList<>();

	public static String PHANTOM_HEAVY_ARMOR_19;
	public static List<Integer> LIST_PHANTOM_HEAVY_ARMOR_19 = new ArrayList<>();

	public static String PHANTOM_HEAVY_ARMOR_20;
	public static List<Integer> LIST_PHANTOM_HEAVY_ARMOR_20 = new ArrayList<>();

	// Armors Light
	public static String PHANTOM_LIGHT_ARMOR_1;
	public static List<Integer> LIST_PHANTOM_LIGHT_ARMOR_1 = new ArrayList<>();

	public static String PHANTOM_LIGHT_ARMOR_2;
	public static List<Integer> LIST_PHANTOM_LIGHT_ARMOR_2 = new ArrayList<>();

	public static String PHANTOM_LIGHT_ARMOR_3;
	public static List<Integer> LIST_PHANTOM_LIGHT_ARMOR_3 = new ArrayList<>();

	public static String PHANTOM_LIGHT_ARMOR_4;
	public static List<Integer> LIST_PHANTOM_LIGHT_ARMOR_4 = new ArrayList<>();

	public static String PHANTOM_LIGHT_ARMOR_5;
	public static List<Integer> LIST_PHANTOM_LIGHT_ARMOR_5 = new ArrayList<>();

	public static String PHANTOM_LIGHT_ARMOR_6;
	public static List<Integer> LIST_PHANTOM_LIGHT_ARMOR_6 = new ArrayList<>();

	public static String PHANTOM_LIGHT_ARMOR_7;
	public static List<Integer> LIST_PHANTOM_LIGHT_ARMOR_7 = new ArrayList<>();

	public static String PHANTOM_LIGHT_ARMOR_8;
	public static List<Integer> LIST_PHANTOM_LIGHT_ARMOR_8 = new ArrayList<>();

	public static String PHANTOM_LIGHT_ARMOR_9;
	public static List<Integer> LIST_PHANTOM_LIGHT_ARMOR_9 = new ArrayList<>();

	public static String PHANTOM_LIGHT_ARMOR_10;
	public static List<Integer> LIST_PHANTOM_LIGHT_ARMOR_10 = new ArrayList<>();

	public static String PHANTOM_LIGHT_ARMOR_11;
	public static List<Integer> LIST_PHANTOM_LIGHT_ARMOR_11 = new ArrayList<>();

	public static String PHANTOM_LIGHT_ARMOR_12;
	public static List<Integer> LIST_PHANTOM_LIGHT_ARMOR_12 = new ArrayList<>();

	public static String PHANTOM_LIGHT_ARMOR_13;
	public static List<Integer> LIST_PHANTOM_LIGHT_ARMOR_13 = new ArrayList<>();

	public static String PHANTOM_LIGHT_ARMOR_14;
	public static List<Integer> LIST_PHANTOM_LIGHT_ARMOR_14 = new ArrayList<>();

	public static String PHANTOM_LIGHT_ARMOR_15;
	public static List<Integer> LIST_PHANTOM_LIGHT_ARMOR_15 = new ArrayList<>();

	public static String PHANTOM_LIGHT_ARMOR_16;
	public static List<Integer> LIST_PHANTOM_LIGHT_ARMOR_16 = new ArrayList<>();

	public static String PHANTOM_LIGHT_ARMOR_17;
	public static List<Integer> LIST_PHANTOM_LIGHT_ARMOR_17 = new ArrayList<>();

	public static String PHANTOM_LIGHT_ARMOR_18;
	public static List<Integer> LIST_PHANTOM_LIGHT_ARMOR_18 = new ArrayList<>();

	public static String PHANTOM_LIGHT_ARMOR_19;
	public static List<Integer> LIST_PHANTOM_LIGHT_ARMOR_19 = new ArrayList<>();

	// BOW
	public static String FAKE_BOW_ID;
	public static List<Integer> LIST_FAKE_BOW;

	// DAGGER
	public static String FAKE_DAGGER_ID;
	public static List<Integer> LIST_FAKE_DAGGER;

	// SWORD
	public static String FAKE_SWORD_ID;
	public static List<Integer> LIST_FAKE_SWORD;

	// SPEAR
	public static String FAKE_SPEAR_ID;
	public static List<Integer> LIST_FAKE_SPEAR;

	// DUAL
	public static String FAKE_DUAL_ID;
	public static List<Integer> LIST_FAKE_DUAL;

	// FIST
	public static String FAKE_FIST_ID;
	public static List<Integer> LIST_FAKE_FIST;

	// BIGSWORD
	public static String FAKE_BIGSWORD_ID;
	public static List<Integer> LIST_FAKE_BIG_SWORD;

	// MAGIC
	public static String FAKE_MAGIC_ID;
	public static List<Integer> LIST_FAKE_MAGIC;

	// SHIELD
	public static String FAKE_SHIELD_ID;
	public static List<Integer> LIST_FAKE_SHIELD;

	// JEWELS
	public static int[] PHANTOM_JEWELS_1;
	public static List<int[]> LIST_PHANTOM_JEWELS_1 = new ArrayList<>();

	public static int[] PHANTOM_JEWELS_2;
	public static List<int[]> LIST_PHANTOM_JEWELS_2 = new ArrayList<>();

	// Accessory
	public static boolean ALLOW_FAKE_PLAYERS_ACCESSORY;
	public static String FAKE_ACCESSORY_ID;
	public static List<Integer> LIST_FAKE_ACCESSORY;

	// Buffer
	public static String NUKER_BUFFER;
	public static List<Integer> NUKER_BUFFER_LIST = new ArrayList<>();

	public static String ARCHER_BUFFER;
	public static List<Integer> ARCHER_BUFFER_LIST = new ArrayList<>();

	public static String WARRIOR_BUFFER;
	public static List<Integer> WARRIOR_BUFFER_LIST = new ArrayList<>();

	public static String DAGGER_BUFFER;
	public static List<Integer> DAGGER_BUFFER_LIST = new ArrayList<>();

	public static String RANDOM_BUFFER;
	public static List<Integer> RANDOM_BUFFER_LIST = new ArrayList<>();

	public static void init() {
		ExProperties phantom = load(PHANTOM_FILE);

		// Clan
		CLAN_ID = phantom.getProperty("FakeClanIDList", "");
		LIST_CLAN_ID = new ArrayList<>();
		for (String itemId : CLAN_ID.split(",")) {
			LIST_CLAN_ID.add(Integer.parseInt(itemId));
		}

		// Trade
		ARMOR_TRADE_ID = phantom.getProperty("FakeTradeArmorIDList", "");
		LIST_ARMOR_TRADE_ID = new ArrayList<>();
		for (String itemId : ARMOR_TRADE_ID.split(",")) {
			LIST_ARMOR_TRADE_ID.add(Integer.parseInt(itemId));
		}

		WEAPON_TRADE_ID = phantom.getProperty("FakeTradeWeaponIDList", "");
		LIST_WEAPON_TRADE_ID = new ArrayList<>();
		for (String itemId : WEAPON_TRADE_ID.split(",")) {
			LIST_WEAPON_TRADE_ID.add(Integer.parseInt(itemId));
		}

		JEWEL_TRADE_ID = phantom.getProperty("FakeTradeJewelIDList", "");
		LIST_JEWEL_TRADE_ID = new ArrayList<>();
		for (String itemId : JEWEL_TRADE_ID.split(",")) {
			LIST_JEWEL_TRADE_ID.add(Integer.parseInt(itemId));
		}

		ETC_TRADE_ID = phantom.getProperty("FakeTradeEtcIDList", "");
		LIST_ETC_TRADE_ID = new ArrayList<>();
		for (String itemId : ETC_TRADE_ID.split(",")) {
			LIST_ETC_TRADE_ID.add(Integer.parseInt(itemId));
		}

		// Enchant
		MIN_ENCHANT_ARMOR = phantom.getProperty("MinEnchantAmor", 0);
		MAX_ENCHANT_ARMOR = phantom.getProperty("MaxEnchantAmor", 0);

		MIN_ENCHANT_WEAPON = phantom.getProperty("MinEnchantWeapon", 0);
		MAX_ENCHANT_WEAPON = phantom.getProperty("MaxEnchantWeapon", 0);

		MIN_ENCHANT_JEWEL = phantom.getProperty("MinEnchantJewel", 0);
		MAX_ENCHANT_JEWEL = phantom.getProperty("MaxEnchantJewel", 0);

		// Armors Robe
		PHANTOM_ROB_ARMOR_1 = phantom.getProperty("ListRobeArmor1", "0");
		LIST_PHANTOM_ROB_ARMOR_1 = new ArrayList<>();
		for (String listid : PHANTOM_ROB_ARMOR_1.split(",")) {
			LIST_PHANTOM_ROB_ARMOR_1.add(Integer.parseInt(listid));
		}

		PHANTOM_ROB_ARMOR_2 = phantom.getProperty("ListRobeArmor2", "0");
		LIST_PHANTOM_ROB_ARMOR_2 = new ArrayList<>();
		for (String listid : PHANTOM_ROB_ARMOR_2.split(",")) {
			LIST_PHANTOM_ROB_ARMOR_2.add(Integer.parseInt(listid));
		}

		PHANTOM_ROB_ARMOR_3 = phantom.getProperty("ListRobeArmor3", "0");
		LIST_PHANTOM_ROB_ARMOR_3 = new ArrayList<>();
		for (String listid : PHANTOM_ROB_ARMOR_3.split(",")) {
			LIST_PHANTOM_ROB_ARMOR_3.add(Integer.parseInt(listid));
		}

		PHANTOM_ROB_ARMOR_4 = phantom.getProperty("ListRobeArmor4", "0");
		LIST_PHANTOM_ROB_ARMOR_4 = new ArrayList<>();
		for (String listid : PHANTOM_ROB_ARMOR_4.split(",")) {
			LIST_PHANTOM_ROB_ARMOR_4.add(Integer.parseInt(listid));
		}
		PHANTOM_ROB_ARMOR_5 = phantom.getProperty("ListRobeArmor5", "0");
		LIST_PHANTOM_ROB_ARMOR_5 = new ArrayList<>();
		for (String listid : PHANTOM_ROB_ARMOR_5.split(",")) {
			LIST_PHANTOM_ROB_ARMOR_5.add(Integer.parseInt(listid));
		}

		PHANTOM_ROB_ARMOR_6 = phantom.getProperty("ListRobeArmor6", "0");
		LIST_PHANTOM_ROB_ARMOR_6 = new ArrayList<>();
		for (String listid : PHANTOM_ROB_ARMOR_6.split(",")) {
			LIST_PHANTOM_ROB_ARMOR_6.add(Integer.parseInt(listid));
		}

		PHANTOM_ROB_ARMOR_7 = phantom.getProperty("ListRobeArmor7", "0");
		LIST_PHANTOM_ROB_ARMOR_7 = new ArrayList<>();
		for (String listid : PHANTOM_ROB_ARMOR_7.split(",")) {
			LIST_PHANTOM_ROB_ARMOR_7.add(Integer.parseInt(listid));
		}

		PHANTOM_ROB_ARMOR_8 = phantom.getProperty("ListRobeArmor8", "0");
		LIST_PHANTOM_ROB_ARMOR_8 = new ArrayList<>();
		for (String listid : PHANTOM_ROB_ARMOR_8.split(",")) {
			LIST_PHANTOM_ROB_ARMOR_8.add(Integer.parseInt(listid));
		}

		PHANTOM_ROB_ARMOR_9 = phantom.getProperty("ListRobeArmor9", "0");
		LIST_PHANTOM_ROB_ARMOR_9 = new ArrayList<>();
		for (String listid : PHANTOM_ROB_ARMOR_9.split(",")) {
			LIST_PHANTOM_ROB_ARMOR_9.add(Integer.parseInt(listid));
		}

		PHANTOM_ROB_ARMOR_10 = phantom.getProperty("ListRobeArmor10", "0");
		LIST_PHANTOM_ROB_ARMOR_10 = new ArrayList<>();
		for (String listid : PHANTOM_ROB_ARMOR_10.split(",")) {
			LIST_PHANTOM_ROB_ARMOR_10.add(Integer.parseInt(listid));
		}

		PHANTOM_ROB_ARMOR_11 = phantom.getProperty("ListRobeArmor11", "0");
		LIST_PHANTOM_ROB_ARMOR_11 = new ArrayList<>();
		for (String listid : PHANTOM_ROB_ARMOR_11.split(",")) {
			LIST_PHANTOM_ROB_ARMOR_11.add(Integer.parseInt(listid));
		}

		PHANTOM_ROB_ARMOR_12 = phantom.getProperty("ListRobeArmor12", "0");
		LIST_PHANTOM_ROB_ARMOR_12 = new ArrayList<>();
		for (String listid : PHANTOM_ROB_ARMOR_12.split(",")) {
			LIST_PHANTOM_ROB_ARMOR_12.add(Integer.parseInt(listid));
		}

		PHANTOM_ROB_ARMOR_13 = phantom.getProperty("ListRobeArmor13", "0");
		LIST_PHANTOM_ROB_ARMOR_13 = new ArrayList<>();
		for (String listid : PHANTOM_ROB_ARMOR_13.split(",")) {
			LIST_PHANTOM_ROB_ARMOR_13.add(Integer.parseInt(listid));
		}

		PHANTOM_ROB_ARMOR_14 = phantom.getProperty("ListRobeArmor14", "0");
		LIST_PHANTOM_ROB_ARMOR_14 = new ArrayList<>();
		for (String listid : PHANTOM_ROB_ARMOR_14.split(",")) {
			LIST_PHANTOM_ROB_ARMOR_14.add(Integer.parseInt(listid));
		}

		PHANTOM_ROB_ARMOR_15 = phantom.getProperty("ListRobeArmor15", "0");
		LIST_PHANTOM_ROB_ARMOR_15 = new ArrayList<>();
		for (String listid : PHANTOM_ROB_ARMOR_15.split(",")) {
			LIST_PHANTOM_ROB_ARMOR_15.add(Integer.parseInt(listid));
		}

		// Armors Heavy
		PHANTOM_HEAVY_ARMOR_1 = phantom.getProperty("ListHeavyArmor1", "0");
		LIST_PHANTOM_HEAVY_ARMOR_1 = new ArrayList<>();
		for (String listid : PHANTOM_HEAVY_ARMOR_1.split(",")) {
			LIST_PHANTOM_HEAVY_ARMOR_1.add(Integer.parseInt(listid));
		}
		Active_GS_FAKEPLAYER = phantom.getProperty("EnableFakes", false);

		PHANTOM_HEAVY_ARMOR_2 = phantom.getProperty("ListHeavyArmor2", "0");
		LIST_PHANTOM_HEAVY_ARMOR_2 = new ArrayList<>();
		for (String listid : PHANTOM_HEAVY_ARMOR_2.split(",")) {
			LIST_PHANTOM_HEAVY_ARMOR_2.add(Integer.parseInt(listid));
		}

		PHANTOM_HEAVY_ARMOR_3 = phantom.getProperty("ListHeavyArmor3", "0");
		LIST_PHANTOM_HEAVY_ARMOR_3 = new ArrayList<>();
		for (String listid : PHANTOM_HEAVY_ARMOR_3.split(",")) {
			LIST_PHANTOM_HEAVY_ARMOR_3.add(Integer.parseInt(listid));
		}

		PHANTOM_HEAVY_ARMOR_4 = phantom.getProperty("ListHeavyArmor4", "0");
		LIST_PHANTOM_HEAVY_ARMOR_4 = new ArrayList<>();
		for (String listid : PHANTOM_HEAVY_ARMOR_4.split(",")) {
			LIST_PHANTOM_HEAVY_ARMOR_4.add(Integer.parseInt(listid));
		}

		PHANTOM_HEAVY_ARMOR_5 = phantom.getProperty("ListHeavyArmor5", "0");
		LIST_PHANTOM_HEAVY_ARMOR_5 = new ArrayList<>();
		for (String listid : PHANTOM_HEAVY_ARMOR_5.split(",")) {
			LIST_PHANTOM_HEAVY_ARMOR_5.add(Integer.parseInt(listid));
		}

		PHANTOM_HEAVY_ARMOR_6 = phantom.getProperty("ListHeavyArmor6", "0");
		LIST_PHANTOM_HEAVY_ARMOR_6 = new ArrayList<>();
		for (String listid : PHANTOM_HEAVY_ARMOR_6.split(",")) {
			LIST_PHANTOM_HEAVY_ARMOR_6.add(Integer.parseInt(listid));
		}

		PHANTOM_HEAVY_ARMOR_7 = phantom.getProperty("ListHeavyArmor7", "0");
		LIST_PHANTOM_HEAVY_ARMOR_7 = new ArrayList<>();
		for (String listid : PHANTOM_HEAVY_ARMOR_7.split(",")) {
			LIST_PHANTOM_HEAVY_ARMOR_7.add(Integer.parseInt(listid));
		}

		PHANTOM_HEAVY_ARMOR_8 = phantom.getProperty("ListHeavyArmor8", "0");
		LIST_PHANTOM_HEAVY_ARMOR_8 = new ArrayList<>();
		for (String listid : PHANTOM_HEAVY_ARMOR_8.split(",")) {
			LIST_PHANTOM_HEAVY_ARMOR_8.add(Integer.parseInt(listid));
		}

		PHANTOM_HEAVY_ARMOR_9 = phantom.getProperty("ListHeavyArmor9", "0");
		LIST_PHANTOM_HEAVY_ARMOR_9 = new ArrayList<>();
		for (String listid : PHANTOM_HEAVY_ARMOR_9.split(",")) {
			LIST_PHANTOM_HEAVY_ARMOR_9.add(Integer.parseInt(listid));
		}

		PHANTOM_HEAVY_ARMOR_10 = phantom.getProperty("ListHeavyArmor10", "0");
		LIST_PHANTOM_HEAVY_ARMOR_10 = new ArrayList<>();
		for (String listid : PHANTOM_HEAVY_ARMOR_10.split(",")) {
			LIST_PHANTOM_HEAVY_ARMOR_10.add(Integer.parseInt(listid));
		}

		PHANTOM_HEAVY_ARMOR_11 = phantom.getProperty("ListHeavyArmor11", "0");
		LIST_PHANTOM_HEAVY_ARMOR_11 = new ArrayList<>();
		for (String listid : PHANTOM_HEAVY_ARMOR_11.split(",")) {
			LIST_PHANTOM_HEAVY_ARMOR_11.add(Integer.parseInt(listid));
		}

		PHANTOM_HEAVY_ARMOR_12 = phantom.getProperty("ListHeavyArmor12", "0");
		LIST_PHANTOM_HEAVY_ARMOR_12 = new ArrayList<>();
		for (String listid : PHANTOM_HEAVY_ARMOR_12.split(",")) {
			LIST_PHANTOM_HEAVY_ARMOR_12.add(Integer.parseInt(listid));
		}

		PHANTOM_HEAVY_ARMOR_13 = phantom.getProperty("ListHeavyArmor13", "0");
		LIST_PHANTOM_HEAVY_ARMOR_13 = new ArrayList<>();
		for (String listid : PHANTOM_HEAVY_ARMOR_13.split(",")) {
			LIST_PHANTOM_HEAVY_ARMOR_13.add(Integer.parseInt(listid));
		}

		PHANTOM_HEAVY_ARMOR_14 = phantom.getProperty("ListHeavyArmor14", "0");
		LIST_PHANTOM_HEAVY_ARMOR_14 = new ArrayList<>();
		for (String listid : PHANTOM_HEAVY_ARMOR_14.split(",")) {
			LIST_PHANTOM_HEAVY_ARMOR_14.add(Integer.parseInt(listid));
		}

		PHANTOM_HEAVY_ARMOR_15 = phantom.getProperty("ListHeavyArmor15", "0");
		LIST_PHANTOM_HEAVY_ARMOR_15 = new ArrayList<>();
		for (String listid : PHANTOM_HEAVY_ARMOR_15.split(",")) {
			LIST_PHANTOM_HEAVY_ARMOR_15.add(Integer.parseInt(listid));
		}

		PHANTOM_HEAVY_ARMOR_16 = phantom.getProperty("ListHeavyArmor16", "0");
		LIST_PHANTOM_HEAVY_ARMOR_16 = new ArrayList<>();
		for (String listid : PHANTOM_HEAVY_ARMOR_16.split(",")) {
			LIST_PHANTOM_HEAVY_ARMOR_16.add(Integer.parseInt(listid));
		}

		PHANTOM_HEAVY_ARMOR_17 = phantom.getProperty("ListHeavyArmor17", "0");
		LIST_PHANTOM_HEAVY_ARMOR_17 = new ArrayList<>();
		for (String listid : PHANTOM_HEAVY_ARMOR_17.split(",")) {
			LIST_PHANTOM_HEAVY_ARMOR_17.add(Integer.parseInt(listid));
		}

		PHANTOM_HEAVY_ARMOR_18 = phantom.getProperty("ListHeavyArmor18", "0");
		LIST_PHANTOM_HEAVY_ARMOR_18 = new ArrayList<>();
		for (String listid : PHANTOM_HEAVY_ARMOR_18.split(",")) {
			LIST_PHANTOM_HEAVY_ARMOR_18.add(Integer.parseInt(listid));
		}

		PHANTOM_HEAVY_ARMOR_19 = phantom.getProperty("ListHeavyArmor19", "0");
		LIST_PHANTOM_HEAVY_ARMOR_19 = new ArrayList<>();
		for (String listid : PHANTOM_HEAVY_ARMOR_19.split(",")) {
			LIST_PHANTOM_HEAVY_ARMOR_19.add(Integer.parseInt(listid));
		}

		PHANTOM_HEAVY_ARMOR_20 = phantom.getProperty("ListHeavyArmor20", "0");
		LIST_PHANTOM_HEAVY_ARMOR_20 = new ArrayList<>();
		for (String listid : PHANTOM_HEAVY_ARMOR_20.split(",")) {
			LIST_PHANTOM_HEAVY_ARMOR_20.add(Integer.parseInt(listid));
		}

		// Armors Light
		PHANTOM_LIGHT_ARMOR_1 = phantom.getProperty("ListLightArmor1", "0");
		LIST_PHANTOM_LIGHT_ARMOR_1 = new ArrayList<>();
		for (String listid : PHANTOM_LIGHT_ARMOR_1.split(",")) {
			LIST_PHANTOM_LIGHT_ARMOR_1.add(Integer.parseInt(listid));
		}

		PHANTOM_LIGHT_ARMOR_2 = phantom.getProperty("ListLightArmor2", "0");
		LIST_PHANTOM_LIGHT_ARMOR_2 = new ArrayList<>();
		for (String listid : PHANTOM_LIGHT_ARMOR_2.split(",")) {
			LIST_PHANTOM_LIGHT_ARMOR_2.add(Integer.parseInt(listid));
		}

		PHANTOM_LIGHT_ARMOR_3 = phantom.getProperty("ListLightArmor3", "0");
		LIST_PHANTOM_LIGHT_ARMOR_3 = new ArrayList<>();
		for (String listid : PHANTOM_LIGHT_ARMOR_3.split(",")) {
			LIST_PHANTOM_LIGHT_ARMOR_3.add(Integer.parseInt(listid));
		}

		PHANTOM_LIGHT_ARMOR_4 = phantom.getProperty("ListLightArmor4", "0");
		LIST_PHANTOM_LIGHT_ARMOR_4 = new ArrayList<>();
		for (String listid : PHANTOM_LIGHT_ARMOR_4.split(",")) {
			LIST_PHANTOM_LIGHT_ARMOR_4.add(Integer.parseInt(listid));
		}

		PHANTOM_LIGHT_ARMOR_5 = phantom.getProperty("ListLightArmor5", "0");
		LIST_PHANTOM_LIGHT_ARMOR_5 = new ArrayList<>();
		for (String listid : PHANTOM_LIGHT_ARMOR_5.split(",")) {
			LIST_PHANTOM_LIGHT_ARMOR_5.add(Integer.parseInt(listid));
		}

		PHANTOM_LIGHT_ARMOR_6 = phantom.getProperty("ListLightArmor6", "0");
		LIST_PHANTOM_LIGHT_ARMOR_6 = new ArrayList<>();
		for (String listid : PHANTOM_LIGHT_ARMOR_6.split(",")) {
			LIST_PHANTOM_LIGHT_ARMOR_6.add(Integer.parseInt(listid));
		}

		PHANTOM_LIGHT_ARMOR_7 = phantom.getProperty("ListLightArmor7", "0");
		LIST_PHANTOM_LIGHT_ARMOR_7 = new ArrayList<>();
		for (String listid : PHANTOM_LIGHT_ARMOR_7.split(",")) {
			LIST_PHANTOM_LIGHT_ARMOR_7.add(Integer.parseInt(listid));
		}

		PHANTOM_LIGHT_ARMOR_8 = phantom.getProperty("ListLightArmor8", "0");
		LIST_PHANTOM_LIGHT_ARMOR_8 = new ArrayList<>();
		for (String listid : PHANTOM_LIGHT_ARMOR_8.split(",")) {
			LIST_PHANTOM_LIGHT_ARMOR_8.add(Integer.parseInt(listid));
		}

		PHANTOM_LIGHT_ARMOR_9 = phantom.getProperty("ListLightArmor9", "0");
		LIST_PHANTOM_LIGHT_ARMOR_9 = new ArrayList<>();
		for (String listid : PHANTOM_LIGHT_ARMOR_9.split(",")) {
			LIST_PHANTOM_LIGHT_ARMOR_9.add(Integer.parseInt(listid));
		}

		PHANTOM_LIGHT_ARMOR_10 = phantom.getProperty("ListLightArmor10", "0");
		LIST_PHANTOM_LIGHT_ARMOR_10 = new ArrayList<>();
		for (String listid : PHANTOM_LIGHT_ARMOR_10.split(",")) {
			LIST_PHANTOM_LIGHT_ARMOR_10.add(Integer.parseInt(listid));
		}

		PHANTOM_LIGHT_ARMOR_11 = phantom.getProperty("ListLightArmor11", "0");
		LIST_PHANTOM_LIGHT_ARMOR_11 = new ArrayList<>();
		for (String listid : PHANTOM_LIGHT_ARMOR_11.split(",")) {
			LIST_PHANTOM_LIGHT_ARMOR_11.add(Integer.parseInt(listid));
		}

		PHANTOM_LIGHT_ARMOR_12 = phantom.getProperty("ListLightArmor12", "0");
		LIST_PHANTOM_LIGHT_ARMOR_12 = new ArrayList<>();
		for (String listid : PHANTOM_LIGHT_ARMOR_12.split(",")) {
			LIST_PHANTOM_LIGHT_ARMOR_12.add(Integer.parseInt(listid));
		}

		PHANTOM_LIGHT_ARMOR_13 = phantom.getProperty("ListLightArmor13", "0");
		LIST_PHANTOM_LIGHT_ARMOR_13 = new ArrayList<>();
		for (String listid : PHANTOM_LIGHT_ARMOR_13.split(",")) {
			LIST_PHANTOM_LIGHT_ARMOR_13.add(Integer.parseInt(listid));
		}

		PHANTOM_LIGHT_ARMOR_14 = phantom.getProperty("ListLightArmor14", "0");
		LIST_PHANTOM_LIGHT_ARMOR_14 = new ArrayList<>();
		for (String listid : PHANTOM_LIGHT_ARMOR_14.split(",")) {
			LIST_PHANTOM_LIGHT_ARMOR_14.add(Integer.parseInt(listid));
		}

		PHANTOM_LIGHT_ARMOR_15 = phantom.getProperty("ListLightArmor15", "0");
		LIST_PHANTOM_LIGHT_ARMOR_15 = new ArrayList<>();
		for (String listid : PHANTOM_LIGHT_ARMOR_15.split(",")) {
			LIST_PHANTOM_LIGHT_ARMOR_15.add(Integer.parseInt(listid));
		}

		PHANTOM_LIGHT_ARMOR_16 = phantom.getProperty("ListLightArmor16", "0");
		LIST_PHANTOM_LIGHT_ARMOR_16 = new ArrayList<>();
		for (String listid : PHANTOM_LIGHT_ARMOR_16.split(",")) {
			LIST_PHANTOM_LIGHT_ARMOR_16.add(Integer.parseInt(listid));
		}

		PHANTOM_LIGHT_ARMOR_17 = phantom.getProperty("ListLightArmor17", "0");
		LIST_PHANTOM_LIGHT_ARMOR_17 = new ArrayList<>();
		for (String listid : PHANTOM_LIGHT_ARMOR_17.split(",")) {
			LIST_PHANTOM_LIGHT_ARMOR_17.add(Integer.parseInt(listid));
		}

		PHANTOM_LIGHT_ARMOR_18 = phantom.getProperty("ListLightArmor18", "0");
		LIST_PHANTOM_LIGHT_ARMOR_18 = new ArrayList<>();
		for (String listid : PHANTOM_LIGHT_ARMOR_18.split(",")) {
			LIST_PHANTOM_LIGHT_ARMOR_18.add(Integer.parseInt(listid));
		}

		PHANTOM_LIGHT_ARMOR_19 = phantom.getProperty("ListLightArmor19", "0");
		LIST_PHANTOM_LIGHT_ARMOR_19 = new ArrayList<>();
		for (String listid : PHANTOM_LIGHT_ARMOR_19.split(",")) {
			LIST_PHANTOM_LIGHT_ARMOR_19.add(Integer.parseInt(listid));
		}

		// Bow Fake
		FAKE_BOW_ID = phantom.getProperty("FakeBowIDList", "");
		LIST_FAKE_BOW = new ArrayList<>();
		for (String itemId : FAKE_BOW_ID.split(",")) {
			LIST_FAKE_BOW.add(Integer.parseInt(itemId));
		}

		// Dagger Fake
		FAKE_DAGGER_ID = phantom.getProperty("FakeDaggerIDList", "");
		LIST_FAKE_DAGGER = new ArrayList<>();
		for (String itemId : FAKE_DAGGER_ID.split(",")) {
			LIST_FAKE_DAGGER.add(Integer.parseInt(itemId));
		}

		// Sword Fake
		FAKE_SWORD_ID = phantom.getProperty("FakeSwordIDList", "");
		LIST_FAKE_SWORD = new ArrayList<>();
		for (String itemId : FAKE_SWORD_ID.split(",")) {
			LIST_FAKE_SWORD.add(Integer.parseInt(itemId));
		}

		// Spear Fake
		FAKE_SPEAR_ID = phantom.getProperty("FakeSpearIDList", "");
		LIST_FAKE_SPEAR = new ArrayList<>();
		for (String itemId : FAKE_SPEAR_ID.split(",")) {
			LIST_FAKE_SPEAR.add(Integer.parseInt(itemId));
		}

		// Dual Fake
		FAKE_DUAL_ID = phantom.getProperty("FakeDualIDList", "");
		LIST_FAKE_DUAL = new ArrayList<>();
		for (String itemId : FAKE_DUAL_ID.split(",")) {
			LIST_FAKE_DUAL.add(Integer.parseInt(itemId));
		}

		// Fist Fake
		FAKE_FIST_ID = phantom.getProperty("FakeFistIDList", "");
		LIST_FAKE_FIST = new ArrayList<>();
		for (String itemId : FAKE_FIST_ID.split(",")) {
			LIST_FAKE_FIST.add(Integer.parseInt(itemId));
		}

		// BigSword Fake
		FAKE_BIGSWORD_ID = phantom.getProperty("FakeBigSwordIDList", "");
		LIST_FAKE_BIG_SWORD = new ArrayList<>();
		for (String itemId : FAKE_BIGSWORD_ID.split(",")) {
			LIST_FAKE_BIG_SWORD.add(Integer.parseInt(itemId));
		}

		// Magic Fake
		FAKE_MAGIC_ID = phantom.getProperty("FakeMagicWeaponIDList", "");
		LIST_FAKE_MAGIC = new ArrayList<>();
		for (String itemId : FAKE_MAGIC_ID.split(",")) {
			LIST_FAKE_MAGIC.add(Integer.parseInt(itemId));
		}

		// Shield Fake
		FAKE_SHIELD_ID = phantom.getProperty("FakeShieldIDList", "");
		LIST_FAKE_SHIELD = new ArrayList<>();
		for (String itemId : FAKE_SHIELD_ID.split(",")) {
			LIST_FAKE_SHIELD.add(Integer.parseInt(itemId));
		}

		// Jewels Set
		String[] propertySplit = phantom.getProperty("JewelSetList1", "0,0").split(";");
		LIST_PHANTOM_JEWELS_1.clear();
		for (String reward : propertySplit) {
			String[] rewardSplit = reward.split(",");
			if (rewardSplit.length != 2) {
				_log.warning("JewelSetList1[FakePlayerConfig.load()]: invalid config property -> JewelSetList1 \""
						+ reward + "\"");
			} else {
				try {
					LIST_PHANTOM_JEWELS_1
							.add(new int[] { Integer.parseInt(rewardSplit[0]), Integer.parseInt(rewardSplit[1]) });
				} catch (NumberFormatException nfe) {
					if (!reward.isEmpty()) {
						_log.warning(
								"JewelSetList1[FakePlayerConfig.load()]: invalid config property -> JewelSetList1 \""
										+ reward + "\"");
					}
				}
			}
		}

		String[] propertySplitPhantomsItem = phantom.getProperty("PhantomStartItems", "57,0").split(";");
		STARTING_PHANTOM_ITEMS.clear();
		for (final String reward : propertySplitPhantomsItem) {
			final String[] rewardSplit = reward.split(",");
			if (rewardSplit.length != 2)
				_log.warning("PhantomStartItems[Config.load()]: invalid Phantoms property -> PhantomStartItems \""
						+ reward + "\"");
			else {
				try {
					STARTING_PHANTOM_ITEMS
							.add(new int[] { Integer.parseInt(rewardSplit[0]), Integer.parseInt(rewardSplit[1]) });
				} catch (final NumberFormatException nfe) {
					nfe.printStackTrace();
					if (!reward.isEmpty())
						_log.warning(
								"PhantomStartItems[Config.load()]: invalid Phantoms property -> PhantomStartItems \""
										+ reward + "\"");
				}
			}
		}
		propertySplit = phantom.getProperty("JewelSetList2", "0,0").split(";");
		LIST_PHANTOM_JEWELS_2.clear();
		for (String reward : propertySplit) {
			String[] rewardSplit = reward.split(",");
			if (rewardSplit.length != 2) {
				_log.warning("JewelSetList2[FakePlayerConfig.load()]: invalid config property -> JewelSetList2 \""
						+ reward + "\"");
			} else {
				try {
					LIST_PHANTOM_JEWELS_2
							.add(new int[] { Integer.parseInt(rewardSplit[0]), Integer.parseInt(rewardSplit[1]) });
				} catch (NumberFormatException nfe) {
					if (!reward.isEmpty()) {
						_log.warning(
								"JewelSetList2[FakePlayerConfig.load()]: invalid config property -> JewelSetList2 \""
										+ reward + "\"");
					}
				}
			}
		}

		// Accessory Fake
		ALLOW_FAKE_PLAYERS_ACCESSORY = phantom.getProperty("AllowFakePlayerAccesory", false);
		FAKE_ACCESSORY_ID = phantom.getProperty("FakeAccessoryIDList", "");
		LIST_FAKE_ACCESSORY = new ArrayList<>();
		for (String itemId : FAKE_ACCESSORY_ID.split(",")) {
			LIST_FAKE_ACCESSORY.add(Integer.parseInt(itemId));
		}

		// Buffer List
		NUKER_BUFFER = phantom.getProperty("NukerBufferList", "0");
		NUKER_BUFFER_LIST = new ArrayList<>();
		for (String listid : NUKER_BUFFER.split(",")) {
			NUKER_BUFFER_LIST.add(Integer.parseInt(listid));
		}

		ARCHER_BUFFER = phantom.getProperty("ArcherBufferList", "0");
		ARCHER_BUFFER_LIST = new ArrayList<>();
		for (String listid : ARCHER_BUFFER.split(",")) {
			ARCHER_BUFFER_LIST.add(Integer.parseInt(listid));
		}

		DAGGER_BUFFER = phantom.getProperty("DaggerBufferList", "0");
		DAGGER_BUFFER_LIST = new ArrayList<>();
		for (String listid : DAGGER_BUFFER.split(",")) {
			DAGGER_BUFFER_LIST.add(Integer.parseInt(listid));
		}

		WARRIOR_BUFFER = phantom.getProperty("WarriorBufferList", "0");
		WARRIOR_BUFFER_LIST = new ArrayList<>();
		for (String listid : WARRIOR_BUFFER.split(",")) {
			WARRIOR_BUFFER_LIST.add(Integer.parseInt(listid));
		}

		RANDOM_BUFFER = phantom.getProperty("RandomBufferList", "0");
		RANDOM_BUFFER_LIST = new ArrayList<>();
		for (String listid : RANDOM_BUFFER.split(",")) {
			RANDOM_BUFFER_LIST.add(Integer.parseInt(listid));
		}

		PHANTOM_PRIVATE_BUY_TITLE_MSG = phantom.getProperty("PhantomPrivate_Buy_Title", "Lineage 2");
		PHANTOM_PRIVATE_BUY_TITLE = new ArrayList<>();
		for (final String type2 : PHANTOM_PRIVATE_BUY_TITLE_MSG.split(","))
			PHANTOM_PRIVATE_BUY_TITLE.add(type2);

		PHANTOM_PRIVATE_BUY = phantom.getProperty("PhantomPrivate_Buy", "");
		LIST_PRIVATE_BUY = new ArrayList<>();
		for (final String itemId : PHANTOM_PRIVATE_BUY.split(","))
			LIST_PRIVATE_BUY.add(Integer.parseInt(itemId));

		PHANTOM_PRIVATE_SELL_TITLE_MSG = phantom.getProperty("PhantomPrivate_Sell_Title", "Lineage 2");
		PHANTOM_PRIVATE_SELL_TITLE = new ArrayList<>();
		for (final String type2 : PHANTOM_PRIVATE_SELL_TITLE_MSG.split(","))
			PHANTOM_PRIVATE_SELL_TITLE.add(type2);

		PHANTOM_PRIVATE_SELL = phantom.getProperty("PhantomPrivate_Sell", "");
		LIST_PRIVATE_SELL = new ArrayList<>();
		for (final String itemId : PHANTOM_PRIVATE_SELL.split(","))
			LIST_PRIVATE_SELL.add(Integer.parseInt(itemId));

		PHANTOM_PRIVATE_SELL_CHANCE = phantom.getProperty("PhantomPrivate_Sell_Chance", 50);
		PHANTOM_PRIVATE_BUY_CHANCE = phantom.getProperty("PhantomPrivate_Buy_Chance", 50);
	}

	public static ExProperties load(String filename) {
		return load(new File(filename));
	}

	public static ExProperties load(File file) {
		ExProperties result = new ExProperties();

		try {
			result.load(file);
		} catch (IOException e) {
			_log.warning("Error loading config : " + file.getName() + "!");
		}

		return result;
	}

}
