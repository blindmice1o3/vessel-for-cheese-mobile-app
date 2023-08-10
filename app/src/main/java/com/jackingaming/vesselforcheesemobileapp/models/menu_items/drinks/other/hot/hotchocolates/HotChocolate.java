package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.hot.hotchocolates;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.hot.HotOther;

public class HotChocolate extends HotOther {
    public static final String TAG = HotChocolate.class.getSimpleName();

    public static final String DEFAULT_NAME = "Hot Chocolate";
    public static final String DEFAULT_DESCRIPTION = "Steamed milk with chocolate-flavored syrups. Topped with sweetened whipped cream and chocolate-flavored drizzle. A timeless classic made to sweeten your spirits.";
    public static final int DEFAULT_CALORIES = 370;
    public static final int DEFAULT_SUGAR_IN_GRAM = 37;
    public static final float DEFAULT_FAT_IN_GRAM = 16.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public HotChocolate() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
