package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.util.Pair;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.customize.CustomizeActivity;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.menu.Menu;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.Drink;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes.CaffeLatte;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MenuItemActivity extends AppCompatActivity {
    public static final String TAG = MenuItemActivity.class.getSimpleName();
    public static final String EXTRA_NAME_CATEGORY = "com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.nameCategory";
    public static final String EXTRA_NAME_SUB_CATEGORY = "com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.nameSubCategory";
    public static final String EXTRA_POSITION = "com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.position";

    private Drink drink;
    private WhatsIncludedAdapter adapter;

    public void initHeightAppBarLayoutAsHalfScreen(AppBarLayout appBarLayout) {
        float heightDp = getResources().getDisplayMetrics().heightPixels / 2;
        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams();
        lp.height = (int) heightDp;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate()");
        setContentView(R.layout.activity_menu_item);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_close_clear_cancel);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar_layout);
        collapsingToolbarLayout.setTitle(" ");
        AppBarLayout appBarLayout = findViewById(R.id.app_bar_layout);
        initHeightAppBarLayoutAsHalfScreen(appBarLayout);

        ImageView ivMenuItemImage = findViewById(R.id.iv_menuitem_image);
        TextView tvMenuItemName = findViewById(R.id.tv_menuitem_name);
        TextView tvMenuItemCalories = findViewById(R.id.tv_menuitem_calories);

        String nameCategory = getIntent().getStringExtra(EXTRA_NAME_CATEGORY);
        String nameSubCategory = getIntent().getStringExtra(EXTRA_NAME_SUB_CATEGORY);
        int position = getIntent().getIntExtra(EXTRA_POSITION, -1);

        TextView tvContent = findViewById(R.id.tv_content);
        tvContent.setText(nameCategory + " | " + nameSubCategory + " | position: " + position);

        TextView tvSizeOptions = findViewById(R.id.tv_size_options);

        TextView tvWhatsIncluded = findViewById(R.id.tv_whats_included);
        RecyclerView rvWhatsIncluded = findViewById(R.id.rv_whats_included);

        Button buttonCustomize = findViewById(R.id.button_customize);

        TextView tvDescription = findViewById(R.id.tv_description);
        TextView tvCaloriesSugarFat = findViewById(R.id.tv_calories_sugar_fat);
        Button buttonNutritionAndIngredient = findViewById(R.id.button_nutrition_and_ingredient);

        ExtendedFloatingActionButton extendedFloatingActionButton = findViewById(R.id.fab);

        if (nameCategory.equals(Menu.HOT_COFFEES)) {
            Log.i(TAG, "Menu.HOT_COFFEES [which implies the selected MenuItem is a Drink]");
            drink = (Drink) Menu.hotCoffeesAsMap.get(nameSubCategory).get(position);

            // TODO: add field to MenuItem class: long idImageResource.
//            ivMenuItemImage.setImageResource(R.drawable.harvest_moon_natsume);
            tvMenuItemName.setText(drink.getName());
            tvMenuItemCalories.setText(drink.getCalories() + " calories");

            appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
                @Override
                public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                    if (Math.abs(verticalOffset) == appBarLayout.getTotalScrollRange()) {
                        // Collapsed
                        collapsingToolbarLayout.setTitle(drink.getName());
                    } else {
                        // Un-collapsed
                        // careful: there should a space between double quote otherwise it wont work.
                        collapsingToolbarLayout.setTitle(" ");
                    }

//                    float percentage = (float) Math.abs(verticalOffset) / appBarLayout.getTotalScrollRange();
//                    if (Math.abs(verticalOffset) == appBarLayout.getTotalScrollRange()) {
//                        // Collapsed
//                        collapsingToolbarLayout.setTitle(drink.getName());
//                    } else if (verticalOffset == 0) {
//                        // Expanded
//                        // careful: there should a space between double quote otherwise it wont work.
//                        collapsingToolbarLayout.setTitle(" ");
//                    } else {
//                        // In-between
//                        collapsingToolbarLayout.animate().alpha(percentage);
//                    }
                }
            });

            String textPreviousContent = tvContent.getText().toString();
            tvContent.setText(textPreviousContent + ": " + drink.getName());

            tvSizeOptions.setText(drink.getDrinkSize().toString());

            if (!(drink instanceof CaffeLatte)) {
                String textPreviousWhatsIncluded = tvWhatsIncluded.getText().toString();
                StringBuilder sb = new StringBuilder();
                Pair<List<DrinkComponent>, List<String>> pairDefaultAndTypes = generateWhatsIncluded(drink);
                for (DrinkComponent drinkComponent : pairDefaultAndTypes.first) {
                    sb.append("\n" + drinkComponent.toString());
                }
                tvWhatsIncluded.setText(textPreviousWhatsIncluded + ": " + sb.toString());
            }

            tvWhatsIncluded.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String[] names = {"Colin", "Mulan", "Muly", "Muhang", "Mushu"};
                    ModalBottomSheet.newInstance(names, "Colin").show(getSupportFragmentManager(), ModalBottomSheet.TAG);
                }
            });

            Pair<List<DrinkComponent>, List<String>> pairDefaultAndTypes = generateWhatsIncluded(drink);
            adapter = new WhatsIncludedAdapter(
                    pairDefaultAndTypes.first,
                    pairDefaultAndTypes.second,
                    drink.getDrinkComponentsStandardRecipe(),
                    new WhatsIncludedAdapter.WhatsIncludedAdapterListener() {
                        @Override
                        public void onItemClicked(String[] names, String nameDefault) {
                            Log.i(TAG, "onItemClicked(String[] names, String nameDefault)");

                            ModalBottomSheet.newInstance(names, nameDefault).show(getSupportFragmentManager(), ModalBottomSheet.TAG);
                        }

                        @Override
                        public void onItemLongClicked(String[] names, String nameDefault) {
                            Log.i(TAG, "onItemLongClicked(String[] names, String nameDefault)");
                        }
                    });
            rvWhatsIncluded.setAdapter(adapter);
            rvWhatsIncluded.setLayoutManager(new LinearLayoutManager(this));

            getSupportFragmentManager().setFragmentResultListener(ModalBottomSheet.REQUEST_KEY, this, new FragmentResultListener() {
                @Override
                public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                    if (requestKey.equals(ModalBottomSheet.REQUEST_KEY)) {
                        String name = result.getString(ModalBottomSheet.KEY_RESULT);

                        adapter.updateDrinkComponentByString(name);
                    }
                }
            });

            buttonCustomize.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentCustomize = new Intent(MenuItemActivity.this, CustomizeActivity.class);
                    intentCustomize.putExtra(CustomizeActivity.EXTRA_DRINK, drink);
                    startActivityForResult(intentCustomize, CustomizeActivity.REQUEST_CODE);
                }
            });

            tvDescription.setText(drink.getDescription());

            String formatStringCaloriesSugarFat = "%d calories, %dg sugar, %.1fg fat";
            tvCaloriesSugarFat.setText(
                    String.format(formatStringCaloriesSugarFat,
                            drink.getCalories(), drink.getSugarInGram(), drink.getFatInGram())
            );
        } else {
            Log.e(TAG, "nameCategory does NOT equals " + Menu.HOT_COFFEES);
        }
    }

    private Pair<List<DrinkComponent>, List<String>> generateWhatsIncluded(Drink drink) {
        Map<String, List<DrinkComponent>> drinkComponentGroups = drink.getDrinkComponents();
        Map<String, List<String>> drinkComponentGroupsDefaultAsString = drink.getDrinkComponentsDefaultAsString();
        List<DrinkComponent> drinkComponentsWhatsIncluded = new ArrayList<>();
        List<String> drinkComponentsWhatsIncludedDefaultAsString = new ArrayList<>();
        Log.i(TAG, "!!!!!creating drinkComponentsWhatsIncluded!!!!!");
        for (int i = 0; i < Menu.DRINK_COMPONENTS_KEYS.size(); i++) {
            String key = Menu.DRINK_COMPONENTS_KEYS.get(i);
            if (drinkComponentGroups.containsKey(key)) {
                Log.i(TAG, i + "contains: " + Menu.DRINK_COMPONENTS_KEYS.get(i));
                List<String> typesDefault = drinkComponentGroupsDefaultAsString.get(key);
                List<DrinkComponent> types = drinkComponentGroups.get(key);
                for (int j = 0; j < types.size(); j++) {
                    DrinkComponent drinkComponent = types.get(j);
                    String drinkComponentDefault = typesDefault.get(j);
                    if (drinkComponent.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING)) {
                        Log.i(TAG, "skipping - drinkComponent.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING)");
                        continue;
                    } else {
                        Log.i(TAG, "adding - drinkComponent.getTypeAsString(): " + drinkComponent.getTypeAsString());
                        drinkComponentsWhatsIncluded.add(drinkComponent);
                        drinkComponentsWhatsIncludedDefaultAsString.add(drinkComponentDefault);
                    }
                }
            } else {
                Log.i(TAG, i + "!contains: " + Menu.DRINK_COMPONENTS_KEYS.get(i));
            }
        }
        return new Pair<>(drinkComponentsWhatsIncluded, drinkComponentsWhatsIncludedDefaultAsString);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        Log.i(TAG, "onCreateOptionsMenu()");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options_menu_item_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull android.view.MenuItem item) {
        Log.i(TAG, "onOptionsItemSelected()");

        if (item.getItemId() == android.R.id.home) {
            Log.i(TAG, "android.R.id.home");
            finish();
        } else if (item.getItemId() == R.id.menu_item_info) {
            Log.i(TAG, "R.id.menu_item_info");
        } else {
            Log.i(TAG, "NOT android.R.id.home or R.id.menu_item_info");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i(TAG, "onActivityResult()");

        if (resultCode == RESULT_OK) {
            Log.i(TAG, "resultCode == RESULT_OK");

            if (requestCode == CustomizeActivity.REQUEST_CODE) {
                Log.i(TAG, "requestCode == CustomizeActivity.REQUEST_CODE");

                Drink drinkReturned = (Drink) data.getSerializableExtra(CustomizeActivity.RESULT_KEY);
                drink.setDrinkComponents(drinkReturned.getDrinkComponents());
                drink.setDrinkComponentsDefaultAsString(drinkReturned.getDrinkComponentsDefaultAsString());

                Pair<List<DrinkComponent>, List<String>> pairDefaultAndTypes = generateWhatsIncluded(drink);
                adapter.setDrinkComponents(pairDefaultAndTypes.first);
                adapter.setDrinkComponentsDefaultAsString(pairDefaultAndTypes.second);

                adapter.notifyDataSetChanged();
            } else {
                Log.e(TAG, "requestCode != CustomizeActivity.REQUEST_CODE");
            }
        } else {
            Log.e(TAG, "resultCode != RESULT_OK");
        }
    }
}