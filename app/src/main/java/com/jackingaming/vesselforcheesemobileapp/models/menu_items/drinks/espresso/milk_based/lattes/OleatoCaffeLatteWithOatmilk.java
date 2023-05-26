package com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes;

public class OleatoCaffeLatteWithOatmilk extends Lattes {
    public static final String TAG = OleatoCaffeLatteWithOatmilk.class.getSimpleName();

    public static final String NAME_DEFAULT = "Oleato Caffe Latte with Oatmilk";
    public static final String DESCRIPTION_DEFAULT = "Starbucks Blonde Espresso infused with Partanna extra virgin olive oil, steamed with oatmilk. Velvety smooth. Deliciously lush.";
    public static final double PRICE_SMALL_DEFAULT = 2.95;
    public static final double PRICE_MEDIUM_DEFAULT = 3.45;
    public static final double PRICE_LARGE_DEFAULT = 3.70;
    public static final boolean ICED_DEFAULT = false;

    public OleatoCaffeLatteWithOatmilk() {
        super(NAME_DEFAULT, DESCRIPTION_DEFAULT, PRICE_MEDIUM_DEFAULT, ICED_DEFAULT);
    }
}
