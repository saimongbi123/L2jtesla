package dev.l2j.tesla.gameserver.network.clientpackets;

import dev.l2j.tesla.gameserver.model.actor.Player;
import dev.l2j.tesla.gameserver.network.serverpackets.ItemList;

public final class RequestItemList extends L2GameClientPacket
{
	@Override
	protected void readImpl()
	{
	}

	@Override
	protected void runImpl()
	{
		final Player activeChar = getClient().getPlayer();
		if (activeChar == null)
			return;

		if (!activeChar.isInventoryDisabled())
			sendPacket(new ItemList(activeChar, true));
	}
}