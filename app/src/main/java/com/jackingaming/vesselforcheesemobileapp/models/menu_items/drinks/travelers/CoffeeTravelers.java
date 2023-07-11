package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.travelers;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.Drink;

public abstract class CoffeeTravelers extends Drink {
    public static final String TAG = CoffeeTravelers.class.getSimpleName();
    public static final DrinkSize DEFAULT_DRINK_SIZE = DrinkSize.UNIQUE;

    public CoffeeTravelers() {
    }

    public CoffeeTravelers(String name, String description, int calories, int sugarInGram, float fatInGram,
                           double price, boolean iced) {
        super(name, description, calories, sugarInGram, fatInGram, price, DEFAULT_DRINK_SIZE, iced);
    }
}
