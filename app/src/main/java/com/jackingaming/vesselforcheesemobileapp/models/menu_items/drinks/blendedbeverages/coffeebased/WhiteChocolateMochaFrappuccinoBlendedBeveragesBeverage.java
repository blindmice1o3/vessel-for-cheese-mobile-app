package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.blendedbeverages.coffeebased;

public class WhiteChocolateMochaFrappuccinoBlendedBeveragesBeverage extends CoffeeBased {
    public static final String TAG = WhiteChocolateMochaFrappuccinoBlendedBeveragesBeverage.class.getSimpleName();

    public static final String DEFAULT_NAME = "White Chocolate Mocha Frappuccino Blended Beverage";
    public static final String DEFAULT_DESCRIPTION = "White chocolate Frappuccino Roast coffee, milk and ice get together for what might be the best thing that happens to you all day. Oh, and there's whipped cream on top.";
    public static final int DEFAULT_CALORIES = 420;
    public static final int DEFAULT_SUGAR_IN_GRAM = 61;
    public static final float DEFAULT_FAT_IN_GRAM = 17.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public WhiteChocolateMochaFrappuccinoBlendedBeveragesBeverage() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
