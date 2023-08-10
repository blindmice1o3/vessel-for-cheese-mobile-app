package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.blended.cremebased;

public class DoubleChocolatyChipCremeFrappuccinoBlendedBeverage extends CremeBased {
    public static final String TAG = DoubleChocolatyChipCremeFrappuccinoBlendedBeverage.class.getSimpleName();

    public static final String DEFAULT_NAME = "Double Chocolaty Chip Creme Frappuccino Blended Beverage";
    public static final String DEFAULT_DESCRIPTION = "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash. Top it off with sweetened whipped cream and mocha drizzle for a real party in your mouth.";
    public static final int DEFAULT_CALORIES = 410;
    public static final int DEFAULT_SUGAR_IN_GRAM = 47;
    public static final float DEFAULT_FAT_IN_GRAM = 20.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public DoubleChocolatyChipCremeFrappuccinoBlendedBeverage() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
