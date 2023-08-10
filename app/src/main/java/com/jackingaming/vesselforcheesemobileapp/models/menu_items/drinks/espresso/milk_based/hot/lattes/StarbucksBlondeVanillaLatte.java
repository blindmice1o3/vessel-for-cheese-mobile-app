package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.hot.lattes;

import com.jackingaming.vesselforcheesemobileapp.R;

public class StarbucksBlondeVanillaLatte extends Lattes {
    public static final String TAG = StarbucksBlondeVanillaLatte.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Starbucks Blonde Vanilla Latte";
    public static final String DEFAULT_DESCRIPTION = "Extra-smooth Starbucks Blonde Espresso, velvety steamed milk and vanilla syrup come together to create a delightful new twist on a beloved espresso classic. An ideal cup for those who prefer a lighter-roasted coffee.";
    public static final int DEFAULT_CALORIES = 250;
    public static final int DEFAULT_SUGAR_IN_GRAM = 35;
    public static final float DEFAULT_FAT_IN_GRAM = 6.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public StarbucksBlondeVanillaLatte() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
