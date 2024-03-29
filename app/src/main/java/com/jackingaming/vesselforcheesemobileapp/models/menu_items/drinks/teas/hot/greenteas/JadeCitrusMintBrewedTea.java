package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.hot.greenteas;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.components.Granular;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.MilkCreamer;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.Room;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.lemonade_options.Lemonade;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.lemonade_options.LemonadeOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.tea_options.TeaBag;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.tea_options.TeaOptions;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.hot.HotTeas;

import java.util.ArrayList;
import java.util.List;

public class JadeCitrusMintBrewedTea extends HotTeas {
    public static final String TAG = JadeCitrusMintBrewedTea.class.getSimpleName();

    public static final String ID = "JadeCitrusMintBrewedTea";
    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Jade Citrus Mint Brewed Tea";
    public static final String DEFAULT_DESCRIPTION = "Green tea, lemon verbena, lemongrass and a hint of spearmint mingle for a bright, refreshing, citrusy green tea experience.";
    public static final int DEFAULT_CALORIES = 0;
    public static final int DEFAULT_SUGAR_IN_GRAM = 0;
    public static final float DEFAULT_FAT_IN_GRAM = 0.0f;

    public static final Granular.Amount DEFAULT_LEMONADE_AMOUNT = Granular.Amount.NO;
    public static final TeaBag.Type DEFAULT_TEA_BAG = TeaBag.Type.TEA_BAG;
    public static final Granular.Amount DEFAULT_MILK_CREAMER_AMOUNT = Granular.Amount.NO;
    public static final Granular.Amount DEFAULT_ROOM_AMOUNT = Granular.Amount.NO;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public JadeCitrusMintBrewedTea() {
        super(ID, DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);

        // LEMONADE_OPTIONS
        List<DrinkComponentWithDefaultAsString> lemonadeOptions = new ArrayList<>();
        lemonadeOptions.add(new DrinkComponentWithDefaultAsString(
                new Lemonade(null, DEFAULT_LEMONADE_AMOUNT), DEFAULT_LEMONADE_AMOUNT.name()
        ));

        drinkComponents.put(LemonadeOptions.TAG, lemonadeOptions);

        // TEA_OPTIONS
        int numberOfTeaBagByDrinkSize = getNumberOfTeaBagByDrinkSize(drinkSize);
        TeaBag teaBag = new TeaBag(DEFAULT_TEA_BAG, numberOfTeaBagByDrinkSize);

        List<DrinkComponentWithDefaultAsString> teaOptions = new ArrayList<>();
        teaOptions.add(0, new DrinkComponentWithDefaultAsString(
                teaBag, Integer.toString(numberOfTeaBagByDrinkSize)
        ));
        drinkComponentsStandardRecipe.add(teaBag);

        drinkComponents.put(TeaOptions.TAG, teaOptions);

        // ADD_INS_OPTIONS
        List<DrinkComponentWithDefaultAsString> addInsOptions = new ArrayList<>();
        addInsOptions.add(new DrinkComponentWithDefaultAsString(
                new MilkCreamer(null, DEFAULT_MILK_CREAMER_AMOUNT), DEFAULT_MILK_CREAMER_AMOUNT.name()
        ));
        addInsOptions.add(new DrinkComponentWithDefaultAsString(
                new Room(null, DEFAULT_ROOM_AMOUNT), DEFAULT_ROOM_AMOUNT.name()
        ));

        drinkComponents.put(AddInsOptions.TAG, addInsOptions);
    }
}
