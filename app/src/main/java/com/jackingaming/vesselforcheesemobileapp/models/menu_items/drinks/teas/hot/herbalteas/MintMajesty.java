package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.hot.herbalteas;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.hot.HotTeas;

public class MintMajesty extends HotTeas {
    public static final String TAG = MintMajesty.class.getSimpleName();

    public static final String DEFAULT_NAME = "Mint Majesty";
    public static final String DEFAULT_DESCRIPTION = "A blend of mint and a pinch of lemon verbena creates a refreshing flavor that's supercool for a caffeine-free herbal tea.";
    public static final int DEFAULT_CALORIES = 0;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public MintMajesty() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
