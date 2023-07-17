package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks;

import android.util.Log;

import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.Incrementable;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.blended_options.BlendedOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.blended_options.FrapChips;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.EspressoOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.Shot;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.flavor_options.Sauce;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.flavor_options.Syrup;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.sweetener_options.Liquid;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.sweetener_options.SweetenerOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.tea_options.Chai;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.tea_options.MatchaPowder;
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
    public static final int NUMBER_OF_PUMP_INDEPENDENT_OF_DRINK_SIZE = -1;
    public static final int NUMBER_OF_SCOOP_INDEPENDENT_OF_DRINK_SIZE = -1;

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

    public abstract int getNumberOfPumpByDrinkSize(DrinkSize drinkSizeNew);

    public abstract int getNumberOfScoopByDrinkSize(DrinkSize drinkSizeNew);

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

                    for (int i = 0; i < drinkComponentsGroup.size(); i++) {
                        DrinkComponent drinkComponent = drinkComponentsGroup.get(i);

                        if (drinkComponentsStandardRecipe.contains(drinkComponent)) {
                            Log.i(TAG, "drinkComponentsStandardRecipe.contains() drinkComponent (Class, Type): (" + drinkComponent.getClassAsString() + ", " + drinkComponent.getTypeAsString() + ")");

                            if (drinkComponent instanceof FrapChips) {
                                Log.i(TAG, "drinkComponent instanceof FrapChips");
                                Incrementable incrementable = (Incrementable) drinkComponent;

                                int quantityNew = getNumberOfScoopByDrinkSize(drinkSizeNew);

                                if (quantityNew == NUMBER_OF_SCOOP_INDEPENDENT_OF_DRINK_SIZE) {
                                    Log.e(TAG, "quantityNew == NUMBER_OF_SCOOP_INDEPENDENT_OF_DRINK_SIZE");
                                    return false;
                                }

                                int quantityInDrink = incrementable.getQuantity();
                                int quantityDefaultInDrink = Integer.parseInt(drinkComponentsDefaultAsString.get(key).get(i));
                                if (quantityInDrink == quantityDefaultInDrink) {
                                    // user left as default value

                                    if (quantityInDrink == quantityNew) {
                                        // new drink size did NOT change quantity
                                    } else {
                                        // new drink size CHANGED quantity
                                        incrementable.setQuantity(quantityNew);
                                    }
                                } else {
                                    // user had customized

                                    if (quantityInDrink == quantityNew) {
                                        // new drink size did NOT change quantity
                                    } else {
                                        // new drink size CHANGED quantity
                                        incrementable.setQuantity(quantityNew);
                                        changedUserCustomizations = true;
                                    }
                                }

                                // update drinkComponent's associate default value
                                drinkComponentsDefaultAsString.get(key).set(i, Integer.toString(quantityNew));
                            }
                        }
                    }
                } else if (key.equals(EspressoOptions.TAG)) {
                    Log.i(TAG, "key.equals(EspressoOptions.TAG)");

                    for (int i = 0; i < drinkComponentsGroup.size(); i++) {
                        DrinkComponent drinkComponent = drinkComponentsGroup.get(i);

                        if (drinkComponent instanceof Shot) {
                            Log.i(TAG, "drinkComponent instanceof Shot");
                            Incrementable incrementable = (Incrementable) drinkComponent;

                            int quantityNew = getNumberOfShotByDrinkSize(drinkSizeNew);

                            if (quantityNew == NUMBER_OF_SHOT_INDEPENDENT_OF_DRINK_SIZE) {
                                Log.e(TAG, "quantityNew == NUMBER_OF_SHOT_INDEPENDENT_OF_DRINK_SIZE");
                                return false;
                            }

                            int quantityInDrink = incrementable.getQuantity();
                            int quantityDefaultInDrink = Integer.parseInt(drinkComponentsDefaultAsString.get(key).get(i));
                            if (quantityInDrink == quantityDefaultInDrink) {
                                // user left as default value

                                if (quantityInDrink == quantityNew) {
                                    // new drink size did NOT change quantity
                                } else {
                                    // new drink size CHANGED quantity
                                    incrementable.setQuantity(quantityNew);
                                }
                            } else {
                                // user had customized

                                if (quantityInDrink == quantityNew) {
                                    // new drink size did NOT change quantity
                                } else {
                                    // new drink size CHANGED quantity
                                    incrementable.setQuantity(quantityNew);
                                    changedUserCustomizations = true;
                                }
                            }

                            // update drinkComponent's associate default value
                            drinkComponentsDefaultAsString.get(key).set(i, Integer.toString(quantityNew));
                        }
                    }
                } else if (key.equals(TeaOptions.TAG)) {
                    Log.i(TAG, "key.equals(TeaOptions.TAG)");

                    for (int i = 0; i < drinkComponentsGroup.size(); i++) {
                        DrinkComponent drinkComponent = drinkComponentsGroup.get(i);

                        if (drinkComponentsStandardRecipe.contains(drinkComponent)) {
                            Log.i(TAG, "drinkComponentsStandardRecipe.contains() drinkComponent (Class, Type): (" + drinkComponent.getClassAsString() + ", " + drinkComponent.getTypeAsString() + ")");

                            if (drinkComponent instanceof Chai) {
                                Log.i(TAG, "drinkComponent instanceof Chai");
                                Incrementable incrementable = (Incrementable) drinkComponent;

                                int quantityNew = getNumberOfPumpByDrinkSize(drinkSizeNew);

                                if (quantityNew == NUMBER_OF_PUMP_INDEPENDENT_OF_DRINK_SIZE) {
                                    Log.e(TAG, "quantityNew == NUMBER_OF_PUMP_INDEPENDENT_OF_DRINK_SIZE");
                                    return false;
                                }

                                int quantityInDrink = incrementable.getQuantity();
                                int quantityDefaultInDrink = Integer.parseInt(drinkComponentsDefaultAsString.get(key).get(i));
                                if (quantityInDrink == quantityDefaultInDrink) {
                                    // user left as default value

                                    if (quantityInDrink == quantityNew) {
                                        // new drink size did NOT change quantity
                                    } else {
                                        // new drink size CHANGED quantity
                                        incrementable.setQuantity(quantityNew);
                                    }
                                } else {
                                    // user had customized

                                    if (quantityInDrink == quantityNew) {
                                        // new drink size did NOT change quantity
                                    } else {
                                        // new drink size CHANGED quantity
                                        incrementable.setQuantity(quantityNew);
                                        changedUserCustomizations = true;
                                    }
                                }

                                // update drinkComponent's associate default value
                                drinkComponentsDefaultAsString.get(key).set(i, Integer.toString(quantityNew));
                            } else if (drinkComponent instanceof MatchaPowder) {
                                Log.i(TAG, "drinkComponent instanceof MatchaPowder");
                                Incrementable incrementable = (Incrementable) drinkComponent;

                                int quantityNew = getNumberOfScoopByDrinkSize(drinkSizeNew);

                                if (quantityNew == NUMBER_OF_SCOOP_INDEPENDENT_OF_DRINK_SIZE) {
                                    Log.e(TAG, "quantityNew == NUMBER_OF_SCOOP_INDEPENDENT_OF_DRINK_SIZE");
                                    return false;
                                }

                                int quantityInDrink = incrementable.getQuantity();
                                int quantityDefaultInDrink = Integer.parseInt(drinkComponentsDefaultAsString.get(key).get(i));
                                if (quantityInDrink == quantityDefaultInDrink) {
                                    // user left as default value

                                    if (quantityInDrink == quantityNew) {
                                        // new drink size did NOT change quantity
                                    } else {
                                        // new drink size CHANGED quantity
                                        incrementable.setQuantity(quantityNew);
                                    }
                                } else {
                                    // user had customized

                                    if (quantityInDrink == quantityNew) {
                                        // new drink size did NOT change quantity
                                    } else {
                                        // new drink size CHANGED quantity
                                        incrementable.setQuantity(quantityNew);
                                        changedUserCustomizations = true;
                                    }
                                }

                                // update drinkComponent's associate default value
                                drinkComponentsDefaultAsString.get(key).set(i, Integer.toString(quantityNew));
                            }
                        }
                    }
                } else if (key.equals(SweetenerOptions.TAG)) {
                    Log.i(TAG, "key.equals(SweetenerOptions.TAG)");

                    for (int i = 0; i < drinkComponentsGroup.size(); i++) {
                        DrinkComponent drinkComponent = drinkComponentsGroup.get(i);

                        if (drinkComponentsStandardRecipe.contains(drinkComponent)) {
                            Log.i(TAG, "drinkComponentsStandardRecipe.contains() drinkComponent (Class, Type): (" + drinkComponent.getClassAsString() + ", " + drinkComponent.getTypeAsString() + ")");

                            if (drinkComponent instanceof Liquid) {
                                Log.i(TAG, "drinkComponent instanceof Liquid");
                                Incrementable incrementable = (Incrementable) drinkComponent;

                                int quantityNew = getNumberOfPumpByDrinkSize(drinkSizeNew);

                                if (quantityNew == NUMBER_OF_PUMP_INDEPENDENT_OF_DRINK_SIZE) {
                                    Log.e(TAG, "quantityNew == NUMBER_OF_PUMP_INDEPENDENT_OF_DRINK_SIZE");
                                    return false;
                                }

                                int quantityInDrink = incrementable.getQuantity();
                                int quantityDefaultInDrink = Integer.parseInt(drinkComponentsDefaultAsString.get(key).get(i));
                                if (quantityInDrink == quantityDefaultInDrink) {
                                    // user left as default value

                                    if (quantityInDrink == quantityNew) {
                                        // new drink size did NOT change quantity
                                    } else {
                                        // new drink size CHANGED quantity
                                        incrementable.setQuantity(quantityNew);
                                    }
                                } else {
                                    // user had customized

                                    if (quantityInDrink == quantityNew) {
                                        // new drink size did NOT change quantity
                                    } else {
                                        // new drink size CHANGED quantity
                                        incrementable.setQuantity(quantityNew);
                                        changedUserCustomizations = true;
                                    }
                                }

                                // update drinkComponent's associate default value
                                drinkComponentsDefaultAsString.get(key).set(i, Integer.toString(quantityNew));
                            }
                        }
                    }
                } else if (key.equals(FlavorOptions.TAG)) {
                    Log.i(TAG, "key.equals(FlavorOptions.TAG)");

                    for (int i = 0; i < drinkComponentsGroup.size(); i++) {
                        DrinkComponent drinkComponent = drinkComponentsGroup.get(i);

                        if (drinkComponentsStandardRecipe.contains(drinkComponent)) {
                            Log.i(TAG, "drinkComponentsStandardRecipe.contains() drinkComponent (Class, Type): (" + drinkComponent.getClassAsString() + ", " + drinkComponent.getTypeAsString() + ")");

                            if (drinkComponent instanceof Sauce || drinkComponent instanceof Syrup) {
                                Log.i(TAG, "drinkComponent instanceof Sauce || drinkComponent instanceof Syrup");
                                Incrementable incrementable = (Incrementable) drinkComponent;

                                int quantityNew = getNumberOfPumpByDrinkSize(drinkSizeNew);

                                if (quantityNew == NUMBER_OF_PUMP_INDEPENDENT_OF_DRINK_SIZE) {
                                    Log.e(TAG, "quantityNew == NUMBER_OF_PUMP_INDEPENDENT_OF_DRINK_SIZE");
                                    return false;
                                }

                                int quantityInDrink = incrementable.getQuantity();
                                int quantityDefaultInDrink = Integer.parseInt(drinkComponentsDefaultAsString.get(key).get(i));
                                if (quantityInDrink == quantityDefaultInDrink) {
                                    // user left as default value

                                    if (quantityInDrink == quantityNew) {
                                        // new drink size did NOT change quantity
                                    } else {
                                        // new drink size CHANGED quantity
                                        incrementable.setQuantity(quantityNew);
                                    }
                                } else {
                                    // user had customized

                                    if (quantityInDrink == quantityNew) {
                                        // new drink size did NOT change quantity
                                    } else {
                                        // new drink size CHANGED quantity
                                        incrementable.setQuantity(quantityNew);
                                        changedUserCustomizations = true;
                                    }
                                }

                                // update drinkComponent's associate default value
                                drinkComponentsDefaultAsString.get(key).set(i, Integer.toString(quantityNew));
                            }
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
