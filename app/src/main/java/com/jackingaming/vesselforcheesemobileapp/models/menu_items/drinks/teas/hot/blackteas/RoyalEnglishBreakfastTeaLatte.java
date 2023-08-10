package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.hot.blackteas;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.hot.HotTeas;

public class RoyalEnglishBreakfastTeaLatte extends HotTeas {
    public static final String TAG = RoyalEnglishBreakfastTeaLatte.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Royal English Breakfast Tea Latte";
    public static final String DEFAULT_DESCRIPTION = "A select blend of rich, full-leaf black teas from India and Sri Lanka sweetened with liquid cane sugar and topped with steamed milk and a velvety foam. Each and every sip - smooth and silky.";
    public static final int DEFAULT_CALORIES = 150;
    public static final int DEFAULT_SUGAR_IN_GRAM = 21;
    public static final float DEFAULT_FAT_IN_GRAM = 4.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public RoyalEnglishBreakfastTeaLatte() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
