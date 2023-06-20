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

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.menu.Menu;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.Drink;

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

        TextView tvName = findViewById(R.id.tv_name);
        tvName.setText(drink.getName());

        TextView tvSize = findViewById(R.id.tv_size);

        String nameDrinkInLowercase = drink.getDrinkSize().name().toLowerCase();
        String textDrinkSize = capitalizeFirstLetter(nameDrinkInLowercase) + " " +
                drink.getDrinkSize().getSizeInFlOz() + " " + " fl oz";
        tvSize.setText(textDrinkSize);

        RecyclerView rvCustomize = findViewById(R.id.rv_customize);
        rvCustomize.setAdapter(new CustomizeAdapter(this, drink));
        rvCustomize.setLayoutManager(new LinearLayoutManager(this));

        Button buttonDoneCustomizing = findViewById(R.id.button_done_customizing);
        buttonDoneCustomizing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "buttonDoneCustomizing clicked");

                Intent result = new Intent();
                result.putExtra(RESULT_KEY, drink);
                setResult(RESULT_OK, result);
                finish();
            }
        });
    }

    private String capitalizeFirstLetter(String text) {
        char[] c = text.toCharArray();
        c[0] = Character.toUpperCase(c[0]);
        return new String(c);
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
        }
        return super.onOptionsItemSelected(item);
    }
}