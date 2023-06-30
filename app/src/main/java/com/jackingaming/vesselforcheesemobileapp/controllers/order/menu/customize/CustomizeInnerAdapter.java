package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.customize;

import android.util.Log;

import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.DrinkComponentBaseAdapter;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.Incrementable;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.sweetener_options.Liquid;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.sweetener_options.Packet;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.sweetener_options.SweetenerOptions;

import java.util.ArrayList;
import java.util.List;

public class CustomizeInnerAdapter extends DrinkComponentBaseAdapter {
    public static final String TAG = CustomizeInnerAdapter.class.getSimpleName();

    public CustomizeInnerAdapter(List<DrinkComponent> drinkComponents, List<String> drinkComponentsDefaultAsString, List<DrinkComponent> drinkComponentsStandardRecipe, DrinkComponentBaseAdapterListener listener) {
        super(drinkComponents, drinkComponentsDefaultAsString, drinkComponentsStandardRecipe, listener);
    }

    @Override
    protected void handleSelectionOfDefaultFromStandardRecipe(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected, String name) {
        handleSelectionOfEverythingElse(drinkComponentSelected,
                drinkComponentDefaultAsStringSelected, name);
    }

    @Override
    protected void handleSelectionOfNonDefaultFromStandardRecipe(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected, String name) {
        handleSelectionOfEverythingElse(drinkComponentSelected,
                drinkComponentDefaultAsStringSelected, name);
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

        updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
    }

    @Override
    protected void handleSelectionOfNonDefaultFromNonStandardRecipe(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected, String name) {
        handleSelectionOfEverythingElse(drinkComponentSelected,
                drinkComponentDefaultAsStringSelected, name);
    }

    private void handleSelectionOfEverythingElse(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected, String name) {
        if (drinkComponentSelected instanceof SweetenerOptions) {
            DrinkComponent drinkComponentToAdd = null;
            int drinkComponentDefaultAsStringToAdd = 0;
            if (drinkComponentSelected instanceof Liquid) {
                drinkComponentToAdd = new Liquid(null, 1);
                drinkComponentDefaultAsStringToAdd = Liquid.DEFAULT_QUANTITY_MIN;
            } else if (drinkComponentSelected instanceof Packet) {
                drinkComponentToAdd = new Packet(null, 1);
                drinkComponentDefaultAsStringToAdd = Packet.DEFAULT_QUANTITY_MIN;
            }

            drinkComponents.add(indexSelected, drinkComponentToAdd);
            drinkComponentsDefaultAsString.add(indexSelected, Integer.toString(drinkComponentDefaultAsStringToAdd));

            // TODO: maybe used quantity = -1 to identify the "invoker" (this
            //  way the ones with non-null type can have quantity == 0 behave
            //  independently/normally instead of being intertwined with
            //  identifying "invoker").
            drinkComponentSelected = drinkComponents.get(indexSelected);
            drinkComponentDefaultAsStringSelected = drinkComponentsDefaultAsString.get(indexSelected);

            // Update the underlying model.
            drinkComponentSelected.setTypeByString(name);
            notifyItemInserted(indexSelected);
        } else {
            // Update the underlying model.
            drinkComponentSelected.setTypeByString(name);
            updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
        }
    }

    @Override
    protected void handleClickForViewHolderIncrementable() {
        if (listener != null) {
            DrinkComponent drinkComponentSelected = drinkComponents.get(indexSelected);
            String drinkComponentDefaultAsStringSelected = drinkComponentsDefaultAsString.get(indexSelected);
            Incrementable incrementable = (Incrementable) drinkComponentSelected;
            int quantity = incrementable.getQuantity();

            if (quantity == DrinkComponent.QUANTITY_FOR_INVOKER) {
                Log.i(TAG, "quantity == DrinkComponent.QUANTITY_FOR_INVOKER");

                String[] enumValues = drinkComponentSelected.getEnumValuesAsStringArray();
                if (enumValues.length > 1) {
                    Log.i(TAG, "enumValues.length > 1");
                    List<String> enumValuesFiltered = new ArrayList<>();
                    for (String enumValueAsString : enumValues) {
                        boolean selectedPreviously = false;

                        for (DrinkComponent drinkComponent : drinkComponents) {
                            if (enumValueAsString.equals(drinkComponent.getTypeAsString())) {
                                selectedPreviously = true;
                            }
                        }

                        if (!selectedPreviously) {
                            enumValuesFiltered.add(enumValueAsString);
                        }
                    }

                    if (enumValuesFiltered.size() == 1) {
                        drinkComponentSelected.setTypeByString(enumValuesFiltered.get(0));
                        incrementable.setQuantity(1);
                        updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
                    } else {
                        listener.onItemClicked(enumValuesFiltered.toArray(new String[0]), drinkComponentDefaultAsStringSelected);
                    }
                } else {
                    Log.i(TAG, "enumValues.length <= 1");
                    incrementable.setQuantity(1);
                    updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
                }
            } else {
                Log.i(TAG, "quantity != DrinkComponent.QUANTITY_FOR_INVOKER");
            }
        }
    }
}
