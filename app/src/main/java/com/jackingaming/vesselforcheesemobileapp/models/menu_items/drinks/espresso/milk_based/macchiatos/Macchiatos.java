package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.macchiatos;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.MilkBased;

public abstract class Macchiatos extends MilkBased {
    public static final String TAG = Macchiatos.class.getSimpleName();

    public Macchiatos() {
    }

    public Macchiatos(String name, String description, double price, boolean iced) {
        super(name, description, price, iced);
    }
}
