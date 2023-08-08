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
import com.jackingaming.vesselforcheesemobileapp.models.menu.category.Category;
import com.jackingaming.vesselforcheesemobileapp.models.menu.category.ParentCategory;
import com.jackingaming.vesselforcheesemobileapp.models.menu.category.TitleCategory;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = CategoryAdapter.class.getSimpleName();

    private static final int VIEW_TYPE_NULL = -1;
    private static final int VIEW_TYPE_TITLE_CATEGORY = 0;
    private static final int VIEW_TYPE_PARENT_CATEGORY = 1;

    public interface CategoryAdapterListener {
        void onParentCategoryClicked(View view, ParentCategory parentCategorySelected);

        void onParentCategoryLongClicked(View view, ParentCategory parentCategorySelected);

        void onTitleCategoryClicked(View view, TitleCategory titleCategorySelected);

        void onTitleCategoryLongClicked(View view, TitleCategory titleCategorySelected);
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
            return VIEW_TYPE_TITLE_CATEGORY;
        } else if (category instanceof ParentCategory) {
            return VIEW_TYPE_PARENT_CATEGORY;
        } else {
            return VIEW_TYPE_NULL;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder viewHolder;

        switch (viewType) {
            case VIEW_TYPE_TITLE_CATEGORY:
                View viewTitleCategory = inflater.inflate(R.layout.list_item_title_category, parent, false);
                viewHolder = new ViewHolderTitleCategory(viewTitleCategory);
                break;
            case VIEW_TYPE_PARENT_CATEGORY:
                View viewParentCategory = inflater.inflate(R.layout.list_item_parent_category, parent, false);
                viewHolder = new ViewHolderParentCategory(viewParentCategory);
                break;
            default:
                View viewDefault = inflater.inflate(R.layout.list_item_title_category, parent, false);
                viewHolder = new ViewHolderTitleCategory(viewDefault);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case VIEW_TYPE_TITLE_CATEGORY:
                ViewHolderTitleCategory viewHolderTitleCategory = (ViewHolderTitleCategory) holder;
                TitleCategory titleCategory = (TitleCategory) categories.get(position);
                viewHolderTitleCategory.bind(titleCategory);
                break;
            case VIEW_TYPE_PARENT_CATEGORY:
                ViewHolderParentCategory viewHolderParentCategory = (ViewHolderParentCategory) holder;
                ParentCategory parentCategory = (ParentCategory) categories.get(position);
                viewHolderParentCategory.bind(parentCategory);
                break;
            default:
                ViewHolderTitleCategory viewHolderDefault = (ViewHolderTitleCategory) holder;
                TitleCategory defaultCategory = (TitleCategory) categories.get(position);
                viewHolderDefault.bind(defaultCategory);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    class ViewHolderTitleCategory extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {
        private TextView tvName;
        private TextView tvSize;

        public void bind(TitleCategory titleCategory) {
            tvName.setText(titleCategory.getName());
            tvSize.setText(
                    String.format("See all %d", titleCategory.getNumberOfParentCategory())
            );
        }

        public ViewHolderTitleCategory(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvSize = itemView.findViewById(R.id.tv_size);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition(); // gets item position
            Log.i(TAG, "item in RV clicked! position: " + position);
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                if (listener != null) {
                    TitleCategory titleCategorySelected = (TitleCategory) categories.get(position);
                    listener.onTitleCategoryClicked(view, titleCategorySelected);
                }
            }
        }

        @Override
        public boolean onLongClick(View view) {
            int position = getAdapterPosition(); // gets item position
            Log.i(TAG, "item in RV long-clicked! position: " + position);
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                if (listener != null) {
                    TitleCategory titleCategorySelected = (TitleCategory) categories.get(position);
                    listener.onTitleCategoryLongClicked(view, titleCategorySelected);
                    return true;
                }
            }
            return false;
        }
    }

    class ViewHolderParentCategory extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {
        private ImageView ivThumbnail;
        private TextView tvName;

        public ViewHolderParentCategory(@NonNull View itemView) {
            super(itemView);
            ivThumbnail = itemView.findViewById(R.id.iv_thumbnail);
            tvName = itemView.findViewById(R.id.tv_name);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void bind(ParentCategory parentCategory) {
            ivThumbnail.setImageResource(parentCategory.getIdImage());
            tvName.setText(parentCategory.getName());
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition(); // gets item position
            Log.i(TAG, "item in RV clicked! position: " + position);
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                if (listener != null) {
                    ParentCategory parentCategorySelected = (ParentCategory) categories.get(position);
                    listener.onParentCategoryClicked(view, parentCategorySelected);
                }
            }
        }

        @Override
        public boolean onLongClick(View view) {
            int position = getAdapterPosition(); // gets item position
            Log.i(TAG, "item in RV long-clicked! position: " + position);
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                if (listener != null) {
                    ParentCategory parentCategorySelected = (ParentCategory) categories.get(position);
                    listener.onParentCategoryLongClicked(view, parentCategorySelected);
                    return true;
                }
            }
            return false;
        }
    }
}
