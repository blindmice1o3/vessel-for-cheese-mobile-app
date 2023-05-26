package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed;

public class CaffeMisto extends BrewedCoffees {
    public static final String TAG = CaffeMisto.class.getSimpleName();

    public static final String NAME_DEFAULT = "Caffe Misto";
    public static final String DESCRIPTION_DEFAULT = "A one-to-one combination of fresh-brewed coffee and steamed milk add up to one distinctly delicious coffee drink remarkably mixed.";
    public static final double PRICE_SMALL_DEFAULT = 1.95;
    public static final double PRICE_MEDIUM_DEFAULT = 2.45;
    public static final double PRICE_LARGE_DEFAULT = 2.70;
    public static final boolean ICED_DEFAULT = false;

    public CaffeMisto() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_MEDIUM_DEFAULT, ICED_DEFAULT);
    }
}
