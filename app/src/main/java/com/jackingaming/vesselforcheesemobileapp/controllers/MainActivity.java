package com.jackingaming.vesselforcheesemobileapp.controllers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bnvMain = (BottomNavigationView) findViewById(R.id.bnv_main);
        bnvMain.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        replaceFragmentInFCV(HomeFragment.newInstance(null, null));
                        return true;
                    case R.id.action_scan:
                        replaceFragmentInFCV(ScanFragment.newInstance(null, null));
                        return true;
                    case R.id.action_order:
                        replaceFragmentInFCV(OrderFragment.newInstance(null, null));
                        return true;
                    case R.id.action_gift:
                        replaceFragmentInFCV(GiftFragment.newInstance(null, null));
                        return true;
                    case R.id.action_stores:
                        replaceFragmentInFCV(StoresFragment.newInstance(null, null));
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