package com.jackingaming.vesselforcheesemobileapp.models.components.drinks2.espresso_options;

public class RoastOptions extends EspressoOptions {
    public enum Type {
        NONE,
        BLONDE,
        SIGNATURE,
        DECAF,
        DECAF_ONE_THIRD,
        DECAF_ONE_HALF,
        DECAF_TWO_THIRD;
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
