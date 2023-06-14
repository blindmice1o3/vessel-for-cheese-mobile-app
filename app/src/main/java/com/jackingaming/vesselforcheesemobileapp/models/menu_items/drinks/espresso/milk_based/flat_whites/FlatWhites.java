package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.flat_whites;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.MilkBased;

public abstract class FlatWhites extends MilkBased {
    public static final String TAG = FlatWhites.class.getSimpleName();

    public FlatWhites() {
    }

    public FlatWhites(String name, String description, int calories, int sugarInGram, float fatInGram,
                      double price, boolean iced) {
        super(name, description, calories, sugarInGram, fatInGram, price, iced);
    }
}
