package com.jackingaming.vesselforcheesemobileapp.models.menu.category;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.MenuItem;

import java.util.List;

public class SubCategory extends Category {
    public static final String TAG = SubCategory.class.getSimpleName();

    private List<MenuItem> menuItems;

    public SubCategory(String name, int idImage, List<MenuItem> menuItems) {
        super(name, idImage);
        this.menuItems = menuItems;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
