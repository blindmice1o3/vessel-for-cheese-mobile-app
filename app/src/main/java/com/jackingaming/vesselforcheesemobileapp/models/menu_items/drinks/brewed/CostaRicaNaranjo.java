package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed;

public class CostaRicaNaranjo extends BrewedCoffees {
    public static final String TAG = CostaRicaNaranjo.class.getSimpleName();

    public static final String NAME_DEFAULT = "Clover Starbucks Reserve Costa Rica Naranjo";
    public static final String DESCRIPTION_DEFAULT = "Apricot & Almond The brilliant hues of the Costa Rican oxcart celebrate coffee's vitality in the Naranjo region, where smallholder farmers in the Naranjo Cooperative worked together to produce this elevated lot rooted in community pride.";
    public static final double PRICE_SMALL_DEFAULT = 1.95;
    public static final double PRICE_MEDIUM_DEFAULT = 2.45;
    public static final double PRICE_LARGE_DEFAULT = 2.70;
    public static final boolean ICED_DEFAULT = false;

    public CostaRicaNaranjo() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_MEDIUM_DEFAULT, ICED_DEFAULT);
    }
}
