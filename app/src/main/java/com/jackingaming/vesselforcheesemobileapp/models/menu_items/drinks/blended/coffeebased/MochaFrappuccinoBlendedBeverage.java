package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.blended.coffeebased;

public class MochaFrappuccinoBlendedBeverage extends CoffeeBased {
    public static final String TAG = MochaFrappuccinoBlendedBeverage.class.getSimpleName();

    public static final String DEFAULT_NAME = "Mocha Frappuccino Blended Beverage";
    public static final String DEFAULT_DESCRIPTION = "Mocha sauce, Frappuccino Roast coffee, milk and ice all come together for a mocha flavor that'll leave you wanting more. To change things up, try it affogato-style with a hot espresso shot poured right over the top.";
    public static final int DEFAULT_CALORIES = 370;
    public static final int DEFAULT_SUGAR_IN_GRAM = 51;
    public static final float DEFAULT_FAT_IN_GRAM = 15.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public MochaFrappuccinoBlendedBeverage() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
