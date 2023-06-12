package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem;

public interface Incrementable {
    void onIncrement();

    void onDecrement();

    int getQuantity();
}
