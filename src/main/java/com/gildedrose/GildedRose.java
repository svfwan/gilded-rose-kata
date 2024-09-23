package com.gildedrose;

class GildedRose {
    Item[] items;
    ItemUpdateHandler itemUpdateHandler;

    public GildedRose(Item[] items) {
        this.items = items;
        this.itemUpdateHandler = new ItemUpdateHandler();
    }

    public void updateQuality() {
        // Changed to for-each loop
        for (Item item : items) {
            itemUpdateHandler.handle(item);
        }
    }
}
