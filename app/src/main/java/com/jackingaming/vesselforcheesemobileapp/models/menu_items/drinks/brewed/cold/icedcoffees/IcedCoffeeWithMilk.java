package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.cold.icedcoffees;

public class IcedCoffeeWithMilk extends IcedCoffees {
    public static final String TAG = IcedCoffeeWithMilk.class.getSimpleName();

    public static final String DEFAULT_NAME = "Iced Coffee with Milk";
    public static final String DEFAULT_DESCRIPTION = "Freshly brewed Starbucks Iced Coffee Blend with milk served chilled and sweetened over ice. An absolutely, seriously, refreshingly lift to any day.";
    public static final int DEFAULT_CALORIES = 110;
    public static final int DEFAULT_SUGAR_IN_GRAM = 23;
    public static final float DEFAULT_FAT_IN_GRAM = 1.5f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;
    public static final boolean DEFAULT_ICED = false;

    public IcedCoffeeWithMilk() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM, DEFAULT_ICED);
    }
}
