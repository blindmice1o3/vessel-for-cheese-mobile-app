package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.blendedbeverages.coffeebased;

import com.jackingaming.vesselforcheesemobileapp.R;

public class CaffeVanillaFrappuccinoBlendedBeveragesBeverage extends CoffeeBased {
    public static final String TAG = CaffeVanillaFrappuccinoBlendedBeveragesBeverage.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Caffe Vanilla Frappuccino Blended Beverage";
    public static final String DEFAULT_DESCRIPTION = "We take Frappuccino roast coffee and vanilla bean powder, combine them with milk and ice, topped with whipped cream. Tastes like happiness.";
    public static final int DEFAULT_CALORIES = 410;
    public static final int DEFAULT_SUGAR_IN_GRAM = 63;
    public static final float DEFAULT_FAT_IN_GRAM = 15.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public CaffeVanillaFrappuccinoBlendedBeveragesBeverage() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
