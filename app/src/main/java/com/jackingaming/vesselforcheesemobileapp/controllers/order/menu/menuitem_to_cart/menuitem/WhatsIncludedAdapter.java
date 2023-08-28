package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem_to_cart.menuitem;

import android.util.Log;

import com.jackingaming.vesselforcheesemobileapp.models.components.Granular;
import com.jackingaming.vesselforcheesemobileapp.models.components.GranularTwoOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.Incrementable;
import com.jackingaming.vesselforcheesemobileapp.models.components.MixedType;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.LineTheCup;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.blended_options.BlendedPrep;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.cup_options.CupSize;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.MilkBaseAllowable;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.preparation_options.PreparationMethod;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.tea_options.Extras;
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
        this.drinkComponents = generateWhatsIncluded(drink);
        this.drinkComponentsStandardRecipe = drink.getDrinkComponentsStandardRecipe();
    }

    private List<DrinkComponentWithDefaultAsString> generateWhatsIncluded(Drink drink) {
        Map<String, List<DrinkComponentWithDefaultAsString>> drinkComponentGroups = drink.getDrinkComponents();
        List<DrinkComponent> drinkComponentsStandardRecipe = drink.getDrinkComponentsStandardRecipe();
        List<DrinkComponentWithDefaultAsString> drinkComponentsWhatsIncluded = new ArrayList<>();
        Log.i(TAG, "!!!!!creating drinkComponentsWhatsIncluded!!!!!");
        for (int i = 0; i < Menu.DRINK_COMPONENTS_KEYS.size(); i++) {
            String key = Menu.DRINK_COMPONENTS_KEYS.get(i);
            if (drinkComponentGroups.containsKey(key)) {
                Log.i(TAG, i + "contains: " + Menu.DRINK_COMPONENTS_KEYS.get(i));
                List<DrinkComponentWithDefaultAsString> types = drinkComponentGroups.get(key);
                for (int j = 0; j < types.size(); j++) {
                    DrinkComponent drinkComponent = types.get(j).getDrinkComponent();
                    String drinkComponentDefault = types.get(j).getDrinkComponentDefaultAsString();

                    if (drinkComponentsStandardRecipe.contains(drinkComponent)) {
                        Log.e(TAG, "drinkComponentsStandardRecipe.contains(drinkComponent)");

                        if ((drinkComponent instanceof PreparationMethod && drinkComponent.getTypeAsString().equals(drinkComponentDefault)) ||
                                (drinkComponent instanceof MilkBaseAllowable && drinkComponent.getTypeAsString().equals(drinkComponentDefault)) ||
                                (drinkComponent instanceof BlendedPrep && drinkComponent.getTypeAsString().equals(drinkComponentDefault)) ||
                                (drinkComponent instanceof Extras && drinkComponent.getTypeAsString().equals(drinkComponentDefault)) ||
                                (drinkComponent instanceof LineTheCup && drinkComponent.getTypeAsString().equals(drinkComponentDefault)) ||
                                (drinkComponent instanceof CupSize && drinkComponent.getTypeAsString().equals(drinkComponentDefault))) {
                            Log.i(TAG, "skipping - (drinkComponent instanceof PreparationMethod && drinkComponent.getTypeAsString().equals(drinkComponentDefault)) || (drinkComponent instanceof LineTheCup && drinkComponent.getTypeAsString().equals(drinkComponentDefault)) || (drinkComponent instanceof CupSize && drinkComponent.getTypeAsString().equals(drinkComponentDefault)) - drinkComponent.getClassAsStrings(): " + drinkComponent.getClassAsString());
                            continue;
                        }

                        Log.i(TAG, "adding - drinkComponent.getClassAsString(): " + drinkComponent.getClassAsString());
                        DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsString = new DrinkComponentWithDefaultAsString(
                                drinkComponent, drinkComponentDefault
                        );
                        drinkComponentsWhatsIncluded.add(drinkComponentWithDefaultAsString);
                    } else {
                        Log.e(TAG, "NOT drinkComponentsStandardRecipe.contains(drinkComponent)");

                        if (drinkComponent.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING)) {
                            Log.i(TAG, "skipping - drinkComponent.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING) - drinkComponent.getClassAsString(): " + drinkComponent.getClassAsString());
                            continue;
                        } else if (drinkComponent instanceof Granular) {
                            if (drinkComponent instanceof GranularTwoOptions) {
                                GranularTwoOptions.Option option = ((GranularTwoOptions) drinkComponent).getOption();

                                if (option == GranularTwoOptions.Option.STANDARD) {
                                    Log.i(TAG, "skipping - option == GranularTwoOptions.Option.NO - drinkComponent.getClassAsString(): " + drinkComponent.getClassAsString());
                                    continue;
                                }
                            } else {
                                Granular.Amount amount = ((Granular) drinkComponent).getAmount();

                                if (amount == Granular.Amount.NO) {
                                    Log.i(TAG, "skipping - amount == Granular.Amount.NO - drinkComponent.getClassAsString(): " + drinkComponent.getClassAsString());
                                    continue;
                                }
                            }
                        } else if (drinkComponent instanceof Incrementable) {
                            int quantity = ((Incrementable) drinkComponent).getQuantity();

                            if (quantity == Incrementable.QUANTITY_FOR_INVOKER) {
                                Log.i(TAG, "skipping - quantity == DrinkComponent.QUANTITY_FOR_INVOKER - drinkComponent.getClassAsString(): " + drinkComponent.getClassAsString());
                                continue;
                            }
                        }

                        Log.i(TAG, "adding - drinkComponent.getClassAsString(): " + drinkComponent.getClassAsString());
                        DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsString = new DrinkComponentWithDefaultAsString(
                                drinkComponent, drinkComponentDefault
                        );
                        drinkComponentsWhatsIncluded.add(drinkComponentWithDefaultAsString);
                    }
                }
            } else {
                Log.i(TAG, i + "!contains: " + Menu.DRINK_COMPONENTS_KEYS.get(i));
            }
        }
        return drinkComponentsWhatsIncluded;
    }

    @Override
    protected void handleSelectionOfDefaultForStandardRecipe(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected, String name) {
        Log.i(TAG, "handleSelectionOfDefaultForStandardRecipe()");

        if (drinkComponentSelected instanceof Incrementable) {
            Log.i(TAG, "drinkComponentSelected instanceof Incrementable");

            // Update the underlying model.
            drinkComponentSelected.setTypeByString(name);
            notifyItemChanged(indexSelected);
        } else if (drinkComponentSelected instanceof Granular) {
            Log.i(TAG, "drinkComponentSelected instanceof Granular");

            if (drinkComponentSelected instanceof GranularTwoOptions) {
                Log.i(TAG, "drinkComponentSelected instanceof GranularTwoOptions");

                GranularTwoOptions.Option optionSelected = null;
                for (int i = 0; i < GranularTwoOptions.Option.values().length; i++) {
                    if (name.equals(GranularTwoOptions.Option.values()[i].name())) {
                        optionSelected = GranularTwoOptions.Option.values()[i];
                        break;
                    }
                }

                // Update the underlying model.
                ((GranularTwoOptions) drinkComponentSelected).setOption(optionSelected);
                notifyItemChanged(indexSelected);
            } else {
                Log.i(TAG, "drinkComponentSelected NOT instanceof GranularTwoOptions");

                Granular.Amount amountSelected = null;
                for (int i = 0; i < Granular.Amount.values().length; i++) {
                    if (name.equals(Granular.Amount.values()[i].name())) {
                        amountSelected = Granular.Amount.values()[i];
                        break;
                    }
                }

                // Update the underlying model.
                ((Granular) drinkComponentSelected).setAmount(amountSelected);
                notifyItemChanged(indexSelected);
            }
        } else {
            Log.i(TAG, "drinkComponentSelected NOT instanceof Incrementable nor Granular");

            // Update the underlying model.
            drinkComponentSelected.setTypeByString(name);

            if (drinkComponentSelected instanceof PreparationMethod ||
                    drinkComponentSelected instanceof MilkBaseAllowable ||
                    drinkComponentSelected instanceof BlendedPrep ||
                    drinkComponentSelected instanceof Extras ||
                    drinkComponentSelected instanceof LineTheCup ||
                    drinkComponentSelected instanceof CupSize) {
                drinkComponents.remove(indexSelected);
                notifyItemRemoved(indexSelected);
            } else {
                notifyItemChanged(indexSelected);
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
            notifyItemRemoved(indexSelected);
        } else if (drinkComponentSelected instanceof Granular) {
            Log.i(TAG, "drinkComponentSelected instanceof Granular");

            if (drinkComponentSelected instanceof GranularTwoOptions) {
                Log.i(TAG, "drinkComponentSelected instanceof GranularTwoOptions");

                String[] enumValues = drinkComponentSelected.getEnumValuesAsStringArray();
                List<String> enumValuesNotInsideDrink = findEnumValuesNotInsideDrink(enumValues);

                if (enumValuesNotInsideDrink.size() == 0) {
                    Log.i(TAG, "enumValuesNotInsideDrink.size() == 0");

                    // Update the underlying model.
                    ((GranularTwoOptions) drinkComponentSelected).setOption(GranularTwoOptions.Option.STANDARD);
                } else {
                    Log.i(TAG, "enumValuesNotInsideDrink.size() != 0");

                    // Update the underlying model.
                    drinkComponentSelected.setTypeByString(DrinkComponent.NULL_TYPE_AS_STRING);
                    ((GranularTwoOptions) drinkComponentSelected).setOption(GranularTwoOptions.Option.STANDARD);
                }

                drinkComponents.remove(indexSelected);
                notifyItemRemoved(indexSelected);
            } else {
                Log.i(TAG, "drinkComponentSelected NOT instanceof GranularTwoOptions");

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
                notifyItemRemoved(indexSelected);
            }
        } else {
            Log.i(TAG, "drinkComponentSelected NOT instanceof Incrementable nor Granular");

            // Update the underlying model.
            drinkComponentSelected.setTypeByString(DrinkComponent.NULL_TYPE_AS_STRING);
            drinkComponents.remove(indexSelected);
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

            if (drinkComponentSelected instanceof GranularTwoOptions) {
                Log.i(TAG, "drinkComponentSelected instanceof GranularTwoOptions");

                GranularTwoOptions.Option optionSelected = null;
                for (int i = 0; i < GranularTwoOptions.Option.values().length; i++) {
                    if (name.equals(GranularTwoOptions.Option.values()[i].name())) {
                        optionSelected = GranularTwoOptions.Option.values()[i];
                        break;
                    }
                }

                // Update the underlying model.
                ((GranularTwoOptions) drinkComponentSelected).setOption(optionSelected);
            } else {
                Log.i(TAG, "drinkComponentSelected NOT instanceof GranularTwoOptions");

                Granular.Amount amountSelected = null;
                for (int i = 0; i < Granular.Amount.values().length; i++) {
                    if (name.equals(Granular.Amount.values()[i].name())) {
                        amountSelected = Granular.Amount.values()[i];
                        break;
                    }
                }

                // Update the underlying model.
                ((Granular) drinkComponentSelected).setAmount(amountSelected);
            }
        } else {
            Log.i(TAG, "drinkComponentSelected NOT instanceof Incrementable nor Granular");

            // Update the underlying model.
            drinkComponentSelected.setTypeByString(name);
        }

        notifyItemChanged(indexSelected);
    }
}
