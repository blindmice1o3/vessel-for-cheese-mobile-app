package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.cold.icedgreenteas;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.cold.IcedTeas;

public class IcedMatchaTeaLatte extends IcedTeas {
    public static final String TAG = IcedMatchaTeaLatte.class.getSimpleName();

    public static final String DEFAULT_NAME = "Iced Matcha Tea Latte";
    public static final String DEFAULT_DESCRIPTION = "Smooth and creamy matcha sweetened just right and served with milk over ice. Green has never tasted so good.";
    public static final int DEFAULT_CALORIES = 200;
    public static final int DEFAULT_SUGAR_IN_GRAM = 28;
    public static final float DEFAULT_FAT_IN_GRAM = 5.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public IcedMatchaTeaLatte() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
