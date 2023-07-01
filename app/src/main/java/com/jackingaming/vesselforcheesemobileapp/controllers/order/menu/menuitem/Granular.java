package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem;

public interface Granular {
    enum Amount { NO, LIGHT, MEDIUM, EXTRA; }

    Amount getAmount();

    void setAmount(Amount amount);
}
