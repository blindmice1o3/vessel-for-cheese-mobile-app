package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.blendedbeverages.coffeebased;

public class MochaCookieCrumbleFrappuccino extends CoffeeBased {
    public static final String TAG = MochaCookieCrumbleFrappuccino.class.getSimpleName();

    public static final String DEFAULT_NAME = "Mocha Cookie Crumble Frappuccino";
    public static final String DEFAULT_DESCRIPTION = "Frappuccino Roast coffee, mocha sauce and Frappuccino chips blended with milk and ice, layered on top of whipped cream and chocolate cookie crumble and topped with vanilla whipped cream, mocha drizzle and even more chocolate cookie crumble. Each sip is as good as the last... all the way to the end.";
    public static final int DEFAULT_CALORIES = 480;
    public static final int DEFAULT_SUGAR_IN_GRAM = 55;
    public static final float DEFAULT_FAT_IN_GRAM = 24.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public MochaCookieCrumbleFrappuccino() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
