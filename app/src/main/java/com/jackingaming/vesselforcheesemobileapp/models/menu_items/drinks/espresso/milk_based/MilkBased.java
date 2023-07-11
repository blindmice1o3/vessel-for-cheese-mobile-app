package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.Espresso;

public abstract class MilkBased extends Espresso {
    public static final String TAG = MilkBased.class.getSimpleName();
    public static final DrinkSize DEFAULT_DRINK_SIZE = DrinkSize.GRANDE;

    public MilkBased() {
    }

    public MilkBased(String name, String description, int calories, int sugarInGram, float fatInGram,
                     double price, boolean iced) {
        super(name, description, calories, sugarInGram, fatInGram, price, DEFAULT_DRINK_SIZE, iced);
    }
}
