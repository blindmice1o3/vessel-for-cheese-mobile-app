package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.hot.hotchocolates;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.hot.HotOther;

public class WhiteHotChocolate extends HotOther {
    public static final String TAG = WhiteHotChocolate.class.getSimpleName();

    public static final String DEFAULT_NAME = "White Hot Chocolate";
    public static final String DEFAULT_DESCRIPTION = "A traditional hot chocolate beverage made with white chocolate sauce and steamed milk, topped with whipped cream.";
    public static final int DEFAULT_CALORIES = 440;
    public static final int DEFAULT_SUGAR_IN_GRAM = 55;
    public static final float DEFAULT_FAT_IN_GRAM = 19.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public WhiteHotChocolate() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
