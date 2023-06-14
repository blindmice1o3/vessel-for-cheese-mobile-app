package com.jackingaming.vesselforcheesemobileapp.models.menu_items.sides;

public class SteamedVegetable extends Side {
    public static final String TAG = "SteamedVegetable";

    public static final String DEFAULT_NAME = "Steamed_vegetable";
    public static final String DEFAULT_DESCRIPTION = "mixed bag of primary producers";
    public static final int DEFAULT_CALORIES = 42;
    public static final int DEFAULT_SUGAR_IN_GRAM = 24;
    public static final float DEFAULT_FAT_IN_GRAM = 42.0f;

    public static final double DEFAULT_PRICE = 0.05;

    public SteamedVegetable() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE);
    }
}
