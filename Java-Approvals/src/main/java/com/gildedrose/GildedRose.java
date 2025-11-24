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

		if (isNormalItem(item) && item.quality > 0) {
			item.quality = item.quality - 1;
		}
		if (!isNormalItem(item) && item.quality < 50) {
			item.quality = item.quality + 1;

			if (isBackstagePasses(item)) {
				if (item.sellIn < 11 && item.quality < 50) {
					item.quality = item.quality + 1;
				}

				if (item.sellIn < 6 && item.quality < 50) {
					item.quality = item.quality + 1;
				}
			}
		}

		item.sellIn = item.sellIn - 1;

		if (item.sellIn < 0) {
			if (isAgedBrie(item) && item.quality < 50) {
				item.quality = item.quality + 1;
			}
			if (isBackstagePasses(item)) {
				item.quality = 0;
			}

			if (isNormalItem(item) && item.quality > 0) {
				item.quality = item.quality - 1;
			}
		}
	}

	private static boolean isAgedBrie(Item item) {
		return item.name.equals("Aged Brie");
	}

	private static boolean isBackstagePasses(Item item) {
		return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
	}

	private static boolean isNormalItem(Item item) {
		return !isAgedBrie(item) && !isBackstagePasses(item);
	}

	private static boolean isSulfuras(Item item) {
		return item.name.equals("Sulfuras, Hand of Ragnaros");
	}
}
