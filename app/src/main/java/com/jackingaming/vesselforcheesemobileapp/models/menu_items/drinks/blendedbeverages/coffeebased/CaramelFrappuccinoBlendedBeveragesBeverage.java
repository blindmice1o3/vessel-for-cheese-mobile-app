package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.blendedbeverages.coffeebased;

public class CaramelFrappuccinoBlendedBeveragesBeverage extends CoffeeBased {
    public static final String TAG = CaramelFrappuccinoBlendedBeveragesBeverage.class.getSimpleName();

    public static final String DEFAULT_NAME = "Caramel Frappuccino Blended Beverage";
    public static final String DEFAULT_DESCRIPTION = "Caramel syrup meets coffee, milk and ice for a rendezvous in the blender, while whipped cream and buttery caramel sauce layer the love on top. To change things up, try it affogato-style with a hot espresso shot poured right over the top.";
    public static final int DEFAULT_CALORIES = 380;
    public static final int DEFAULT_SUGAR_IN_GRAM = 54;
    public static final float DEFAULT_FAT_IN_GRAM = 16.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public CaramelFrappuccinoBlendedBeveragesBeverage() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
