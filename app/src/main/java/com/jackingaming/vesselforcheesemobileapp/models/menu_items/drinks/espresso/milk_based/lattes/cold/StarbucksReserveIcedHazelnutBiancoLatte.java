package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes.cold;

public class StarbucksReserveIcedHazelnutBiancoLatte extends IcedLattes {
    public static final String TAG = StarbucksReserveIcedHazelnutBiancoLatte.class.getSimpleName();

    public static final String DEFAULT_NAME = "Starbucks Reserve Iced Hazelnut Bianco Latte";
    public static final String DEFAULT_DESCRIPTION = "House-made hazelnut-praline-infused milk combined with our small-lot Starbucks Reserve espresso and served over ice - a true character of sweetly chilled nut love.";
    public static final int DEFAULT_CALORIES = 280;
    public static final int DEFAULT_SUGAR_IN_GRAM = 26;
    public static final float DEFAULT_FAT_IN_GRAM = 13.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;
    public static final boolean DEFAULT_ICED = false;

    public StarbucksReserveIcedHazelnutBiancoLatte() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM, DEFAULT_ICED);
    }
}
