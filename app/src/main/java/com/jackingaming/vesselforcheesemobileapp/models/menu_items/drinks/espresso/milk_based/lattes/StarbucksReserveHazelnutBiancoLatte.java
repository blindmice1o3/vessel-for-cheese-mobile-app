package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes;

public class StarbucksReserveHazelnutBiancoLatte extends Lattes {
    public static final String TAG = StarbucksReserveHazelnutBiancoLatte.class.getSimpleName();

    public static final String DEFAULT_NAME = "Starbucks Reserve Hazelnut Bianco Latte";
    public static final String DEFAULT_DESCRIPTION = "House-made hazelnut-praline-infused milk combined with our small-lot Starbucks Reserve espresso-a true character of sweetly nut love.";
    public static final int DEFAULT_CALORIES = 380;
    public static final int DEFAULT_SUGAR_IN_GRAM = 36;
    public static final float DEFAULT_FAT_IN_GRAM = 18.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;
    public static final boolean DEFAULT_ICED = false;

    public StarbucksReserveHazelnutBiancoLatte() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM, DEFAULT_ICED);

        drinkSizesAllowed = DEFAULT_DRINK_SIZES_ALLOWED;
    }
}
