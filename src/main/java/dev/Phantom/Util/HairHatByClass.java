package dev.Phantom.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dev.l2j.tesla.commons.random.Rnd;
import dev.l2j.tesla.gameserver.model.actor.Player;
import dev.l2j.tesla.gameserver.model.item.instance.ItemInstance;

public class HairHatByClass {
	public static void giveAcessoryByClass(Player player) {
		List<Integer> itemIds = new ArrayList<>();
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
			itemIds = Arrays.asList(getRandomAcessory());
			break;
		default:
			break;
		}
		for (int id : itemIds) {
			player.getInventory().addItem("Accessory", id, 1, player, null);
			ItemInstance item = player.getInventory().getItemByItemId(id);
			player.getInventory().equipItemAndRecord(item);
			player.getInventory().reloadEquippedItems();
		}
	}

	public static int getRandomAcessory() {
		return FakePlayerConfig.LIST_FAKE_ACCESSORY.get(Rnd.get(FakePlayerConfig.LIST_FAKE_ACCESSORY.size()));
	}
}
