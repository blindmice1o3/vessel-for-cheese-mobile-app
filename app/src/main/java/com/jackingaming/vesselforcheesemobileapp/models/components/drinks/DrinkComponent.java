package com.jackingaming.vesselforcheesemobileapp.models.components.drinks;

public abstract class DrinkComponent {
    public static final String TAG = DrinkComponent.class.getSimpleName();

    public abstract String[] getEnumValuesAsStringArray();

    public abstract String getTypeAsString();
    public abstract void setTypeByString(String typeAsString);
}
