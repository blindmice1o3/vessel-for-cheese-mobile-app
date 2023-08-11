package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.cold.juice;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.cold.ColdOther;

public class EvolutionFreshOrganicDefenseUp extends ColdOther {
    public static final String TAG = EvolutionFreshOrganicDefenseUp.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Evolution Fresh Organic Defense Up";
    public static final String DEFAULT_DESCRIPTION = "A refreshing smoothie packed with bright flavor thanks to organic oranges, pineapples, mangoes, apples and acerola cherries. An excellent source of vitamin C, made with 100% juice and no added sweeteners or artificial flavors.";
    public static final int DEFAULT_CALORIES = 170;
    public static final int DEFAULT_SUGAR_IN_GRAM = 37;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 0.05;
    public static final double DEFAULT_PRICE_MEDIUM = 0.10;
    public static final double DEFAULT_PRICE_LARGE = 0.25;

    public EvolutionFreshOrganicDefenseUp() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
