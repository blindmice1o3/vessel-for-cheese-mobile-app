package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.customize;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.Drink;

public class CustomizeActivity extends AppCompatActivity {
    public static final String TAG = CustomizeActivity.class.getSimpleName();
    public static final String EXTRA_DRINK = "com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.customize.drink";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate()");
        setContentView(R.layout.activity_customize);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(" ");

        Drink drink = (Drink) getIntent().getSerializableExtra(EXTRA_DRINK);

        TextView tvName = findViewById(R.id.tv_name);
        tvName.setText(drink.getName());

        TextView tvSize = findViewById(R.id.tv_size);
        tvSize.setText(drink.getDrinkSize().name());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull android.view.MenuItem item) {
        Log.i(TAG, "onOptionsItemSelected()");

        if (item.getItemId() == android.R.id.home) {
            Log.i(TAG, "android.R.id.home");
            finish();
        } else {
            Log.i(TAG, "NOT android.R.id.home");
        }
        return super.onOptionsItemSelected(item);
    }
}