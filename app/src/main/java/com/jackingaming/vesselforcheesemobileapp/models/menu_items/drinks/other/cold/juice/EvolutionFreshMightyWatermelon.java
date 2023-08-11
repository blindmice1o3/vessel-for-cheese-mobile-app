package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.cold.juice;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.cold.ColdOther;

public class EvolutionFreshMightyWatermelon extends ColdOther {
    public static final String TAG = EvolutionFreshMightyWatermelon.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Evolution Fresh Mighty Watermelon";
    public static final String DEFAULT_DESCRIPTION = "A naturally refreshing and hydrating juice with just a touch of lemon, our fruit is picked at its absolute peak of sweetness then cold-pressed using high pressure processing for maximum flavor and nutrients. 100% juice with no added sweeteners or artificial flavors.";
    public static final int DEFAULT_CALORIES = 130;
    public static final int DEFAULT_SUGAR_IN_GRAM = 25;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 0.05;
    public static final double DEFAULT_PRICE_MEDIUM = 0.10;
    public static final double DEFAULT_PRICE_LARGE = 0.25;

    public EvolutionFreshMightyWatermelon() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
