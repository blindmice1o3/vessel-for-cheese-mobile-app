package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.cold.icedshakenespressos;

import com.jackingaming.vesselforcheesemobileapp.R;

public class IcedToastedVanillaOatmilkShakenEspresso extends IcedShakenEspressos {
    public static final String TAG = IcedToastedVanillaOatmilkShakenEspresso.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Iced Toasted Vanilla Oatmilk Shaken Espresso";
    public static final String DEFAULT_DESCRIPTION = "Starbucks Blonde espresso combined with notes of caramelized vanilla shaken together and topped with oatmilk for an energizing treat to boost your day.";
    public static final int DEFAULT_CALORIES = 140;
    public static final int DEFAULT_SUGAR_IN_GRAM = 11;
    public static final float DEFAULT_FAT_IN_GRAM = 4.5f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public IcedToastedVanillaOatmilkShakenEspresso() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
