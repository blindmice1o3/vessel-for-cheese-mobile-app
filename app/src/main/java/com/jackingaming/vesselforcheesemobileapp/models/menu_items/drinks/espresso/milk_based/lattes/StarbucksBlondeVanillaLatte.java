package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes;

public class StarbucksBlondeVanillaLatte extends Lattes {
    public static final String TAG = StarbucksBlondeVanillaLatte.class.getSimpleName();

    public static final String NAME_DEFAULT = "Starbucks Blonde Vanilla Latte";
    public static final String DESCRIPTION_DEFAULT = "Extra-smooth Starbucks Blonde Espresso, velvety steamed milk and vanilla syrup come together to create a delightful new twist on a beloved espresso classic. An ideal cup for those who prefer a lighter-roasted coffee.";
    public static final double PRICE_SMALL_DEFAULT = 2.95;
    public static final double PRICE_MEDIUM_DEFAULT = 3.45;
    public static final double PRICE_LARGE_DEFAULT = 3.70;
    public static final boolean ICED_DEFAULT = false;

    public StarbucksBlondeVanillaLatte() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_MEDIUM_DEFAULT, ICED_DEFAULT);
    }
}
