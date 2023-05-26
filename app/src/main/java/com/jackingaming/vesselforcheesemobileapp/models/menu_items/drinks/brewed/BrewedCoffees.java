package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.Drink;

public abstract class BrewedCoffees extends Drink {
    public static final String TAG = BrewedCoffees.class.getSimpleName();

    public BrewedCoffees() {
    }

    public BrewedCoffees(String name, String description, double price, boolean iced) {
        super(name, description, price, iced);
    }
}
