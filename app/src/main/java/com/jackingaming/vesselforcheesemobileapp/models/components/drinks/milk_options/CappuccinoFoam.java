package com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options;

public class CappuccinoFoam extends MilkOptions {
    public enum Type {
        EXTRA_DRY, DRY, MEDIUM, WET, EXTRA_WET;
    }

    private Type type;

    public CappuccinoFoam(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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
}
