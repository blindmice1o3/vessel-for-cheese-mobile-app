package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.mochas;

public class CaffeMocha extends Mochas {
    public static final String TAG = CaffeMocha.class.getSimpleName();

    public static final String NAME_DEFAULT = "Caffe Mocha";
    public static final String DESCRIPTION_DEFAULT = "Our rich, full-bodied espresso combined with bittersweet mocha sauce and steamed milk, then topped with sweetened whipped cream. The classic coffee drink that always sweetly satisfies.";
    public static final double PRICE_SMALL_DEFAULT = 1.95;
    public static final double PRICE_MEDIUM_DEFAULT = 2.45;
    public static final double PRICE_LARGE_DEFAULT = 2.70;
    public static final boolean ICED_DEFAULT = false;

    public CaffeMocha() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_MEDIUM_DEFAULT, ICED_DEFAULT);
    }
}
