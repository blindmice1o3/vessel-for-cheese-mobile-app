package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.blended.coffeebased;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.blended.Blended;

public abstract class CoffeeBased extends Blended {
    public static final String TAG = CoffeeBased.class.getSimpleName();

    public CoffeeBased() {
    }

    public CoffeeBased(String name, String description, int calories, int sugarInGram, float fatInGram,
                       double price) {
        super(name, description, calories, sugarInGram, fatInGram,
                price);
    }
}
