package com.gildedrose;

import com.gildedrose.core.GildedRose;
import com.gildedrose.core.Item;
import com.gildedrose.items.NormalItem;
import com.gildedrose.items.SwitchItem;
import org.junit.jupiter.api.Test;

public class SwitchItemTest {
    private Item[] items = new Item[] {new SwitchItem("Switcher", 5, 10)};
    private GildedRose app = new GildedRose(items);

    @Test
    void decreaseQualityNormal() {
        app.calculateNextDay();
        assert(app.items[0].sellIn == 4);
        assert(app.items[0].quality == 11);
    }

    @Test
    void decreaseQualityExpired() {
        app.items[0].sellIn = -1;
        app.items[0].quality = 20;
        app.calculateNextDay();
        assert(app.items[0].sellIn == -2);
        assert(app.items[0].quality == 19);
        app.calculateNextDay();
        assert(app.items[0].sellIn == -3);
        assert(app.items[0].quality == 18);
        app.calculateNextDay();
        assert(app.items[0].sellIn == -4);
        assert(app.items[0].quality == 17);
    }

    @Test
    void SellinBelowZero() {
        app.items[0].sellIn = 10;
        app.items[0].quality = 10;
        app.calculateNextDay();
        assert(app.items[0].sellIn == 9);
        assert(app.items[0].quality == 11);
        app.calculateNextDay();
        assert(app.items[0].sellIn == 8);
        assert(app.items[0].quality == 12);
        app.calculateNextDay();
        assert(app.items[0].sellIn == 7);
        assert(app.items[0].quality == 13);
    }

}
