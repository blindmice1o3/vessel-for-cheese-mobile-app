package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks;

import android.util.Log;

import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.blended_options.BlendedOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.EspressoOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.Shot;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.flavor_options.Sauce;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.flavor_options.Syrup;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.sweetener_options.SweetenerOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.tea_options.TeaOptions;
import com.jackingaming.vesselforcheesemobileapp.models.menu.Menu;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Drink extends MenuItem {
    public static final String TAG = Drink.class.getSimpleName();
    public static final int NUMBER_OF_SHOT_INDEPENDENT_OF_DRINK_SIZE = -1;

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

    public abstract int getNumberOfShotByDrinkSize(DrinkSize drinkSizeNew);

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

    public boolean updateDrinkSize(DrinkSize drinkSizeNew) {
        Log.i(TAG, "updateDrinkSize(DrinkSize)");

        this.drinkSize = drinkSizeNew;

        boolean changedUserCustomizations = false;
        // TODO: set changedUserCustomizations to true if altered.
        for (String key : Menu.DRINK_SIZE_CHANGED_KEYS) {
            if (drinkComponents.containsKey(key)) {
                Log.i(TAG, "key: " + key);

                List<DrinkComponent> drinkComponentsGroup = drinkComponents.get(key);
                if (key.equals(AddInsOptions.TAG)) {
                    Log.i(TAG, "key.equals(AddInsOptions.TAG)");

                } else if (key.equals(BlendedOptions.TAG)) {
                    Log.i(TAG, "key.equals(BlendedOptions.TAG)");

                } else if (key.equals(EspressoOptions.TAG)) {
                    Log.i(TAG, "key.equals(EspressoOptions.TAG)");

                    for (int i = 0; i < drinkComponentsGroup.size(); i++) {
                        DrinkComponent drinkComponent = drinkComponentsGroup.get(i);

                        if (drinkComponent instanceof Shot) {
                            Shot shot = (Shot) drinkComponent;

                            int quantityNew = getNumberOfShotByDrinkSize(drinkSizeNew);

                            if (quantityNew == NUMBER_OF_SHOT_INDEPENDENT_OF_DRINK_SIZE) {
                                Log.e(TAG, "quantityNew == NUMBER_OF_SHOT_INDEPENDENT_OF_DRINK_SIZE");
                                return false;
                            }

                            int quantityInDrink = shot.getQuantity();
                            int quantityDefaultInDrink = Integer.parseInt(drinkComponentsDefaultAsString.get(key).get(i));
                            if (quantityInDrink == quantityDefaultInDrink) {
                                // user left as default value

                                if (quantityInDrink == quantityNew) {
                                    // new drink size did not change number of shot
                                } else {
                                    // new drink size CHANGED number of shot
                                    shot.setQuantity(quantityNew);
                                }
                            } else {
                                // user had customized

                                if (quantityInDrink == quantityNew) {
                                    // new drink size did not change number of shot
                                } else {
                                    // new drink size CHANGED number of shot
                                    shot.setQuantity(quantityNew);
                                    changedUserCustomizations = true;
                                }
                            }

                            // update drinkComponent's associate default value
                            drinkComponentsDefaultAsString.get(key).set(i, Integer.toString(quantityNew));
                        }
                    }
                } else if (key.equals(TeaOptions.TAG)) {
                    Log.i(TAG, "key.equals(TeaOptions.TAG)");

                    // TODO: [Chai]
                } else if (key.equals(SweetenerOptions.TAG)) {
                    Log.i(TAG, "key.equals(SweetenerOptions.TAG)");

                    // TODO: [Liquid], NOT [Packet]
                } else if (key.equals(FlavorOptions.TAG)) {
                    Log.i(TAG, "key.equals(FlavorOptions.TAG)");

                    // TODO: [Sauce] and [Syrup]
                    for (int i = 0; i < drinkComponentsGroup.size(); i++) {
                        DrinkComponent drinkComponent = drinkComponentsGroup.get(i);

                        if (drinkComponent instanceof Sauce || drinkComponent instanceof Syrup) {
                            // TODO: !!! change value of drinkComponentsDefaultAsString !!!

                        }
                    }
                } else {
                    Log.e(TAG, "else clause to identify [key] related to drink size changed.");
                }
            }
        }
        return changedUserCustomizations;
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
