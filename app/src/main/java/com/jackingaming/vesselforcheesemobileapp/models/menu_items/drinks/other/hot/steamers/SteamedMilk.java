package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.hot.steamers;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.hot.HotOther;

public class SteamedMilk extends HotOther {
    public static final String TAG = SteamedMilk.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Steamed Milk";
    public static final String DEFAULT_DESCRIPTION = "Enjoy a warm cup of skim, 2%, soy, almond or coconutmilk steamed for your sipping pleasure.";
    public static final int DEFAULT_CALORIES = 200;
    public static final int DEFAULT_SUGAR_IN_GRAM = 19;
    public static final float DEFAULT_FAT_IN_GRAM = 8.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public SteamedMilk() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
