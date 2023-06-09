package com.jackingaming.vesselforcheesemobileapp.models.components.drinks2.sweetener_options;

public class Liquid extends SweetenerOptions {
    public enum Type {
        CLASSIC,
        HONEY_BLEND,
        LIQUID_CANE;
    }

    private Type type;



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
