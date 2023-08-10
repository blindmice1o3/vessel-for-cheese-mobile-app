package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.cold.icedmochas;

import com.jackingaming.vesselforcheesemobileapp.R;

public class StarbucksReserveIcedDarkChocolateMocha extends IcedMochas {
    public static final String TAG = StarbucksReserveIcedDarkChocolateMocha.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Starbucks Reserve Iced Dark Chocolate Mocha";
    public static final String DEFAULT_DESCRIPTION = "Our small-lot Starbucks Reserve espresso - combined with cocoa and ground chocolate, then topped with cold milk and served over iced - makes a perfect mocha companion day or night.";
    public static final int DEFAULT_CALORIES = 260;
    public static final int DEFAULT_SUGAR_IN_GRAM = 28;
    public static final float DEFAULT_FAT_IN_GRAM = 10.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public StarbucksReserveIcedDarkChocolateMocha() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
