package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes.hot;

public class OleatoCaffeLatteWithOatmilk extends Lattes {
    public static final String TAG = OleatoCaffeLatteWithOatmilk.class.getSimpleName();

    public static final String DEFAULT_NAME = "Oleato Caffe Latte with Oatmilk";
    public static final String DEFAULT_DESCRIPTION = "Starbucks Blonde Espresso infused with Partanna extra virgin olive oil, steamed with oatmilk. Velvety smooth. Deliciously lush.";
    public static final int DEFAULT_CALORIES = 330;
    public static final int DEFAULT_SUGAR_IN_GRAM = 6;
    public static final float DEFAULT_FAT_IN_GRAM = 23.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;
    public static final boolean DEFAULT_ICED = false;

    public OleatoCaffeLatteWithOatmilk() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM, DEFAULT_ICED);
    }
}
