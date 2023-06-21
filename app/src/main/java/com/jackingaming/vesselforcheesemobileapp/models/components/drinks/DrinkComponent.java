package com.jackingaming.vesselforcheesemobileapp.models.components.drinks;

import java.io.Serializable;

public abstract class DrinkComponent
        implements Serializable {
    public static final String TAG = DrinkComponent.class.getSimpleName();
    public static final String NULL_TYPE_AS_STRING = "null";

    private String typeIntendedAsString;

    public String getTypeIntendedAsString() {
        return typeIntendedAsString;
    }

    public void setTypeIntendedAsString(String typeIntendedAsString) {
        this.typeIntendedAsString = typeIntendedAsString;
    }

    public abstract String[] getEnumValuesAsStringArray();

    public abstract String getClassAsString();

    public abstract String getTypeAsString();

    public abstract void setTypeByString(String typeAsString);
}
