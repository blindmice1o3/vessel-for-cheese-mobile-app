package com.jackingaming.vesselforcheesemobileapp.controllers.order;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.favorites.FavoritesFragment;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.featured.FeaturedFragment;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.category.MenuFragment;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.previous.PreviousFragment;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.MenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrderFragment extends Fragment {
    public static final String TAG = OrderFragment.class.getSimpleName();

    private static OrderFragment instance;
    private List<MenuItem> order = new ArrayList<>();

    public void addMenuItemToOrder(MenuItem menuItem) {
        order.add(menuItem);
    }

    private Fragment[] fragments = {
            MenuFragment.newInstance(null, null),
            FeaturedFragment.newInstance(null, null),
            PreviousFragment.newInstance(null, null),
            FavoritesFragment.newInstance(null, null)
    };

    private String[] namesTab = {
            "Menu",
            "Featured",
            "Previous",
            "Favorites"
    };

    public OrderFragment() {
        // Required empty public constructor
    }


    public static OrderFragment getInstance() {
        if (instance == null) {
            instance = new OrderFragment();
        }
        return instance;
    }

    public List<MenuItem> getOrder() {
        return order;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OrderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrderFragment newInstance(String param1, String param2) {
        OrderFragment fragment = new OrderFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_order, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ViewPager2 viewPager2 = (ViewPager2) view.findViewById(R.id.view_pager2);
        viewPager2.setAdapter(new OrderFragmentAdapter(this));

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, viewPager2,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText(namesTab[position]);
                    }
                }
        ).attach();

        viewPager2.setCurrentItem(1, false);
    }

    class OrderFragmentAdapter extends FragmentStateAdapter {
        public OrderFragmentAdapter(@NonNull Fragment fragment) {
            super(fragment);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return fragments[position];
        }

        @Override
        public int getItemCount() {
            return fragments.length;
        }
    }
}
