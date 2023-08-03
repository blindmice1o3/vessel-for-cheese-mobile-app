package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.cold.icedcoffees;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;

public class IcedEspresso extends IcedCoffees {
    public static final String TAG = IcedEspresso.class.getSimpleName();

    public static final String DEFAULT_NAME = "Iced Espresso";
    public static final String DEFAULT_DESCRIPTION = "Our smooth signature Espresso Roast over ice boasts rich, robust flavor and caramelly sweetness. A recipe of perfection at the heart of every handcrafted espresso we serve.";
    public static final int DEFAULT_CALORIES = 10;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final DrinkSize[] UNIQUE_DEFAULT_DRINK_SIZES_ALLOWED = {DrinkSize.UNIQUE};

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;
    public static final boolean DEFAULT_ICED = false;

    public IcedEspresso() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM, DEFAULT_ICED);

        drinkSizesAllowed = UNIQUE_DEFAULT_DRINK_SIZES_ALLOWED;
    }
}
