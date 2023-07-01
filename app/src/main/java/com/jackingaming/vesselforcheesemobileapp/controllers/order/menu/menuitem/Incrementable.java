package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem;

public interface Incrementable {
    int QUANTITY_FOR_INVOKER = -1;

    void onIncrement();

    void onDecrement();

    int getQuantity();

    void setQuantity(int quantity);
}
