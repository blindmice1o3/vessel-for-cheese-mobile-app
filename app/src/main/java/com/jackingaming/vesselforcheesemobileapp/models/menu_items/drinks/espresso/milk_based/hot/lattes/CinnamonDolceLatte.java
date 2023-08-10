package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.hot.lattes;

import com.jackingaming.vesselforcheesemobileapp.R;

public class CinnamonDolceLatte extends Lattes {
    public static final String TAG = CinnamonDolceLatte.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Cinnamon Dolce Latte";
    public static final String DEFAULT_DESCRIPTION = "We add freshly steamed milk and cinnamon dolce-flavored syrup to our classic espresso, topped with sweetened whipped cream and a cinnamon dolce topping to bring you specialness in a treat.";
    public static final int DEFAULT_CALORIES = 340;
    public static final int DEFAULT_SUGAR_IN_GRAM = 40;
    public static final float DEFAULT_FAT_IN_GRAM = 14.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public CinnamonDolceLatte() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
