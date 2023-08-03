package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.water_based.americanos.cold;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.water_based.WaterBased;

public abstract class IcedAmericano extends WaterBased {
    public static final String TAG = IcedAmericano.class.getSimpleName();

    public static final DrinkSize[] DEFAULT_DRINK_SIZES_ALLOWED =
            {DrinkSize.TALL, DrinkSize.GRANDE, DrinkSize.VENTI_ICED};

    public IcedAmericano() {
    }

    public IcedAmericano(String name, String description, int calories, int sugarInGram, float fatInGram,
                         double price, boolean iced) {
        super(name, description, calories, sugarInGram, fatInGram, price, iced);

        drinkSizesAllowed = DEFAULT_DRINK_SIZES_ALLOWED;
    }
}
