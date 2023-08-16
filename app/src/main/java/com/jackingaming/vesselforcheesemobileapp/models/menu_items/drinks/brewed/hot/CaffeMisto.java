package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.hot;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.components.Granular;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.MilkBase;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.MilkFoam;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.Temperature;

import java.util.ArrayList;
import java.util.List;

public class CaffeMisto extends HotBrewedCoffees {
    public static final String TAG = CaffeMisto.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Caffe Misto";
    public static final String DEFAULT_DESCRIPTION = "A one-to-one combination of fresh-brewed coffee and steamed milk add up to one distinctly delicious coffee drink remarkably mixed.";
    public static final int DEFAULT_CALORIES = 110;
    public static final int DEFAULT_SUGAR_IN_GRAM = 10;
    public static final float DEFAULT_FAT_IN_GRAM = 4.0f;

    public static final MilkFoam.Type DEFAULT_MILK_FOAM = MilkFoam.Type.MILK_FOAM;
    public static final Granular.Amount DEFAULT_MILK_FOAM_AMOUNT = Granular.Amount.MEDIUM;
    public static final MilkBase.Type DEFAULT_MILK_BASE = MilkBase.Type.TWO_PERCENT;
    public static final Temperature.Type DEFAULT_TEMPERATURE = Temperature.Type.MEDIUM;

    public static final double DEFAULT_PRICE_SMALL = 1.95;
    public static final double DEFAULT_PRICE_MEDIUM = 2.45;
    public static final double DEFAULT_PRICE_LARGE = 2.70;

    public CaffeMisto() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // MILK_OPTIONS
        List<DrinkComponent> milkOptions = new ArrayList<>();
        milkOptions.add(new MilkFoam(DEFAULT_MILK_FOAM, DEFAULT_MILK_FOAM_AMOUNT));
        milkOptions.add(new MilkBase(DEFAULT_MILK_BASE));
        milkOptions.add(new Temperature(DEFAULT_TEMPERATURE));

        // MILK_OPTIONS (defaults)
        List<String> milkOptionsDefault = new ArrayList<>();
        milkOptionsDefault.add(DEFAULT_MILK_FOAM_AMOUNT.name());
        milkOptionsDefault.add(DEFAULT_MILK_BASE.name());
        milkOptionsDefault.add(DEFAULT_TEMPERATURE.name());

        drinkComponents.put(MilkOptions.TAG, milkOptions);
        drinkComponentsDefaultAsString.put(MilkOptions.TAG, milkOptionsDefault);

        List<DrinkComponent> drinkComponentsGroup = drinkComponents.get(MilkOptions.TAG);
        for (DrinkComponent drinkComponent : drinkComponentsGroup) {
            if (drinkComponent.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING)) {
                continue;
            } else {
                drinkComponentsStandardRecipe.add(drinkComponent);
            }
        }
    }
}
