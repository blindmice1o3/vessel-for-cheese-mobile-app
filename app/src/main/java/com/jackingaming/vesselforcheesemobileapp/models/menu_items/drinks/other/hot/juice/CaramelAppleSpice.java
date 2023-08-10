package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.hot.juice;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.hot.HotOther;

public class CaramelAppleSpice extends HotOther {
    public static final String TAG = CaramelAppleSpice.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Caramel Apple Spice";
    public static final String DEFAULT_DESCRIPTION = "Steamed apple juice complemented with cinnamon syrup, whipped cream and a caramel sauce drizzle.";
    public static final int DEFAULT_CALORIES = 380;
    public static final int DEFAULT_SUGAR_IN_GRAM = 70;
    public static final float DEFAULT_FAT_IN_GRAM = 8.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public CaramelAppleSpice() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
