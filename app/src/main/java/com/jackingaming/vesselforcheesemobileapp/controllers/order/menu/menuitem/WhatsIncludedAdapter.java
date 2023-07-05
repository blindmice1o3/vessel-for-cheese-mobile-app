package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem;

import android.util.Log;

import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.topping_options.ColdFoam;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.topping_options.Drizzle;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.topping_options.Topping;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.topping_options.ToppingOptions;

import java.util.List;

public class WhatsIncludedAdapter extends DrinkComponentBaseAdapter {
    public static final String TAG = WhatsIncludedAdapter.class.getSimpleName();

    public WhatsIncludedAdapter(List<DrinkComponent> drinkComponents, List<String> drinkComponentsDefaultAsString, List<DrinkComponent> drinkComponentsStandardRecipe, DrinkComponentBaseAdapterListener listener) {
        super(drinkComponents, drinkComponentsDefaultAsString, drinkComponentsStandardRecipe, listener);
    }

    @Override
    protected void handleSelectionOfDefaultFromStandardRecipe(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected, String name) {
        handleSelectionFromStandardRecipe(drinkComponentSelected, drinkComponentDefaultAsStringSelected, name);
    }

    @Override
    protected void handleSelectionOfNonDefaultFromStandardRecipe(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected, String name) {
        handleSelectionFromStandardRecipe(drinkComponentSelected, drinkComponentDefaultAsStringSelected, name);
    }

    @Override
    protected void handleSelectionOfDefaultFromNonStandardRecipe(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected) {
        if (drinkComponentSelected instanceof Incrementable) {
            // Update the underlying model.
            ((Incrementable) drinkComponentSelected).setQuantity(Incrementable.QUANTITY_FOR_INVOKER);
            drinkComponents.remove(indexSelected);
            drinkComponentsDefaultAsString.remove(indexSelected);
            notifyItemRemoved(indexSelected);
        } else if (drinkComponentSelected instanceof Granular) {
            String[] enumValues = drinkComponentSelected.getEnumValuesAsStringArray();
            List<String> enumValuesNotInsideDrink = findEnumValuesNotInsideDrink(enumValues);

            if (enumValuesNotInsideDrink.size() == 0) {
                Log.i(TAG, "enumValuesNotInsideDrink.size() == 0");

                // Update the underlying model.
                drinkComponentSelected.setTypeByString(DrinkComponent.NULL_TYPE_AS_STRING);
                ((Granular) drinkComponentSelected).setAmount(Granular.Amount.NO);
                updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
            } else {
                Log.i(TAG, "enumValuesNotInsideDrink.size() != 0");

                // Update the underlying model.
                drinkComponentSelected.setTypeByString(DrinkComponent.NULL_TYPE_AS_STRING);
                ((Granular) drinkComponentSelected).setAmount(Granular.Amount.NO);
                drinkComponents.remove(indexSelected);
                drinkComponentsDefaultAsString.remove(indexSelected);
                notifyItemRemoved(indexSelected);
            }
        } else {
            // Update the underlying model.
            drinkComponentSelected.setTypeByString(DrinkComponent.NULL_TYPE_AS_STRING);
            drinkComponents.remove(indexSelected);
            drinkComponentsDefaultAsString.remove(indexSelected);
            notifyItemRemoved(indexSelected);
        }
    }

    @Override
    protected void handleSelectionOfNonDefaultFromNonStandardRecipe(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected, String name) {
        handleSelectionFromStandardRecipe(drinkComponentSelected, drinkComponentDefaultAsStringSelected, name);
    }

    private void handleSelectionFromStandardRecipe(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected, String name) {
        Log.i(TAG, "handleSelectionFromStandardRecipe()");

        if (drinkComponentSelected instanceof Incrementable) {
            Log.i(TAG, "drinkComponentSelected instanceof Incrementable");

            // Update the underlying model.
            drinkComponentSelected.setTypeByString(name);
            updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
        } else if (drinkComponentSelected instanceof Granular) {
            Log.i(TAG, "drinkComponentSelected instanceof Granular");

            if (drinkComponentSelected.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING)) {
                Log.i(TAG, "drinkComponentSelected.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING)");

                if (drinkComponentSelected instanceof ToppingOptions) {
                    Log.i(TAG, "drinkComponentSelected instanceof ToppingOptions");

                    String[] enumValues = drinkComponentSelected.getEnumValuesAsStringArray();
                    List<String> enumValuesNotInsideDrink = findEnumValuesNotInsideDrink(enumValues);
                    // this handleSelection...() is only called when (enumValues.length > 1).
                    // special case when only 2 choices left (one choice is the user selection,
                    // the other is the left-over choice... the "invoker" should be converted to this).
                    if (enumValuesNotInsideDrink.size() == 2) {
                        Log.i(TAG, "enumValuesNotInsideDrink.size() == 2");

                        String nameDrinkComponentToAdd = null;
                        String nameDrinkComponentLast = null;
                        if (name.equals(enumValuesNotInsideDrink.get(0))) {
                            Log.i(TAG, "user selected index 0");
                            nameDrinkComponentToAdd = enumValuesNotInsideDrink.get(0);
                            nameDrinkComponentLast = enumValuesNotInsideDrink.get(1);
                        } else {
                            Log.i(TAG, "user selected index 1");
                            nameDrinkComponentToAdd = enumValuesNotInsideDrink.get(1);
                            nameDrinkComponentLast = enumValuesNotInsideDrink.get(0);
                        }
                        // LAST
                        ((Granular) drinkComponentSelected).setAmount(Granular.Amount.NO);
                        drinkComponentSelected.setTypeByString(nameDrinkComponentLast);
                        updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);

                        // SECOND-TO-LAST
                        DrinkComponent drinkComponentToAdd = null;
                        if (drinkComponentSelected instanceof ColdFoam) {
                            Log.i(TAG, "drinkComponentSelected instanceof ColdFoam");
                            drinkComponentToAdd = new ColdFoam(null, Granular.Amount.MEDIUM);
                        } else if (drinkComponentSelected instanceof Drizzle) {
                            Log.i(TAG, "drinkComponentSelected instanceof Drizzle");
                            drinkComponentToAdd = new Drizzle(null, Granular.Amount.MEDIUM);
                        } else if (drinkComponentSelected instanceof Topping) {
                            Log.i(TAG, "drinkComponentSelected instanceof Topping");
                            drinkComponentToAdd = new Topping(null, Granular.Amount.MEDIUM);
                        }
                        drinkComponentToAdd.setTypeByString(nameDrinkComponentToAdd);
                        String drinkComponentDefaultAsStringToAdd = Granular.Amount.NO.name();

                        drinkComponents.add(indexSelected, drinkComponentToAdd);
                        drinkComponentsDefaultAsString.add(indexSelected, drinkComponentDefaultAsStringToAdd);
                        notifyItemInserted(indexSelected);
                    } else if (enumValuesNotInsideDrink.size() == 1) {
                        // LAST
                        ((Granular) drinkComponentSelected).setAmount(Granular.Amount.MEDIUM);
                        drinkComponentSelected.setTypeByString(enumValuesNotInsideDrink.get(0));
                        updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
                    } else {
                        Log.i(TAG, "enumValuesNotInsideDrink.size() != 2 and enumValuesNotInsideDrink.size() != 1");

                        DrinkComponent drinkComponentToAdd = null;
                        if (drinkComponentSelected instanceof ColdFoam) {
                            Log.i(TAG, "drinkComponentSelected instanceof ColdFoam");
                            drinkComponentToAdd = new ColdFoam(null, Granular.Amount.MEDIUM);
                        } else if (drinkComponentSelected instanceof Drizzle) {
                            Log.i(TAG, "drinkComponentSelected instanceof Drizzle");
                            drinkComponentToAdd = new Drizzle(null, Granular.Amount.MEDIUM);
                        } else if (drinkComponentSelected instanceof Topping) {
                            Log.i(TAG, "drinkComponentSelected instanceof Topping");
                            drinkComponentToAdd = new Topping(null, Granular.Amount.MEDIUM);
                        }
                        drinkComponentToAdd.setTypeByString(name);
                        String drinkComponentDefaultAsStringToAdd = Granular.Amount.NO.name();

                        drinkComponents.add(indexSelected, drinkComponentToAdd);
                        drinkComponentsDefaultAsString.add(indexSelected, drinkComponentDefaultAsStringToAdd);
                        notifyItemInserted(indexSelected);
                    }
                }
            } else {
                Granular.Amount amountSelected = null;
                for (int i = 0; i < Granular.Amount.values().length; i++) {
                    if (name.equals(Granular.Amount.values()[i].name())) {
                        amountSelected = Granular.Amount.values()[i];
                        break;
                    }
                }

                // Update the underlying model.
                ((Granular) drinkComponentSelected).setAmount(amountSelected);
                updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
            }
        } else {
            Log.i(TAG, "drinkComponentSelected NOT instanceof Incrementable nor Granular");

            // Update the underlying model.
            drinkComponentSelected.setTypeByString(name);
            updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
        }
    }

    public void setDrinkComponents(List<DrinkComponent> drinkComponents) {
        this.drinkComponents = drinkComponents;
    }

    public void setDrinkComponentsDefaultAsString(List<String> drinkComponentsDefaultAsString) {
        this.drinkComponentsDefaultAsString = drinkComponentsDefaultAsString;
    }
}
