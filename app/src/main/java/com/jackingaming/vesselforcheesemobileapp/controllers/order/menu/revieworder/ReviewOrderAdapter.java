package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.revieworder;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.MenuItem;
import com.jackingaming.vesselforcheesemobileapp.views.CircularBorderedImageView;

import java.util.List;

public class ReviewOrderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = ReviewOrderAdapter.class.getSimpleName();

    public interface ReviewOrderAdapterListener {
        void onItemClicked();

        void onItemLongClicked();
    }

    private List<MenuItem> order;
    private ReviewOrderAdapterListener listener;

    public ReviewOrderAdapter(List<MenuItem> order, ReviewOrderAdapterListener listener) {
        this.order = order;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_menu_item_for_revieworder, parent, false);
        return new MenuItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MenuItem menuItem = order.get(position);
        ((MenuItemViewHolder) holder).bind(menuItem);
    }

    @Override
    public int getItemCount() {
        return order.size();
    }

    class MenuItemViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {

        private CircularBorderedImageView ivThumbnail;
        private TextView tvName;
        private RecyclerView rvCustomizations;
        private ImageView ivAdd;
        private ImageView ivMinus;

        public MenuItemViewHolder(@NonNull View itemView) {
            super(itemView);

            ivThumbnail = itemView.findViewById(R.id.iv_thumbnail);
            tvName = itemView.findViewById(R.id.tv_name);
            rvCustomizations = itemView.findViewById(R.id.rv_menu_item_customizations);
            ivAdd = itemView.findViewById(R.id.iv_add);
            ivMinus = itemView.findViewById(R.id.iv_minus);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void bind(MenuItem menuItem) {
            // TODO: ivThumbnail

            tvName.setText(menuItem.getName());

            // TODO: rvCustomizations

            ivAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i(TAG, "add clicked");
                }
            });

            ivMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i(TAG, "minus clicked");
                }
            });
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition(); // gets item position
            Log.i(TAG, "item in RV clicked! position: " + position);
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                if (listener != null) {
                    listener.onItemClicked();
                }
            }
        }

        @Override
        public boolean onLongClick(View view) {
            int position = getAdapterPosition(); // gets item position
            Log.i(TAG, "item in RV long-clicked! position: " + position);
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                if (listener != null) {
                    listener.onItemLongClicked();
                    return true;
                }
            }
            return false;
        }
    }
}
