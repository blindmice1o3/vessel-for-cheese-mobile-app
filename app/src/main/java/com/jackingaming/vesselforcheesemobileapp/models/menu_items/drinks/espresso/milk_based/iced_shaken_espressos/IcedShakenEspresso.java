package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.iced_shaken_espressos;

public class IcedShakenEspresso extends IcedShakenEspressos {
    public static final String TAG = IcedShakenEspresso.class.getSimpleName();

    public static final String DEFAULT_NAME = "Iced Shaken Espresso";
    public static final String DEFAULT_DESCRIPTION = "Made with the rich, full-bodied espresso you love - then shaken, chilled and mellowed with sweetness and a touch of milk to create a delightfully and deliciously convenient on-the-go drink.";
    public static final int DEFAULT_CALORIES = 100;
    public static final int DEFAULT_SUGAR_IN_GRAM = 14;
    public static final float DEFAULT_FAT_IN_GRAM = 2.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public IcedShakenEspresso() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
