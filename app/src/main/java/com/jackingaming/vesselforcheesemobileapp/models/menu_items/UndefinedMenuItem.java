package com.jackingaming.vesselforcheesemobileapp.models.menu_items;

public class UndefinedMenuItem extends MenuItem {
    public static final String TAG = UndefinedMenuItem.class.getSimpleName();

    public static final String DEFAULT_NAME = "Undefined";
    public static final String DEFAULT_DESCRIPTION = "no description";
    public static final int DEFAULT_CALORIES = 0;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE = 0.00;

    public UndefinedMenuItem() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE);
    }
}
