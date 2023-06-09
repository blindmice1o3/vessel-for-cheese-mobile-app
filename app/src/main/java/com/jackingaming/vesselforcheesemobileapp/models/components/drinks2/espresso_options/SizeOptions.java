package com.jackingaming.vesselforcheesemobileapp.models.components.drinks2.espresso_options;

public class SizeOptions extends EspressoOptions {
    public enum Type {
        SOLO,
        DOPPIO,
        TRIPLE,
        QUAD;
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
