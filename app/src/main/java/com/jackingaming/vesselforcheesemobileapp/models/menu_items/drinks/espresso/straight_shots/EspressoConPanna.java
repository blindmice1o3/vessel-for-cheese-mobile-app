package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.straight_shots;

public class EspressoConPanna extends EspressoShots {
    public static final String TAG = EspressoConPanna.class.getSimpleName();

    public static final String NAME_DEFAULT = "Espresso Con Panna";
    public static final String DESCRIPTION_DEFAULT = "Espresso meets a dollop of whipped cream to enhance the rich and caramelly flavors of a straight-up shot.";
    public static final double PRICE_SMALL_DEFAULT = 0.75;
    public static final double PRICE_MEDIUM_DEFAULT = 1.40;
    public static final double PRICE_LARGE_DEFAULT = 1.95;
    public static final boolean ICED_DEFAULT = false;

    public EspressoConPanna() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_SMALL_DEFAULT, ICED_DEFAULT);
    }
}
