package dev.l2j.tesla.gameserver.skills.effects;

import dev.l2j.tesla.gameserver.enums.skills.L2EffectFlag;
import dev.l2j.tesla.gameserver.enums.skills.L2EffectType;
import dev.l2j.tesla.gameserver.model.L2Effect;
import dev.l2j.tesla.gameserver.skills.Env;

public class EffectMute extends L2Effect
{
	public EffectMute(Env env, EffectTemplate template)
	{
		super(env, template);
	}

	@Override
	public L2EffectType getEffectType()
	{
		return L2EffectType.MUTE;
	}

	@Override
	public boolean onStart()
	{
		getEffected().startMuted();
		return true;
	}

	@Override
	public boolean onActionTime()
	{
		// Simply stop the effect
		return false;
	}

	@Override
	public void onExit()
	{
		getEffected().stopMuted(false);
	}

	@Override
	public int getEffectFlags()
	{
		return L2EffectFlag.MUTED.getMask();
	}
}