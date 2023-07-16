package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.iced_shaken_espressos;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.MilkBased;

public abstract class IcedShakenEspressos extends MilkBased {
    public static final String TAG = IcedShakenEspressos.class.getSimpleName();

    public IcedShakenEspressos() {
    }

    public IcedShakenEspressos(String name, String description, int calories, int sugarInGram, float fatInGram,
                               double price, boolean iced) {
        super(name, description, calories, sugarInGram, fatInGram, price, iced);
    }
}
