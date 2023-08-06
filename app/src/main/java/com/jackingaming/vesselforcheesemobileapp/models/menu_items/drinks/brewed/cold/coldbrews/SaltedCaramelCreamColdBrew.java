package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.cold.coldbrews;

public class SaltedCaramelCreamColdBrew extends ColdBrews {
    public static final String TAG = SaltedCaramelCreamColdBrew.class.getSimpleName();

    public static final String DEFAULT_NAME = "Salted Caramel Cream Cold Brew";
    public static final String DEFAULT_DESCRIPTION = "Here's a savory-meets-sweet refreshing beverage certain to delight: our signature, super-smooth cold brew, sweetened with a touch of caramel and topped with a salted, rich cold foam.";
    public static final int DEFAULT_CALORIES = 240;
    public static final int DEFAULT_SUGAR_IN_GRAM = 26;
    public static final float DEFAULT_FAT_IN_GRAM = 14.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public SaltedCaramelCreamColdBrew() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
