package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.cold.icedherbalteas;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.cold.IcedTeas;

public class IcedPassionTangoTeaLemonade extends IcedTeas {
    public static final String TAG = IcedPassionTangoTeaLemonade.class.getSimpleName();

    public static final String DEFAULT_NAME = "Iced Passion Tango Tea";
    public static final String DEFAULT_DESCRIPTION = "A blend of hibiscus, lemongrass and apple hand-shaken with ice: a refreshingly vibrant tea infused with the color of passion";
    public static final int DEFAULT_CALORIES = 0;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public IcedPassionTangoTeaLemonade() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
