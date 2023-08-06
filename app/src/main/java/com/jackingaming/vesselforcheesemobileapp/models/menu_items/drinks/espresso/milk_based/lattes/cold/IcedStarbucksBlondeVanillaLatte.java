package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes.cold;

public class IcedStarbucksBlondeVanillaLatte extends IcedLattes {
    public static final String TAG = IcedStarbucksBlondeVanillaLatte.class.getSimpleName();

    public static final String DEFAULT_NAME = "Iced Starbucks Blonde Vanilla Latte";
    public static final String DEFAULT_DESCRIPTION = "Seriously smooth and subtly sweet Starbucks Blonde Espresso, milk, ice and vanilla syrup come together to create a delightful twist on a beloved espresso classic.";
    public static final int DEFAULT_CALORIES = 190;
    public static final int DEFAULT_SUGAR_IN_GRAM = 28;
    public static final float DEFAULT_FAT_IN_GRAM = 4.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public IcedStarbucksBlondeVanillaLatte() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
