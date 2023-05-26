package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.travelers;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.Drink;

public abstract class CoffeeTravelers extends Drink {
    public static final String TAG = CoffeeTravelers.class.getSimpleName();

    public CoffeeTravelers() {
    }

    public CoffeeTravelers(String name, String description, double price, boolean iced) {
        super(name, description, price, iced);
    }
}
