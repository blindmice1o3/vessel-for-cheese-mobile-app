package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.blendedbeverages.cremebased;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.blendedbeverages.BlendedBeverages;

public abstract class CremeBased extends BlendedBeverages {
    public static final String TAG = CremeBased.class.getSimpleName();

    public CremeBased() {
    }

    public CremeBased(int imageResourceId, String name, String description,
                      int calories, int sugarInGram, float fatInGram,
                      double price) {
        super(imageResourceId, name, description,
                calories, sugarInGram, fatInGram,
                price);
    }
}
