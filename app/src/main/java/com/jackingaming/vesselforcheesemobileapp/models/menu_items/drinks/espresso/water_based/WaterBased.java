package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.water_based;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.Espresso;

public abstract class WaterBased extends Espresso {
    public static final String TAG = WaterBased.class.getSimpleName();
    public static final DrinkSize DEFAULT_DRINK_SIZE = DrinkSize.GRANDE;

    public WaterBased() {
    }

    public WaterBased(String name, String description, int calories, int sugarInGram, float fatInGram,
                      double price, boolean iced) {
        super(name, description, calories, sugarInGram, fatInGram, price, DEFAULT_DRINK_SIZE, iced);
    }
}
