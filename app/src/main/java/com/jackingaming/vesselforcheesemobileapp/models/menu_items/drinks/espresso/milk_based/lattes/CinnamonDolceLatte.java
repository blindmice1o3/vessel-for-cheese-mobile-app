package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes;

public class CinnamonDolceLatte extends Lattes {
    public static final String TAG = CinnamonDolceLatte.class.getSimpleName();

    public static final String NAME_DEFAULT = "Cinnamon Dolce Latte";
    public static final String DESCRIPTION_DEFAULT = "We add freshly steamed milk and cinnamon dolce-flavored syrup to our classic espresso, topped with sweetened whipped cream and a cinnamon dolce topping to bring you specialness in a treat.";
    public static final double PRICE_SMALL_DEFAULT = 2.95;
    public static final double PRICE_MEDIUM_DEFAULT = 3.45;
    public static final double PRICE_LARGE_DEFAULT = 3.70;
    public static final boolean ICED_DEFAULT = false;

    public CinnamonDolceLatte() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_MEDIUM_DEFAULT, ICED_DEFAULT);
    }
}
