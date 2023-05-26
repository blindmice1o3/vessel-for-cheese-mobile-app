package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.flat_whites;

public class FlatWhite extends FlatWhites {
    public static final String TAG = FlatWhite.class.getSimpleName();

    public static final String NAME_DEFAULT = "Flat White";
    public static final String DESCRIPTION_DEFAULT = "Smooth ristretto shots of espresso get the perfect amount of steamed whole milk to create a not-too-strong, not-too-creamy, just-right flavor.";
    public static final double PRICE_SMALL_DEFAULT = 0.75;
    public static final double PRICE_MEDIUM_DEFAULT = 1.40;
    public static final double PRICE_LARGE_DEFAULT = 1.95;
    public static final boolean ICED_DEFAULT = false;

    public FlatWhite() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_MEDIUM_DEFAULT, ICED_DEFAULT);
    }
}
