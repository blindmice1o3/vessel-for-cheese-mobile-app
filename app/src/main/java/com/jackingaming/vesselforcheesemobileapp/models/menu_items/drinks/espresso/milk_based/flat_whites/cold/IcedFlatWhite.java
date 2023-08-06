package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.flat_whites.cold;

public class IcedFlatWhite extends IcedFlatWhites {
    public static final String TAG = IcedFlatWhite.class.getSimpleName();

    public static final String DEFAULT_NAME = "Iced Flat White";
    public static final String DEFAULT_DESCRIPTION = "Smooth ristretto shots of espresso get the perfect amount of whole milk and ice to create a not-too-strong, not-too-creamy, just-right flavor.";
    public static final int DEFAULT_CALORIES = 150;
    public static final int DEFAULT_SUGAR_IN_GRAM = 11;
    public static final float DEFAULT_FAT_IN_GRAM = 8.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public IcedFlatWhite() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
