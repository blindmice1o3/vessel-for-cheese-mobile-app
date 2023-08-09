package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.cold.icedblackteas;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.cold.IcedTeas;

public class IcedLondonFogTeaLatte extends IcedTeas {
    public static final String TAG = IcedLondonFogTeaLatte.class.getSimpleName();

    public static final String DEFAULT_NAME = "Iced London Fog Tea Latte";
    public static final String DEFAULT_DESCRIPTION = "Bright, citrusy spark of bergamot blends with subtle hints of lavender and mixes with vanilla syrup, milk and ice to create this delicious reinvention of a classic Earl Grey tea.";
    public static final int DEFAULT_CALORIES = 140;
    public static final int DEFAULT_SUGAR_IN_GRAM = 25;
    public static final float DEFAULT_FAT_IN_GRAM = 2.5f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public IcedLondonFogTeaLatte() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
