package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.cold.coldbrews;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.components.Granular;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.flavor_options.SyrupSeasonal;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.topping_options.ColdFoam;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.topping_options.Topping;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.topping_options.ToppingOptions;

import java.util.List;

public class WhiteChocolateMacadamiaCreamColdBrew extends ColdBrews {
    public static final String TAG = WhiteChocolateMacadamiaCreamColdBrew.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "White Chocolate Macadamia Cream Cold Brew";
    public static final String DEFAULT_DESCRIPTION = "Starbucks signature cold brew sweetened with macadamia syrup, topped with a silky white-chocolate macadamia cream cold foam and finished with toasted cookie crumbles.";
    public static final int DEFAULT_CALORIES = 240;
    public static final int DEFAULT_SUGAR_IN_GRAM = 30;
    public static final float DEFAULT_FAT_IN_GRAM = 11.0f;

    public static final SyrupSeasonal.Type DEFAULT_SYRUP_SEASONAL_MACADAMIA = SyrupSeasonal.Type.MACADAMIA_SYRUP;
    public static final ColdFoam.Type DEFAULT_COLD_FOAM_WHITE_CHOCOLATE_MACADAMIA_CREAM = ColdFoam.Type.WHITE_CHOCOLATE_MACADAMIA_CREAM_COLD_FOAM;
    public static final Granular.Amount DEFAULT_COLD_FOAM_WHITE_CHOCOLATE_MACADAMIA_CREAM_AMOUNT = Granular.Amount.MEDIUM;
    public static final Topping.Type DEFAULT_TOPPING_TOASTED_COOKIE_CRUMBLE = Topping.Type.PUMPKIN_SPICE_TOPPING;
    public static final Granular.Amount DEFAULT_TOPPING_TOASTED_COOKIE_CRUMBLE_AMOUNT = Granular.Amount.MEDIUM;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public WhiteChocolateMacadamiaCreamColdBrew() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // FLAVOR_OPTIONS (add into EXISTING DrinkComponent group)
        int numberOfPumpByDrinkSize = getNumberOfPumpByDrinkSize(drinkSize);
        SyrupSeasonal syrupSeasonalMacadamia = new SyrupSeasonal(DEFAULT_SYRUP_SEASONAL_MACADAMIA, numberOfPumpByDrinkSize);

        List<DrinkComponentWithDefaultAsString> flavorOptions = drinkComponents.get(FlavorOptions.TAG);
        flavorOptions.add(0, new DrinkComponentWithDefaultAsString(
                syrupSeasonalMacadamia, Integer.toString(numberOfPumpByDrinkSize)
        ));

        drinkComponentsStandardRecipe.add(syrupSeasonalMacadamia);

        // TOPPING_OPTIONS (add into EXISTING DrinkComponent group)
        ColdFoam coldFoamWhiteChocolateMacadamiaCream = new ColdFoam(DEFAULT_COLD_FOAM_WHITE_CHOCOLATE_MACADAMIA_CREAM, DEFAULT_COLD_FOAM_WHITE_CHOCOLATE_MACADAMIA_CREAM_AMOUNT);
        Topping toppingToastedCookieCrumble = new Topping(DEFAULT_TOPPING_TOASTED_COOKIE_CRUMBLE, DEFAULT_TOPPING_TOASTED_COOKIE_CRUMBLE_AMOUNT);

        List<DrinkComponentWithDefaultAsString> toppingOptions = drinkComponents.get(ToppingOptions.TAG);
        toppingOptions.add(0, new DrinkComponentWithDefaultAsString(
                coldFoamWhiteChocolateMacadamiaCream, DEFAULT_COLD_FOAM_WHITE_CHOCOLATE_MACADAMIA_CREAM_AMOUNT.name()
        ));
        toppingOptions.add(1, new DrinkComponentWithDefaultAsString(
                toppingToastedCookieCrumble, DEFAULT_TOPPING_TOASTED_COOKIE_CRUMBLE_AMOUNT.name()
        ));

        drinkComponentsStandardRecipe.add(coldFoamWhiteChocolateMacadamiaCream);
        drinkComponentsStandardRecipe.add(toppingToastedCookieCrumble);
    }
}
