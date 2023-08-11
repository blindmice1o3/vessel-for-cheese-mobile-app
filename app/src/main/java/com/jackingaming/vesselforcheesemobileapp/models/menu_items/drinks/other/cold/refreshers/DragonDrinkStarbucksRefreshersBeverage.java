package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.cold.refreshers;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.cold.ColdOther;

public class DragonDrinkStarbucksRefreshersBeverage extends ColdOther {
    public static final String TAG = DragonDrinkStarbucksRefreshersBeverage.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Dragon Drink Starbucks Refreshers Beverage";
    public static final String DEFAULT_DESCRIPTION = "This tropical-inspired pick-me-up--crafted with sweet mango and dragonfruit flavors and hand-shaken with creamy coconutmilk, ice and a scoop of real diced dragonfruit--creates a refreshing and surprising delight in the fall.";
    public static final int DEFAULT_CALORIES = 130;
    public static final int DEFAULT_SUGAR_IN_GRAM = 23;
    public static final float DEFAULT_FAT_IN_GRAM = 3.0f;

    public static final double DEFAULT_PRICE_SMALL = 0.05;
    public static final double DEFAULT_PRICE_MEDIUM = 0.10;
    public static final double DEFAULT_PRICE_LARGE = 0.25;

    public DragonDrinkStarbucksRefreshersBeverage() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
