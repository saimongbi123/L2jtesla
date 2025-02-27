package dev.Phantom;

import dev.Phantom.Helpers.FakeHelpers;
import dev.Phantom.Util.*;
import dev.Phantom.ai.Walker.AdenWalkerAI;
import dev.Phantom.ai.Walker.DionWalkerAI;
import dev.Phantom.ai.Walker.GiranWalkerAI;
import dev.Phantom.ai.Walker.GludinWalkerAI;
import dev.l2j.tesla.Config;
import dev.l2j.tesla.commons.concurrent.ThreadPool;
import dev.l2j.tesla.commons.lang.StringUtil;
import dev.l2j.tesla.gameserver.data.manager.CastleManager;
import dev.l2j.tesla.gameserver.data.xml.MapRegionData.TeleportType;
import dev.l2j.tesla.gameserver.enums.ZoneId;
import dev.l2j.tesla.gameserver.model.World;
import dev.l2j.tesla.gameserver.model.actor.Playable;
import dev.l2j.tesla.gameserver.model.actor.Player;
import dev.l2j.tesla.gameserver.model.entity.Castle;
import dev.l2j.tesla.gameserver.model.entity.Siege;
import dev.l2j.tesla.gameserver.model.pledge.Clan;
import dev.l2j.tesla.gameserver.network.SystemMessageId;
import dev.l2j.tesla.gameserver.network.serverpackets.PledgeShowMemberListUpdate;
import dev.l2j.tesla.gameserver.network.serverpackets.SystemMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public enum FakePlayerManager {
	INSTANCE;

	private FakePlayerManager() {

	}

	public static void initialise() {
		FakePlayerNameManager.INSTANCE.initialise();
		FakePlayerTitleManager.INSTANCE.initialise();
		FakePlayerTaskManager.INSTANCE.initialise();
		PhantomPlayerUtils.load();
		
		StringUtil.printSection("Phantom Walker");
		if (Config.ALLOW_PHANTOM_STORE)
			PhantomStore.init();
		if (Config.ALLOW_PHANTOM_PLAYERS)
			PhantomWalker.init();
		

		
	}

	public static FakePlayer spawnPlayer(int x, int y, int z) {
		FakePlayer activeChar = FakeHelpers.createRandomFakePlayer();
		World.getInstance().addPlayer(activeChar);
		handlePlayerClanOnSpawn(activeChar);
		
		if (Config.PLAYER_SPAWN_PROTECTION > 0)
			activeChar.setSpawnProtection(true);
		activeChar.spawnMe(x, y, z);
		activeChar.onPlayerEnter();
		
		if (!activeChar.isGM() && (!activeChar.isInSiege() || activeChar.getSiegeState() < 2)
				&& activeChar.isInsideZone(ZoneId.SIEGE))
			activeChar.teleportTo(TeleportType.TOWN);

		ArmorFakePlayer.giveArmorByClass(activeChar, true);
		BufferByClass.giveBuffsByClass(activeChar);
		HairHatByClass.giveAcessoryByClass(activeChar);
		InvetoryItemsByClass.giveItemsInventory(activeChar);
		JewelsByClass.giveJewelsByClass(activeChar, true);
		WeaponsByClass.giveWeaponsByClass(activeChar, true);
		
		activeChar.heal();
		return activeChar;
	   
	}

	public static void despawnFakePlayer(int objectId) {
		Player player = World.getInstance().getPlayer(objectId);
		if (player instanceof FakePlayer) {
			FakePlayer fakePlayer = (FakePlayer) player;
			fakePlayer.despawnPlayer();
		}
	}
	
	
	private static void handlePlayerClanOnSpawn(final FakePlayer activeChar) {
        final Clan clan = activeChar.getClan();
        if (clan != null) {
            clan.getClanMember(activeChar.getObjectId()).setPlayerInstance(activeChar);
            final SystemMessage msg = SystemMessage.getSystemMessage(SystemMessageId.CLAN_MEMBER_S1_LOGGED_IN).addCharName(activeChar);
            final PledgeShowMemberListUpdate update = new PledgeShowMemberListUpdate(activeChar);
            for (final Playable member : clan.getOnlineMembers()) {
                if (member != activeChar) {
                    member.sendPacket(msg);
                    member.sendPacket(update);
                }
            }
            for (final Castle castle : CastleManager.getInstance().getCastles()) {
                final Siege siege = castle.getSiege();
                if (!siege.isInProgress()) {
                    continue;
                }


                }
            }
        }
    
	
    public static ArrayList<Integer> getFighterBuffs() {
        return Config.FIGHTER_BUFF_LIST;
    }
    
    public static ArrayList<Integer> getMageBuffs() {
        return Config.MAGE_BUFF_LIST;
    }
    
	public static int getFakePlayersCount() {
		return getFakePlayers().size();
	}

	public static List<FakePlayer> getFakePlayers() {
		return World.getInstance().getPlayers().stream().filter(x -> x instanceof FakePlayer).map(x -> (FakePlayer) x)
				.collect(Collectors.toList());
	}

	/**
	 * @param ENABLE_TELE_TO
	 * @return
	 */
	public static FakePlayer spawnPlayer1(boolean ENABLE_TELE_TO)
	{
		FakePlayer activeChar = FakeHelpers.createRandomFakePlayer();
		World.getInstance().addPlayer(activeChar);
		handlePlayerClanOnSpawn(activeChar);
		
		if (Config.PLAYER_SPAWN_PROTECTION > 0)
			activeChar.setSpawnProtection(true);
		activeChar.spawnMe(Config.TELE_TO_GIRAN[0], Config.TELE_TO_GIRAN[1], Config.TELE_TO_GIRAN[2]);
		activeChar.onPlayerEnter();
		
		if (!activeChar.isGM() && (!activeChar.isInSiege() || activeChar.getSiegeState() < 2)
				&& activeChar.isInsideZone(ZoneId.SIEGE))
			activeChar.teleportTo(TeleportType.TOWN);

		ArmorFakePlayer.giveArmorByClass(activeChar, true);
		BufferByClass.giveBuffsByClass(activeChar);
		HairHatByClass.giveAcessoryByClass(activeChar);
		InvetoryItemsByClass.giveItemsInventory(activeChar);
		JewelsByClass.giveJewelsByClass(activeChar, true);
		WeaponsByClass.giveWeaponsByClass(activeChar, true);
		
		activeChar.heal();
		
		return activeChar;
	}
	
	public static FakePlayer spawnPlayer2(boolean ENABLE_TELE_TO)
	{
		FakePlayer activeChar = FakeHelpers.createRandomFakePlayer();
		World.getInstance().addPlayer(activeChar);
		handlePlayerClanOnSpawn(activeChar);
		
		if (Config.PLAYER_SPAWN_PROTECTION > 0)
			activeChar.setSpawnProtection(true);
		activeChar.spawnMe(Config.TELE_TO_GODDARD[0], Config.TELE_TO_GODDARD[1], Config.TELE_TO_GODDARD[2]);
		activeChar.onPlayerEnter();
	
        
		if (!activeChar.isGM() && (!activeChar.isInSiege() || activeChar.getSiegeState() < 2)
				&& activeChar.isInsideZone(ZoneId.SIEGE))
			activeChar.teleportTo(TeleportType.TOWN);

		ArmorFakePlayer.giveArmorByClass(activeChar, true);
		BufferByClass.giveBuffsByClass(activeChar);
		HairHatByClass.giveAcessoryByClass(activeChar);
		InvetoryItemsByClass.giveItemsInventory(activeChar);
		JewelsByClass.giveJewelsByClass(activeChar, true);
		WeaponsByClass.giveWeaponsByClass(activeChar, true);
		
		activeChar.heal();
		
		return activeChar;
	}
	
	public static FakePlayer spawnPlayer3(boolean ENABLE_TELE_TO)
	{
		FakePlayer activeChar = FakeHelpers.createRandomFakePlayer();
		World.getInstance().addPlayer(activeChar);
		handlePlayerClanOnSpawn(activeChar);
		
		if (Config.PLAYER_SPAWN_PROTECTION > 0)
			activeChar.setSpawnProtection(true);
		
		ArmorFakePlayer.giveArmorByClass(activeChar, true);
		BufferByClass.giveBuffsByClass(activeChar);
		HairHatByClass.giveAcessoryByClass(activeChar);
		InvetoryItemsByClass.giveItemsInventory(activeChar);
		JewelsByClass.giveJewelsByClass(activeChar, true);
		WeaponsByClass.giveWeaponsByClass(activeChar, true);
		
        ThreadPool.schedule(new Runnable()
        {
          @Override
		public void run()
          {
        	  
	        
        	  FakePlayerManager.WhileLoopExample1.spawn(Config.TELE_TO_GIRAN[0], Config.TELE_TO_GIRAN[1], Config.TELE_TO_GIRAN[2]);
            System.out.println("[Fake Walker Giran]: Starded!");
          }
        }, 1L);
		
		activeChar.onPlayerEnter();

        
		if (!activeChar.isGM() && (!activeChar.isInSiege() || activeChar.getSiegeState() < 2)
				&& activeChar.isInsideZone(ZoneId.SIEGE))
			activeChar.teleportTo(TeleportType.TOWN);

		activeChar.heal();
		
		return activeChar;
	}

	public static FakePlayer spawnPlayer4(boolean ENABLE_TELE_TO)
	{
		FakePlayer activeChar = FakeHelpers.createRandomFakePlayer();
		World.getInstance().addPlayer(activeChar);
		handlePlayerClanOnSpawn(activeChar);

		if (Config.PLAYER_SPAWN_PROTECTION > 0)
			activeChar.setSpawnProtection(true);
		activeChar.spawnMe(Config.TELE_TO_ADEN[0], Config.TELE_TO_ADEN[1], Config.TELE_TO_ADEN[2]);
		activeChar.onPlayerEnter();


		if (!activeChar.isGM() && (!activeChar.isInSiege() || activeChar.getSiegeState() < 2)
				&& activeChar.isInsideZone(ZoneId.SIEGE))
			activeChar.teleportTo(TeleportType.TOWN);

		ArmorFakePlayer.giveArmorByClass(activeChar, true);
		BufferByClass.giveBuffsByClass(activeChar);
		HairHatByClass.giveAcessoryByClass(activeChar);
		InvetoryItemsByClass.giveItemsInventory(activeChar);
		JewelsByClass.giveJewelsByClass(activeChar, true);
		WeaponsByClass.giveWeaponsByClass(activeChar, true);

		activeChar.heal();

		return activeChar;
	}


	public static FakePlayer spawnPlayer5(boolean ENABLE_TELE_TO)
	{
		FakePlayer activeChar = FakeHelpers.createRandomFakePlayer();
		World.getInstance().addPlayer(activeChar);
		handlePlayerClanOnSpawn(activeChar);

		if (Config.PLAYER_SPAWN_PROTECTION > 0)
			activeChar.setSpawnProtection(true);
		activeChar.spawnMe(Config.TELE_TO_GLUDIN[0], Config.TELE_TO_GLUDIN[1], Config.TELE_TO_GLUDIN[2]);
		activeChar.onPlayerEnter();


		if (!activeChar.isGM() && (!activeChar.isInSiege() || activeChar.getSiegeState() < 2)
				&& activeChar.isInsideZone(ZoneId.SIEGE))
			activeChar.teleportTo(TeleportType.TOWN);

		ArmorFakePlayer.giveArmorByClass(activeChar, true);
		BufferByClass.giveBuffsByClass(activeChar);
		HairHatByClass.giveAcessoryByClass(activeChar);
		InvetoryItemsByClass.giveItemsInventory(activeChar);
		JewelsByClass.giveJewelsByClass(activeChar, true);
		WeaponsByClass.giveWeaponsByClass(activeChar, true);

		activeChar.heal();

		return activeChar;
	}


	public static FakePlayer spawnPlayer6(boolean ENABLE_TELE_TO)
	{
		FakePlayer activeChar = FakeHelpers.createRandomFakePlayer();
		World.getInstance().addPlayer(activeChar);
		handlePlayerClanOnSpawn(activeChar);

		if (Config.PLAYER_SPAWN_PROTECTION > 0)
			activeChar.setSpawnProtection(true);
		activeChar.spawnMe(Config.TELE_TO_DION[0], Config.TELE_TO_DION[1], Config.TELE_TO_DION[2]);
		activeChar.onPlayerEnter();


		if (!activeChar.isGM() && (!activeChar.isInSiege() || activeChar.getSiegeState() < 2)
				&& activeChar.isInsideZone(ZoneId.SIEGE))
			activeChar.teleportTo(TeleportType.TOWN);

		ArmorFakePlayer.giveArmorByClass(activeChar, true);
		BufferByClass.giveBuffsByClass(activeChar);
		HairHatByClass.giveAcessoryByClass(activeChar);
		InvetoryItemsByClass.giveItemsInventory(activeChar);
		JewelsByClass.giveJewelsByClass(activeChar, true);
		WeaponsByClass.giveWeaponsByClass(activeChar, true);

		activeChar.heal();

		return activeChar;
	}
	
	  static class WhileLoopExample1
	  {
	    public static void spawn(int x, int y, int z)
	    {
	      int i = 24;
	      while (i > 0)
	      {
	        
	    	System.out.println("Spwan: " + i);
            FakePlayer fakePlayer = FakePlayerManager.spawnPlayer(Config.TELE_TO_GIRAN[0], Config.TELE_TO_GIRAN[1], Config.TELE_TO_GIRAN[2]);
            fakePlayer.setFakeAi(new GiranWalkerAI(fakePlayer));
            
            
	        try
	        {
	          Thread.sleep(9000L);
	        }
	        catch (InterruptedException localInterruptedException) {}
	        i--;
	      }
	    }
	  }

	static class WhileLoopExample4
	{
		public static void spawn(int x, int y, int z)
		{
			int i = 24;
			while (i > 0)
			{

				System.out.println("Spwan: " + i);
				FakePlayer fakePlayer = FakePlayerManager.spawnPlayer(Config.TELE_TO_ADEN[0], Config.TELE_TO_ADEN[1], Config.TELE_TO_ADEN[2]);
				fakePlayer.setFakeAi(new AdenWalkerAI(fakePlayer));
				FakePlayerManager.WhileLoopExample4.spawn(Config.TELE_TO_ADEN[0], Config.TELE_TO_ADEN[1], Config.TELE_TO_ADEN[2]);

				try
				{
					Thread.sleep(9000L);
				}
				catch (InterruptedException localInterruptedException) {}
				i--;
			}
		}
	}


	static class WhileLoopExample5
	{
		public static void spawn(int x, int y, int z)
		{
			int i = 24;
			while (i > 0)
			{

				System.out.println("Spwan: " + i);
				FakePlayer fakePlayer = FakePlayerManager.spawnPlayer(Config.TELE_TO_GLUDIN[0], Config.TELE_TO_GLUDIN[1], Config.TELE_TO_GLUDIN[2]);
				fakePlayer.setFakeAi(new GludinWalkerAI(fakePlayer));
				FakePlayerManager.WhileLoopExample5.spawn(Config.TELE_TO_GLUDIN[0], Config.TELE_TO_GLUDIN[1], Config.TELE_TO_GLUDIN[2]);

				try
				{
					Thread.sleep(9000L);
				}
				catch (InterruptedException localInterruptedException) {}
				i--;
			}
		}

		static class WhileLoopExample1
		{
			public static void spawn(int x, int y, int z)
			{
				int i = 24;
				while (i > 0)
				{

					System.out.println("Spwan: " + i);
					FakePlayer fakePlayer = FakePlayerManager.spawnPlayer(Config.TELE_TO_DION[0], Config.TELE_TO_DION[1], Config.TELE_TO_DION[2]);
					fakePlayer.setFakeAi(new DionWalkerAI(fakePlayer));
					FakePlayerManager.WhileLoopExample1.spawn(Config.TELE_TO_DION[0], Config.TELE_TO_DION[1], Config.TELE_TO_DION[2]);


					try
					{
						Thread.sleep(9000L);
					}
					catch (InterruptedException localInterruptedException) {}
					i--;
				}
			}
		}
	}

	}


	 
	
    

