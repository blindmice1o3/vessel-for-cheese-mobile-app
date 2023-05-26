package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.mochas;

public class StarbucksReserveDarkChocolateMocha extends Mochas {
    public static final String TAG = StarbucksReserveDarkChocolateMocha.class.getSimpleName();

    public static final String NAME_DEFAULT = "Starbucks Reserve Dark Chocolate Mocha";
    public static final String DESCRIPTION_DEFAULT = "Our small-lot Starbucks Reserve espresso combined with cocoa, ground chocolate and topped with steamed milk delivers a brilliant combination of sweetness.";
    public static final double PRICE_SMALL_DEFAULT = 1.95;
    public static final double PRICE_MEDIUM_DEFAULT = 2.45;
    public static final double PRICE_LARGE_DEFAULT = 2.70;
    public static final boolean ICED_DEFAULT = false;

    public StarbucksReserveDarkChocolateMocha() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_MEDIUM_DEFAULT, ICED_DEFAULT);
    }
}
