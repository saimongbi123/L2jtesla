package dev.l2j.tesla.gameserver.network.clientpackets;

import dev.l2j.tesla.gameserver.data.manager.SevenSignsManager;
import dev.l2j.tesla.gameserver.model.actor.Player;
import dev.l2j.tesla.gameserver.network.serverpackets.SSQStatus;

public final class RequestSSQStatus extends L2GameClientPacket
{
	private int _page;

	@Override
	protected void readImpl()
	{
		_page = readC();
	}

	@Override
	protected void runImpl()
	{
		Player activeChar = getClient().getPlayer();
		if ((activeChar == null) || ((SevenSignsManager.getInstance().isSealValidationPeriod() || SevenSignsManager.getInstance().isCompResultsPeriod()) && _page == 4))
			return;

		activeChar.sendPacket(new SSQStatus(activeChar.getObjectId(), _page));
	}
}