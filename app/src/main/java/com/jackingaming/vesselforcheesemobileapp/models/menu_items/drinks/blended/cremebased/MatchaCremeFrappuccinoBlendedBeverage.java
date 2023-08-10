package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.blended.cremebased;

public class MatchaCremeFrappuccinoBlendedBeverage extends CremeBased {
    public static final String TAG = MatchaCremeFrappuccinoBlendedBeverage.class.getSimpleName();

    public static final String DEFAULT_NAME = "Matcha Creme Frappuccino Blended Beverage";
    public static final String DEFAULT_DESCRIPTION = "This blend of sweetened premium matcha green tea, milk and ice - topped off with sweetened whipped cream - inspires a delicious boost and good green vibes.";
    public static final int DEFAULT_CALORIES = 420;
    public static final int DEFAULT_SUGAR_IN_GRAM = 61;
    public static final float DEFAULT_FAT_IN_GRAM = 16.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public MatchaCremeFrappuccinoBlendedBeverage() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
