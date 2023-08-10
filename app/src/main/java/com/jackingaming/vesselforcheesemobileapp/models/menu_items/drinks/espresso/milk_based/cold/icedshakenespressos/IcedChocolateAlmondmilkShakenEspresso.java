package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.cold.icedshakenespressos;

import com.jackingaming.vesselforcheesemobileapp.R;

public class IcedChocolateAlmondmilkShakenEspresso extends IcedShakenEspressos {
    public static final String TAG = IcedChocolateAlmondmilkShakenEspresso.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Iced Chocolate Almondmilk Shaken Espresso";
    public static final String DEFAULT_DESCRIPTION = "Starbucks Blonde espresso meets cocoa and notes of malt, shaken together and topped with almondmilk and ice for an invigorating treat to power you through your day.";
    public static final int DEFAULT_CALORIES = 110;
    public static final int DEFAULT_SUGAR_IN_GRAM = 16;
    public static final float DEFAULT_FAT_IN_GRAM = 3.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public IcedChocolateAlmondmilkShakenEspresso() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
