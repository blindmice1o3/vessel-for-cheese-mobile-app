package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.hot;

public class RwandaSholi extends BrewedCoffees {
    public static final String TAG = RwandaSholi.class.getSimpleName();

    public static final String DEFAULT_NAME = "Clover Starbucks Reserve Rwanda Sholi";
    public static final String DEFAULT_DESCRIPTION = "Notes of Raspberry & Toffee The founding principle of Abateraninkunga ba Sholi, a woman-founded coffee cooperative in the Muhanga District of central Rwanda, is one of community support through coffee. The name translates to \"mutual assistance,\" and the members of Sholi bring exceptional coffee and renewed strength to the local economy. There's deep satisfaction in enjoying this coffee-and helping the spirit of Sholi live on.";
    public static final int DEFAULT_CALORIES = 10;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 1.95;
    public static final double DEFAULT_PRICE_MEDIUM = 2.45;
    public static final double DEFAULT_PRICE_LARGE = 2.70;
    public static final boolean DEFAULT_ICED = false;

    public RwandaSholi() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM, DEFAULT_ICED);

        drinkSizesAllowed = DEFAULT_DRINK_SIZES_ALLOWED;
    }
}
