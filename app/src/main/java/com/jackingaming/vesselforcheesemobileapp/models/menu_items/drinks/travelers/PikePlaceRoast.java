package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.travelers;

public class PikePlaceRoast extends CoffeeTravelers {
    public static final String TAG = PikePlaceRoast.class.getSimpleName();

    public static final String NAME_DEFAULT = "Coffee Traveler - Pike Place Roast";
    public static final String DESCRIPTION_DEFAULT = "A convenient carrier filled with 96 fl oz of our featured brewed medium roast coffee (equivalent of twelve 8 fl oz cups)-a perfect pick-me-up for meetings, picnics or whatever occasion calls for coffee.";
    public static final double PRICE_SMALL_DEFAULT = 1.95;
    public static final double PRICE_MEDIUM_DEFAULT = 2.45;
    public static final double PRICE_LARGE_DEFAULT = 2.70;
    public static final boolean ICED_DEFAULT = false;

    public PikePlaceRoast() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_MEDIUM_DEFAULT, ICED_DEFAULT);
    }
}
