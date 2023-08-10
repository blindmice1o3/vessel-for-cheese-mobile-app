package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.blendedbeverages.cremebased;

public class ChocolateCookieCrumbleCremeFrappuccino extends CremeBased {
    public static final String TAG = ChocolateCookieCrumbleCremeFrappuccino.class.getSimpleName();

    public static final String DEFAULT_NAME = "Chocolate Cookie Crumble Creme Frappuccino";
    public static final String DEFAULT_DESCRIPTION = "Mocha sauce and Frappuccino chips are blended with milk and ice, layered on top of whipped cream and chocolate cookie crumble and topped with vanilla whipped cream, mocha drizzle and even more chocolate cookie crumble. These layers ensure each sip is as good as the last; all the way to the end.";
    public static final int DEFAULT_CALORIES = 460;
    public static final int DEFAULT_SUGAR_IN_GRAM = 46;
    public static final float DEFAULT_FAT_IN_GRAM = 25.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public ChocolateCookieCrumbleCremeFrappuccino() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
