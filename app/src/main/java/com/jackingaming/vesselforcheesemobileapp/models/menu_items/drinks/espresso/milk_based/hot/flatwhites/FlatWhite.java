package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.hot.flatwhites;

public class FlatWhite extends FlatWhites {
    public static final String TAG = FlatWhite.class.getSimpleName();

    public static final String DEFAULT_NAME = "Flat White";
    public static final String DEFAULT_DESCRIPTION = "Smooth ristretto shots of espresso get the perfect amount of steamed whole milk to create a not-too-strong, not-too-creamy, just-right flavor.";
    public static final int DEFAULT_CALORIES = 170;
    public static final int DEFAULT_SUGAR_IN_GRAM = 13;
    public static final float DEFAULT_FAT_IN_GRAM = 9.0f;

    public static final double DEFAULT_PRICE_SMALL = 0.75;
    public static final double DEFAULT_PRICE_MEDIUM = 1.40;
    public static final double DEFAULT_PRICE_LARGE = 1.95;

    public FlatWhite() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
