package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.hot.greenteas;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.hot.HotTeas;

public class JadeCitrusMintBrewedTea extends HotTeas {
    public static final String TAG = JadeCitrusMintBrewedTea.class.getSimpleName();

    public static final String DEFAULT_NAME = "Jade Citrus Mint Brewed Tea";
    public static final String DEFAULT_DESCRIPTION = "Green tea, lemon verbena, lemongrass and a hint of spearmint mingle for a bright, refreshing, citrusy green tea experience.";
    public static final int DEFAULT_CALORIES = 0;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public JadeCitrusMintBrewedTea() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
