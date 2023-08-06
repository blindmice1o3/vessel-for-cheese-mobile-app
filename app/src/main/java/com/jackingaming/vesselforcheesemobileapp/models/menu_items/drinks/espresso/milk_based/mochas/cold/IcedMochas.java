package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.mochas.cold;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.MilkBased;

public abstract class IcedMochas extends MilkBased {
    public static final String TAG = IcedMochas.class.getSimpleName();
    public static final DrinkSize DEFAULT_DRINK_SIZE = DrinkSize.GRANDE;

    public static final DrinkSize[] DEFAULT_DRINK_SIZES_ALLOWED =
            {DrinkSize.TALL, DrinkSize.GRANDE, DrinkSize.VENTI_ICED};

    public IcedMochas() {
    }

    public IcedMochas(String name, String description, int calories, int sugarInGram, float fatInGram,
                      double price) {
        super(name, description, calories, sugarInGram, fatInGram,
                price, DEFAULT_DRINK_SIZE);

        drinkSizesAllowed = DEFAULT_DRINK_SIZES_ALLOWED;
    }
}
