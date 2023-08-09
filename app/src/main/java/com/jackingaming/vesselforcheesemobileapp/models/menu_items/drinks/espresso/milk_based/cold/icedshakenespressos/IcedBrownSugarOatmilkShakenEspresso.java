package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.cold.icedshakenespressos;

public class IcedBrownSugarOatmilkShakenEspresso extends IcedShakenEspressos {
    public static final String TAG = IcedBrownSugarOatmilkShakenEspresso.class.getSimpleName();

    public static final String DEFAULT_NAME = "Iced Brown Sugar Oatmilk Shaken Espresso";
    public static final String DEFAULT_DESCRIPTION = "First we shake Starbucks Blonde espresso, brown sugar and cinnamon together, and then top it off with oatmilk and ice for a cool lift to power you through your day.";
    public static final int DEFAULT_CALORIES = 120;
    public static final int DEFAULT_SUGAR_IN_GRAM = 12;
    public static final float DEFAULT_FAT_IN_GRAM = 3.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public IcedBrownSugarOatmilkShakenEspresso() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
