package com.jackingaming.vesselforcheesemobileapp.models.menu.drinks.other;

import com.jackingaming.vesselforcheesemobileapp.models.menu.drinks.Drink;

public abstract class Other extends Drink {
    public static final String TAG = Other.class.getSimpleName();

    public Other() {
        super();
    }

    public Other(String name, String description, double price, boolean iced) {
        super(name, description, price, iced);
    }
}
