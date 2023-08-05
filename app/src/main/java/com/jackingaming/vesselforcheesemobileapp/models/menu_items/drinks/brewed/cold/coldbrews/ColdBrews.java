package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.cold.coldbrews;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.cold.ColdBrewedCoffees;

public abstract class ColdBrews extends ColdBrewedCoffees {
    public static final String TAG = ColdBrews.class.getSimpleName();

    public ColdBrews() {
    }

    public ColdBrews(String name, String description, int calories, int sugarInGram, float fatInGram,
                     double price, boolean iced) {
        super(name, description, calories, sugarInGram, fatInGram, price, iced);
    }
}
