package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.hot.greenteas;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.hot.HotTeas;

public class MatchaTeaLatte extends HotTeas {
    public static final String TAG = MatchaTeaLatte.class.getSimpleName();

    public static final String DEFAULT_NAME = "Matcha Tea Latte";
    public static final String DEFAULT_DESCRIPTION = "Smooth and creamy matcha sweetened just right and served with steamed milk. This favorite will transport your senses to pure green delight.";
    public static final int DEFAULT_CALORIES = 240;
    public static final int DEFAULT_SUGAR_IN_GRAM = 32;
    public static final float DEFAULT_FAT_IN_GRAM = 7.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public MatchaTeaLatte() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
