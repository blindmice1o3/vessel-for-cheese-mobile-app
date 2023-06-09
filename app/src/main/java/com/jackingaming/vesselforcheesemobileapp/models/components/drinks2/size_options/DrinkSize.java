package com.jackingaming.vesselforcheesemobileapp.models.components.drinks2.size_options;

public class DrinkSize extends SizeOptions {
    public enum Type {
        SHORT, TALL, GRANDE, VENTI, TRENTA, UNIQUE, UNDEFINED;
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
