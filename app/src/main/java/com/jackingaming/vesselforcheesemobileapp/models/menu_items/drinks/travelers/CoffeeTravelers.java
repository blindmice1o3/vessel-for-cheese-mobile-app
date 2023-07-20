package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.travelers;

import android.util.Log;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.Drink;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;

public abstract class CoffeeTravelers extends Drink {
    public static final String TAG = CoffeeTravelers.class.getSimpleName();
    public static final DrinkSize DEFAULT_DRINK_SIZE = DrinkSize.UNIQUE;

    public CoffeeTravelers() {
    }

    public CoffeeTravelers(String name, String description, int calories, int sugarInGram, float fatInGram,
                           double price, boolean iced) {
        super(name, description, calories, sugarInGram, fatInGram, price, DEFAULT_DRINK_SIZE, iced);
    }

    @Override
    public int getNumberOfShotByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfShotByDrinkSize(DrinkSize)");

        return QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
    }

    @Override
    public int getNumberOfPumpByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfPumpByDrinkSize(DrinkSize)");

        return QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
    }

    @Override
    public int getNumberOfScoopByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfScoopByDrinkSize(DrinkSize)");

        return QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
    }

    @Override
    public int getNumberOfFrapRoastByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfFrapRoastByDrinkSize(DrinkSize)");

        return QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
    }

    @Override
    public int getNumberOfTeaBagByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfTeaBagByDrinkSize(DrinkSize)");

        return QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
    }
}
