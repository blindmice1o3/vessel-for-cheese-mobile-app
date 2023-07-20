package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.revieworder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jackingaming.vesselforcheesemobileapp.R;

import java.util.List;

public class DrinkComponentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = DrinkComponentAdapter.class.getSimpleName();

    List<String> drinkComponentsCustomAsString;

    public DrinkComponentAdapter(List<String> drinkComponentsCustomAsString) {
        this.drinkComponentsCustomAsString = drinkComponentsCustomAsString;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_drink_component_adapter, parent, false);
        return new DrinkComponentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        String drinkComponentAsString = drinkComponentsCustomAsString.get(position);
        ((DrinkComponentViewHolder) holder).bind(drinkComponentAsString);
    }

    @Override
    public int getItemCount() {
        return drinkComponentsCustomAsString.size();
    }

    class DrinkComponentViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;

        public DrinkComponentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
        }

        public void bind(String drinkComponentAsString) {
            tvName.setText(drinkComponentAsString);
        }
    }
}
