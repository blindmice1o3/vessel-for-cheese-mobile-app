package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.hot.chaiteas;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.hot.HotTeas;

public class ChaiTeaLatte extends HotTeas {
    public static final String TAG = ChaiTeaLatte.class.getSimpleName();

    public static final String DEFAULT_NAME = "Chai Tea Latte";
    public static final String DEFAULT_DESCRIPTION = "Black tea infused with cinnamon, clove and other warming spices is combined with steamed milk and topped with foam for the perfect balance of sweet and spicy. An iconic chai cup.";
    public static final int DEFAULT_CALORIES = 240;
    public static final int DEFAULT_SUGAR_IN_GRAM = 42;
    public static final float DEFAULT_FAT_IN_GRAM = 4.5f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public ChaiTeaLatte() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
