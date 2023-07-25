package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.customize;

import static com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.mixed_type.fruits.base.Fruits.Type.DRAGONFRUIT_FRUIT;
import static com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.mixed_type.fruits.base.Fruits.Type.PINEAPPLE_FRUIT;
import static com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.mixed_type.fruits.base.Fruits.Type.STRAWBERRY_FRUIT;
import static com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.mixed_type.fruits.base.Fruits.Type.STRAWBERRY_PUREE_FRUIT;

import android.util.Log;

import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.DrinkComponentBaseAdapter;
import com.jackingaming.vesselforcheesemobileapp.models.components.Granular;
import com.jackingaming.vesselforcheesemobileapp.models.components.Incrementable;
import com.jackingaming.vesselforcheesemobileapp.models.components.MixedType;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.mixed_type.fruits.base.Fruits;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.mixed_type.fruits.derived.FruitInclusion;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.mixed_type.fruits.derived.StrawberryPuree;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.mixed_type.powders.base.Powders;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.mixed_type.powders.derived.ChocolateMaltPowder;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.mixed_type.powders.derived.VanillaBeanPowder;
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
                updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
            } else {
                Log.i(TAG, "enumValuesNotInsideDrink.size() != 0");

                // Update the underlying model.
                drinkComponentSelected.setTypeByString(DrinkComponent.NULL_TYPE_AS_STRING);
                ((Granular) drinkComponentSelected).setAmount(Granular.Amount.NO);
                drinkComponents.remove(indexSelected);
                drinkComponentsDefaultAsString.remove(indexSelected);
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
            }

            // Update the underlying model.
            ((Incrementable) drinkComponentSelected).setQuantity(Incrementable.QUANTITY_FOR_INVOKER);
            updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
        } else if (drinkComponentSelected instanceof Granular) {
            Log.i(TAG, "drinkComponentSelected instanceof Granular");

            if (drinkComponentSelected instanceof MixedType) {
                Log.i(TAG, "drinkComponentSelected instanceof MixedType");

                // Update the underlying model.
                drinkComponentSelected.setTypeByString(DrinkComponent.NULL_TYPE_AS_STRING);
                ((Granular) drinkComponentSelected).setAmount(Granular.Amount.NO);
                updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
                // TODO:

                return;
            }

            handleSelectionOfDefaultForAllowableGranular(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
        } else {
            Log.i(TAG, "drinkComponentSelected NOT instanceof Incrementable nor Granular");

            // Update the underlying model.
            drinkComponentSelected.setTypeByString(DrinkComponent.NULL_TYPE_AS_STRING);
            updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
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

            if (drinkComponentSelected instanceof SweetenerOptions ||
                    drinkComponentSelected instanceof FlavorOptions) {
                Log.i(TAG, "drinkComponentSelected instanceof SweetenerOptions || drinkComponentSelected instanceof FlavorOptions");

                DrinkComponent drinkComponentToAdd = null;
                int drinkComponentDefaultAsStringToAdd = 0;
                if (drinkComponentSelected instanceof Liquid) {
                    drinkComponentToAdd = new Liquid(null, 1);
                    drinkComponentDefaultAsStringToAdd = Liquid.DEFAULT_QUANTITY_MIN;
                } else if (drinkComponentSelected instanceof Packet) {
                    drinkComponentToAdd = new Packet(null, 1);
                    drinkComponentDefaultAsStringToAdd = Packet.DEFAULT_QUANTITY_MIN;
                } else if (drinkComponentSelected instanceof Sauce) {
                    drinkComponentToAdd = new Sauce(null, 1);
                    drinkComponentDefaultAsStringToAdd = Sauce.DEFAULT_QUANTITY_MIN;
                } else if (drinkComponentSelected instanceof Syrup) {
                    drinkComponentToAdd = new Syrup(null, 1);
                    drinkComponentDefaultAsStringToAdd = Syrup.DEFAULT_QUANTITY_MIN;
                } else {
                    Log.e(TAG, "drinkComponentSelected NOT instanceof Liquid nor Packet nor Sauce nor Syrup");
                }
                drinkComponentToAdd.setTypeByString(name);

                drinkComponents.add(indexSelected, drinkComponentToAdd);
                drinkComponentsDefaultAsString.add(indexSelected, Integer.toString(drinkComponentDefaultAsStringToAdd));
                notifyItemInserted(indexSelected);
            } else {
                Log.i(TAG, "drinkComponentSelected NOT instanceof SweetenerOptions nor FlavorOptions");

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
                        String drinkComponentDefaultAsStringToAdd = null;
                        if (drinkComponentSelected instanceof ColdFoam) {
                            Log.i(TAG, "drinkComponentSelected instanceof ColdFoam");
                            drinkComponentToAdd = new ColdFoam(null, Granular.Amount.MEDIUM);
                        } else if (drinkComponentSelected instanceof Drizzle) {
                            Log.i(TAG, "drinkComponentSelected instanceof Drizzle");
                            drinkComponentToAdd = new Drizzle(null, Granular.Amount.MEDIUM);
                        } else if (drinkComponentSelected instanceof Topping) {
                            Log.i(TAG, "drinkComponentSelected instanceof Topping");
                            drinkComponentToAdd = new Topping(null, Granular.Amount.MEDIUM);
                        } else {
                            Log.e(TAG, "drinkComponentSelected NOT instanceof ColdFoam nor Drizzle nor Topping");
                        }
                        drinkComponentToAdd.setTypeByString(nameDrinkComponentToAdd);
                        drinkComponentDefaultAsStringToAdd = Granular.Amount.NO.name();

                        drinkComponents.add(indexSelected, drinkComponentToAdd);
                        drinkComponentsDefaultAsString.add(indexSelected, drinkComponentDefaultAsStringToAdd);
                        notifyItemInserted(indexSelected);
                    } else if (enumValuesNotInsideDrink.size() == 1) {
                        // LAST
                        ((Granular) drinkComponentSelected).setAmount(Granular.Amount.MEDIUM);
                        drinkComponentSelected.setTypeByString(enumValuesNotInsideDrink.get(0));
                        updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
                    } else {
                        Log.i(TAG, "enumValuesNotInsideDrink.size() != 2 and enumValuesNotInsideDrink.size() != 1");

                        DrinkComponent drinkComponentToAdd = null;
                        String drinkComponentDefaultAsStringToAdd = null;
                        if (drinkComponentSelected instanceof ColdFoam) {
                            Log.i(TAG, "drinkComponentSelected instanceof ColdFoam");
                            drinkComponentToAdd = new ColdFoam(null, Granular.Amount.MEDIUM);
                        } else if (drinkComponentSelected instanceof Drizzle) {
                            Log.i(TAG, "drinkComponentSelected instanceof Drizzle");
                            drinkComponentToAdd = new Drizzle(null, Granular.Amount.MEDIUM);
                        } else if (drinkComponentSelected instanceof Topping) {
                            Log.i(TAG, "drinkComponentSelected instanceof Topping");
                            drinkComponentToAdd = new Topping(null, Granular.Amount.MEDIUM);
                        } else {
                            Log.e(TAG, "drinkComponentSelected NOT instanceof ColdFoam nor Drizzle nor Topping");
                        }
                        drinkComponentToAdd.setTypeByString(name);
                        drinkComponentDefaultAsStringToAdd = Granular.Amount.NO.name();

                        drinkComponents.add(indexSelected, drinkComponentToAdd);
                        drinkComponentsDefaultAsString.add(indexSelected, drinkComponentDefaultAsStringToAdd);
                        notifyItemInserted(indexSelected);
                    }
                } else {
                    Log.e(TAG, "drinkComponentSelected NOT instanceof ToppingOptions");

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
        } else if (drinkComponentSelected instanceof MixedType) {
            Log.i(TAG, "drinkComponentSelected instanceof MixedType");

            DrinkComponent drinkComponentToAdd = null;
            String drinkComponentDefaultAsStringToAdd = null;
            if (drinkComponentSelected instanceof Powders) {
                for (String typeVanillaBeanPowder : VanillaBeanPowder.getEnumValuesAsStringForMixedType()) {
                    if (name.equals(typeVanillaBeanPowder)) {
                        // TODO: quantity should depend on DrinkSize
                        drinkComponentToAdd = new VanillaBeanPowder(null, 2);
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
                drinkComponents.add(indexSelected, drinkComponentToAdd);
                drinkComponentsDefaultAsString.add(indexSelected, drinkComponentDefaultAsStringToAdd);
                notifyItemInserted(indexSelected);

                // TODO: account for AddInsOptions -> Powders
                //  that are already inside the drink
                //  (compared to how many types that are NOT inside).

                // CHECK IF LAST OPTION CONDITION
                List<String> drinkComponentsAsStringAlreadyInsideDrink = new ArrayList<>();
                for (DrinkComponent drinkComponentInsideDrink : drinkComponents) {
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
                    drinkComponents.set(indexSelected + 1, drinkComponentNotInsideDrink);
                    drinkComponentsDefaultAsString.set(indexSelected + 1, drinkComponentDefaultNotInsideDrink);
                    notifyItemChanged(indexSelected + 1);
                }
            } else if (drinkComponentSelected instanceof Fruits) {
                for (String typeFruitInclusion : FruitInclusion.getEnumValuesAsStringForMixedType()) {
                    if (name.equals(typeFruitInclusion)) {
                        // TODO: quantity should depend on DrinkSize
                        drinkComponentToAdd = new FruitInclusion(null, 2);
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
                drinkComponents.add(indexSelected, drinkComponentToAdd);
                drinkComponentsDefaultAsString.add(indexSelected, drinkComponentDefaultAsStringToAdd);
                notifyItemInserted(indexSelected);

                // CHECK IF LAST OPTION CONDITION
                List<String> drinkComponentsAsStringAlreadyInsideDrink = new ArrayList<>();
                for (DrinkComponent drinkComponentInsideDrink : drinkComponents) {
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
                    drinkComponents.set(indexSelected + 1, drinkComponentNotInsideDrink);
                    drinkComponentsDefaultAsString.set(indexSelected + 1, drinkComponentDefaultNotInsideDrink);
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
