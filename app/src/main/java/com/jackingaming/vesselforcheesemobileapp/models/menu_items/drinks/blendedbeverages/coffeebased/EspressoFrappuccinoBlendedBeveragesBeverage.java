package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.blendedbeverages.coffeebased;

import com.jackingaming.vesselforcheesemobileapp.R;

public class EspressoFrappuccinoBlendedBeveragesBeverage extends CoffeeBased {
    public static final String TAG = EspressoFrappuccinoBlendedBeveragesBeverage.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Espresso Frappuccino Blended Beverage";
    public static final String DEFAULT_DESCRIPTION = "Coffee is combined with a shot of espresso and milk, then blended with ice to give you a nice little jolt and lots of sipping joy.";
    public static final int DEFAULT_CALORIES = 210;
    public static final int DEFAULT_SUGAR_IN_GRAM = 42;
    public static final float DEFAULT_FAT_IN_GRAM = 2.5f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public EspressoFrappuccinoBlendedBeveragesBeverage() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
