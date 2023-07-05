package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.customize;

import android.util.Log;

import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.DrinkComponentBaseAdapter;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.Granular;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.Incrementable;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.flavor_options.Sauce;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.flavor_options.Syrup;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.sweetener_options.Liquid;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.sweetener_options.Packet;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.sweetener_options.SweetenerOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.topping_options.ColdFoam;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.topping_options.Drizzle;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.topping_options.Topping;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.topping_options.ToppingOptions;

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
        Log.i(TAG, "handleSelectionOfDefaultFromNonStandardRecipe()");

        if (drinkComponentSelected instanceof Incrementable) {
            Log.i(TAG, "drinkComponentSelected instanceof Incrementable");

            // Update the underlying model.
            ((Incrementable) drinkComponentSelected).setQuantity(Incrementable.QUANTITY_FOR_INVOKER);
            updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
        } else if (drinkComponentSelected instanceof Granular) {
            Log.i(TAG, "drinkComponentSelected instanceof Granular");

            String[] enumValues = drinkComponentSelected.getEnumValuesAsStringArray();
            if (enumValues.length == 1) {
                Log.i(TAG, "enumValues.length == 1");

                // Update the underlying model.
                drinkComponentSelected.setTypeByString(DrinkComponent.NULL_TYPE_AS_STRING);
                ((Granular) drinkComponentSelected).setAmount(Granular.Amount.NO);
                updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
            } else {
                Log.i(TAG, "enumValues.length != 1");

                List<String> enumValuesNotInsideDrink = findEnumValuesNotInsideDrink(enumValues);
                for (String enumValue : enumValuesNotInsideDrink) {
                    Log.i(TAG, "enumValue: " + enumValue);
                }

                if (enumValuesNotInsideDrink.size() == 0) {
                    Log.i(TAG, "enumValuesNotInsideDrink.size() == 0");

                    // Update the underlying model.
                    drinkComponentSelected.setTypeByString(DrinkComponent.NULL_TYPE_AS_STRING);
                    ((Granular) drinkComponentSelected).setAmount(Granular.Amount.NO);
                    drinkComponents.remove(indexSelected);
                    drinkComponentsDefaultAsString.remove(indexSelected);
                    notifyItemRemoved(indexSelected);
                } else {
                    Log.i(TAG, "enumValuesNotInsideDrink.size() != 0");

                    // Update the underlying model.
                    drinkComponentSelected.setTypeByString(DrinkComponent.NULL_TYPE_AS_STRING);
                    ((Granular) drinkComponentSelected).setAmount(Granular.Amount.NO);
                    updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
                }
            }
        } else {
            Log.i(TAG, "NOT drinkComponentSelected instanceof Incrementable and NOT drinkComponentSelected instanceof Granular");

            // Update the underlying model.
            drinkComponentSelected.setTypeByString(DrinkComponent.NULL_TYPE_AS_STRING);
            updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
        }
    }

    @Override
    protected void handleSelectionOfNonDefaultFromNonStandardRecipe(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected, String name) {
        handleSelectionOfEverythingElse(drinkComponentSelected,
                drinkComponentDefaultAsStringSelected, name);
    }

    private void handleSelectionOfEverythingElse(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected, String name) {
        Log.i(TAG, "handleSelectionOfEverythingElse()");

        if (drinkComponentSelected instanceof Incrementable) {
            Log.i(TAG, "drinkComponentSelected instanceof Incrementable");

            if (drinkComponentSelected instanceof SweetenerOptions ||
                    drinkComponentSelected instanceof FlavorOptions) {
                Log.i(TAG, "drinkComponentSelected instanceof SweetenerOptions || drinkComponentSelected instanceof FlavorOptions");

                DrinkComponent drinkComponentToAdd = null;
                int drinkComponentDefaultAsStringToAdd = 0;
                if (drinkComponentSelected instanceof Liquid) {
                    drinkComponentToAdd = new Liquid(null, 1);
                    drinkComponentToAdd.setTypeByString(name);
                    drinkComponentDefaultAsStringToAdd = Liquid.DEFAULT_QUANTITY_MIN;
                } else if (drinkComponentSelected instanceof Packet) {
                    drinkComponentToAdd = new Packet(null, 1);
                    drinkComponentToAdd.setTypeByString(name);
                    drinkComponentDefaultAsStringToAdd = Packet.DEFAULT_QUANTITY_MIN;
                } else if (drinkComponentSelected instanceof Sauce) {
                    drinkComponentToAdd = new Sauce(null, 1);
                    drinkComponentToAdd.setTypeByString(name);
                    drinkComponentDefaultAsStringToAdd = Sauce.DEFAULT_QUANTITY_MIN;
                } else if (drinkComponentSelected instanceof Syrup) {
                    drinkComponentToAdd = new Syrup(null, 1);
                    drinkComponentToAdd.setTypeByString(name);
                    drinkComponentDefaultAsStringToAdd = Syrup.DEFAULT_QUANTITY_MIN;
                }

                drinkComponents.add(indexSelected, drinkComponentToAdd);
                drinkComponentsDefaultAsString.add(indexSelected, Integer.toString(drinkComponentDefaultAsStringToAdd));
                notifyItemInserted(indexSelected);
            } else {
                Log.i(TAG, "NOT drinkComponentSelected instanceof SweetenerOptions || drinkComponentSelected instanceof FlavorOptions");

                // Update the underlying model.
                drinkComponentSelected.setTypeByString(name);
                updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
            }
        } else if (drinkComponentSelected instanceof Granular) {
            Log.i(TAG, "drinkComponentSelected instanceof Granular");

            if (drinkComponentSelected.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING)) {
                Log.i(TAG, "drinkComponentSelected.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING)");

                if (drinkComponentSelected instanceof ToppingOptions) {
                    Log.i(TAG, "drinkComponentSelected instanceof ToppingOptions");

                    String[] enumValues = drinkComponentSelected.getEnumValuesAsStringArray();
                    List<String> enumValuesNotInsideDrink = findEnumValuesNotInsideDrink(enumValues);
                    // this handleSelection...() is only called when (enumValues.length > 1).
                    // special case when only 2 choices left (one choice is the user selection,
                    // the other is the left-over choice... the "invoker" should be converted to this).
                    if (enumValuesNotInsideDrink.size() == 2) {
                        Log.i(TAG, "enumValuesNotInsideDrink.size() == 2");

                        String nameDrinkComponentToAdd = null;
                        String nameDrinkComponentLast = null;
                        if (name.equals(enumValuesNotInsideDrink.get(0))) {
                            Log.i(TAG, "user selected index 0");
                            nameDrinkComponentToAdd = enumValuesNotInsideDrink.get(0);
                            nameDrinkComponentLast = enumValuesNotInsideDrink.get(1);
                        } else {
                            Log.i(TAG, "user selected index 1");
                            nameDrinkComponentToAdd = enumValuesNotInsideDrink.get(1);
                            nameDrinkComponentLast = enumValuesNotInsideDrink.get(0);
                        }
                        // LAST
                        ((Granular) drinkComponentSelected).setAmount(Granular.Amount.NO);
                        drinkComponentSelected.setTypeByString(nameDrinkComponentLast);
                        updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);

                        // SECOND-TO-LAST
                        DrinkComponent drinkComponentToAdd = null;
                        if (drinkComponentSelected instanceof ColdFoam) {
                            Log.i(TAG, "drinkComponentSelected instanceof ColdFoam");
                            drinkComponentToAdd = new ColdFoam(null, Granular.Amount.MEDIUM);
                        } else if (drinkComponentSelected instanceof Drizzle) {
                            Log.i(TAG, "drinkComponentSelected instanceof Drizzle");
                            drinkComponentToAdd = new Drizzle(null, Granular.Amount.MEDIUM);
                        } else if (drinkComponentSelected instanceof Topping) {
                            Log.i(TAG, "drinkComponentSelected instanceof Topping");
                            drinkComponentToAdd = new Topping(null, Granular.Amount.MEDIUM);
                        }
                        drinkComponentToAdd.setTypeByString(nameDrinkComponentToAdd);
                        String drinkComponentDefaultAsStringToAdd = Granular.Amount.NO.name();

                        drinkComponents.add(indexSelected, drinkComponentToAdd);
                        drinkComponentsDefaultAsString.add(indexSelected, drinkComponentDefaultAsStringToAdd);
                        notifyItemInserted(indexSelected);
                    } else {
                        Log.i(TAG, "enumValuesNotInsideDrink.size() != 2");

                        DrinkComponent drinkComponentToAdd = null;
                        if (drinkComponentSelected instanceof ColdFoam) {
                            Log.i(TAG, "drinkComponentSelected instanceof ColdFoam");
                            drinkComponentToAdd = new ColdFoam(null, Granular.Amount.MEDIUM);
                        } else if (drinkComponentSelected instanceof Drizzle) {
                            Log.i(TAG, "drinkComponentSelected instanceof Drizzle");
                            drinkComponentToAdd = new Drizzle(null, Granular.Amount.MEDIUM);
                        } else if (drinkComponentSelected instanceof Topping) {
                            Log.i(TAG, "drinkComponentSelected instanceof Topping");
                            drinkComponentToAdd = new Topping(null, Granular.Amount.MEDIUM);
                        }
                        drinkComponentToAdd.setTypeByString(name);
                        String drinkComponentDefaultAsStringToAdd = Granular.Amount.NO.name();

                        drinkComponents.add(indexSelected, drinkComponentToAdd);
                        drinkComponentsDefaultAsString.add(indexSelected, drinkComponentDefaultAsStringToAdd);
                        notifyItemInserted(indexSelected);
                    }
                } else {
                    Log.i(TAG, "NOT drinkComponentSelected instanceof ToppingOptions");

                    // Update the underlying model.
                    drinkComponentSelected.setTypeByString(name);
                    updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
                }
            } else {
                Log.i(TAG, "NOT drinkComponentSelected.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING)");

                Granular.Amount amountSelected = null;
                for (int i = 0; i < Granular.Amount.values().length; i++) {
                    if (name.equals(Granular.Amount.values()[i].name())) {
                        amountSelected = Granular.Amount.values()[i];
                        break;
                    }
                }

                // Update the underlying model.
                ((Granular) drinkComponentSelected).setAmount(amountSelected);
                updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
            }
        } else {
            Log.i(TAG, "drinkComponentSelected NOT instanceof Incrementable nor Granular");

            // Update the underlying model.
            drinkComponentSelected.setTypeByString(name);
            updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
        }
    }

    @Override
    protected void handleClickForViewHolderIncrementable() {
        super.handleClickForViewHolderIncrementable();
        Log.i(TAG, "handleClickForViewHolderIncrementable()");

        if (listener == null) {
            Log.e(TAG, "listener == null");
            return;
        }

        DrinkComponent drinkComponentSelected = drinkComponents.get(indexSelected);
        String drinkComponentDefaultAsStringSelected = drinkComponentsDefaultAsString.get(indexSelected);
        int quantity = ((Incrementable) drinkComponentSelected).getQuantity();

        if (quantity == Incrementable.QUANTITY_FOR_INVOKER) {
            Log.i(TAG, "quantity == Incrementable.QUANTITY_FOR_INVOKER");

            String[] enumValues = drinkComponentSelected.getEnumValuesAsStringArray();
            if (enumValues.length == 1) {
                Log.i(TAG, "enumValues.length == 1");

                drinkComponentSelected.setTypeByString(enumValues[0]);
                ((Incrementable) drinkComponentSelected).setQuantity(1);
                updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
            } else {
                Log.i(TAG, "enumValues.length != 1");

                List<String> enumValuesFiltered = new ArrayList<>();
                for (String enumValueAsString : enumValues) {
                    boolean isInsideDrink = false;

                    for (DrinkComponent drinkComponent : drinkComponents) {
                        if (enumValueAsString.equals(drinkComponent.getTypeAsString())) {
                            isInsideDrink = true;
                        }
                    }

                    if (!isInsideDrink) {
                        enumValuesFiltered.add(enumValueAsString);
                    }
                }

                // TODO: redo below check (move to after making the second-to-last selection),
                //  maybe do a check here for (enumValuesFiltered.size() == 2) [second to last]...
                //  but potential the user doesn't select (they may [dismiss] the bottom sheet).

                // TODO: below check is NEEDED. but still have another check after making
                //  second-to-last selection. Think through DrinkComponent with 3 Type values...
                //  (1) all 3 already inside drink    |  enumValuesFiltered.size() == 0
                //  (2) 2 already inside drink, 1 not |  enumValuesFiltered.size() == 1
                //  (3) 1 already inside drink, 2 not |  enumValuesFiltered.size() == 2 (potential second-to-last)
                //  (4) none inside drink, 3 not      |  enumValuesFiltered.size() == 3
                if (enumValuesFiltered.size() == 1) {
                    drinkComponentSelected.setTypeByString(enumValuesFiltered.get(0));
                    ((Incrementable) drinkComponentSelected).setQuantity(1);
                    updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
                } else {
                    listener.onItemClicked(enumValuesFiltered.toArray(new String[0]), drinkComponentDefaultAsStringSelected);
                }
            }
        } else {
            Log.i(TAG, "quantity != Incrementable.QUANTITY_FOR_INVOKER");
        }
    }
}
