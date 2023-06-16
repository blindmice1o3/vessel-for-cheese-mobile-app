package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes;

import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.PrepOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.PullOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.RoastOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.Shot;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.MilkBase;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.MilkFoam;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.Temperature;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.sweetener_options.Liquid;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.sweetener_options.SweetenerOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.tea_options.Chai;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.tea_options.TeaOptions;

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
    public static final int DEFAULT_NUMBER_OF_ESPRESSO_SHOTS = 2;

    // TODO: there are 2 different kinds of Type:
    //  (1) (NONE, LIGHT, MEDIUM, EXTRA)  <-- maybe turn into an interface (which means a 3rd ViewHolder)
    //  (2) varying Type.values()

    // TODO: there are 2 different kinds of Incrementable:
    //  (1) Type.values().length == 1 (e.g. AffogatoShot, Shot [have to change], Chai)
    //  (2) Type.values().length > 1  (e.g. Liquid, Packet, Sauce, Syrup)
    //          Use HashMap<Type, Integer> to map.put(HONEY_BLEND, quantityHoneyBlend)
    public static final PullOptions.Type DEFAULT_PULL_OPTIONS = PullOptions.Type.NONE;
    public static final PrepOptions.Type DEFAULT_PREP_OPTIONS = PrepOptions.Type.NONE;
    public static final int DEFAULT_NUMBER_OF_CHAI_SCOOPS = 0;
//    public static final Map<Liquid.Type, DEFAULT_LIQUID =

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;
    public static final boolean DEFAULT_ICED = false;

    public CaffeLatte() {
        super(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM, DEFAULT_ICED);

        drinkComponentsWhatsIncluded.add(new MilkFoam(DEFAULT_MILK_FOAM));
        drinkComponentsWhatsIncluded.add(new MilkBase(DEFAULT_MILK_BASE));
        drinkComponentsWhatsIncluded.add(new Temperature(DEFAULT_TEMPERATURE));
        drinkComponentsWhatsIncluded.add(new RoastOptions(DEFAULT_ROAST_OPTIONS));
        drinkComponentsWhatsIncluded.add(new Shot(DEFAULT_SHOT, DEFAULT_NUMBER_OF_ESPRESSO_SHOTS));

        drinkComponentsWhatsIncludedDefaultValuesAsStringArray =
                new String[drinkComponentsWhatsIncluded.size()];
        drinkComponentsWhatsIncludedDefaultValuesAsStringArray[0] = DEFAULT_MILK_FOAM.name();
        drinkComponentsWhatsIncludedDefaultValuesAsStringArray[1] = DEFAULT_MILK_BASE.name();
        drinkComponentsWhatsIncludedDefaultValuesAsStringArray[2] = DEFAULT_TEMPERATURE.name();
        drinkComponentsWhatsIncludedDefaultValuesAsStringArray[3] = DEFAULT_ROAST_OPTIONS.name();
        drinkComponentsWhatsIncludedDefaultValuesAsStringArray[4] = Integer.toString(DEFAULT_NUMBER_OF_ESPRESSO_SHOTS);

        drinkComponentsCustomized.add(new PullOptions(DEFAULT_PULL_OPTIONS));
        // TODO:
    }
}
