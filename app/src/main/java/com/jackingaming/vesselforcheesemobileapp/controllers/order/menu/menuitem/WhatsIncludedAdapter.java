package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem;

import android.util.Log;

import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;

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
        } else if (drinkComponentSelected instanceof Granular) {
            // Update the underlying model.
            drinkComponentSelected.setTypeByString(DrinkComponent.NULL_TYPE_AS_STRING);
        } else {
            // Update the underlying model.
            drinkComponentSelected.setTypeByString(DrinkComponent.NULL_TYPE_AS_STRING);
        }

        drinkComponents.remove(indexSelected);
        drinkComponentsDefaultAsString.remove(indexSelected);
        notifyItemRemoved(indexSelected);
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
