package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.mochas.cold;

public class IcedWhiteChocolateMocha extends IcedMochas {
    public static final String TAG = IcedWhiteChocolateMocha.class.getSimpleName();

    public static final String DEFAULT_NAME = "Iced White Chocolate Mocha";
    public static final String DEFAULT_DESCRIPTION = "Our signature espresso meets white chocolate sauce, milk and ice, and then is finished off with sweetened whipped cream to create this supreme white chocolate delight.";
    public static final int DEFAULT_CALORIES = 420;
    public static final int DEFAULT_SUGAR_IN_GRAM = 48;
    public static final float DEFAULT_FAT_IN_GRAM = 20.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;
    public static final boolean DEFAULT_ICED = false;

    public IcedWhiteChocolateMocha() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM, DEFAULT_ICED);
    }
}
