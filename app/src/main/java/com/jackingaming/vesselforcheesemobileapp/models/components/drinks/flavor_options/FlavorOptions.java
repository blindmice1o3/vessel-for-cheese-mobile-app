package com.jackingaming.vesselforcheesemobileapp.models.components.drinks.flavor_options;

import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;

public abstract class FlavorOptions extends DrinkComponent {
    public static final String TAG = FlavorOptions.class.getSimpleName();

    public FlavorOptions(String id) {
        super(id);
    }
}
