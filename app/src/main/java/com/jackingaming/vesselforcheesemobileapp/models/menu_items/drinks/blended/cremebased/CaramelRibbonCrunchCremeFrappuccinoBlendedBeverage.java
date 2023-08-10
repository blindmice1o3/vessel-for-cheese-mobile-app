package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.blended.cremebased;

public class CaramelRibbonCrunchCremeFrappuccinoBlendedBeverage extends CremeBased {
    public static final String TAG = CaramelRibbonCrunchCremeFrappuccinoBlendedBeverage.class.getSimpleName();

    public static final String DEFAULT_NAME = "Caramel Ribbon Crunch Creme Frappuccino Blended Beverage";
    public static final String DEFAULT_DESCRIPTION = "Buttery caramel syrup is blended with milk and ice, then topped with a layer of dark caramel sauce, whipped cream, caramel drizzle and a crunchy caramel-sugar topping - oh-so-beautifully delicious.";
    public static final int DEFAULT_CALORIES = 420;
    public static final int DEFAULT_SUGAR_IN_GRAM = 46;
    public static final float DEFAULT_FAT_IN_GRAM = 22.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public CaramelRibbonCrunchCremeFrappuccinoBlendedBeverage() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
