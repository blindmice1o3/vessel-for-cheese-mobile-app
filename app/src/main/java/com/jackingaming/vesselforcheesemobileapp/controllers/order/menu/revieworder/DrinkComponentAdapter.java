package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.revieworder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.Granular;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.Incrementable;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;

import java.util.List;

public class DrinkComponentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = DrinkComponentAdapter.class.getSimpleName();

    List<DrinkComponent> drinkComponentsAsList;

    public DrinkComponentAdapter(List<DrinkComponent> drinkComponentsAsList) {
        this.drinkComponentsAsList = drinkComponentsAsList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_drink_component_adapter, parent, false);
        return new DrinkComponentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        DrinkComponent drinkComponent = drinkComponentsAsList.get(position);
        ((DrinkComponentViewHolder) holder).bind(drinkComponent);
    }

    @Override
    public int getItemCount() {
        return drinkComponentsAsList.size();
    }

    class DrinkComponentViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;

        public DrinkComponentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
        }

        public void bind(DrinkComponent drinkComponent) {
            String drinkComponentDetails = null;
            if (drinkComponent instanceof Incrementable) {
                drinkComponentDetails = drinkComponent.getClassAsString() + " | " + drinkComponent.getTypeAsString() +
                        " | " + ((Incrementable) drinkComponent).getQuantity();
            } else if (drinkComponent instanceof Granular) {
                drinkComponentDetails = drinkComponent.getClassAsString() + " | " + drinkComponent.getTypeAsString() +
                        " | " + ((Granular) drinkComponent).getAmount();
            } else {
                drinkComponentDetails = drinkComponent.getClassAsString() + " | " + drinkComponent.getTypeAsString();
            }

            tvName.setText(drinkComponentDetails);
        }
    }
}
