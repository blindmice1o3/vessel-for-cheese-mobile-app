package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other;

import android.util.Log;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.Drink;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;

public abstract class Other extends Drink {
    public static final String TAG = Other.class.getSimpleName();
    public static final DrinkSize DEFAULT_DRINK_SIZE = DrinkSize.GRANDE;

    public static final DrinkSize[] DEFAULT_DRINK_SIZES_ALLOWED =
            {DrinkSize.TALL, DrinkSize.GRANDE, DrinkSize.VENTI_ICED};

    public Other() {
        super();
    }

    public Other(String name, String description, int calories, int sugarInGram, float fatInGram,
                 double price, boolean iced) {
        super(name, description, calories, sugarInGram, fatInGram, price, DEFAULT_DRINK_SIZE, iced);

        drinkSizesAllowed = DEFAULT_DRINK_SIZES_ALLOWED;
    }

    @Override
    public int getNumberOfShotByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfShotByDrinkSize(DrinkSize)");

        int numberOfShotNew = QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
        switch (drinkSizeNew) {
            case SHORT:
            case TALL:
                numberOfShotNew = 1;
                break;
            case GRANDE:
            case VENTI_HOT:
                numberOfShotNew = 2;
                break;
            case VENTI_ICED:
                numberOfShotNew = 3;
                break;
            case TRENTA:
            case UNIQUE:
            case UNDEFINED:
                break;
        }

        return numberOfShotNew;
    }

    @Override
    public int getNumberOfPumpByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfPumpByDrinkSize(DrinkSize)");

        int numberOfPumpNew = QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
        switch (drinkSizeNew) {
            case SHORT:
                numberOfPumpNew = 2;
                break;
            case TALL:
                numberOfPumpNew = 3;
                break;
            case GRANDE:
                numberOfPumpNew = 4;
                break;
            case VENTI_HOT:
                numberOfPumpNew = 5;
                break;
            case VENTI_ICED:
                numberOfPumpNew = 6;
                break;
            case TRENTA:
            case UNIQUE:
            case UNDEFINED:
                break;
        }

        return numberOfPumpNew;
    }

    @Override
    public int getNumberOfScoopByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfScoopByDrinkSize(DrinkSize)");

        int numberOfScoopNew = QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
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

    @Override
    public int getNumberOfFrapRoastByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfFrapRoastByDrinkSize(DrinkSize)");

        int numberOfFrapRoastNew = QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
        switch (drinkSizeNew) {
            case SHORT:
                numberOfFrapRoastNew = 1;
                break;
            case TALL:
                numberOfFrapRoastNew = 2;
                break;
            case GRANDE:
                numberOfFrapRoastNew = 3;
                break;
            case VENTI_HOT:
            case VENTI_ICED:
                numberOfFrapRoastNew = 4;
                break;
            case TRENTA:
            case UNIQUE:
            case UNDEFINED:
                break;
        }

        return numberOfFrapRoastNew;
    }

    @Override
    public int getNumberOfTeaBagByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfTeaBagByDrinkSize(DrinkSize)");

        int numberOfTeaBagNew = QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
        switch (drinkSizeNew) {
            case SHORT:
            case TALL:
                numberOfTeaBagNew = 1;
                break;
            case GRANDE:
            case VENTI_HOT:
            case VENTI_ICED:
                numberOfTeaBagNew = 2;
                break;
            case TRENTA:
            case UNIQUE:
            case UNDEFINED:
                break;
        }

        return numberOfTeaBagNew;
    }
}
