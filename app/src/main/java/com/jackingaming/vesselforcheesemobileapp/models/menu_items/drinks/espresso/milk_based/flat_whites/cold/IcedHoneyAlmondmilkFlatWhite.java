package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.flat_whites.cold;

public class IcedHoneyAlmondmilkFlatWhite extends IcedFlatWhites {
    public static final String TAG = IcedHoneyAlmondmilkFlatWhite.class.getSimpleName();

    public static final String DEFAULT_NAME = "Iced Honey Almondmilk Flat White";
    public static final String DEFAULT_DESCRIPTION = "This iced flat white - intentionally made with almondmilk and Starbucks Blonde Espresso Roast poured over ice with a hint of honey - creates a perfect amount of cool, creamy, nutty sweetness.";
    public static final int DEFAULT_CALORIES = 100;
    public static final int DEFAULT_SUGAR_IN_GRAM = 17;
    public static final float DEFAULT_FAT_IN_GRAM = 2.5f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;
    public static final boolean DEFAULT_ICED = false;

    public IcedHoneyAlmondmilkFlatWhite() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM, DEFAULT_ICED);
    }
}
