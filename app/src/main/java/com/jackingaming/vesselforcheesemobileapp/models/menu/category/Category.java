package com.jackingaming.vesselforcheesemobileapp.models.menu.category;

import java.io.Serializable;

public abstract class Category
        implements Serializable {
    private String name;
    private int idImage;

    public Category(String name, int idImage) {
        this.name = name;
        this.idImage = idImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }
}
