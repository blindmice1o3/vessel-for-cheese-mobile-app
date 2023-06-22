package com.jackingaming.vesselforcheesemobileapp.models.components.drinks.refresher_base_options;

import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;

public class RefresherBase extends RefresherBaseOptions {
    public static final String DEFAULT_TEXT_INIT = "Add Refresher Bases";

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
    public String getTextInit() {
        return DEFAULT_TEXT_INIT;
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
        return RefresherBase.class.getSimpleName();
    }

    @Override
    public String getTypeAsString() {
        return type.name();
    }

    @Override
    public void setTypeByString(String typeAsString) {
        if (typeAsString.equals(DrinkComponent.NULL_TYPE_AS_STRING)) {
            type = null;
            return;
        }

        Type[] enumValues = Type.values();
        for (int i = 0; i < enumValues.length; i++) {
            if (enumValues[i].name().equals(typeAsString)) {
                type = enumValues[i];
                break;
            }
        }
    }
}
