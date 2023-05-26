package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed;

public class PikePlaceRoast extends BrewedCoffees {
    public static final String TAG = PikePlaceRoast.class.getSimpleName();

    public static final String NAME_DEFAULT = "Featured Medium Roast - Pike Place Roast";
    public static final String DESCRIPTION_DEFAULT = "From our first store in Seattle's Pike Place Market to our coffeehouses around the world, customers requested a freshly brewed coffee they could enjoy throughout the day. In 2008 our master blenders and roasters created this for you-a smooth, well-rounded blend of Latin American coffees with subtly rich flavors of chocolate and toasted nuts, it's served fresh every day at a Starbucks store near you.";
    public static final double PRICE_SMALL_DEFAULT = 1.95;
    public static final double PRICE_MEDIUM_DEFAULT = 2.45;
    public static final double PRICE_LARGE_DEFAULT = 2.70;
    public static final boolean ICED_DEFAULT = false;

    public PikePlaceRoast() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_MEDIUM_DEFAULT, ICED_DEFAULT);
    }
}
