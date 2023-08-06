package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.water_based.americanos.hot;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.water_based.WaterBased;

public abstract class Americanos extends WaterBased {
    public static final String TAG = Americanos.class.getSimpleName();
    public static final DrinkSize DEFAULT_DRINK_SIZE = DrinkSize.GRANDE;

    public static final DrinkSize[] DEFAULT_DRINK_SIZES_ALLOWED =
            {DrinkSize.SHORT, DrinkSize.TALL, DrinkSize.GRANDE, DrinkSize.VENTI_HOT};

    public Americanos() {
    }

    public Americanos(String name, String description, int calories, int sugarInGram, float fatInGram,
                      double price) {
        super(name, description, calories, sugarInGram, fatInGram,
                price, DEFAULT_DRINK_SIZE);

        drinkSizesAllowed = DEFAULT_DRINK_SIZES_ALLOWED;
    }
}
