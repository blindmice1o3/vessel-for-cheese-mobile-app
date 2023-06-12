package com.jackingaming.vesselforcheesemobileapp.models.components.drinks.refresher_base_options;

public class RefresherBase extends RefresherBaseOptions {
    public enum Type {
        KIWI_STARFRUIT,
        MANGO_DRAGONFRUIT,
        PINEAPPLE_PASSIONFRUIT,
        STRAWBERRY_ACAI;
    }

    private Type type;

    public RefresherBase(Type type) {
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
