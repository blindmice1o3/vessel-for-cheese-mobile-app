package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.hot.blackteas;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.hot.HotTeas;

public class RoyalEnglishBreakfastTea extends HotTeas {
    public static final String TAG = RoyalEnglishBreakfastTea.class.getSimpleName();

    public static final String DEFAULT_NAME = "Royal English Breakfast Tea";
    public static final String DEFAULT_DESCRIPTION = "Each sip of this beloved morning black tea unfolds to reveal the complexity of the high-grown full leaves. An elegant, time-honored classic that brings a royal nod to every cup.";
    public static final int DEFAULT_CALORIES = 0;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public RoyalEnglishBreakfastTea() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
