package com.jackingaming.vesselforcheesemobileapp.models.components;

public interface Incrementable {
    int QUANTITY_FOR_INVOKER = -1;

    void onIncrement();

    void onDecrement();

    int getQuantity();

    void setQuantity(int quantity);
}
