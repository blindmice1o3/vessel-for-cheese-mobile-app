package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.cappuccinos;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.MilkBased;

public abstract class Cappuccinos extends MilkBased {
    public static final String TAG = Cappuccinos.class.getSimpleName();

    public Cappuccinos() {
    }

    public Cappuccinos(String name, String description, double price, boolean iced) {
        super(name, description, price, iced);
    }
}
