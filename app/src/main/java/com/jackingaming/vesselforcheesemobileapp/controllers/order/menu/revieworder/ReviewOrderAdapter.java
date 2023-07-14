package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.revieworder;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.Granular;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.Incrementable;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.menu.Menu;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.MenuItem;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.Drink;
import com.jackingaming.vesselforcheesemobileapp.views.CircularBorderedImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

            // TODO: pass filtered list to DrinkComponentAdapter
            List<DrinkComponent> drinkComponentsAsList = new ArrayList<>();
            if (menuItem instanceof Drink) {
                Map<String, List<DrinkComponent>> drinkComponents = ((Drink) menuItem).getDrinkComponents();
                Map<String, List<String>> drinkComponentsDefaultAsString = ((Drink) menuItem).getDrinkComponentsDefaultAsString();
                for (String key : Menu.DRINK_COMPONENTS_KEYS) {
                    if (drinkComponents.containsKey(key)) {
                        List<DrinkComponent> drinkComponentsGroup = drinkComponents.get(key);
                        List<String> drinkComponentsDefaultAsStringGroup = drinkComponentsDefaultAsString.get(key);
                        for (int i = 0; i < drinkComponentsGroup.size(); i++) {
                            DrinkComponent drinkComponent = drinkComponentsGroup.get(i);
                            String drinkComponentDefaultAsString = drinkComponentsDefaultAsStringGroup.get(i);

                            if (drinkComponent.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING)) {
                                continue;
                            }

                            if (drinkComponent instanceof Incrementable) {
                                String quantityAsString = Integer.toString(((Incrementable) drinkComponent).getQuantity());
                                if (quantityAsString.equals(drinkComponentDefaultAsString)) {
                                    continue;
                                }
                            } else if (drinkComponent instanceof Granular) {
                                String amountAsString = ((Granular) drinkComponent).getAmount().name();
                                if (amountAsString.equals(drinkComponentDefaultAsString)) {
                                    continue;
                                }
                            } else {
                                String typeAsString = drinkComponent.getTypeAsString();
                                if (typeAsString.equals(drinkComponentDefaultAsString)) {
                                    continue;
                                }
                            }

                            drinkComponentsAsList.add(drinkComponent);
                        }
                    }
                }
            } else {
                Log.e(TAG, "NOT menuItem instanceof Drink");
            }
            rvCustomizations.setAdapter(new DrinkComponentAdapter(drinkComponentsAsList));
            rvCustomizations.setLayoutManager(new LinearLayoutManager(rvCustomizations.getContext()));

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
