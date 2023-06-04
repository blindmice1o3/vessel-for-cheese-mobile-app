package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.water_based;

import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.size_options.SizeOptions;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.Espresso;

public abstract class WaterBased extends Espresso {
    public static final String TAG = WaterBased.class.getSimpleName();
    public static final SizeOptions.DrinkSize DEFAULT_DRINK_SIZE = SizeOptions.DrinkSize.GRANDE;

    public WaterBased() {
    }

    public WaterBased(String name, String description, double price, boolean iced) {
        super(name, description, price, DEFAULT_DRINK_SIZE, iced);
    }
}
