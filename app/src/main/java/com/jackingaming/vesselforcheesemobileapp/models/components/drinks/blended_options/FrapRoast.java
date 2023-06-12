package com.jackingaming.vesselforcheesemobileapp.models.components.drinks.blended_options;

public class FrapRoast extends BlendedOptions {
    public enum Type {
        FRAP_ROAST;
    }

    private Type type;

    public FrapRoast(Type type) {
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
