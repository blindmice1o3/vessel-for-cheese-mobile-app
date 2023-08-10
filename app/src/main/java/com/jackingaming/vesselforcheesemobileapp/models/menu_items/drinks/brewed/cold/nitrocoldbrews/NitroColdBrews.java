package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.cold.nitrocoldbrews;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.cold.ColdBrewedCoffees;

public abstract class NitroColdBrews extends ColdBrewedCoffees {
    public static final String TAG = NitroColdBrews.class.getSimpleName();

    public static final DrinkSize[] DEFAULT_DRINK_SIZES_ALLOWED =
            {DrinkSize.TALL, DrinkSize.GRANDE};

    public NitroColdBrews() {
    }

    public NitroColdBrews(int imageResourceId, String name, String description,
                          int calories, int sugarInGram, float fatInGram,
                          double price) {
        super(imageResourceId, name, description,
                calories, sugarInGram, fatInGram,
                price);

        drinkSizesAllowed = DEFAULT_DRINK_SIZES_ALLOWED;
    }
}
