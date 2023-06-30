package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem;

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
            ((Incrementable) drinkComponentSelected).setQuantity(DrinkComponent.QUANTITY_FOR_INVOKER);
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
        // Update the underlying model.
        drinkComponentSelected.setTypeByString(name);

        updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
    }

    public void setDrinkComponents(List<DrinkComponent> drinkComponents) {
        this.drinkComponents = drinkComponents;
    }

    public void setDrinkComponentsDefaultAsString(List<String> drinkComponentsDefaultAsString) {
        this.drinkComponentsDefaultAsString = drinkComponentsDefaultAsString;
    }
}
