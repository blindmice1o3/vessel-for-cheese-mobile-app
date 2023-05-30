package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.menu.Menu;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.MenuItem;

public class MenuItemActivity extends AppCompatActivity {
    public static final String TAG = MenuItemActivity.class.getSimpleName();
    public static final String EXTRA_NAME_CATEGORY = "com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.nameCategory";
    public static final String EXTRA_NAME_SUB_CATEGORY = "com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.nameSubCategory";
    public static final String EXTRA_POSITION = "com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate()");
        setContentView(R.layout.activity_menu_item);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_close_clear_cancel);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        collapsingToolbarLayout.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        ImageView ivMenuItemImage = (ImageView) findViewById(R.id.iv_menuitem_image);
        TextView tvMenuItemName = (TextView) findViewById(R.id.tv_menuitem_name);
        TextView tvMenuItemCalories = (TextView) findViewById(R.id.tv_menuitem_calories);

        String nameCategory = getIntent().getStringExtra(EXTRA_NAME_CATEGORY);
        String nameSubCategory = getIntent().getStringExtra(EXTRA_NAME_SUB_CATEGORY);
        int position = getIntent().getIntExtra(EXTRA_POSITION, -1);

        TextView tvContent = findViewById(R.id.tv_content);
        tvContent.setText(nameCategory + " | " + nameSubCategory + " | position: " + position);

        if (nameCategory.equals(Menu.HOT_COFFEES)) {
            MenuItem menuItem = Menu.hotCoffeesAsMap.get(nameSubCategory).get(position);
            String textPrevious = tvContent.getText().toString();
            tvContent.setText(textPrevious + ": " + menuItem.getName());

            // TODO: add field to MenuItem class: long idImageResource.
            // TODO: add field to MenuItem class: int calories.
            ivMenuItemImage.setImageResource(R.drawable.harvest_moon_natsume);
            tvMenuItemName.setText(menuItem.getName());
            tvMenuItemCalories.setText("42 calories");

            appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
                @Override
                public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                    if (Math.abs(verticalOffset) == appBarLayout.getTotalScrollRange()) {
                        // Collapsed
                        collapsingToolbarLayout.setTitle(menuItem.getName());
                    } else {
                        // Un-collapsed
                        // careful: there should a space between double quote otherwise it wont work.
                        collapsingToolbarLayout.setTitle(" ");
                    }

//                    float percentage = (float) Math.abs(verticalOffset) / appBarLayout.getTotalScrollRange();
//                    if (Math.abs(verticalOffset) == appBarLayout.getTotalScrollRange()) {
//                        // Collapsed
//                        collapsingToolbarLayout.setTitle(menuItem.getName());
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