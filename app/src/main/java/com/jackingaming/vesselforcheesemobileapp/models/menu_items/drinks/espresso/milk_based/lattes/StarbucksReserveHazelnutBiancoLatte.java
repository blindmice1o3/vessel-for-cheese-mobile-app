package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes;

public class StarbucksReserveHazelnutBiancoLatte extends Lattes {
    public static final String TAG = StarbucksReserveHazelnutBiancoLatte.class.getSimpleName();

    public static final String NAME_DEFAULT = "Starbucks Reserve Hazelnut Bianco Latte";
    public static final String DESCRIPTION_DEFAULT = "House-made hazelnut-praline-infused milk combined with our small-lot Starbucks Reserve espresso-a true character of sweetly nut love.";
    public static final double PRICE_SMALL_DEFAULT = 2.95;
    public static final double PRICE_MEDIUM_DEFAULT = 3.45;
    public static final double PRICE_LARGE_DEFAULT = 3.70;
    public static final boolean ICED_DEFAULT = false;

    public StarbucksReserveHazelnutBiancoLatte() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_MEDIUM_DEFAULT, ICED_DEFAULT);
    }
}
