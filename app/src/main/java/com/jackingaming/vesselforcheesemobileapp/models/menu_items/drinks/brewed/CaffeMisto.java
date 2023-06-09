package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed;

public class CaffeMisto extends BrewedCoffees {
    public static final String TAG = CaffeMisto.class.getSimpleName();

    public static final String DEFAULT_NAME = "Caffe Misto";
    public static final String DEFAULT_DESCRIPTION = "A one-to-one combination of fresh-brewed coffee and steamed milk add up to one distinctly delicious coffee drink remarkably mixed.";
    public static final int DEFAULT_CALORIES = 110;
    public static final int DEFAULT_SUGAR_IN_GRAM = 10;
    public static final float DEFAULT_FAT_IN_GRAM = 4.0f;

    public static final double DEFAULT_PRICE_SMALL = 1.95;
    public static final double DEFAULT_PRICE_MEDIUM = 2.45;
    public static final double DEFAULT_PRICE_LARGE = 2.70;
    public static final boolean DEFAULT_ICED = false;

    public CaffeMisto() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM, DEFAULT_ICED);
    }
}
