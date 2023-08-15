package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.hierarchy.section;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.hierarchy.topic.MenuItemAdapter;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.MenuItemActivity;
import com.jackingaming.vesselforcheesemobileapp.models.menu.hierarchy.Section;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.MenuItem;

public class SectionAsGridActivity extends AppCompatActivity {
    public static final String TAG = SectionAsGridActivity.class.getSimpleName();
    public static final String EXTRA_SECTION_SELECTED = "com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.hierarchy.section.sectionSelected";
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
        setContentView(R.layout.activity_section_as_grid);

        Section sectionSelected = (Section) getIntent().getSerializableExtra(EXTRA_SECTION_SELECTED);

        AppBarLayout appBarLayout = findViewById(R.id.app_bar_layout);
        initHeightAppBarLayoutAsQuarterScreen(appBarLayout);

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar_layout);
        String formatStringTitle = "%s (%d)";
        String title = String.format(formatStringTitle,
                sectionSelected.getName(), sectionSelected.getMenuItems().size());
        collapsingToolbarLayout.setTitle(title);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView rvMenuItem = findViewById(R.id.rv_nested);
        MenuItemAdapter adapter = new MenuItemAdapter(sectionSelected.getMenuItems(), new MenuItemAdapter.MenuItemAdapterListener() {
            @Override
            public void onItemClicked(View view, MenuItem menuItemSelected) {
                Log.i(TAG, "onItemClicked(View, MenuItem) menuItemSelected: " + menuItemSelected.getName());
                Intent intent = new Intent(view.getContext(), MenuItemActivity.class);
                intent.putExtra(MenuItemActivity.EXTRA_MENU_ITEM_SELECTED, menuItemSelected);
                view.getContext().startActivity(intent);
            }

            @Override
            public void onItemLongClicked(View view, MenuItem menuItemSelected) {
                Log.i(TAG, "onItemLongClicked(View, MenuItem) menuItemSelected: " + menuItemSelected.getName());
                // TODO:
            }
        });
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, NUMBER_OF_COLUMNS);
        rvMenuItem.setAdapter(adapter);
        rvMenuItem.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull android.view.MenuItem item) {
        Log.i(TAG, "onOptionsItemSelected()");
        if (item.getItemId() == android.R.id.home) {
            Log.i(TAG, "up button (android.R.id.home) was pressed");

            finish();
            return true;
        } else {
            Log.i(TAG, "else-clause");
            return super.onOptionsItemSelected(item);
        }
    }
}