package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.cappuccinos;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;

public class Cappuccino extends Cappuccinos {
    public static final String TAG = Cappuccino.class.getSimpleName();

    public static final String DEFAULT_NAME = "Cappuccino";
    public static final String DEFAULT_DESCRIPTION = "Dark, rich espresso lies in wait under a smoothed and stretched layer of thick milk foam. An alchemy of barista artistry and craft.";
    public static final int DEFAULT_CALORIES = 140;
    public static final int DEFAULT_SUGAR_IN_GRAM = 12;
    public static final float DEFAULT_FAT_IN_GRAM = 5.0f;

    public static final DrinkSize[] DEFAULT_DRINK_SIZES_ALLOWED = {DrinkSize.SHORT, DrinkSize.TALL, DrinkSize.GRANDE, DrinkSize.VENTI_HOT};

    public static final double DEFAULT_PRICE_SMALL = 1.95;
    public static final double DEFAULT_PRICE_MEDIUM = 2.45;
    public static final double DEFAULT_PRICE_LARGE = 2.70;

    public Cappuccino() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
