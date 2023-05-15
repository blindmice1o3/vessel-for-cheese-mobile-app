package com.jackingaming.vesselforcheesemobileapp.models.menu.categories;

public class MenuItemCategory extends Category {
    private int idImage;

    public MenuItemCategory(String name, int idImage) {
        super(name);
        this.idImage = idImage;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }
}
