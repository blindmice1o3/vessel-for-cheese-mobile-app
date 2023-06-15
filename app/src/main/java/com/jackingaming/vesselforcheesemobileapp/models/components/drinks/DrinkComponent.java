package com.jackingaming.vesselforcheesemobileapp.models.components.drinks;

import java.io.Serializable;

public abstract class DrinkComponent
        implements Serializable {
    public static final String TAG = DrinkComponent.class.getSimpleName();

    public abstract String[] getEnumValuesAsStringArray();

    public abstract String getTypeAsString();

    public abstract void setTypeByString(String typeAsString);
}
