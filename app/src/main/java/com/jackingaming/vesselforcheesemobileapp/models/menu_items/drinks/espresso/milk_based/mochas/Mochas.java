package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.mochas;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.MilkBased;

public abstract class Mochas extends MilkBased {
    public static final String TAG = Mochas.class.getSimpleName();

    public Mochas() {
    }

    public Mochas(String name, String description, int calories, int sugarInGram, float fatInGram,
                  double price, boolean iced) {
        super(name, description, calories, sugarInGram, fatInGram, price, iced);
    }
}
