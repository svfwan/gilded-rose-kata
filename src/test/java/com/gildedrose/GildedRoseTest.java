package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    @Test
    void standardItemUpdateTest() {
        Item[] items = new Item[]{
            new Item("Iron Sword", 1, 4)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        this.assertItem(app.items[0], 0, 3);
        app.updateQuality();
        this.assertItem(app.items[0], -1, 1);
        app.updateQuality();
        this.assertItem(app.items[0], -2, 0);
    }

    @Test
    void agedBrieTest() {
        Item[] items = new Item[]{
            new Item("Aged Brie", 1, 49)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        this.assertItem(app.items[0], 0, 50);
        app.updateQuality();
        this.assertItem(app.items[0], -1, 50);
    }

    @Test
    void sulfurasTest() {
        Item[] items = new Item[]{
            new Item("Sulfuras, Hand of Ragnaros", 1, 80)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        this.assertItem(app.items[0], 0, 80);
        app.updateQuality();
        this.assertItem(app.items[0], -1, 80);
    }

    @Test
    void backStagePassTest() {
        Item[] items = new Item[]{
            new Item("Backstage passes to a TAFKAL80ETC concert", 11, 2)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        this.assertItem(app.items[0], 10, 4);
        app.updateQuality();
        this.assertItem(app.items[0], 9, 6);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        this.assertItem(app.items[0], 5, 15);
        app.updateQuality();
        this.assertItem(app.items[0], 4, 18);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        this.assertItem(app.items[0], -1, 0);
    }

    @Test
    void conjuredItemTest() {
        Item[] items = new Item[]{
            new Item("Conjured Mana Cake", 1, 8)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        this.assertItem(app.items[0], 0, 6);
        app.updateQuality();
        this.assertItem(app.items[0], -1, 2);
        app.updateQuality();
        this.assertItem(app.items[0], -2, 0);
    }


    private void assertItem(Item item, int sellIn, int quality) {
        assertEquals(sellIn, item.sellIn);
        assertEquals(quality, item.quality);
    }
}
