package com.jackingaming.vesselforcheesemobileapp.models.menu_items.foods;

public class Bread extends Food {
    public static final String TAG = Bread.class.getSimpleName();

    public static final String DEFAULT_NAME = "Bread";
    public static final String DEFAULT_DESCRIPTION = "made from multiplying yeast";
    public static final int DEFAULT_CALORIES = 42;
    public static final int DEFAULT_SUGAR_IN_GRAM = 24;
    public static final float DEFAULT_FAT_IN_GRAM = 42.0f;

    public static final double DEFAULT_PRICE = 0.10;

    public Bread() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE);
    }
}
