package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.blended.cremebased;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.blended.Blended;

public abstract class CremeBased extends Blended {
    public static final String TAG = CremeBased.class.getSimpleName();

    public CremeBased() {
    }

    public CremeBased(String name, String description, int calories, int sugarInGram, float fatInGram,
                      double price) {
        super(name, description, calories, sugarInGram, fatInGram,
                price);
    }
}
