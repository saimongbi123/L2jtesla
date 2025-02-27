package dev.l2j.tesla.gameserver.network.clientpackets;

import dev.l2j.tesla.gameserver.model.actor.Player;
import dev.l2j.tesla.gameserver.network.serverpackets.NpcHtmlMessage;

/**
 * @author zabbix Lets drink to code!
 */
public final class RequestLinkHtml extends L2GameClientPacket
{
	private String _link;

	@Override
	protected void readImpl()
	{
		_link = readS();
	}

	@Override
	public void runImpl()
	{
		final Player actor = getClient().getPlayer();
		if ((actor == null) || _link.contains("..") || !_link.contains(".htm"))
			return;

		final NpcHtmlMessage html = new NpcHtmlMessage(0);
		html.setFile(_link);
		sendPacket(html);
	}
}