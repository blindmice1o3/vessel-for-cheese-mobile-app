package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.cold.icedgreenteas;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.cold.IcedTeas;

public class IcedPeachGreenTeaLemonade extends IcedTeas {
    public static final String TAG = IcedPeachGreenTeaLemonade.class.getSimpleName();

    public static final String DEFAULT_NAME = "Iced Peach Green Tea Lemonade";
    public static final String DEFAULT_DESCRIPTION = "Green tea is layered together with flavors of spearmint, lemon verbena, lemongrass and a splash of lemonade over ice for a patio-ready refreshment of surprise and delight.";
    public static final int DEFAULT_CALORIES = 80;
    public static final int DEFAULT_SUGAR_IN_GRAM = 18;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public IcedPeachGreenTeaLemonade() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
