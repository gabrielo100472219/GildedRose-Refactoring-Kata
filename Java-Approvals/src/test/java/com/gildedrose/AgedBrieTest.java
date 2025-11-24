package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgedBrieTest {
    @Test
    public void agedBrie_increasesQualityBy1BeforeSellDate() {
        final Item[] items = new Item[]{new Item("Aged Brie", 5, 10)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(11, items[0].quality);
        assertEquals(4, items[0].sellIn);
    }

    @Test
    public void agedBrie_increasesQualityBy2AfterSellDate() {
        final Item[] items = new Item[]{new Item("Aged Brie", 0, 10)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(12, items[0].quality);
        assertEquals(-1, items[0].sellIn);
    }

    @Test
    public void agedBrie_qualityNeverExceeds50() {
        final Item[] items = new Item[]{new Item("Aged Brie", 5, 50)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(50, items[0].quality);
    }

    @Test
    public void agedBrie_qualityNeverExceeds50AfterSellDate() {
        final Item[] items = new Item[]{new Item("Aged Brie", -1, 49)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(50, items[0].quality);
    }
}
