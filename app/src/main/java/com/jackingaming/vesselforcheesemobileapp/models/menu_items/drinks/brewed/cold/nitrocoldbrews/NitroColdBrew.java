package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.cold.nitrocoldbrews;

public class NitroColdBrew extends NitroColdBrews {
    public static final String TAG = NitroColdBrew.class.getSimpleName();

    public static final String DEFAULT_NAME = "Nitro Cold Brew";
    public static final String DEFAULT_DESCRIPTION = "Our small-batch cold brew-slow-steeped for a super-smooth taste-gets even better. We're infusing it with nitrogen to create a sweet flavor without sugar and cascading, velvety crema. Perfection is served.";
    public static final int DEFAULT_CALORIES = 5;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;
    public static final boolean DEFAULT_ICED = false;

    public NitroColdBrew() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM, DEFAULT_ICED);
    }
}
