package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.straight_shots;

public class ShotEspresso extends EspressoShots {
    public static final String TAG = ShotEspresso.class.getSimpleName();

    public static final String NAME_DEFAULT = "Espresso";
    public static final String DESCRIPTION_DEFAULT = "Our smooth signature Espresso Roast with rich flavor and caramelly sweetness is at the very heart of everything we do.";
    public static final double PRICE_SMALL_DEFAULT = 0.75;
    public static final double PRICE_MEDIUM_DEFAULT = 1.40;
    public static final double PRICE_LARGE_DEFAULT = 1.95;
    public static final boolean ICED_DEFAULT = false;

    public ShotEspresso() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_SMALL_DEFAULT, ICED_DEFAULT);
    }
}
