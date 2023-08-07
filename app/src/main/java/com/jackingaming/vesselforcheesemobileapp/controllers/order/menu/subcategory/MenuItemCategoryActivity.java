package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.subcategory;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.menu.Menu;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.MenuItem;

import java.util.List;
import java.util.Map;

public class MenuItemCategoryActivity extends AppCompatActivity {
    public static final String TAG = MenuItemCategoryActivity.class.getSimpleName();
    public static final String EXTRA_TITLE = "com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.child.title";
    public static final String EXTRA_SIZE = "com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.child.size";

    public void initHeightAppBarLayoutAsQuarterScreen(AppBarLayout appBarLayout) {
        float heightDp = getResources().getDisplayMetrics().heightPixels / 4;
        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams();
        lp.height = (int) heightDp;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate()");
        setContentView(R.layout.activity_menu_item_category);

        String title = getIntent().getStringExtra(EXTRA_TITLE);
        int numberOfMenuItems = getIntent().getIntExtra(EXTRA_SIZE, 0);

        AppBarLayout appBarLayout = findViewById(R.id.app_bar_layout);
        initHeightAppBarLayoutAsQuarterScreen(appBarLayout);

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar_layout);
        collapsingToolbarLayout.setTitle(title + " (" + numberOfMenuItems + ")");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // TODO: change from just Brewed Coffees to all 9 sub-categories of Hot Coffees.
        // TODO: use Menu.hotCoffeesAsMap
        Map<String, List<MenuItem>> categorySelected = null;
        if (title.equals(Menu.OILEETO)) {
            categorySelected = Menu.oileetoAsMap;
        } else if (title.equals(Menu.HOT_COFFEES)) {
            categorySelected = Menu.hotCoffeesAsMap;
        } else if (title.equals(Menu.HOT_TEAS)) {
            categorySelected = Menu.hotTeasAsMap;
        } else if (title.equals(Menu.HOT_DRINKS)) {
            categorySelected = Menu.hotDrinksAsMap;
        } else if (title.equals(Menu.BLENDED_BEVERAGES)) {
            categorySelected = Menu.blendedBeveragesAsMap;
        } else if (title.equals(Menu.COLD_COFFEES)) {
            categorySelected = Menu.coldCoffeesAsMap;
        } else if (title.equals(Menu.ICED_TEAS)) {
            categorySelected = Menu.icedTeasAsMap;
        } else if (title.equals(Menu.COLD_DRINKS)) {
            categorySelected = Menu.coldDrinksAsMap;
        } else if (title.equals(Menu.HOT_BREAKFAST)) {
            categorySelected = Menu.hotBreakfastAsMap;
        } else if (title.equals(Menu.OATMEAL_AND_YOGURT)) {
            categorySelected = Menu.oatmealAndYogurtAsMap;
        } else if (title.equals(Menu.BAKERY)) {
            categorySelected = Menu.bakeryAsMap;
        } else if (title.equals(Menu.LUNCH)) {
            categorySelected = Menu.lunchAsMap;
        } else if (title.equals(Menu.SNACKS_AND_SWEETS)) {
            categorySelected = Menu.snacksAndSweetsAsMap;
        } else if (title.equals(Menu.WHOLE_BEAN)) {
            categorySelected = Menu.wholeBeanAsMap;
        } else if (title.equals(Menu.INSTANT_COFFEE)) {
            categorySelected = Menu.instantCoffeeAsMap;
        } else if (title.equals(Menu.COLD_CUPS)) {
            categorySelected = Menu.coldCupsAsMap;
        } else if (title.equals(Menu.TUMBLERS)) {
            categorySelected = Menu.tumblersAsMap;
        } else if (title.equals(Menu.MUGS)) {
            categorySelected = Menu.mugsAsMap;
        } else if (title.equals(Menu.WATER_BOTTLES)) {
            categorySelected = Menu.waterBottlesAsMap;
        } else if (title.equals(Menu.OTHER)) {
            categorySelected = Menu.otherAsMap;
        } else if (title.equals(Menu.HAPPY_BIRTHDAY)) {
            categorySelected = Menu.happyBirthdayAsMap;
        } else if (title.equals(Menu.THANK_YOU)) {
            categorySelected = Menu.thankYouAsMap;
        } else if (title.equals(Menu.TRADITIONAL)) {
            categorySelected = Menu.traditionalAsMap;
        } else {
            Log.e(TAG, "title NOT equals() current listed options from MenuItemCategoryActivity.onCreate()");
        }
        SubCategoryAdapter adapter = new SubCategoryAdapter(title, categorySelected, new SubCategoryAdapter.SubCategoryAdapterListener() {
            @Override
            public void onItemClicked(int position, View view) {
                Toast.makeText(MenuItemCategoryActivity.this, "onItemClicked() position: " + position, Toast.LENGTH_SHORT).show();
                // TODO:
            }

            @Override
            public void onItemLongClicked(int position, View view) {
                Toast.makeText(MenuItemCategoryActivity.this, "onItemLongClicked() position: " + position, Toast.LENGTH_SHORT).show();
                // TODO:
            }
        });

        RecyclerView recyclerView = findViewById(R.id.rv_menu_item_category);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull android.view.MenuItem item) {
        Log.i(TAG, "onOptionsItemSelected()");
        if (item.getItemId() == android.R.id.home) {
            Log.i(TAG, "up button (android.R.id.home) was pressed");
            // TODO: if needed, can customize behavior of Up-button here.
            return super.onOptionsItemSelected(item);
        } else {
            Log.i(TAG, "else-clause");
            return super.onOptionsItemSelected(item);
        }
    }
}