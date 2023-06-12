package com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins;

public class LineTheCup extends AddInsOptions {
    public enum Type {
        NONE,
        CARAMEL_SAUCE,
        MOCHA_SAUCE;
    }

    private Type type;

    public LineTheCup(Type type) {
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
