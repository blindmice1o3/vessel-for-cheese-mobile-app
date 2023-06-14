package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.mochas;

public class WhiteChocolateMocha extends Mochas {
    public static final String TAG = WhiteChocolateMocha.class.getSimpleName();

    public static final String DEFAULT_NAME = "White Chocolate Mocha";
    public static final String DEFAULT_DESCRIPTION = "Our signature espresso meets white chocolate sauce and steamed milk, and then is finished off with sweetened whipped cream to create this supreme white chocolate delight.";
    public static final int DEFAULT_CALORIES = 430;
    public static final int DEFAULT_SUGAR_IN_GRAM = 53;
    public static final float DEFAULT_FAT_IN_GRAM = 18.0f;

    public static final double DEFAULT_PRICE_SMALL = 1.95;
    public static final double DEFAULT_PRICE_MEDIUM = 2.45;
    public static final double DEFAULT_PRICE_LARGE = 2.70;
    public static final boolean DEFAULT_ICED = false;

    public WhiteChocolateMocha() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM, DEFAULT_ICED);
    }
}
