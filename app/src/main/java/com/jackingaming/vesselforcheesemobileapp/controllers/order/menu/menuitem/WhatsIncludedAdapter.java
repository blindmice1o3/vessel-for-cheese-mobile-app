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
    private List<String> drinkComponentsDefaultAsString;
    private List<DrinkComponent> drinkComponentsStandardRecipe;
    private WhatsIncludedAdapterListener listener;

    private int indexSelected = -1;
    private DrinkComponentViewHolder viewHolderSelected;

    public WhatsIncludedAdapter(List<DrinkComponent> drinkComponents,
                                List<String> drinkComponentsDefaultAsString,
                                List<DrinkComponent> drinkComponentsStandardRecipe,
                                WhatsIncludedAdapterListener listener) {
        this.drinkComponents = drinkComponents;
        this.drinkComponentsDefaultAsString = drinkComponentsDefaultAsString;
        this.drinkComponentsStandardRecipe = drinkComponentsStandardRecipe;
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {
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
        String drinkComponentDefaultAsString = drinkComponentsDefaultAsString.get(position);
        if (holder instanceof DrinkComponentIncrementableViewHolder) {
            ((DrinkComponentIncrementableViewHolder) holder).bind(drinkComponent, drinkComponentDefaultAsString);
        } else if (holder instanceof DrinkComponentViewHolder) {
            ((DrinkComponentViewHolder) holder).bind(drinkComponent, drinkComponentDefaultAsString);
        } else {
            Log.e(TAG, "else-clause identifying specific type of ViewHolder");
        }
    }

    @Override
    public int getItemCount() {
        return drinkComponents.size();
    }

    public void updateDrinkComponentByString(String name) {
        Log.i(TAG, "updateDrinkComponentByString(String)");

        if (indexSelected > -1) {
            DrinkComponent drinkComponentSelected = drinkComponents.get(indexSelected);
            String drinkComponentDefaultAsStringSelected = drinkComponentsDefaultAsString.get(indexSelected);
            Log.e(TAG, "drinkComponentSelected: " + drinkComponentSelected.getClassAsString() + ", " + drinkComponentSelected.getTypeAsString());

            boolean typeSelectedIsDefault =
                    name.equals(drinkComponentDefaultAsStringSelected);

            boolean typeSelectedInStandardRecipe = false;
            for (DrinkComponent drinkComponent : drinkComponentsStandardRecipe) {
                Log.e(TAG, "drinkComponent from drinkComponentsStandardRecipe: " + drinkComponent.getClassAsString() + ", " + drinkComponent.getTypeAsString());
                if (drinkComponent.getClassAsString().equals(drinkComponentSelected.getClassAsString())) {
                    Log.e(TAG, "CLASSES ARE THE SAME, IT'S A PART OF THE STANDARD RECIPE");
                    typeSelectedInStandardRecipe = true;
                    break;
                }
            }
            Log.e(TAG, "typeSelectedIsDefault: " + typeSelectedIsDefault);
            Log.e(TAG, "typeSelectedInStandardRecipe: " + typeSelectedInStandardRecipe);
            if (typeSelectedIsDefault && !typeSelectedInStandardRecipe) {
                Log.e(TAG, "!!!if!!! (typeSelectedIsDefault && !typeSelectedInStandardRecipe)");
                drinkComponentSelected.setTypeByString(DrinkComponent.NULL_TYPE_AS_STRING);

                // TODO: removal isn't working properly (correct for MenuItemActivity,
                //  but should not remove for CustomizeActivity.
                drinkComponents.remove(indexSelected);
                drinkComponentsDefaultAsString.remove(indexSelected);
                notifyItemRemoved(indexSelected);
            } else {
                Log.e(TAG, "!!!else!!!");
                // Update the underlying model.
                drinkComponentSelected.setTypeByString(name);

                // Update the screen.
                viewHolderSelected.update(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
            }

            // Tear-down steps.
            indexSelected = -1;
            viewHolderSelected = null;
        } else {
            Log.e(TAG, "indexSelected <= -1");
        }
    }

    public void setDrinkComponents(List<DrinkComponent> drinkComponents) {
        this.drinkComponents = drinkComponents;
    }

    public void setDrinkComponentsDefaultAsString(List<String> drinkComponentsDefaultAsString) {
        this.drinkComponentsDefaultAsString = drinkComponentsDefaultAsString;
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

        public void bind(DrinkComponent drinkComponent, String drinkComponentDefaultAsString) {
            tvBorderTitle.setText(drinkComponent.getClassAsString());

            update(drinkComponent, drinkComponentDefaultAsString);
        }

        public void update(DrinkComponent drinkComponent, String drinkComponentDefaultAsString) {
            boolean init = drinkComponent.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING);
            if (init) {
                tvName.setText(drinkComponent.getTextInit());

                tvBorderTitle.setVisibility(View.INVISIBLE);

                viewBorder.setBackgroundResource(R.drawable.border_drink_component_null);
            } else {
                tvName.setText(drinkComponent.getTypeAsString());

                tvBorderTitle.setVisibility(View.VISIBLE);

                boolean defaultSelected =
                        (drinkComponent.getTypeAsString().equals(drinkComponentDefaultAsString)) ? true : false;
                updateBorderColor(defaultSelected);
            }
        }

        private void updateBorderColor(boolean defaultSelected) {
            if (defaultSelected) {
                String colorDefault = "#1B455F";
                tvBorderTitle.setTextColor(Color.parseColor(colorDefault));

                viewBorder.setBackgroundResource(R.drawable.border_drink_component_default);
            } else {
                String colorCustomized = "#AAFF00";
                tvBorderTitle.setTextColor(Color.parseColor(colorCustomized));

                viewBorder.setBackgroundResource(R.drawable.border_drink_component_customized);
            }
        }

        @Override
        public void onClick(View view) {
            indexSelected = getAdapterPosition(); // gets item position
            viewHolderSelected = DrinkComponentViewHolder.this;
            Log.i(TAG, "item in RV clicked! position: " + indexSelected);
            if (indexSelected != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                if (listener != null) {
                    String[] names = drinkComponents.get(indexSelected).getEnumValuesAsStringArray();
                    String nameDefault = drinkComponentsDefaultAsString.get(indexSelected);
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
                    String nameDefault = drinkComponentsDefaultAsString.get(position);
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

        public void bind(DrinkComponent drinkComponent, String drinkComponentDefaultAsString) {
            Incrementable incrementable = (Incrementable) drinkComponent;

            tvBorderTitle.setText(drinkComponent.getClassAsString());

            ivMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    incrementable.onDecrement();

                    update(drinkComponent, drinkComponentDefaultAsString);
                }
            });

            ivAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    incrementable.onIncrement();

                    update(drinkComponent, drinkComponentDefaultAsString);
                }
            });

            update(drinkComponent, drinkComponentDefaultAsString);
        }

        private void update(DrinkComponent drinkComponent, String drinkComponentDefaultAsString) {
            Incrementable incrementable = (Incrementable) drinkComponent;

            String quantityAsString = Integer.toString(incrementable.getQuantity());
            tvQuantity.setText(quantityAsString);

            boolean init = drinkComponent.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING);
            boolean quantityIsZero = incrementable.getQuantity() == 0;
            if (init || quantityIsZero) {
                tvName.setText(drinkComponent.getTextInit());

                tvBorderTitle.setVisibility(View.INVISIBLE);
                ivMinus.setVisibility(View.INVISIBLE);
                tvQuantity.setVisibility(View.INVISIBLE);

                viewBorder.setBackgroundResource(R.drawable.border_drink_component_null);
            } else {
                tvName.setText(drinkComponent.getTypeAsString());

                tvBorderTitle.setVisibility(View.VISIBLE);
                ivMinus.setVisibility(View.VISIBLE);
                tvQuantity.setVisibility(View.VISIBLE);

                boolean defaultSelected =
                        (quantityAsString.equals(drinkComponentDefaultAsString)) ? true : false;
                updateBorderColor(defaultSelected);
            }
        }

        private void updateBorderColor(boolean defaultSelected) {
            if (defaultSelected) {
                String colorDefault = "#1B455F";
                tvBorderTitle.setTextColor(Color.parseColor(colorDefault));

                viewBorder.setBackgroundResource(R.drawable.border_drink_component_default);
            } else {
                String colorCustomized = "#AAFF00";
                tvBorderTitle.setTextColor(Color.parseColor(colorCustomized));

                viewBorder.setBackgroundResource(R.drawable.border_drink_component_customized);
            }
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
