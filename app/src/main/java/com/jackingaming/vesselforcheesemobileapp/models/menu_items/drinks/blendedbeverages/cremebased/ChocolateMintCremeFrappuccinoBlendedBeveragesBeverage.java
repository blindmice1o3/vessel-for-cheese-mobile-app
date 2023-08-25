package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.blendedbeverages.cremebased;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.components.Granular;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.blended_options.BlendedOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.blended_options.FrapChips;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.topping_options.Drizzle;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.topping_options.ToppingOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.topping_options.WhippedCream;

import java.util.List;

public class ChocolateMintCremeFrappuccinoBlendedBeveragesBeverage extends CremeBased {
    public static final String TAG = ChocolateMintCremeFrappuccinoBlendedBeveragesBeverage.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Chocolate Mint Creme Frappuccino Blended Beverage";
    public static final String DEFAULT_DESCRIPTION = "Flavors of sweet chocolate and refreshing mint blended with rich Frappuccino chips for a smooth treat finished with a layer of mocha sauce, whipped cream and chocolate-mint cookie crumble.";
    public static final int DEFAULT_CALORIES = 450;
    public static final int DEFAULT_SUGAR_IN_GRAM = 57;
    public static final float DEFAULT_FAT_IN_GRAM = 21.0f;

    public static final FrapChips.Type DEFAULT_FRAP_CHIPS = FrapChips.Type.FRAP_CHIPS;
    public static final WhippedCream.Type DEFAULT_WHIPPED_CREAM = WhippedCream.Type.WHIPPED_CREAM;
    public static final Granular.Amount DEFAULT_WHIPPED_CREAM_AMOUNT = Granular.Amount.MEDIUM;
    public static final Drizzle.Type DEFAULT_DRIZZLE_MOCHA = Drizzle.Type.MOCHA_DRIZZLE;
    public static final Granular.Amount DEFAULT_DRIZZLE_MOCHA_AMOUNT = Granular.Amount.MEDIUM;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public ChocolateMintCremeFrappuccinoBlendedBeveragesBeverage() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // REMOVAL: BLENDED_OPTIONS: FrapChips
        FrapChips frapChips = null;
        for (DrinkComponent drinkComponent : drinkComponentsStandardRecipe) {
            if (drinkComponent instanceof FrapChips) {
                frapChips = (FrapChips) drinkComponent;
                break;
            }
        }
        drinkComponentsStandardRecipe.remove(frapChips);
        drinkComponents.get(BlendedOptions.TAG).remove(1);

        // BLENDED_OPTIONS (add into EXISTING DrinkComponent group)
        int numberOfScoopByDrinkSize = getNumberOfScoopByDrinkSize(drinkSize);
        FrapChips frapChipsDefined = new FrapChips(DEFAULT_FRAP_CHIPS, numberOfScoopByDrinkSize);

        List<DrinkComponentWithDefaultAsString> blendedOptions = drinkComponents.get(BlendedOptions.TAG);
        blendedOptions.add(0, new DrinkComponentWithDefaultAsString(
                frapChipsDefined, Integer.toString(numberOfScoopByDrinkSize)
        ));
        drinkComponentsStandardRecipe.add(frapChipsDefined);

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

        // TOPPING_OPTIONS (add into EXISTING DrinkComponent group)
        Drizzle drizzleMocha = new Drizzle(DEFAULT_DRIZZLE_MOCHA, DEFAULT_DRIZZLE_MOCHA_AMOUNT);

        toppingOptions.add(0, new DrinkComponentWithDefaultAsString(
                drizzleMocha, DEFAULT_DRIZZLE_MOCHA_AMOUNT.name()
        ));
        drinkComponentsStandardRecipe.add(drizzleMocha);
    }
}