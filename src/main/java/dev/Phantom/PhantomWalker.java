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
import dev.l2j.tesla.gameserver.model.L2Skill;
import dev.l2j.tesla.gameserver.model.World;
import dev.l2j.tesla.gameserver.model.actor.Player;
import dev.l2j.tesla.gameserver.model.actor.player.Appearance;
import dev.l2j.tesla.gameserver.model.actor.player.Experience;
import dev.l2j.tesla.gameserver.model.actor.template.PlayerTemplate;
import dev.l2j.tesla.gameserver.model.location.Location;
import dev.l2j.tesla.gameserver.model.pledge.Clan;
import dev.l2j.tesla.gameserver.network.GameClient;
import dev.l2j.tesla.gameserver.network.GameClient.GameClientState;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhantomWalker {
	static final Logger _log = Logger.getLogger(PhantomWalker.class.getName());
	static String _phantomAcc = Config.PHANTOM_PLAYERS_ACC_1;
	static int _PhantomsCount = 0;
	static int _PhantomsLimit = 0;
	static int _setsCount = 0;
	static int _setsCountClan = 0;
	volatile int _PhantomsTownTotal = 0;

	static int _setsArcherCount = 0;

	static PhantomWalker _instance;
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

	public static PhantomWalker getInstance() {
		return _instance;
	}

	private void load() {
		cacheFantoms();
		_PhantomsTown.put(Integer.valueOf(1), new ConcurrentLinkedQueue<Player>());
		_PhantomsTown.put(Integer.valueOf(2), new ConcurrentLinkedQueue<Player>());
		_PhantomsTown.put(Integer.valueOf(3), new ConcurrentLinkedQueue<Player>());
		_PhantomsTown.put(Integer.valueOf(4), new ConcurrentLinkedQueue<Player>());
		_PhantomsTown.put(Integer.valueOf(5), new ConcurrentLinkedQueue<Player>());

	}

	public void reload() {


	}

	public static void init() {
		_instance = new PhantomWalker();
		_instance.load();
	}

	static int getFaceEquipe() {
		return Config.LIST_PHANTOM_FACE.get(Rnd.get(Config.LIST_PHANTOM_FACE.size())).intValue();
	}

	static List<Location> locations = Arrays.asList(
			//Giran
			new Location(82792,147976,-3464),
			new Location(82840,148056,-3464),
			new Location(82888,148136,-3464),
			new Location(82952,148200,-3464),
			new Location(82888,148280,-3464),
			new Location(83016,148424,-3464),
			new Location(82952,148520,-3464),
			new Location(82472,148712,-3464),
			new Location(82472,148504,-3464),
			new Location(82664,148360,-3464),
			new Location(83224,148648,-3408),
			new Location(83320,148744,-3400),
			new Location(83496,148888,-3400),
			new Location(83400,149112,-3400),
			new Location(83384,147992,-3400),
			new Location(83352,148072,-3400),
			new Location(83432,148088,-3400),
			new Location(83352,148072,-3400),
			new Location(83304,148008,-3408),
			new Location(83352,148072,-3400),
			new Location(83544,148504,-3400),
			new Location(83368,148520,-3400),
			new Location(83336,148232,-3400),
			new Location(83000,148152,-3464),
			new Location(83544,148216,-3400),
			new Location(83592,147704,-3400),
			new Location(83192,147672,-3464),
			new Location(81512,147736,-3464),
			new Location(82456,147848,-3464),
			new Location(82920,148232,-3464),
			new Location(83448,148232,-3400),
			new Location(83384,148472,-3400),
			new Location(81544,147640,-3464),
			new Location(81464,147608,-3464),
			new Location(82072,147768,-3464),
			new Location(82632,148584,-3464),
			new Location(82792,148760,-3464),
			new Location(82456,149128,-3464),
			new Location(81928,149016,-3464),
			new Location(81784,148216,-3464),
			new Location(82120,148104,-3464),
			new Location(82360,148504,-3464),
			new Location(81480,147048,-3528),
			new Location(81576,146888,-3528),
			new Location(79880,146616,-3520),
			new Location(79688,146648,-3520),
			new Location(83448,148248,-3400),
			new Location(83256,148616,-3408),
			new Location(83432,148200,-3400),
			new Location(81654,147832,-3464),
			new Location(82152,147752,-3464),
			new Location(82696,147848,-3364),
			new Location(82872,148600,-3464),
			new Location(83480,148312,-3400),
			new Location(83320,148344,-3408),
			new Location(83272,148008,-3408),
			new Location(83464,148088,-3400),
			new Location(82520, 148600, -3472),
			new Location(82584, 148584, -3472),
			new Location(82568, 148440, -3472),
			new Location(82616, 148328, -3472),
			new Location(82584, 148232, -3472),
			new Location(82663, 148200, -3472),
			new Location(82664, 148280, -3472),
			new Location(82616, 148344, -3472),
			new Location(82568, 148344, -3472),
			new Location(82536, 148248, -3472),
			new Location(82600, 148152, -3472),
			new Location(82728, 148072, -3472),
			new Location(82728, 148184, -3472),
			new Location(82807, 148215, -3472),
			new Location(82808, 148312, -3472),
			new Location(82808, 148408, -3472),
			new Location(82792, 148519, -3472),
			new Location(82792, 148632, -3472),
			new Location(82792, 148744, -3472),
			new Location(82792, 148856, -3472),
			new Location(82776, 148967, -3472),
			new Location(82824, 149000, -3472),
			new Location(82856, 148936, -3472),
			new Location(82824, 148872, -3472),
			new Location(82839, 148760, -3472),
			new Location(82840, 148568, -3472),
			new Location(82888, 148552, -3472),
			new Location(82888, 148456, -3472),
			new Location(82903, 148344, -3472),
			new Location(82904, 148216, -3472),
			new Location(82904, 148088, -3472),
			new Location(82904, 147944, -3472),
			new Location(82872, 147960, -3472),
			new Location(83592, 147624, -3408),
			new Location(83512, 147624, -3408),
			new Location(83304, 147608, -3472),
			new Location(83144, 147608, -3472),
			new Location(82888, 147608, -3472),
			new Location(82616, 147608, -3472),
			new Location(82376, 147608, -3472),
			new Location(82120, 147608, -3472),
			new Location(81864, 147608, -3472),
			new Location(81608, 147608, -3472),
			new Location(81352, 147608, -3472),
			new Location(81096, 147608, -3472),
			new Location(81160, 147576, -3464),
			new Location(81336, 147592, -3472),
			new Location(81560, 147592, -3472),
			new Location(81704, 147560, -3464),
			new Location(81864, 147560, -3464),
			new Location(81992, 147592, -3472),
			new Location(82136, 147592, -3472),
			new Location(82296, 147576, -3464),
			new Location(82391, 147607, -3472),
			new Location(82519, 147544, -3464),
			new Location(82664, 147544, -3464),
			new Location(82856, 147528, -3464),
			new Location(83064, 147544, -3464),
			new Location(83112, 147592, -3472),
			new Location(83160, 147656, -3472),
			new Location(83160, 147720, -3472),
			new Location(83112, 147752, -3472),
			new Location(83064, 147800, -3472),
			new Location(83128, 147800, -3472),
			new Location(83223, 147784, -3464),
			new Location(83192, 147736, -3472),
			new Location(83112, 147736, -3472),
			new Location(83048, 147768, -3472),

			//Aden
			new Location(146840,25816,-2008),
			new Location(146792,25784,-2008),
			new Location(146904,25784,-2008),
			new Location(147480,25816,-2008),
			new Location(147256,25816,-2008),
			new Location(147416,25672,-2008),
			new Location(147272,25896,-2008),
			new Location(147416,26664,-2200),
			new Location(147736,26776,-2200),
			new Location(146648, 26888, -2208),
			new Location(146728, 26952, -2208),
			new Location(146728, 27032, -2208),
			new Location(146664, 27000, -2208),
			new Location(146632, 26952, -2208),
			new Location(146664, 26936, -2208),
			new Location(146664, 26888, -2208),
			new Location(146696, 26872, -2208),
			new Location(146760, 26856, -2208),
			new Location(146824, 26856, -2208),
			new Location(146936, 26856, -2208),
			new Location(147032, 26856, -2208),
			new Location(147128, 26856, -2208),
			new Location(147288, 26856, -2208),
			new Location(147400, 26856, -2208),
			new Location(147528, 26856, -2208),
			new Location(147640, 26856, -2208),
			new Location(147752, 26856, -2208),
			new Location(147864, 26856, -2208),
			new Location(147864, 26904, -2208),
			new Location(147864, 26968, -2208),
			new Location(147864, 27048, -2208),
			new Location(147864, 27144, -2208),
			new Location(147848, 27239, -2208),
			new Location(147752, 27255, -2208),
			new Location(147656, 27240, -2208),
			new Location(147560, 27208, -2208),
			new Location(147496, 27144, -2208),
			new Location(147384, 27159, -2208),
			new Location(147384, 27304, -2208),
			new Location(147463, 27383, -2208),
			new Location(147336, 27352, -2208),
			new Location(147240, 27288, -2200),
			new Location(147128, 27224, -2208),
			new Location(147032, 27160, -2208),
			new Location(147047, 27064, -2208),
			new Location(146904, 27016, -2208),
			new Location(146888, 27160, -2208),
			new Location(146792, 27160, -2208),
			new Location(146744, 27112, -2208),
			new Location(146760, 27048, -2208),
			new Location(146792, 26984, -2208),
			new Location(146823, 26904, -2208),
			new Location(146792, 26808, -2208),
			new Location(146696, 26823, -2208),
			new Location(146648, 26728, -2208),
			new Location(146632, 26792, -2208),
			new Location(146632, 26888, -2208),
			new Location(146552, 26904, -2208),
			new Location(146552, 26792, -2208),
			new Location(146488, 26808, -2208),
			new Location(146520, 26936, -2208),
			new Location(146584, 27032, -2208),
			new Location(146568, 27143, -2208),
			new Location(146679, 27159, -2208),
			new Location(146776, 27080, -2208),
			new Location(146840, 27016, -2208),
			new Location(146856, 26952, -2208),
			new Location(147000, 26968, -2208),
			new Location(147015, 27063, -2208),
			new Location(147080, 27112, -2208),
			new Location(147112, 27048, -2208),
			new Location(147128, 26968, -2208),
			new Location(147192, 26952, -2208),
			new Location(147176, 27032, -2208),
			new Location(147112, 26984, -2208),
			new Location(147112, 26904, -2208),
			new Location(147160, 26856, -2208),
			new Location(147191, 26935, -2208),
			new Location(147287, 26967, -2208),
			new Location(147352, 26888, -2208),
			new Location(147447, 26856, -2208),
			new Location(147479, 26935, -2208),
			new Location(147464, 27031, -2208),
			new Location(147416, 27096, -2208),
			new Location(147495, 27127, -2208),
			new Location(147496, 27192, -2208),
			new Location(147448, 27224, -2208),
			new Location(147512, 27240, -2208),
			new Location(147464, 27304, -2208),
			new Location(147416, 27304, -2208),
			new Location(147384, 26856, -2208),
			new Location(147448, 26808, -2208),
			new Location(147512, 26744, -2208),
			new Location(147480, 26680, -2208),
			new Location(147560, 26664, -2208),
			new Location(147736, 26696, -2208),
			new Location(147976, 26696, -2208),
			new Location(147960, 26760, -2208),
			new Location(148104, 26792, -2208),
			new Location(148152, 26712, -2208),
			new Location(148296, 26712, -2208),
			new Location(148296, 26792, -2208),
			new Location(148248, 26760, -2208),
			new Location(148232, 26696, -2208),
			new Location(148168, 26744, -2208),
			new Location(148168, 26744, -2208),
			new Location(148215, 26919, -2208),
			new Location(148312, 26920, -2208),
			new Location(148264, 27000, -2208),
			new Location(148200, 27016, -2208),
			new Location(148120, 27000, -2208),
			new Location(148056, 26968, -2208),
			new Location(147976, 26984, -2208),
			new Location(147912, 26952, -2208),
			new Location(147848, 26984, -2208),
			new Location(147784, 26952, -2208),
			new Location(147736, 27016, -2208),
			new Location(147800, 27048, -2208),
			new Location(147880, 27032, -2208),
			new Location(147944, 27096, -2208),
			new Location(148056, 27064, -2208),
			new Location(148152, 27128, -2208),
			new Location(148231, 27096, -2208),
			new Location(148296, 27144, -2208),
			new Location(148360, 27096, -2208),
			new Location(148424, 27144, -2208),
			new Location(148408, 27176, -2208),
			new Location(148344, 27160, -2208),
			new Location(148344, 27224, -2208),
			new Location(148248, 27239, -2208),
			new Location(148152, 27255, -2208),
			new Location(147992, 27208, -2208),
			new Location(147912, 27208, -2208),
			new Location(147816, 27208, -2208),
			new Location(147720, 27208, -2208),
			new Location(147624, 27192, -2208),
			new Location(147624, 27192, -2208),
			new Location(147176, 27192, -2208),
			new Location(147048, 27192, -2208),
			new Location(146952, 27207, -2208),
			new Location(146856, 27208, -2208),
			new Location(146760, 27208, -2208),
			new Location(146664, 27208, -2208),
			new Location(146568, 27208, -2208),
			new Location(146472, 27208, -2208),
			new Location(147336,27048,-2200),
			//Oren
			new Location(82936,53208,-1488),
			new Location(82856,53256,-1488),
			new Location(82856,53368,-1488),
			new Location(82984,53496,-1480),
			//Gludio
			new Location(-12616,122728,-3112),
			new Location(-12840,122696,-3112),
			new Location(-12760,122760,-3112),
			new Location(-12920,122680,-3112),
			new Location(-13208,122680,-3048),
			new Location(-13432,122328,-2984),
			new Location(-13640,122232,-2984),
			new Location(-12904,122712,-3112),
			//Dion
			new Location(15689,143001,-2700),
			new Location(15672,143032,-2707),
			new Location(15960,142984,-2712),
		    new Location(15640,142920,-2696),
		    new Location(15752,143128,-2728),
	        new Location(15944,143304,-2768),
			new Location(18748, 145437, -3136),
			new Location(18984, 145384, -3136),
			new Location(18888, 145288, -3136),
			new Location(18760, 145304, -3136),
			new Location(18808, 145128, -3136),
			new Location(18952, 145080, -3136),
			new Location(18888, 144952, -3120),
			new Location(18728, 144984, -3120),
			new Location(18648, 144904, -3120),
			new Location(18776, 144744, -3120),
			new Location(18936, 144712, -3120),
			new Location(18967, 144807, -3120),
			new Location(18904, 144904, -3120),
			new Location(18728, 144936, -3120),
			new Location(18504, 144872, -3088),
			new Location(18280, 144712, -3040),
			new Location(18568, 144840, -3104),
			new Location(18728, 144936, -3120),
			new Location(19080, 144647, -3104),
			new Location(19448, 144552, -3088),
			new Location(19199, 145196, -3120),
			new Location(19256, 145704, -3104),
			new Location(19288, 145976, -3064),
			new Location(19240, 146071, -3064),
			new Location(19384, 146104, -3064),
			new Location(18760, 145640, -3120),
			new Location(18504, 145736, -3120),
			new Location(18264, 145688, -3120),
			new Location(18072, 145848, -3120),
			new Location(17928, 145752, -3120),
			new Location(17864, 145592, -3104),
			new Location(17624, 145528, -3088),
			new Location(17400, 145416, -3072),
			new Location(17368, 145272, -3056),
			new Location(17128, 145144, -3040),
			new Location(17064, 145000, -3040),
			new Location(16904, 144920, -3024),
			new Location(16872, 144680, -3008),
			new Location(16744, 144488, -3008),
			new Location(16648, 144200, -2992),
			new Location(16520, 144008, -2976),
			new Location(16472, 143752, -2928),
			new Location(16360, 143656, -2896),
			new Location(16312, 143464, -2832),
			new Location(16152, 143400, -2832),
			new Location(16008, 143416, -2816),
			new Location(15880, 143304, -2760),
			new Location(15880, 143128, -2752),
			new Location(18279, 145320, -3104),
			new Location(18407, 145192, -3096),
			new Location(18472, 145240, -3120),
			new Location(18536, 145096, -3120),
			new Location(18520, 144968, -3088),
			new Location(18535, 144856, -3088),
			new Location(18616, 144920, -3120),
			new Location(18552, 144920, -3088),
			new Location(18568, 145000, -3120),
			new Location(18632, 145016, -3120),
			new Location(18664, 144936, -3120),
			new Location(18712, 144856, -3120),
			new Location(18792, 144840, -3120),
			new Location(18872, 144952, -3120),
			new Location(18952, 145080, -3136),
			new Location(19048, 144904, -3120),
			new Location(19016, 144776, -3120),
			new Location(18936, 144824, -3120),
			new Location(18952, 144648, -3120),
			new Location(19016, 144584, -3120),
			new Location(18936, 144504, -3104),
			new Location(18951, 144392, -3104),
			new Location(19047, 144407, -3104),
			new Location(19080, 144520, -3104),
			new Location(18968, 144552, -3120),
			new Location(18840, 144584, -3120),
			new Location(18871, 144663, -3120),
			new Location(18760, 144712, -3120),
			new Location(18792, 144776, -3120),
			new Location(18856, 144824, -3120),
			new Location(18840, 144904, -3120),
			new Location(18904, 144984, -3120),
			new Location(18872, 145063, -3136),
			new Location(18951, 145095, -3136),
			new Location(18952, 145176, -3136),
			new Location(18888, 145224, -3136),
			new Location(18919, 145303, -3136),
			new Location(18904, 145415, -3136),
			new Location(18920, 145560, -3120),
			new Location(18936, 145576, -3120),
			new Location(19064, 145576, -3120),
			new Location(19175, 145591, -3120),
			new Location(19160, 145656, -3120),
			new Location(19271, 145671, -3104),
			new Location(19304, 145608, -3120),
			new Location(19368, 145656, -3104),
			new Location(19384, 145496, -3104),
			new Location(19463, 145575, -3104),
			new Location(19576, 145640, -3104),
			new Location(19432, 145688, -3096),
			new Location(19304, 145704, -3104),
			new Location(19192, 145672, -3104),
			new Location(19048, 145704, -3104),
			new Location(18904, 145752, -3104),
			new Location(18760, 145784, -3104),
			new Location(18632, 145832, -3088),
			new Location(18504, 145848, -3104),
			new Location(18424, 145816, -3120),
			new Location(18328, 145847, -3120),
			new Location(18264, 145960, -3104),
			new Location(18184, 146056, -3088),
			new Location(18104, 146024, -3120),
			new Location(18008, 145976, -3120),
			new Location(17912, 145928, -3104),
			new Location(17912, 145832, -3104),
			new Location(17975, 145704, -3120),
			new Location(18056, 145592, -3104),
			new Location(18168, 145592, -3104),
			new Location(18199, 145687, -3120),
			new Location(18328, 145640, -3120),
			new Location(18392, 145544, -3120),
			new Location(18488, 145480, -3120),
			new Location(18584, 145400, -3136),
			new Location(18664, 145288, -3136),
			new Location(18648, 145176, -3120),
			new Location(18568, 145240, -3120),
			new Location(18472, 145304, -3120),
			new Location(18376, 145384, -3120),
			new Location(18280, 145464, -3120),
			new Location(18184, 145544, -3120),
			new Location(18088, 145624, -3104),
			new Location(17992, 145704, -3120),
			new Location(18296, 145672, -3120),
			new Location(18392, 145576, -3120),
			new Location(18488, 145464, -3120),
			new Location(18584, 145352, -3136),
			new Location(18552, 145431, -3120),
			new Location(18632, 145336, -3136),
			new Location(18663, 145240, -3120),
			new Location(18759, 145192, -3136),
			new Location(18760, 145080, -3136),
			new Location(18855, 145048, -3136),
			new Location(18856, 144952, -3120),
			new Location(18792, 144904, -3120),
			new Location(18712, 144904, -3120),
			new Location(18632, 144952, -3120),
			new Location(18552, 144936, -3096),
			new Location(18631, 144856, -3104),
			new Location(18711, 144824, -3120),
			new Location(18792, 144840, -3120),
			new Location(15991, 143143, -2752),
			new Location(15976, 143239, -2752),
			new Location(16120, 143160, -2768),
			new Location(16104, 143032, -2720),
			new Location(15976, 142952, -2704),
			new Location(15816, 142952, -2704)


	);

	static Location getRandomLoc() {
		Collections.shuffle(locations);
		return locations.get(0);
	}



	public static void startWalk(Player paramPlayer) {
		ThreadPool.schedule(new PhantomWalk(paramPlayer), Rnd.get(1000, 8000));
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
			if (_phantom.isSpawnProtected()) {
				_phantom.setSpawnProtection(false);
			}
			_phantom.rndWalk();
			PhantomWalker.startWalk(_phantom);
			if (Rnd.nextInt(100) == 0)
				PhantomPlayerUtils.maybeAnnounce(_phantom);
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


		@Override
		public void run() {
			int i = 0;
			switch (_task) {
			case 1:
				PhantomWalker._log.info("PhantomWalker: Account " + Config.PHANTOM_PLAYERS_ACC_1 + ", spawn started.");
				try (Connection con = L2DatabaseFactory.getInstance().getConnection()) {
					PreparedStatement stm = con.prepareStatement(
							"SELECT obj_Id,char_name,title,x,y,z,sex,clanid FROM characters WHERE account_name = ?");
					stm.setString(1, PhantomWalker._phantomAcc);

					ResultSet rs = stm.executeQuery();
					while (rs.next()) {
						FakePlayer player = null;
						try {

							ClassId classId = getThirdClasses().get(Rnd.get(0, getThirdClasses().size() - 1));
							final PlayerTemplate template = PlayerData.getInstance().getTemplate(classId);
							Appearance app = getRandomAppearance(template.getClass());
							player = new FakePlayer(rs.getInt("obj_Id"), template, Config.PHANTOM_PLAYERS_ACC_1, app);

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


							player.getAppearance().setNameColor(Integer.decode("0x" + PhantomStore.getNameColor()));
							player.getAppearance().setTitleColor(Integer.decode("0x" + PhantomStore.getTitleColor()));

							player.setName(playerName);
							player.setAccessLevel(Config.DEFAULT_ACCESS_LEVEL);
							player.setBaseClass(player.getClassId());
							player.addExpAndSp(Experience.LEVEL[80], 0);
							player.rewardSkills();

							// Equipment
							ArmorFakePlayer.giveArmorByClass(player, true);
							BufferByClass.giveBuffsByClass(player);
							HairHatByClass.giveAcessoryByClass(player);
							InvetoryItemsByClass.giveItemsInventory(player);
							JewelsByClass.giveJewelsByClass(player, true);
							WeaponsByClass.giveWeaponsByClass(player, true);

							PhantomWalker.startWalk(player);

							if (Rnd.nextInt(30) == 0)
								PhantomPlayerUtils.maybeAnnounce(player);

							player.addExpAndSp(Experience.LEVEL[81], 0);
							player.rewardSkills();

							Clan clan = ClanTable.getInstance().getClan(getRandomClan());
							if (clan != null)
							{
								clan.addClanMember(player);
								clan.broadcastClanStatus();
							}



							Location localLocation = PhantomWalker.getRandomLoc();
							player.setXYZInvisible(localLocation.getX(), localLocation.getY(), localLocation.getZ());
							player.spawnMe(localLocation.getX(), localLocation.getY(), localLocation.getZ());
							player.setLastCords(player.getX(), player.getY(), player.getZ());
							if (Config.PLAYER_SPAWN_PROTECTION > 0) {
								player.setSpawnProtection(true);
							}

							if (player.isDead())
								player.doRevive();

							player.setRunning();
							player.broadcastUserInfo();

							if (Rnd.get(100) < Config.PHANTOM_CHANCE_MALARIA) {
								L2Skill skill = SkillTable.getInstance().getInfo(4554, 4);
								skill.getEffects(player, player);
							}
							PhantomWalker._players.add(player);
							PhantomWalker._PhantomsTown.get(Integer.valueOf(1)).add(player);

							i++;
						} catch (Exception e) {
							PhantomWalker._log.log(Level.WARNING, "FakePlayers: " + player, e);
							if (player != null) {
								player.deleteMe();
							}
						}


					}
					rs.close();
					stm.close();
				} catch (Exception e) {
					PhantomWalker._log.log(Level.WARNING, "FakePlayerss: ", e);
				}
				PhantomWalker._log.info("Phantom Walker: Foi Gerado " + i + " Phantom Store.");
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
				PhantomWalker.removePlayers(_activeChar);
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

	public static int getRandomClan() {
		return FakePlayerConfig.LIST_CLAN_ID.get(Rnd.get(FakePlayerConfig.LIST_CLAN_ID.size())).intValue();
	}
}



