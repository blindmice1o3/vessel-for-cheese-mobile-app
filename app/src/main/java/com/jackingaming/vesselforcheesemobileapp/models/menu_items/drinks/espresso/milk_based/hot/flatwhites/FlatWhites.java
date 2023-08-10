package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.hot.flatwhites;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.MilkBased;

public abstract class FlatWhites extends MilkBased {
    public static final String TAG = FlatWhites.class.getSimpleName();
    public static final DrinkSize DEFAULT_DRINK_SIZE = DrinkSize.GRANDE;

    public static final DrinkSize[] DEFAULT_DRINK_SIZES_ALLOWED =
            {DrinkSize.SHORT, DrinkSize.TALL, DrinkSize.GRANDE, DrinkSize.VENTI_HOT};

    public FlatWhites() {
    }

    public FlatWhites(int imageResourceId, String name, String description,
                      int calories, int sugarInGram, float fatInGram,
                      double price) {
        super(imageResourceId, name, description,
                calories, sugarInGram, fatInGram,
                price, DEFAULT_DRINK_SIZE);

        drinkSizesAllowed = DEFAULT_DRINK_SIZES_ALLOWED;
    }
}
