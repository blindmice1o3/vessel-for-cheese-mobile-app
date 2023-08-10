package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.blendedbeverages.coffeebased;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.blendedbeverages.BlendedBeverages;

public abstract class CoffeeBased extends BlendedBeverages {
    public static final String TAG = CoffeeBased.class.getSimpleName();

    public CoffeeBased() {
    }

    public CoffeeBased(int imageResourceId, String name, String description,
                       int calories, int sugarInGram, float fatInGram,
                       double price) {
        super(imageResourceId, name, description,
                calories, sugarInGram, fatInGram,
                price);
    }
}
