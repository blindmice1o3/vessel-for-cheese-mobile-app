package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.cold.coldbrews;

public class ChocolateCreamColdBrew extends ColdBrews {
    public static final String TAG = ChocolateCreamColdBrew.class.getSimpleName();

    public static final String DEFAULT_NAME = "Chocolate Cream Cold Brew";
    public static final String DEFAULT_DESCRIPTION = "Starbucks Cold Brew sweetened with vanilla syrup and topped with a silky, chocolaty cream cold foam.";
    public static final int DEFAULT_CALORIES = 250;
    public static final int DEFAULT_SUGAR_IN_GRAM = 28;
    public static final float DEFAULT_FAT_IN_GRAM = 14.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;
    public static final boolean DEFAULT_ICED = false;

    public ChocolateCreamColdBrew() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM, DEFAULT_ICED);
    }
}
