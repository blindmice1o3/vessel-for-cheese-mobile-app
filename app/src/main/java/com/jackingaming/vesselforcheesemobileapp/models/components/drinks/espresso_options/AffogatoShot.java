package com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options;

import android.util.Log;

import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.Incrementable;

public class AffogatoShot extends EspressoOptions
        implements Incrementable {
    private static final int DEFAULT_QUANTITY_MAX = 4;

    @Override
    public void onIncrement() {
        Log.i(TAG, "onIncrement()");
        Log.i(TAG, "quantity: " + quantity);

        quantity++;

        Log.i(TAG, "quantity: " + quantity);
        if (quantity > DEFAULT_QUANTITY_MAX) {
            Log.i(TAG, "quantity > DEFAULT_QUANTITY_MAX --- SETTING quantity = DEFAULT_QUANTITY_MAX");
            quantity = DEFAULT_QUANTITY_MAX;
        }
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
        AFFOGATO_SHOT;
    }

    private Type type;
    private int quantity;

    public AffogatoShot(int quantity) {
        this.quantity = quantity;
        type = Type.AFFOGATO_SHOT;
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
