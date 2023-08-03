package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.travelers;

public class DecafPikePlaceRoast extends CoffeeTravelers {
    public static final String TAG = DecafPikePlaceRoast.class.getSimpleName();

    public static final String DEFAULT_NAME = "Coffee Traveler - Decaf Pike Place Roast";
    public static final String DEFAULT_DESCRIPTION = "A convenient carrier filled with 96 fl oz of our featured brewed decaf coffee (equivalent of twelve 8 fl oz cups)-a perfect companion for meetings, picnics or whatever occasion calls for coffee.";
    public static final int DEFAULT_CALORIES = 5;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 1.95;
    public static final double DEFAULT_PRICE_MEDIUM = 2.45;
    public static final double DEFAULT_PRICE_LARGE = 2.70;
    public static final boolean DEFAULT_ICED = false;

    public DecafPikePlaceRoast() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM, DEFAULT_ICED);
    }
}
