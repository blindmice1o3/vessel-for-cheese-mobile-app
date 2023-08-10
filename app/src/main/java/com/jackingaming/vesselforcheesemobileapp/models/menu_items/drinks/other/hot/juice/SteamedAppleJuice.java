package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.hot.juice;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.hot.HotOther;

public class SteamedAppleJuice extends HotOther {
    public static final String TAG = SteamedAppleJuice.class.getSimpleName();

    public static final String DEFAULT_NAME = "Steamed Apple Juice";
    public static final String DEFAULT_DESCRIPTION = "Freshly steamed 100% apple juice (not from concentrate). Feel the apple goodness in this classic fruit drink that will soothe and embolden your day.";
    public static final int DEFAULT_CALORIES = 220;
    public static final int DEFAULT_SUGAR_IN_GRAM = 50;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public SteamedAppleJuice() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
