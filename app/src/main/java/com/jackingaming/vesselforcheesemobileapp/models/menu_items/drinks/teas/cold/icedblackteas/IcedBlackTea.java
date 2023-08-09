package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.cold.icedblackteas;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.cold.IcedTeas;

public class IcedBlackTea extends IcedTeas {
    public static final String TAG = IcedBlackTea.class.getSimpleName();

    public static final String DEFAULT_NAME = "Iced Black Tea";
    public static final String DEFAULT_DESCRIPTION = "Premium black tea sweetened just right and shaken with ice to create an ideal iced tea - a rich and flavorful black tea journey awaits you.";
    public static final int DEFAULT_CALORIES = 0;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public IcedBlackTea() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
