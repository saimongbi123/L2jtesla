package dev.Phantom.Util;

import dev.l2j.tesla.commons.random.Rnd;
import dev.l2j.tesla.gameserver.model.L2Augmentation;
import dev.l2j.tesla.gameserver.model.actor.Player;
import dev.l2j.tesla.gameserver.model.item.instance.ItemInstance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeaponsByClass {
	public static void giveWeaponsByClass(Player player, boolean randomlyEnchant) {
		List<Integer> itemIds = new ArrayList<>();
		switch (player.getClassId()) {
		case GHOST_HUNTER:
		case WIND_RIDER:
		case ADVENTURER:
			itemIds = Arrays.asList(getRandomDagger());
			break;
		case SAGGITARIUS:
		case MOONLIGHT_SENTINEL:
		case GHOST_SENTINEL:
			itemIds = Arrays.asList(getRandomBow());
			break;
		case PHOENIX_KNIGHT:
		case SWORD_MUSE:
		case HELL_KNIGHT:
		case EVAS_TEMPLAR:
		case SHILLIEN_TEMPLAR:
			itemIds = Arrays.asList(getRandomSword(), getRandomShield());
			break;
		case FORTUNE_SEEKER:
		case MAESTRO:
			itemIds = Arrays.asList(6585, 6377);
			break;
		case TITAN:
			itemIds = Arrays.asList(getRandomBigSword());
			break;
		case DUELIST:
		case SPECTRAL_DANCER:
			itemIds = Arrays.asList(getRandomDualSword());
			break;
		case DREADNOUGHT:
			itemIds = Arrays.asList(getRandomSpear());
			break;
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
			itemIds = Arrays.asList(getRandomMagicWeapon());
			break;
		case GRAND_KHAVATARI:
			itemIds = Arrays.asList(getRandomFist());
			break;
		default:
			break;
		}
		for (int id : itemIds) {
			player.getInventory().addItem("Weapon", id, 1, player, null);
			ItemInstance item = player.getInventory().getItemByItemId(id);

			if (randomlyEnchant)
				item.setEnchantLevel(Rnd.get(FakePlayerConfig.MIN_ENCHANT_WEAPON, FakePlayerConfig.MAX_ENCHANT_WEAPON));
			if (Rnd.get(100) < 30)
				item.setAugmentation(new L2Augmentation(1067847165, 3250, 1));
			player.getInventory().equipItemAndRecord(item);
			player.getInventory().reloadEquippedItems();
		}
	}

	public static int getRandomDagger() {
		return FakePlayerConfig.LIST_FAKE_DAGGER.get(Rnd.get(FakePlayerConfig.LIST_FAKE_DAGGER.size()));
	}

	public static int getRandomBow() {
		return FakePlayerConfig.LIST_FAKE_BOW.get(Rnd.get(FakePlayerConfig.LIST_FAKE_BOW.size()));
	}

	public static int getRandomSword() {
		return FakePlayerConfig.LIST_FAKE_SWORD.get(Rnd.get(FakePlayerConfig.LIST_FAKE_SWORD.size()));
	}

	public static int getRandomSpear() {
		return FakePlayerConfig.LIST_FAKE_SPEAR.get(Rnd.get(FakePlayerConfig.LIST_FAKE_SPEAR.size()));
	}

	public static int getRandomDualSword() {
		return FakePlayerConfig.LIST_FAKE_DUAL.get(Rnd.get(FakePlayerConfig.LIST_FAKE_DUAL.size()));
	}

	public static int getRandomFist() {
		return FakePlayerConfig.LIST_FAKE_FIST.get(Rnd.get(FakePlayerConfig.LIST_FAKE_FIST.size()));
	}

	public static int getRandomBigSword() {
		return FakePlayerConfig.LIST_FAKE_BIG_SWORD.get(Rnd.get(FakePlayerConfig.LIST_FAKE_BIG_SWORD.size()));
	}

	public static int getRandomMagicWeapon() {
		return FakePlayerConfig.LIST_FAKE_MAGIC.get(Rnd.get(FakePlayerConfig.LIST_FAKE_MAGIC.size()));
	}

	public static int getRandomShield() {
		return FakePlayerConfig.LIST_FAKE_SHIELD.get(Rnd.get(FakePlayerConfig.LIST_FAKE_SHIELD.size()));
	}

}
