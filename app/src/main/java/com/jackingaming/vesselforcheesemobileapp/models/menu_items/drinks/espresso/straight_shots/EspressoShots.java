package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.straight_shots;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.Espresso;

public abstract class EspressoShots extends Espresso {
    public static final String TAG = EspressoShots.class.getSimpleName();
    public static final DrinkSize DEFAULT_DRINK_SIZE = DrinkSize.UNIQUE;

    public EspressoShots() {
    }

    public EspressoShots(String name, String description, int calories, int sugarInGram, float fatInGram,
                         double price, boolean iced) {
        super(name, description, calories, sugarInGram, fatInGram, price, DEFAULT_DRINK_SIZE, iced);
    }
}
