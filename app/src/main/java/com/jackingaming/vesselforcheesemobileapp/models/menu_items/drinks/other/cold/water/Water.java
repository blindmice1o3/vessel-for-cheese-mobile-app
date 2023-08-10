package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.cold.water;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.cold.ColdOther;

public class Water extends ColdOther {
    public static final String TAG = Water.class.getSimpleName();

    public static final String DEFAULT_NAME = "Water";
    public static final String DEFAULT_DESCRIPTION = "2 part H, 1 part O";
    public static final int DEFAULT_CALORIES = 0;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 0.05;
    public static final double DEFAULT_PRICE_MEDIUM = 0.10;
    public static final double DEFAULT_PRICE_LARGE = 0.25;

    public Water() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
