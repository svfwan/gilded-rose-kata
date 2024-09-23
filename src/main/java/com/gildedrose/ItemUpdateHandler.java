package com.gildedrose;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class ItemUpdateHandler {

    private interface ItemUpdateStrategy {
        void update(Item item);
    }

    private int MAX_QUALITY = 50;
    private int MIN_QUALITY = 0;

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
        int decrease;
        if (item.sellIn < 0) {
            decrease = 2;
        } else {
            decrease = 1;
        }

        item.quality = checkQualityDecrease(item.quality, decrease, MIN_QUALITY);
    }

    private void updateAgedBrie(@NotNull Item item) {
        item.sellIn--;
        if (item.quality < MAX_QUALITY) {
            item.quality++;
        }
    }

    private void updateBackstagePass(@NotNull Item item) {
        item.sellIn--;
        int increase = 0;
        if (item.sellIn < 0) {
            item.quality = 0;
        } else if (item.sellIn > 10) {
            increase = 1;
        } else if (item.sellIn > 5) {
            increase = 2;
        } else {
            increase = 3;
        }

        if (increase > 0) {
            item.quality = checkQualityIncrease(item.quality, increase, MAX_QUALITY);
        }
    }

    private void updateSulfuras(@NotNull Item item) {
        item.sellIn--;
    }

    private void updateConjured(@NotNull Item item) {
        item.sellIn--;
        int decrease;
        if (item.sellIn < 0) {
            decrease = 4;
        } else {
            decrease = 2;
        }
        item.quality = checkQualityDecrease(item.quality, decrease, MIN_QUALITY);;
    }

    private int checkQualityIncrease(int quality, int increase, int max) {
        if (quality + increase > max) {
            return max;
        }
        return quality + increase;
    }

    private int checkQualityDecrease(int quality, int decrease, int min) {
        if (quality - decrease < min) {
            return min;
        }
        return quality - decrease;
    }
}
