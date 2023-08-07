package com.jackingaming.vesselforcheesemobileapp.models.menu.category;

public class TitleCategory extends Category {
    private int sizeCategory;

    public TitleCategory(String name, int sizeCategory) {
        super(name);
        this.sizeCategory = sizeCategory;
    }

    public int getSizeCategory() {
        return sizeCategory;
    }

    public void setSizeCategory(int sizeCategory) {
        this.sizeCategory = sizeCategory;
    }
}
