package com.jackingaming.vesselforcheesemobileapp.models.components.drinks.flavor_options;

public class Syrup extends FlavorOptions {
    public enum Type {
        BROWN_SUGAR,
        CARAMEL,
        CINNAMON_DOLCE,
        HAZELNUT,
        PEPPERMINT,
        RASPBERRY,
        SUGAR_FREE_VANILLA,
        TOASTED_VANILLA,
        TOFFEE_NUT,
        VANILLA;
    }

    private Type type;

    public Syrup(Type type) {
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

    @Override
    public String getTypeAsString() {
        return type.name();
    }

    @Override
    public void setTypeByString(String typeAsString) {
        Type[] enumValues = Type.values();
        for (int i = 0; i < enumValues.length; i++) {
            if (enumValues[i].name().equals(typeAsString)) {
                type = enumValues[i];
                break;
            }
        }
    }
}
