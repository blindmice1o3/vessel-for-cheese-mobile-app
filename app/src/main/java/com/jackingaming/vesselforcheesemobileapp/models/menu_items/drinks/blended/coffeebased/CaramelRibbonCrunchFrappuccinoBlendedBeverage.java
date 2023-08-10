package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.blended.coffeebased;

public class CaramelRibbonCrunchFrappuccinoBlendedBeverage extends CoffeeBased {
    public static final String TAG = CaramelRibbonCrunchFrappuccinoBlendedBeverage.class.getSimpleName();

    public static final String DEFAULT_NAME = "Caramel Ribbon Crunch Frappuccino Blended Beverage";
    public static final String DEFAULT_DESCRIPTION = "Buttery caramel syrup blended with coffee, milk and ice, then topped with a layer of dark caramel sauce, whipped cream, caramel drizzle and a crunchy caramel-sugar topping - oh-so-beautifully delicious.";
    public static final int DEFAULT_CALORIES = 470;
    public static final int DEFAULT_SUGAR_IN_GRAM = 60;
    public static final float DEFAULT_FAT_IN_GRAM = 22.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public CaramelRibbonCrunchFrappuccinoBlendedBeverage() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
