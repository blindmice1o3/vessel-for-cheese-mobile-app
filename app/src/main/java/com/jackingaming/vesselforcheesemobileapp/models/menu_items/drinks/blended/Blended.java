package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.blended;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.Drink;

public abstract class Blended extends Drink {
    public static final String TAG = Blended.class.getSimpleName();
    public static final DrinkSize DEFAULT_DRINK_SIZE = DrinkSize.GRANDE;

    public Blended() {
    }

    public Blended(String name, String description, int calories, int sugarInGram, float fatInGram,
                   double price, boolean iced) {
        super(name, description, calories, sugarInGram, fatInGram, price, DEFAULT_DRINK_SIZE, iced);
    }
}
