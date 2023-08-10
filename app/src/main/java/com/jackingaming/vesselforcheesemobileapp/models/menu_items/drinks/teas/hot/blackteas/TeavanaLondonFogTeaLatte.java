package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.hot.blackteas;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.teas.hot.HotTeas;

public class TeavanaLondonFogTeaLatte extends HotTeas {
    public static final String TAG = TeavanaLondonFogTeaLatte.class.getSimpleName();

    public static final int DEFAULT_IMAGE_RESOURCE_ID = R.drawable.harvest_moon_natsume;
    public static final String DEFAULT_NAME = "Teavana London Fog Tea Latte";
    public static final String DEFAULT_DESCRIPTION = "Bright, citrusy spark of Italian bergamot blends with subtle hints of lavender, vanilla syrup, and steamed milk for this frothy reinvention of classic Earl Grey tea.";
    public static final int DEFAULT_CALORIES = 180;
    public static final int DEFAULT_SUGAR_IN_GRAM = 29;
    public static final float DEFAULT_FAT_IN_GRAM = 4.0f;

    public static final double DEFAULT_PRICE_SMALL = 2.95;
    public static final double DEFAULT_PRICE_MEDIUM = 3.45;
    public static final double DEFAULT_PRICE_LARGE = 3.70;

    public TeavanaLondonFogTeaLatte() {
        super(DEFAULT_IMAGE_RESOURCE_ID, DEFAULT_NAME, DEFAULT_DESCRIPTION,
                DEFAULT_CALORIES, DEFAULT_SUGAR_IN_GRAM, DEFAULT_FAT_IN_GRAM,
                DEFAULT_PRICE_MEDIUM);
    }
}
