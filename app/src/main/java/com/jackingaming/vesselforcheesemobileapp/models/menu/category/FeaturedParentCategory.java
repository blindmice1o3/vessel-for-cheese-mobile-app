package com.jackingaming.vesselforcheesemobileapp.models.menu.category;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.MenuItem;

import java.util.List;

public class FeaturedParentCategory extends ParentCategory {
    public static final String TAG = FeaturedParentCategory.class.getSimpleName();

    private List<MenuItem> menuItems;

    public FeaturedParentCategory(String name, int idImage, List<MenuItem> menuItems) {
        super(name, idImage, null);
        this.menuItems = menuItems;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
