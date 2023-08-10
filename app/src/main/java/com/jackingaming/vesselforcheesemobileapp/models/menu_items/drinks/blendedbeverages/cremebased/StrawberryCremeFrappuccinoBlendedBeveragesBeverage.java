package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.blendedbeverages.cremebased;

public class StrawberryCremeFrappuccinoBlendedBeveragesBeverage extends CremeBased {
    public static final String TAG = StrawberryCremeFrappuccinoBlendedBeveragesBeverage.class.getSimpleName();

    public static final String DEFAULT_NAME = "Strawberry Creme Frappuccino Blended Beverage";
    public static final String DEFAULT_DESCRIPTION = "Summer's favorite berry is the star of this delicious Frappuccino Blended Beverage - a blend of ice, milk and strawberry puree layered on top of a splash of strawberry puree and finished with vanilla whipped cream.";
    public static final int DEFAULT_CALORIES = 370;
    public static final int DEFAULT_SUGAR_IN_GRAM = 51;
    public static final float DEFAULT_FAT_IN_GRAM = 16.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public StrawberryCremeFrappuccinoBlendedBeveragesBeverage() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
