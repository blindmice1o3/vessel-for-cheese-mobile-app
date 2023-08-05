package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.cold;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.BrewedCoffees;

public class ColdBrewedCoffees extends BrewedCoffees {
    public static final String TAG = ColdBrewedCoffees.class.getSimpleName();
    public static final DrinkSize DEFAULT_DRINK_SIZE = DrinkSize.GRANDE;

    public static final DrinkSize[] DEFAULT_DRINK_SIZES_ALLOWED =
            {DrinkSize.TALL, DrinkSize.GRANDE, DrinkSize.VENTI_ICED, DrinkSize.TRENTA};

    public ColdBrewedCoffees() {
    }

    public ColdBrewedCoffees(String name, String description, int calories, int sugarInGram, float fatInGram,
                             double price, boolean iced) {
        super(name, description, calories, sugarInGram, fatInGram, price, DEFAULT_DRINK_SIZE, iced);

        drinkSizesAllowed = DEFAULT_DRINK_SIZES_ALLOWED;
    }
}
