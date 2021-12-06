package com.gildedrose;

import com.gildedrose.core.GildedRose;
import com.gildedrose.core.Item;
import com.gildedrose.core.ItemFactory;

public class RunSimulation {

    public static void main(String[] args) throws Exception {

        System.out.println("Welcome to the Gildedrose Inn!");

        Item[] items = new Item[] {
                ItemFactory.getInstance().createItem("+5 Dexterity Vest", 10, 20), //
                ItemFactory.getInstance().createItem("Aged Brie", 2, 0), //
                ItemFactory.getInstance().createItem("Elixir of the Mongoose", 5, 7), //
                ItemFactory.getInstance().createItem("Sulfuras, Hand of Ragnaros", 0, 80), //
                ItemFactory.getInstance().createItem("Sulfuras, Hand of Ragnaros", -1, 80),
                ItemFactory.getInstance().createItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                ItemFactory.getInstance().createItem("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                ItemFactory.getInstance().createItem("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                ItemFactory.getInstance().createItem("Conjured Mana Cake", 3, 6),
                ItemFactory.getInstance().createItem("Switcher", 2 , 10)
        };

        GildedRose app = new GildedRose(items);
        int days = 5;
        if (args.length > 0) days = Integer.parseInt(args[0]) + 1;
        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.calculateNextDay();
        }
    }
}
