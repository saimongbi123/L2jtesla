package dev.Phantom.Util;

import java.util.ArrayList;
import java.util.List;

import dev.l2j.tesla.commons.random.Rnd;
import dev.l2j.tesla.gameserver.model.actor.Player;
import dev.l2j.tesla.gameserver.model.item.instance.ItemInstance;

public class JewelsByClass {
	public static void giveJewelsByClass(Player player, boolean randomlyEnchant) {
		List<int[]> itemIds = new ArrayList<>();
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
			int randomJewels = Rnd.get(2);
			switch (randomJewels) {
			case 0:
				itemIds = FakePlayerConfig.LIST_PHANTOM_JEWELS_1;
				break;
			case 1:
				itemIds = FakePlayerConfig.LIST_PHANTOM_JEWELS_2;
				break;
			default:
				itemIds = FakePlayerConfig.LIST_PHANTOM_JEWELS_1;
				break;
			}
			break;
		default:
			break;
		}
		for (int[] id : itemIds) {
			ItemInstance item = player.getInventory().addItem("Jewels", id[0], id[1], player, null);

			if (randomlyEnchant)
				item.setEnchantLevel(Rnd.get(FakePlayerConfig.MIN_ENCHANT_JEWEL, FakePlayerConfig.MAX_ENCHANT_JEWEL));

			player.getInventory().equipItemAndRecord(item);
			player.getInventory().reloadEquippedItems();
		}
	}
}