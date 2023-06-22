package com.jackingaming.vesselforcheesemobileapp.models.components.drinks.size_options;

import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;

public class DrinkSize extends SizeOptions {
    public static final String DEFAULT_TEXT_INIT = "Drink Size";

    public enum Type {
        SHORT(8),
        TALL(12),
        GRANDE(16),
        VENTI_HOT(20),
        VENTI_ICED(24),
        TRENTA(30),
        UNIQUE(-1),
        UNDEFINED(-1);

        private final int sizeInFlOz;

        Type(int sizeInFlOz) {
            this.sizeInFlOz = sizeInFlOz;
        }

        public int getSizeInFlOz() {
            return sizeInFlOz;
        }
    }

    private Type type;

    public DrinkSize(Type type) {
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
        return DrinkSize.class.getSimpleName();
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
