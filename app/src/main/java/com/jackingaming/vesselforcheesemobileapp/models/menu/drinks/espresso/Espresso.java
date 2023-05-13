package com.jackingaming.vesselforcheesemobileapp.models.menu.drinks.espresso;

import com.jackingaming.vesselforcheesemobileapp.models.menu.drinks.Drink;

public abstract class Espresso extends Drink {
    public static final String TAG = Espresso.class.getSimpleName();

    public enum Type {SHOT, CAPPUCCINO, FLAT_WHITE, LATTE, MACCHIATO;}

    // TODO: numberOfShots field

    public Espresso() {
    }

    public Espresso(String name, String description, double price, boolean iced) {
        super(name, description, price, iced);
    }
}
