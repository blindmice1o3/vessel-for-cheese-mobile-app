package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.cold.refreshers;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.components.Granular;
import com.jackingaming.vesselforcheesemobileapp.models.components.GranularTwoOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.Ice;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.mixed_type.fruits.derived.FruitInclusion;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.extra_refresher_bases_options.ExtraRefresherBases;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.extra_refresher_bases_options.ExtraRefresherBasesOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.MilkBaseAllowable;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.preparation_options.PreparationMethod;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.preparation_options.PreparationOptions;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.cold.ColdOther;

import java.util.ArrayList;
import java.util.List;

public class StrawberryAcaiStarbucksRefreshersBeverage extends ColdOther {
    public static final String TAG = StrawberryAcaiStarbucksRefreshersBeverage.class.getSimpleName();

    public static final String ID = "StrawberryAcaiStarbucksRefreshersBeverage";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Strawberry Acai Starbucks Refreshers Beverage";
    public static final String DEFAULT_DESCRIPTION = "Sweet strawberry flavors accented by passion fruit and acai notes, shaken with ice and real strawberry pieces--a welcoming sweet spot of refreshment.";
    public static final int DEFAULT_CALORIES = 100;
    public static final int DEFAULT_SUGAR_IN_GRAM = 21;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final GranularTwoOptions.Option DEFAULT_EXTRA_REFRESHER_BASES_OPTION = GranularTwoOptions.Option.STANDARD;
    public static final PreparationMethod.Type DEFAULT_PREPARATION_METHOD = PreparationMethod.Type.NONE;
    public static final MilkBaseAllowable.Type DEFAULT_MILK_BASE_ALLOWABLE = MilkBaseAllowable.Type.NO;
    public static final FruitInclusion.Type DEFAULT_FRUIT_INCLUSION_STRAWBERRY = FruitInclusion.Type.STRAWBERRY_INCLUSION;
    public static final Ice.Type DEFAULT_ICE = Ice.Type.ICE;
    public static final Granular.Amount DEFAULT_ICE_AMOUNT = Granular.Amount.MEDIUM;

    public static final double DEFAULT_PRICE_SMALL = 0.05;
    public static final double DEFAULT_PRICE_MEDIUM = 0.10;
    public static final double DEFAULT_PRICE_LARGE = 0.25;

    public StrawberryAcaiStarbucksRefreshersBeverage() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // EXTRA_REFRESHER_BASES_OPTIONS
        List<DrinkComponentWithDefaultAsString> extraRefresherBasesOptions = new ArrayList<>();
        extraRefresherBasesOptions.add(new DrinkComponentWithDefaultAsString(
                new ExtraRefresherBases(null, DEFAULT_EXTRA_REFRESHER_BASES_OPTION), DEFAULT_EXTRA_REFRESHER_BASES_OPTION.name()
        ));

        drinkComponents.put(ExtraRefresherBasesOptions.TAG, extraRefresherBasesOptions);

        // PREPARATION_OPTIONS (add into NEW DrinkComponent group)
        PreparationMethod preparationMethod = new PreparationMethod(DEFAULT_PREPARATION_METHOD);

        List<DrinkComponentWithDefaultAsString> preparationOptions = new ArrayList<>();
        preparationOptions.add(new DrinkComponentWithDefaultAsString(
                preparationMethod, DEFAULT_PREPARATION_METHOD.name()
        ));
        drinkComponentsStandardRecipe.add(preparationMethod);

        drinkComponents.put(PreparationOptions.TAG, preparationOptions);

        // MILK_OPTIONS (add into NEW DrinkComponent group)
        MilkBaseAllowable milkBaseAllowable = new MilkBaseAllowable(DEFAULT_MILK_BASE_ALLOWABLE);

        List<DrinkComponentWithDefaultAsString> milkOptions = new ArrayList<>();
        milkOptions.add(new DrinkComponentWithDefaultAsString(
                milkBaseAllowable, DEFAULT_MILK_BASE_ALLOWABLE.name()
        ));
        drinkComponentsStandardRecipe.add(milkBaseAllowable);

        drinkComponents.put(MilkOptions.TAG, milkOptions);

        // ADD_INS_OPTIONS (add into EXISTING DrinkComponent group)
        int numberOfScoopByDrinkSize = getNumberOfScoopByDrinkSize(drinkSize);
        FruitInclusion fruitInclusionStrawberry = new FruitInclusion(DEFAULT_FRUIT_INCLUSION_STRAWBERRY, numberOfScoopByDrinkSize);
        Ice ice = new Ice(DEFAULT_ICE, DEFAULT_ICE_AMOUNT);

        List<DrinkComponentWithDefaultAsString> addInsOptions = drinkComponents.get(AddInsOptions.TAG);
        addInsOptions.add(0, new DrinkComponentWithDefaultAsString(
                fruitInclusionStrawberry, Integer.toString(numberOfScoopByDrinkSize)
        ));
        addInsOptions.add(1, new DrinkComponentWithDefaultAsString(
                ice, DEFAULT_ICE_AMOUNT.name()
        ));
        drinkComponentsStandardRecipe.add(fruitInclusionStrawberry);
        drinkComponentsStandardRecipe.add(ice);
    }
}
