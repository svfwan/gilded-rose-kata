package com.gildedrose;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class ItemUpdateHandler {

    private interface ItemUpdateStrategy {
        void update(Item item);
    }

    private final Map<String, ItemUpdateStrategy> strategies = new HashMap<>();

    public ItemUpdateHandler() {
        strategies.put("Standard Item", this::updateStandardItem);
        strategies.put("Aged Brie", this::updateAgedBrie);
        strategies.put("Sulfuras, Hand of Ragnaros", this::updateSulfuras);
        strategies.put("Backstage passes to a TAFKAL80ETC concert", this::updateBackstagePass);
        strategies.put("Conjured Mana Cake", this::updateConjured);
    }

    public void handle(@NotNull Item item) {
        ItemUpdateStrategy strategy = strategies.getOrDefault(item.name, this::updateStandardItem);
        strategy.update(item);
    }

    private void updateStandardItem(@NotNull Item item) {
        item.sellIn--;
        if (item.sellIn < 0 && item.quality - 1 > 0) {
            item.quality -= 2;
        } else if (item.quality > 0) {
            item.quality--;
        }
    }

    private void updateAgedBrie(@NotNull Item item) {
        item.sellIn--;
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void updateBackstagePass(@NotNull Item item) {
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = 0;
        } else if (item.sellIn <= 5 && item.quality + 2 < 50) {
            item.quality += 2;
        } else if (item.sellIn <= 10 && item.quality + 3 < 50) {
            item.quality += 3;
        } else if (item.quality < 50) {
            item.quality++;
        }
    }

    private void updateSulfuras(@NotNull Item item) {
        item.sellIn--;
    }

    private void updateConjured(@NotNull Item item) {
        item.sellIn--;
        if (item.sellIn < 0 && item.quality - 3 > 0) {
            item.quality -= 4;
        } else if (item.quality - 1 > 0) {
            item.quality -= 2;
        }
    }
}
