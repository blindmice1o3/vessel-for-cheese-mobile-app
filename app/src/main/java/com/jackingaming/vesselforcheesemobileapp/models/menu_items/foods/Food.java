package com.jackingaming.vesselforcheesemobileapp.models.menu_items.foods;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.MenuItem;

public abstract class Food extends MenuItem {
    public static final String TAG = Food.class.getSimpleName();

    public Food() {
        super();
    }

    public Food(int imageResourceId, String name, String description,
                int calories, int sugarInGram, float fatInGram,
                double price) {
        super(imageResourceId, name, description,
                calories, sugarInGram, fatInGram,
                price);
    }
}
