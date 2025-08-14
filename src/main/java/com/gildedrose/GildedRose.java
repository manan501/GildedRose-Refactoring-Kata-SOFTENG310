package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            boolean isAgedBrie = item.name.equals("Aged Brie");
            boolean isBackstage = item.name.equals("Backstage passes to a TAFKAL80ETC concert");
            boolean isSulfuras = item.name.equals("Sulfuras, Hand of Ragnaros");

            if (!isAgedBrie && !isBackstage) {
                if (item.quality > 0) {
                    if (!isSulfuras) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (isBackstage) {
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

            if (!isSulfuras) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!isAgedBrie) {
                    if (!isBackstage) {
                        if (item.quality > 0) {
                            if (!isSulfuras) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality;
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