package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.Drink;

public abstract class Other extends Drink {
    public static final String TAG = Other.class.getSimpleName();
    public static final DrinkSize DEFAULT_DRINK_SIZE = DrinkSize.GRANDE;

    public Other() {
        super();
    }

    public Other(String name, String description, int calories, int sugarInGram, float fatInGram,
                 double price, boolean iced) {
        super(name, description, calories, sugarInGram, fatInGram, price, DEFAULT_DRINK_SIZE, iced);
    }
}
