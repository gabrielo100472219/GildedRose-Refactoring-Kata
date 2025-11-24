package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackstagePassesTest {
    @Test
    public void backstagePass_increasesBy1WhenMoreThan10DaysLeft() {
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(21, items[0].quality);
        assertEquals(14, items[0].sellIn);
    }

    @Test
    public void backstagePass_increasesBy2When10DaysOrLess() {
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(22, items[0].quality);
        assertEquals(9, items[0].sellIn);
    }

    @Test
    public void backstagePass_increasesBy2When6To10Days() {
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 7, 20)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(22, items[0].quality);
        assertEquals(6, items[0].sellIn);
    }

    @Test
    public void backstagePass_increasesBy3When5DaysOrLess() {
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(23, items[0].quality);
        assertEquals(4, items[0].sellIn);
    }

    @Test
    public void backstagePass_increasesBy3When1Day() {
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(23, items[0].quality);
        assertEquals(0, items[0].sellIn);
    }

    @Test
    public void backstagePass_dropsTo0AfterConcert() {
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(0, items[0].quality);
        assertEquals(-1, items[0].sellIn);
    }

    @Test
    public void backstagePass_qualityNeverExceeds50() {
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(50, items[0].quality);
    }

    @Test
    public void backstagePass_qualityNeverExceeds50WhenClose() {
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(50, items[0].quality);
    }
}
