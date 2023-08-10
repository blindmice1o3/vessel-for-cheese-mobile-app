package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.straight_shots;

import com.jackingaming.vesselforcheesemobileapp.R;

public class ShotEspresso extends EspressoShots {
    public static final String TAG = ShotEspresso.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Espresso";
    public static final String DEFAULT_DESCRIPTION = "Our smooth signature Espresso Roast with rich flavor and caramelly sweetness is at the very heart of everything we do.";
    public static final int DEFAULT_CALORIES = 10;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 0.75;
    public static final double DEFAULT_PRICE_MEDIUM = 1.40;
    public static final double DEFAULT_PRICE_LARGE = 1.95;

    public ShotEspresso() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_SMALL);
    }
}
