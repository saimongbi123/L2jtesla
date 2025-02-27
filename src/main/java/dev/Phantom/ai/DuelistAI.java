package dev.Phantom.ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dev.Phantom.FakePlayer;
import dev.Phantom.FakePlayerManager;
import dev.Phantom.Helpers.FakeHelpers;
import dev.Phantom.ai.addon.IConsumableSpender;
import dev.Phantom.model.HealingSpell;
import dev.Phantom.model.OffensiveSpell;
import dev.Phantom.model.SpellUsageCondition;
import dev.Phantom.model.SupportSpell;
import dev.l2j.tesla.Config;
import dev.l2j.tesla.gameserver.enums.items.ShotType;

public class DuelistAI extends CombatAI implements IConsumableSpender {
	
	public DuelistAI(FakePlayer character) {
		super(character);
	}

	
	@Override
	public void thinkAndAct() {
		super.thinkAndAct();
		setBusyThinking(true);
		applyDefaultBuffs();
		handleShots();
		selfSupportBuffs();
		tryTargetRandomCreatureByTypeInRadius(FakeHelpers.getTestTargetClass(), FakeHelpers.getTestTargetRange());
		if(Config.FAKE_PLAYER_CAN_TARGET_REAL_PLAYER == true)
		{
			tryFlagTargetRandom(FakeHelpers.getFlagTargetClass(), FakeHelpers.getTestTargetRange());
		}
		
		tryAttackingUsingFighterOffensiveSkill();
		
		
		setBusyThinking(false);
	}

	@Override
	protected ShotType getShotType() {
		return ShotType.SOULSHOT;
	}	
	
	@Override
	protected double changeOfUsingSkill() {
		return 0.5;
	}

	@Override
	protected List<OffensiveSpell> getOffensiveSpells() {
		List<OffensiveSpell> _offensiveSpells = new ArrayList<>();
		_offensiveSpells.add(new OffensiveSpell(345, 1));
		_offensiveSpells.add(new OffensiveSpell(261, 2));		
		_offensiveSpells.add(new OffensiveSpell(5, 3));		
		_offensiveSpells.add(new OffensiveSpell(6, 4));		
		_offensiveSpells.add(new OffensiveSpell(1, 5));
		return _offensiveSpells;
	}
	
	@Override
	protected List<SupportSpell> getSelfSupportSpells() {
		List<SupportSpell> _selfSupportSpells = new ArrayList<>();
		_selfSupportSpells.add(new SupportSpell(99, 1));
		_selfSupportSpells.add(new SupportSpell(97, 1));
		_selfSupportSpells.add(new SupportSpell(440, SpellUsageCondition.MISSINGCP, 1000, 1));
		return _selfSupportSpells;
	}
	
    @Override
    protected ArrayList<Integer> getBuffs() {
        return FakePlayerManager.getFighterBuffs();
    }
	
	@Override
	protected List<HealingSpell> getHealingSpells()
	{		
		return Collections.emptyList();
	}
	

}
