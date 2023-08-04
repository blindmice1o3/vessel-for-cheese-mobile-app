package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.category;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.subcategory.MenuItemCategoryActivity;
import com.jackingaming.vesselforcheesemobileapp.models.menu.Menu;

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
        adapter = new CategoryAdapter(Menu.categories, new CategoryAdapter.CategoryAdapterListener() {
            @Override
            public void onItemClicked(int position, View view) {
                // TODO: HOT_COFFEES, COLD_COFFEES, ...
                String nameOfCategory = Menu.categories.get(position).getName();
                if (nameOfCategory.equals(Menu.HOT_COFFEES)) {
                    int numberOfMenuItems = Menu.americanos.size() +
                            Menu.brewedCoffees.size() +
                            Menu.cappuccinos.size() +
                            Menu.espressoShots.size() +
                            Menu.flatWhites.size() +
                            Menu.lattes.size() +
                            Menu.macchiatos.size() +
                            Menu.mochas.size() +
                            Menu.coffeeTravelers.size();

                    Intent intent = new Intent(getContext(), MenuItemCategoryActivity.class);
                    intent.putExtra(MenuItemCategoryActivity.EXTRA_TITLE, Menu.HOT_COFFEES);
                    intent.putExtra(MenuItemCategoryActivity.EXTRA_SIZE, numberOfMenuItems);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else if (nameOfCategory.equals(Menu.COLD_COFFEES)) {
                    int numberOfMenuItems = Menu.coldBrews.size() +
                            Menu.nitroColdBrews.size() +
                            Menu.icedAmericano.size() +
                            Menu.icedCoffees.size() +
                            Menu.icedShakenEspresso.size() +
                            Menu.icedFlatWhites.size() +
                            Menu.icedLattes.size() +
                            Menu.icedMacchiatos.size() +
                            Menu.icedMochas.size();

                    Intent intent = new Intent(getContext(), MenuItemCategoryActivity.class);
                    intent.putExtra(MenuItemCategoryActivity.EXTRA_TITLE, Menu.COLD_COFFEES);
                    intent.putExtra(MenuItemCategoryActivity.EXTRA_SIZE, numberOfMenuItems);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    Toast.makeText(getContext(), "onItemClicked() position: " + position, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onItemLongClicked(int position, View view) {
                Toast.makeText(getContext(), "onItemLongClicked() position: " + position, Toast.LENGTH_SHORT).show();
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