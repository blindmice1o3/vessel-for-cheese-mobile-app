package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.cold.water;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.cold.ColdOther;

public class EthosBottledWater extends ColdOther {
    public static final String TAG = EthosBottledWater.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Ethos Bottled Water";
    public static final String DEFAULT_DESCRIPTION = "For every bottle of Ethos water you buy, Starbucks will donate 5 cents to support humanitarian programs in coffee - growing communities, providing clean, safe water to those in need.";
    public static final int DEFAULT_CALORIES = -1;
    public static final int DEFAULT_SUGAR_IN_GRAM = -1;
    public static final float DEFAULT_FAT_IN_GRAM = -1.0f;

    public static final double DEFAULT_PRICE_SMALL = 0.05;
    public static final double DEFAULT_PRICE_MEDIUM = 0.10;
    public static final double DEFAULT_PRICE_LARGE = 0.25;

    public EthosBottledWater() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}