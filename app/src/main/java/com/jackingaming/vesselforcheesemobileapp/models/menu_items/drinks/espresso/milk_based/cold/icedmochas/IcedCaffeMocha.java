package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.cold.icedmochas;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.components.Granular;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.flavor_options.Sauce;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.topping_options.ToppingOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.topping_options.WhippedCream;

import java.util.List;

public class IcedCaffeMocha extends IcedMochas {
    public static final String TAG = IcedCaffeMocha.class.getSimpleName();

    public static final String ID = "IcedCaffeMocha";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Iced Caffe Mocha";
    public static final String DEFAULT_DESCRIPTION = "Our rich, full-bodied espresso combined with bittersweet mocha sauce, milk and ice, then topped with sweetened whipped cream. The classic iced coffee drink that always sweetly satisfies.";
    public static final int DEFAULT_CALORIES = 350;
    public static final int DEFAULT_SUGAR_IN_GRAM = 30;
    public static final float DEFAULT_FAT_IN_GRAM = 17.0f;

    public static final Sauce.Type DEFAULT_SAUCE_MOCHA = Sauce.Type.MOCHA_SAUCE;
    public static final WhippedCream.Type DEFAULT_WHIPPED_CREAM = WhippedCream.Type.WHIPPED_CREAM;
    public static final Granular.Amount DEFAULT_WHIPPED_CREAM_AMOUNT = Granular.Amount.MEDIUM;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public IcedCaffeMocha() {
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
