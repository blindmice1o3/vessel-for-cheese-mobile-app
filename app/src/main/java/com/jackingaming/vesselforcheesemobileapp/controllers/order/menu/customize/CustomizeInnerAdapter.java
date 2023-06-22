package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.customize;

import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.WhatsIncludedAdapter;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;

import java.util.List;

public class CustomizeInnerAdapter extends WhatsIncludedAdapter {
    public static final String TAG = CustomizeInnerAdapter.class.getSimpleName();

    public CustomizeInnerAdapter(List<DrinkComponent> drinkComponents, List<String> drinkComponentsDefaultAsString, List<DrinkComponent> drinkComponentsStandardRecipe, WhatsIncludedAdapterListener listener) {
        super(drinkComponents, drinkComponentsDefaultAsString, drinkComponentsStandardRecipe, listener);
    }

    @Override
    protected boolean isWhatsIncludedActivity() {
        return false;
    }
}
