package com.jackingaming.vesselforcheesemobileapp.models.components.drinks.tea_options;

public class IcedTeaBase extends TeaOptions {
    public enum Type {
        BLACK_TEA,
        GREEN_TEA,
        PASSION_TANGO_TEA;
    }

    private Type type;

    public IcedTeaBase(Type type) {
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
    public String getClassAsString() {
        return IcedTeaBase.class.getSimpleName();
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
