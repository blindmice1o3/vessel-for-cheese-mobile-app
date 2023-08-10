package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.cold.coldbrews;

import com.jackingaming.vesselforcheesemobileapp.R;

public class CinnamonCaramelCreamColdBrew extends ColdBrews {
    public static final String TAG = CinnamonCaramelCreamColdBrew.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Cinnamon Caramel Cream Cold Brew";
    public static final String DEFAULT_DESCRIPTION = "Starbucks Cold Brew packed with flavors of cinnamon caramel, topped with vanilla sweet cream cold foam and dusted with even more flavor for a special personal treat.";
    public static final int DEFAULT_CALORIES = 250;
    public static final int DEFAULT_SUGAR_IN_GRAM = 32;
    public static final float DEFAULT_FAT_IN_GRAM = 12.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public CinnamonCaramelCreamColdBrew() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
