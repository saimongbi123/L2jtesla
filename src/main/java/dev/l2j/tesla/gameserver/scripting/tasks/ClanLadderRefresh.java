package dev.l2j.tesla.gameserver.scripting.tasks;

import dev.l2j.tesla.gameserver.data.sql.ClanTable;
import dev.l2j.tesla.gameserver.scripting.ScheduledQuest;

public final class ClanLadderRefresh extends ScheduledQuest
{
	public ClanLadderRefresh()
	{
		super(-1, "tasks");
	}

	@Override
	public final void onStart()
	{
		ClanTable.getInstance().refreshClansLadder(true);
	}

	@Override
	public final void onEnd()
	{
	}
}