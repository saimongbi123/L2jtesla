package dev.Phantom.ai.addon;

import java.util.List;
import java.util.stream.Collectors;

import dev.Phantom.FakePlayer;
import dev.Phantom.ai.CombatAI;
import dev.Phantom.model.HealingSpell;
import dev.l2j.tesla.gameserver.model.actor.Creature;

public interface IHealer {
	

	
	 default void tryTargetingLowestHpTargetInRadius(final FakePlayer player, final Class<? extends Creature> creatureClass, final int radius) {
	        if (player.getTarget() == null) {
	        	if(player.getTarget() == null) {
	    			List<Creature> targets = player.getKnownTypeInRadius(creatureClass, radius).stream()
	    					.filter(x->!x.isDead())					
	    					.collect(Collectors.toList());
	    			
	    			if (!player.isDead()) {
	                targets.add(player);
	            }
	    			List<Creature> sortedTargets = targets.stream().sorted((x1, x2) -> Double.compare(x1.getCurrentHp(), x2.getCurrentHp())).collect(Collectors.toList());
	    			 if (!sortedTargets.isEmpty()) {
	                final Creature target = sortedTargets.get(0);
	                player.setTarget(target);
	            }
	        }
	        else if (((Creature)player.getTarget()).isDead()) {
	            player.setTarget(null);
	        }
	    }
	 }
	 
	 
	
	default void tryHealingTarget(FakePlayer player) {
		
		if(player.getTarget() != null && player.getTarget() instanceof Creature)
		{
			Creature target = (Creature) player.getTarget();
			if(player.getFakeAi() instanceof CombatAI) {
				HealingSpell skill = ((CombatAI)player.getFakeAi()).getRandomAvaiableHealingSpellForTarget();
				if(skill != null) {
					switch(skill.getCondition()){
						case LESSHPPERCENT:
							double currentHpPercentage = Math.round(100.0 / target.getMaxHp() * target.getCurrentHp());
							if(currentHpPercentage <= skill.getConditionValue()) {
								player.getFakeAi().castSpell(player.getSkill(skill.getSkillId()));						
							}						
							break;				
						default:
							break;							
					}
					
				}
			}
		}
	}
}
