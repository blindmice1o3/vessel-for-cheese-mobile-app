package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.cold.icedgreenteas;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.cold.IcedTeas;

public class IcedPeachGreenTea extends IcedTeas {
    public static final String TAG = IcedPeachGreenTea.class.getSimpleName();

    public static final String DEFAULT_NAME = "Iced Peach Green Tea";
    public static final String DEFAULT_DESCRIPTION = "Green tea is layered together with flavors of spearmint, lemon verbena and lemongrass for a taste that's really peachy keen.";
    public static final int DEFAULT_CALORIES = 60;
    public static final int DEFAULT_SUGAR_IN_GRAM = 12;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public IcedPeachGreenTea() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
