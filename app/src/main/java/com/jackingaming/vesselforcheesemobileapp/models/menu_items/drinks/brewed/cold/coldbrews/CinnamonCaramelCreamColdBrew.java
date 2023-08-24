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

public class CinnamonCaramelCreamColdBrew extends ColdBrews {
    public static final String TAG = CinnamonCaramelCreamColdBrew.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Cinnamon Caramel Cream Cold Brew";
    public static final String DEFAULT_DESCRIPTION = "Starbucks Cold Brew packed with flavors of cinnamon caramel, topped with vanilla sweet cream cold foam and dusted with even more flavor for a special personal treat.";
    public static final int DEFAULT_CALORIES = 250;
    public static final int DEFAULT_SUGAR_IN_GRAM = 32;
    public static final float DEFAULT_FAT_IN_GRAM = 12.0f;

    public static final SyrupSeasonal.Type DEFAULT_SYRUP_SEASONAL_CINNAMON_CARAMEL = SyrupSeasonal.Type.CINNAMON_CARAMEL_SYRUP;
    public static final ColdFoam.Type DEFAULT_COLD_FOAM_CINNAMON_SWEET_CREAM = ColdFoam.Type.CINNAMON_SWEET_CREAM_COLD_FOAM;
    public static final Granular.Amount DEFAULT_COLD_FOAM_CINNAMON_SWEET_CREAM_AMOUNT = Granular.Amount.MEDIUM;
    public static final Topping.Type DEFAULT_TOPPING_CINNAMON_DOLCE_SPRINKLES = Topping.Type.CINNAMON_DOLCE_SPRINKLES;
    public static final Granular.Amount DEFAULT_TOPPING_CINNAMON_DOLCE_SPRINKLES_AMOUNT = Granular.Amount.MEDIUM;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public CinnamonCaramelCreamColdBrew() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // FLAVOR_OPTIONS (add into EXISTING DrinkComponent group)
        int numberOfPumpByDrinkSize = getNumberOfPumpByDrinkSize(drinkSize);
        SyrupSeasonal syrupSeasonalCinnamonCaramel = new SyrupSeasonal(DEFAULT_SYRUP_SEASONAL_CINNAMON_CARAMEL, numberOfPumpByDrinkSize);

        List<DrinkComponentWithDefaultAsString> flavorOptions = drinkComponents.get(FlavorOptions.TAG);
        flavorOptions.add(0, new DrinkComponentWithDefaultAsString(
                syrupSeasonalCinnamonCaramel, Integer.toString(numberOfPumpByDrinkSize)
        ));

        drinkComponentsStandardRecipe.add(syrupSeasonalCinnamonCaramel);

        // TOPPING_OPTIONS (add into EXISTING DrinkComponent group)
        ColdFoam coldFoamCinnamonSweetCream = new ColdFoam(DEFAULT_COLD_FOAM_CINNAMON_SWEET_CREAM, DEFAULT_COLD_FOAM_CINNAMON_SWEET_CREAM_AMOUNT);
        Topping toppingCinnamonDolceSprinkles = new Topping(DEFAULT_TOPPING_CINNAMON_DOLCE_SPRINKLES, DEFAULT_TOPPING_CINNAMON_DOLCE_SPRINKLES_AMOUNT);

        List<DrinkComponentWithDefaultAsString> toppingOptions = drinkComponents.get(ToppingOptions.TAG);
        toppingOptions.add(0, new DrinkComponentWithDefaultAsString(
                coldFoamCinnamonSweetCream, DEFAULT_COLD_FOAM_CINNAMON_SWEET_CREAM_AMOUNT.name()
        ));
        toppingOptions.add(1, new DrinkComponentWithDefaultAsString(
                toppingCinnamonDolceSprinkles, DEFAULT_TOPPING_CINNAMON_DOLCE_SPRINKLES_AMOUNT.name()
        ));

        drinkComponentsStandardRecipe.add(coldFoamCinnamonSweetCream);
        drinkComponentsStandardRecipe.add(toppingCinnamonDolceSprinkles);
    }
}
