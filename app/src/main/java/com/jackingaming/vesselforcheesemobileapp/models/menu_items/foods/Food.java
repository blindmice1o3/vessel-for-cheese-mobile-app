package com.jackingaming.vesselforcheesemobileapp.models.menu_items.foods;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.MenuItem;

public abstract class Food extends MenuItem {
    public static final String TAG = Food.class.getSimpleName();

    public Food() {
        super();
    }

    public Food(String name, String description, double price) {
        super(name, description, price);
    }
}
