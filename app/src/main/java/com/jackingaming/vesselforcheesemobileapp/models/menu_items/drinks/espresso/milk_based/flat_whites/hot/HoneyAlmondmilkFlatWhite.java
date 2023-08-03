package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.flat_whites.hot;

public class HoneyAlmondmilkFlatWhite extends FlatWhites {
    public static final String TAG = HoneyAlmondmilkFlatWhite.class.getSimpleName();

    public static final String DEFAULT_NAME = "Honey Almondmilk Flat White";
    public static final String DEFAULT_DESCRIPTION = "This flat white intentionally pairs almondmilk and Starbucks Blonde Espresso Roast with a hint of honey, making a perfect amount of creamy, nutty sweetness.";
    public static final int DEFAULT_CALORIES = 120;
    public static final int DEFAULT_SUGAR_IN_GRAM = 18;
    public static final float DEFAULT_FAT_IN_GRAM = 4.0f;

    public static final double DEFAULT_PRICE_SMALL = 0.75;
    public static final double DEFAULT_PRICE_MEDIUM = 1.40;
    public static final double DEFAULT_PRICE_LARGE = 1.95;
    public static final boolean DEFAULT_ICED = false;

    public HoneyAlmondmilkFlatWhite() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM, DEFAULT_ICED);

        drinkSizesAllowed = DEFAULT_DRINK_SIZES_ALLOWED;
    }
}
