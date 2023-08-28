package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem_to_cart.customize;

import android.util.Log;

import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem_to_cart.menuitem.DrinkComponentBaseAdapter;
import com.jackingaming.vesselforcheesemobileapp.models.components.Granular;
import com.jackingaming.vesselforcheesemobileapp.models.components.GranularTwoOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.Incrementable;
import com.jackingaming.vesselforcheesemobileapp.models.components.MixedType;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.mixed_type.fruits.base.Fruits;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.mixed_type.fruits.derived.FruitInclusion;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.mixed_type.fruits.derived.StrawberryPuree;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.mixed_type.powders.base.Powders;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.mixed_type.powders.derived.ChocolateMaltPowder;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.mixed_type.powders.derived.VanillaBeanPowder;

import java.util.ArrayList;
import java.util.List;

public class CustomizeInnerAdapter extends DrinkComponentBaseAdapter {
    public static final String TAG = CustomizeInnerAdapter.class.getSimpleName();

    public CustomizeInnerAdapter(List<DrinkComponentWithDefaultAsString> drinkComponents, List<DrinkComponent> drinkComponentsStandardRecipe, DrinkComponentBaseAdapterListener listener) {
        super(drinkComponents, drinkComponentsStandardRecipe, listener);
    }

    @Override
    protected void handleSelectionOfDefaultForStandardRecipe(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected, String name) {
        Log.i(TAG, "handleSelectionOfDefaultForStandardRecipe()");

        handleSelectionOfEverythingElse(drinkComponentSelected,
                drinkComponentDefaultAsStringSelected, name);
    }

    @Override
    protected void handleSelectionOfNonDefaultForStandardRecipe(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected, String name) {
        Log.i(TAG, "handleSelectionOfNonDefaultForStandardRecipe()");

        handleSelectionOfEverythingElse(drinkComponentSelected,
                drinkComponentDefaultAsStringSelected, name);
    }

    private void handleSelectionOfDefaultForAllowableGranular(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected) {
        Log.i(TAG, "handleSelectionOfDefaultForAllowableGranular(DrinkComponent, String)");

        if (drinkComponentSelected instanceof GranularTwoOptions) {
            Log.i(TAG, "drinkComponentSelected instanceof GranularTwoOptions");

            String[] enumValues = drinkComponentSelected.getEnumValuesAsStringArray();
            List<String> enumValuesNotInsideDrink = findEnumValuesNotInsideDrink(enumValues);
            if (enumValuesNotInsideDrink.size() == 0) {
                Log.i(TAG, "enumValuesNotInsideDrink.size() == 0");

                // Update the underlying model.
                drinkComponentSelected.setTypeByString(DrinkComponent.NULL_TYPE_AS_STRING);
                ((GranularTwoOptions) drinkComponentSelected).setOption(GranularTwoOptions.Option.STANDARD);
                notifyItemChanged(indexSelected);
            } else {
                Log.i(TAG, "enumValuesNotInsideDrink.size() != 0");

                // Update the underlying model.
                drinkComponentSelected.setTypeByString(DrinkComponent.NULL_TYPE_AS_STRING);
                ((GranularTwoOptions) drinkComponentSelected).setOption(GranularTwoOptions.Option.STANDARD);
                drinkComponents.remove(indexSelected);
                notifyItemRemoved(indexSelected);
            }
        } else {
            Log.i(TAG, "drinkComponentSelected NOT instanceof GranularTwoOptions");

            String[] enumValues = drinkComponentSelected.getEnumValuesAsStringArray();
            List<String> enumValuesNotInsideDrink = findEnumValuesNotInsideDrink(enumValues);
            if (enumValuesNotInsideDrink.size() == 0) {
                Log.i(TAG, "enumValuesNotInsideDrink.size() == 0");

                // Update the underlying model.
                drinkComponentSelected.setTypeByString(DrinkComponent.NULL_TYPE_AS_STRING);
                ((Granular) drinkComponentSelected).setAmount(Granular.Amount.NO);
                notifyItemChanged(indexSelected);
            } else {
                Log.i(TAG, "enumValuesNotInsideDrink.size() != 0");

                // Update the underlying model.
                drinkComponentSelected.setTypeByString(DrinkComponent.NULL_TYPE_AS_STRING);
                ((Granular) drinkComponentSelected).setAmount(Granular.Amount.NO);
                drinkComponents.remove(indexSelected);
                notifyItemRemoved(indexSelected);
            }
        }
    }

    @Override
    protected void handleSelectionOfDefaultForAllowable(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected, String name) {
        Log.i(TAG, "handleSelectionOfDefaultForAllowable()");

        if (drinkComponentSelected instanceof Incrementable) {
            Log.i(TAG, "drinkComponentSelected instanceof Incrementable");

            if (drinkComponentSelected instanceof MixedType) {
                Log.i(TAG, "drinkComponentSelected instanceof MixedType");

                // Intentionally blank.
                return;
            }

            // Update the underlying model.
            ((Incrementable) drinkComponentSelected).setQuantity(Incrementable.QUANTITY_FOR_INVOKER);
            notifyItemChanged(indexSelected);
        } else if (drinkComponentSelected instanceof Granular) {
            Log.i(TAG, "drinkComponentSelected instanceof Granular");

            if (drinkComponentSelected instanceof MixedType) {
                Log.i(TAG, "drinkComponentSelected instanceof MixedType");

                // Update the underlying model.
                drinkComponentSelected.setTypeByString(DrinkComponent.NULL_TYPE_AS_STRING);
                ((Granular) drinkComponentSelected).setAmount(Granular.Amount.NO);
                notifyItemChanged(indexSelected);
                // TODO:

                return;
            }

            handleSelectionOfDefaultForAllowableGranular(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
        } else {
            Log.i(TAG, "drinkComponentSelected NOT instanceof Incrementable nor Granular");

            // Update the underlying model.
            drinkComponentSelected.setTypeByString(DrinkComponent.NULL_TYPE_AS_STRING);
            notifyItemChanged(indexSelected);
        }
    }

    @Override
    protected void handleSelectionOfNonDefaultForAllowable(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected, String name) {
        Log.i(TAG, "handleSelectionOfNonDefaultForAllowable()");

        handleSelectionOfEverythingElse(drinkComponentSelected,
                drinkComponentDefaultAsStringSelected, name);
    }

    private void handleSelectionOfEverythingElse(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected, String name) {
        Log.i(TAG, "---> handleSelectionOfEverythingElse()");

        // TODO: Important to check for MixedType AFTER Incrementable and Granular.

        if (drinkComponentSelected instanceof Incrementable) {
            Log.i(TAG, "drinkComponentSelected instanceof Incrementable");

            // ADD USER'S SELECTION
            DrinkComponent drinkComponentToAdd =
                    ((Incrementable) drinkComponentSelected).newInstanceViaTypeAsString(name, 1);
            int drinkComponentDefaultAsStringToAdd = ((Incrementable) drinkComponentSelected).getQuantityMin();
            DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsStringToAdd =
                    new DrinkComponentWithDefaultAsString(
                            drinkComponentToAdd, Integer.toString(drinkComponentDefaultAsStringToAdd)
                    );
            drinkComponents.add(indexSelected, drinkComponentWithDefaultAsStringToAdd);
            notifyItemInserted(indexSelected);

            // CHECK CONDITION TO CONVERT "INVOKER" TO LAST OPTION
            String[] enumValues = drinkComponentSelected.getEnumValuesAsStringArray();
            List<String> enumValuesNotInsideDrink = findEnumValuesNotInsideDrink(enumValues);
            if (enumValuesNotInsideDrink.size() == 1) {
                drinkComponentSelected.setTypeByString(enumValuesNotInsideDrink.get(0));
                ((Incrementable) drinkComponentSelected).setQuantity(0);
                notifyItemChanged(indexSelected + 1);
            }
        } else if (drinkComponentSelected instanceof Granular) {
            Log.i(TAG, "drinkComponentSelected instanceof Granular");

            if (drinkComponentSelected instanceof GranularTwoOptions) {
                Log.i(TAG, "drinkComponentSelected instanceof GranularTwoOptions");

                if (drinkComponentSelected.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING)) {
                    Log.i(TAG, "drinkComponentSelected.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING)");

                    // ADD USER'S SELECTION
                    DrinkComponent drinkComponentToAdd =
                            ((GranularTwoOptions) drinkComponentSelected).newInstanceViaTypeAsString(name, null);
                    String drinkComponentDefaultAsStringToAdd = GranularTwoOptions.Option.STANDARD.name();
                    DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsStringToAdd =
                            new DrinkComponentWithDefaultAsString(
                                    drinkComponentToAdd, drinkComponentDefaultAsStringToAdd
                            );
                    drinkComponents.add(indexSelected, drinkComponentWithDefaultAsStringToAdd);
                    notifyItemInserted(indexSelected);

                    // CHECK CONDITION TO CONVERT "INVOKER" TO LAST OPTION
                    String[] enumValues = drinkComponentSelected.getEnumValuesAsStringArray();
                    List<String> enumValuesNotInsideDrink = findEnumValuesNotInsideDrink(enumValues);
                    if (enumValuesNotInsideDrink.size() == 1) {
                        drinkComponentSelected.setTypeByString(enumValuesNotInsideDrink.get(0));
                        ((GranularTwoOptions) drinkComponentSelected).setOption(GranularTwoOptions.Option.STANDARD);
                        notifyItemChanged(indexSelected + 1);
                    }
                } else {
                    Log.i(TAG, "NOT drinkComponentSelected.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING)");

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
                }
            } else {
                Log.i(TAG, "drinkComponentSelected NOT instanceof GranularTwoOptions");

                if (drinkComponentSelected.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING)) {
                    Log.i(TAG, "drinkComponentSelected.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING)");

                    // ADD USER'S SELECTION
                    DrinkComponent drinkComponentToAdd =
                            ((Granular) drinkComponentSelected).newInstanceViaTypeAsString(name, Granular.Amount.MEDIUM);
                    String drinkComponentDefaultAsStringToAdd = Granular.Amount.NO.name();
                    DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsStringToAdd =
                            new DrinkComponentWithDefaultAsString(
                                    drinkComponentToAdd, drinkComponentDefaultAsStringToAdd
                            );
                    drinkComponents.add(indexSelected, drinkComponentWithDefaultAsStringToAdd);
                    notifyItemInserted(indexSelected);

                    // CHECK CONDITION TO CONVERT "INVOKER" TO LAST OPTION
                    String[] enumValues = drinkComponentSelected.getEnumValuesAsStringArray();
                    List<String> enumValuesNotInsideDrink = findEnumValuesNotInsideDrink(enumValues);
                    if (enumValuesNotInsideDrink.size() == 1) {
                        drinkComponentSelected.setTypeByString(enumValuesNotInsideDrink.get(0));
                        ((Granular) drinkComponentSelected).setAmount(Granular.Amount.NO);
                        notifyItemChanged(indexSelected + 1);
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
                    notifyItemChanged(indexSelected);
                }
            }
        } else if (drinkComponentSelected instanceof MixedType) {
            Log.i(TAG, "drinkComponentSelected instanceof MixedType");
            // ABOVE: [MixedType] "non-invokers" (within [Incrementable] and [Granular]).
            // BELOW: [MixedType] "invoker".

            DrinkComponent drinkComponentToAdd = null;
            String drinkComponentDefaultAsStringToAdd = null;
            if (drinkComponentSelected instanceof Powders) {
                Log.i(TAG, "drinkComponentSelected instanceof Powders");

                for (String typeVanillaBeanPowder : VanillaBeanPowder.getEnumValuesAsStringForMixedType()) {
                    if (name.equals(typeVanillaBeanPowder)) {
                        // TODO: quantity should depend on DrinkSize
                        drinkComponentToAdd = new VanillaBeanPowder(null, 1);
                        drinkComponentToAdd.setTypeByString(name);
                        drinkComponentDefaultAsStringToAdd = Integer.toString(0);
                    }
                }
                for (String typeChocolateMaltPowder : ChocolateMaltPowder.getEnumValuesAsStringForMixedType()) {
                    if (name.equals(typeChocolateMaltPowder)) {
                        drinkComponentToAdd = new ChocolateMaltPowder(null, Granular.Amount.MEDIUM);
                        drinkComponentToAdd.setTypeByString(name);
                        drinkComponentDefaultAsStringToAdd = Granular.Amount.NO.name();
                    }
                }
                DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsStringToAdd =
                        new DrinkComponentWithDefaultAsString(
                                drinkComponentToAdd, drinkComponentDefaultAsStringToAdd
                        );
                drinkComponents.add(indexSelected, drinkComponentWithDefaultAsStringToAdd);
                notifyItemInserted(indexSelected);

                // TODO: account for AddInsOptions -> Powders
                //  that are already inside the drink
                //  (compared to how many types that are NOT inside).

                // CHECK IF LAST OPTION CONDITION
                List<String> drinkComponentsAsStringAlreadyInsideDrink = new ArrayList<>();
                for (DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsString : drinkComponents) {
                    DrinkComponent drinkComponentInsideDrink = drinkComponentWithDefaultAsString.getDrinkComponent();
                    if (drinkComponentInsideDrink instanceof Powders) {
                        if (drinkComponentInsideDrink instanceof Incrementable) {
                            Log.i(TAG, "drinkComponentInsideDrink instanceof Incrementable");
                            // Incrementable
                            if (((Incrementable) drinkComponentInsideDrink).getQuantity() > 0) {
                                Log.i(TAG, "((Incrementable) drinkComponentInsideDrink).getQuantity() > 0 --- drinkComponentsAsStringAlreadyInsideDrink.add(drinkComponentInsideDrink)");
                                drinkComponentsAsStringAlreadyInsideDrink.add(drinkComponentInsideDrink.getTypeAsString());
                            } else {
                                Log.i(TAG, "((Incrementable) drinkComponentInsideDrink).getQuantity() <= 0 --- skip");
                                continue;
                            }
                        } else if (drinkComponentInsideDrink instanceof Granular) {
                            Log.i(TAG, "drinkComponentInsideDrink instanceof Granular");
                            // Granular
                            if (((Granular) drinkComponentInsideDrink).getAmount() != Granular.Amount.NO) {
                                Log.i(TAG, "((Granular) drinkComponentInsideDrink).getAmount() != Granular.Amount.NO --- drinkComponentsAsStringAlreadyInsideDrink.add(drinkComponentInsideDrink)");
                                drinkComponentsAsStringAlreadyInsideDrink.add(drinkComponentInsideDrink.getTypeAsString());
                            } else {
                                Log.i(TAG, "((Granular) drinkComponentInsideDrink).getAmount() == Granular.Amount.NO --- skip");
                                continue;
                            }
                        } else {
                            Log.e(TAG, "drinkComponentInsideDrink NOT instanceof Incrementable nor Granular");
                            continue;
                        }
                    }
                }
                int numberOfTypeTotal = Powders.Type.values().length;
                int numberOfTypeAlreadyInsideDrink = drinkComponentsAsStringAlreadyInsideDrink.size();
                Log.e(TAG, "numberOfTypeTotal: " + numberOfTypeTotal);
                Log.e(TAG, "numberOfTypeAlreadyInsideDrink: " + numberOfTypeAlreadyInsideDrink);

                boolean lastOption = (numberOfTypeTotal - numberOfTypeAlreadyInsideDrink) == 1;
                // FIND LAST OPTION
                if (lastOption) {
                    Log.i(TAG, "lastOption");

                    DrinkComponent drinkComponentNotInsideDrink = null;
                    String drinkComponentDefaultNotInsideDrink = null;
                    for (String typeVanillaBeanPowder : VanillaBeanPowder.getEnumValuesAsStringForMixedType()) {
                        boolean isInside = false;
                        for (String drinkComponentAsStringAlreadyInsideDrink : drinkComponentsAsStringAlreadyInsideDrink) {
                            if (typeVanillaBeanPowder.equals(drinkComponentAsStringAlreadyInsideDrink)) {
                                isInside = true;
                            }
                        }
                        if (!isInside) {
                            Log.i(TAG, "lastOption found: " + typeVanillaBeanPowder + "... breaking out of for-loop");
                            drinkComponentNotInsideDrink = new VanillaBeanPowder(null, 0);
                            drinkComponentNotInsideDrink.setTypeByString(typeVanillaBeanPowder);
                            drinkComponentDefaultNotInsideDrink = Integer.toString(0);
                            break;
                        }
                    }
                    for (String typeChocolateMaltPowder : ChocolateMaltPowder.getEnumValuesAsStringForMixedType()) {
                        boolean isInside = false;
                        for (String drinkComponentAsStringAlreadyInsideDrink : drinkComponentsAsStringAlreadyInsideDrink) {
                            if (typeChocolateMaltPowder.equals(drinkComponentAsStringAlreadyInsideDrink)) {
                                isInside = true;
                            }
                        }
                        if (!isInside) {
                            Log.i(TAG, "lastOption found: " + typeChocolateMaltPowder + "... breaking out of for-loop");
                            drinkComponentNotInsideDrink = new ChocolateMaltPowder(null, Granular.Amount.NO);
                            drinkComponentNotInsideDrink.setTypeByString(typeChocolateMaltPowder);
                            drinkComponentDefaultNotInsideDrink = Granular.Amount.NO.name();
                            break;
                        }
                    }
                    Log.e(TAG, "drinkComponentNotInsideDrink: " + drinkComponentNotInsideDrink.getTypeAsString());

                    // TURN "invoker" INTO LAST OPTION
                    DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsString =
                            new DrinkComponentWithDefaultAsString(
                                    drinkComponentNotInsideDrink, drinkComponentDefaultNotInsideDrink
                            );
                    drinkComponents.set(indexSelected + 1, drinkComponentWithDefaultAsString);
                    notifyItemChanged(indexSelected + 1);
                } else {
                    Log.i(TAG, "NOT lastOption");
                }
            } else if (drinkComponentSelected instanceof Fruits) {
                Log.i(TAG, "drinkComponentSelected instanceof Fruits");

                for (String typeFruitInclusion : FruitInclusion.getEnumValuesAsStringForMixedType()) {
                    if (name.equals(typeFruitInclusion)) {
                        // TODO: quantity should depend on DrinkSize
                        drinkComponentToAdd = new FruitInclusion(null, 1);
                        drinkComponentToAdd.setTypeByString(name);
                        drinkComponentDefaultAsStringToAdd = Integer.toString(0);
                    }
                }
                for (String typeStrawberryPuree : StrawberryPuree.getEnumValuesAsStringForMixedType()) {
                    if (name.equals(typeStrawberryPuree)) {
                        drinkComponentToAdd = new StrawberryPuree(null, Granular.Amount.MEDIUM);
                        drinkComponentToAdd.setTypeByString(name);
                        drinkComponentDefaultAsStringToAdd = Granular.Amount.NO.name();
                    }
                }
                DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsString =
                        new DrinkComponentWithDefaultAsString(
                                drinkComponentToAdd, drinkComponentDefaultAsStringToAdd
                        );
                drinkComponents.add(indexSelected, drinkComponentWithDefaultAsString);
                notifyItemInserted(indexSelected);

                // CHECK IF LAST OPTION CONDITION
                List<String> drinkComponentsAsStringAlreadyInsideDrink = new ArrayList<>();
                for (DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsStringInsideDrink : drinkComponents) {
                    DrinkComponent drinkComponentInsideDrink = drinkComponentWithDefaultAsStringInsideDrink.getDrinkComponent();
                    if (drinkComponentInsideDrink instanceof Fruits) {
                        if (drinkComponentInsideDrink instanceof Incrementable) {
                            Log.i(TAG, "drinkComponentInsideDrink instanceof Incrementable");
                            // Incrementable
                            if (((Incrementable) drinkComponentInsideDrink).getQuantity() > 0) {
                                Log.i(TAG, "((Incrementable) drinkComponentInsideDrink).getQuantity() > 0 --- drinkComponentsAsStringAlreadyInsideDrink.add(drinkComponentInsideDrink)");
                                drinkComponentsAsStringAlreadyInsideDrink.add(drinkComponentInsideDrink.getTypeAsString());
                            } else {
                                Log.i(TAG, "((Incrementable) drinkComponentInsideDrink).getQuantity() <= 0 --- skip");
                                continue;
                            }
                        } else if (drinkComponentInsideDrink instanceof Granular) {
                            Log.i(TAG, "drinkComponentInsideDrink instanceof Granular");
                            // Granular
                            if (((Granular) drinkComponentInsideDrink).getAmount() != Granular.Amount.NO) {
                                Log.i(TAG, "((Granular) drinkComponentInsideDrink).getAmount() != Granular.Amount.NO --- drinkComponentsAsStringAlreadyInsideDrink.add(drinkComponentInsideDrink)");
                                drinkComponentsAsStringAlreadyInsideDrink.add(drinkComponentInsideDrink.getTypeAsString());
                            } else {
                                Log.i(TAG, "((Granular) drinkComponentInsideDrink).getAmount() == Granular.Amount.NO --- skip");
                                continue;
                            }
                        } else {
                            Log.e(TAG, "drinkComponentInsideDrink NOT instanceof Incrementable nor Granular");
                            continue;
                        }
                    }
                }
                int numberOfTypeTotal = Fruits.Type.values().length;
                int numberOfTypeAlreadyInsideDrink = drinkComponentsAsStringAlreadyInsideDrink.size();
                Log.e(TAG, "numberOfTypeTotal: " + numberOfTypeTotal);
                Log.e(TAG, "numberOfTypeAlreadyInsideDrink: " + numberOfTypeAlreadyInsideDrink);

                boolean lastOption = (numberOfTypeTotal - numberOfTypeAlreadyInsideDrink) == 1;
                // FIND LAST OPTION
                if (lastOption) {
                    Log.i(TAG, "lastOption");

                    DrinkComponent drinkComponentNotInsideDrink = null;
                    String drinkComponentDefaultNotInsideDrink = null;
                    for (String typeFruitInclusion : FruitInclusion.getEnumValuesAsStringForMixedType()) {
                        boolean isInside = false;
                        for (String drinkComponentAsStringAlreadyInsideDrink : drinkComponentsAsStringAlreadyInsideDrink) {
                            if (typeFruitInclusion.equals(drinkComponentAsStringAlreadyInsideDrink)) {
                                isInside = true;
                            }
                        }
                        if (!isInside) {
                            Log.i(TAG, "lastOption found: " + typeFruitInclusion + "... breaking out of for-loop");
                            drinkComponentNotInsideDrink = new FruitInclusion(null, 0);
                            drinkComponentNotInsideDrink.setTypeByString(typeFruitInclusion);
                            drinkComponentDefaultNotInsideDrink = Integer.toString(0);
                            break;
                        }
                    }
                    for (String typeStrawberryPuree : StrawberryPuree.getEnumValuesAsStringForMixedType()) {
                        boolean isInside = false;
                        for (String drinkComponentAsStringAlreadyInsideDrink : drinkComponentsAsStringAlreadyInsideDrink) {
                            if (typeStrawberryPuree.equals(drinkComponentAsStringAlreadyInsideDrink)) {
                                isInside = true;
                            }
                        }
                        if (!isInside) {
                            Log.i(TAG, "lastOption found: " + typeStrawberryPuree + "... breaking out of for-loop");
                            drinkComponentNotInsideDrink = new StrawberryPuree(null, Granular.Amount.NO);
                            drinkComponentNotInsideDrink.setTypeByString(typeStrawberryPuree);
                            drinkComponentDefaultNotInsideDrink = Granular.Amount.NO.name();
                            break;
                        }
                    }
                    Log.e(TAG, "drinkComponentNotInsideDrink: " + drinkComponentNotInsideDrink.getTypeAsString());

                    // TURN "invoker" INTO LAST OPTION
                    DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsStringNotInsideDrink =
                            new DrinkComponentWithDefaultAsString(
                                    drinkComponentNotInsideDrink, drinkComponentDefaultNotInsideDrink
                            );
                    drinkComponents.set(indexSelected + 1, drinkComponentWithDefaultAsStringNotInsideDrink);
                    notifyItemChanged(indexSelected + 1);
                } else {
                    Log.i(TAG, "NOT lastOption");
                }
            } else {
                Log.e(TAG, "drinkComponentSelected NOT instanceof Powders nor Fruits");
            }
        } else {
            Log.i(TAG, "drinkComponentSelected NOT instanceof Incrementable nor Granular nor MixedType");

            // Update the underlying model.
            drinkComponentSelected.setTypeByString(name);
            notifyItemChanged(indexSelected);
        }
    }
}
