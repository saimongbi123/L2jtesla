package dev.l2j.tesla.gameserver.network.clientpackets;

import dev.l2j.tesla.gameserver.model.actor.Player;
import dev.l2j.tesla.gameserver.network.serverpackets.UserInfo;

public final class Appearing extends L2GameClientPacket
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

		if (activeChar.isTeleporting())
			activeChar.onTeleported();

		sendPacket(new UserInfo(activeChar));
	}

	@Override
	protected boolean triggersOnActionRequest()
	{
		return false;
	}
}