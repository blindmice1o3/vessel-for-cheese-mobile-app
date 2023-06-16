package com.jackingaming.vesselforcheesemobileapp.models.components.drinks.flavor_options;

import android.util.Log;

import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.Incrementable;

public class Sauce extends FlavorOptions
        implements Incrementable {
    @Override
    public void onIncrement() {
        Log.i(TAG, "onIncrement()");
        Log.i(TAG, "quantity: " + quantity);

        quantity++;

        Log.i(TAG, "quantity: " + quantity);
        Log.i(TAG, "end of onIncrement() --- quantity: " + quantity);
    }

    @Override
    public void onDecrement() {
        Log.i(TAG, "onDecrement()");
        Log.i(TAG, "quantity: " + quantity);

        quantity--;

        Log.i(TAG, "quantity: " + quantity);
        if (quantity < 0) {
            Log.i(TAG, "quantity < 0 --- SETTING quantity = 0");
            quantity = 0;
        }
        Log.i(TAG, "end of onDecrement() --- quantity: " + quantity);
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    public enum Type {
        DARK_CARAMEL,
        MOCHA,
        PISTACHIO,
        WHITE_CHOCOLATE_MOCHA;
    }

    private Type type;
    private int quantity;

    public Sauce(Type type, int quantity) {
        this.type = type;
        this.quantity = quantity;
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
