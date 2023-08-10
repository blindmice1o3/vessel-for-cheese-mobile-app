package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.blended.coffeebased;

public class CoffeeFrappuccinoBlendedBeverage extends CoffeeBased {
    public static final String TAG = CoffeeFrappuccinoBlendedBeverage.class.getSimpleName();

    public static final String DEFAULT_NAME = "Coffee Frappuccino Blended Beverage";
    public static final String DEFAULT_DESCRIPTION = "Coffee meets milk and ice in a blender for a rumble-and-tumble togetherness to create one of our most-beloved original Frappuccino blended beverages.";
    public static final int DEFAULT_CALORIES = 230;
    public static final int DEFAULT_SUGAR_IN_GRAM = 45;
    public static final float DEFAULT_FAT_IN_GRAM = 3.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public CoffeeFrappuccinoBlendedBeverage() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
