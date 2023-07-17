package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.tea;

import android.util.Log;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.Drink;

public abstract class Tea extends Drink {
    public static final String TAG = Tea.class.getSimpleName();
    public static final DrinkSize DEFAULT_DRINK_SIZE = DrinkSize.GRANDE;

    public Tea() {
    }

    public Tea(String name, String description, int calories, int sugarInGram, float fatInGram,
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

    @Override
    public int getNumberOfScoopByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfScoopByDrinkSize(DrinkSize)");

        int numberOfScoopNew = NUMBER_OF_SCOOP_INDEPENDENT_OF_DRINK_SIZE;
        switch (drinkSizeNew) {
            case SHORT:
                numberOfScoopNew = 1;
                break;
            case TALL:
                numberOfScoopNew = 2;
                break;
            case GRANDE:
                numberOfScoopNew = 3;
                break;
            case VENTI_HOT:
            case VENTI_ICED:
                numberOfScoopNew = 4;
                break;
            case TRENTA:
            case UNIQUE:
            case UNDEFINED:
                break;
        }

        return numberOfScoopNew;
    }
}
