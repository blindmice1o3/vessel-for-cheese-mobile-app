package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed;

public class GreenApronBlend extends BrewedCoffees {
    public static final String TAG = GreenApronBlend.class.getSimpleName();

    public static final String DEFAULT_NAME = "Green Apron Blend";
    public static final String DEFAULT_DESCRIPTION = "Notes of Honeybell Orange & Graham Cracker This blend is for the Starbucks \"partners\" who wear the iconic green apron. Made up of exceptional coffees from Latin America and Africa, this coffee is soulful and essential, bright and inspiring-just like the store baristas whose pride and passion it celebrates. Starbucks will designate funds from the sale of this coffee to our Caring Unites Partners (CUP) Fund, a Starbucks program providing grants to eligible Starbucks employees in times of need.";
    public static final int DEFAULT_CALORIES = 5;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final double DEFAULT_PRICE_SMALL = 1.95;
    public static final double DEFAULT_PRICE_MEDIUM = 2.45;
    public static final double DEFAULT_PRICE_LARGE = 2.70;
    public static final boolean DEFAULT_ICED = false;

    public GreenApronBlend() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM, DEFAULT_ICED);
    }
}
