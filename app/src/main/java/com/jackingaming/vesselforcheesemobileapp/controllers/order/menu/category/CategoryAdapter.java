package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.category;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.menu.categories.Category;
import com.jackingaming.vesselforcheesemobileapp.models.menu.categories.MenuItemCategory;
import com.jackingaming.vesselforcheesemobileapp.models.menu.categories.TitleCategory;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = CategoryAdapter.class.getSimpleName();

    private static final int VIEW_TYPE_TITLE = 0;
    private static final int VIEW_TYPE_CATEGORY = 1;

    public interface CategoryAdapterListener {
        void onItemClicked(int position, View view);

        void onItemLongClicked(int position, View view);
    }

    private List<Category> categories;
    private CategoryAdapterListener listener;

    public CategoryAdapter(List<Category> categories, CategoryAdapterListener listener) {
        this.categories = categories;
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        Category category = categories.get(position);

        if (category instanceof TitleCategory) {
            return VIEW_TYPE_TITLE;
        } else if (category instanceof MenuItemCategory) {
            return VIEW_TYPE_CATEGORY;
        } else {
            return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder viewHolder;

        switch (viewType) {
            case VIEW_TYPE_TITLE:
                View viewTitle = inflater.inflate(R.layout.list_item_title, parent, false);
                viewHolder = new ViewHolderTitle(viewTitle);
                break;
            case VIEW_TYPE_CATEGORY:
                View viewCategory = inflater.inflate(R.layout.list_item_category, parent, false);
                viewHolder = new ViewHolderCategory(viewCategory);
                break;
            default:
                View viewDefault = inflater.inflate(R.layout.list_item_title, parent, false);
                viewHolder = new ViewHolderTitle(viewDefault);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case VIEW_TYPE_TITLE:
                ViewHolderTitle viewHolderTitle = (ViewHolderTitle) holder;
                TitleCategory titleCategory = (TitleCategory) categories.get(position);
                viewHolderTitle.bind(titleCategory);
                break;
            case VIEW_TYPE_CATEGORY:
                ViewHolderCategory viewHolderCategory = (ViewHolderCategory) holder;
                MenuItemCategory menuItemCategory = (MenuItemCategory) categories.get(position);
                viewHolderCategory.bind(menuItemCategory);
                break;
            default:
                ViewHolderTitle viewHolderDefault = (ViewHolderTitle) holder;
                TitleCategory defaultCategory = (TitleCategory) categories.get(position);
                viewHolderDefault.bind(defaultCategory);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    class ViewHolderCategory extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {
        private ImageView ivThumbnail;
        private TextView tvName;

        public ViewHolderCategory(@NonNull View itemView) {
            super(itemView);
            ivThumbnail = itemView.findViewById(R.id.iv_thumbnail);
            tvName = itemView.findViewById(R.id.tv_name);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void bind(MenuItemCategory menuItemCategory) {
            ivThumbnail.setImageResource(menuItemCategory.getIdImage());
            tvName.setText(menuItemCategory.getName());
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

    class ViewHolderTitle extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {
        private TextView tvName;
        private TextView tvSize;

        public ViewHolderTitle(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvSize = itemView.findViewById(R.id.tv_size);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void bind(TitleCategory titleCategory) {
            tvName.setText(titleCategory.getName());
            tvSize.setText(
                    String.format("See all %d", titleCategory.getSizeCategory())
            );
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
