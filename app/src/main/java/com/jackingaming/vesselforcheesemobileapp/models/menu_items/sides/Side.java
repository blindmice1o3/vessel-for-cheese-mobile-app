package com.jackingaming.vesselforcheesemobileapp.models.menu_items.sides;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.MenuItem;

public abstract class Side extends MenuItem {
    public static final String TAG = "Side";

    public Side() {
        super();
    }

    public Side(int imageResourceId, String name, String description,
                int calories, int sugarInGram, float fatInGram,
                double price) {
        super(imageResourceId, name, description,
                calories, sugarInGram, fatInGram,
                price);
    }
}
