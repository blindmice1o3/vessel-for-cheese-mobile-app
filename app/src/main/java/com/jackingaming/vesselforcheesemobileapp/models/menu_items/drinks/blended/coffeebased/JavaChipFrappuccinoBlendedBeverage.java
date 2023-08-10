package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.blended.coffeebased;

public class JavaChipFrappuccinoBlendedBeverage extends CoffeeBased {
    public static final String TAG = JavaChipFrappuccinoBlendedBeverage.class.getSimpleName();

    public static final String DEFAULT_NAME = "Java Chip Frappuccino Blended Beverage";
    public static final String DEFAULT_DESCRIPTION = "We blend mocha sauce and Frappuccino chips with coffee, milk and ice, then top it off with whipped cream and a mocha drizzle to bring you endless java joy.";
    public static final int DEFAULT_CALORIES = 440;
    public static final int DEFAULT_SUGAR_IN_GRAM = 59;
    public static final float DEFAULT_FAT_IN_GRAM = 19.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public JavaChipFrappuccinoBlendedBeverage() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
