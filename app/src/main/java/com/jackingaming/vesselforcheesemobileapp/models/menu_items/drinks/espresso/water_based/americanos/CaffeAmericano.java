package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.water_based.americanos;

public class CaffeAmericano extends Americanos {
    public static final String TAG = CaffeAmericano.class.getSimpleName();

    public static final String NAME_DEFAULT = "Caffe Americano";
    public static final String DESCRIPTION_DEFAULT = "Espresso shots topped with hot water create a light layer of crema culminating in this wonderfully rich cup with depth and nuance.";
    public static final double PRICE_SMALL_DEFAULT = 1.95;
    public static final double PRICE_MEDIUM_DEFAULT = 2.45;
    public static final double PRICE_LARGE_DEFAULT = 2.70;
    public static final boolean ICED_DEFAULT = false;

    public CaffeAmericano() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_MEDIUM_DEFAULT, ICED_DEFAULT);
    }
}
