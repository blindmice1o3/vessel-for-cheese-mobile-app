package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other;

import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.size_options.SizeOptions;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.Drink;

public abstract class Other extends Drink {
    public static final String TAG = Other.class.getSimpleName();
    public static final SizeOptions.DrinkSize DEFAULT_DRINK_SIZE = SizeOptions.DrinkSize.GRANDE;

    public Other() {
        super();
    }

    public Other(String name, String description, double price, boolean iced) {
        super(name, description, price, DEFAULT_DRINK_SIZE, iced);
    }
}
