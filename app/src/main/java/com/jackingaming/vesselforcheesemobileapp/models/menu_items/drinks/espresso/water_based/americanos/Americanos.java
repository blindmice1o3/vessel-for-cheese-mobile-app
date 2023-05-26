package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.water_based.americanos;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.water_based.WaterBased;

public abstract class Americanos extends WaterBased {
    public static final String TAG = Americanos.class.getSimpleName();

    public Americanos() {
    }

    public Americanos(String name, String description, double price, boolean iced) {
        super(name, description, price, iced);
    }
}
