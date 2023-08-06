package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.mochas.hot;

public class CaffeMocha extends Mochas {
    public static final String TAG = CaffeMocha.class.getSimpleName();

    public static final String DEFAULT_NAME = "Caffe Mocha";
    public static final String DEFAULT_DESCRIPTION = "Our rich, full-bodied espresso combined with bittersweet mocha sauce and steamed milk, then topped with sweetened whipped cream. The classic coffee drink that always sweetly satisfies.";
    public static final int DEFAULT_CALORIES = 370;
    public static final int DEFAULT_SUGAR_IN_GRAM = 35;
    public static final float DEFAULT_FAT_IN_GRAM = 15.0f;

    public static final double DEFAULT_PRICE_SMALL = 1.95;
    public static final double DEFAULT_PRICE_MEDIUM = 2.45;
    public static final double DEFAULT_PRICE_LARGE = 2.70;

    public CaffeMocha() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
