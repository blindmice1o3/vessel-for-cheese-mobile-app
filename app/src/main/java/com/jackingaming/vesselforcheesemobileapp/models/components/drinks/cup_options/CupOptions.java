package com.jackingaming.vesselforcheesemobileapp.models.components.drinks.cup_options;

import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;

public abstract class CupOptions extends DrinkComponent {
    public static final String TAG = CupOptions.class.getSimpleName();

    public CupOptions(String id) {
        super(id);
    }
}
