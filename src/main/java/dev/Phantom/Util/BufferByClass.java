package dev.Phantom.Util;

import java.util.ArrayList;
import java.util.List;

import dev.l2j.tesla.gameserver.data.SkillTable;
import dev.l2j.tesla.gameserver.model.L2Skill;
import dev.l2j.tesla.gameserver.model.actor.Player;

public class BufferByClass {

	public static void giveBuffsByClass(Player player) {
		List<Integer> buffList = new ArrayList<>();
		switch (player.getClassId()) {
		case ARCHMAGE:
		case SOULTAKER:
		case HIEROPHANT:
		case ARCANA_LORD:
		case CARDINAL:
		case MYSTIC_MUSE:
		case ELEMENTAL_MASTER:
		case EVAS_SAINT:
		case STORM_SCREAMER:
		case SPECTRAL_MASTER:
		case SHILLIEN_SAINT:
		case DOMINATOR:
		case DOOMCRYER:
		case CLERIC:
		case ELVEN_WIZARD:

		case SORCERER:
		case SPELLSINGER:
		case OVERLORD:
			buffList = FakePlayerConfig.NUKER_BUFFER_LIST;
			break;
		case SAGGITARIUS:
		case MOONLIGHT_SENTINEL:
		case ROGUE:
		case ASSASSIN:

		case PHANTOM_RANGER:
		case HAWKEYE:
		case SILVER_RANGER:

			buffList = FakePlayerConfig.ARCHER_BUFFER_LIST;
			break;
		case DUELIST:
		case DREADNOUGHT:
		case PHOENIX_KNIGHT:
		case SWORD_MUSE:
		case HELL_KNIGHT:
		case SPECTRAL_DANCER:
		case EVAS_TEMPLAR:
		case SHILLIEN_TEMPLAR:
		case TITAN:
		case MAESTRO:
		case KNIGHT:
		case MONK:
		case ORC_RAIDER:

		case GLADIATOR:
		case DESTROYER:
		case SHILLIEN_KNIGHT:
			buffList = FakePlayerConfig.WARRIOR_BUFFER_LIST;
			break;
		case ADVENTURER:
		case WIND_RIDER:
		case GHOST_HUNTER:
		case FORTUNE_SEEKER:
		case GRAND_KHAVATARI:
			buffList = FakePlayerConfig.DAGGER_BUFFER_LIST;
			break;
		default:
			buffList = FakePlayerConfig.RANDOM_BUFFER_LIST;
			break;

		}
		for (Integer skillid : buffList) {
			L2Skill skill = SkillTable.getInstance().getInfo(skillid, SkillTable.getInstance().getMaxLevel(skillid));
			if (skill != null)
				skill.getEffects(player, player);
		}
	}

}
