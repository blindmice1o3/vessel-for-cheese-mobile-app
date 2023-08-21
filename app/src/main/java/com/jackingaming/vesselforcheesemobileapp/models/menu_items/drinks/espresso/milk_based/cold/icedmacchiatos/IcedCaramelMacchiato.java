package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.cold.icedmacchiatos;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.components.Granular;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.Ice;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.flavor_options.Syrup;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.Temperature;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.topping_options.Drizzle;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.topping_options.ToppingOptions;

import java.util.List;

public class IcedCaramelMacchiato extends IcedMacchiatos {
    public static final String TAG = IcedCaramelMacchiato.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Iced Caramel Macchiato";
    public static final String DEFAULT_DESCRIPTION = "We combine our rich, full-bodied espresso with vanilla-flavored syrup, milk and ice, then top it off with a caramel drizzle for an oh-so-sweet finish.";
    public static final int DEFAULT_CALORIES = 250;
    public static final int DEFAULT_SUGAR_IN_GRAM = 34;
    public static final float DEFAULT_FAT_IN_GRAM = 7.0f;

    public static final Syrup.Type DEFAULT_SYRUP_VANILLA = Syrup.Type.VANILLA;
    public static final Drizzle.Type DEFAULT_DRIZZLE_CARAMEL = Drizzle.Type.CARAMEL;
    public static final Granular.Amount DEFAULT_DRIZZLE_CARAMEL_AMOUNT = Granular.Amount.MEDIUM;
    public static final Ice.Type DEFAULT_ICE = Ice.Type.ICE;
    public static final Granular.Amount DEFAULT_ICE_AMOUNT = Granular.Amount.MEDIUM;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public IcedCaramelMacchiato() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // FLAVOR_OPTIONS (add into EXISTING DrinkComponent group)
        int numberOfPumpByDrinkSize = getNumberOfPumpByDrinkSize(drinkSize);
        Syrup syrupVanilla = new Syrup(DEFAULT_SYRUP_VANILLA, numberOfPumpByDrinkSize);

        List<DrinkComponentWithDefaultAsString> flavorOptions = drinkComponents.get(FlavorOptions.TAG);
        flavorOptions.add(0, new DrinkComponentWithDefaultAsString(
                syrupVanilla, Integer.toString(numberOfPumpByDrinkSize)
        ));
        // TOPPING_OPTIONS (add into EXISTING DrinkComponent group)
        Drizzle drizzleCaramel = new Drizzle(DEFAULT_DRIZZLE_CARAMEL, DEFAULT_DRIZZLE_CARAMEL_AMOUNT);

        List<DrinkComponentWithDefaultAsString> toppingOptions = drinkComponents.get(ToppingOptions.TAG);
        toppingOptions.add(0, new DrinkComponentWithDefaultAsString(
                drizzleCaramel, DEFAULT_DRIZZLE_CARAMEL_AMOUNT.name()
        ));
        // ADD_INS_OPTIONS (add into EXISTING DrinkComponent group)
        Ice ice = new Ice(DEFAULT_ICE, DEFAULT_ICE_AMOUNT);

        List<DrinkComponentWithDefaultAsString> addInsOptions = drinkComponents.get(AddInsOptions.TAG);
        addInsOptions.add(0, new DrinkComponentWithDefaultAsString(
                ice, DEFAULT_ICE_AMOUNT.name()
        ));

        drinkComponentsStandardRecipe.add(syrupVanilla);
        drinkComponentsStandardRecipe.add(drizzleCaramel);
        drinkComponentsStandardRecipe.add(ice);

        // REMOVAL: MILK_OPTIONS: Temperature
        Temperature temperature = null;
        for (DrinkComponent drinkComponent : drinkComponentsStandardRecipe) {
            if (drinkComponent instanceof Temperature) {
                temperature = (Temperature) drinkComponent;
                break;
            }
        }
        drinkComponentsStandardRecipe.remove(temperature);
        drinkComponents.get(MilkOptions.TAG).remove(1);
    }
}
