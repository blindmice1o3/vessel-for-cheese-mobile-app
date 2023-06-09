package com.jackingaming.vesselforcheesemobileapp.models.menu;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.AddInsOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.blended_options.BlendedOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.cup_options.CupOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.EspressoOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.flavor_options.FlavorOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.juice_options.JuiceOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.lemonade_options.LemonadeOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.preparation_options.PreparationOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.refresher_base_options.RefresherBaseOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.sweetener_options.SweetenerOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.tea_options.TeaOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.topping_options.ToppingOptions;
import com.jackingaming.vesselforcheesemobileapp.models.menu.categories.Category;
import com.jackingaming.vesselforcheesemobileapp.models.menu.categories.MenuItemCategory;
import com.jackingaming.vesselforcheesemobileapp.models.menu.categories.TitleCategory;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.MenuItem;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.UndefinedMenuItem;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.CaffeMisto;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.CostaRicaNaranjo;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.DarkRoast;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.DecafPikePlaceRoast;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.EcuadorLoja;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.GreenApronBlend;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.PapuaNewGuineaMoanti;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.PikePlaceRoast;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.RwandaSholi;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.cappuccinos.Cappuccino;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.flat_whites.FlatWhite;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.flat_whites.HoneyAlmondmilkFlatWhite;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes.CaffeLatte;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes.CinnamonDolceLatte;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes.OleatoCaffeLatteWithOatmilk;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes.StarbucksBlondeVanillaLatte;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes.StarbucksReserveHazelnutBiancoLatte;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes.StarbucksReserveLatte;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.macchiatos.CaramelMacchiato;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.macchiatos.EspressoMacchiato;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.mochas.CaffeMocha;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.mochas.StarbucksReserveDarkChocolateMocha;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.mochas.WhiteChocolateMocha;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.straight_shots.EspressoConPanna;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.straight_shots.ShotEspresso;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.water_based.americanos.CaffeAmericano;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.other.Water;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.travelers.VerandaBlend;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.foods.Bread;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.sides.SteamedVegetable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    public static final String TAG = Menu.class.getSimpleName();
    public static final String HOT_COFFEES = "Hot Coffees";
    public static final String AMERICANOS = "Americanos";
    public static final String BREWED_COFFEES = "Brewed Coffees";
    public static final String CAPPUCCINOS = "Cappuccinos";
    public static final String ESPRESSO_SHOTS = "Espresso Shots";
    public static final String FLAT_WHITES = "Flat Whites";
    public static final String LATTES = "Lattes";
    public static final String MACCHIATOS = "Macchiatos";
    public static final String MOCHAS = "Mochas";
    public static final String COFFEE_TRAVELERS = "Coffee Travelers";

    public static final List<String> DRINK_COMPONENTS_KEYS = Arrays.asList(
            LemonadeOptions.TAG,
            PreparationOptions.TAG,
            MilkOptions.TAG,
            EspressoOptions.TAG,
            BlendedOptions.TAG,
            RefresherBaseOptions.TAG,
            TeaOptions.TAG,
            JuiceOptions.TAG,
            SweetenerOptions.TAG,
            FlavorOptions.TAG,
            ToppingOptions.TAG,
            AddInsOptions.TAG,
            CupOptions.TAG
    );

    public static final List<MenuItemCategory> hotCoffees = Arrays.asList(
            new MenuItemCategory(AMERICANOS, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(BREWED_COFFEES, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(CAPPUCCINOS, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(ESPRESSO_SHOTS, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(FLAT_WHITES, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(LATTES, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(MACCHIATOS, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(MOCHAS, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(COFFEE_TRAVELERS, R.drawable.harvest_moon_natsume)
    );

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public static final List<MenuItem> americanos = Arrays.asList(
            new CaffeAmericano()
    );

    public static final List<MenuItem> brewedCoffees = Arrays.asList(
            new GreenApronBlend(),
            new PikePlaceRoast(),
            new DarkRoast(),
            new DecafPikePlaceRoast(),
            new RwandaSholi(),
            new PapuaNewGuineaMoanti(),
            new CostaRicaNaranjo(),
            new EcuadorLoja(),
            new CaffeMisto()
    );

    public static final List<MenuItem> cappuccinos = Arrays.asList(
            new Cappuccino()
    );

    public static final List<MenuItem> espressoShots = Arrays.asList(
            new ShotEspresso(),
            new EspressoConPanna()
    );

    public static final List<MenuItem> flatWhites = Arrays.asList(
            new FlatWhite(),
            new HoneyAlmondmilkFlatWhite()
    );

    public static final List<MenuItem> lattes = Arrays.asList(
            new OleatoCaffeLatteWithOatmilk(),
            new CaffeLatte(),
            new CinnamonDolceLatte(),
            new StarbucksReserveLatte(),
            new StarbucksReserveHazelnutBiancoLatte(),
            new StarbucksBlondeVanillaLatte()
    );

    public static final List<MenuItem> macchiatos = Arrays.asList(
            new CaramelMacchiato(),
            new EspressoMacchiato()
    );
    public static final List<MenuItem> mochas = Arrays.asList(
            new CaffeMocha(),
            new WhiteChocolateMocha(),
            new StarbucksReserveDarkChocolateMocha()
    );

    public static final List<MenuItem> coffeeTravelers = Arrays.asList(
            new VerandaBlend(),
            new com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.travelers.DarkRoast(),
            new com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.travelers.PikePlaceRoast(),
            new com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.travelers.DecafPikePlaceRoast()
    );

    public static final Map<String, List<MenuItem>> hotCoffeesAsMap = new HashMap<String, List<MenuItem>>();

    static {
        hotCoffeesAsMap.put(AMERICANOS, americanos);
        hotCoffeesAsMap.put(BREWED_COFFEES, brewedCoffees);
        hotCoffeesAsMap.put(CAPPUCCINOS, cappuccinos);
        hotCoffeesAsMap.put(ESPRESSO_SHOTS, espressoShots);
        hotCoffeesAsMap.put(FLAT_WHITES, flatWhites);
        hotCoffeesAsMap.put(LATTES, lattes);
        hotCoffeesAsMap.put(MACCHIATOS, macchiatos);
        hotCoffeesAsMap.put(MOCHAS, mochas);
        hotCoffeesAsMap.put(COFFEE_TRAVELERS, coffeeTravelers);
    }

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public static final List<Category> drinks = Arrays.asList(
            new MenuItemCategory("Oileeto", R.drawable.harvest_moon_natsume),
            new MenuItemCategory(HOT_COFFEES, R.drawable.harvest_moon_natsume),
            new MenuItemCategory("Hot Teas", R.drawable.harvest_moon_natsume),
            new MenuItemCategory("Hot Drinks", R.drawable.harvest_moon_natsume),
            new MenuItemCategory("Blended Beverages", R.drawable.harvest_moon_natsume),
            new MenuItemCategory("Cold Coffees", R.drawable.harvest_moon_natsume),
            new MenuItemCategory("Iced Teas", R.drawable.harvest_moon_natsume),
            new MenuItemCategory("Cold Drinks", R.drawable.harvest_moon_natsume)
    );

    public static final List<Category> food = Arrays.asList(
            new MenuItemCategory("Hot Breakfast", R.drawable.harvest_moon_natsume),
            new MenuItemCategory("Oatmeal & Yogurt", R.drawable.harvest_moon_natsume),
            new MenuItemCategory("Bakery", R.drawable.harvest_moon_natsume),
            new MenuItemCategory("Lunch", R.drawable.harvest_moon_natsume),
            new MenuItemCategory("Snacks & Sweets", R.drawable.harvest_moon_natsume)
    );

    public static final List<Category> atHomeCoffee = Arrays.asList(
            new MenuItemCategory("Whole Bean", R.drawable.harvest_moon_natsume),
            new MenuItemCategory("Instant Coffee", R.drawable.harvest_moon_natsume)
    );

    public static final List<Category> merchandise = Arrays.asList(
            new MenuItemCategory("Cold Cups", R.drawable.harvest_moon_natsume),
            new MenuItemCategory("Tumblers", R.drawable.harvest_moon_natsume),
            new MenuItemCategory("Mugs", R.drawable.harvest_moon_natsume),
            new MenuItemCategory("Water Bottles", R.drawable.harvest_moon_natsume),
            new MenuItemCategory("Other", R.drawable.harvest_moon_natsume)
    );

    public static final List<Category> giftCards = Arrays.asList(
            new MenuItemCategory("Happy Birthday", R.drawable.harvest_moon_natsume),
            new MenuItemCategory("Thank You", R.drawable.harvest_moon_natsume),
            new MenuItemCategory("Traditional", R.drawable.harvest_moon_natsume)
    );

    public static final List<Category> categories = new ArrayList<Category>();

    static {
        categories.add(new TitleCategory("Drinks", drinks.size()));
        categories.addAll(drinks);
        categories.add(new TitleCategory("Food", food.size()));
        categories.addAll(food);
        categories.add(new TitleCategory("At Home Coffee", atHomeCoffee.size()));
        categories.addAll(atHomeCoffee);
        categories.add(new TitleCategory("Merchandise", merchandise.size()));
        categories.addAll(merchandise);
        categories.add(new TitleCategory("Gift Cards", giftCards.size()));
        categories.addAll(giftCards);
    }

//    public static String parseDrinkComponentForStringRepresentation(DrinkComponent drinkComponent) {
//        String stringRepresentationOfDrinkComponent = null;
//        if (drinkComponent instanceof AddInsOptions) {
//            AddInsOptions addInsOptions = (AddInsOptions) drinkComponent;
//            stringRepresentationOfDrinkComponent = addInsOptions.toString();
//        } else if (drinkComponent instanceof BlendedOptions) {
//            BlendedOptions blendedOptions = (BlendedOptions) drinkComponent;
//            stringRepresentationOfDrinkComponent = blendedOptions.toString();
//        } else if (drinkComponent instanceof CupOptions) {
//            CupOptions cupOptions = (CupOptions) drinkComponent;
//            stringRepresentationOfDrinkComponent = cupOptions.toString();
//        } else if (drinkComponent instanceof EspressoOptions) {
//            EspressoOptions espressoOptions = (EspressoOptions) drinkComponent;
//            stringRepresentationOfDrinkComponent = espressoOptions.toString();
//        } else if (drinkComponent instanceof FlavorOptions) {
//            FlavorOptions flavorOptions = (FlavorOptions) drinkComponent;
//            stringRepresentationOfDrinkComponent = flavorOptions.toString();
//        } else if (drinkComponent instanceof JuiceOptions) {
//            JuiceOptions juiceOptions = (JuiceOptions) drinkComponent;
//            stringRepresentationOfDrinkComponent = juiceOptions.toString();
//        } else if (drinkComponent instanceof LemonadeOptions) {
//            LemonadeOptions lemonadeOptions = (LemonadeOptions) drinkComponent;
//            stringRepresentationOfDrinkComponent = lemonadeOptions.toString();
//        } else if (drinkComponent instanceof MilkOptions) {
//            MilkOptions milkOptions = (MilkOptions) drinkComponent;
//            stringRepresentationOfDrinkComponent = milkOptions.toString();
//        } else if (drinkComponent instanceof PreparationOptions) {
//            PreparationOptions preparationOptions = (PreparationOptions) drinkComponent;
//            stringRepresentationOfDrinkComponent = preparationOptions.toString();
//        } else if (drinkComponent instanceof RefresherBaseOptions) {
//            RefresherBaseOptions refresherBaseOptions = (RefresherBaseOptions) drinkComponent;
//            stringRepresentationOfDrinkComponent = refresherBaseOptions.toString();
//        } else if (drinkComponent instanceof SizeOptions) {
//            SizeOptions sizeOptions = (SizeOptions) drinkComponent;
//            stringRepresentationOfDrinkComponent = sizeOptions.toString();
//        } else if (drinkComponent instanceof SweetenerOptions) {
//            SweetenerOptions sweetenerOptions = (SweetenerOptions) drinkComponent;
//            stringRepresentationOfDrinkComponent = sweetenerOptions.toString();
//        } else if (drinkComponent instanceof TeaOptions) {
//            TeaOptions teaOptions = (TeaOptions) drinkComponent;
//            stringRepresentationOfDrinkComponent = teaOptions.toString();
//        } else if (drinkComponent instanceof ToppingOptions) {
//            ToppingOptions toppingOptions = (ToppingOptions) drinkComponent;
//            stringRepresentationOfDrinkComponent = toppingOptions.toString();
//        } else {
//            if (drinkComponent instanceof UndefinedDrinkComponent) {
//                UndefinedDrinkComponent undefinedDrinkComponent = (UndefinedDrinkComponent) drinkComponent;
//                stringRepresentationOfDrinkComponent = undefinedDrinkComponent.toString();
//            } else {
//                stringRepresentationOfDrinkComponent = drinkComponent.getClass().getSimpleName();
//            }
//        }
//        return stringRepresentationOfDrinkComponent;
//    }

    // TODO: instantiateSyrupByButtonTag(String)
    // TODO: instantiateMilkByButtonTag(String)
    // TODO: instantiateCustomizationByButtonTag(String)
//    public static DrinkComponent instantiateDrinkComponentByButtonTag(String tagOfSelectedButton) {
//        DrinkComponent drinkComponentSelected = null;
//        // FlavorOptions.Syrup
//        if (tagOfSelectedButton.equals(FlavorOptions.Syrup.BROWN_SUGAR.name())) {
//            drinkComponentSelected = new FlavorOptions(FlavorOptions.Syrup.BROWN_SUGAR);
//        } else if (tagOfSelectedButton.equals(FlavorOptions.Syrup.CARAMEL.name())) {
//            drinkComponentSelected = new FlavorOptions(FlavorOptions.Syrup.CARAMEL);
//        } else if (tagOfSelectedButton.equals(FlavorOptions.Syrup.CINNAMON_DOLCE.name())) {
//            drinkComponentSelected = new FlavorOptions(FlavorOptions.Syrup.CINNAMON_DOLCE);
//        } else if (tagOfSelectedButton.equals(FlavorOptions.Syrup.HAZELNUT.name())) {
//            drinkComponentSelected = new FlavorOptions(FlavorOptions.Syrup.HAZELNUT);
//        } else if (tagOfSelectedButton.equals(FlavorOptions.Syrup.PEPPERMINT.name())) {
//            drinkComponentSelected = new FlavorOptions(FlavorOptions.Syrup.PEPPERMINT);
//        } else if (tagOfSelectedButton.equals(FlavorOptions.Syrup.RASPBERRY.name())) {
//            drinkComponentSelected = new FlavorOptions(FlavorOptions.Syrup.RASPBERRY);
//        } else if (tagOfSelectedButton.equals(FlavorOptions.Syrup.SUGAR_FREE_VANILLA.name())) {
//            drinkComponentSelected = new FlavorOptions(FlavorOptions.Syrup.SUGAR_FREE_VANILLA);
//        } else if (tagOfSelectedButton.equals(FlavorOptions.Syrup.TOASTED_VANILLA.name())) {
//            drinkComponentSelected = new FlavorOptions(FlavorOptions.Syrup.TOASTED_VANILLA);
//        } else if (tagOfSelectedButton.equals(FlavorOptions.Syrup.TOFFEE_NUT.name())) {
//            drinkComponentSelected = new FlavorOptions(FlavorOptions.Syrup.TOFFEE_NUT);
//        } else if (tagOfSelectedButton.equals(FlavorOptions.Syrup.VANILLA.name())) {
//            drinkComponentSelected = new FlavorOptions(FlavorOptions.Syrup.VANILLA);
//        }
//        // FlavorOptions.Sauce
//        else if (tagOfSelectedButton.equals(FlavorOptions.Sauce.DARK_CARAMEL.name())) {
//            drinkComponentSelected = new FlavorOptions(FlavorOptions.Sauce.DARK_CARAMEL);
//        } else if (tagOfSelectedButton.equals(FlavorOptions.Sauce.MOCHA.name())) {
//            drinkComponentSelected = new FlavorOptions(FlavorOptions.Sauce.MOCHA);
//        } else if (tagOfSelectedButton.equals(FlavorOptions.Sauce.PISTACHIO.name())) {
//            drinkComponentSelected = new FlavorOptions(FlavorOptions.Sauce.PISTACHIO);
//        } else if (tagOfSelectedButton.equals(FlavorOptions.Sauce.WHITE_CHOCOLATE_MOCHA.name())) {
//            drinkComponentSelected = new FlavorOptions(FlavorOptions.Sauce.WHITE_CHOCOLATE_MOCHA);
//        }
//        // SweetenerOptions.Liquid
//        else if (tagOfSelectedButton.equals(SweetenerOptions.Liquid.CLASSIC.name())) {
//            drinkComponentSelected = new SweetenerOptions(SweetenerOptions.Liquid.CLASSIC);
//        } else if (tagOfSelectedButton.equals(SweetenerOptions.Liquid.HONEY_BLEND.name())) {
//            drinkComponentSelected = new SweetenerOptions(SweetenerOptions.Liquid.HONEY_BLEND);
//        } else if (tagOfSelectedButton.equals(SweetenerOptions.Liquid.LIQUID_CANE.name())) {
//            drinkComponentSelected = new SweetenerOptions(SweetenerOptions.Liquid.LIQUID_CANE);
//        }
//        // TeaOptions.Chai
//        else if (tagOfSelectedButton.equals(TeaOptions.Chai.CHAI.name())) {
//            drinkComponentSelected = new TeaOptions(TeaOptions.Chai.CHAI);
//        }
//        // MilkOptions.MilkBase
//        else if (tagOfSelectedButton.equals(MilkOptions.MilkBase.TWO_PERCENT.name())) {
//            drinkComponentSelected = new MilkOptions(MilkOptions.MilkBase.TWO_PERCENT);
//        } else if (tagOfSelectedButton.equals(MilkOptions.MilkBase.BREVE.name())) {
//            drinkComponentSelected = new MilkOptions(MilkOptions.MilkBase.BREVE);
//        } else if (tagOfSelectedButton.equals(MilkOptions.MilkBase.COCONUT.name())) {
//            drinkComponentSelected = new MilkOptions(MilkOptions.MilkBase.COCONUT);
//        } else if (tagOfSelectedButton.equals(MilkOptions.MilkBase.HEAVY_CREAM.name())) {
//            drinkComponentSelected = new MilkOptions(MilkOptions.MilkBase.HEAVY_CREAM);
//        } else if (tagOfSelectedButton.equals(MilkOptions.MilkBase.NONFAT_MILK.name())) {
//            drinkComponentSelected = new MilkOptions(MilkOptions.MilkBase.NONFAT_MILK);
//        } else if (tagOfSelectedButton.equals(MilkOptions.MilkBase.OATMILK.name())) {
//            drinkComponentSelected = new MilkOptions(MilkOptions.MilkBase.OATMILK);
//        } else if (tagOfSelectedButton.equals(MilkOptions.MilkBase.SOY.name())) {
//            drinkComponentSelected = new MilkOptions(MilkOptions.MilkBase.SOY);
//        } else if (tagOfSelectedButton.equals(MilkOptions.MilkBase.VANILLA_SWEET_CREAM.name())) {
//            drinkComponentSelected = new MilkOptions(MilkOptions.MilkBase.VANILLA_SWEET_CREAM);
//        } else if (tagOfSelectedButton.equals(MilkOptions.MilkBase.WHOLE_MILK.name())) {
//            drinkComponentSelected = new MilkOptions(MilkOptions.MilkBase.WHOLE_MILK);
//        } else if (tagOfSelectedButton.equals(MilkOptions.MilkBase.ALMOND.name())) {
//            drinkComponentSelected = new MilkOptions(MilkOptions.MilkBase.ALMOND);
//        }
//        // CUSTOMIZATIONS
//        else if (tagOfSelectedButton.equals(AddInsOptions.Ice.class.getSimpleName())) {
//            drinkComponentSelected = new AddInsOptions(AddInsOptions.Ice.MEDIUM);
//        } else if (tagOfSelectedButton.equals(AddInsOptions.Water.class.getSimpleName())) {
//            drinkComponentSelected = new AddInsOptions(AddInsOptions.Water.MEDIUM);
//        } else if (tagOfSelectedButton.equals(ToppingOptions.WhippedCream.class.getSimpleName())) {
//            drinkComponentSelected = new ToppingOptions(ToppingOptions.WhippedCream.WHIPPED_CREAM);
//        } else if (tagOfSelectedButton.equals(AddInsOptions.MilkCreamer.VANILLA_SWEET_CREAM.name())) {
//            drinkComponentSelected = new AddInsOptions(AddInsOptions.MilkCreamer.VANILLA_SWEET_CREAM);
//        } else if (tagOfSelectedButton.equals(SweetenerOptions.Packet.SPLENDA.name())) {
//            drinkComponentSelected = new SweetenerOptions(SweetenerOptions.Packet.SPLENDA);
//        } else if (tagOfSelectedButton.equals(SweetenerOptions.Packet.SUGAR.name())) {
//            drinkComponentSelected = new SweetenerOptions(SweetenerOptions.Packet.SUGAR);
//        } else if (tagOfSelectedButton.equals(SweetenerOptions.Packet.STEVIA_IN_THE_RAW.name())) {
//            drinkComponentSelected = new SweetenerOptions(SweetenerOptions.Packet.STEVIA_IN_THE_RAW);
//        } else if (tagOfSelectedButton.equals(SweetenerOptions.Packet.HONEY.name())) {
//            drinkComponentSelected = new SweetenerOptions(SweetenerOptions.Packet.HONEY);
//        } else if (tagOfSelectedButton.equals(SweetenerOptions.Packet.SUGAR_IN_THE_RAW.name())) {
//            drinkComponentSelected = new SweetenerOptions(SweetenerOptions.Packet.SUGAR_IN_THE_RAW);
//        } else if (tagOfSelectedButton.equals(AddInsOptions.Fruit.STRAWBERRY_PUREE.name())) {
//            drinkComponentSelected = new AddInsOptions(AddInsOptions.Fruit.STRAWBERRY_PUREE);
//        } else if (tagOfSelectedButton.equals(BlendedOptions.FrapChips.FRAP_CHIPS.name())) {
//            drinkComponentSelected = new BlendedOptions(BlendedOptions.FrapChips.FRAP_CHIPS);
//        } else if (tagOfSelectedButton.equals(AddInsOptions.Powder.VANILLA_BEAN.name())) {
//            drinkComponentSelected = new AddInsOptions(AddInsOptions.Powder.VANILLA_BEAN);
//        } else if (tagOfSelectedButton.equals(TeaOptions.MatchaPowder.MATCHA_POWDER.name())) {
//            drinkComponentSelected = new TeaOptions(TeaOptions.MatchaPowder.MATCHA_POWDER);
//        } else if (tagOfSelectedButton.equals(AddInsOptions.Powder.CHOCOLATE_MALT.name())) {
//            drinkComponentSelected = new AddInsOptions(AddInsOptions.Powder.CHOCOLATE_MALT);
//        } else if (tagOfSelectedButton.equals("Mocha_Drizzle")) {
//            drinkComponentSelected = new AddInsOptions(AddInsOptions.LineTheCup.MOCHA_SAUCE);
//        } else if (tagOfSelectedButton.equals("Caramel_Drizzle")) {
//            drinkComponentSelected = new AddInsOptions(AddInsOptions.LineTheCup.CARAMEL_SAUCE);
//        } else if (tagOfSelectedButton.equals(TeaOptions.IcedTeaSplash.BLACK_TEA.name())) {
//            drinkComponentSelected = new TeaOptions(TeaOptions.IcedTeaSplash.BLACK_TEA);
//        } else if (tagOfSelectedButton.equals(TeaOptions.IcedTeaSplash.GREEN_TEA.name())) {
//            drinkComponentSelected = new TeaOptions(TeaOptions.IcedTeaSplash.GREEN_TEA);
//        } else if (tagOfSelectedButton.equals(TeaOptions.IcedTeaSplash.PASSION_TANGO_TEA.name())) {
//            drinkComponentSelected = new TeaOptions(TeaOptions.IcedTeaSplash.PASSION_TANGO_TEA);
//        } else if (tagOfSelectedButton.equals(RefresherBaseOptions.RefresherBase.PINEAPPLE_PASSIONFRUIT.name())) {
//            drinkComponentSelected = new RefresherBaseOptions(RefresherBaseOptions.RefresherBase.PINEAPPLE_PASSIONFRUIT);
//        } else if (tagOfSelectedButton.equals(RefresherBaseOptions.RefresherBase.STRAWBERRY_ACAI.name())) {
//            drinkComponentSelected = new RefresherBaseOptions(RefresherBaseOptions.RefresherBase.STRAWBERRY_ACAI);
//        } else if (tagOfSelectedButton.equals(RefresherBaseOptions.RefresherBase.MANGO_DRAGONFRUIT.name())) {
//            drinkComponentSelected = new RefresherBaseOptions(RefresherBaseOptions.RefresherBase.MANGO_DRAGONFRUIT);
//        } else if (tagOfSelectedButton.equals(MilkOptions.MilkFoam.class.getSimpleName())) {
//            drinkComponentSelected = new MilkOptions(MilkOptions.MilkFoam.MEDIUM);
//        } else if (tagOfSelectedButton.equals(AddInsOptions.Room.class.getSimpleName())) {
//            drinkComponentSelected = new AddInsOptions(AddInsOptions.Room.MEDIUM);
//        } else if (tagOfSelectedButton.equals(ToppingOptions.ColdFoam.VANILLA_SWEET_CREAM.name())) {
//            drinkComponentSelected = new ToppingOptions(ToppingOptions.ColdFoam.VANILLA_SWEET_CREAM);
//        } else if (tagOfSelectedButton.equals(JuiceOptions.Juice.PEACH_BLEND.name())) {
//            drinkComponentSelected = new JuiceOptions(JuiceOptions.Juice.PEACH_BLEND);
//        } else if (tagOfSelectedButton.equals(RefresherBaseOptions.RefresherBase.KIWI_STARFRUIT.name())) {
//            drinkComponentSelected = new RefresherBaseOptions(RefresherBaseOptions.RefresherBase.KIWI_STARFRUIT);
//        } else if (tagOfSelectedButton.equals(LemonadeOptions.Lemonade.LEMONADE.name())) {
//            drinkComponentSelected = new LemonadeOptions(LemonadeOptions.Lemonade.LEMONADE);
//        } else if (tagOfSelectedButton.equals(JuiceOptions.Juice.APPLE.name())) {
//            drinkComponentSelected = new JuiceOptions(JuiceOptions.Juice.APPLE);
//        }
//        // UNDEFINED
//        else {
//            drinkComponentSelected = new UndefinedDrinkComponent();
//        }
//
//        return drinkComponentSelected;
//    }

    public static MenuItem instantiateMenuItemByButtonTag(String tagOfSelectedButton) {
        MenuItem menuItemSelected = null;
        // FOODS
        if (tagOfSelectedButton.equals(Bread.DEFAULT_NAME)) {
            menuItemSelected = new Bread();
        }
        // DRINKS
        else if (tagOfSelectedButton.equals(Water.DEFAULT_NAME)) {
            menuItemSelected = new Water();
        } else if (tagOfSelectedButton.equals(GreenApronBlend.DEFAULT_NAME)) {
            menuItemSelected = new GreenApronBlend();
        } else if (tagOfSelectedButton.equals(CaffeLatte.DEFAULT_NAME)) {
            menuItemSelected = new CaffeLatte();
        } else if (tagOfSelectedButton.equals(ShotEspresso.DEFAULT_NAME)) {
            menuItemSelected = new ShotEspresso();
        }
        // SIDES
        else if (tagOfSelectedButton.equals(SteamedVegetable.DEFAULT_NAME)) {
            menuItemSelected = new SteamedVegetable();
        }
        // UNDEFINED
        else {
            menuItemSelected = new UndefinedMenuItem();
        }

        return menuItemSelected;
    }

    public static List<String> createListOfButtonTitleFoods() {
        List<String> allFoods = new ArrayList<String>();

        allFoods.add(Bread.DEFAULT_NAME);
        allFoods.add("NULL");
        allFoods.add("NULL");

        allFoods.add("NULL");
        allFoods.add("NULL");
        allFoods.add("NULL");

        allFoods.add("NULL");
        allFoods.add("NULL");
        allFoods.add("NULL");

        allFoods.add("NULL");
        allFoods.add("NULL");
        allFoods.add("NULL");

        return allFoods;
    }

    public static List<String> createListOfButtonTitleDrinks() {
        List<String> allDrinks = new ArrayList<String>();

        allDrinks.add(Water.DEFAULT_NAME);
        allDrinks.add(GreenApronBlend.DEFAULT_NAME);
        allDrinks.add(CaffeLatte.DEFAULT_NAME);
        allDrinks.add(ShotEspresso.DEFAULT_NAME);
        allDrinks.add("NULL");

        allDrinks.add("NULL");
        allDrinks.add("NULL");
        allDrinks.add("NULL");
        allDrinks.add("NULL");
        allDrinks.add("NULL");

        allDrinks.add("NULL");
        allDrinks.add("NULL");
        allDrinks.add("NULL");
        allDrinks.add("NULL");
        allDrinks.add("NULL");

        allDrinks.add("NULL");
        allDrinks.add("NULL");
        allDrinks.add("NULL");
        allDrinks.add("NULL");
        allDrinks.add("NULL");

        allDrinks.add("NULL");
        allDrinks.add("NULL");
        allDrinks.add("NULL");
        allDrinks.add("NULL");
        allDrinks.add("NULL");

        return allDrinks;
    }

    public static List<String> createListOfButtonTitleSides() {
        List<String> allSides = new ArrayList<String>();

        allSides.add(SteamedVegetable.DEFAULT_NAME);
        allSides.add("NULL");
        allSides.add("NULL");

        allSides.add("NULL");
        allSides.add("NULL");
        allSides.add("NULL");

        return allSides;
    }

//    public static List<String> createListOfButtonTitleFlavors() {
//        List<String> allFlavors = new ArrayList<String>();
//
//        allFlavors.add(FlavorOptions.Syrup.CARAMEL.name());
//        allFlavors.add(FlavorOptions.Syrup.CINNAMON_DOLCE.name());
//        allFlavors.add(FlavorOptions.Syrup.HAZELNUT.name());
//        allFlavors.add(FlavorOptions.Syrup.TOFFEE_NUT.name());
//        allFlavors.add(FlavorOptions.Syrup.VANILLA.name());
//
//        allFlavors.add(SweetenerOptions.Liquid.CLASSIC.name());
//        allFlavors.add(FlavorOptions.Syrup.PEPPERMINT.name());
//        allFlavors.add(FlavorOptions.Syrup.RASPBERRY.name());
//        allFlavors.add(FlavorOptions.Syrup.TOASTED_VANILLA.name());
//        allFlavors.add(FlavorOptions.Syrup.BROWN_SUGAR.name());
//
//        allFlavors.add(TeaOptions.Chai.CHAI.name());
//        allFlavors.add(SweetenerOptions.Liquid.HONEY_BLEND.name());
//        allFlavors.add(SweetenerOptions.Liquid.LIQUID_CANE.name());
//        allFlavors.add("NULL");
//        allFlavors.add("NULL");
//
//        allFlavors.add(FlavorOptions.Syrup.SUGAR_FREE_VANILLA.name());
//        allFlavors.add("NULL");
//        allFlavors.add("NULL");
//        allFlavors.add("NULL");
//        allFlavors.add("NULL");
//
//        allFlavors.add(FlavorOptions.Sauce.MOCHA.name());
//        allFlavors.add(FlavorOptions.Sauce.WHITE_CHOCOLATE_MOCHA.name());
//        allFlavors.add(FlavorOptions.Sauce.DARK_CARAMEL.name());
//        allFlavors.add("NULL");
//        allFlavors.add("NULL");
//
//        allFlavors.add(FlavorOptions.Sauce.PISTACHIO.name());
//        allFlavors.add("NULL");
//        allFlavors.add("NULL");
//        allFlavors.add("NULL");
//        allFlavors.add("More_Seasonal_Syrup");
//
//        return allFlavors;
//    }
//
//    public static List<String> createListOfButtonTitleMilkCreamers() {
//        List<String> allCreamers = new ArrayList<String>();
//
//        allCreamers.add(AddInsOptions.MilkCreamer.NONFAT_MILK.name());
//        allCreamers.add(AddInsOptions.MilkCreamer.VANILLA_SWEET_CREAM.name());
//        allCreamers.add(AddInsOptions.MilkCreamer.TWO_PERCENT.name());
//        allCreamers.add(AddInsOptions.MilkCreamer.WHOLE_MILK.name());
//        allCreamers.add(AddInsOptions.MilkCreamer.SOY.name());
//        allCreamers.add(AddInsOptions.MilkCreamer.OATMILK.name());
//        allCreamers.add(AddInsOptions.MilkCreamer.COCONUT.name());
//        allCreamers.add(AddInsOptions.MilkCreamer.ALMOND.name());
//        allCreamers.add(AddInsOptions.MilkCreamer.BREVE.name());
//        allCreamers.add(AddInsOptions.MilkCreamer.HEAVY_CREAM.name());
//
//        return allCreamers;
//    }
//
//    public static List<String> createListOfButtonTitleMilkBases() {
//        List<String> allMilks = new ArrayList<String>();
//
//        allMilks.add(MilkOptions.MilkBase.NONFAT_MILK.name());
//        allMilks.add(MilkOptions.MilkBase.VANILLA_SWEET_CREAM.name());
//        allMilks.add(MilkOptions.MilkBase.TWO_PERCENT.name());
//        allMilks.add(MilkOptions.MilkBase.WHOLE_MILK.name());
//        allMilks.add(MilkOptions.MilkBase.SOY.name());
//        allMilks.add(MilkOptions.MilkBase.OATMILK.name());
//        allMilks.add(MilkOptions.MilkBase.COCONUT.name());
//        allMilks.add(MilkOptions.MilkBase.ALMOND.name());
//        allMilks.add(MilkOptions.MilkBase.BREVE.name());
//        allMilks.add(MilkOptions.MilkBase.HEAVY_CREAM.name());
//
//        return allMilks;
//    }
//
//    public static List<String> createListOfButtonTitleCustomizations() {
//        List<String> allCustomizations = new ArrayList<String>();
//
//        allCustomizations.add(AddInsOptions.Ice.class.getSimpleName());
//        allCustomizations.add(AddInsOptions.Water.class.getSimpleName());
//        allCustomizations.add(ToppingOptions.WhippedCream.class.getSimpleName());
//        allCustomizations.add(AddInsOptions.MilkCreamer.VANILLA_SWEET_CREAM.name());
//        allCustomizations.add("NULL");
//        allCustomizations.add("NULL");
//
//        allCustomizations.add("Agave"); // TODO: suppose to be in FOODS-oatmeal.
//        allCustomizations.add(SweetenerOptions.Packet.SPLENDA.name());
//        allCustomizations.add(SweetenerOptions.Packet.SUGAR.name());
//        allCustomizations.add(SweetenerOptions.Packet.STEVIA_IN_THE_RAW.name());
//        allCustomizations.add(SweetenerOptions.Packet.HONEY.name());
//        allCustomizations.add(SweetenerOptions.Packet.SUGAR_IN_THE_RAW.name());
//
//        allCustomizations.add("Banana"); // TODO: suppose to be in FOODS-discontinued.
//        allCustomizations.add(AddInsOptions.Fruit.STRAWBERRY_PUREE.name());
//        allCustomizations.add(BlendedOptions.FrapChips.FRAP_CHIPS.name());
//        allCustomizations.add(AddInsOptions.Powder.VANILLA_BEAN.name());
//        allCustomizations.add(TeaOptions.MatchaPowder.MATCHA_POWDER.name());
//        allCustomizations.add(AddInsOptions.Powder.CHOCOLATE_MALT.name());
//
//        allCustomizations.add("Mocha_Drizzle");
//        allCustomizations.add("Caramel_Drizzle");
//        allCustomizations.add("No_topping");
//        allCustomizations.add("Coconut_Flakes");
//        allCustomizations.add("Add_Blueberries"); // TODO: suppose to be in FOODS-oatmeal.
//        allCustomizations.add("Strawberry_Drizzle");
//
//        allCustomizations.add(TeaOptions.IcedTeaSplash.BLACK_TEA.name());
//        allCustomizations.add(TeaOptions.IcedTeaSplash.GREEN_TEA.name());
//        allCustomizations.add(TeaOptions.IcedTeaSplash.PASSION_TANGO_TEA.name());
//        allCustomizations.add(RefresherBaseOptions.RefresherBase.PINEAPPLE_PASSIONFRUIT.name());
//        allCustomizations.add(RefresherBaseOptions.RefresherBase.STRAWBERRY_ACAI.name());
//        allCustomizations.add(RefresherBaseOptions.RefresherBase.MANGO_DRAGONFRUIT.name());
//
//        allCustomizations.add(MilkOptions.MilkFoam.class.getSimpleName());
//        allCustomizations.add(AddInsOptions.Room.class.getSimpleName());
//        allCustomizations.add(ToppingOptions.ColdFoam.VANILLA_SWEET_CREAM.name());
//        allCustomizations.add(JuiceOptions.Juice.PEACH_BLEND.name());
//        allCustomizations.add(RefresherBaseOptions.RefresherBase.KIWI_STARFRUIT.name());
//        allCustomizations.add(LemonadeOptions.Lemonade.LEMONADE.name());
//
//        allCustomizations.add("Extra_Hot");
//        allCustomizations.add("Warm");
//        allCustomizations.add("Temperature");
//        allCustomizations.add(JuiceOptions.Juice.APPLE.name());
//        allCustomizations.add("More_Custom_Toppings_and_Inclusions");
//        allCustomizations.add("More_Custom_Directions");
//
//        return allCustomizations;
//    }
}
