package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed;

public class RwandaSholi extends BrewedCoffees {
    public static final String TAG = RwandaSholi.class.getSimpleName();

    public static final String NAME_DEFAULT = "Clover Starbucks Reserve Rwanda Sholi";
    public static final String DESCRIPTION_DEFAULT = "Notes of Raspberry & Toffee The founding principle of Abateraninkunga ba Sholi, a woman-founded coffee cooperative in the Muhanga District of central Rwanda, is one of community support through coffee. The name translates to \"mutual assistance,\" and the members of Sholi bring exceptional coffee and renewed strength to the local economy. There's deep satisfaction in enjoying this coffee-and helping the spirit of Sholi live on.";
    public static final double PRICE_SMALL_DEFAULT = 1.95;
    public static final double PRICE_MEDIUM_DEFAULT = 2.45;
    public static final double PRICE_LARGE_DEFAULT = 2.70;
    public static final boolean ICED_DEFAULT = false;

    public RwandaSholi() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_MEDIUM_DEFAULT, ICED_DEFAULT);
    }
}
