package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.hot;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.Other;

public abstract class HotOther extends Other {
    public static final String TAG = HotOther.class.getSimpleName();
    public static final DrinkSize DEFAULT_DRINK_SIZE = DrinkSize.GRANDE;

    public static final DrinkSize[] DEFAULT_DRINK_SIZES_ALLOWED =
            {DrinkSize.SHORT, DrinkSize.TALL, DrinkSize.GRANDE, DrinkSize.VENTI_HOT};

    public HotOther() {
    }

    public HotOther(String name, String description, int calories, int sugarInGram, float fatInGram,
                    double price) {
        super(name, description, calories, sugarInGram, fatInGram,
                price, DEFAULT_DRINK_SIZE);

        drinkSizesAllowed = DEFAULT_DRINK_SIZES_ALLOWED;
    }
}
