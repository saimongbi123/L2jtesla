package dev.Phantom.Util;

import dev.l2j.tesla.commons.random.Rnd;
import dev.l2j.tesla.gameserver.model.actor.Player;
import dev.l2j.tesla.gameserver.model.item.instance.ItemInstance;

import java.util.ArrayList;
import java.util.List;

public class ArmorFakePlayer {

	public static void giveArmorByClass(Player player, boolean randomlyEnchant) {
		List<Integer> itemIds = new ArrayList<>();
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
			case ORC_SHAMAN:
			case ORC_MYSTIC:
				int randomRobe = Rnd.get(15);
				switch (randomRobe) {
					case 0:
						itemIds = FakePlayerConfig.LIST_PHANTOM_ROB_ARMOR_1;
						break;
					case 1:
						itemIds = FakePlayerConfig.LIST_PHANTOM_ROB_ARMOR_2;
						break;
					case 2:
						itemIds = FakePlayerConfig.LIST_PHANTOM_ROB_ARMOR_3;
						break;
					case 3:
						itemIds = FakePlayerConfig.LIST_PHANTOM_ROB_ARMOR_4;
						break;
					case 4:
						itemIds = FakePlayerConfig.LIST_PHANTOM_ROB_ARMOR_5;
						break;
					case 5:
						itemIds = FakePlayerConfig.LIST_PHANTOM_ROB_ARMOR_6;
						break;
					case 6:
						itemIds = FakePlayerConfig.LIST_PHANTOM_ROB_ARMOR_7;
						break;
					case 7:
						itemIds = FakePlayerConfig.LIST_PHANTOM_ROB_ARMOR_8;
						break;
					case 8:
						itemIds = FakePlayerConfig.LIST_PHANTOM_ROB_ARMOR_9;
						break;
					case 9:
						itemIds = FakePlayerConfig.LIST_PHANTOM_ROB_ARMOR_10;
						break;
					case 10:
						itemIds = FakePlayerConfig.LIST_PHANTOM_ROB_ARMOR_11;
						break;
					case 11:
						itemIds = FakePlayerConfig.LIST_PHANTOM_ROB_ARMOR_12;
						break;
					case 12:
						itemIds = FakePlayerConfig.LIST_PHANTOM_ROB_ARMOR_13;
						break;
					case 13:
						itemIds = FakePlayerConfig.LIST_PHANTOM_ROB_ARMOR_14;
						break;
					case 14:
						itemIds = FakePlayerConfig.LIST_PHANTOM_ROB_ARMOR_15;
						break;
					default:
						itemIds = FakePlayerConfig.LIST_PHANTOM_ROB_ARMOR_1;
						break;
				}
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
			case DWARVEN_FIGHTER:
			case ORC_FIGHTER:

				int randomHeavy = Rnd.get(20);
				switch (randomHeavy) {
					case 0:
						itemIds = FakePlayerConfig.LIST_PHANTOM_HEAVY_ARMOR_1;
						break;
					case 1:
						itemIds = FakePlayerConfig.LIST_PHANTOM_HEAVY_ARMOR_2;
						break;
					case 2:
						itemIds = FakePlayerConfig.LIST_PHANTOM_HEAVY_ARMOR_3;
						break;
					case 3:
						itemIds = FakePlayerConfig.LIST_PHANTOM_HEAVY_ARMOR_4;
						break;
					case 4:
						itemIds = FakePlayerConfig.LIST_PHANTOM_HEAVY_ARMOR_5;
						break;
					case 5:
						itemIds = FakePlayerConfig.LIST_PHANTOM_HEAVY_ARMOR_6;
						break;
					case 6:
						itemIds = FakePlayerConfig.LIST_PHANTOM_HEAVY_ARMOR_7;
						break;
					case 7:
						itemIds = FakePlayerConfig.LIST_PHANTOM_HEAVY_ARMOR_8;
						break;
					case 8:
						itemIds = FakePlayerConfig.LIST_PHANTOM_HEAVY_ARMOR_9;
						break;
					case 9:
						itemIds = FakePlayerConfig.LIST_PHANTOM_HEAVY_ARMOR_10;
						break;
					case 10:
						itemIds = FakePlayerConfig.LIST_PHANTOM_HEAVY_ARMOR_11;
						break;
					case 12:
						itemIds = FakePlayerConfig.LIST_PHANTOM_HEAVY_ARMOR_12;
						break;
					case 13:
						itemIds = FakePlayerConfig.LIST_PHANTOM_HEAVY_ARMOR_14;
						break;
					case 14:
						itemIds = FakePlayerConfig.LIST_PHANTOM_HEAVY_ARMOR_15;
						break;
					case 15:
						itemIds = FakePlayerConfig.LIST_PHANTOM_HEAVY_ARMOR_16;
						break;
					case 16:
						itemIds = FakePlayerConfig.LIST_PHANTOM_HEAVY_ARMOR_17;
						break;
					case 17:
						itemIds = FakePlayerConfig.LIST_PHANTOM_HEAVY_ARMOR_18;
						break;
					case 18:
						itemIds = FakePlayerConfig.LIST_PHANTOM_HEAVY_ARMOR_19;
						break;
					case 19:
						itemIds = FakePlayerConfig.LIST_PHANTOM_HEAVY_ARMOR_20;
						break;
					default:
						itemIds = FakePlayerConfig.LIST_PHANTOM_HEAVY_ARMOR_1;
						break;
				}
				break;

			case SAGGITARIUS:
			case ADVENTURER:
			case WIND_RIDER:
			case MOONLIGHT_SENTINEL:
			case GHOST_HUNTER:
			case GHOST_SENTINEL:
			case FORTUNE_SEEKER:
			case GRAND_KHAVATARI:

				int randomLight = Rnd.get(19);
				switch (randomLight) {
					case 0:
						itemIds = FakePlayerConfig.LIST_PHANTOM_LIGHT_ARMOR_1;
						break;
					case 1:
						itemIds = FakePlayerConfig.LIST_PHANTOM_LIGHT_ARMOR_2;
						break;
					case 2:
						itemIds = FakePlayerConfig.LIST_PHANTOM_LIGHT_ARMOR_3;
						break;
					case 3:
						itemIds = FakePlayerConfig.LIST_PHANTOM_LIGHT_ARMOR_4;
						break;
                    case 4:
						itemIds = FakePlayerConfig.LIST_PHANTOM_LIGHT_ARMOR_6;
						break;
					case 5:
						itemIds = FakePlayerConfig.LIST_PHANTOM_LIGHT_ARMOR_6;
						break;
					case 6:
						itemIds = FakePlayerConfig.LIST_PHANTOM_LIGHT_ARMOR_7;
						break;
					case 7:
						itemIds = FakePlayerConfig.LIST_PHANTOM_LIGHT_ARMOR_8;
						break;
					case 8:
						itemIds = FakePlayerConfig.LIST_PHANTOM_LIGHT_ARMOR_9;
						break;
					case 9:
						itemIds = FakePlayerConfig.LIST_PHANTOM_LIGHT_ARMOR_10;
						break;
					case 10:
						itemIds = FakePlayerConfig.LIST_PHANTOM_LIGHT_ARMOR_11;
						break;
					case 11:
						itemIds = FakePlayerConfig.LIST_PHANTOM_LIGHT_ARMOR_12;
						break;
					case 12:
						itemIds = FakePlayerConfig.LIST_PHANTOM_LIGHT_ARMOR_13;
						break;
					case 13:
						itemIds = FakePlayerConfig.LIST_PHANTOM_LIGHT_ARMOR_14;
						break;
					case 14:
						itemIds = FakePlayerConfig.LIST_PHANTOM_LIGHT_ARMOR_15;
						break;
					case 15:
						itemIds = FakePlayerConfig.LIST_PHANTOM_LIGHT_ARMOR_16;
						break;
					case 16:
						itemIds = FakePlayerConfig.LIST_PHANTOM_LIGHT_ARMOR_17;
						break;
					case 17:
						itemIds = FakePlayerConfig.LIST_PHANTOM_LIGHT_ARMOR_18;
						break;
					case 18:
						itemIds = FakePlayerConfig.LIST_PHANTOM_LIGHT_ARMOR_19;
						break;
                    default:
                        itemIds = FakePlayerConfig.LIST_PHANTOM_LIGHT_ARMOR_1;
                        break;
                }
				break;
			default:
				break;

		}
		for (int id : itemIds) {
			player.getInventory().addItem("Armors", id, 1, player, null);
			ItemInstance item = player.getInventory().getItemByItemId(id);

			if (randomlyEnchant)
				item.setEnchantLevel(Rnd.get(FakePlayerConfig.MIN_ENCHANT_ARMOR, FakePlayerConfig.MAX_ENCHANT_ARMOR));

			player.getInventory().equipItemAndRecord(item);
			player.getInventory().reloadEquippedItems();
			player.broadcastCharInfo();
		}
	}
}
