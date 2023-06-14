package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.straight_shots;

public class EspressoConPanna extends EspressoShots {
    public static final String TAG = EspressoConPanna.class.getSimpleName();

    public static final String DEFAULT_NAME = "Espresso Con Panna";
    public static final String DEFAULT_DESCRIPTION = "Espresso meets a dollop of whipped cream to enhance the rich and caramelly flavors of a straight-up shot.";
    public static final int DEFAULT_CALORIES = 35;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 2.5f;

    public static final double DEFAULT_PRICE_SMALL = 0.75;
    public static final double DEFAULT_PRICE_MEDIUM = 1.40;
    public static final double DEFAULT_PRICE_LARGE = 1.95;
    public static final boolean DEFAULT_ICED = false;

    public EspressoConPanna() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_SMALL, DEFAULT_ICED);
    }
}
