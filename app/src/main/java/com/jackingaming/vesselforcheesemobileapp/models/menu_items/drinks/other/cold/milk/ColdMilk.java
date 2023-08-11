package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.cold.milk;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.cold.ColdOther;

public class ColdMilk extends ColdOther {
    public static final String TAG = ColdMilk.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Cold Milk";
    public static final String DEFAULT_DESCRIPTION = "Skim, 2%, soy, almond, or coconutmilk served chilled or over ice. Simply refreshing.";
    public static final int DEFAULT_CALORIES = 260;
    public static final int DEFAULT_SUGAR_IN_GRAM = 25;
    public static final float DEFAULT_FAT_IN_GRAM = 10.0f;

    public static final double DEFAULT_PRICE_SMALL = 0.05;
    public static final double DEFAULT_PRICE_MEDIUM = 0.10;
    public static final double DEFAULT_PRICE_LARGE = 0.25;

    public ColdMilk() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
