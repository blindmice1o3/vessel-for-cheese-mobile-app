package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.iced_shaken_espressos;

public class OleatoIcedShakenEspressoWithOatmilkAndToffeenut extends IcedShakenEspressos {
    public static final String TAG = OleatoIcedShakenEspressoWithOatmilkAndToffeenut.class.getSimpleName();

    public static final String DEFAULT_NAME = "Oleato Iced Shaken Espresso with Oatmilk and Toffeenut";
    public static final String DEFAULT_DESCRIPTION = "Layers of flavor - coffee forward and lightly sweetened with notes of toasted nuts, rich espresso, and creamy oatmilk infused with Partanna extra virgin olive oil.";
    public static final int DEFAULT_CALORIES = 250;
    public static final int DEFAULT_SUGAR_IN_GRAM = 12;
    public static final float DEFAULT_FAT_IN_GRAM = 17.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;
    public static final boolean DEFAULT_ICED = false;

    public OleatoIcedShakenEspressoWithOatmilkAndToffeenut() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM, DEFAULT_ICED);
    }
}
