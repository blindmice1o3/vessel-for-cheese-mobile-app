package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.child;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.jackingaming.vesselforcheesemobileapp.R;

public class MenuItemCategoryActivity extends AppCompatActivity {
    public static final String TAG = MenuItemCategoryActivity.class.getSimpleName();
    public static final String EXTRA_TITLE = "com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.child.title";
    public static final String EXTRA_SIZE = "com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.child.size";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate()");
        setContentView(R.layout.activity_menu_item_category);

        String title = getIntent().getStringExtra(EXTRA_TITLE);
        int numberOfMenuItems = getIntent().getIntExtra(EXTRA_SIZE, 0);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        // TODO:
        collapsingToolbarLayout.setTitle(title + " (" + numberOfMenuItems + ")");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.rv_menu_item_category);

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