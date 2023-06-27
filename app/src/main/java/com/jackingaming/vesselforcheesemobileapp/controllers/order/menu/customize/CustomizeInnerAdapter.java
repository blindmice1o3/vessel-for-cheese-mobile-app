package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.customize;

import android.util.Log;

import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.DrinkComponentBaseAdapter;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.Incrementable;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.sweetener_options.Liquid;

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
        // Update the underlying model.
        drinkComponentSelected.setTypeByString(DrinkComponent.NULL_TYPE_AS_STRING);

        updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
    }

    @Override
    protected void handleSelectionOfNonDefaultFromNonStandardRecipe(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected, String name) {
        handleSelectionOfEverythingElse(drinkComponentSelected,
                drinkComponentDefaultAsStringSelected, name);
    }

    private void handleSelectionOfEverythingElse(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected, String name) {
        if (drinkComponentSelected instanceof Liquid) {
            Liquid liquid = new Liquid(null, 1);
            drinkComponents.add(indexSelected, liquid);
            drinkComponentsDefaultAsString.add(indexSelected, Integer.toString(Liquid.DEFAULT_QUANTITY_MIN));

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
            String[] names = drinkComponentSelected.getEnumValuesAsStringArray();
            Incrementable incrementable = (Incrementable) drinkComponentSelected;
            String nameDefault = drinkComponentsDefaultAsString.get(indexSelected);

            List<String> namesFiltered = new ArrayList<>();
            for (String name : names) {
                boolean selectedPreviously = false;

                for (DrinkComponent drinkComponent : drinkComponents) {
                    if (name.equals(drinkComponent.getTypeAsString())) {
                        selectedPreviously = true;
                    }
                }

                if (!selectedPreviously) {
                    namesFiltered.add(name);
                }
            }

            if (names.length > 1 &&
                    drinkComponentSelected.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING)) {
                Log.i(TAG, "(names.length > 1) && (type == null) --- names.length: " + names.length);
                listener.onItemClicked(namesFiltered.toArray(new String[0]), nameDefault);
            } else {
                Log.i(TAG, "(names.length <= 1) || (type != null) --- names.length: " + names.length);
                // intentionally doing nothing.
                // ivMinus's and ivAdd's click handlers will take care of this.
            }
        }
    }
}
