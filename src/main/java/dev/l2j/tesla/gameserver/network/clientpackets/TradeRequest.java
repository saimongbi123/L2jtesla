package dev.l2j.tesla.gameserver.network.clientpackets;

import dev.Phantom.FakePlayer;
import dev.Phantom.PhantomPlayerUtils;
import dev.Phantom.Util.FakePlayerConfig;
import dev.l2j.tesla.Config;
import dev.l2j.tesla.commons.concurrent.ThreadPool;
import dev.l2j.tesla.commons.math.MathUtil;
import dev.l2j.tesla.commons.random.Rnd;
import dev.l2j.tesla.gameserver.model.World;
import dev.l2j.tesla.gameserver.model.actor.Npc;
import dev.l2j.tesla.gameserver.model.actor.Player;
import dev.l2j.tesla.gameserver.model.actor.player.BlockList;
import dev.l2j.tesla.gameserver.model.item.instance.ItemInstance;
import dev.l2j.tesla.gameserver.model.tradelist.TradeItem;
import dev.l2j.tesla.gameserver.model.tradelist.TradeList;
import dev.l2j.tesla.gameserver.network.SystemMessageId;
import dev.l2j.tesla.gameserver.network.serverpackets.SendTradeRequest;
import dev.l2j.tesla.gameserver.network.serverpackets.SystemMessage;
import dev.l2j.tesla.gameserver.network.serverpackets.TradeItemUpdate;
import dev.l2j.tesla.gameserver.network.serverpackets.TradeOtherAdd;
import dev.l2j.tesla.gameserver.network.serverpackets.TradeOwnAdd;

public final class TradeRequest extends L2GameClientPacket
{
	private int _objectId;

	@Override
	protected void readImpl()
	{
		_objectId = readD();
	}

	@Override
	protected void runImpl()
	{
		final Player player = getClient().getPlayer();
		if (player == null)
			return;

		if (!player.getAccessLevel().allowTransaction())
		{
			player.sendPacket(SystemMessageId.YOU_ARE_NOT_AUTHORIZED_TO_DO_THAT);
			return;
		}

		final Player target = World.getInstance().getPlayer(_objectId);
		if (target == null || !player.getKnownType(Player.class).contains(target) || target.equals(player))
		{
			player.sendPacket(SystemMessageId.TARGET_IS_INCORRECT);
			return;
		}
		
		
		if(target instanceof FakePlayer)
		{
			player.setActiveRequester(target);
			target.onTransactionResponse();
			
			ThreadPool.schedule(() -> player.startTrade(target), 1000 * 5);
			
		
			
			if (target instanceof FakePlayer)
			{
				FakePlayer fakePlayer = (FakePlayer) target;
				PhantomPlayerUtils.answerPlayersTrade(player, fakePlayer);
			}
			
			ThreadPool.schedule(() -> additem(player, target), 1000 * 10);
			
			player.sendPacket(SystemMessage.getSystemMessage(SystemMessageId.REQUEST_S1_FOR_TRADE).addCharName(target));
			return;
		}

		if (target.isInOlympiadMode() || player.isInOlympiadMode())
		{
			player.sendMessage("You or your target cannot trade during Olympiad.");
			return;
		}

		// Alt game - Karma punishment
		if (!Config.KARMA_PLAYER_CAN_TRADE && (player.getKarma() > 0 || target.getKarma() > 0))
		{
			player.sendMessage("You cannot trade in a chaotic state.");
			return;
		}

		if (player.isInStoreMode() || target.isInStoreMode())
		{
			player.sendPacket(SystemMessageId.CANNOT_TRADE_DISCARD_DROP_ITEM_WHILE_IN_SHOPMODE);
			return;
		}

		if (player.isProcessingTransaction())
		{
			player.sendPacket(SystemMessageId.ALREADY_TRADING);
			return;
		}

		if (target.isProcessingRequest() || target.isProcessingTransaction())
		{
			SystemMessage sm = SystemMessage.getSystemMessage(SystemMessageId.S1_IS_BUSY_TRY_LATER).addCharName(target);
			player.sendPacket(sm);
			return;
		}

		if (target.getTradeRefusal())
		{
			player.sendMessage("Your target is in trade refusal mode.");
			return;
		}

		if (BlockList.isBlocked(target, player))
		{
			SystemMessage sm = SystemMessage.getSystemMessage(SystemMessageId.S1_HAS_ADDED_YOU_TO_IGNORE_LIST).addCharName(target);
			player.sendPacket(sm);
			return;
		}

		if (MathUtil.calculateDistance(player, target, true) > Npc.INTERACTION_DISTANCE)
		{
			player.sendPacket(SystemMessageId.TARGET_TOO_FAR);
			return;
		}

		player.onTransactionRequest(target);
		target.sendPacket(new SendTradeRequest(player.getObjectId()));
		player.sendPacket(SystemMessage.getSystemMessage(SystemMessageId.REQUEST_S1_FOR_TRADE).addCharName(target));
	}
	
	public static void additem(Player player, Player target)
	{
		TradeList tradeList = target.getActiveTradeList();
		
		switch (Rnd.get(5))
		{
			case 0:
			{
				ItemInstance item1 = target.getInventory().addItem("", getRandomArmorItem(), 1, target, null);
				item1.setEnchantLevel(Rnd.get(FakePlayerConfig.MIN_ENCHANT_ARMOR, FakePlayerConfig.MAX_ENCHANT_ARMOR));
				
				TradeItem tradeItem1 = tradeList.addItem(item1.getObjectId(), 1, 0);
				target.sendPacket(new TradeOwnAdd(tradeItem1));
				target.sendPacket(new TradeItemUpdate(tradeList, target));
				
				tradeList.getPartner().sendPacket(new TradeOtherAdd(tradeItem1));
				break;
				
			}
			case 1:
			{
				ItemInstance item1 = target.getInventory().addItem("", getRandomWeaponItem(), 1, target, null);
				item1.setEnchantLevel(Rnd.get(FakePlayerConfig.MIN_ENCHANT_WEAPON, FakePlayerConfig.MAX_ENCHANT_WEAPON));
				
				TradeItem tradeItem1 = tradeList.addItem(item1.getObjectId(), 1, 0);
				target.sendPacket(new TradeOwnAdd(tradeItem1));
				target.sendPacket(new TradeItemUpdate(tradeList, target));
				
				tradeList.getPartner().sendPacket(new TradeOtherAdd(tradeItem1));
				break;
			}
			case 2:
			{
				ItemInstance item1 = target.getInventory().addItem("", getRandomJewelItem(), 1, target, null);
				item1.setEnchantLevel(Rnd.get(FakePlayerConfig.MIN_ENCHANT_JEWEL, FakePlayerConfig.MAX_ENCHANT_JEWEL));
				
				TradeItem tradeItem1 = tradeList.addItem(item1.getObjectId(), 1, 0);
				target.sendPacket(new TradeOwnAdd(tradeItem1));
				target.sendPacket(new TradeItemUpdate(tradeList, target));
				
				tradeList.getPartner().sendPacket(new TradeOtherAdd(tradeItem1));
				break;
			}
			case 3:
			{
				ItemInstance item1 = target.getInventory().addItem("", getRandomEtcItem(), 1, target, null);
				
				TradeItem tradeItem1 = tradeList.addItem(item1.getObjectId(), 1, 0);
				target.sendPacket(new TradeOwnAdd(tradeItem1));
				target.sendPacket(new TradeItemUpdate(tradeList, target));
				
				tradeList.getPartner().sendPacket(new TradeOtherAdd(tradeItem1));
				break;
			}
			case 4:
			{
				ItemInstance item1 = target.getInventory().addItem("", getRandomEtcItem(), Rnd.get(1, 113), target, null);
				
				TradeItem tradeItem1 = tradeList.addItem(item1.getObjectId(), 1, 0);
				target.sendPacket(new TradeOwnAdd(tradeItem1));
				target.sendPacket(new TradeItemUpdate(tradeList, target));
				
				tradeList.getPartner().sendPacket(new TradeOtherAdd(tradeItem1));
				break;
				
			}
		}
		
	}
	
	static int getRandomEtcItem()
	{
		return FakePlayerConfig.LIST_ETC_TRADE_ID.get(Rnd.get(FakePlayerConfig.LIST_ETC_TRADE_ID.size()));
	}
	
	static int getRandomJewelItem()
	{
		return FakePlayerConfig.LIST_JEWEL_TRADE_ID.get(Rnd.get(FakePlayerConfig.LIST_JEWEL_TRADE_ID.size()));
	}
	
	static int getRandomWeaponItem()
	{
		return FakePlayerConfig.LIST_WEAPON_TRADE_ID.get(Rnd.get(FakePlayerConfig.LIST_WEAPON_TRADE_ID.size()));
	}
	
	static int getRandomArmorItem()
	{
		return FakePlayerConfig.LIST_ARMOR_TRADE_ID.get(Rnd.get(FakePlayerConfig.LIST_ARMOR_TRADE_ID.size()));
	}
}