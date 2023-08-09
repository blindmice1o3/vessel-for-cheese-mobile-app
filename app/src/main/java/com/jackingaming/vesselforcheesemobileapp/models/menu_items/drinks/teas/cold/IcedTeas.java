package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.cold;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.Teas;

public abstract class IcedTeas extends Teas {
    public static final String TAG = IcedTeas.class.getSimpleName();
    public static final DrinkSize DEFAULT_DRINK_SIZE = DrinkSize.GRANDE;

    public static final DrinkSize[] DEFAULT_DRINK_SIZES_ALLOWED =
            {DrinkSize.TALL, DrinkSize.GRANDE, DrinkSize.VENTI_ICED, DrinkSize.TRENTA};

    public IcedTeas() {
    }

    public IcedTeas(String name, String description, int calories, int sugarInGram, float fatInGram,
                    double price) {
        super(name, description, calories, sugarInGram, fatInGram,
                price, DEFAULT_DRINK_SIZE);

        drinkSizesAllowed = DEFAULT_DRINK_SIZES_ALLOWED;
    }
}
