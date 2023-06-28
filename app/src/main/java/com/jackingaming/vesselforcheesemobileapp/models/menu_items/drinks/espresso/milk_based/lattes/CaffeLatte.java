package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes;

import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.EspressoOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.PrepOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.PullOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.RoastOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.Shot;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.MilkBase;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.MilkFoam;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.Temperature;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.sweetener_options.Liquid;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.sweetener_options.Packet;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.sweetener_options.SweetenerOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.tea_options.Chai;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.tea_options.TeaOptions;
import com.jackingaming.vesselforcheesemobileapp.models.menu.Menu;

import java.util.ArrayList;
import java.util.List;

public class CaffeLatte extends Lattes {
    public static final String TAG = CaffeLatte.class.getSimpleName();

    public static final String DEFAULT_NAME = "Caffe Latte";
    public static final String DEFAULT_DESCRIPTION = "Our dark, rich espresso balanced with steamed milk and a light layer of foam. A perfect milk-forward warm-up.";
    public static final int DEFAULT_CALORIES = 190;
    public static final int DEFAULT_SUGAR_IN_GRAM = 18;
    public static final float DEFAULT_FAT_IN_GRAM = 7.0f;

    public static final MilkFoam.Type DEFAULT_MILK_FOAM = MilkFoam.Type.MEDIUM;
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

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;
    public static final boolean DEFAULT_ICED = false;

    public CaffeLatte() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM, DEFAULT_ICED);
        // MILK_OPTIONS
        List<DrinkComponent> milkOptions = new ArrayList<>();
        milkOptions.add(new MilkFoam(DEFAULT_MILK_FOAM));
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
        Chai chai = new Chai(null, DEFAULT_NUMBER_OF_CHAI_SCOOPS);
        teaOptions.add(chai);
        // SWEETENER_OPTIONS
        List<DrinkComponent> sweetenerOptions = new ArrayList<>();
        Liquid liquid = new Liquid(null, DEFAULT_NUMBER_OF_SWEETENER_LIQUID_PUMPS);
        sweetenerOptions.add(liquid);
        Packet packet = new Packet(null, DEFAULT_NUMBER_OF_SWEETENER_PACKET_PACKS);
        sweetenerOptions.add(packet);

        // MILK_OPTIONS (defaults)
        List<String> milkOptionsDefault = new ArrayList<>();
        milkOptionsDefault.add(DEFAULT_MILK_FOAM.name());
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

        drinkComponents.put(MilkOptions.TAG, milkOptions);
        drinkComponents.put(EspressoOptions.TAG, espressoOptions);
        drinkComponents.put(TeaOptions.TAG, teaOptions);
        drinkComponents.put(SweetenerOptions.TAG, sweetenerOptions);
        drinkComponentsDefaultAsString.put(MilkOptions.TAG, milkOptionsDefault);
        drinkComponentsDefaultAsString.put(EspressoOptions.TAG, espressoOptionsDefault);
        drinkComponentsDefaultAsString.put(TeaOptions.TAG, teaOptionsDefault);
        drinkComponentsDefaultAsString.put(SweetenerOptions.TAG, sweetenerOptionsDefault);

        for (int i = 0; i < Menu.DRINK_COMPONENTS_KEYS.size(); i++) {
            String key = Menu.DRINK_COMPONENTS_KEYS.get(i);
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
