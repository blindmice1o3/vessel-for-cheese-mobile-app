package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.macchiatos.hot;

import com.jackingaming.vesselforcheesemobileapp.models.components.Granular;
import com.jackingaming.vesselforcheesemobileapp.models.components.Incrementable;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.LineTheCup;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.mixed_type.powders.base.Powders;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.cup_options.CupOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.cup_options.CupSize;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.EspressoOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.PrepOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.PullOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.RoastOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.Shot;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.flavor_options.Sauce;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.flavor_options.Syrup;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.MilkBase;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.MilkFoam;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.Temperature;
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
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;

import java.util.ArrayList;
import java.util.List;

public class CaramelMacchiato extends Macchiatos {
    public static final String TAG = CaramelMacchiato.class.getSimpleName();

    public static final String DEFAULT_NAME = "Caramel Macchiato";
    public static final String DEFAULT_DESCRIPTION = "Freshly steamed milk with vanilla-flavored syrup marked with espresso and topped with a caramel drizzle for an oh-so-sweet finish.";
    public static final int DEFAULT_CALORIES = 250;
    public static final int DEFAULT_SUGAR_IN_GRAM = 33;
    public static final float DEFAULT_FAT_IN_GRAM = 7.0f;

    public static final MilkFoam.Type DEFAULT_MILK_FOAM = MilkFoam.Type.MILK_FOAM;
    public static final Granular.Amount DEFAULT_MILK_FOAM_AMOUNT = Granular.Amount.MEDIUM;
    public static final MilkBase.Type DEFAULT_MILK_BASE = MilkBase.Type.TWO_PERCENT;
    public static final Temperature.Type DEFAULT_TEMPERATURE = Temperature.Type.MEDIUM;
    public static final RoastOptions.Type DEFAULT_ROAST_OPTIONS = RoastOptions.Type.SIGNATURE;
    public static final Shot.Type DEFAULT_SHOT = Shot.Type.SHOT;
    public static final int DEFAULT_NUMBER_OF_ESPRESSO_SHOTS_MIN = 1;
    public static final int DEFAULT_NUMBER_OF_ESPRESSO_SHOTS = 2;
    public static final PullOptions.Type DEFAULT_PULL_OPTIONS = PullOptions.Type.NONE;
    public static final PrepOptions.Type DEFAULT_PREP_OPTIONS = PrepOptions.Type.NONE;
    public static final int DEFAULT_NUMBER_OF_CHAI_SCOOPS = 0;
    public static final int DEFAULT_NUMBER_OF_SWEETENER_LIQUID_PUMPS = 0;
    public static final int DEFAULT_NUMBER_OF_SWEETENER_PACKET_PACKS = 0;
    public static final int DEFAULT_NUMBER_OF_FLAVOR_SAUCE_PUMPS = 0;
    public static final Syrup.Type DEFAULT_SYRUP_VANILLA = Syrup.Type.VANILLA;
    public static final int DEFAULT_NUMBER_OF_SYRUP_VANILLA_PUMPS = 3;
    public static final int DEFAULT_NUMBER_OF_FLAVOR_SYRUP_PUMPS = 0;
    public static final Granular.Amount DEFAULT_COLD_FOAM_AMOUNT = Granular.Amount.NO;
    public static final Granular.Amount DEFAULT_CINNAMON_POWDER_AMOUNT = Granular.Amount.NO;
    public static final Drizzle.Type DEFAULT_DRIZZLE_CARAMEL = Drizzle.Type.CARAMEL;
    public static final Granular.Amount DEFAULT_DRIZZLE_CARAMEL_AMOUNT = Granular.Amount.MEDIUM;
    public static final Granular.Amount DEFAULT_DRIZZLE_AMOUNT = Granular.Amount.NO;
    public static final Granular.Amount DEFAULT_TOPPING_AMOUNT = Granular.Amount.NO;
    public static final Granular.Amount DEFAULT_WHIPPED_CREAM_AMOUNT = Granular.Amount.NO;
    public static final LineTheCup.Type DEFAULT_LINE_THE_CUP = LineTheCup.Type.NO;
    public static final String DEFAULT_POWDERS = DrinkComponent.NULL_TYPE_AS_STRING;
    public static final CupSize.Type DEFAULT_CUP_SIZE = CupSize.Type.NO;
    public static final DrinkSize[] DEFAULT_DRINK_SIZES_ALLOWED = {DrinkSize.SHORT, DrinkSize.TALL, DrinkSize.GRANDE, DrinkSize.VENTI_HOT};

    public static final double DEFAULT_PRICE_SMALL = 1.95;
    public static final double DEFAULT_PRICE_MEDIUM = 2.45;
    public static final double DEFAULT_PRICE_LARGE = 2.70;
    public static final boolean DEFAULT_ICED = false;

    public CaramelMacchiato() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM, DEFAULT_ICED);
        // MILK_OPTIONS
        List<DrinkComponent> milkOptions = new ArrayList<>();
        milkOptions.add(new MilkFoam(DEFAULT_MILK_FOAM, DEFAULT_MILK_FOAM_AMOUNT));
        milkOptions.add(new MilkBase(DEFAULT_MILK_BASE));
        milkOptions.add(new Temperature(DEFAULT_TEMPERATURE));
        // ESPRESSO_OPTIONS
        List<DrinkComponent> espressoOptions = new ArrayList<>();
        espressoOptions.add(new RoastOptions(DEFAULT_ROAST_OPTIONS));
        Shot shot = new Shot(DEFAULT_SHOT, DEFAULT_NUMBER_OF_ESPRESSO_SHOTS);
        shot.setQuantityMin(DEFAULT_NUMBER_OF_ESPRESSO_SHOTS_MIN);
        espressoOptions.add(shot);
        espressoOptions.add(new PullOptions(null));
        espressoOptions.add(new PrepOptions(null));
        // TEA_OPTIONS
        List<DrinkComponent> teaOptions = new ArrayList<>();
        Chai chai = new Chai(null, Incrementable.QUANTITY_FOR_INVOKER);
        teaOptions.add(chai);
        // SWEETENER_OPTIONS
        List<DrinkComponent> sweetenerOptions = new ArrayList<>();
        Liquid liquid = new Liquid(null, Incrementable.QUANTITY_FOR_INVOKER);
        sweetenerOptions.add(liquid);
        Packet packet = new Packet(null, Incrementable.QUANTITY_FOR_INVOKER);
        sweetenerOptions.add(packet);
        // FLAVOR_OPTIONS
        List<DrinkComponent> flavorOptions = new ArrayList<>();
        Syrup syrupVanilla = new Syrup(DEFAULT_SYRUP_VANILLA, DEFAULT_NUMBER_OF_SYRUP_VANILLA_PUMPS);
        flavorOptions.add(syrupVanilla);
        Sauce sauce = new Sauce(null, Incrementable.QUANTITY_FOR_INVOKER);
        flavorOptions.add(sauce);
        Syrup syrup = new Syrup(null, Incrementable.QUANTITY_FOR_INVOKER);
        flavorOptions.add(syrup);
        // TOPPING_OPTIONS
        List<DrinkComponent> toppingOptions = new ArrayList<>();
        Drizzle drizzleCaramel = new Drizzle(DEFAULT_DRIZZLE_CARAMEL, DEFAULT_DRIZZLE_CARAMEL_AMOUNT);
        toppingOptions.add(drizzleCaramel);
        ColdFoam coldFoam = new ColdFoam(null, Granular.Amount.NO);
        toppingOptions.add(coldFoam);
        CinnamonPowder cinnamonPowder = new CinnamonPowder(null, Granular.Amount.NO);
        toppingOptions.add(cinnamonPowder);
        Drizzle drizzle = new Drizzle(null, Granular.Amount.NO);
        toppingOptions.add(drizzle);
        Topping topping = new Topping(null, Granular.Amount.NO);
        toppingOptions.add(topping);
        WhippedCream whippedCream = new WhippedCream(null, Granular.Amount.NO);
        toppingOptions.add(whippedCream);
        // ADD_INS_OPTIONS
        List<DrinkComponent> addInsOptions = new ArrayList<>();
        LineTheCup lineTheCup = new LineTheCup(DEFAULT_LINE_THE_CUP);
        addInsOptions.add(lineTheCup);
        Powders powders = new Powders();
        addInsOptions.add(powders);
        // CUP_OPTIONS
        List<DrinkComponent> cupOptions = new ArrayList<>();
        CupSize cupSize = new CupSize(DEFAULT_CUP_SIZE);
        cupOptions.add(cupSize);

        // MILK_OPTIONS (defaults)
        List<String> milkOptionsDefault = new ArrayList<>();
        milkOptionsDefault.add(DEFAULT_MILK_FOAM_AMOUNT.name());
        milkOptionsDefault.add(DEFAULT_MILK_BASE.name());
        milkOptionsDefault.add(DEFAULT_TEMPERATURE.name());
        // ESPRESSO_OPTIONS (defaults)
        List<String> espressoOptionsDefault = new ArrayList<>();
        espressoOptionsDefault.add(DEFAULT_ROAST_OPTIONS.name());
        espressoOptionsDefault.add(Integer.toString(DEFAULT_NUMBER_OF_ESPRESSO_SHOTS));
        espressoOptionsDefault.add(DEFAULT_PULL_OPTIONS.name());
        espressoOptionsDefault.add(DEFAULT_PREP_OPTIONS.name());
        // TEA_OPTIONS (defaults)
        List<String> teaOptionsDefault = new ArrayList<>();
        teaOptionsDefault.add(Integer.toString(DEFAULT_NUMBER_OF_CHAI_SCOOPS));
        // SWEETENER_OPTIONS (defaults)
        List<String> sweetenerOptionsDefault = new ArrayList<>();
        sweetenerOptionsDefault.add(Integer.toString(DEFAULT_NUMBER_OF_SWEETENER_LIQUID_PUMPS));
        sweetenerOptionsDefault.add(Integer.toString(DEFAULT_NUMBER_OF_SWEETENER_PACKET_PACKS));
        // FLAVOR_OPTIONS (defaults)
        List<String> flavorOptionsDefault = new ArrayList<>();
        flavorOptionsDefault.add(Integer.toString(DEFAULT_NUMBER_OF_SYRUP_VANILLA_PUMPS));
        flavorOptionsDefault.add(Integer.toString(DEFAULT_NUMBER_OF_FLAVOR_SAUCE_PUMPS));
        flavorOptionsDefault.add(Integer.toString(DEFAULT_NUMBER_OF_FLAVOR_SYRUP_PUMPS));
        // TOPPING_OPTIONS (defaults)
        List<String> toppingOptionsDefault = new ArrayList<>();
        toppingOptionsDefault.add(DEFAULT_DRIZZLE_CARAMEL_AMOUNT.name());
        toppingOptionsDefault.add(DEFAULT_COLD_FOAM_AMOUNT.name());
        toppingOptionsDefault.add(DEFAULT_CINNAMON_POWDER_AMOUNT.name());
        toppingOptionsDefault.add(DEFAULT_DRIZZLE_AMOUNT.name());
        toppingOptionsDefault.add(DEFAULT_TOPPING_AMOUNT.name());
        toppingOptionsDefault.add(DEFAULT_WHIPPED_CREAM_AMOUNT.name());
        // ADD_INS_OPTIONS (defaults)
        List<String> addInsOptionsDefault = new ArrayList<>();
        addInsOptionsDefault.add(DEFAULT_LINE_THE_CUP.name());
        addInsOptionsDefault.add(DEFAULT_POWDERS);
        // CUP_OPTIONS (defaults)
        List<String> cupOptionsDefault = new ArrayList<>();
        cupOptionsDefault.add(DEFAULT_CUP_SIZE.name());

        drinkComponents.put(MilkOptions.TAG, milkOptions);
        drinkComponents.put(EspressoOptions.TAG, espressoOptions);
        drinkComponents.put(TeaOptions.TAG, teaOptions);
        drinkComponents.put(SweetenerOptions.TAG, sweetenerOptions);
        drinkComponents.put(FlavorOptions.TAG, flavorOptions);
        drinkComponents.put(ToppingOptions.TAG, toppingOptions);
        drinkComponents.put(AddInsOptions.TAG, addInsOptions);
        drinkComponents.put(CupOptions.TAG, cupOptions);
        drinkComponentsDefaultAsString.put(MilkOptions.TAG, milkOptionsDefault);
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

        drinkSizesAllowed = DEFAULT_DRINK_SIZES_ALLOWED;
    }
}
