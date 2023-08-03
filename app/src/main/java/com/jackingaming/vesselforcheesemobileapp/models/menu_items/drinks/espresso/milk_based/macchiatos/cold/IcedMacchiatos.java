package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.macchiatos.cold;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.MilkBased;

public abstract class IcedMacchiatos extends MilkBased {
    public static final String TAG = IcedMacchiatos.class.getSimpleName();

    public static final DrinkSize[] DEFAULT_DRINK_SIZES_ALLOWED =
            {DrinkSize.TALL, DrinkSize.GRANDE, DrinkSize.VENTI_ICED};

    public IcedMacchiatos() {
    }

    public IcedMacchiatos(String name, String description, int calories, int sugarInGram, float fatInGram,
                          double price, boolean iced) {
        super(name, description, calories, sugarInGram, fatInGram, price, iced);

        drinkSizesAllowed = DEFAULT_DRINK_SIZES_ALLOWED;
    }
}
