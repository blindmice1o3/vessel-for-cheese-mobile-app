package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed;

public class EcuadorLoja extends BrewedCoffees {
    public static final String TAG = EcuadorLoja.class.getSimpleName();

    public static final String NAME_DEFAULT = "Clover Starbucks Reserve Ecuador Loja";
    public static final String DESCRIPTION_DEFAULT = "Notes of Dried Apricot & Caramel The terroir of Ecuador's Loja province is ideal for growing coffee, but it's only part of the equation. These beans were carefully cultivated by smallholder farmers whose efforts pay off beautifully in this complex cup. We're excited to share a rare and delicious find from a tiny origin with enormous potential.";
    public static final double PRICE_SMALL_DEFAULT = 1.95;
    public static final double PRICE_MEDIUM_DEFAULT = 2.45;
    public static final double PRICE_LARGE_DEFAULT = 2.70;
    public static final boolean ICED_DEFAULT = false;

    public EcuadorLoja() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_MEDIUM_DEFAULT, ICED_DEFAULT);
    }
}
