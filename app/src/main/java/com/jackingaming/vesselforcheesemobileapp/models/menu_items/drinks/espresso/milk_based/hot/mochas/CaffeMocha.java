package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.hot.mochas;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.components.Granular;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.flavor_options.Sauce;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.topping_options.ToppingOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.topping_options.WhippedCream;

import java.util.List;

public class CaffeMocha extends Mochas {
    public static final String TAG = CaffeMocha.class.getSimpleName();

    public static final String ID = "CaffeMocha";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Caffe Mocha";
    public static final String DEFAULT_DESCRIPTION = "Our rich, full-bodied espresso combined with bittersweet mocha sauce and steamed milk, then topped with sweetened whipped cream. The classic coffee drink that always sweetly satisfies.";
    public static final int DEFAULT_CALORIES = 370;
    public static final int DEFAULT_SUGAR_IN_GRAM = 35;
    public static final float DEFAULT_FAT_IN_GRAM = 15.0f;

    public static final Sauce.Type DEFAULT_SAUCE_MOCHA = Sauce.Type.MOCHA_SAUCE;
    public static final WhippedCream.Type DEFAULT_WHIPPED_CREAM = WhippedCream.Type.WHIPPED_CREAM;
    public static final Granular.Amount DEFAULT_WHIPPED_CREAM_AMOUNT = Granular.Amount.MEDIUM;

    public static final double DEFAULT_PRICE_SMALL = 1.95;
    public static final double DEFAULT_PRICE_MEDIUM = 2.45;
    public static final double DEFAULT_PRICE_LARGE = 2.70;

    public CaffeMocha() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // FLAVOR_OPTIONS (add into EXISTING DrinkComponent group)
        int numberOfPumpByDrinkSize = getNumberOfPumpByDrinkSize(drinkSize);
        Sauce sauceMocha = new Sauce(DEFAULT_SAUCE_MOCHA, numberOfPumpByDrinkSize);

        List<DrinkComponentWithDefaultAsString> flavorOptions = drinkComponents.get(FlavorOptions.TAG);
        flavorOptions.add(0, new DrinkComponentWithDefaultAsString(
                sauceMocha, Integer.toString(numberOfPumpByDrinkSize)
        ));
        drinkComponentsStandardRecipe.add(sauceMocha);

        // REMOVAL: TOPPING_OPTIONS: WhippedCream
        WhippedCream whippedCream = null;
        for (DrinkComponent drinkComponent : drinkComponentsStandardRecipe) {
            if (drinkComponent instanceof WhippedCream) {
                whippedCream = (WhippedCream) drinkComponent;
                break;
            }
        }
        drinkComponentsStandardRecipe.remove(whippedCream);
        drinkComponents.get(ToppingOptions.TAG).remove(4);

        // TOPPING_OPTIONS (add into EXISTING DrinkComponent group)
        WhippedCream whippedCreamDefined = new WhippedCream(DEFAULT_WHIPPED_CREAM, DEFAULT_WHIPPED_CREAM_AMOUNT);

        List<DrinkComponentWithDefaultAsString> toppingOptions = drinkComponents.get(ToppingOptions.TAG);

        toppingOptions.add(0, new DrinkComponentWithDefaultAsString(
                whippedCreamDefined, DEFAULT_WHIPPED_CREAM_AMOUNT.name()
        ));

        drinkComponentsStandardRecipe.add(whippedCreamDefined);
    }
}
