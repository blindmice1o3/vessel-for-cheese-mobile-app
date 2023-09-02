package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.cold;

import com.jackingaming.vesselforcheesemobileapp.models.components.Granular;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.Ice;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.mixed_type.powders.base.Powders;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.MilkBase;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.Espresso;

import java.util.ArrayList;
import java.util.List;

public abstract class ColdMilkBased extends Espresso {
    public static final String TAG = ColdMilkBased.class.getSimpleName();

    public static final MilkBase.Type DEFAULT_MILK_BASE = MilkBase.Type.TWO_PERCENT;
    public static final Ice.Type DEFAULT_ICE = Ice.Type.ICE;
    public static final Granular.Amount DEFAULT_ICE_AMOUNT = Granular.Amount.MEDIUM;
    public static final String DEFAULT_POWDERS = DrinkComponent.NULL_TYPE_AS_STRING;

    public ColdMilkBased() {
    }

    public ColdMilkBased(String id, int imageResourceId, String name, String description,
                         int calories, int sugarInGram, float fatInGram,
                         double price, DrinkSize drinkSizeDefault) {
        super(id, imageResourceId, name, description,
                calories, sugarInGram, fatInGram,
                price, drinkSizeDefault);

        // MILK_OPTIONS (add into NEW DrinkComponent group)
        MilkBase milkBaseTwoPercent = new MilkBase(DEFAULT_MILK_BASE);

        List<DrinkComponentWithDefaultAsString> milkOptions = new ArrayList<>();
        milkOptions.add(new DrinkComponentWithDefaultAsString(
                milkBaseTwoPercent, DEFAULT_MILK_BASE.name()
        ));
        drinkComponentsStandardRecipe.add(milkBaseTwoPercent);

        drinkComponents.put(MilkOptions.TAG, milkOptions);

        // ADD_INS_OPTIONS (add into EXISTING DrinkComponent group)
        Ice ice = new Ice(DEFAULT_ICE, DEFAULT_ICE_AMOUNT);

        List<DrinkComponentWithDefaultAsString> addInsOptions = drinkComponents.get(AddInsOptions.TAG);
        addInsOptions.add(0, new DrinkComponentWithDefaultAsString(
                ice, DEFAULT_ICE_AMOUNT.name()
        ));
        addInsOptions.add(2, new DrinkComponentWithDefaultAsString(
                new Powders(Powders.DUMMY_ID), DEFAULT_POWDERS
        ));
        drinkComponentsStandardRecipe.add(ice);
    }
}
