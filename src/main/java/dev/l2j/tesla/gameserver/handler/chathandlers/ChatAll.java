package dev.l2j.tesla.gameserver.handler.chathandlers;

import java.util.StringTokenizer;

import dev.l2j.tesla.gameserver.handler.IChatHandler;
import dev.l2j.tesla.gameserver.handler.IVoicedCommandHandler;
import dev.l2j.tesla.gameserver.handler.VoicedCommandHandler;
import dev.l2j.tesla.gameserver.model.actor.Player;
import dev.l2j.tesla.gameserver.model.actor.player.BlockList;
import dev.l2j.tesla.gameserver.network.FloodProtectors;
import dev.l2j.tesla.gameserver.network.serverpackets.CreatureSay;

public class ChatAll implements IChatHandler
{
	private static final int[] COMMAND_IDS =
	{
		0
	};

	@Override
	public void handleChat(int type, Player activeChar, String params, String text)
	{
		if (!FloodProtectors.performAction(activeChar.getClient(), FloodProtectors.Action.GLOBAL_CHAT))
			return;


		boolean vcd_used = false;
		if (text.startsWith("."))
		{
		    StringTokenizer st = new StringTokenizer(text);
		    IVoicedCommandHandler vch;
		    String command = "";
		    if (st.countTokens() > 1)
		    {
		        command = st.nextToken().substring(1);
		        text = text.substring(command.length() + 2);
		        vch = VoicedCommandHandler.getInstance().getVoicedCommandHandler(command);
		    }
		    else
		    {
		        command = text.substring(1);
		        vch = VoicedCommandHandler.getInstance().getVoicedCommandHandler(command);
		    }

		    if (vch != null)
		    {
		        vch.useVoicedCommand(command, activeChar, text);
		        vcd_used = true;

		    }
		}
		if (!vcd_used)
		{
			final CreatureSay cs = new CreatureSay(activeChar.getObjectId(), type, activeChar.getName(), text);
			for (Player player : activeChar.getKnownTypeInRadius(Player.class, 1250))
			{
				if (!BlockList.isBlocked(player, activeChar))
					player.sendPacket(cs);
			}
			activeChar.sendPacket(cs);

		}

		//final CreatureSay cs = new CreatureSay(activeChar.getObjectId(), type, activeChar.getName(), text);
		//for (Player player : activeChar.getKnownTypeInRadius(Player.class, 1250))
		//{
			//if (!BlockList.isBlocked(player, activeChar))
				//player.sendPacket(cs);
		//}
		//activeChar.sendPacket(cs);
	}

	@Override
	public int[] getChatTypeList()
	{
		return COMMAND_IDS;
	}
}