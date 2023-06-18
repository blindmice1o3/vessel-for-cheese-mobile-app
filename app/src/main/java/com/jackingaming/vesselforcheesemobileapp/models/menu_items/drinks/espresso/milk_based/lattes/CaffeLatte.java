package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes;

import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.Incrementable;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.EspressoOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.RoastOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.Shot;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.MilkBase;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.MilkFoam;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.Temperature;

import java.util.ArrayList;
import java.util.List;

public class CaffeLatte extends Lattes {
    public static final String TAG = CaffeLatte.class.getSimpleName();

    public static final String DEFAULT_NAME = "Caffe Latte";
    public static final String DEFAULT_DESCRIPTION = "Our dark, rich espresso balanced with steamed milk and a light layer of foam. A perfect milk-forward warm-up.";
    public static final int DEFAULT_CALORIES = 190;
    public static final int DEFAULT_SUGAR_IN_GRAM = 18;
    public static final float DEFAULT_FAT_IN_GRAM = 7.0f;

    public static final MilkFoam.Type DEFAULT_MILK_FOAM = MilkFoam.Type.MEDIUM;
    public static final MilkBase.Type DEFAULT_MILK_BASE = MilkBase.Type.TWO_PERCENT;
    public static final Temperature.Type DEFAULT_TEMPERATURE = Temperature.Type.MEDIUM;
    public static final RoastOptions.Type DEFAULT_ROAST_OPTIONS = RoastOptions.Type.SIGNATURE;
    public static final Shot.Type DEFAULT_SHOT = Shot.Type.SHOT;
    public static final int DEFAULT_NUMBER_OF_ESPRESSO_SHOTS = 2;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;
    public static final boolean DEFAULT_ICED = false;

    public CaffeLatte() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM, DEFAULT_ICED);
        // MILK_OPTIONS
        List<DrinkComponent> milkOptions = new ArrayList<>();
        milkOptions.add(new MilkFoam(DEFAULT_MILK_FOAM));
        milkOptions.add(new MilkBase(DEFAULT_MILK_BASE));
        milkOptions.add(new Temperature(DEFAULT_TEMPERATURE));
        // ESPRESSO_OPTIONS
        List<DrinkComponent> espressoOptions = new ArrayList<>();
        espressoOptions.add(new RoastOptions(DEFAULT_ROAST_OPTIONS));
        espressoOptions.add(new Shot(DEFAULT_SHOT, DEFAULT_NUMBER_OF_ESPRESSO_SHOTS));

        // MILK_OPTIONS (defaults)
        List<String> milkOptionsDefault = new ArrayList<>();
        for (DrinkComponent drinkComponent : milkOptions) {
            if (drinkComponent instanceof Incrementable) {
                Incrementable incrementable = (Incrementable) drinkComponent;
                milkOptionsDefault.add(Integer.toString(incrementable.getQuantity()));
            } else {
                milkOptionsDefault.add(drinkComponent.getTypeAsString());
            }
        }
        // ESPRESSO_OPTIONS (defaults)
        List<String> espressoOptionsDefault = new ArrayList<>();
        for (DrinkComponent drinkComponent : espressoOptions) {
            if (drinkComponent instanceof Incrementable) {
                Incrementable incrementable = (Incrementable) drinkComponent;
                espressoOptionsDefault.add(Integer.toString(incrementable.getQuantity()));
            } else {
                espressoOptionsDefault.add(drinkComponent.getTypeAsString());
            }
        }

        drinkComponents.put(MilkOptions.TAG, milkOptions);
        drinkComponents.put(EspressoOptions.TAG, espressoOptions);
        drinkComponentsDefaultAsString.put(MilkOptions.TAG, milkOptionsDefault);
        drinkComponentsDefaultAsString.put(EspressoOptions.TAG, espressoOptionsDefault);

        drinkComponentsWhatsIncluded.addAll(milkOptions);
        drinkComponentsWhatsIncluded.addAll(espressoOptions);
        drinkComponentsWhatsIncludedDefaultAsString.addAll(milkOptionsDefault);
        drinkComponentsWhatsIncludedDefaultAsString.addAll(espressoOptionsDefault);
    }
}
