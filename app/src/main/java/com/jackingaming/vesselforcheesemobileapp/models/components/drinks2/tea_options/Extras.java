package com.jackingaming.vesselforcheesemobileapp.models.components.drinks2.tea_options;

public class Extras extends TeaOptions {
    public enum Type {
        EXTRA_NONE,
        EXTRA_LEMONADE,
        EXTRA_TEA;
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
