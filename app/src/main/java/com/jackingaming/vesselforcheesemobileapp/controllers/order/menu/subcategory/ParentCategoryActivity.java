package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.subcategory;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.MenuItemActivity;
import com.jackingaming.vesselforcheesemobileapp.models.menu.category.FeaturedParentCategory;
import com.jackingaming.vesselforcheesemobileapp.models.menu.category.ParentCategory;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.MenuItem;

import java.util.List;

public class ParentCategoryActivity extends AppCompatActivity {
    public static final String TAG = ParentCategoryActivity.class.getSimpleName();
    public static final String EXTRA_PARENT_CATEGORY_SELECTED = "com.jackingaming.vesselforcheesemobileapp.models.menu.category.parentCategorySelected";
    public static final int NUMBER_OF_COLUMNS = 2;

    public void initHeightAppBarLayoutAsQuarterScreen(AppBarLayout appBarLayout) {
        float heightDp = getResources().getDisplayMetrics().heightPixels / 4;
        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams();
        lp.height = (int) heightDp;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate()");
        setContentView(R.layout.activity_parent_category);

        ParentCategory parentCategorySelected = (ParentCategory) getIntent().getSerializableExtra(EXTRA_PARENT_CATEGORY_SELECTED);

        AppBarLayout appBarLayout = findViewById(R.id.app_bar_layout);
        initHeightAppBarLayoutAsQuarterScreen(appBarLayout);

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar_layout);
        int sizeOfList = -1;
        if (parentCategorySelected instanceof FeaturedParentCategory) {
            Log.i(TAG, "parentCategorySelected instanceof FeaturedParentCategory ---> SPECIAL FeaturedParentCategory");

            FeaturedParentCategory featuredParentCategory = (FeaturedParentCategory) parentCategorySelected;
            sizeOfList = featuredParentCategory.getMenuItems().size();
        } else {
            Log.i(TAG, "NOT parentCategorySelected instanceof FeaturedParentCategory ---> REGULAR FeaturedParentCategory");

            sizeOfList = parentCategorySelected.getSubCategories().size();
        }
        String formatStringTitle = "%s (%d)";
        String title = String.format(formatStringTitle,
                parentCategorySelected.getName(), sizeOfList);
        collapsingToolbarLayout.setTitle(title);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.rv_menu_item_category);
        RecyclerView.Adapter adapter = null;
        RecyclerView.LayoutManager layoutManager = null;
        if (parentCategorySelected instanceof FeaturedParentCategory) {
            Log.i(TAG, "parentCategorySelected instanceof FeaturedParentCategory ---> SPECIAL FeaturedParentCategory");

            // TODO:
            List<MenuItem> featuredMenuItems = ((FeaturedParentCategory) parentCategorySelected).getMenuItems();
            adapter = new MenuItemAdapter(featuredMenuItems, new MenuItemAdapter.MenuItemAdapterListener() {
                @Override
                public void onItemClicked(int position, View view) {
                    Toast.makeText(view.getContext(), "onItemClicked() position: " + position, Toast.LENGTH_SHORT).show();

                    MenuItem menuItemSelected = featuredMenuItems.get(position);
                    Intent intent = new Intent(view.getContext(), MenuItemActivity.class);
                    intent.putExtra(MenuItemActivity.EXTRA_MENU_ITEM_SELECTED, menuItemSelected);
                    view.getContext().startActivity(intent);
                }

                @Override
                public void onItemLongClicked(int position, View view) {
                    Toast.makeText(view.getContext(), "onItemLongClicked() position: " + position, Toast.LENGTH_SHORT).show();
                    // TODO:
                }
            });

            layoutManager = new GridLayoutManager(this, NUMBER_OF_COLUMNS);
        } else {
            Log.i(TAG, "NOT parentCategorySelected instanceof FeaturedParentCategory ---> REGULAR ParentCategory");

            adapter = new SubCategoryAdapter(parentCategorySelected.getName(), parentCategorySelected.getSubCategories(), new SubCategoryAdapter.SubCategoryAdapterListener() {
                @Override
                public void onItemClicked(int position, View view) {
                    Toast.makeText(ParentCategoryActivity.this, "onItemClicked() position: " + position, Toast.LENGTH_SHORT).show();
                    // TODO:
                }

                @Override
                public void onItemLongClicked(int position, View view) {
                    Toast.makeText(ParentCategoryActivity.this, "onItemLongClicked() position: " + position, Toast.LENGTH_SHORT).show();
                    // TODO:
                }
            });

            layoutManager = new LinearLayoutManager(this);
            ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.VERTICAL);

            RecyclerView.ItemDecoration itemDecoration =
                    new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
            recyclerView.addItemDecoration(itemDecoration);
        }
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

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