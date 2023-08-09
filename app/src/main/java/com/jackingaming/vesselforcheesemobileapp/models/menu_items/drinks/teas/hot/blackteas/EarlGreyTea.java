package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.hot.blackteas;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.hot.HotTeas;

public class EarlGreyTea extends HotTeas {
    public static final String TAG = EarlGreyTea.class.getSimpleName();

    public static final String DEFAULT_NAME = "Earl Grey Tea";
    public static final String DEFAULT_DESCRIPTION = "We take a strong black tea base and add the essence of bergamot, a citrus fruit with subtle lemon and floral lavender notes, to create this aromatically awesome tea flavor.";
    public static final int DEFAULT_CALORIES = 0;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public EarlGreyTea() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
