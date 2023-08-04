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
import com.jackingaming.vesselforcheesemobileapp.models.menu.Menu;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.MenuItem;

import java.util.List;
import java.util.Map;

public class SubCategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = SubCategoryAdapter.class.getSimpleName();

    public interface SubCategoryAdapterListener {
        void onItemClicked(int position, View view);

        void onItemLongClicked(int position, View view);
    }

    private String title;
    private Map<String, List<MenuItem>> categorySelected;
    private SubCategoryAdapterListener listener;

    public SubCategoryAdapter(String title, Map<String, List<MenuItem>> categorySelected, SubCategoryAdapterListener listener) {
        this.title = title;
        this.categorySelected = categorySelected;
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
        Log.i(TAG, "position == " + position);

        String nameSubCategory = null;
        if (title.equals(Menu.HOT_COFFEES)) {
            Log.i(TAG, "title.equals(Menu.HOT_COFFEES)");

            if (position == 0) {
                nameSubCategory = Menu.AMERICANOS;
            } else if (position == 1) {
                nameSubCategory = Menu.BREWED_COFFEES;
            } else if (position == 2) {
                nameSubCategory = Menu.CAPPUCCINOS;
            } else if (position == 3) {
                nameSubCategory = Menu.ESPRESSO_SHOTS;
            } else if (position == 4) {
                nameSubCategory = Menu.FLAT_WHITES;
            } else if (position == 5) {
                nameSubCategory = Menu.LATTES;
            } else if (position == 6) {
                nameSubCategory = Menu.MACCHIATOS;
            } else if (position == 7) {
                nameSubCategory = Menu.MOCHAS;
            } else if (position == 8) {
                nameSubCategory = Menu.COFFEE_TRAVELERS;
            } else {
                Log.e(TAG, "else-clause");
            }
        } else if (title.equals(Menu.COLD_COFFEES)) {
            Log.i(TAG, "title.equals(Menu.COLD_COFFEES)");

            if (position == 0) {
                nameSubCategory = Menu.COLD_BREWS;
            } else if (position == 1) {
                nameSubCategory = Menu.NITRO_COLD_BREWS;
            } else if (position == 2) {
                nameSubCategory = Menu.ICED_AMERICANO;
            } else if (position == 3) {
                nameSubCategory = Menu.ICED_COFFEES;
            } else if (position == 4) {
                nameSubCategory = Menu.ICED_SHAKEN_ESPRESSO;
            } else if (position == 5) {
                nameSubCategory = Menu.ICED_FLAT_WHITES;
            } else if (position == 6) {
                nameSubCategory = Menu.ICED_LATTES;
            } else if (position == 7) {
                nameSubCategory = Menu.ICED_MACCHIATOS;
            } else if (position == 8) {
                nameSubCategory = Menu.ICED_MOCHAS;
            } else {
                Log.e(TAG, "else-clause");
            }
        } else {
            Log.e(TAG, "title NOT equals() Menu.HOT_COFFEES nor Menu.COLD_COFFEES");
        }

        List<MenuItem> menuItems = categorySelected.get(nameSubCategory);
        SubCategoryViewHolder subCategoryViewHolder = (SubCategoryViewHolder) holder;
        subCategoryViewHolder.bind(nameSubCategory, menuItems);
    }

    @Override
    public int getItemCount() {
        Log.i(TAG, "onItemCount() size: " + categorySelected.keySet().size());
        return categorySelected.keySet().size();
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

        public void bind(String nameSubCategory, List<MenuItem> menuItems) {
            tvName.setText(nameSubCategory);
            tvSize.setText("See all " + menuItems.size());

            MenuItemAdapter adapter = new MenuItemAdapter(menuItems, new MenuItemAdapter.MenuItemAdapterListener() {
                @Override
                public void onItemClicked(int position, View view) {
                    Toast.makeText(view.getContext(), "onItemClicked() position: " + position, Toast.LENGTH_SHORT).show();
                    // TODO: start MenuItemActivity
                    Intent intent = new Intent(view.getContext(), MenuItemActivity.class);
                    intent.putExtra(MenuItemActivity.EXTRA_NAME_CATEGORY, title);
                    intent.putExtra(MenuItemActivity.EXTRA_NAME_SUB_CATEGORY, nameSubCategory);
                    intent.putExtra(MenuItemActivity.EXTRA_POSITION, position);
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
