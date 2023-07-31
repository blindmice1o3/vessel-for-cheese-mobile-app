package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.MilkBased;

public abstract class Lattes extends MilkBased {
    public static final String TAG = Lattes.class.getSimpleName();

    public static final DrinkSize[] DEFAULT_DRINK_SIZES_ALLOWED = {DrinkSize.SHORT, DrinkSize.TALL, DrinkSize.GRANDE, DrinkSize.VENTI_HOT};

    public Lattes() {
    }

    public Lattes(String name, String description, int calories, int sugarInGram, float fatInGram,
                  double price, boolean iced) {
        super(name, description, calories, sugarInGram, fatInGram, price, iced);
    }
}
