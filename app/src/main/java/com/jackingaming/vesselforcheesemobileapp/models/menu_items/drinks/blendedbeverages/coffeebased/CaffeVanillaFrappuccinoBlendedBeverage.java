package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.blendedbeverages.coffeebased;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.components.Granular;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.mixed_type.powders.derived.VanillaBeanPowder;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.topping_options.ToppingOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.topping_options.WhippedCream;

import java.util.List;

public class CaffeVanillaFrappuccinoBlendedBeverage extends CoffeeBased {
    public static final String TAG = CaffeVanillaFrappuccinoBlendedBeverage.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Caffe Vanilla Frappuccino Blended Beverage";
    public static final String DEFAULT_DESCRIPTION = "We take Frappuccino roast coffee and vanilla bean powder, combine them with milk and ice, topped with whipped cream. Tastes like happiness.";
    public static final int DEFAULT_CALORIES = 410;
    public static final int DEFAULT_SUGAR_IN_GRAM = 63;
    public static final float DEFAULT_FAT_IN_GRAM = 15.0f;

    public static final WhippedCream.Type DEFAULT_WHIPPED_CREAM = WhippedCream.Type.WHIPPED_CREAM;
    public static final Granular.Amount DEFAULT_WHIPPED_CREAM_AMOUNT = Granular.Amount.MEDIUM;
    public static final VanillaBeanPowder.Type DEFAULT_VANILLA_BEAN_POWDER = VanillaBeanPowder.Type.VANILLA_BEAN_POWDER;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public CaffeVanillaFrappuccinoBlendedBeverage() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // REMOVAL: TOPPING_OPTIONS: WhippedCream
        WhippedCream whippedCream = null;
        for (DrinkComponent drinkComponent : drinkComponentsStandardRecipe) {
            if (drinkComponent instanceof WhippedCream) {
                whippedCream = (WhippedCream) drinkComponent;
                break;
            }
        }
        drinkComponentsStandardRecipe.remove(whippedCream);
        drinkComponents.get(ToppingOptions.TAG).remove(3);

        // TOPPING_OPTIONS (add into EXISTING DrinkComponent group)
        WhippedCream whippedCreamDefined = new WhippedCream(DEFAULT_WHIPPED_CREAM, DEFAULT_WHIPPED_CREAM_AMOUNT);

        List<DrinkComponentWithDefaultAsString> toppingOptions = drinkComponents.get(ToppingOptions.TAG);
        toppingOptions.add(0, new DrinkComponentWithDefaultAsString(
                whippedCreamDefined, DEFAULT_WHIPPED_CREAM_AMOUNT.name()
        ));
        drinkComponentsStandardRecipe.add(whippedCreamDefined);

        // ADD_INS_OPTIONS (add into EXISTING DrinkComponent group)
        int numberOfScoopByDrinkSize = getNumberOfScoopByDrinkSize(drinkSize);
        VanillaBeanPowder vanillaBeanPowder = new VanillaBeanPowder(DEFAULT_VANILLA_BEAN_POWDER, numberOfScoopByDrinkSize);

        List<DrinkComponentWithDefaultAsString> addInsOptions = drinkComponents.get(AddInsOptions.TAG);
        addInsOptions.add(0, new DrinkComponentWithDefaultAsString(
                vanillaBeanPowder, Integer.toString(numberOfScoopByDrinkSize)
        ));
        drinkComponentsStandardRecipe.add(vanillaBeanPowder);
    }
}
