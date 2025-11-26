package com.gildedrose;

class GildedRose {
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (final Item item : this.items) {
			updateItem(item);
		}
	}

	private static void updateItem(Item item) {
		if (isSulfuras(item)) {
			return;
		}

		item.sellIn--;

		if (isAgedBrie(item)) {
			updateAgedBrie(item);
			return;
		}

		if (isBackstagePasses(item)) {
			updateBackstagePasses(item);
			return;
		}

		updateNormalItem(item);
	}

	private static void updateNormalItem(Item item) {
		if (item.quality > 0) {
			item.quality = item.quality - 1;
		}

		if (item.sellIn < 0 && item.quality > 0) {
			item.quality = item.quality - 1;
		}
	}

	private static void updateAgedBrie(Item item) {
		if (item.quality < 50) {
			item.quality = item.quality + 1;
		}

		if (item.sellIn < 0 && item.quality < 50) {
			item.quality++;
		}
	}

	private static void updateBackstagePasses(Item item) {
		if (item.sellIn < 0) {
			item.quality = 0;
			return;
		}

		if (item.quality < 50) {
			item.quality = item.quality + 1;

			if (item.sellIn < 10 && item.quality < 50) {
				item.quality = item.quality + 1;
			}

			if (item.sellIn < 5 && item.quality < 50) {
				item.quality = item.quality + 1;
			}
		}
	}

	private static boolean isAgedBrie(Item item) {
		return item.name.equals("Aged Brie");
	}

	private static boolean isBackstagePasses(Item item) {
		return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
	}

	private static boolean isSulfuras(Item item) {
		return item.name.equals("Sulfuras, Hand of Ragnaros");
	}
}
