package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.customize;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.OrderFragment;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.MenuItemActivity;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.revieworder.ReviewOrderActivity;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.Drink;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CustomizeActivity extends AppCompatActivity {
    public static final String TAG = CustomizeActivity.class.getSimpleName();
    public static final String EXTRA_DRINK = "com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.customize.drink";
    public static final int REQUEST_CODE = 1;
    public static final String RESULT_KEY = "com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.customize.key";

    private Drink drink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate()");
        setContentView(R.layout.activity_customize);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(" ");

        // -----------------------------------------------------------------
        drink = (Drink) getIntent().getSerializableExtra(EXTRA_DRINK);
        // -----------------------------------------------------------------

        RecyclerView rvCustomize = findViewById(R.id.rv_customize);
        rvCustomize.setAdapter(new CustomizeAdapter(this, drink));
        rvCustomize.setLayoutManager(new LinearLayoutManager(this));

        Button buttonCart = findViewById(R.id.button_cart);
        buttonCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "buttonCart clicked");

                Intent intentReviewOrder = new Intent(CustomizeActivity.this, ReviewOrderActivity.class);
                startActivity(intentReviewOrder);
            }
        });

        ExtendedFloatingActionButton extendedFloatingActionButton = findViewById(R.id.fab);
        extendedFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "extendedFloatingActionButton clicked");

                OrderFragment.getInstance().addMenuItemToOrder(drink);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull android.view.MenuItem item) {
        Log.i(TAG, "onOptionsItemSelected()");

        if (item.getItemId() == android.R.id.home) {
            Log.i(TAG, "android.R.id.home");

            Intent result = new Intent();
            result.putExtra(RESULT_KEY, drink);
            setResult(RESULT_OK, result);
            finish();
            return true;
        } else {
            Log.i(TAG, "NOT android.R.id.home");
            return super.onOptionsItemSelected(item);
        }
    }
}