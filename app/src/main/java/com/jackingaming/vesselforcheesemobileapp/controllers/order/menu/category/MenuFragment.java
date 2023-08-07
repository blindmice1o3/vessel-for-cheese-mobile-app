package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.category;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.subcategory.MenuItemCategoryActivity;
import com.jackingaming.vesselforcheesemobileapp.models.menu.Menu;
import com.jackingaming.vesselforcheesemobileapp.models.menu.category.Category;
import com.jackingaming.vesselforcheesemobileapp.models.menu.category.MenuItemCategory;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuFragment extends Fragment {
    public static final String TAG = MenuFragment.class.getSimpleName();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // SUBCLASSES: (1) TitleCategory, (2) MenuItemCategory
    private List<Category> categories = Menu.categories;
    private CategoryAdapter adapter;

    public MenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new CategoryAdapter(categories, new CategoryAdapter.CategoryAdapterListener() {
            @Override
            public void onMenuItemCategoryClicked(View view, String nameOfCategorySelected) {
                Log.i(TAG, "onMenuItemCategoryClicked(View, String) nameOfCategorySelected: " + nameOfCategorySelected);

                int numberOfMenuItemsViaMap = 0;
                if (nameOfCategorySelected.equals(Menu.HOT_COFFEES)) {
                    Log.i(TAG, "nameOfCategorySelected.equals(Menu.HOT_COFFEES)");

                    for (MenuItemCategory menuItemCategory : Menu.hotCoffees) {
                        String keyHotCoffees = menuItemCategory.getName();
                        numberOfMenuItemsViaMap += Menu.hotCoffeesAsMap.get(keyHotCoffees).size();
                    }
                } else if (nameOfCategorySelected.equals(Menu.COLD_COFFEES)) {
                    Log.i(TAG, "nameOfCategorySelected.equals(Menu.COLD_COFFEES)");

                    for (MenuItemCategory menuItemCategory : Menu.coldCoffees) {
                        String keyColdCoffees = menuItemCategory.getName();
                        numberOfMenuItemsViaMap += Menu.coldCoffeesAsMap.get(keyColdCoffees).size();
                    }
                } else {
                    Log.e(TAG, "nameOfCategorySelected NOT equals() Menu.HOT_COFFEES nor Menu.COLD_COFFEES");
                }
                Log.i(TAG, "numberOfMenuItemsViaMap: " + numberOfMenuItemsViaMap);

                Intent intent = new Intent(getContext(), MenuItemCategoryActivity.class);
                intent.putExtra(MenuItemCategoryActivity.EXTRA_TITLE, nameOfCategorySelected);
                intent.putExtra(MenuItemCategoryActivity.EXTRA_SIZE, numberOfMenuItemsViaMap);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }

            @Override
            public void onMenuItemCategoryLongClicked(View view, String nameOfCategorySelected) {
                Log.i(TAG, "onMenuItemCategoryLongClicked(View, String) nameOfCategorySelected: " + nameOfCategorySelected);

                // TODO:
            }

            @Override
            public void onTitleCategoryClicked(View view, String nameOfCategorySelected) {
                Log.i(TAG, "onTitleCategoryClicked(View, String) nameOfCategorySelected: " + nameOfCategorySelected);

                // TODO:
            }

            @Override
            public void onTitleCategoryLongClicked(View view, String nameOfCategorySelected) {
                Log.i(TAG, "onTitleCategoryLongClicked(View, String) nameOfCategorySelected: " + nameOfCategorySelected);

                // TODO:
            }
        });

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
    }
}