package com.jackingaming.vesselforcheesemobileapp.models.components.drinks;

import java.io.Serializable;

public abstract class DrinkComponent
        implements Serializable {
    public static final String TAG = DrinkComponent.class.getSimpleName();
    public static final String NULL_TYPE_AS_STRING = "null";
    public static final int QUANTITY_FOR_INVOKER = -1;

    public abstract String getTextInit();

    public abstract String[] getEnumValuesAsStringArray();

    public abstract String getClassAsString();

    public abstract String getTypeAsString();

    public abstract void setTypeByString(String typeAsString);
}
