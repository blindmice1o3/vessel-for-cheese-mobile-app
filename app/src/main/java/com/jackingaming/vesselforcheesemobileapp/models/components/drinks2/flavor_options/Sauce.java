package com.jackingaming.vesselforcheesemobileapp.models.components.drinks2.flavor_options;

public class Sauce extends FlavorOptions {
    public enum Type {
        DARK_CARAMEL,
        MOCHA,
        PISTACHIO,
        WHITE_CHOCOLATE_MOCHA;
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
