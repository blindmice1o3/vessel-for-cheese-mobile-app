package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.cold.icedlattes;

import com.jackingaming.vesselforcheesemobileapp.R;

public class StarbucksReserveIcedLatte extends IcedLattes {
    public static final String TAG = StarbucksReserveIcedLatte.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Starbucks Reserve Iced Latte";
    public static final String DEFAULT_DESCRIPTION = "Small-lot Starbucks Reserve espresso combined with milk and served over ice creates perfectly handcrafted sips of cool.";
    public static final int DEFAULT_CALORIES = 210;
    public static final int DEFAULT_SUGAR_IN_GRAM = 16;
    public static final float DEFAULT_FAT_IN_GRAM = 11.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public StarbucksReserveIcedLatte() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
