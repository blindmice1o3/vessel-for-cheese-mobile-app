package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed;

public class GreenApronBlend extends BrewedCoffees {
    public static final String TAG = GreenApronBlend.class.getSimpleName();

    public static final String NAME_DEFAULT = "Green Apron Blend";
    public static final String DESCRIPTION_DEFAULT = "Notes of Honeybell Orange & Graham Cracker This blend is for the Starbucks \"partners\" who wear the iconic green apron. Made up of exceptional coffees from Latin America and Africa, this coffee is soulful and essential, bright and inspiring-just like the store baristas whose pride and passion it celebrates. Starbucks will designate funds from the sale of this coffee to our Caring Unites Partners (CUP) Fund, a Starbucks program providing grants to eligible Starbucks employees in times of need.";
    public static final double PRICE_SMALL_DEFAULT = 1.95;
    public static final double PRICE_MEDIUM_DEFAULT = 2.45;
    public static final double PRICE_LARGE_DEFAULT = 2.70;
    public static final boolean ICED_DEFAULT = false;

    public GreenApronBlend() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_MEDIUM_DEFAULT, ICED_DEFAULT);
    }
}
