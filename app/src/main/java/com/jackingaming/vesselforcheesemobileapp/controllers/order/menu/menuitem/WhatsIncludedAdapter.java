package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem;

import android.util.Log;

import androidx.core.util.Pair;

import com.jackingaming.vesselforcheesemobileapp.models.components.Granular;
import com.jackingaming.vesselforcheesemobileapp.models.components.Incrementable;
import com.jackingaming.vesselforcheesemobileapp.models.components.MixedType;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.LineTheCup;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.cup_options.CupSize;
import com.jackingaming.vesselforcheesemobileapp.models.menu.Menu;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.Drink;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WhatsIncludedAdapter extends DrinkComponentBaseAdapter {
    public static final String TAG = WhatsIncludedAdapter.class.getSimpleName();

    public WhatsIncludedAdapter(Drink drink, DrinkComponentBaseAdapterListener listener) {
        init(drink);
        this.listener = listener;
    }

    public void init(Drink drink) {
        Pair<List<DrinkComponent>, List<String>> pairDefaultAndTypes = generateWhatsIncluded(drink);
        this.drinkComponents = pairDefaultAndTypes.first;
        this.drinkComponentsDefaultAsString = pairDefaultAndTypes.second;
        this.drinkComponentsStandardRecipe = drink.getDrinkComponentsStandardRecipe();
    }

    private Pair<List<DrinkComponent>, List<String>> generateWhatsIncluded(Drink drink) {
        Map<String, List<DrinkComponent>> drinkComponentGroups = drink.getDrinkComponents();
        Map<String, List<String>> drinkComponentGroupsDefaultAsString = drink.getDrinkComponentsDefaultAsString();
        List<DrinkComponent> drinkComponentsWhatsIncluded = new ArrayList<>();
        List<String> drinkComponentsWhatsIncludedDefaultAsString = new ArrayList<>();
        Log.i(TAG, "!!!!!creating drinkComponentsWhatsIncluded!!!!!");
        for (int i = 0; i < Menu.DRINK_COMPONENTS_KEYS.size(); i++) {
            String key = Menu.DRINK_COMPONENTS_KEYS.get(i);
            if (drinkComponentGroups.containsKey(key)) {
                Log.i(TAG, i + "contains: " + Menu.DRINK_COMPONENTS_KEYS.get(i));
                List<String> typesDefault = drinkComponentGroupsDefaultAsString.get(key);
                List<DrinkComponent> types = drinkComponentGroups.get(key);
                for (int j = 0; j < types.size(); j++) {
                    DrinkComponent drinkComponent = types.get(j);
                    String drinkComponentDefault = typesDefault.get(j);

                    if (drinkComponent.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING)) {
                        Log.i(TAG, "skipping - drinkComponent.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING)");
                        continue;
                    } else if (drinkComponent instanceof Granular) {
                        Granular.Amount amount = ((Granular) drinkComponent).getAmount();

                        if (amount == Granular.Amount.NO) {
                            Log.i(TAG, "skipping - amount == Granular.Amount.NO");
                            continue;
                        }
                    } else if (drinkComponent instanceof Incrementable) {
                        int quantity = ((Incrementable) drinkComponent).getQuantity();

                        if (quantity == Incrementable.QUANTITY_FOR_INVOKER) {
                            Log.i(TAG, "skipping - quantity == DrinkComponent.QUANTITY_FOR_INVOKER");
                            continue;
                        }
                    } else if (drinkComponent instanceof CupSize &&
                            drinkComponent.getTypeAsString().equals(drinkComponentDefault)) {
                        Log.i(TAG, "skipping - drinkComponent instanceof CupSize && drinkComponent.getTypeAsString().equals(drinkComponentDefault)");
                        continue;
                    } else if (drinkComponent instanceof LineTheCup &&
                            drinkComponent.getTypeAsString().equals(drinkComponentDefault)) {
                        Log.i(TAG, "skipping - drinkComponent instanceof LineTheCup && drinkComponent.getTypeAsString().equals(drinkComponentDefault)");
                        continue;
                    }

                    Log.i(TAG, "adding - drinkComponent.getTypeAsString(): " + drinkComponent.getTypeAsString());
                    drinkComponentsWhatsIncluded.add(drinkComponent);
                    drinkComponentsWhatsIncludedDefaultAsString.add(drinkComponentDefault);
                }
            } else {
                Log.i(TAG, i + "!contains: " + Menu.DRINK_COMPONENTS_KEYS.get(i));
            }
        }
        return new Pair<>(drinkComponentsWhatsIncluded, drinkComponentsWhatsIncludedDefaultAsString);
    }

    @Override
    protected void handleSelectionOfDefaultForStandardRecipe(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected, String name) {
        Log.i(TAG, "handleSelectionOfDefaultForStandardRecipe()");

        if (drinkComponentSelected instanceof Incrementable) {
            Log.i(TAG, "drinkComponentSelected instanceof Incrementable");

            // Update the underlying model.
            drinkComponentSelected.setTypeByString(name);
            updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
        } else if (drinkComponentSelected instanceof Granular) {
            Log.i(TAG, "drinkComponentSelected instanceof Granular");

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
        } else {
            Log.i(TAG, "drinkComponentSelected NOT instanceof Incrementable nor Granular");

            // Update the underlying model.
            drinkComponentSelected.setTypeByString(name);

            if (drinkComponentSelected instanceof CupSize ||
                    drinkComponentSelected instanceof LineTheCup) {
                drinkComponents.remove(indexSelected);
                drinkComponentsDefaultAsString.remove(indexSelected);
                notifyItemRemoved(indexSelected);
            } else {
                updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
            }
        }
    }

    @Override
    protected void handleSelectionOfNonDefaultForStandardRecipe(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected, String name) {
        Log.i(TAG, "handleSelectionOfNonDefaultForStandardRecipe()");

        handleSelectionOfNonDefault(drinkComponentSelected, drinkComponentDefaultAsStringSelected, name);
    }

    @Override
    protected void handleSelectionOfDefaultForAllowable(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected, String name) {
        Log.i(TAG, "handleSelectionOfDefaultForAllowable()");

        if (drinkComponentSelected instanceof Incrementable) {
            Log.i(TAG, "drinkComponentSelected instanceof Incrementable");

            if (drinkComponentSelected instanceof MixedType) {
                Log.i(TAG, "drinkComponentSelected instanceof MixedType");

                // Intentionally blank.
            }

            // Update the underlying model.
            ((Incrementable) drinkComponentSelected).setQuantity(Incrementable.QUANTITY_FOR_INVOKER);
            drinkComponents.remove(indexSelected);
            drinkComponentsDefaultAsString.remove(indexSelected);
            notifyItemRemoved(indexSelected);
        } else if (drinkComponentSelected instanceof Granular) {
            Log.i(TAG, "drinkComponentSelected instanceof Granular");

            if (drinkComponentSelected instanceof MixedType) {
                Log.i(TAG, "drinkComponentSelected instanceof MixedType");

                // Intentionally blank.
            }

            String[] enumValues = drinkComponentSelected.getEnumValuesAsStringArray();
            List<String> enumValuesNotInsideDrink = findEnumValuesNotInsideDrink(enumValues);

            if (enumValuesNotInsideDrink.size() == 0) {
                Log.i(TAG, "enumValuesNotInsideDrink.size() == 0");

                // Update the underlying model.
                ((Granular) drinkComponentSelected).setAmount(Granular.Amount.NO);
            } else {
                Log.i(TAG, "enumValuesNotInsideDrink.size() != 0");

                // Update the underlying model.
                drinkComponentSelected.setTypeByString(DrinkComponent.NULL_TYPE_AS_STRING);
                ((Granular) drinkComponentSelected).setAmount(Granular.Amount.NO);
            }

            drinkComponents.remove(indexSelected);
            drinkComponentsDefaultAsString.remove(indexSelected);
            notifyItemRemoved(indexSelected);
        } else {
            Log.i(TAG, "drinkComponentSelected NOT instanceof Incrementable nor Granular");

            // Update the underlying model.
            drinkComponentSelected.setTypeByString(DrinkComponent.NULL_TYPE_AS_STRING);
            drinkComponents.remove(indexSelected);
            drinkComponentsDefaultAsString.remove(indexSelected);
            notifyItemRemoved(indexSelected);
        }
    }

    @Override
    protected void handleSelectionOfNonDefaultForAllowable(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected, String name) {
        Log.i(TAG, "handleSelectionOfNonDefaultForAllowable()");

        handleSelectionOfNonDefault(drinkComponentSelected, drinkComponentDefaultAsStringSelected, name);
    }

    private void handleSelectionOfNonDefault(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected, String name) {
        Log.i(TAG, "---> handleSelectionOfNonDefault()");

        if (drinkComponentSelected instanceof Incrementable) {
            Log.i(TAG, "drinkComponentSelected instanceof Incrementable");

            // Update the underlying model.
            drinkComponentSelected.setTypeByString(name);
        } else if (drinkComponentSelected instanceof Granular) {
            Log.i(TAG, "drinkComponentSelected instanceof Granular");

            Granular.Amount amountSelected = null;
            for (int i = 0; i < Granular.Amount.values().length; i++) {
                if (name.equals(Granular.Amount.values()[i].name())) {
                    amountSelected = Granular.Amount.values()[i];
                    break;
                }
            }

            // Update the underlying model.
            ((Granular) drinkComponentSelected).setAmount(amountSelected);
        } else {
            Log.i(TAG, "drinkComponentSelected NOT instanceof Incrementable nor Granular");

            // Update the underlying model.
            drinkComponentSelected.setTypeByString(name);
        }

        updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
    }
}
