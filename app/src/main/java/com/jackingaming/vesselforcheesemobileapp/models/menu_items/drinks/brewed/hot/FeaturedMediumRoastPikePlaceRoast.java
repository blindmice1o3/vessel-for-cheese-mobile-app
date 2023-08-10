package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.hot;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.components.Granular;
import com.jackingaming.vesselforcheesemobileapp.models.components.Incrementable;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.LineTheCup;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.MilkCreamer;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.Room;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.mixed_type.powders.base.Powders;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.cup_options.CupOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.cup_options.CupSize;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.EspressoOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.RoastOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.Shot;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.flavor_options.Sauce;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.flavor_options.Syrup;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.sweetener_options.Liquid;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.sweetener_options.Packet;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.sweetener_options.SweetenerOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.tea_options.Chai;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.tea_options.TeaOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.topping_options.CinnamonPowder;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.topping_options.ColdFoam;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.topping_options.Drizzle;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.topping_options.Topping;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.topping_options.ToppingOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.topping_options.WhippedCream;
import com.jackingaming.vesselforcheesemobileapp.models.menu.Menu;

import java.util.ArrayList;
import java.util.List;

public class FeaturedMediumRoastPikePlaceRoast extends HotBrewedCoffees {
    public static final String TAG = FeaturedMediumRoastPikePlaceRoast.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Featured Medium Roast Pike Place Roast";
    public static final String DEFAULT_DESCRIPTION = "From our first store in Seattle's Pike Place Market to our coffeehouses around the world, customers requested a freshly brewed coffee they could enjoy throughout the day. In 2008 our master blenders and roasters created this for you-a smooth, well-rounded blend of Latin American coffees with subtly rich flavors of chocolate and toasted nuts, it's served fresh every day at a Starbucks store near you.";
    public static final int DEFAULT_CALORIES = 5;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final RoastOptions.Type DEFAULT_ROAST_OPTIONS = RoastOptions.Type.NONE;
    public static final int DEFAULT_NUMBER_OF_ESPRESSO_SHOTS = 0;
    public static final int DEFAULT_NUMBER_OF_CHAI_SCOOPS = 0;
    public static final int DEFAULT_NUMBER_OF_SWEETENER_LIQUID_PUMPS = 0;
    public static final int DEFAULT_NUMBER_OF_SWEETENER_PACKET_PACKS = 0;
    public static final int DEFAULT_NUMBER_OF_FLAVOR_SAUCE_PUMPS = 0;
    public static final int DEFAULT_NUMBER_OF_FLAVOR_SYRUP_PUMPS = 0;
    public static final Granular.Amount DEFAULT_COLD_FOAM_AMOUNT = Granular.Amount.NO;
    public static final Granular.Amount DEFAULT_CINNAMON_POWDER_AMOUNT = Granular.Amount.NO;
    public static final Granular.Amount DEFAULT_DRIZZLE_AMOUNT = Granular.Amount.NO;
    public static final Granular.Amount DEFAULT_TOPPING_AMOUNT = Granular.Amount.NO;
    public static final Granular.Amount DEFAULT_WHIPPED_CREAM_AMOUNT = Granular.Amount.NO;
    public static final LineTheCup.Type DEFAULT_LINE_THE_CUP = LineTheCup.Type.NO;
    public static final String DEFAULT_POWDERS = DrinkComponent.NULL_TYPE_AS_STRING;
    public static final Granular.Amount DEFAULT_MILK_CREAMER_AMOUNT = Granular.Amount.NO;
    public static final Granular.Amount DEFAULT_ROOM_AMOUNT = Granular.Amount.NO;
    public static final CupSize.Type DEFAULT_CUP_SIZE = CupSize.Type.NO;

    public static final double DEFAULT_PRICE_SMALL = 1.95;
    public static final double DEFAULT_PRICE_MEDIUM = 2.45;
    public static final double DEFAULT_PRICE_LARGE = 2.70;

    public FeaturedMediumRoastPikePlaceRoast() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // ESPRESSO_OPTIONS
        List<DrinkComponent> espressoOptions = new ArrayList<>();
        espressoOptions.add(new RoastOptions(null));
        espressoOptions.add(new Shot(null, Incrementable.QUANTITY_FOR_INVOKER));
        // TEA_OPTIONS
        List<DrinkComponent> teaOptions = new ArrayList<>();
        teaOptions.add(new Chai(null, Incrementable.QUANTITY_FOR_INVOKER));
        // SWEETENER_OPTIONS
        List<DrinkComponent> sweetenerOptions = new ArrayList<>();
        sweetenerOptions.add(new Liquid(null, Incrementable.QUANTITY_FOR_INVOKER));
        sweetenerOptions.add(new Packet(null, Incrementable.QUANTITY_FOR_INVOKER));
        // FLAVOR_OPTIONS
        List<DrinkComponent> flavorOptions = new ArrayList<>();
        flavorOptions.add(new Sauce(null, Incrementable.QUANTITY_FOR_INVOKER));
        flavorOptions.add(new Syrup(null, Incrementable.QUANTITY_FOR_INVOKER));
        // TOPPING_OPTIONS
        List<DrinkComponent> toppingOptions = new ArrayList<>();
        toppingOptions.add(new ColdFoam(null, DEFAULT_COLD_FOAM_AMOUNT));
        toppingOptions.add(new CinnamonPowder(null, DEFAULT_CINNAMON_POWDER_AMOUNT));
        toppingOptions.add(new Drizzle(null, DEFAULT_DRIZZLE_AMOUNT));
        toppingOptions.add(new Topping(null, DEFAULT_TOPPING_AMOUNT));
        toppingOptions.add(new WhippedCream(null, DEFAULT_WHIPPED_CREAM_AMOUNT));
        // ADD_INS_OPTIONS
        List<DrinkComponent> addInsOptions = new ArrayList<>();
        addInsOptions.add(new LineTheCup(DEFAULT_LINE_THE_CUP));
        addInsOptions.add(new Powders());
        addInsOptions.add(new MilkCreamer(null, DEFAULT_MILK_CREAMER_AMOUNT));
        addInsOptions.add(new Room(null, DEFAULT_ROOM_AMOUNT));
        // CUP_OPTIONS
        List<DrinkComponent> cupOptions = new ArrayList<>();
        CupSize cupSize = new CupSize(DEFAULT_CUP_SIZE);
        cupOptions.add(cupSize);

        // ESPRESSO_OPTIONS (defaults)
        List<String> espressoOptionsDefault = new ArrayList<>();
        espressoOptionsDefault.add(DEFAULT_ROAST_OPTIONS.name());
        espressoOptionsDefault.add(Integer.toString(DEFAULT_NUMBER_OF_ESPRESSO_SHOTS));
        // TEA_OPTIONS (defaults)
        List<String> teaOptionsDefault = new ArrayList<>();
        teaOptionsDefault.add(Integer.toString(DEFAULT_NUMBER_OF_CHAI_SCOOPS));
        // SWEETENER_OPTIONS (defaults)
        List<String> sweetenerOptionsDefault = new ArrayList<>();
        sweetenerOptionsDefault.add(Integer.toString(DEFAULT_NUMBER_OF_SWEETENER_LIQUID_PUMPS));
        sweetenerOptionsDefault.add(Integer.toString(DEFAULT_NUMBER_OF_SWEETENER_PACKET_PACKS));
        // FLAVOR_OPTIONS (defaults)
        List<String> flavorOptionsDefault = new ArrayList<>();
        flavorOptionsDefault.add(Integer.toString(DEFAULT_NUMBER_OF_FLAVOR_SAUCE_PUMPS));
        flavorOptionsDefault.add(Integer.toString(DEFAULT_NUMBER_OF_FLAVOR_SYRUP_PUMPS));
        // TOPPING_OPTIONS (defaults)
        List<String> toppingOptionsDefault = new ArrayList<>();
        toppingOptionsDefault.add(DEFAULT_COLD_FOAM_AMOUNT.name());
        toppingOptionsDefault.add(DEFAULT_CINNAMON_POWDER_AMOUNT.name());
        toppingOptionsDefault.add(DEFAULT_DRIZZLE_AMOUNT.name());
        toppingOptionsDefault.add(DEFAULT_TOPPING_AMOUNT.name());
        toppingOptionsDefault.add(DEFAULT_WHIPPED_CREAM_AMOUNT.name());
        // ADD_INS_OPTIONS (defaults)
        List<String> addInsOptionsDefault = new ArrayList<>();
        addInsOptionsDefault.add(DEFAULT_LINE_THE_CUP.name());
        addInsOptionsDefault.add(DEFAULT_POWDERS);
        addInsOptionsDefault.add(DEFAULT_MILK_CREAMER_AMOUNT.name());
        addInsOptionsDefault.add(DEFAULT_ROOM_AMOUNT.name());
        // CUP_OPTIONS (defaults)
        List<String> cupOptionsDefault = new ArrayList<>();
        cupOptionsDefault.add(DEFAULT_CUP_SIZE.name());

        drinkComponents.put(EspressoOptions.TAG, espressoOptions);
        drinkComponents.put(TeaOptions.TAG, teaOptions);
        drinkComponents.put(SweetenerOptions.TAG, sweetenerOptions);
        drinkComponents.put(FlavorOptions.TAG, flavorOptions);
        drinkComponents.put(ToppingOptions.TAG, toppingOptions);
        drinkComponents.put(AddInsOptions.TAG, addInsOptions);
        drinkComponents.put(CupOptions.TAG, cupOptions);
        drinkComponentsDefaultAsString.put(EspressoOptions.TAG, espressoOptionsDefault);
        drinkComponentsDefaultAsString.put(TeaOptions.TAG, teaOptionsDefault);
        drinkComponentsDefaultAsString.put(SweetenerOptions.TAG, sweetenerOptionsDefault);
        drinkComponentsDefaultAsString.put(FlavorOptions.TAG, flavorOptionsDefault);
        drinkComponentsDefaultAsString.put(ToppingOptions.TAG, toppingOptionsDefault);
        drinkComponentsDefaultAsString.put(AddInsOptions.TAG, addInsOptionsDefault);
        drinkComponentsDefaultAsString.put(CupOptions.TAG, cupOptionsDefault);

        for (String key : Menu.DRINK_COMPONENTS_KEYS) {
            if (drinkComponents.containsKey(key)) {
                List<DrinkComponent> drinkComponentsGroup = drinkComponents.get(key);
                for (DrinkComponent drinkComponent : drinkComponentsGroup) {
                    if (drinkComponent.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING)) {
                        continue;
                    } else {
                        drinkComponentsStandardRecipe.add(drinkComponent);
                    }
                }
            }
        }
    }
}
