package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed;

public class DarkRoast extends BrewedCoffees {
    public static final String TAG = DarkRoast.class.getSimpleName();

    public static final String NAME_DEFAULT = "Featured Starbucks Dark Roast Coffee";
    public static final String DESCRIPTION_DEFAULT = "This full-bodied dark roast coffee with bold, robust flavors showcases our roasting and blending artistry-an essential blend of balanced and lingering flavors.";
    public static final double PRICE_SMALL_DEFAULT = 1.95;
    public static final double PRICE_MEDIUM_DEFAULT = 2.45;
    public static final double PRICE_LARGE_DEFAULT = 2.70;
    public static final boolean ICED_DEFAULT = false;

    public DarkRoast() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_MEDIUM_DEFAULT, ICED_DEFAULT);
    }
}
