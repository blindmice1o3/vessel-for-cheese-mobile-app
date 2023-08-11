package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.cold.refreshers;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.cold.ColdOther;

public class FrozenPineapplePassionfruitLemonadeStarbucksRefreshersBeverage extends ColdOther {
    public static final String TAG = FrozenPineapplePassionfruitLemonadeStarbucksRefreshersBeverage.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Frozen Pineapple Passionfruit Lemonade Starbucks Refreshers Beverage";
    public static final String DEFAULT_DESCRIPTION = "Tropical flavors of pineapple and passionfruit blended with real diced pineapple, strawberry puree and lemonade for a refreshingly frozen, vibrant escape in a cup.";
    public static final int DEFAULT_CALORIES = 160;
    public static final int DEFAULT_SUGAR_IN_GRAM = 33;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 0.05;
    public static final double DEFAULT_PRICE_MEDIUM = 0.10;
    public static final double DEFAULT_PRICE_LARGE = 0.25;

    public FrozenPineapplePassionfruitLemonadeStarbucksRefreshersBeverage() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
