package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
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

    public void updateQuality() {
        // Changed to for-each loop
        for (Item item : items) {
            if (!item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < 50) {
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
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        // Simplified the items quality to be set as 0, item can not have negative quality once
                        // sellIn date is passed
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}
