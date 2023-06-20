package com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options;

import android.util.Log;

import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.Incrementable;

public class Shot extends EspressoOptions
        implements Incrementable {
    private static final int DEFAULT_QUANTITY_MIN = 0;
    private static final int DEFAULT_QUANTITY_MAX = 12;

    private int quantityMin = DEFAULT_QUANTITY_MIN;
    private int quantityMax = DEFAULT_QUANTITY_MAX;

    @Override
    public void onIncrement() {
        Log.i(TAG, "start of onIncrement() --- quantity: " + quantity);

        quantity++;

        if (quantity > quantityMax) {
            Log.i(TAG, "quantity > quantityMax --- SETTING quantity = quantityMax");
            quantity = quantityMax;
        }
        Log.i(TAG, "end of onIncrement() --- quantity: " + quantity);
    }

    @Override
    public void onDecrement() {
        Log.i(TAG, "start of onDecrement() --- quantity: " + quantity);

        quantity--;

        if (quantity < quantityMin) {
            Log.i(TAG, "quantity < quantityMin --- SETTING quantity = quantityMin");
            quantity = quantityMin;
        }
        Log.i(TAG, "end of onDecrement() --- quantity: " + quantity);
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    public enum Type {
        SHOT;
    }

    private Type type;
    private int quantity;

    public Shot(Type type, int quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getQuantityMin() {
        return quantityMin;
    }

    public void setQuantityMin(int quantityMin) {
        this.quantityMin = quantityMin;
    }

    public int getQuantityMax() {
        return quantityMax;
    }

    public void setQuantityMax(int quantityMax) {
        this.quantityMax = quantityMax;
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
        return Shot.class.getSimpleName();
    }

    @Override
    public String getTypeAsString() {
        return (type == null) ? NULL_TYPE_AS_STRING : type.name();
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
