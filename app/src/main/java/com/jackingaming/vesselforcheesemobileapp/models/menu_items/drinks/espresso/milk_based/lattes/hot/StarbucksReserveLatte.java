package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes.hot;

public class StarbucksReserveLatte extends Lattes {
    public static final String TAG = StarbucksReserveLatte.class.getSimpleName();

    public static final String DEFAULT_NAME = "Starbucks Reserve Latte";
    public static final String DEFAULT_DESCRIPTION = "Small-lot Starbucks Reserve espresso balanced with steamed milk and a light layer of foam forms a perfectly handcrafted latte.";
    public static final int DEFAULT_CALORIES = 230;
    public static final int DEFAULT_SUGAR_IN_GRAM = 18;
    public static final float DEFAULT_FAT_IN_GRAM = 12.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public StarbucksReserveLatte() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
