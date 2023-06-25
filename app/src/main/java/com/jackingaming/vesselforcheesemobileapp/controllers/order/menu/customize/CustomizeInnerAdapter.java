package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.customize;

import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.DrinkComponentBaseAdapter;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.sweetener_options.Liquid;

import java.util.List;

public class CustomizeInnerAdapter extends DrinkComponentBaseAdapter {
    public static final String TAG = CustomizeInnerAdapter.class.getSimpleName();

    public CustomizeInnerAdapter(List<DrinkComponent> drinkComponents, List<String> drinkComponentsDefaultAsString, List<DrinkComponent> drinkComponentsStandardRecipe, DrinkComponentBaseAdapterListener listener) {
        super(drinkComponents, drinkComponentsDefaultAsString, drinkComponentsStandardRecipe, listener);
    }

    @Override
    protected void handleSelectionOfDefaultFromNonStandardRecipe(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected) {
        // Update the underlying model.
        drinkComponentSelected.setTypeByString(DrinkComponent.NULL_TYPE_AS_STRING);

        updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
    }

    @Override
    protected void handleSelectionOfEverythingElse(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected, String name) {
        if (drinkComponentSelected instanceof Liquid) {
            Liquid liquid = new Liquid(null, 1);
            int indexOneBehindSelected = (indexSelected == 0) ?
                    (0) : (indexSelected - 1);
            drinkComponents.add(indexOneBehindSelected, liquid);
            drinkComponentsDefaultAsString.add(indexOneBehindSelected, Integer.toString(Liquid.DEFAULT_QUANTITY_MIN));

            // TODO: separate a base version out from WhatsIncludedAdapter,
            //  have both CustomizeInnerAdapter and WhatsIncludedAdapter
            //  inherit from base version.
            //
            // TODO: maybe used quantity = -1 to identify the "invoker" (this
            //  way the ones with non-null type can have quantity == 0 behave
            //  independently/normally instead of being intertwined with
            //  identifying "invoker").
            drinkComponentSelected = drinkComponents.get(indexOneBehindSelected);
            drinkComponentDefaultAsStringSelected = drinkComponentsDefaultAsString.get(indexOneBehindSelected);
        }

        // Update the underlying model.
        drinkComponentSelected.setTypeByString(name);

        updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
    }
}
