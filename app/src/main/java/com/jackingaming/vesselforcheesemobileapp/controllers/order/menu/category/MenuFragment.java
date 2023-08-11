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
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.parentcategory.ParentCategoryActivity;
import com.jackingaming.vesselforcheesemobileapp.models.menu.Menu;
import com.jackingaming.vesselforcheesemobileapp.models.menu.category.Category;
import com.jackingaming.vesselforcheesemobileapp.models.menu.category.ParentCategory;
import com.jackingaming.vesselforcheesemobileapp.models.menu.category.TitleCategory;

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
            public void onParentCategoryClicked(View view, ParentCategory parentCategorySelected) {
                Log.i(TAG, "onParentCategoryClicked(View, ParentCategory) parentCategorySelected: " + parentCategorySelected.getName());

                Intent intent = new Intent(getContext(), ParentCategoryActivity.class);
                intent.putExtra(ParentCategoryActivity.EXTRA_PARENT_CATEGORY_SELECTED, parentCategorySelected);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }

            @Override
            public void onParentCategoryLongClicked(View view, ParentCategory parentCategorySelected) {
                Log.i(TAG, "onParentCategoryLongClicked(View, ParentCategory) parentCategorySelected: " + parentCategorySelected.getName());

                // TODO:
            }

            @Override
            public void onTitleCategoryClicked(View view, TitleCategory titleCategorySelected) {
                Log.i(TAG, "onTitleCategoryClicked(View, TitleCategory) titleCategorySelected: " + titleCategorySelected.getName());

                // TODO:
            }

            @Override
            public void onTitleCategoryLongClicked(View view, TitleCategory titleCategorySelected) {
                Log.i(TAG, "onTitleCategoryLongClicked(View, TitleCategory) titleCategorySelected: " + titleCategorySelected.getName());

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