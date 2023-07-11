package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks;

import android.util.Log;

import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Drink extends MenuItem {
    public static final String TAG = Drink.class.getSimpleName();

    protected DrinkSize drinkSize;
    protected boolean iced;

    protected Map<String, List<DrinkComponent>> drinkComponents = new HashMap<>();
    protected Map<String, List<String>> drinkComponentsDefaultAsString = new HashMap<>();
    protected List<DrinkComponent> drinkComponentsStandardRecipe = new ArrayList<>();
    protected DrinkSize[] drinkSizesAllowed;

    public Drink() {
        super();
    }

    public Drink(String name, String description, int calories, int sugarInGram, float fatInGram,
                 double price, DrinkSize drinkSizeDefault, boolean iced) {
        super(name, description, calories, sugarInGram, fatInGram, price);
        this.drinkSize = drinkSizeDefault;
        this.iced = iced;
    }

    // TODO: abstract initDrinkComponents()
    // TODO: abstract initDrinkComponentsDefaultAsString()
    // TODO: abstract initDrinkComponentsStandardRecipe()
    // TODO: abstract initDrinkSizesAllowed()
    //  (as oppose to CaffeLatte doing this straight in the constructor).

    public void addToDrinkComponents(String key, DrinkComponent drinkComponent) {
        Log.i(TAG, "addToDrinkComponents(String, DrinkComponent)");
        // TODO: screen for duplication (subclasses should override and add rules-check)
//        drinkComponents.get(key).add(drinkComponent);
    }

    public Map<String, List<DrinkComponent>> getDrinkComponents() {
        return drinkComponents;
    }

    public void setDrinkComponents(Map<String, List<DrinkComponent>> drinkComponents) {
        this.drinkComponents = drinkComponents;
    }

    public Map<String, List<String>> getDrinkComponentsDefaultAsString() {
        return drinkComponentsDefaultAsString;
    }

    public void setDrinkComponentsDefaultAsString(Map<String, List<String>> drinkComponentsDefaultAsString) {
        this.drinkComponentsDefaultAsString = drinkComponentsDefaultAsString;
    }

    public List<DrinkComponent> getDrinkComponentsStandardRecipe() {
        return drinkComponentsStandardRecipe;
    }

    public void setDrinkComponentsStandardRecipe(List<DrinkComponent> drinkComponentsStandardRecipe) {
        this.drinkComponentsStandardRecipe = drinkComponentsStandardRecipe;
    }

    public DrinkSize getDrinkSize() {
        return drinkSize;
    }

    public void setDrinkSize(DrinkSize drinkSize) {
        this.drinkSize = drinkSize;
    }

    public DrinkSize[] getDrinkSizesAllowed() {
        return drinkSizesAllowed;
    }

    public void setDrinkSizesAllowed(DrinkSize[] drinkSizesAllowed) {
        this.drinkSizesAllowed = drinkSizesAllowed;
    }

    public boolean isIced() {
        return iced;
    }

    public void setIced(boolean iced) {
        this.iced = iced;
    }
}
