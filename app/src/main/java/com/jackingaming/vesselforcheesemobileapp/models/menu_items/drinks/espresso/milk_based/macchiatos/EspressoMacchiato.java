package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.macchiatos;

public class EspressoMacchiato extends Macchiatos {
    public static final String TAG = EspressoMacchiato.class.getSimpleName();

    public static final String NAME_DEFAULT = "Espresso Macchiato";
    public static final String DESCRIPTION_DEFAULT = "Our rich espresso marked with dollop of steamed milk and foam. A European-style classic.";
    public static final double PRICE_SMALL_DEFAULT = 1.95;
    public static final double PRICE_MEDIUM_DEFAULT = 2.45;
    public static final double PRICE_LARGE_DEFAULT = 2.70;
    public static final boolean ICED_DEFAULT = false;

    public EspressoMacchiato() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_MEDIUM_DEFAULT, ICED_DEFAULT);
    }
}
