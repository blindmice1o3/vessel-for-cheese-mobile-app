package com.jackingaming.vesselforcheesemobileapp.models.menu.category;

public class TitleCategory extends Category {
    public static final String TAG = TitleCategory.class.getSimpleName();
    public static final int NULL_ID_IMAGE = -1;

    private int numberOfParentCategory;

    public TitleCategory(String name, int numberOfParentCategory) {
        super(name, NULL_ID_IMAGE);
        this.numberOfParentCategory = numberOfParentCategory;
    }

    public int getNumberOfParentCategory() {
        return numberOfParentCategory;
    }

    public void setNumberOfParentCategory(int numberOfParentCategory) {
        this.numberOfParentCategory = numberOfParentCategory;
    }
}
