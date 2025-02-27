package dev.Phantom.Util;

import dev.l2j.tesla.gameserver.data.ItemTable;
import dev.l2j.tesla.gameserver.model.actor.Player;

public class InvetoryItemsByClass {

	public static void giveItemsInventory(Player player) {
		switch (player.getClassId()) {
		case DUELIST:
		case DREADNOUGHT:
		case PHOENIX_KNIGHT:
		case HELL_KNIGHT:
		case SAGGITARIUS:
		case ADVENTURER:
		case ARCHMAGE:
		case SOULTAKER:
		case ARCANA_LORD:
		case CARDINAL:
		case HIEROPHANT:
		case EVAS_TEMPLAR:
		case SWORD_MUSE:
		case WIND_RIDER:
		case MOONLIGHT_SENTINEL:
		case MYSTIC_MUSE:
		case ELEMENTAL_MASTER:
		case EVAS_SAINT:
		case SHILLIEN_TEMPLAR:
		case SPECTRAL_DANCER:
		case GHOST_HUNTER:
		case GHOST_SENTINEL:
		case STORM_SCREAMER:
		case SPECTRAL_MASTER:
		case SHILLIEN_SAINT:
		case TITAN:
		case GRAND_KHAVATARI:
		case DOMINATOR:
		case DOOMCRYER:
		case FORTUNE_SEEKER:
		case MAESTRO:

		case BOUNTY_HUNTER:
		case DESTROYER:
		case HAWKEYE:
		case OVERLORD:
		case SORCERER:
		case SPELLHOWLER:
		case SPELLSINGER:
		case TREASURE_HUNTER:
		case PHANTOM_RANGER:

		case CLERIC:
		case ELVEN_WIZARD:
		case ORC_SHAMAN:
		case WARRIOR:
		case ELVEN_SCOUT:
		case ASSASSIN:
			for (final int[] reward : FakePlayerConfig.STARTING_PHANTOM_ITEMS) {
				if (ItemTable.getInstance().createDummyItem(reward[0]).isStackable())
					player.getInventory().addItem("Phatoms Items", reward[0], reward[1], player, null);
				else
					for (int i = 0; i < reward[1]; ++i)
						player.getInventory().addItem("Phatoms Items", reward[0], 1, player, null);
			}
			break;
		default:
			break;
		}

	}
}
