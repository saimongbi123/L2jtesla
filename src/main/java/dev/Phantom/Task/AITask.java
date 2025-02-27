package dev.Phantom.Task;

import dev.Phantom.FakePlayer;
import dev.Phantom.FakePlayerManager;

import java.util.List;

public class AITask implements Runnable
{
	private final int _from;
	private int _to;
	
	

	public AITask(int from, int to)
	{
		_from = from;
		_to = to;
		
	
	}

	@Override
	public void run()
	{
		adjustPotentialIndexOutOfBounds();
		List<FakePlayer> fakePlayers = FakePlayerManager.getFakePlayers().subList(_from, _to);
		try
		{
			if (fakePlayers != null) {
				fakePlayers.stream()
						.filter(x -> x != null && x.getFakeAi() != null && !x.getFakeAi().isBusyThinking())
						.forEach(x -> x.getFakeAi().thinkAndAct());
			}

		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

	}

	private void adjustPotentialIndexOutOfBounds()
	{
		if (_to > FakePlayerManager.getFakePlayersCount())
			_to = FakePlayerManager.getFakePlayersCount();
	}
}
