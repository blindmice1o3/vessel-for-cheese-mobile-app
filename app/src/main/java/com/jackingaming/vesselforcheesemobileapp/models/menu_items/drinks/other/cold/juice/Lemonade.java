package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.cold.juice;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.cold.ColdOther;

public class Lemonade extends ColdOther {
    public static final String TAG = Lemonade.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Lemonade";
    public static final String DEFAULT_DESCRIPTION = "Awaken your taste buds with the zing of refreshing lemonade--this tangy, fresh sip puts a little zip in your step.";
    public static final int DEFAULT_CALORIES = 120;
    public static final int DEFAULT_SUGAR_IN_GRAM = 27;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 0.05;
    public static final double DEFAULT_PRICE_MEDIUM = 0.10;
    public static final double DEFAULT_PRICE_LARGE = 0.25;

    public Lemonade() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
