package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.blended;

import android.util.Log;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.Drink;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes.Lattes;

public abstract class Blended extends Drink {
    public static final String TAG = Blended.class.getSimpleName();
    public static final DrinkSize DEFAULT_DRINK_SIZE = DrinkSize.GRANDE;

    public Blended() {
    }

    public Blended(String name, String description, int calories, int sugarInGram, float fatInGram,
                   double price, boolean iced) {
        super(name, description, calories, sugarInGram, fatInGram, price, DEFAULT_DRINK_SIZE, iced);
    }

    @Override
    public int getNumberOfShotByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfShotByDrinkSize(DrinkSize)");

        return NUMBER_OF_SHOT_INDEPENDENT_OF_DRINK_SIZE;
    }

    @Override
    public int getNumberOfPumpByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfPumpByDrinkSize(DrinkSize)");

        return NUMBER_OF_PUMP_INDEPENDENT_OF_DRINK_SIZE;
    }
}
