package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.Drink;

public abstract class Brewed extends Drink {
    public static final String TAG = Brewed.class.getSimpleName();

    public Brewed() {
    }

    public Brewed(String name, String description, double price, boolean iced) {
        super(name, description, price, iced);
    }
}
