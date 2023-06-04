package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks;

import android.util.Log;

import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.size_options.SizeOptions;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.MenuItem;

import java.util.ArrayList;
import java.util.List;

public abstract class Drink extends MenuItem {
    public static final String TAG = Drink.class.getSimpleName();

    protected SizeOptions sizeOptions;
    protected boolean iced;
    protected List<DrinkComponent> customizedDrinkComponents = new ArrayList<>();

    public Drink() {
        super();
    }

    public Drink(String name, String description, double price, SizeOptions.DrinkSize drinkSizeDefault, boolean iced) {
        super(name, description, price);
        sizeOptions = new SizeOptions(drinkSizeDefault);
        this.iced = iced;
    }

    public void addDrinkComponent(DrinkComponent drinkComponent) {
        Log.i(TAG, "addDrinkComponent(DrinkComponent)");
        // TODO: screen for duplication (subclasses should override and add rules-check)
        customizedDrinkComponents.add(drinkComponent);
    }

    public SizeOptions getSizeOptions() {
        return sizeOptions;
    }

    public void setSizeOptions(SizeOptions sizeOptions) {
        this.sizeOptions = sizeOptions;
    }

    public boolean isIced() {
        return iced;
    }

    public void setIced(boolean iced) {
        this.iced = iced;
    }

    public List<DrinkComponent> getCustomizedDrinkComponents() {
        return customizedDrinkComponents;
    }

    public void setCustomizedDrinkComponents(List<DrinkComponent> customizedDrinkComponents) {
        this.customizedDrinkComponents = customizedDrinkComponents;
    }
}
