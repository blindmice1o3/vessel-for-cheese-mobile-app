package com.jackingaming.vesselforcheesemobileapp.models.menu.foods;

import com.jackingaming.vesselforcheesemobileapp.models.menu.MenuItem;

public abstract class Food extends MenuItem {
    public static final String TAG = Food.class.getSimpleName();

    public Food() {
        super();
    }

    public Food(String name, String description, double price) {
        super(name, description, price);
    }
}
