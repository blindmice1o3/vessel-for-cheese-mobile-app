package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.hot;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.BrewedCoffees;

public abstract class HotBrewedCoffees extends BrewedCoffees {
    public static final String TAG = HotBrewedCoffees.class.getSimpleName();
    public static final DrinkSize DEFAULT_DRINK_SIZE = DrinkSize.GRANDE;

    public static final DrinkSize[] DEFAULT_DRINK_SIZES_ALLOWED =
            {DrinkSize.SHORT, DrinkSize.TALL, DrinkSize.GRANDE, DrinkSize.VENTI_HOT};

    public HotBrewedCoffees() {
    }

    public HotBrewedCoffees(int imageResourceId, String name, String description,
                            int calories, int sugarInGram, float fatInGram,
                            double price) {
        super(imageResourceId, name, description,
                calories, sugarInGram, fatInGram,
                price, DEFAULT_DRINK_SIZE);

        drinkSizesAllowed = DEFAULT_DRINK_SIZES_ALLOWED;
    }
}
