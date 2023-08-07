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
import com.jackingaming.vesselforcheesemobileapp.models.menu.category.Category;
import com.jackingaming.vesselforcheesemobileapp.models.menu.category.MenuItemCategory;
import com.jackingaming.vesselforcheesemobileapp.models.menu.category.TitleCategory;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.MenuItem;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.cold.coldbrews.ChocolateCreamColdBrew;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.cold.coldbrews.CinnamonCaramelCreamColdBrew;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.cold.coldbrews.OleatoGoldenFoamColdBrew;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.cold.coldbrews.SaltedCaramelCreamColdBrew;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.cold.coldbrews.StarbucksColdBrewCoffee;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.cold.coldbrews.StarbucksColdBrewCoffeeWithMilk;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.cold.coldbrews.VanillaSweetCreamColdBrew;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.cold.coldbrews.WhiteChocolateMacadamiaCreamColdBrew;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.cold.icedcoffees.IcedCoffee;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.cold.icedcoffees.IcedCoffeeWithMilk;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.cold.icedcoffees.IcedEspresso;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.cold.nitrocoldbrews.CinnamonCaramelCreamNitroColdBrew;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.cold.nitrocoldbrews.NitroColdBrew;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.cold.nitrocoldbrews.VanillaSweetCreamNitroColdBrew;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.hot.CaffeMisto;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.hot.CostaRicaNaranjo;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.hot.DarkRoast;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.hot.DecafPikePlaceRoast;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.hot.EcuadorLoja;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.hot.GreenApronBlend;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.hot.PapuaNewGuineaMoanti;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.hot.PikePlaceRoast;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.hot.RwandaSholi;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.cappuccinos.Cappuccino;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.flat_whites.cold.IcedFlatWhite;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.flat_whites.cold.IcedHoneyAlmondmilkFlatWhite;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.flat_whites.hot.FlatWhite;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.flat_whites.hot.HoneyAlmondmilkFlatWhite;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.iced_shaken_espressos.IcedBrownSugarOatmilkShakenEspresso;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.iced_shaken_espressos.IcedChocolateAlmondmilkShakenEspresso;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.iced_shaken_espressos.IcedShakenEspresso;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.iced_shaken_espressos.IcedToastedVanillaOatmilkShakenEspresso;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.iced_shaken_espressos.OleatoIcedShakenEspressoWithOatmilkAndToffeenut;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes.cold.IcedCaffeLatte;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes.cold.IcedCinnamonDolceLatte;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes.cold.IcedStarbucksBlondeVanillaLatte;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes.cold.StarbucksReserveIcedHazelnutBiancoLatte;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes.cold.StarbucksReserveIcedLatte;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes.hot.CaffeLatte;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes.hot.CinnamonDolceLatte;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes.hot.OleatoCaffeLatteWithOatmilk;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes.hot.StarbucksBlondeVanillaLatte;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes.hot.StarbucksReserveHazelnutBiancoLatte;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes.hot.StarbucksReserveLatte;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.macchiatos.cold.IcedCaramelMacchiato;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.macchiatos.hot.CaramelMacchiato;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.macchiatos.hot.EspressoMacchiato;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.mochas.cold.IcedCaffeMocha;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.mochas.cold.IcedWhiteChocolateMocha;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.mochas.cold.StarbucksReserveIcedDarkChocolateMocha;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.mochas.hot.CaffeMocha;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.mochas.hot.StarbucksReserveDarkChocolateMocha;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.mochas.hot.WhiteChocolateMocha;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.straight_shots.EspressoConPanna;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.straight_shots.ShotEspresso;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.water_based.americanos.cold.IcedCaffeAmericano;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.water_based.americanos.hot.CaffeAmericano;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.travelers.VerandaBlend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    public static final String TAG = Menu.class.getSimpleName();

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

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

    public static final List<String> DRINK_SIZE_CHANGED_KEYS = Arrays.asList(
            AddInsOptions.TAG,
            BlendedOptions.TAG,
            EspressoOptions.TAG,
            TeaOptions.TAG,
            SweetenerOptions.TAG,
            FlavorOptions.TAG
    );

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

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

    public static final String COLD_COFFEES = "Cold Coffees";
    public static final String COLD_BREWS = "Cold Brews";
    public static final String NITRO_COLD_BREWS = "Nitro Cold Brews";
    public static final String ICED_AMERICANO = "Iced Americano";
    public static final String ICED_COFFEES = "Iced Coffees";
    public static final String ICED_SHAKEN_ESPRESSO = "Iced Shaken Espresso";
    public static final String ICED_FLAT_WHITES = "Iced Flat Whites";
    public static final String ICED_LATTES = "Iced Lattes";
    public static final String ICED_MACCHIATOS = "Iced Macchiatos";
    public static final String ICED_MOCHAS = "Iced Mochas";

    public static final List<MenuItemCategory> coldCoffees = Arrays.asList(
            new MenuItemCategory(COLD_BREWS, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(NITRO_COLD_BREWS, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(ICED_AMERICANO, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(ICED_COFFEES, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(ICED_SHAKEN_ESPRESSO, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(ICED_FLAT_WHITES, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(ICED_LATTES, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(ICED_MACCHIATOS, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(ICED_MOCHAS, R.drawable.harvest_moon_natsume)
    );

    public static final List<MenuItem> coldBrews = Arrays.asList(
            new OleatoGoldenFoamColdBrew(),
            new WhiteChocolateMacadamiaCreamColdBrew(),
            new CinnamonCaramelCreamColdBrew(),
            new ChocolateCreamColdBrew(),
            new SaltedCaramelCreamColdBrew(),
            new StarbucksColdBrewCoffee(),
            new VanillaSweetCreamColdBrew(),
            new StarbucksColdBrewCoffeeWithMilk()
    );

    public static final List<MenuItem> nitroColdBrews = Arrays.asList(
            new CinnamonCaramelCreamNitroColdBrew(),
            new NitroColdBrew(),
            new VanillaSweetCreamNitroColdBrew()
    );

    public static final List<MenuItem> icedAmericano = Arrays.asList(
            new IcedCaffeAmericano()
    );

    public static final List<MenuItem> icedCoffees = Arrays.asList(
            new IcedCoffee(),
            new IcedCoffeeWithMilk(),
            new IcedEspresso()
    );

    public static final List<MenuItem> icedShakenEspresso = Arrays.asList(
            new OleatoIcedShakenEspressoWithOatmilkAndToffeenut(),
            new IcedToastedVanillaOatmilkShakenEspresso(),
            new IcedBrownSugarOatmilkShakenEspresso(),
            new IcedChocolateAlmondmilkShakenEspresso(),
            new IcedShakenEspresso()
    );

    public static final List<MenuItem> icedFlatWhites = Arrays.asList(
            new IcedFlatWhite(),
            new IcedHoneyAlmondmilkFlatWhite()
    );

    public static final List<MenuItem> icedLattes = Arrays.asList(
            new StarbucksReserveIcedLatte(),
            new StarbucksReserveIcedHazelnutBiancoLatte(),
            new IcedCaffeLatte(),
            new IcedCinnamonDolceLatte(),
            new IcedStarbucksBlondeVanillaLatte()
    );

    public static final List<MenuItem> icedMacchiatos = Arrays.asList(
            new IcedCaramelMacchiato()
    );

    public static final List<MenuItem> icedMochas = Arrays.asList(
            new IcedWhiteChocolateMocha(),
            new IcedCaffeMocha(),
            new StarbucksReserveIcedDarkChocolateMocha()
    );

    public static final Map<String, List<MenuItem>> coldCoffeesAsMap = new HashMap<String, List<MenuItem>>();

    static {
        coldCoffeesAsMap.put(COLD_BREWS, coldBrews);
        coldCoffeesAsMap.put(NITRO_COLD_BREWS, nitroColdBrews);
        coldCoffeesAsMap.put(ICED_AMERICANO, icedAmericano);
        coldCoffeesAsMap.put(ICED_COFFEES, icedCoffees);
        coldCoffeesAsMap.put(ICED_SHAKEN_ESPRESSO, icedShakenEspresso);
        coldCoffeesAsMap.put(ICED_FLAT_WHITES, icedFlatWhites);
        coldCoffeesAsMap.put(ICED_LATTES, icedLattes);
        coldCoffeesAsMap.put(ICED_MACCHIATOS, icedMacchiatos);
        coldCoffeesAsMap.put(ICED_MOCHAS, icedMochas);
    }

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public static final String OILEETO = "Oileeto";

    public static final Map<String, List<MenuItem>> oileetoAsMap = new HashMap<String, List<MenuItem>>();

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public static final String HOT_TEAS = "Hot Teas";

    public static final Map<String, List<MenuItem>> hotTeasAsMap = new HashMap<String, List<MenuItem>>();

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public static final String HOT_DRINKS = "Hot Drinks";

    public static final Map<String, List<MenuItem>> hotDrinksAsMap = new HashMap<String, List<MenuItem>>();

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public static final String BLENDED_BEVERAGES = "Blended Beverages";

    public static final Map<String, List<MenuItem>> blendedBeveragesAsMap = new HashMap<String, List<MenuItem>>();

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public static final String ICED_TEAS = "Iced Teas";

    public static final Map<String, List<MenuItem>> icedTeasAsMap = new HashMap<String, List<MenuItem>>();

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public static final String COLD_DRINKS = "Cold Drinks";

    public static final Map<String, List<MenuItem>> coldDrinksAsMap = new HashMap<String, List<MenuItem>>();

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // ======================================================================

    public static final String HOT_BREAKFAST = "Hot Breakfast";

    public static final Map<String, List<MenuItem>> hotBreakfastAsMap = new HashMap<String, List<MenuItem>>();

    // ======================================================================

    // ======================================================================

    public static final String OATMEAL_AND_YOGURT = "Oatmeal & Yogurt";

    public static final Map<String, List<MenuItem>> oatmealAndYogurtAsMap = new HashMap<String, List<MenuItem>>();

    // ======================================================================

    // ======================================================================

    public static final String BAKERY = "Bakery";

    public static final Map<String, List<MenuItem>> bakeryAsMap = new HashMap<String, List<MenuItem>>();

    // ======================================================================

    // ======================================================================

    public static final String LUNCH = "Lunch";

    public static final Map<String, List<MenuItem>> lunchAsMap = new HashMap<String, List<MenuItem>>();

    // ======================================================================

    // ======================================================================

    public static final String SNACKS_AND_SWEETS = "Snacks & Sweets";

    public static final Map<String, List<MenuItem>> snacksAndSweetsAsMap = new HashMap<String, List<MenuItem>>();

    // ======================================================================

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public static final String WHOLE_BEAN = "Whole Bean";

    public static final Map<String, List<MenuItem>> wholeBeanAsMap = new HashMap<String, List<MenuItem>>();

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public static final String INSTANT_COFFEE = "Instant Coffee";

    public static final Map<String, List<MenuItem>> instantCoffeeAsMap = new HashMap<String, List<MenuItem>>();

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    public static final String COLD_CUPS = "Cold Cups";

    public static final Map<String, List<MenuItem>> coldCupsAsMap = new HashMap<String, List<MenuItem>>();

    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    public static final String TUMBLERS = "Tumblers";

    public static final Map<String, List<MenuItem>> tumblersAsMap = new HashMap<String, List<MenuItem>>();

    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    public static final String MUGS = "Mugs";

    public static final Map<String, List<MenuItem>> mugsAsMap = new HashMap<String, List<MenuItem>>();

    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    public static final String WATER_BOTTLES = "Water Bottles";

    public static final Map<String, List<MenuItem>> waterBottlesAsMap = new HashMap<String, List<MenuItem>>();

    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    public static final String OTHER = "Other";

    public static final Map<String, List<MenuItem>> otherAsMap = new HashMap<String, List<MenuItem>>();

    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    // ######################################################################

    public static final String HAPPY_BIRTHDAY = "Happy Birthday";

    public static final Map<String, List<MenuItem>> happyBirthdayAsMap = new HashMap<String, List<MenuItem>>();

    // ######################################################################

    // ######################################################################

    public static final String THANK_YOU = "Thank You";

    public static final Map<String, List<MenuItem>> thankYouAsMap = new HashMap<String, List<MenuItem>>();

    // ######################################################################

    // ######################################################################

    public static final String TRADITIONAL = "Traditional";

    public static final Map<String, List<MenuItem>> traditionalAsMap = new HashMap<String, List<MenuItem>>();

    // ######################################################################

    // **********************************************************************
    // class: MenuFragment
    // **********************************************************************

    public static final List<Category> drinks = Arrays.asList(
            new MenuItemCategory(OILEETO, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(HOT_COFFEES, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(HOT_TEAS, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(HOT_DRINKS, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(BLENDED_BEVERAGES, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(COLD_COFFEES, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(ICED_TEAS, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(COLD_DRINKS, R.drawable.harvest_moon_natsume)
    );

    public static final List<Category> food = Arrays.asList(
            new MenuItemCategory(HOT_BREAKFAST, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(OATMEAL_AND_YOGURT, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(BAKERY, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(LUNCH, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(SNACKS_AND_SWEETS, R.drawable.harvest_moon_natsume)
    );

    public static final List<Category> atHomeCoffee = Arrays.asList(
            new MenuItemCategory(WHOLE_BEAN, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(INSTANT_COFFEE, R.drawable.harvest_moon_natsume)
    );

    public static final List<Category> merchandise = Arrays.asList(
            new MenuItemCategory(COLD_CUPS, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(TUMBLERS, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(MUGS, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(WATER_BOTTLES, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(OTHER, R.drawable.harvest_moon_natsume)
    );

    public static final List<Category> giftCards = Arrays.asList(
            new MenuItemCategory(HAPPY_BIRTHDAY, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(THANK_YOU, R.drawable.harvest_moon_natsume),
            new MenuItemCategory(TRADITIONAL, R.drawable.harvest_moon_natsume)
    );

    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

    public static final String DRINKS = "Drinks";
    public static final String FOOD = "Food";
    public static final String AT_HOME_COFFEE = "At Home Coffee";
    public static final String MERCHANDISE = "Merchandise";
    public static final String GIFT_CARDS = "Gift Cards";

    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

    public static final List<Category> categories = new ArrayList<Category>();

    static {
        categories.add(new TitleCategory(DRINKS, drinks.size()));
        categories.addAll(drinks);
        categories.add(new TitleCategory(FOOD, food.size()));
        categories.addAll(food);
        categories.add(new TitleCategory(AT_HOME_COFFEE, atHomeCoffee.size()));
        categories.addAll(atHomeCoffee);
        categories.add(new TitleCategory(MERCHANDISE, merchandise.size()));
        categories.addAll(merchandise);
        categories.add(new TitleCategory(GIFT_CARDS, giftCards.size()));
        categories.addAll(giftCards);
    }
}
