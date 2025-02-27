package dev.Phantom.ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dev.Phantom.FakePlayer;
import dev.Phantom.FakePlayerManager;
import dev.Phantom.Helpers.FakeHelpers;
import dev.Phantom.model.HealingSpell;
import dev.Phantom.model.OffensiveSpell;
import dev.Phantom.model.SupportSpell;
import dev.l2j.tesla.Config;
import dev.l2j.tesla.gameserver.enums.items.ShotType;

public class WindRiderAI extends CombatAI
{
	public WindRiderAI(FakePlayer character)
	{
		super(character);
	}
	
	@Override
	public void thinkAndAct()
	{
		super.thinkAndAct();
		setBusyThinking(true);
		applyDefaultBuffs();
		handleShots();			
		tryTargetRandomCreatureByTypeInRadius(FakeHelpers.getTestTargetClass(), FakeHelpers.getTestTargetRange());
		if(Config.FAKE_PLAYER_CAN_TARGET_REAL_PLAYER == true)
		{
			tryFlagTargetRandom(FakeHelpers.getFlagTargetClass(), FakeHelpers.getTestTargetRange());
		}
		tryAttackingUsingFighterOffensiveSkill();
		
		setBusyThinking(false);
	}
	
	@Override
	protected ShotType getShotType()
	{
		return ShotType.SOULSHOT;
	}
	
	@Override
	protected List<OffensiveSpell> getOffensiveSpells()
	{
		List<OffensiveSpell> _offensiveSpells = new ArrayList<>();
		_offensiveSpells.add(new OffensiveSpell(263, 1));
		_offensiveSpells.add(new OffensiveSpell(12, 2));
		_offensiveSpells.add(new OffensiveSpell(410, 3));
		_offensiveSpells.add(new OffensiveSpell(102, 4));
		_offensiveSpells.add(new OffensiveSpell(321, 5));
		_offensiveSpells.add(new OffensiveSpell(344, 6));
		_offensiveSpells.add(new OffensiveSpell(358, 7));	
		return _offensiveSpells; 
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
	
	@Override
	protected List<SupportSpell> getSelfSupportSpells() {
		return Collections.emptyList();
	}
}