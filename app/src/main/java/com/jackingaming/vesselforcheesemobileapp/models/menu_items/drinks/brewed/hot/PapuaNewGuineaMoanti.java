package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.hot;

public class PapuaNewGuineaMoanti extends HotBrewedCoffees {
    public static final String TAG = PapuaNewGuineaMoanti.class.getSimpleName();

    public static final String DEFAULT_NAME = "Clover Starbucks Reserve Papua New Guinea Moanti";
    public static final String DEFAULT_DESCRIPTION = "Notes of Milk Chocolate & Hazelnut Moanti Ise is a one-woman force for change. In the Eastern Highlands of Papua New Guinea, she single-handedly brought hundreds of smallholder farmers together, creating a high-quality supply chain that is improving lives. We are in awe of her accomplishments and honored to share this exceptional cup.";
    public static final int DEFAULT_CALORIES = 10;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 1.95;
    public static final double DEFAULT_PRICE_MEDIUM = 2.45;
    public static final double DEFAULT_PRICE_LARGE = 2.70;
    public static final boolean DEFAULT_ICED = false;

    public PapuaNewGuineaMoanti() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM, DEFAULT_ICED);
    }
}
