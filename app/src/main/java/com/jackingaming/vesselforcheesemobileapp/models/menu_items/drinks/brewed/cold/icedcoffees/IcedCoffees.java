package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.cold.icedcoffees;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.cold.ColdBrewedCoffees;

public abstract class IcedCoffees extends ColdBrewedCoffees {
    public static final String TAG = IcedCoffees.class.getSimpleName();

    public IcedCoffees() {
    }

    public IcedCoffees(String name, String description, int calories, int sugarInGram, float fatInGram,
                       double price) {
        super(name, description, calories, sugarInGram, fatInGram,
                price);
    }
}
