package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.water_based.americanos;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;

public class CaffeAmericano extends Americanos {
    public static final String TAG = CaffeAmericano.class.getSimpleName();

    public static final String DEFAULT_NAME = "Caffe Americano";
    public static final String DEFAULT_DESCRIPTION = "Espresso shots topped with hot water create a light layer of crema culminating in this wonderfully rich cup with depth and nuance.";
    public static final int DEFAULT_CALORIES = 15;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final DrinkSize[] DEFAULT_DRINK_SIZES_ALLOWED = {DrinkSize.SHORT, DrinkSize.TALL, DrinkSize.GRANDE, DrinkSize.VENTI_HOT};

    public static final double DEFAULT_PRICE_SMALL = 1.95;
    public static final double DEFAULT_PRICE_MEDIUM = 2.45;
    public static final double DEFAULT_PRICE_LARGE = 2.70;
    public static final boolean DEFAULT_ICED = false;

    public CaffeAmericano() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM, DEFAULT_ICED);

        drinkSizesAllowed = DEFAULT_DRINK_SIZES_ALLOWED;
    }
}
