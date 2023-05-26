package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.travelers;

public class DarkRoast extends CoffeeTravelers {
    public static final String TAG = DarkRoast.class.getSimpleName();

    public static final String NAME_DEFAULT = "Coffee Traveler - Dark Roast";
    public static final String DESCRIPTION_DEFAULT = "A convenient carrier filled with 96 fl oz of our brewed Starbucks Dark Roast coffee.";
    public static final double PRICE_SMALL_DEFAULT = 1.95;
    public static final double PRICE_MEDIUM_DEFAULT = 2.45;
    public static final double PRICE_LARGE_DEFAULT = 2.70;
    public static final boolean ICED_DEFAULT = false;

    public DarkRoast() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_MEDIUM_DEFAULT, ICED_DEFAULT);
    }
}
