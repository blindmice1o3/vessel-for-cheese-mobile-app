package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.hierarchy.topic;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.MenuItem;

import java.util.List;

public class MenuItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = MenuItemAdapter.class.getSimpleName();

    public interface MenuItemAdapterListener {
        void onItemClicked(View view, MenuItem menuItemSelected);

        void onItemLongClicked(View view, MenuItem menuItemSelected);
    }

    private List<MenuItem> menuItems;
    private MenuItemAdapterListener listener;

    public MenuItemAdapter(List<MenuItem> menuItems, MenuItemAdapterListener listener) {
        this.menuItems = menuItems;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_menu_item_for_childcategory, parent, false);
        RecyclerView.ViewHolder viewHolderMenuItem = new ViewHolderMenuItem(view);
        return viewHolderMenuItem;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MenuItem menuItem = menuItems.get(position);
        ViewHolderMenuItem viewHolderMenuItem = (ViewHolderMenuItem) holder;
        viewHolderMenuItem.bind(menuItem);
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    class ViewHolderMenuItem extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {
        private ImageView ivThumbnail;
        private TextView tvName;

        public ViewHolderMenuItem(@NonNull View itemView) {
            super(itemView);
            ivThumbnail = itemView.findViewById(R.id.iv_thumbnail);
            tvName = itemView.findViewById(R.id.tv_name);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void bind(MenuItem menuItem) {
            ivThumbnail.setImageResource(menuItem.getImageResourceId());
            tvName.setText(menuItem.getName());
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition(); // gets item position
            Log.i(TAG, "item in RV clicked! position: " + position);
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                if (listener != null) {
                    MenuItem menuItemSelected = menuItems.get(position);
                    listener.onItemClicked(view, menuItemSelected);
                }
            }
        }

        @Override
        public boolean onLongClick(View view) {
            int position = getAdapterPosition(); // gets item position
            Log.i(TAG, "item in RV long-clicked! position: " + position);
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                if (listener != null) {
                    MenuItem menuItemSelected = menuItems.get(position);
                    listener.onItemLongClicked(view, menuItemSelected);
                    return true;
                }
            }
            return false;
        }
    }
}
