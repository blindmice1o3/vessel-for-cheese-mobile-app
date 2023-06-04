package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.subcategory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.menu.Menu;

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
        SubCategoryAdapter adapter = new SubCategoryAdapter(Menu.hotCoffeesAsMap, new SubCategoryAdapter.SubCategoryAdapterListener() {
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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
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