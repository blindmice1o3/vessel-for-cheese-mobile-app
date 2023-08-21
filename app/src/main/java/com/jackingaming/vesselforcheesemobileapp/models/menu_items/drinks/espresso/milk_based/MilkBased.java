package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based;

import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.mixed_type.powders.base.Powders;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.MilkBase;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.Temperature;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.Espresso;

import java.util.ArrayList;
import java.util.List;

public abstract class MilkBased extends Espresso {
    public static final String TAG = MilkBased.class.getSimpleName();

    public static final MilkBase.Type DEFAULT_MILK_BASE = MilkBase.Type.TWO_PERCENT;
    public static final Temperature.Type DEFAULT_TEMPERATURE = Temperature.Type.MEDIUM;
    public static final String DEFAULT_POWDERS = DrinkComponent.NULL_TYPE_AS_STRING;

    public MilkBased() {
    }

    public MilkBased(int imageResourceId, String name, String description,
                     int calories, int sugarInGram, float fatInGram,
                     double price, DrinkSize drinkSizeDefault) {
        super(imageResourceId, name, description,
                calories, sugarInGram, fatInGram,
                price, drinkSizeDefault);

        // MILK_OPTIONS (add into NEW DrinkComponent group)
        MilkBase milkBaseTwoPercent = new MilkBase(DEFAULT_MILK_BASE);
        Temperature temperatureMedium = new Temperature(DEFAULT_TEMPERATURE);

        List<DrinkComponentWithDefaultAsString> milkOptions = new ArrayList<>();
        milkOptions.add(new DrinkComponentWithDefaultAsString(
                milkBaseTwoPercent, DEFAULT_MILK_BASE.name()
        ));
        milkOptions.add(new DrinkComponentWithDefaultAsString(
                temperatureMedium, DEFAULT_TEMPERATURE.name()
        ));
        // ADD_INS_OPTIONS (add into EXISTING DrinkComponent group)
        List<DrinkComponentWithDefaultAsString> addInsOptions = drinkComponents.get(AddInsOptions.TAG);
        addInsOptions.add(1, new DrinkComponentWithDefaultAsString(
                new Powders(), DEFAULT_POWDERS
        ));

        drinkComponents.put(MilkOptions.TAG, milkOptions);

        drinkComponentsStandardRecipe.add(milkBaseTwoPercent);
        drinkComponentsStandardRecipe.add(temperatureMedium);
    }
}
