package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

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

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_close_clear_cancel);
        setSupportActionBar(toolbar);

        String nameCategory = getIntent().getStringExtra(EXTRA_NAME_CATEGORY);
        String nameSubCategory = getIntent().getStringExtra(EXTRA_NAME_SUB_CATEGORY);
        int position = getIntent().getIntExtra(EXTRA_POSITION, -1);

        TextView tvContent = findViewById(R.id.tv_content);
        tvContent.setText(nameCategory + " | " + nameSubCategory + " | position: " + position);

        if (nameCategory.equals(Menu.HOT_COFFEES)) {
            MenuItem menuItem = Menu.hotCoffeesAsMap.get(nameSubCategory).get(position);
            String textPrevious = tvContent.getText().toString();
            tvContent.setText(textPrevious + ": " + menuItem.getName());
            collapsingToolbarLayout.setTitle(menuItem.getName());
        } else {
            Log.e(TAG, "nameCategory does NOT equals " + Menu.HOT_COFFEES);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull android.view.MenuItem item) {
        Log.i(TAG, "onOptionsItemSelected()");

        if (item.getItemId() == android.R.id.home) {
            Log.d(TAG, "android.R.id.home");
            finish();
        } else {
            Log.d(TAG, "NOT android.R.id.home");
        }
        return super.onOptionsItemSelected(item);
    }
}