package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.cold.coldbrews;

public class WhiteChocolateMacadamiaCreamColdBrew extends ColdBrews {
    public static final String TAG = WhiteChocolateMacadamiaCreamColdBrew.class.getSimpleName();

    public static final String DEFAULT_NAME = "White Chocolate Macadamia Cream Cold Brew";
    public static final String DEFAULT_DESCRIPTION = "Starbucks signature cold brew sweetened with macadamia syrup, topped with a silky white-chocolate macadamia cream cold foam and finished with toasted cookie crumbles.";
    public static final int DEFAULT_CALORIES = 240;
    public static final int DEFAULT_SUGAR_IN_GRAM = 30;
    public static final float DEFAULT_FAT_IN_GRAM = 11.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;
    public static final boolean DEFAULT_ICED = false;

    public WhiteChocolateMacadamiaCreamColdBrew() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM, DEFAULT_ICED);
    }
}
