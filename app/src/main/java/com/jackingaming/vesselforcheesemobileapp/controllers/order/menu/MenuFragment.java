package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.hierarchy.category.CategoryAdapter;
import com.jackingaming.vesselforcheesemobileapp.models.menu.Menu;
import com.jackingaming.vesselforcheesemobileapp.models.menu.hierarchy.Category;

import java.util.List;

public class MenuFragment extends Fragment {
    public static final String TAG = MenuFragment.class.getSimpleName();

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private List<Category> categories = Menu.categories;
    private CategoryAdapter adapter;

    public MenuFragment() {
        // Required empty public constructor
    }

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
            public void onItemClicked(View view, Category categorySelected) {
                Log.i(TAG, "onItemClicked(View, Category) categorySelected: " + categorySelected.getName());
                // TODO:
            }

            @Override
            public void onItemLongClicked(View view, Category categorySelected) {
                Log.i(TAG, "onItemLongClicked(View, Category) categorySelected: " + categorySelected.getName());
                // TODO:
            }
        });

        RecyclerView rvCategory = view.findViewById(R.id.rv_category);
        rvCategory.setAdapter(adapter);
        rvCategory.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}