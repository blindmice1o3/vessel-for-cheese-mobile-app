
package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem_to_cart.revieworder;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.OrderFragment;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class ReviewOrderActivity extends AppCompatActivity {
    public static final String TAG = ReviewOrderActivity.class.getSimpleName();
    public static final String EXTRA_ORDER = "com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem_to_cart.revieworder.order";

    private CollapsingToolbarLayout collapsingToolbarLayout;

    private List<MenuItem> order;
    private List<List<DrinkComponent>> customizationsFromOrder = new ArrayList<>();

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
        // --------------------------------------------

        AppBarLayout appBarLayout = findViewById(R.id.app_bar_layout);
        initHeightAppBarLayoutAsSixthScreen(appBarLayout);

        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar_layout);
        updateToolbarTitle();

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_arrow_down);
        setSupportActionBar(toolbar);

        RecyclerView rvReviewOrder = findViewById(R.id.rv_review_order);
        rvReviewOrder.setAdapter(new ReviewOrderAdapter(order, new ReviewOrderAdapter.ReviewOrderAdapterListener() {
            @Override
            public void onItemClicked() {
                Log.i(TAG, "onItemClicked()");
            }

            @Override
            public void onItemLongClicked() {
                Log.i(TAG, "onItemLongClicked()");
            }
        }));
        rvReviewOrder.setLayoutManager(new LinearLayoutManager(this));

        ExtendedFloatingActionButton extendedFloatingActionButton = findViewById(R.id.fab);
        extendedFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "[Continue] clicked");
                Toast.makeText(view.getContext(), "[Continue] clicked", Toast.LENGTH_SHORT).show();
                // TODO:
            }
        });
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