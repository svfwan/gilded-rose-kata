package com.gildedrose;

class GildedRose {
    Item[] items;
    ItemUpdateHandler itemUpdateHandler;

    public GildedRose(Item[] items) {
        this.items = items;
        this.itemUpdateHandler = new ItemUpdateHandler();
    }

    // increase, decrease Quality functions
    // create static variables for names of exception items
    // use switch for exceptions i.e. Aged Brie, Sulfuras, Backstage passes, "Conjured" items and otherwise
    // or check if enum value matches
    // process item normally
    // Check for backstage pass item is hardcoded, needs to be more dynamic i.e. startsWith "Backstage passes"
    // create unit tests for all cases
    // (possibly create interface for accessing Items class


    // every item decreases sellIn date (except Sulfuras)
    // Aged Brie increases quality per day passed
    // Sulfuras sellIn and quality stay same
    // Backstage passes increase quality like Aged Brie
    // except: if sellIn < 11 then quality +2, if sellIn < 6 then quality +3, after sellIn < 0 then quality = 0
    // "Conjured XY" quality decreases -2 per day
    // Item can not have quality above 50, except Sulfuras fixed at 80 always


    // Aged Brie
    // Backstage passes to a TAFKAL80ETC concert
    // Sulfuras, Hand of Ragnaros

    public void updateQuality() {
        // Changed to for-each loop
        for (Item item : items) {
            itemUpdateHandler.handle(item);
        }
    }
}
