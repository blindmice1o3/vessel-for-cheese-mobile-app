package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.hot;

public class DecafPikePlaceRoast extends HotBrewedCoffees {
    public static final String TAG = DecafPikePlaceRoast.class.getSimpleName();

    public static final String DEFAULT_NAME = "Decaf Pike Place Roast";
    public static final String DEFAULT_DESCRIPTION = "From our first store in Seattle's Pike Place Market to our coffeehouses around the world, customers requested a freshly brewed coffee they could enjoy throughout the day. In 2008 our master blenders and roasters created this for you-a smooth, well-rounded blend of Latin American coffees with subtly rich flavors of chocolate and toasted nuts, it's served fresh every day at a Starbucks store near you. (Decaf as you like it.)";
    public static final int DEFAULT_CALORIES = 5;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 1.95;
    public static final double DEFAULT_PRICE_MEDIUM = 2.45;
    public static final double DEFAULT_PRICE_LARGE = 2.70;
    public static final boolean DEFAULT_ICED = false;

    public DecafPikePlaceRoast() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM, DEFAULT_ICED);
    }
}
