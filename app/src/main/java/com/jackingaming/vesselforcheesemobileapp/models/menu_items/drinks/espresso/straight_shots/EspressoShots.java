package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.straight_shots;

import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.size_options.DrinkSize;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.Espresso;

public abstract class EspressoShots extends Espresso {
    public static final String TAG = EspressoShots.class.getSimpleName();
    public static final DrinkSize.Type DEFAULT_DRINK_SIZE = DrinkSize.Type.UNIQUE;

    public EspressoShots() {
    }

    public EspressoShots(String name, String description, double price, boolean iced) {
        super(name, description, price, DEFAULT_DRINK_SIZE, iced);
    }
}
