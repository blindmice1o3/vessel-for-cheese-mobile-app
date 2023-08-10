package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.water_based;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.Espresso;

public abstract class WaterBased extends Espresso {
    public static final String TAG = WaterBased.class.getSimpleName();

    public WaterBased() {
    }

    public WaterBased(int imageResourceId, String name, String description,
                      int calories, int sugarInGram, float fatInGram,
                      double price, DrinkSize drinkSizeDefault) {
        super(imageResourceId, name, description,
                calories, sugarInGram, fatInGram,
                price, drinkSizeDefault);
    }
}
