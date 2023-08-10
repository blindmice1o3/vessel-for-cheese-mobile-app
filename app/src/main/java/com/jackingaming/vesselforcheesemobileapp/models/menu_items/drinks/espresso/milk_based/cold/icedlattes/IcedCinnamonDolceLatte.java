package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.cold.icedlattes;

import com.jackingaming.vesselforcheesemobileapp.R;

public class IcedCinnamonDolceLatte extends IcedLattes {
    public static final String TAG = IcedCinnamonDolceLatte.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Iced Cinnamon Dolce Latte";
    public static final String DEFAULT_DESCRIPTION = "We add freshly steamed milk and cinnamon dolce-flavored syrup to our classic espresso and ice, topped with sweetened whipped cream and a cinnamon dolce topping to bring you specialness in a treat.";
    public static final int DEFAULT_CALORIES = 300;
    public static final int DEFAULT_SUGAR_IN_GRAM = 35;
    public static final float DEFAULT_FAT_IN_GRAM = 13.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public IcedCinnamonDolceLatte() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
