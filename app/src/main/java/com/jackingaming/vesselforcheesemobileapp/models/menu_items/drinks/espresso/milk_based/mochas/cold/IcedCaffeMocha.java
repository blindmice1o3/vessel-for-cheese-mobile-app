package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.mochas.cold;

public class IcedCaffeMocha extends IcedMochas {
    public static final String TAG = IcedCaffeMocha.class.getSimpleName();

    public static final String DEFAULT_NAME = "Iced Caffe Mocha";
    public static final String DEFAULT_DESCRIPTION = "Our rich, full-bodied espresso combined with bittersweet mocha sauce, milk and ice, then topped with sweetened whipped cream. The classic iced coffee drink that always sweetly satisfies.";
    public static final int DEFAULT_CALORIES = 350;
    public static final int DEFAULT_SUGAR_IN_GRAM = 30;
    public static final float DEFAULT_FAT_IN_GRAM = 17.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public IcedCaffeMocha() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
