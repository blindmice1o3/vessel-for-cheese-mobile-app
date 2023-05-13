package com.jackingaming.vesselforcheesemobileapp.models.menu.sides;

import com.jackingaming.vesselforcheesemobileapp.models.menu.MenuItem;

public abstract class Side extends MenuItem {
    public static final String TAG = "Side";

    public Side() {
        super();
    }

    public Side(String name, String description, double price) {
        super(name, description, price);
    }
}
