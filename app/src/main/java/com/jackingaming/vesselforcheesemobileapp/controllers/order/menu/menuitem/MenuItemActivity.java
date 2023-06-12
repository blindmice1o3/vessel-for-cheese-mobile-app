package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.menu.Menu;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.Drink;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.espresso.milk_based.lattes.CaffeLatte;

public class MenuItemActivity extends AppCompatActivity {
    public static final String TAG = MenuItemActivity.class.getSimpleName();
    public static final String EXTRA_NAME_CATEGORY = "com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.nameCategory";
    public static final String EXTRA_NAME_SUB_CATEGORY = "com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.nameSubCategory";
    public static final String EXTRA_POSITION = "com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.position";

    private TextView textViewSelected;

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
//        LinearLayout linearLayout = findViewById(R.id.linearlayout_whatsincluded);

        Button buttonCustomize = findViewById(R.id.button_customize);

        TextView tvDescription = findViewById(R.id.tv_description);
        TextView tvCalories = findViewById(R.id.tv_calories);
        Button buttonNutritionAndIngredient = findViewById(R.id.button_nutrition_and_ingredient);

        ExtendedFloatingActionButton extendedFloatingActionButton = findViewById(R.id.fab);

        if (nameCategory.equals(Menu.HOT_COFFEES)) {
            Log.i(TAG, "Menu.HOT_COFFEES [which implies the selected MenuItem is a Drink]");
            Drink drink = (Drink) Menu.hotCoffeesAsMap.get(nameSubCategory).get(position);

            // TODO: add field to MenuItem class: long idImageResource.
            // TODO: add field to MenuItem class: int calories.
//            ivMenuItemImage.setImageResource(R.drawable.harvest_moon_natsume);
            tvMenuItemName.setText(drink.getName());
            tvMenuItemCalories.setText("42 calories");

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
                for (DrinkComponent drinkComponent : drink.getDrinkComponentsWhatsIncluded()) {
                    sb.append("\n" + drinkComponent.toString());
                }
                tvWhatsIncluded.setText(textPreviousWhatsIncluded + ": " + sb.toString());
            }

            tvWhatsIncluded.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String[] names = {"Colin", "Mulan", "Muly", "Muhang", "Mushu"};
                    ModalBottomSheet.newInstance(names).show(getSupportFragmentManager(), ModalBottomSheet.TAG);
                }
            });

            getSupportFragmentManager().setFragmentResultListener(ModalBottomSheet.REQUEST_KEY, this, new FragmentResultListener() {
                @Override
                public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                    if (requestKey.equals(ModalBottomSheet.REQUEST_KEY)) {
                        String name = result.getString(ModalBottomSheet.KEY_RESULT);
                        // TODO: update the underlying model.
                        textViewSelected.setText(name);
                        textViewSelected = null;
                    }
                }
            });
            WhatsIncludedAdapter adapter = new WhatsIncludedAdapter(drink.getDrinkComponentsWhatsIncluded(), new WhatsIncludedAdapter.WhatsIncludedAdapterListener() {
                @Override
                public void onItemClicked(String[] names, TextView textView) {
                    Log.i(TAG, "onItemClicked(String[] names, TextView textView)");
                    textViewSelected = textView;
                    ModalBottomSheet.newInstance(names).show(getSupportFragmentManager(), ModalBottomSheet.TAG);
                }

                @Override
                public void onItemLongClicked(String[] names, TextView textView) {
                    Log.i(TAG, "onItemLongClicked(String[] names, TextView textView)");
                    textViewSelected = textView;
                }
            });
            rvWhatsIncluded.setAdapter(adapter);
            rvWhatsIncluded.setLayoutManager(new LinearLayoutManager(this));

            tvDescription.setText(drink.getDescription());

            tvCalories.setText("42 calories, 10g sugar, 4.0g fat");
        } else {
            Log.e(TAG, "nameCategory does NOT equals " + Menu.HOT_COFFEES);
        }
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
}