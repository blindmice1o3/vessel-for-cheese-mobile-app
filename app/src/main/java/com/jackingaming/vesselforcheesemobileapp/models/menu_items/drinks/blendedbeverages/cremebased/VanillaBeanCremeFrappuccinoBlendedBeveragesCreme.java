package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.blendedbeverages.cremebased;

public class VanillaBeanCremeFrappuccinoBlendedBeveragesCreme extends CremeBased {
    public static final String TAG = VanillaBeanCremeFrappuccinoBlendedBeveragesCreme.class.getSimpleName();

    public static final String DEFAULT_NAME = "Vanilla Bean Creme Frappuccino Blended Creme";
    public static final String DEFAULT_DESCRIPTION = "This rich and creamy blend of vanilla bean, milk and ice topped with whipped cream takes va-va-vanilla flavor to another level. To change things up, try it affogato-style with a hot espresso shot poured right over the top.";
    public static final int DEFAULT_CALORIES = 380;
    public static final int DEFAULT_SUGAR_IN_GRAM = 52;
    public static final float DEFAULT_FAT_IN_GRAM = 16.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public VanillaBeanCremeFrappuccinoBlendedBeveragesCreme() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
