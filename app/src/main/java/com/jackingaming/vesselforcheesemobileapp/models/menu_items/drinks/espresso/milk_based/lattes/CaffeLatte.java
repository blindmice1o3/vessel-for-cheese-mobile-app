package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes;

import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.RoastOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.Shot;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.MilkBase;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.MilkFoam;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.Temperature;

public class CaffeLatte extends Lattes {
    public static final String TAG = CaffeLatte.class.getSimpleName();

    public static final String NAME_DEFAULT = "Caffe Latte";
    public static final String DESCRIPTION_DEFAULT = "Our dark, rich espresso balanced with steamed milk and a light layer of foam. A perfect milk-forward warm-up.";
    public static final double PRICE_SMALL_DEFAULT = 2.95;
    public static final double PRICE_MEDIUM_DEFAULT = 3.45;
    public static final double PRICE_LARGE_DEFAULT = 3.70;
    public static final boolean ICED_DEFAULT = false;

    public CaffeLatte() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_MEDIUM_DEFAULT, ICED_DEFAULT);

        drinkComponentsWhatsIncluded.add(new MilkFoam(MilkFoam.Type.MEDIUM));
        drinkComponentsWhatsIncluded.add(new MilkBase(MilkBase.Type.TWO_PERCENT));
        drinkComponentsWhatsIncluded.add(new Temperature(Temperature.Type.MEDIUM));
        drinkComponentsWhatsIncluded.add(new RoastOptions(RoastOptions.Type.SIGNATURE));
        drinkComponentsWhatsIncluded.add(new Shot(Shot.Type.TWO));
    }
}
