package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes;

public class StarbucksReserveLatte extends Lattes {
    public static final String TAG = StarbucksReserveLatte.class.getSimpleName();

    public static final String NAME_DEFAULT = "Starbucks Reserve Latte";
    public static final String DESCRIPTION_DEFAULT = "Small-lot Starbucks Reserve espresso balanced with steamed milk and a light layer of foam forms a perfectly handcrafted latte.";
    public static final double PRICE_SMALL_DEFAULT = 2.95;
    public static final double PRICE_MEDIUM_DEFAULT = 3.45;
    public static final double PRICE_LARGE_DEFAULT = 3.70;
    public static final boolean ICED_DEFAULT = false;

    public StarbucksReserveLatte() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_MEDIUM_DEFAULT, ICED_DEFAULT);
    }
}
