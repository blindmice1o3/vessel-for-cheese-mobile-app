package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.macchiatos.hot;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;

public class EspressoMacchiato extends Macchiatos {
    public static final String TAG = EspressoMacchiato.class.getSimpleName();

    public static final String DEFAULT_NAME = "Espresso Macchiato";
    public static final String DEFAULT_DESCRIPTION = "Our rich espresso marked with dollop of steamed milk and foam. A European-style classic.";
    public static final int DEFAULT_CALORIES = 15;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final DrinkSize[] DEFAULT_DRINK_SIZES_ALLOWED = {DrinkSize.UNIQUE};

    public static final double DEFAULT_PRICE_SMALL = 1.95;
    public static final double DEFAULT_PRICE_MEDIUM = 2.45;
    public static final double DEFAULT_PRICE_LARGE = 2.70;
    public static final boolean DEFAULT_ICED = false;

    public EspressoMacchiato() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM, DEFAULT_ICED);

        drinkSizesAllowed = DEFAULT_DRINK_SIZES_ALLOWED;
    }
}
