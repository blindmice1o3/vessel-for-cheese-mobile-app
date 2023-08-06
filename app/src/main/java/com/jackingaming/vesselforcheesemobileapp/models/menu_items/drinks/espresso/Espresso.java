package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso;

import android.util.Log;

import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.Drink;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.cappuccinos.Cappuccinos;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.flat_whites.cold.IcedFlatWhites;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.flat_whites.hot.FlatWhites;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.iced_shaken_espressos.IcedShakenEspressos;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes.cold.IcedLattes;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes.hot.Lattes;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.macchiatos.cold.IcedMacchiatos;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.macchiatos.hot.EspressoMacchiato;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.macchiatos.hot.Macchiatos;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.mochas.cold.IcedMochas;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.mochas.hot.Mochas;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.water_based.americanos.cold.IcedAmericano;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.water_based.americanos.hot.Americanos;

public abstract class Espresso extends Drink {
    public static final String TAG = Espresso.class.getSimpleName();

    public Espresso() {
    }

    public Espresso(String name, String description, int calories, int sugarInGram, float fatInGram,
                    double price, DrinkSize drinkSizeDefault) {
        super(name, description, calories, sugarInGram, fatInGram,
                price, drinkSizeDefault);
    }

    @Override
    public int getNumberOfShotByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfShotByDrinkSize(DrinkSize)");

        int numberOfShotNew = QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
        if (this instanceof Lattes || this instanceof IcedLattes ||
                this instanceof Mochas || this instanceof IcedMochas ||
                this instanceof Cappuccinos || this instanceof IcedMacchiatos ||
                this instanceof Macchiatos && !(this instanceof EspressoMacchiato)) {
            Log.i(TAG, "this instanceof Lattes || this instanceof IcedLattes || this instanceof Mochas || this instanceof IcedMochas || this instanceof Cappuccinos || this instanceof IcedMacchiatos || this instanceof Macchiatos && !(this instanceof EspressoMacchiato)");
            // TODO: double check on EspressoMacchiato shot-by-DrinkSize
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
        } else if (this instanceof Americanos || this instanceof IcedAmericano) {
            Log.i(TAG, "this instanceof Americanos || this instanceof IcedAmericano");
            switch (drinkSizeNew) {
                case SHORT:
                    numberOfShotNew = 1;
                    break;
                case TALL:
                    numberOfShotNew = 2;
                    break;
                case GRANDE:
                    numberOfShotNew = 3;
                    break;
                case VENTI_HOT:
                case VENTI_ICED:
                    numberOfShotNew = 4;
                    break;
                case TRENTA:
                case UNIQUE:
                case UNDEFINED:
                    break;
            }
        } else if (this instanceof FlatWhites || this instanceof IcedFlatWhites ||
                this instanceof IcedShakenEspressos) {
            Log.i(TAG, "this instanceof FlatWhites || this instanceof IcedFlatWhites || this instanceof IcedShakenEspressos");
            switch (drinkSizeNew) {
                case SHORT:
                case TALL:
                    numberOfShotNew = 2;
                    break;
                case GRANDE:
                case VENTI_HOT:
                    numberOfShotNew = 3;
                    break;
                case VENTI_ICED:
                    numberOfShotNew = 4;
                    break;
                case TRENTA:
                case UNIQUE:
                case UNDEFINED:
                    break;
            }
        } else {
            Log.e(TAG, "else-clause");
        }

        return numberOfShotNew;
    }

    @Override
    public int getNumberOfPumpByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfPumpByDrinkSize(DrinkSize)");

        int numberOfPumpNew = QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
        if (this instanceof Lattes || this instanceof IcedLattes ||
                this instanceof Mochas || this instanceof IcedMochas ||
                this instanceof Americanos || this instanceof IcedAmericano ||
                this instanceof FlatWhites || this instanceof IcedShakenEspressos ||
                this instanceof Cappuccinos) {
            Log.i(TAG, "this instanceof Lattes || this instanceof IcedLattes || this instanceof Mochas || this instanceof IcedMochas || this instanceof Americanos || this instanceof IcedAmericano || this instanceof FlatWhites || this instanceof IcedShakenEspressos || this instanceof Cappuccinos");
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
        } else if (this instanceof Macchiatos && !(this instanceof EspressoMacchiato)
                || this instanceof IcedMacchiatos) {
            Log.i(TAG, "this instanceof Macchiatos && !(this instanceof EspressoMacchiato) || this instanceof IcedMacchiatos");
            // TODO: double check on EspressoMacchiato shot-by-DrinkSize
            switch (drinkSizeNew) {
                case SHORT:
                    numberOfPumpNew = 1;
                    break;
                case TALL:
                    numberOfPumpNew = 2;
                    break;
                case GRANDE:
                    numberOfPumpNew = 3;
                    break;
                case VENTI_HOT:
                    numberOfPumpNew = 4;
                    break;
                case VENTI_ICED:
                    numberOfPumpNew = 5;
                    break;
                case TRENTA:
                case UNIQUE:
                case UNDEFINED:
                    break;
            }
        } else {
            Log.e(TAG, "else-clause");
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

        return QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
    }

    @Override
    public int getNumberOfTeaBagByDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "getNumberOfTeaBagByDrinkSize(DrinkSize)");

        return QUANTITY_INDEPENDENT_OF_DRINK_SIZE;
    }
}