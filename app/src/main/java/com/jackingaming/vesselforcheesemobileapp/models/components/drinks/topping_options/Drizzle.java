package com.jackingaming.vesselforcheesemobileapp.models.components.drinks.topping_options;

public class Drizzle extends ToppingOptions {
    public enum Type {
        CARAMEL,
        MOCHA;
    }

    private Type type;

    public Drizzle(Type type) {
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
