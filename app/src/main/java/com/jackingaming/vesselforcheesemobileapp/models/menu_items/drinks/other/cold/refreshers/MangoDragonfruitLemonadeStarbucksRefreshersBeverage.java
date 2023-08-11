package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.cold.refreshers;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.cold.ColdOther;

public class MangoDragonfruitLemonadeStarbucksRefreshersBeverage extends ColdOther {
    public static final String TAG = MangoDragonfruitLemonadeStarbucksRefreshersBeverage.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Mango Dragonfruit Lemonade Starbucks Refreshers Beverage";
    public static final String DEFAULT_DESCRIPTION = "This tropical-inspired pick-me-up--crafted with a clever combination of vibrant lemonade, sweet mango and refreshing dragonfruit flavors and hand-shaken with ice plus a scoop of real diced dragonfruit.";
    public static final int DEFAULT_CALORIES = 140;
    public static final int DEFAULT_SUGAR_IN_GRAM = 31;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 0.05;
    public static final double DEFAULT_PRICE_MEDIUM = 0.10;
    public static final double DEFAULT_PRICE_LARGE = 0.25;

    public MangoDragonfruitLemonadeStarbucksRefreshersBeverage() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
