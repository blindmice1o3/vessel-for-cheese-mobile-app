package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed;

public class EcuadorLoja extends BrewedCoffees {
    public static final String TAG = EcuadorLoja.class.getSimpleName();

    public static final String DEFAULT_NAME = "Clover Starbucks Reserve Ecuador Loja";
    public static final String DEFAULT_DESCRIPTION = "Notes of Dried Apricot & Caramel The terroir of Ecuador's Loja province is ideal for growing coffee, but it's only part of the equation. These beans were carefully cultivated by smallholder farmers whose efforts pay off beautifully in this complex cup. We're excited to share a rare and delicious find from a tiny origin with enormous potential.";
    public static final int DEFAULT_CALORIES = 10;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 1.95;
    public static final double DEFAULT_PRICE_MEDIUM = 2.45;
    public static final double DEFAULT_PRICE_LARGE = 2.70;
    public static final boolean DEFAULT_ICED = false;

    public EcuadorLoja() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM, DEFAULT_ICED);
    }
}
