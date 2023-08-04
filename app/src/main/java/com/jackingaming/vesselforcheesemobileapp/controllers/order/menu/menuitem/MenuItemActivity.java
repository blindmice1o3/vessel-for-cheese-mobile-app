package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.OrderFragment;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.customize.CustomizeActivity;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.revieworder.ReviewOrderActivity;
import com.jackingaming.vesselforcheesemobileapp.models.components.Granular;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.menu.Menu;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.MenuItem;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.Drink;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.DrinkSize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MenuItemActivity extends AppCompatActivity {
    public static final String TAG = MenuItemActivity.class.getSimpleName();
    public static final String EXTRA_NAME_CATEGORY = "com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.nameCategory";
    public static final String EXTRA_NAME_SUB_CATEGORY = "com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.nameSubCategory";
    public static final String EXTRA_POSITION = "com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.position";

    private Drink drink;
    private WhatsIncludedAdapter adapter;

    public void initHeightAppBarLayoutAsHalfScreen(AppBarLayout appBarLayout) {
        float heightDp = getResources().getDisplayMetrics().heightPixels / 2;
        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams();
        lp.height = (int) heightDp;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate()");
        setContentView(R.layout.activity_menu_item);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_close_clear_cancel);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar_layout);
        collapsingToolbarLayout.setTitle(" ");
        AppBarLayout appBarLayout = findViewById(R.id.app_bar_layout);
        initHeightAppBarLayoutAsHalfScreen(appBarLayout);

        ImageView ivMenuItemImage = findViewById(R.id.iv_menuitem_image);
        TextView tvMenuItemName = findViewById(R.id.tv_menuitem_name);
        TextView tvMenuItemCalories = findViewById(R.id.tv_menuitem_calories);

        String nameCategory = getIntent().getStringExtra(EXTRA_NAME_CATEGORY);
        String nameSubCategory = getIntent().getStringExtra(EXTRA_NAME_SUB_CATEGORY);
        int position = getIntent().getIntExtra(EXTRA_POSITION, -1);

        TextView tvContent = findViewById(R.id.tv_content);
        tvContent.setText(nameCategory + " | " + nameSubCategory + " | position: " + position);

        RecyclerView rvWhatsIncluded = findViewById(R.id.rv_whats_included);

        Button buttonCustomize = findViewById(R.id.button_customize);

        TextView tvDescription = findViewById(R.id.tv_description);
        TextView tvCaloriesSugarFat = findViewById(R.id.tv_calories_sugar_fat);
        Button buttonNutritionAndIngredient = findViewById(R.id.button_nutrition_and_ingredient);

        if (nameCategory.equals(Menu.HOT_COFFEES) ||
                nameCategory.equals(Menu.COLD_COFFEES)) {
            Log.i(TAG, "Menu.HOT_COFFEES || Menu.COLD_COFFEES " +
                    "[which implies the selected MenuItem is a Drink]");
            drink = createCopyOfDrinkFromMenu(nameCategory, nameSubCategory, position);

            // TODO: add field to MenuItem class: long idImageResource.
//            ivMenuItemImage.setImageResource(R.drawable.harvest_moon_natsume);
            tvMenuItemName.setText(drink.getName());
            tvMenuItemCalories.setText(drink.getCalories() + " calories");

            appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
                @Override
                public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                    if (Math.abs(verticalOffset) == appBarLayout.getTotalScrollRange()) {
                        // Collapsed
                        collapsingToolbarLayout.setTitle(drink.getName());
                    } else {
                        // Un-collapsed
                        // careful: there should a space between double quote otherwise it wont work.
                        collapsingToolbarLayout.setTitle(" ");
                    }

//                    float percentage = (float) Math.abs(verticalOffset) / appBarLayout.getTotalScrollRange();
//                    if (Math.abs(verticalOffset) == appBarLayout.getTotalScrollRange()) {
//                        // Collapsed
//                        collapsingToolbarLayout.setTitle(drink.getName());
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

            String textPreviousContent = tvContent.getText().toString();
            tvContent.setText(textPreviousContent + ": " + drink.getName());

            LinearLayout linearLayoutDrinkSizeOptions = findViewById(R.id.linearlayout_drink_size_options);
            DrinkSize[] drinkSizesAllowed = drink.getDrinkSizesAllowed();
            for (int i = 0; i < drinkSizesAllowed.length; i++) {
                ImageView imageView = new ImageView(this);
                imageView.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        1.0f));

                DrinkSize drinkSize = drinkSizesAllowed[i];
                int imageResource = 0;
                switch (drinkSize) {
                    case SHORT:
                        imageResource = R.drawable.drinksize_short;
                        break;
                    case TALL:
                        imageResource = R.drawable.drinksize_tall;
                        break;
                    case GRANDE:
                        imageResource = R.drawable.drinksize_grande;
                        break;
                    case VENTI_HOT:
                        imageResource = R.drawable.drinksize_venti;
                        break;
                    case VENTI_ICED:
                        imageResource = R.drawable.drinksize_venti;
                        break;
                    case TRENTA:
                        imageResource = R.drawable.drinksize_trenta;
                        break;
                    case UNIQUE:
                        imageResource = R.drawable.drinksize_short;
                        break;
                    case UNDEFINED:
                        imageResource = R.drawable.drinksize_short;
                        break;
                }
                imageView.setImageResource(imageResource);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MenuItemActivity.this, "drinkSize: " + drinkSize.name(), Toast.LENGTH_SHORT).show();

                        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        boolean changedUserCustomizations =
                                drink.updateDrinkSize(drinkSize);
                        if (changedUserCustomizations) {
                            showDialogChangedUserCustomizations();
                        }
                        // always update (default value may have changed)
                        adapter.init(drink);
                        adapter.notifyDataSetChanged();
                        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

                        for (int j = 0; j < linearLayoutDrinkSizeOptions.getChildCount(); j++) {
                            if (drinkSizesAllowed[j] == drinkSize) {
                                ((ImageView) linearLayoutDrinkSizeOptions.getChildAt(j)).setColorFilter(
                                        ContextCompat.getColor(MenuItemActivity.this, R.color.purple_200),
                                        PorterDuff.Mode.MULTIPLY
                                );
                            } else {
                                ((ImageView) linearLayoutDrinkSizeOptions.getChildAt(j)).setColorFilter(
                                        ContextCompat.getColor(MenuItemActivity.this, R.color.white),
                                        PorterDuff.Mode.MULTIPLY
                                );
                            }
                        }
                    }
                });

                if (drinkSize == drink.getDrinkSize()) {
                    imageView.setColorFilter(
                            ContextCompat.getColor(this, R.color.purple_200),
                            PorterDuff.Mode.MULTIPLY
                    );
                }

                linearLayoutDrinkSizeOptions.addView(imageView);
            }

            adapter = new WhatsIncludedAdapter(drink,
                    new DrinkComponentBaseAdapter.DrinkComponentBaseAdapterListener() {
                        @Override
                        public void onItemClicked(String[] names, String nameDefault) {
                            Log.i(TAG, "onItemClicked(String[] names, String nameDefault)");

                            ModalBottomSheet.newInstance(names, nameDefault).show(getSupportFragmentManager(), ModalBottomSheet.TAG);
                        }

                        @Override
                        public void onItemLongClicked(String[] names, String nameDefault) {
                            Log.i(TAG, "onItemLongClicked(String[] names, String nameDefault)");
                        }
                    });
            rvWhatsIncluded.setAdapter(adapter);
            rvWhatsIncluded.setLayoutManager(new LinearLayoutManager(this));

            getSupportFragmentManager().setFragmentResultListener(ModalBottomSheet.REQUEST_KEY, this, new FragmentResultListener() {
                @Override
                public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                    if (requestKey.equals(ModalBottomSheet.REQUEST_KEY)) {
                        String name = result.getString(ModalBottomSheet.KEY_RESULT);

                        adapter.updateDrinkComponentByString(name);
                    }
                }
            });

            buttonCustomize.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // ***********************************
                    removeDuplicateGranularInvoker(drink);
                    // ***********************************

                    Intent intentCustomize = new Intent(MenuItemActivity.this, CustomizeActivity.class);
                    intentCustomize.putExtra(CustomizeActivity.EXTRA_DRINK, drink);
                    startActivityForResult(intentCustomize, CustomizeActivity.REQUEST_CODE);
                }
            });

            tvDescription.setText(drink.getDescription());

            String formatStringCaloriesSugarFat = "%d calories, %dg sugar, %.1fg fat";
            tvCaloriesSugarFat.setText(
                    String.format(formatStringCaloriesSugarFat,
                            drink.getCalories(), drink.getSugarInGram(), drink.getFatInGram())
            );
        } else {
            Log.e(TAG, "nameCategory does NOT equals " + Menu.HOT_COFFEES);
        }

        Button buttonCart = findViewById(R.id.button_cart);
        buttonCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "buttonCart clicked");

                Intent intentReviewOrder = new Intent(MenuItemActivity.this, ReviewOrderActivity.class);
                startActivity(intentReviewOrder);
            }
        });

        ExtendedFloatingActionButton extendedFloatingActionButton = findViewById(R.id.fab);
        extendedFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "extendedFloatingActionButton clicked");

                OrderFragment.getInstance().addMenuItemToOrder(drink);

                Snackbar.make(view, drink.getName() + " added", Snackbar.LENGTH_LONG)
                        .show();
            }
        });
    }

    private Drink createCopyOfDrinkFromMenu(String nameCategory, String nameSubCategory, int position) {
        MenuItem menuItem = null;
        if (nameCategory.equals(Menu.HOT_COFFEES)) {
            menuItem = Menu.hotCoffeesAsMap.get(nameSubCategory).get(position);
        } else if (nameCategory.equals(Menu.COLD_COFFEES)) {
            menuItem = Menu.coldCoffeesAsMap.get(nameSubCategory).get(position);
        } else {
            Log.e(TAG, "nameCategory NOT equals() Menu.HOT_COFFEES nor Menu.COLD_COFFEES");
        }

        if (menuItem instanceof Drink) {
            Drink original = (Drink) menuItem;
            Drink copy = null;
            try {
                // Serialize the object
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(original);
                oos.close();

                // Deserialize the object
                ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                ObjectInputStream ois = new ObjectInputStream(bais);
                copy = (Drink) ois.readObject();
            } catch (IOException | ClassNotFoundException exception) {
                exception.printStackTrace();
            }

            return copy;
        } else {
            Log.e(TAG, "NOT menuItem instanceof Drink");

            return null;
        }
    }

    private void showDialogChangedUserCustomizations() {
        ChangedUserCustomizationsDialogFragment.newInstance()
                .show(getSupportFragmentManager(), TAG);
    }

    private void removeDuplicateGranularInvoker(Drink drink) {
        Map<String, List<DrinkComponent>> drinkComponents = drink.getDrinkComponents();
        Map<String, List<String>> drinkComponentsDefaultAsString = drink.getDrinkComponentsDefaultAsString();

        for (int i = 0; i < Menu.DRINK_COMPONENTS_KEYS.size(); i++) {
            String key = Menu.DRINK_COMPONENTS_KEYS.get(i);
            Log.d(TAG, i + ": " + Menu.DRINK_COMPONENTS_KEYS.get(i));
            if (drinkComponents.containsKey(key)) {
                List<DrinkComponent> drinkComponentsGroup = drinkComponents.get(key);
                List<String> drinkComponentsDefaultAsStringGroup = drinkComponentsDefaultAsString.get(key);

                for (int j = 0; j < drinkComponentsGroup.size(); j++) {
                    DrinkComponent drinkComponent = drinkComponentsGroup.get(j);
                    Log.e(TAG, "drinkComponent.getTypeAsString(): " + drinkComponent.getTypeAsString());

                    if (drinkComponent instanceof Granular) {
                        if (drinkComponent.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING)) {
                            String classDrinkComponent = drinkComponent.getClassAsString();

                            List<Integer> indexesOfDuplicate = new ArrayList<>();
                            for (int k = 0; k < drinkComponentsGroup.size(); k++) {
                                DrinkComponent drinkComponentInner = drinkComponentsGroup.get(k);
                                Log.e(TAG, "drinkComponentInner.getTypeAsString(): " + drinkComponentInner.getTypeAsString());

                                if (drinkComponentInner == drinkComponent) {
                                    Log.e(TAG, "drinkComponentInner == drinkComponent");
                                    continue;
                                }

                                if (drinkComponentInner.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING)) {
                                    String classDrinkComponentInner = drinkComponentInner.getClassAsString();
                                    if (classDrinkComponentInner.equals(classDrinkComponent)) {
                                        Log.e(TAG, "classDrinkComponentInner.equals(classDrinkComponent)");
                                        Log.e(TAG, "ADD: " + drinkComponentInner.getClassAsString() + ", " + drinkComponentInner.getTypeAsString());
                                        indexesOfDuplicate.add(k);
                                    }
                                }
                            }

                            for (Integer indexOfRemoval : indexesOfDuplicate) {
                                DrinkComponent drinkComponentRemoval = drinkComponentsGroup.remove(indexOfRemoval.intValue());
                                String drinkComponentDefaultRemoval = drinkComponentsDefaultAsStringGroup.remove(indexOfRemoval.intValue());
                                Log.e(TAG, "successfulRemoval: " + drinkComponentRemoval.getClassAsString() + ", " + drinkComponentRemoval.getTypeAsString());
                                Log.e(TAG, "default value: " + drinkComponentDefaultRemoval);
                            }
                        }
                    }
                }
            }
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i(TAG, "onActivityResult()");

        if (resultCode == RESULT_OK) {
            Log.i(TAG, "resultCode == RESULT_OK");

            if (requestCode == CustomizeActivity.REQUEST_CODE) {
                Log.i(TAG, "requestCode == CustomizeActivity.REQUEST_CODE");

                Drink drinkReturned = (Drink) data.getSerializableExtra(CustomizeActivity.RESULT_KEY);
                drink.setDrinkComponents(drinkReturned.getDrinkComponents());
                drink.setDrinkComponentsDefaultAsString(drinkReturned.getDrinkComponentsDefaultAsString());
                drink.setDrinkComponentsStandardRecipe(drinkReturned.getDrinkComponentsStandardRecipe());

                adapter.init(drink);
                adapter.notifyDataSetChanged();
            } else {
                Log.e(TAG, "requestCode != CustomizeActivity.REQUEST_CODE");
            }
        } else {
            Log.e(TAG, "resultCode != RESULT_OK");
        }
    }
}