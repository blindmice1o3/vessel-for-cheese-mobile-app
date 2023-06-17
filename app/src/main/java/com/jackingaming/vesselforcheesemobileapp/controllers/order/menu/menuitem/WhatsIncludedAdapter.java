package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;

import java.util.List;

public class WhatsIncludedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = WhatsIncludedAdapter.class.getSimpleName();

    private static final int VIEW_TYPE_INCREMENTABLE = 0;
    private static final int VIEW_TYPE_SINGLE_SELECTION = 1;

    public interface WhatsIncludedAdapterListener {
        void onItemClicked(String[] names, String nameDefault);

        void onItemLongClicked(String[] names, String nameDefault);
    }

    private List<DrinkComponent> drinkComponents;
    private String[] drinkComponentsDefaultValuesAsStringArray;
    private WhatsIncludedAdapterListener listener;

    private int indexSelected = -1;
    private DrinkComponentViewHolder viewHolderSelected;

    public WhatsIncludedAdapter(List<DrinkComponent> drinkComponents,
                                String[] drinkComponentsDefaultValuesAsStringArray,
                                WhatsIncludedAdapterListener listener) {
        this.drinkComponents = drinkComponents;
        this.drinkComponentsDefaultValuesAsStringArray = drinkComponentsDefaultValuesAsStringArray;
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        Log.i(TAG, "getItemViewType()");

        DrinkComponent drinkComponent = drinkComponents.get(position);
        if (drinkComponent instanceof Incrementable) {
            return VIEW_TYPE_INCREMENTABLE;
        } else {
            return VIEW_TYPE_SINGLE_SELECTION;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder()");

        if (viewType == VIEW_TYPE_INCREMENTABLE) {
            View viewIncrementableDrinkComponent = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_drink_component_incrementable, parent, false);
            return new DrinkComponentIncrementableViewHolder(viewIncrementableDrinkComponent);
        } else {
            View viewDrinkComponent = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_drink_component, parent, false);
            return new DrinkComponentViewHolder(viewDrinkComponent);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder()");

        DrinkComponent drinkComponent = drinkComponents.get(position);
        if (holder instanceof DrinkComponentIncrementableViewHolder) {
            ((DrinkComponentIncrementableViewHolder) holder).bind(drinkComponent);
        } else if (holder instanceof DrinkComponentViewHolder) {
            ((DrinkComponentViewHolder) holder).bind(drinkComponent);
        } else {
            Log.e(TAG, "else-clause identifying specific type of ViewHolder");
        }
    }

    @Override
    public int getItemCount() {
        Log.i(TAG, "getItemCount()");
        return drinkComponents.size();
    }

    public void updateDrinkComponentByString(String name) {
        Log.i(TAG, "updateDrinkComponentByString(String)");

        if (indexSelected > -1) {
            // Update the underlying model.
            DrinkComponent drinkComponentSelected = drinkComponents.get(indexSelected);
            drinkComponentSelected.setTypeByString(name);

            // Check criteria for changing border color.
            String drinkComponentSelectedDefaultValueAsString = drinkComponentsDefaultValuesAsStringArray[indexSelected];
            boolean defaultValueSelected = false;
            if (drinkComponentSelected.getTypeAsString().equals(drinkComponentSelectedDefaultValueAsString)) {
                defaultValueSelected = true;
            }

            // Update the screen.
            viewHolderSelected.updateScreenAfterSelection(name, defaultValueSelected);

            // Tear-down steps.
            indexSelected = -1;
            viewHolderSelected = null;
        } else {
            Log.e(TAG, "position <= -1");
        }
    }

    class DrinkComponentViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {

        private View viewBorder;
        private TextView tvBorderTitle;
        private TextView tvName;
        private ImageView ivDropDownImage;

        public DrinkComponentViewHolder(@NonNull View itemView) {
            super(itemView);
            viewBorder = itemView.findViewById(R.id.view_border);
            tvBorderTitle = itemView.findViewById(R.id.tv_border_title);
            tvName = itemView.findViewById(R.id.tv_name);
            ivDropDownImage = itemView.findViewById(R.id.iv_drop_down_image);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void updateScreenAfterSelection(String name, boolean defaultValueSelected) {
            tvName.setText(name);

            if (defaultValueSelected) {
                // The selected value is the same as the default value for this drink's type.
                String colorDefault = "#1B455F";
                viewBorder.setBackgroundResource(R.drawable.border_drink_component_default);
                tvBorderTitle.setTextColor(Color.parseColor(colorDefault));
            } else {
                // The selected value is NOT the same as the default value for this drink's type.
                String colorCustomized = "#AAFF00";
                viewBorder.setBackgroundResource(R.drawable.border_drink_component_customized);
                tvBorderTitle.setTextColor(Color.parseColor(colorCustomized));
            }
        }

        public void bind(DrinkComponent drinkComponent) {
            tvBorderTitle.setText(drinkComponent.getClassAsString());
            tvName.setText(drinkComponent.getTypeAsString());

            ivDropDownImage.setImageResource(R.drawable.ic_menu_arrow_down);
        }

        @Override
        public void onClick(View view) {
            indexSelected = getAdapterPosition(); // gets item position
            viewHolderSelected = DrinkComponentViewHolder.this;
            Log.i(TAG, "item in RV clicked! position: " + indexSelected);
            if (indexSelected != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                if (listener != null) {
                    String[] names = drinkComponents.get(indexSelected).getEnumValuesAsStringArray();
                    String nameDefault = drinkComponentsDefaultValuesAsStringArray[indexSelected];
                    listener.onItemClicked(names, nameDefault);
                }
            }
        }

        @Override
        public boolean onLongClick(View view) {
            int position = getAdapterPosition(); // gets item position
            Log.i(TAG, "item in RV long-clicked! position: " + position);
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                if (listener != null) {
                    DrinkComponent drinkComponent = drinkComponents.get(position);
                    String[] enumsAsString = drinkComponent.getEnumValuesAsStringArray();
                    String nameDefault = drinkComponentsDefaultValuesAsStringArray[position];
                    listener.onItemLongClicked(enumsAsString, nameDefault);
                    return true;
                }
            }
            return false;
        }
    }

    class DrinkComponentIncrementableViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {

        private View viewBorder;
        private TextView tvBorderTitle;
        private TextView tvName;
        private ImageView ivAdd;
        private TextView tvQuantity;
        private ImageView ivMinus;

        public DrinkComponentIncrementableViewHolder(@NonNull View itemView) {
            super(itemView);
            viewBorder = itemView.findViewById(R.id.view_border);
            tvBorderTitle = itemView.findViewById(R.id.tv_border_title);
            tvName = itemView.findViewById(R.id.tv_name);
            ivMinus = itemView.findViewById(R.id.iv_minus);
            tvQuantity = itemView.findViewById(R.id.tv_quantity);
            ivAdd = itemView.findViewById(R.id.iv_add);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void bind(DrinkComponent drinkComponent) {
            tvBorderTitle.setText(drinkComponent.getClassAsString());
            tvName.setText(drinkComponent.getTypeAsString());

            Incrementable incrementable = (Incrementable) drinkComponent;

            ivMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    incrementable.onDecrement();

                    tvName.setText(drinkComponent.getTypeAsString());
                    tvQuantity.setText(Integer.toString(incrementable.getQuantity()));

                    String quantityAsString = Integer.toString(incrementable.getQuantity());
                    String nameTypeDefault = drinkComponentsDefaultValuesAsStringArray[getAdapterPosition()];
                    if (quantityAsString.equals(nameTypeDefault)) {
                        // The selected value is the same as the default value for this drink's type.
                        String colorDefault = "#1B455F";
                        viewBorder.setBackgroundResource(R.drawable.border_drink_component_default);
                        tvBorderTitle.setTextColor(Color.parseColor(colorDefault));
                    } else {
                        // The selected value is NOT the same as the default value for this drink's type.
                        String colorCustomized = "#AAFF00";
                        viewBorder.setBackgroundResource(R.drawable.border_drink_component_customized);
                        tvBorderTitle.setTextColor(Color.parseColor(colorCustomized));
                    }
                }
            });
            tvQuantity.setText(Integer.toString(incrementable.getQuantity()));
            ivAdd.setImageResource(R.drawable.ic_menu_add);
            ivAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    incrementable.onIncrement();

                    tvName.setText(drinkComponent.getTypeAsString());
                    tvQuantity.setText(Integer.toString(incrementable.getQuantity()));

                    String quantityAsString = Integer.toString(incrementable.getQuantity());
                    String nameTypeDefault = drinkComponentsDefaultValuesAsStringArray[getAdapterPosition()];
                    if (quantityAsString.equals(nameTypeDefault)) {
                        // The selected value is the same as the default value for this drink's type.
                        String colorDefault = "#1B455F";
                        viewBorder.setBackgroundResource(R.drawable.border_drink_component_default);
                        tvBorderTitle.setTextColor(Color.parseColor(colorDefault));
                    } else {
                        // The selected value is NOT the same as the default value for this drink's type.
                        String colorCustomized = "#AAFF00";
                        viewBorder.setBackgroundResource(R.drawable.border_drink_component_customized);
                        tvBorderTitle.setTextColor(Color.parseColor(colorCustomized));
                    }
                }
            });
        }

        @Override
        public void onClick(View view) {
//            int position = getAdapterPosition(); // gets item position
//            Log.i(TAG, "item in RV clicked! position: " + position);
//            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
//                if (listener != null) {
//                    listener.onItemClicked(enumsAsString, view.findViewById(R.id.tv_name));
//                    Log.i(TAG, "intentionally doing nothing");
//                }
//            }
        }

        @Override
        public boolean onLongClick(View view) {
//            int position = getAdapterPosition(); // gets item position
//            Log.i(TAG, "item in RV long-clicked! position: " + position);
//            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
//                if (listener != null) {
//                    listener.onItemLongClicked(enumsAsString, view.findViewById(R.id.tv_name));
//                    Log.i(TAG, "intentionally doing nothing");
//                    return true;
//                }
//            }
            return false;
        }
    }
}
