package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes.cold;

public class IcedCaffeLatte extends IcedLattes {
    public static final String TAG = IcedCaffeLatte.class.getSimpleName();

    public static final String DEFAULT_NAME = "Iced Caffe Latte";
    public static final String DEFAULT_DESCRIPTION = "Our dark, rich espresso combined with milk and served over ice. A perfect milk-forward cooldown.";
    public static final int DEFAULT_CALORIES = 130;
    public static final int DEFAULT_SUGAR_IN_GRAM = 11;
    public static final float DEFAULT_FAT_IN_GRAM = 4.5f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;
    public static final boolean DEFAULT_ICED = false;

    public IcedCaffeLatte() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM, DEFAULT_ICED);
    }
}
