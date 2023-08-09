package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.hot.mochas;

public class StarbucksReserveDarkChocolateMocha extends Mochas {
    public static final String TAG = StarbucksReserveDarkChocolateMocha.class.getSimpleName();

    public static final String DEFAULT_NAME = "Starbucks Reserve Dark Chocolate Mocha";
    public static final String DEFAULT_DESCRIPTION = "Our small-lot Starbucks Reserve espresso combined with cocoa, ground chocolate and topped with steamed milk delivers a brilliant combination of sweetness.";
    public static final int DEFAULT_CALORIES = 320;
    public static final int DEFAULT_SUGAR_IN_GRAM = 33;
    public static final float DEFAULT_FAT_IN_GRAM = 14.0f;

    public static final double DEFAULT_PRICE_SMALL = 1.95;
    public static final double DEFAULT_PRICE_MEDIUM = 2.45;
    public static final double DEFAULT_PRICE_LARGE = 2.70;

    public StarbucksReserveDarkChocolateMocha() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
