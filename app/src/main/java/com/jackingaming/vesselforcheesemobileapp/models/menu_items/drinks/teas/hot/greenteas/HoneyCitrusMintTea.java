package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.hot.greenteas;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.hot.HotTeas;

public class HoneyCitrusMintTea extends HotTeas {
    public static final String TAG = HoneyCitrusMintTea.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Honey Citrus Mint Tea";
    public static final String DEFAULT_DESCRIPTION = "A customer creation so popular it's now on the menu. Jade Citrus Mint green tea, Peach Tranquility herbal tea, hot water, steamed lemonade and a touch of honey mingle tastefully well together for a tea that comforts from the inside out.";
    public static final int DEFAULT_CALORIES = 130;
    public static final int DEFAULT_SUGAR_IN_GRAM = 30;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public HoneyCitrusMintTea() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
