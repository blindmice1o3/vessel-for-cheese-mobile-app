package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed;

public class PapuaNewGuineaMoanti extends BrewedCoffees {
    public static final String TAG = PapuaNewGuineaMoanti.class.getSimpleName();

    public static final String NAME_DEFAULT = "Clover Starbucks Reserve Papua New Guinea Moanti";
    public static final String DESCRIPTION_DEFAULT = "Notes of Milk Chocolate & Hazelnut Moanti Ise is a one-woman force for change. In the Eastern Highlands of Papua New Guinea, she single-handedly brought hundreds of smallholder farmers together, creating a high-quality supply chain that is improving lives. We are in awe of her accomplishments and honored to share this exceptional cup.";
    public static final double PRICE_SMALL_DEFAULT = 1.95;
    public static final double PRICE_MEDIUM_DEFAULT = 2.45;
    public static final double PRICE_LARGE_DEFAULT = 2.70;
    public static final boolean ICED_DEFAULT = false;

    public PapuaNewGuineaMoanti() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_MEDIUM_DEFAULT, ICED_DEFAULT);
    }
}
