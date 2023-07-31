package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.macchiatos;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;

public class CaramelMacchiato extends Macchiatos {
    public static final String TAG = CaramelMacchiato.class.getSimpleName();

    public static final String DEFAULT_NAME = "Caramel Macchiato";
    public static final String DEFAULT_DESCRIPTION = "Freshly steamed milk with vanilla-flavored syrup marked with espresso and topped with a caramel drizzle for an oh-so-sweet finish.";
    public static final int DEFAULT_CALORIES = 250;
    public static final int DEFAULT_SUGAR_IN_GRAM = 33;
    public static final float DEFAULT_FAT_IN_GRAM = 7.0f;

    public static final DrinkSize[] DEFAULT_DRINK_SIZES_ALLOWED = {DrinkSize.SHORT, DrinkSize.TALL, DrinkSize.GRANDE, DrinkSize.VENTI_HOT};

    public static final double DEFAULT_PRICE_SMALL = 1.95;
    public static final double DEFAULT_PRICE_MEDIUM = 2.45;
    public static final double DEFAULT_PRICE_LARGE = 2.70;
    public static final boolean DEFAULT_ICED = false;

    public CaramelMacchiato() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM, DEFAULT_ICED);

        drinkSizesAllowed = DEFAULT_DRINK_SIZES_ALLOWED;
    }
}
