package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks;

import android.util.Log;

import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.size_options.DrinkSize;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.MenuItem;

import java.util.ArrayList;
import java.util.List;

public abstract class Drink extends MenuItem {
    public static final String TAG = Drink.class.getSimpleName();

    protected DrinkSize.Type drinkSize;
    protected boolean iced;
    protected List<DrinkComponent> drinkComponentsWhatsIncluded = new ArrayList<>();
    protected String[] drinkComponentsWhatsIncludedDefaultValuesAsStringArray;
    protected List<DrinkComponent> drinkComponentsCustomized = new ArrayList<>();

    public Drink() {
        super();
    }

    public Drink(String name, String description, double price, DrinkSize.Type drinkSizeDefault, boolean iced) {
        super(name, description, price);
        drinkSize = drinkSizeDefault;
        this.iced = iced;
    }

    // TODO: abstract method to initDrinkComponentsWhatsIncluded()
    //  (as oppose to CaffeLatte doing this straight in the constructor).

    // TODO: abstract method to initDrinkComponentsWhatsIncludedDefaultValuesAsStringArray().

    public void addToDrinkComponentsWhatsIncluded(DrinkComponent drinkComponent) {
        Log.i(TAG, "addToDrinkComponentsWhatsIncluded(DrinkComponent)");
        // TODO: screen for duplication (subclasses should override and add rules-check)
        drinkComponentsWhatsIncluded.add(drinkComponent);
    }

    public void addToDrinkComponentsCustomized(DrinkComponent drinkComponent) {
        Log.i(TAG, "addToDrinkComponentsCustomized(DrinkComponent)");
        // TODO: screen for duplication (subclasses should override and add rules-check)
        drinkComponentsCustomized.add(drinkComponent);
    }

    public String[] getDrinkComponentsWhatsIncludedDefaultValuesAsStringArray() {
        return drinkComponentsWhatsIncludedDefaultValuesAsStringArray;
    }

    public DrinkSize.Type getDrinkSize() {
        return drinkSize;
    }

    public void setDrinkSize(DrinkSize.Type drinkSize) {
        this.drinkSize = drinkSize;
    }

    public boolean isIced() {
        return iced;
    }

    public void setIced(boolean iced) {
        this.iced = iced;
    }

    public List<DrinkComponent> getDrinkComponentsWhatsIncluded() {
        return drinkComponentsWhatsIncluded;
    }

    public void setDrinkComponentsWhatsIncluded(List<DrinkComponent> drinkComponentsWhatsIncluded) {
        this.drinkComponentsWhatsIncluded = drinkComponentsWhatsIncluded;
    }

    public List<DrinkComponent> getDrinkComponentsCustomized() {
        return drinkComponentsCustomized;
    }

    public void setDrinkComponentsCustomized(List<DrinkComponent> drinkComponentsCustomized) {
        this.drinkComponentsCustomized = drinkComponentsCustomized;
    }
}
