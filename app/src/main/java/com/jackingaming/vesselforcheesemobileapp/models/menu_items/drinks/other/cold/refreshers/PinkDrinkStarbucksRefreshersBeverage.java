package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.cold.refreshers;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.cold.ColdOther;

public class PinkDrinkStarbucksRefreshersBeverage extends ColdOther {
    public static final String TAG = PinkDrinkStarbucksRefreshersBeverage.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Pink Drink Starbucks Refreshers Beverage";
    public static final String DEFAULT_DESCRIPTION = "Our crisp Strawberry Acai Refreshers beverage--with accents of passion fruit and combined with creamy coconutmilk--evokes a fruity and refreshing sip of spring, no matter what time of year.";
    public static final int DEFAULT_CALORIES = 140;
    public static final int DEFAULT_SUGAR_IN_GRAM = 25;
    public static final float DEFAULT_FAT_IN_GRAM = 2.5f;

    public static final double DEFAULT_PRICE_SMALL = 0.05;
    public static final double DEFAULT_PRICE_MEDIUM = 0.10;
    public static final double DEFAULT_PRICE_LARGE = 0.25;

    public PinkDrinkStarbucksRefreshersBeverage() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
