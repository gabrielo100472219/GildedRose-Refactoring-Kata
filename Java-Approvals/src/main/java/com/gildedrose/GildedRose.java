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

			if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
				if (item.sellIn < 11) {
					if (item.quality < 50) {
						item.quality = item.quality + 1;
					}
				}

				if (item.sellIn < 6) {
					if (item.quality < 50) {
						item.quality = item.quality + 1;
					}
				}
			}
		}

		item.sellIn = item.sellIn - 1;

		if (item.sellIn < 0) {
			if (!item.name.equals("Aged Brie")) {
				if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
					// normal item
					if (item.quality > 0) {
						item.quality = item.quality - 1;
					}
				} else {
					// backstage passes
					item.quality = 0;
				}
			} else {
				// aged brie
				if (item.quality < 50) {
					item.quality = item.quality + 1;
				}
			}
		}
	}

	private static boolean isNormalItem(Item item) {
		return !item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert");
	}

	private static boolean isSulfuras(Item item) {
		return item.name.equals("Sulfuras, Hand of Ragnaros");
	}
}
