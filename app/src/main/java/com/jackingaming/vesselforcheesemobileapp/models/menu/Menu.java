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
import com.jackingaming.vesselforcheesemobileapp.models.menu.category.ParentCategory;
import com.jackingaming.vesselforcheesemobileapp.models.menu.category.SubCategory;
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
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.hot.CloverStarbucksReserveCostaRicaNaranjo;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.hot.CloverStarbucksReserveEcuadorLoja;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.hot.CloverStarbucksReservePapuaNewGuineaMoanti;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.hot.CloverStarbucksReserveRwandaSholi;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.hot.FeaturedBlondeRoast;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.hot.FeaturedBlondeRoastVerandaBlend;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.hot.FeaturedDarkRoastCaffeVerona;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.hot.FeaturedDarkRoastSumatra;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.hot.FeaturedDecafRoastDecafPikePlaceRoast;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.hot.FeaturedDecafRoastDecafPikePlaceRoast2;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.hot.FeaturedLTORoastGreenApronBlend;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.hot.FeaturedMediumRoastPikePlaceRoast;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.brewed.hot.FeaturedMediumRoastPikePlaceRoast2;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.cold.icedflatwhites.IcedFlatWhite;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.cold.icedflatwhites.IcedHoneyAlmondmilkFlatWhite;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.cold.icedlattes.IcedCaffeLatte;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.cold.icedlattes.IcedCinnamonDolceLatte;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.cold.icedlattes.IcedStarbucksBlondeVanillaLatte;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.cold.icedlattes.StarbucksReserveIcedHazelnutBiancoLatte;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.cold.icedlattes.StarbucksReserveIcedLatte;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.cold.icedmacchiatos.IcedCaramelMacchiato;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.cold.icedmochas.IcedCaffeMocha;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.cold.icedmochas.IcedWhiteChocolateMocha;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.cold.icedmochas.StarbucksReserveIcedDarkChocolateMocha;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.cold.icedshakenespressos.IcedBrownSugarOatmilkShakenEspresso;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.cold.icedshakenespressos.IcedChocolateAlmondmilkShakenEspresso;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.cold.icedshakenespressos.IcedShakenEspresso;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.cold.icedshakenespressos.IcedToastedVanillaOatmilkShakenEspresso;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.cold.icedshakenespressos.OleatoIcedShakenEspressoWithOatmilkAndToffeenut;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.hot.cappuccinos.Cappuccino;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.hot.flatwhites.FlatWhite;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.hot.flatwhites.HoneyAlmondmilkFlatWhite;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.hot.lattes.CaffeLatte;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.hot.lattes.CinnamonDolceLatte;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.hot.lattes.OleatoCaffeLatteWithOatmilk;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.hot.lattes.StarbucksBlondeVanillaLatte;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.hot.lattes.StarbucksReserveHazelnutBiancoLatte;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.hot.lattes.StarbucksReserveLatte;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.hot.macchiatos.CaramelMacchiato;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.hot.macchiatos.EspressoMacchiato;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.hot.mochas.CaffeMocha;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.hot.mochas.StarbucksReserveDarkChocolateMocha;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.hot.mochas.WhiteChocolateMocha;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.straight_shots.EspressoConPanna;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.straight_shots.ShotEspresso;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.water_based.cold.icedamericano.IcedCaffeAmericano;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.water_based.hot.americanos.CaffeAmericano;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.travelers.VerandaBlend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static final List<MenuItem> americanos = Arrays.asList(
            new CaffeAmericano()
    );

    public static final List<MenuItem> brewedCoffees = Arrays.asList(
            new FeaturedBlondeRoast(),
            new FeaturedMediumRoastPikePlaceRoast(),
            new FeaturedDarkRoastSumatra(),
            new FeaturedDecafRoastDecafPikePlaceRoast(),
            new FeaturedBlondeRoastVerandaBlend(),
            new FeaturedMediumRoastPikePlaceRoast2(),
            new FeaturedDarkRoastCaffeVerona(),
            new FeaturedDecafRoastDecafPikePlaceRoast2(),
            new FeaturedLTORoastGreenApronBlend(),
            new CaffeMisto(),
            new CloverStarbucksReserveRwandaSholi(),
            new CloverStarbucksReservePapuaNewGuineaMoanti(),
            new CloverStarbucksReserveEcuadorLoja(),
            new CloverStarbucksReserveCostaRicaNaranjo()
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

    public static final List<SubCategory> hotCoffees = Arrays.asList(
            new SubCategory(AMERICANOS, R.drawable.harvest_moon_natsume, americanos),
            new SubCategory(BREWED_COFFEES, R.drawable.harvest_moon_natsume, brewedCoffees),
            new SubCategory(CAPPUCCINOS, R.drawable.harvest_moon_natsume, cappuccinos),
            new SubCategory(ESPRESSO_SHOTS, R.drawable.harvest_moon_natsume, espressoShots),
            new SubCategory(FLAT_WHITES, R.drawable.harvest_moon_natsume, flatWhites),
            new SubCategory(LATTES, R.drawable.harvest_moon_natsume, lattes),
            new SubCategory(MACCHIATOS, R.drawable.harvest_moon_natsume, macchiatos),
            new SubCategory(MOCHAS, R.drawable.harvest_moon_natsume, mochas),
            new SubCategory(COFFEE_TRAVELERS, R.drawable.harvest_moon_natsume, coffeeTravelers)
    );

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

    public static final List<SubCategory> coldCoffees = Arrays.asList(
            new SubCategory(COLD_BREWS, R.drawable.harvest_moon_natsume, coldBrews),
            new SubCategory(NITRO_COLD_BREWS, R.drawable.harvest_moon_natsume, nitroColdBrews),
            new SubCategory(ICED_AMERICANO, R.drawable.harvest_moon_natsume, icedAmericano),
            new SubCategory(ICED_COFFEES, R.drawable.harvest_moon_natsume, icedCoffees),
            new SubCategory(ICED_SHAKEN_ESPRESSO, R.drawable.harvest_moon_natsume, icedShakenEspresso),
            new SubCategory(ICED_FLAT_WHITES, R.drawable.harvest_moon_natsume, icedFlatWhites),
            new SubCategory(ICED_LATTES, R.drawable.harvest_moon_natsume, icedLattes),
            new SubCategory(ICED_MACCHIATOS, R.drawable.harvest_moon_natsume, icedMacchiatos),
            new SubCategory(ICED_MOCHAS, R.drawable.harvest_moon_natsume, icedMochas)
    );

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public static final String OILEETO = "Oileeto";

    public static final List<SubCategory> oileeto = Arrays.asList(
            // TODO:
    );

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public static final String HOT_TEAS = "Hot Teas";
    public static final String CHAI_TEAS = "Chai Teas";
    public static final String BLACK_TEAS = "Black Teas";
    public static final String GREEN_TEAS = "Green Teas";
    public static final String HERBAL_TEAS = "Herbal Teas";

    public static final List<MenuItem> chaiTeas = Arrays.asList(
            // TODO:
    );

    public static final List<MenuItem> blackTeas = Arrays.asList(
            // TODO:
    );

    public static final List<MenuItem> greenTeas = Arrays.asList(
            // TODO:
    );

    public static final List<MenuItem> herbalTeas = Arrays.asList(
            // TODO:
    );

    public static final List<SubCategory> hotTeas = Arrays.asList(
            // TODO:
    );

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public static final String HOT_DRINKS = "Hot Drinks";
    public static final String HOT_CHOCOLATES = "Hot Chocolates";
    public static final String JUICE = "Juice";
    public static final String STEAMERS = "Steamers";

    public static final List<MenuItem> hotChocolates = Arrays.asList(
            // TODO:
    );

    public static final List<MenuItem> juice = Arrays.asList(
            // TODO:
    );

    public static final List<MenuItem> steamers = Arrays.asList(
            // TODO:
    );

    public static final List<SubCategory> hotDrinks = Arrays.asList(
            // TODO:
    );

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public static final String BLENDED_BEVERAGES = "Blended Beverages";
    public static final String COFFEE_FRAPPUCCINO = "Coffee Frappuccino";
    public static final String CREME_FRAPPUCCINO = "Creme Frappuccino";

    public static final List<MenuItem> coffeeFrappuccino = Arrays.asList(
            // TODO:
    );

    public static final List<MenuItem> cremeFrappuccino = Arrays.asList(
            // TODO:
    );

    public static final List<SubCategory> blendedBeverages = Arrays.asList(
            // TODO:
    );

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public static final String ICED_TEAS = "Iced Teas";
    public static final String BOTTLED_TEAS = "Bottled Teas";
    public static final String ICED_BLACK_TEAS = "Iced Black Teas";
    public static final String ICED_CHAI_TEAS = "Iced Chai Teas";
    public static final String ICED_GREEN_TEAS = "Iced Green Teas";
    public static final String ICED_HERBAL_TEAS = "Iced Herbal Teas";

    public static final List<MenuItem> bottledTeas = Arrays.asList(
            // TODO:
    );

    public static final List<MenuItem> icedBlackTeas = Arrays.asList(
            // TODO:
    );

    public static final List<MenuItem> icedChaiTeas = Arrays.asList(
            // TODO:
    );

    public static final List<MenuItem> icedGreenTeas = Arrays.asList(
            // TODO:
    );

    public static final List<MenuItem> icedHerbalTeas = Arrays.asList(
            // TODO:
    );

    public static final List<SubCategory> icedTeas = Arrays.asList(
            // TODO:
    );

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    public static final String COLD_DRINKS = "Cold Drinks";
    public static final String REFRESHERS = "Starbucks Refreshers";
    public static final String ICED_JUICE = "Juice";
    public static final String MILK = "Milk";
    public static final String SPARKLING_WATER = "Sparkling Water";
    public static final String WATER = "Water";

    public static final List<MenuItem> refreshers = Arrays.asList(
            // TODO:
    );

    public static final List<MenuItem> icedJuice = Arrays.asList(
            // TODO:
    );

    public static final List<MenuItem> milk = Arrays.asList(
            // TODO:
    );

    public static final List<MenuItem> sparklingWater = Arrays.asList(
            // TODO:
    );

    public static final List<MenuItem> water = Arrays.asList(
            // TODO:
    );

    public static final List<SubCategory> coldDrinks = Arrays.asList(
            // TODO:
    );

    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // ======================================================================

    public static final String HOT_BREAKFAST = "Hot Breakfast";
    public static final String BREAKFAST_SANDWICHES_AND_WRAPS = "Breakfast Sandwiches & Wraps";
    public static final String SOUS_VIDE_EGG_BITES = "Sous Vide Egg Bites";

    public static final List<MenuItem> breakfastSandwichesAndWraps = Arrays.asList(
            // TODO:
    );

    public static final List<MenuItem> sousVideEggBites = Arrays.asList(
            // TODO:
    );

    public static final List<SubCategory> hotBreakfast = Arrays.asList(
            // TODO:
    );

    // ======================================================================

    // ======================================================================

    public static final String OATMEAL_AND_YOGURT = "Oatmeal & Yogurt";

    public static final List<SubCategory> oatmealAndYogurt = Arrays.asList(
            // TODO:
    );

    // ======================================================================

    // ======================================================================

    public static final String BAKERY = "Bakery";
    public static final String BAGELS = "Bagels";
    public static final String CAKE_POPS = "Cake Pops";
    public static final String COOKIES_BROWNIES_AND_BARS = "Cookies, Brownies & Bars";
    public static final String CROISSANTS = "Croissants";
    public static final String LOAVES_CAKES_AND_BUNS = "Loaves, Cakes & Buns";
    public static final String DANISHES_AND_DOUGHNUTS = "Danishes & Doughnuts";
    public static final String MUFFINS_AND_SCONES = "Muffins & Scones";

    public static final List<MenuItem> bagels = Arrays.asList(
            // TODO:
    );

    public static final List<MenuItem> cakePops = Arrays.asList(
            // TODO:
    );

    public static final List<MenuItem> cookiesBrowniesAndBars = Arrays.asList(
            // TODO:
    );

    public static final List<MenuItem> croissants = Arrays.asList(
            // TODO:
    );

    public static final List<SubCategory> loavesCakesAndBuns = Arrays.asList(
            // TODO:
    );

    public static final List<SubCategory> danishesAndDoughnuts = Arrays.asList(
            // TODO:
    );

    public static final List<SubCategory> muffinsAndScones = Arrays.asList(
            // TODO:
    );

    public static final List<SubCategory> bakery = Arrays.asList(
            // TODO:
    );

    // ======================================================================

    // ======================================================================

    public static final String LUNCH = "Lunch";
    public static final String WARM_SANDWICHES = "Warm Sandwiches";
    public static final String PROTEIN_BOXES = "Protein Boxes";

    public static final List<SubCategory> warmSandwiches = Arrays.asList(
            // TODO:
    );

    public static final List<SubCategory> proteinBoxes = Arrays.asList(
            // TODO:
    );

    public static final List<SubCategory> lunch = Arrays.asList(
            // TODO:
    );

    // ======================================================================

    // ======================================================================

    public static final String SNACKS_AND_SWEETS = "Snacks & Sweets";
    public static final String BISCOTTI_AND_COOKIES = "Biscotti & Cookies";
    public static final String CHOCOLATES_AND_CANDY = "Chocolates & Candy";
    public static final String FRUITS_AND_NUTS = "Fruits & Nuts";
    public static final String GUM_AND_MINTS = "Gum & Mints";
    public static final String POPCORN_AND_CHIPS = "Popcorn & Chips";
    public static final String MEAT_AND_CHEESE = "Meat & Cheese";
    public static final String SNACK_BARS = "Snack Bars";
    public static final String SPREADS = "Spreads";

    public static final List<MenuItem> biscottiAndCookies = Arrays.asList(
            // TODO:
    );

    public static final List<MenuItem> chocolatesAndCandy = Arrays.asList(
            // TODO:
    );

    public static final List<MenuItem> fruitsAndNuts = Arrays.asList(
            // TODO:
    );

    public static final List<MenuItem> gumAndMints = Arrays.asList(
            // TODO:
    );

    public static final List<SubCategory> popcornAndChips = Arrays.asList(
            // TODO:
    );

    public static final List<SubCategory> meatAndCheese = Arrays.asList(
            // TODO:
    );

    public static final List<SubCategory> snackBars = Arrays.asList(
            // TODO:
    );

    public static final List<SubCategory> spreads = Arrays.asList(
            // TODO:
    );

    public static final List<SubCategory> snacksAndSweets = Arrays.asList(
            // TODO:
    );

    // ======================================================================

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public static final String WHOLE_BEAN = "Whole Bean";

    public static final List<SubCategory> wholeBean = Arrays.asList(
            // TODO:
    );

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public static final String INSTANT_COFFEE = "Instant Coffee";

    public static final List<SubCategory> instantCoffee = Arrays.asList(
            // TODO:
    );

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    public static final String COLD_CUPS = "Cold Cups";

    public static final List<SubCategory> coldCups = Arrays.asList(
            // TODO:
    );

    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    public static final String TUMBLERS = "Tumblers";

    public static final List<SubCategory> tumblers = Arrays.asList(
            // TODO:
    );

    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    public static final String MUGS = "Mugs";

    public static final List<SubCategory> mugs = Arrays.asList(
            // TODO:
    );

    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    public static final String WATER_BOTTLES = "Water Bottles";

    public static final List<SubCategory> waterBottles = Arrays.asList(
            // TODO:
    );

    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    public static final String OTHER = "Other";

    public static final List<SubCategory> other = Arrays.asList(
            // TODO:
    );

    // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    // ######################################################################

    public static final String HAPPY_BIRTHDAY = "Happy Birthday";

    public static final List<SubCategory> happyBirthday = Arrays.asList(
            // TODO:
    );

    // ######################################################################

    // ######################################################################

    public static final String THANK_YOU = "Thank You";

    public static final List<SubCategory> thankYou = Arrays.asList(
            // TODO:
    );

    // ######################################################################

    // ######################################################################

    public static final String TRADITIONAL = "Traditional";

    public static final List<SubCategory> traditional = Arrays.asList(
            // TODO:
    );

    // ######################################################################

    // **********************************************************************
    // class: MenuFragment
    // **********************************************************************

    public static final List<ParentCategory> drinks = Arrays.asList(
            new ParentCategory(OILEETO, R.drawable.harvest_moon_natsume, oileeto),
            new ParentCategory(HOT_COFFEES, R.drawable.harvest_moon_natsume, hotCoffees),
            new ParentCategory(HOT_TEAS, R.drawable.harvest_moon_natsume, hotTeas),
            new ParentCategory(HOT_DRINKS, R.drawable.harvest_moon_natsume, hotDrinks),
            new ParentCategory(BLENDED_BEVERAGES, R.drawable.harvest_moon_natsume, blendedBeverages),
            new ParentCategory(COLD_COFFEES, R.drawable.harvest_moon_natsume, coldCoffees),
            new ParentCategory(ICED_TEAS, R.drawable.harvest_moon_natsume, icedTeas),
            new ParentCategory(COLD_DRINKS, R.drawable.harvest_moon_natsume, coldDrinks)
    );

    public static final List<ParentCategory> food = Arrays.asList(
            new ParentCategory(HOT_BREAKFAST, R.drawable.harvest_moon_natsume, hotBreakfast),
            new ParentCategory(OATMEAL_AND_YOGURT, R.drawable.harvest_moon_natsume, oatmealAndYogurt),
            new ParentCategory(BAKERY, R.drawable.harvest_moon_natsume, bakery),
            new ParentCategory(LUNCH, R.drawable.harvest_moon_natsume, lunch),
            new ParentCategory(SNACKS_AND_SWEETS, R.drawable.harvest_moon_natsume, snacksAndSweets)
    );

    public static final List<ParentCategory> atHomeCoffee = Arrays.asList(
            new ParentCategory(WHOLE_BEAN, R.drawable.harvest_moon_natsume, wholeBean),
            new ParentCategory(INSTANT_COFFEE, R.drawable.harvest_moon_natsume, instantCoffee)
    );

    public static final List<ParentCategory> merchandise = Arrays.asList(
            new ParentCategory(COLD_CUPS, R.drawable.harvest_moon_natsume, coldCups),
            new ParentCategory(TUMBLERS, R.drawable.harvest_moon_natsume, tumblers),
            new ParentCategory(MUGS, R.drawable.harvest_moon_natsume, mugs),
            new ParentCategory(WATER_BOTTLES, R.drawable.harvest_moon_natsume, waterBottles),
            new ParentCategory(OTHER, R.drawable.harvest_moon_natsume, other)
    );

    public static final List<ParentCategory> giftCards = Arrays.asList(
            new ParentCategory(HAPPY_BIRTHDAY, R.drawable.harvest_moon_natsume, happyBirthday),
            new ParentCategory(THANK_YOU, R.drawable.harvest_moon_natsume, thankYou),
            new ParentCategory(TRADITIONAL, R.drawable.harvest_moon_natsume, traditional)
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
