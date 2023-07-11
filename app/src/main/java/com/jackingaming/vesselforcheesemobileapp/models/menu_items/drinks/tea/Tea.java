package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.tea;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.Drink;

public abstract class Tea extends Drink {
    public static final String TAG = Tea.class.getSimpleName();
    public static final DrinkSize DEFAULT_DRINK_SIZE = DrinkSize.GRANDE;

    public Tea() {
    }

    public Tea(String name, String description, int calories, int sugarInGram, float fatInGram,
               double price, boolean iced) {
        super(name, description, calories, sugarInGram, fatInGram, price, DEFAULT_DRINK_SIZE, iced);
    }
}
