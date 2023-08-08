package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.subcategory;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.MenuItemActivity;
import com.jackingaming.vesselforcheesemobileapp.models.menu.category.SubCategory;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.MenuItem;

import java.util.List;

public class SubCategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = SubCategoryAdapter.class.getSimpleName();

    public interface SubCategoryAdapterListener {
        void onItemClicked(int position, View view);

        void onItemLongClicked(int position, View view);
    }

    private String title;
    private List<SubCategory> subCategories;
    private SubCategoryAdapterListener listener;

    public SubCategoryAdapter(String title, List<SubCategory> subCategories, SubCategoryAdapterListener listener) {
        this.title = title;
        this.subCategories = subCategories;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_sub_category, parent, false);
        RecyclerView.ViewHolder viewHolder = new SubCategoryViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder");
        SubCategory subCategorySelected = subCategories.get(position);
        SubCategoryViewHolder subCategoryViewHolder = (SubCategoryViewHolder) holder;
        subCategoryViewHolder.bind(subCategorySelected);
    }

    @Override
    public int getItemCount() {
        Log.i(TAG, "onItemCount() subCategories.size(): " + subCategories.size());
        return subCategories.size();
    }

    class SubCategoryViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {
        private TextView tvName;
        private TextView tvSize;
        private RecyclerView rvSubCategory;

        public SubCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvSize = itemView.findViewById(R.id.tv_size);
            rvSubCategory = itemView.findViewById(R.id.rv_sub_category);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void bind(SubCategory subCategorySelected) {
            List<MenuItem> menuItems = subCategorySelected.getMenuItems();

            tvName.setText(subCategorySelected.getName());
            tvSize.setText("See all " + menuItems.size());

            MenuItemAdapter adapter = new MenuItemAdapter(menuItems, new MenuItemAdapter.MenuItemAdapterListener() {
                @Override
                public void onItemClicked(int position, View view) {
                    Toast.makeText(view.getContext(), "onItemClicked() position: " + position, Toast.LENGTH_SHORT).show();

                    MenuItem menuItemSelected = menuItems.get(position);
                    Intent intent = new Intent(view.getContext(), MenuItemActivity.class);
                    intent.putExtra(MenuItemActivity.EXTRA_MENU_ITEM_SELECTED, menuItemSelected);
                    rvSubCategory.getContext().startActivity(intent);
                }

                @Override
                public void onItemLongClicked(int position, View view) {
                    Toast.makeText(view.getContext(), "onItemLongClicked() position: " + position, Toast.LENGTH_SHORT).show();
                    // TODO:
                }
            });

            rvSubCategory.setAdapter(adapter);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rvSubCategory.getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            rvSubCategory.setLayoutManager(linearLayoutManager);
            rvSubCategory.setNestedScrollingEnabled(false);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition(); // gets item position
            Log.i(TAG, "item in RV clicked! position: " + position);
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                if (listener != null) {
                    listener.onItemClicked(position, view);
                }
            }
        }

        @Override
        public boolean onLongClick(View view) {
            int position = getAdapterPosition(); // gets item position
            Log.i(TAG, "item in RV long-clicked! position: " + position);
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                if (listener != null) {
                    listener.onItemLongClicked(position, view);
                    return true;
                }
            }
            return false;
        }
    }
}
