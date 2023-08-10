package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.cold.coldbrews;

import com.jackingaming.vesselforcheesemobileapp.R;

public class OleatoGoldenFoamColdBrew extends ColdBrews {
    public static final String TAG = OleatoGoldenFoamColdBrew.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Oleato Golden Foam Cold Brew";
    public static final String DEFAULT_DESCRIPTION = "Cold foam contrasts with dark, smooth cold brew, yielding an inviting aroma with lush Partanna infused cold foam.";
    public static final int DEFAULT_CALORIES = 380;
    public static final int DEFAULT_SUGAR_IN_GRAM = 19;
    public static final float DEFAULT_FAT_IN_GRAM = 34.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public OleatoGoldenFoamColdBrew() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
