package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.cold.refreshers;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.components.Granular;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.mixed_type.fruits.derived.FruitInclusion;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.mixed_type.fruits.derived.StrawberryPuree;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.lemonade_options.Lemonade;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.lemonade_options.LemonadeOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.MilkBaseAllowable;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.cold.ColdOther;

import java.util.ArrayList;
import java.util.List;

public class FrozenPineapplePassionfruitLemonadeStarbucksRefreshersBeverage extends ColdOther {
    public static final String TAG = FrozenPineapplePassionfruitLemonadeStarbucksRefreshersBeverage.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Frozen Pineapple Passionfruit Lemonade Starbucks Refreshers Beverage";
    public static final String DEFAULT_DESCRIPTION = "Tropical flavors of pineapple and passionfruit blended with real diced pineapple, strawberry puree and lemonade for a refreshingly frozen, vibrant escape in a cup.";
    public static final int DEFAULT_CALORIES = 160;
    public static final int DEFAULT_SUGAR_IN_GRAM = 33;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final Lemonade.Type DEFAULT_LEMONADE = Lemonade.Type.LEMONADE;
    public static final Granular.Amount DEFAULT_LEMONADE_AMOUNT = Granular.Amount.MEDIUM;
    public static final MilkBaseAllowable.Type DEFAULT_MILK_BASE_ALLOWABLE = MilkBaseAllowable.Type.NO;
    public static final FruitInclusion.Type DEFAULT_FRUIT_INCLUSION_PINEAPPLE = FruitInclusion.Type.PINEAPPLE_INCLUSION;
    public static final StrawberryPuree.Type DEFAULT_STRAWBERRY_PUREE = StrawberryPuree.Type.STRAWBERRY_PUREE;
    public static final Granular.Amount DEFAULT_STRAWBERRY_PUREE_AMOUNT = Granular.Amount.MEDIUM;

    public static final double DEFAULT_PRICE_SMALL = 0.05;
    public static final double DEFAULT_PRICE_MEDIUM = 0.10;
    public static final double DEFAULT_PRICE_LARGE = 0.25;

    public FrozenPineapplePassionfruitLemonadeStarbucksRefreshersBeverage() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // LEMONADE_OPTIONS
        Lemonade lemonade = new Lemonade(DEFAULT_LEMONADE, DEFAULT_LEMONADE_AMOUNT);

        List<DrinkComponentWithDefaultAsString> lemonadeOptions = new ArrayList<>();
        lemonadeOptions.add(new DrinkComponentWithDefaultAsString(
                lemonade, DEFAULT_LEMONADE_AMOUNT.name()
        ));
        drinkComponentsStandardRecipe.add(lemonade);

        drinkComponents.put(LemonadeOptions.TAG, lemonadeOptions);

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
        FruitInclusion fruitInclusionPineapple = new FruitInclusion(DEFAULT_FRUIT_INCLUSION_PINEAPPLE, numberOfScoopByDrinkSize);
        StrawberryPuree strawberryPuree = new StrawberryPuree(DEFAULT_STRAWBERRY_PUREE, DEFAULT_STRAWBERRY_PUREE_AMOUNT);

        List<DrinkComponentWithDefaultAsString> addInsOptions = drinkComponents.get(AddInsOptions.TAG);
        addInsOptions.add(0, new DrinkComponentWithDefaultAsString(
                fruitInclusionPineapple, Integer.toString(numberOfScoopByDrinkSize)
        ));
        addInsOptions.add(1, new DrinkComponentWithDefaultAsString(
                strawberryPuree, DEFAULT_STRAWBERRY_PUREE_AMOUNT.name()
        ));
        drinkComponentsStandardRecipe.add(fruitInclusionPineapple);
        drinkComponentsStandardRecipe.add(strawberryPuree);
    }
}
