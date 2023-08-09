package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.hot.herbalteas;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.hot.HotTeas;

public class PeachTranquility extends HotTeas {
    public static final String TAG = PeachTranquility.class.getSimpleName();

    public static final String DEFAULT_NAME = "Peach Tranquility";
    public static final String DEFAULT_DESCRIPTION = "A sweet fusion of peach, candied pineapple, chamomile blossoms, lemon verbena and rose hips come together in this caffeine-free herbal tea. Sip back and relax.";
    public static final int DEFAULT_CALORIES = 0;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public PeachTranquility() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
