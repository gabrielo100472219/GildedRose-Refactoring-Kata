package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SulfurasTest {
    @Test
    public void sulfuras_qualityNeverChanges() {
        final Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 10, 80)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(80, items[0].quality);
    }

    @Test
    public void sulfuras_sellInNeverChanges() {
        final Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 10, 80)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(10, items[0].sellIn);
    }

    @Test
    public void sulfuras_qualityNeverChangesAfterSellDate() {
        final Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", -1, 80)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(80, items[0].quality);
        assertEquals(-1, items[0].sellIn);
    }
}
