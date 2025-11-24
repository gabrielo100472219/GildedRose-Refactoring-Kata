package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NormalItemsTest {
    @Test
    public void normalItem_decreasesQualityBy1BeforeSellDate() {
        final Item[] items = new Item[]{new Item("Normal Item", 5, 10)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(9, items[0].quality);
        assertEquals(4, items[0].sellIn);
    }

    @Test
    public void normalItem_decreasesQualityBy2AfterSellDate() {
        final Item[] items = new Item[]{new Item("Normal Item", 0, 10)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(8, items[0].quality);
        assertEquals(-1, items[0].sellIn);
    }

    @Test
    public void normalItem_qualityNeverNegative() {
        final Item[] items = new Item[]{new Item("Normal Item", 5, 0)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(0, items[0].quality);
    }

    @Test
    public void normalItem_qualityDoesNotGoBelowZeroAfterSellDate() {
        final Item[] items = new Item[]{new Item("Normal Item", -1, 1)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(0, items[0].quality);
    }
}
