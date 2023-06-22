package com.jackingaming.vesselforcheesemobileapp.models.components.drinks.topping_options;

import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;

public class ColdFoam extends ToppingOptions {
    public static final String DEFAULT_TEXT_INIT = "Add Cold Foam";

    public enum Type {
        CHOCOLATE_CREAM,
        PISTACHIO_CREAM,
        SALTED_CARAMEL_CREAM,
        VANILLA_SWEET_CREAM;
    }

    private Type type;

    public ColdFoam(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String getTextInit() {
        return DEFAULT_TEXT_INIT;
    }

    @Override
    public String[] getEnumValuesAsStringArray() {
        Type[] enumValues = Type.values();
        String[] enumValuesAsStringArray = new String[enumValues.length];
        for (int i = 0; i < enumValues.length; i++) {
            enumValuesAsStringArray[i] = enumValues[i].name();
        }
        return enumValuesAsStringArray;
    }

    @Override
    public String getClassAsString() {
        return ColdFoam.class.getSimpleName();
    }

    @Override
    public String getTypeAsString() {
        return type.name();
    }

    @Override
    public void setTypeByString(String typeAsString) {
        if (typeAsString.equals(DrinkComponent.NULL_TYPE_AS_STRING)) {
            type = null;
            return;
        }

        Type[] enumValues = Type.values();
        for (int i = 0; i < enumValues.length; i++) {
            if (enumValues[i].name().equals(typeAsString)) {
                type = enumValues[i];
                break;
            }
        }
    }
}
