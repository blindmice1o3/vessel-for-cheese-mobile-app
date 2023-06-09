package com.jackingaming.vesselforcheesemobileapp.controllers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.controllers.gift.GiftFragment;
import com.jackingaming.vesselforcheesemobileapp.controllers.home.HomeFragment;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.OrderFragment;
import com.jackingaming.vesselforcheesemobileapp.controllers.scan.ScanFragment;
import com.jackingaming.vesselforcheesemobileapp.controllers.stores.StoresFragment;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    public void initHeightAppBarLayoutAsThirdScreen(AppBarLayout appBarLayout) {
        float heightDp = getResources().getDisplayMetrics().heightPixels / 3;
        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams();
        lp.height = (int) heightDp;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppBarLayout appBarLayout = findViewById(R.id.app_bar_layout);
        initHeightAppBarLayoutAsThirdScreen(appBarLayout);

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView bnvMain = findViewById(R.id.bnv_main);
        bnvMain.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        replaceFragmentInFCV(HomeFragment.newInstance(null, null));
                        collapsingToolbarLayout.setTitle(
                                getResources().getString(R.string.app_name)
                        );
                        return true;
                    case R.id.action_scan:
                        replaceFragmentInFCV(ScanFragment.newInstance(null, null));
                        collapsingToolbarLayout.setTitle("Scan");
                        return true;
                    case R.id.action_order:
                        replaceFragmentInFCV(OrderFragment.getInstance());
                        collapsingToolbarLayout.setTitle("Order");
                        return true;
                    case R.id.action_gift:
                        replaceFragmentInFCV(GiftFragment.newInstance(null, null));
                        collapsingToolbarLayout.setTitle("Gift");
                        return true;
                    case R.id.action_stores:
                        replaceFragmentInFCV(StoresFragment.newInstance(null, null));
                        collapsingToolbarLayout.setTitle("Stores");
                        return true;
                    default:
                        Log.e(TAG, "onCreate() bncMain item selected listener's switch-construct's default block");
                        return false;
                }
            }
        });

        replaceFragmentInFCV(HomeFragment.newInstance(null, null));
    }

    private void replaceFragmentInFCV(Fragment fragmentToBeInserted) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setReorderingAllowed(true);
        ft.replace(R.id.fcv_main, fragmentToBeInserted);
        ft.commit();
    }
}