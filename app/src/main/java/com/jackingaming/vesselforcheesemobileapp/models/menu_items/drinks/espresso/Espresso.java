package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.Drink;

public abstract class Espresso extends Drink {
    public static final String TAG = Espresso.class.getSimpleName();

    public enum Type {SHOT, CAPPUCCINO, FLAT_WHITE, LATTE, MACCHIATO;}

    // TODO: numberOfShots field

    public Espresso() {
    }

    public Espresso(String name, String description, int calories, int sugarInGram, float fatInGram,
                    double price, DrinkSize drinkSizeDefault, boolean iced) {
        super(name, description, calories, sugarInGram, fatInGram, price, drinkSizeDefault, iced);
    }
}
