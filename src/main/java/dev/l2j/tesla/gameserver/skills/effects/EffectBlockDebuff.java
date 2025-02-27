package dev.l2j.tesla.gameserver.skills.effects;

import dev.l2j.tesla.gameserver.enums.skills.L2EffectType;
import dev.l2j.tesla.gameserver.model.L2Effect;
import dev.l2j.tesla.gameserver.skills.Env;

public class EffectBlockDebuff extends L2Effect
{
	public EffectBlockDebuff(Env env, EffectTemplate template)
	{
		super(env, template);
	}

	@Override
	public L2EffectType getEffectType()
	{
		return L2EffectType.BLOCK_DEBUFF;
	}

	@Override
	public boolean onActionTime()
	{
		return false;
	}
}