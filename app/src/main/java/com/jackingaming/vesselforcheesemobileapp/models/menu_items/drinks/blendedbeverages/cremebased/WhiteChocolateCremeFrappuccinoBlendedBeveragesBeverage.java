package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.blendedbeverages.cremebased;

import com.jackingaming.vesselforcheesemobileapp.R;

public class WhiteChocolateCremeFrappuccinoBlendedBeveragesBeverage extends CremeBased {
    public static final String TAG = WhiteChocolateCremeFrappuccinoBlendedBeveragesBeverage.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "White Chocolate Creme Frappuccino Blended Beverage";
    public static final String DEFAULT_DESCRIPTION = "A smooth blend of white chocolate sauce, milk and ice topped with whipped cream for a remarkable flavor that surprisingly wows.";
    public static final int DEFAULT_CALORIES = 380;
    public static final int DEFAULT_SUGAR_IN_GRAM = 49;
    public static final float DEFAULT_FAT_IN_GRAM = 18.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public WhiteChocolateCremeFrappuccinoBlendedBeveragesBeverage() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
