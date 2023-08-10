package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.cold.icedgreenteas;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.cold.IcedTeas;

public class IcedMatchaLemonade extends IcedTeas {
    public static final String TAG = IcedMatchaLemonade.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Iced Matcha Lemonade";
    public static final String DEFAULT_DESCRIPTION = "Our finely ground Teavana matcha green tea combined with crisp lemonade, then shaken with ice, creates a refreshingly sweet, delicious drink and a delightfully vibrant, green hue.";
    public static final int DEFAULT_CALORIES = 120;
    public static final int DEFAULT_SUGAR_IN_GRAM = 27;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public IcedMatchaLemonade() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
