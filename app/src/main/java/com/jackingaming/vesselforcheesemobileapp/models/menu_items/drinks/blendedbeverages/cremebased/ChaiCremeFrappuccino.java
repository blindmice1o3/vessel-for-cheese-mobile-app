package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.blendedbeverages.cremebased;

public class ChaiCremeFrappuccino extends CremeBased {
    public static final String TAG = ChaiCremeFrappuccino.class.getSimpleName();

    public static final String DEFAULT_NAME = "Chai Creme Frappuccino";
    public static final String DEFAULT_DESCRIPTION = "A creamy blend of spicy classic chai, milk and ice. Topped with sweetened whipped cream and a dash of cinnamon. Spice up your afternoon treat.";
    public static final int DEFAULT_CALORIES = 340;
    public static final int DEFAULT_SUGAR_IN_GRAM = 45;
    public static final float DEFAULT_FAT_IN_GRAM = 16.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public ChaiCremeFrappuccino() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
