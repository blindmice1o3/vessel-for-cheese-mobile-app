package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.blended.coffeebased;

public class ChocolateJavaMintFrappuccinoBlendedBeverage extends CoffeeBased {
    public static final String TAG = ChocolateJavaMintFrappuccinoBlendedBeverage.class.getSimpleName();

    public static final String DEFAULT_NAME = "Chocolate Java Mint Frappuccino Blended Beverage";
    public static final String DEFAULT_DESCRIPTION = "Coffee and flavors of sweet chocolate and refreshing mint blended with rich Frappuccino chips for a smooth treat finished with a layer of mocha sauce, whipped cream and chocolate-mint cookie crumble.";
    public static final int DEFAULT_CALORIES = 490;
    public static final int DEFAULT_SUGAR_IN_GRAM = 69;
    public static final float DEFAULT_FAT_IN_GRAM = 20.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public ChocolateJavaMintFrappuccinoBlendedBeverage() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
