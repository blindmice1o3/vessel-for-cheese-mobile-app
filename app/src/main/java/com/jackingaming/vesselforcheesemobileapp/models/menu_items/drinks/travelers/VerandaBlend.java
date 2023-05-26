package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.travelers;

public class VerandaBlend extends CoffeeTravelers {
    public static final String TAG = VerandaBlend.class.getSimpleName();

    public static final String NAME_DEFAULT = "Coffee Traveler - Veranda Blend";
    public static final String DESCRIPTION_DEFAULT = "A convenient carrier filled with 96 fl oz of our brewed Starbucks Blonde Veranda Blend (equivalent to 12 8-fl-oz cups), perfect for meetings, picnic gatherings or any occasion that calls for coffee.";
    public static final double PRICE_SMALL_DEFAULT = 1.95;
    public static final double PRICE_MEDIUM_DEFAULT = 2.45;
    public static final double PRICE_LARGE_DEFAULT = 2.70;
    public static final boolean ICED_DEFAULT = false;

    public VerandaBlend() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_MEDIUM_DEFAULT, ICED_DEFAULT);
    }
}
