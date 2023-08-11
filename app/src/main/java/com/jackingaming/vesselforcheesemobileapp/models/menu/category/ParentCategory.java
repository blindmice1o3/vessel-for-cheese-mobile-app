package com.jackingaming.vesselforcheesemobileapp.models.menu.category;

import java.util.List;

public class ParentCategory extends Category {
    public static final String TAG = ParentCategory.class.getSimpleName();

    List<SubCategory> subCategories;

    public ParentCategory(String name, int idImage,
                          List<SubCategory> subCategories) {
        super(name, idImage);
        this.subCategories = subCategories;
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }
}
