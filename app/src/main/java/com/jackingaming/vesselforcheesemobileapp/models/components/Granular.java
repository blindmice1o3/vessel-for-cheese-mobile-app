package com.jackingaming.vesselforcheesemobileapp.models.components;

import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;

public interface Granular {
    enum Amount {NO, LIGHT, MEDIUM, EXTRA;}

    Amount getAmount();

    void setAmount(Amount amount);

    DrinkComponent newInstanceViaTypeAsString(String typeAsString, Granular.Amount amount);
}
