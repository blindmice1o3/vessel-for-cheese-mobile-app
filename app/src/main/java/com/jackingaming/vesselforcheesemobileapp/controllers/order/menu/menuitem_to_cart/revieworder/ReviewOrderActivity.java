
package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem_to_cart.revieworder;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.OrderFragment;
import com.jackingaming.vesselforcheesemobileapp.models.LocalDateTimeTypeAdapter;
import com.jackingaming.vesselforcheesemobileapp.models.MenuItemInfo;
import com.jackingaming.vesselforcheesemobileapp.models.Order;
import com.jackingaming.vesselforcheesemobileapp.models.components.Granular;
import com.jackingaming.vesselforcheesemobileapp.models.components.GranularTwoOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.Incrementable;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesemobileapp.models.menu.Menu;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.MenuItem;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.Drink;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.NotHandCrafted;

import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReviewOrderActivity extends AppCompatActivity {
    public static final String TAG = ReviewOrderActivity.class.getSimpleName();
    public static final String EXTRA_ORDER = "com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem_to_cart.revieworder.order";

    public static final String URL_ORDER = "http://192.168.1.143:8080/orders";
    private RequestQueue requestQueue;

    private CollapsingToolbarLayout collapsingToolbarLayout;

    private List<MenuItem> order;
    private RecyclerView rvReviewOrder;

    public void initHeightAppBarLayoutAsSixthScreen(AppBarLayout appBarLayout) {
        float heightDp = getResources().getDisplayMetrics().heightPixels / 6;
        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams();
        lp.height = (int) heightDp;
    }

    public void updateToolbarTitle() {
        String formatString = "Review order (%d)";
        collapsingToolbarLayout.setTitle(String.format(formatString, order.size()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_order);

        // --------------------------------------------
        order = OrderFragment.getInstance().getOrder();
        requestQueue = Volley.newRequestQueue(this);
        // --------------------------------------------

        AppBarLayout appBarLayout = findViewById(R.id.app_bar_layout);
        initHeightAppBarLayoutAsSixthScreen(appBarLayout);

        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar_layout);
        updateToolbarTitle();

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_arrow_down);
        setSupportActionBar(toolbar);

        rvReviewOrder = findViewById(R.id.rv_review_order);
        rvReviewOrder.setAdapter(new ReviewOrderAdapter(order, new ReviewOrderAdapter.ReviewOrderAdapterListener() {
            @Override
            public void onItemClicked() {
                Log.i(TAG, "onItemClicked()");

                // TODO: (maybe) re-use CustomizeActivity to give
                //  quick access to editing the selected MenuItem.
            }

            @Override
            public void onItemLongClicked() {
                Log.i(TAG, "onItemLongClicked()");
            }
        }));
        rvReviewOrder.setLayoutManager(new LinearLayoutManager(this));

        ExtendedFloatingActionButton fabContinue = findViewById(R.id.fab);
        fabContinue.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                Log.i(TAG, "[Continue] clicked");

                Order order = new Order(
                        LocalDateTime.now(),
                        convertToListOfMenuItemInfo(
                                OrderFragment.getInstance().getOrder()
                        )
                );

                try {
                    postOrder(order);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

//                StringRequest stringRequest =
//                        new StringRequest(
//                                Request.Method.POST,
//                                URL_ADD_NEW_MEAL,
//                                new Response.Listener<String>() {
//                                    @Override
//                                    public void onResponse(String response) {
//                                        Log.i(TAG, "fabContinue click listener's onResponse()");
//
//                                        Log.e(TAG, response);
//                                    }
//                                },
//                                new Response.ErrorListener() {
//                                    @Override
//                                    public void onErrorResponse(VolleyError error) {
//                                        Log.e(TAG, "requestPostMeal() onErrorResponse(): " + error);
//                                    }
//                                }
//                        ) {
//                            @Nullable
//                            @Override
//                            protected Map<String, String> getParams() throws AuthFailureError {
//                                Map<String, String> params = new HashMap<String, String>();
//                                params.put("nameDrink", nameDrink);
//                                params.put("sizeDrink", Integer.toString(sizeDrink));
//                                return params;
//                            }
//                        };
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void postOrder(Order order) throws JSONException {
        Log.i(TAG, "postOrder(Order)");

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
        String orderAsJsonString = gson.toJson(order);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST,
                URL_ORDER,
                new JSONObject(orderAsJsonString),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Order responsePayload = gson.fromJson(response.toString(), Order.class);

                        LocalDateTime createdOnPayload = responsePayload.getCreatedOn();
                        Log.e(TAG, createdOnPayload.toString());

                        Log.i(TAG, "onResponse(JSONObject) clearing local Order from OrderFragment.");
                        OrderFragment.getInstance().getOrder().clear();
                        rvReviewOrder.getAdapter().notifyDataSetChanged();
                        updateToolbarTitle();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        Log.e(TAG, "onErrorResponse(VolleyError)" + error);
                    }
                });

        requestQueue.add(jsonObjectRequest);
    }

    private List<MenuItemInfo> convertToListOfMenuItemInfo(List<MenuItem> order) {
        Log.i(TAG, "convertToListOfMenuItemInfo(List<MenuItem>)");

        List<MenuItemInfo> menuItemInfos = new ArrayList<>();

        for (MenuItem menuItem : order) {
            String menuItemId = menuItem.getId();
            String menuItemSize = null;
            List<String> menuItemCustomizations = new ArrayList<>();

            if (menuItem instanceof Drink) {
                Map<String, List<DrinkComponentWithDefaultAsString>> drinkComponents = ((Drink) menuItem).getDrinkComponents();
                for (String key : Menu.DRINK_COMPONENTS_KEYS) {
                    if (drinkComponents.containsKey(key)) {
                        List<DrinkComponentWithDefaultAsString> drinkComponentsGroup = drinkComponents.get(key);
                        for (int i = 0; i < drinkComponentsGroup.size(); i++) {
                            DrinkComponent drinkComponent = drinkComponentsGroup.get(i).getDrinkComponent();
                            String drinkComponentDefaultAsString = drinkComponentsGroup.get(i).getDrinkComponentDefaultAsString();

                            if (drinkComponent.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING)) {
                                continue;
                            }

                            if (drinkComponent instanceof Incrementable) {
                                String quantityAsString = Integer.toString(((Incrementable) drinkComponent).getQuantity());
                                if (quantityAsString.equals(drinkComponentDefaultAsString)) {
                                    continue;
                                }
                            } else if (drinkComponent instanceof Granular) {
                                String amountAsString = ((Granular) drinkComponent).getAmount().name();
                                if (amountAsString.equals(drinkComponentDefaultAsString)) {
                                    continue;
                                }
                            } else {
                                String typeAsString = drinkComponent.getTypeAsString();
                                if (typeAsString.equals(drinkComponentDefaultAsString)) {
                                    continue;
                                }
                            }

                            String drinkComponentDetails = null;
                            if (drinkComponent instanceof Incrementable) {
                                drinkComponentDetails = drinkComponent.getId() + ", " + drinkComponent.getTypeAsString() +
                                        ", " + ((Incrementable) drinkComponent).getQuantity();
                            } else if (drinkComponent instanceof GranularTwoOptions) {
                                drinkComponentDetails = drinkComponent.getId() + ", " + drinkComponent.getTypeAsString() +
                                        ", " + ((GranularTwoOptions) drinkComponent).getOption();
                            } else if (drinkComponent instanceof Granular) {
                                drinkComponentDetails = drinkComponent.getId() + ", " + drinkComponent.getTypeAsString() +
                                        ", " + ((Granular) drinkComponent).getAmount();
                            } else {
                                drinkComponentDetails = drinkComponent.getId() + ", " + drinkComponent.getTypeAsString() +
                                        ", " + "SimpleSelection";
                            }

                            menuItemCustomizations.add(drinkComponentDetails);
                        }
                    }
                }

                // convert DrinkSize to String
                String drinkSizeAsString = null;
                if (((Drink) menuItem) instanceof NotHandCrafted) {
                    float containerSize = ((NotHandCrafted) menuItem).getContainerSize();
                    drinkSizeAsString = (containerSize < 0) ?
                            "traveler" : containerSize + " fl oz";
                } else {
                    drinkSizeAsString = ((Drink) menuItem).getDrinkSize().getUserFriendlyName();
                }

                menuItemInfos.add(
                        new MenuItemInfo(menuItemId, drinkSizeAsString, menuItemCustomizations)
                );
            } else {
                Log.e(TAG, "menuItem NOT instanceof Drink");
            }
        }

        return menuItemInfos;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull android.view.MenuItem item) {
        Log.i(TAG, "onOptionsItemSelected()");

        if (item.getItemId() == android.R.id.home) {
            Log.i(TAG, "android.R.id.home");

            finish();
            return true;
        } else {
            Log.i(TAG, "NOT android.R.id.home");
            return super.onOptionsItemSelected(item);
        }
    }
}