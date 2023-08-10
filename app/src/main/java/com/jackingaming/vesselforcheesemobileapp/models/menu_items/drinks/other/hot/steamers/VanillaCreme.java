package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.hot.steamers;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.hot.HotOther;

public class VanillaCreme extends HotOther {
    public static final String TAG = VanillaCreme.class.getSimpleName();

    public static final String DEFAULT_NAME = "Vanilla Creme";
    public static final String DEFAULT_DESCRIPTION = "A smooth, frothy vanilla flavoured luxury. For those times when you'd rather not indulge in the rich flavour of our world-famous espresso - but still desire a hot, creamy vanilla beverage.";
    public static final int DEFAULT_CALORIES = 350;
    public static final int DEFAULT_SUGAR_IN_GRAM = 43;
    public static final float DEFAULT_FAT_IN_GRAM = 14.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public VanillaCreme() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
