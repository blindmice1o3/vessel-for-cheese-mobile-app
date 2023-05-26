package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.Espresso;

public abstract class MilkBased extends Espresso {
    public static final String TAG = MilkBased.class.getSimpleName();

    // TODO: milk.type field

    public MilkBased() {
    }

    public MilkBased(String name, String description, double price, boolean iced) {
        super(name, description, price, iced);
    }
}