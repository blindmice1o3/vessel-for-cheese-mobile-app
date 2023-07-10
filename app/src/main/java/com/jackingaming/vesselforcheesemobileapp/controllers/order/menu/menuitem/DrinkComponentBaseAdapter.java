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

import java.util.ArrayList;
import java.util.List;

public abstract class DrinkComponentBaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = DrinkComponentBaseAdapter.class.getSimpleName();

    protected static final int VIEW_TYPE_INCREMENTABLE = 0;
    protected static final int VIEW_TYPE_GRANULAR_SELECTION = 1;
    protected static final int VIEW_TYPE_SIMPLE_SELECTION = 2;

    private static final String COLOR_DEFAULT = "#1B455F";
    private static final String COLOR_CUSTOMIZED = "#AAFF00";
    private static final int BACKGROUND_BORDER_INIT = R.drawable.border_drink_component_null;
    private static final int BACKGROUND_BORDER_DEFAULT = R.drawable.border_drink_component_default;
    private static final int BACKGROUND_BORDER_CUSTOMIZED = R.drawable.border_drink_component_customized;

    public interface DrinkComponentBaseAdapterListener {
        void onItemClicked(String[] names, String nameDefault);

        void onItemLongClicked(String[] names, String nameDefault);
    }

    protected List<DrinkComponent> drinkComponents;
    protected List<String> drinkComponentsDefaultAsString;
    protected List<DrinkComponent> drinkComponentsStandardRecipe;
    protected DrinkComponentBaseAdapterListener listener;

    protected int indexSelected = -1;
    protected RecyclerView.ViewHolder viewHolderSelected;

    public DrinkComponentBaseAdapter() {

    }

    public DrinkComponentBaseAdapter(List<DrinkComponent> drinkComponents,
                                     List<String> drinkComponentsDefaultAsString,
                                     List<DrinkComponent> drinkComponentsStandardRecipe,
                                     DrinkComponentBaseAdapterListener listener) {
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
        } else if (drinkComponent instanceof Granular) {
            return VIEW_TYPE_GRANULAR_SELECTION;
        } else {
            return VIEW_TYPE_SIMPLE_SELECTION;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_INCREMENTABLE) {
            View viewIncrementable = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_incrementable, parent, false);
            return new ViewHolderIncrementable(viewIncrementable);
        } else if (viewType == VIEW_TYPE_GRANULAR_SELECTION) {
            View viewGranularSelection = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_granular_selection, parent, false);
            return new ViewHolderGranularSelection(viewGranularSelection);
        } else {
            View viewSimpleSelection = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_simple_selection, parent, false);
            return new ViewHolderSimpleSelection(viewSimpleSelection);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        DrinkComponent drinkComponent = drinkComponents.get(position);
        String drinkComponentDefaultAsString = drinkComponentsDefaultAsString.get(position);
        if (holder instanceof ViewHolderIncrementable) {
            ((ViewHolderIncrementable) holder).bind(drinkComponent, drinkComponentDefaultAsString);
        } else if (holder instanceof ViewHolderGranularSelection) {
            ((ViewHolderGranularSelection) holder).bind(drinkComponent, drinkComponentDefaultAsString);
        } else {
            ((ViewHolderSimpleSelection) holder).bind(drinkComponent, drinkComponentDefaultAsString);
        }
    }

    @Override
    public int getItemCount() {
        return drinkComponents.size();
    }

    public void updateDrinkComponentByString(String name) {
        Log.i(TAG, "updateDrinkComponentByString(String)");

        if (indexSelected < 0) {
            Log.e(TAG, "(indexSelected < 0) ---> returning.");
            return;
        }

        DrinkComponent drinkComponentSelected = drinkComponents.get(indexSelected);
        String drinkComponentDefaultAsStringSelected = drinkComponentsDefaultAsString.get(indexSelected);
        Log.i(TAG, "drinkComponentSelected ---> class: " + drinkComponentSelected.getClassAsString() + ", type: " + drinkComponentSelected.getTypeAsString());

        boolean typeSelectedIsDefault =
                name.equals(drinkComponentDefaultAsStringSelected);
        boolean typeSelectedInStandardRecipe = false;
        for (DrinkComponent drinkComponent : drinkComponentsStandardRecipe) {
            Log.i(TAG, "drinkComponent from drinkComponentsStandardRecipe ---> class: " + drinkComponent.getClassAsString() + ", type:" + drinkComponent.getTypeAsString());
            if (drinkComponent.getClassAsString().equals(drinkComponentSelected.getClassAsString())) {
                Log.i(TAG, "CLASSES ARE THE SAME, IT'S A PART OF THE STANDARD RECIPE");
                typeSelectedInStandardRecipe = true;
                break;
            }
        }
        Log.i(TAG, "typeSelectedIsDefault: " + typeSelectedIsDefault);
        Log.i(TAG, "typeSelectedInStandardRecipe: " + typeSelectedInStandardRecipe);

        if (typeSelectedInStandardRecipe) {
            // Standard
            if (typeSelectedIsDefault) {
                handleSelectionOfDefaultFromStandardRecipe(drinkComponentSelected,
                        drinkComponentDefaultAsStringSelected, name);
            } else {
                handleSelectionOfNonDefaultFromStandardRecipe(drinkComponentSelected,
                        drinkComponentDefaultAsStringSelected, name);
            }
        } else {
            // Non-Standard (Allowables)
            if (typeSelectedIsDefault) {
                handleSelectionOfDefaultFromNonStandardRecipe(drinkComponentSelected,
                        null);
            } else {
                handleSelectionOfNonDefaultFromNonStandardRecipe(drinkComponentSelected,
                        drinkComponentDefaultAsStringSelected, name);
            }
        }

        // Tear-down steps.
        indexSelected = -1;
        viewHolderSelected = null;
    }

    protected void updateScreen(DrinkComponent drinkComponentSelected,
                                String drinkComponentDefaultAsStringSelected) {
        if (viewHolderSelected.getItemViewType() == VIEW_TYPE_INCREMENTABLE) {
            ViewHolderIncrementable viewHolderIncrementable = (ViewHolderIncrementable) viewHolderSelected;
            viewHolderIncrementable.updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
        } else if (viewHolderSelected.getItemViewType() == VIEW_TYPE_GRANULAR_SELECTION) {
            ViewHolderGranularSelection viewHolderGranularSelection = (ViewHolderGranularSelection) viewHolderSelected;
            viewHolderGranularSelection.updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
        } else {
            ViewHolderSimpleSelection viewHolderSimpleSelection = (ViewHolderSimpleSelection) viewHolderSelected;
            viewHolderSimpleSelection.updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
        }
    }

    protected abstract void handleSelectionOfDefaultFromStandardRecipe(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected, String name);

    protected abstract void handleSelectionOfNonDefaultFromStandardRecipe(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected, String name);

    protected abstract void handleSelectionOfDefaultFromNonStandardRecipe(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected);

    protected abstract void handleSelectionOfNonDefaultFromNonStandardRecipe(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected, String name);

    class ViewHolderGranularSelection extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {

        private View viewBorder;
        private TextView tvBorderTitle;
        private TextView tvName;
        private ImageView ivDropDownImage;

        public ViewHolderGranularSelection(@NonNull View itemView) {
            super(itemView);
            viewBorder = itemView.findViewById(R.id.view_border);
            tvBorderTitle = itemView.findViewById(R.id.tv_border_title);
            tvName = itemView.findViewById(R.id.tv_name);
            ivDropDownImage = itemView.findViewById(R.id.iv_drop_down_image);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void bind(DrinkComponent drinkComponent, String drinkComponentDefaultAsString) {
            updateScreen(drinkComponent, drinkComponentDefaultAsString);
        }

        public void updateScreen(DrinkComponent drinkComponent, String drinkComponentDefaultAsString) {
            tvBorderTitle.setText(drinkComponent.getClassAsString());

            String typeAsString = drinkComponent.getTypeAsString();
            boolean init = typeAsString.equals(DrinkComponent.NULL_TYPE_AS_STRING);
            if (init) {
                tvName.setText(drinkComponent.getTextInit());
                ivDropDownImage.setImageResource(R.drawable.ic_menu_add);

                tvBorderTitle.setVisibility(View.INVISIBLE);

                viewBorder.setBackgroundResource(BACKGROUND_BORDER_INIT);
            } else {
                Granular.Amount amount = ((Granular) drinkComponent).getAmount();
                String textBasedOnAmount = (amount == Granular.Amount.MEDIUM) ?
                        (typeAsString) : (amount.name() + " " + typeAsString);
                tvName.setText(textBasedOnAmount);
                ivDropDownImage.setImageResource(R.drawable.ic_menu_arrow_down);

                tvBorderTitle.setVisibility(View.VISIBLE);

                boolean defaultSelected =
                        (amount.name().equals(drinkComponentDefaultAsString)) ? true : false;
                updateBorderColor(defaultSelected);
            }
        }

        private void updateBorderColor(boolean defaultSelected) {
            if (defaultSelected) {
                tvBorderTitle.setTextColor(Color.parseColor(COLOR_DEFAULT));

                viewBorder.setBackgroundResource(BACKGROUND_BORDER_DEFAULT);
            } else {
                tvBorderTitle.setTextColor(Color.parseColor(COLOR_CUSTOMIZED));

                viewBorder.setBackgroundResource(BACKGROUND_BORDER_CUSTOMIZED);
            }
        }

        @Override
        public void onClick(View view) {
            indexSelected = getAdapterPosition(); // gets item position
            viewHolderSelected = ViewHolderGranularSelection.this;
            Log.i(TAG, "item in RV clicked! position: " + indexSelected);
            if (indexSelected != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                handleClickForViewHolderGranularSelection();
            }
        }

        @Override
        public boolean onLongClick(View view) {
            int position = getAdapterPosition(); // gets item position
            Log.i(TAG, "item in RV long-clicked! position: " + position);
//            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
//                if (listener != null) {
//                    DrinkComponent drinkComponent = drinkComponents.get(position);
//                    String[] enumsAsString = drinkComponent.getEnumValuesAsStringArray();
//                    String nameDefault = drinkComponentsDefaultAsString.get(position);
//                    listener.onItemLongClicked(enumsAsString, nameDefault);
//                    return true;
//                }
//            }
            return false;
        }
    }

    class ViewHolderSimpleSelection extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {

        private View viewBorder;
        private TextView tvBorderTitle;
        private TextView tvName;
        private ImageView ivDropDownImage;

        public ViewHolderSimpleSelection(@NonNull View itemView) {
            super(itemView);
            viewBorder = itemView.findViewById(R.id.view_border);
            tvBorderTitle = itemView.findViewById(R.id.tv_border_title);
            tvName = itemView.findViewById(R.id.tv_name);
            ivDropDownImage = itemView.findViewById(R.id.iv_drop_down_image);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void bind(DrinkComponent drinkComponent, String drinkComponentDefaultAsString) {
            updateScreen(drinkComponent, drinkComponentDefaultAsString);
        }

        public void updateScreen(DrinkComponent drinkComponent, String drinkComponentDefaultAsString) {
            tvBorderTitle.setText(drinkComponent.getClassAsString());

            boolean init = drinkComponent.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING);
            if (init) {
                tvName.setText(drinkComponent.getTextInit());

                tvBorderTitle.setVisibility(View.INVISIBLE);

                viewBorder.setBackgroundResource(BACKGROUND_BORDER_INIT);
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
                tvBorderTitle.setTextColor(Color.parseColor(COLOR_DEFAULT));

                viewBorder.setBackgroundResource(BACKGROUND_BORDER_DEFAULT);
            } else {
                tvBorderTitle.setTextColor(Color.parseColor(COLOR_CUSTOMIZED));

                viewBorder.setBackgroundResource(BACKGROUND_BORDER_CUSTOMIZED);
            }
        }

        @Override
        public void onClick(View view) {
            indexSelected = getAdapterPosition(); // gets item position
            viewHolderSelected = ViewHolderSimpleSelection.this;
            Log.i(TAG, "item in RV clicked! position: " + indexSelected);
            if (indexSelected != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                handleClickForViewHolderSimpleSelection();
            }
        }

        @Override
        public boolean onLongClick(View view) {
            int position = getAdapterPosition(); // gets item position
            Log.i(TAG, "item in RV long-clicked! position: " + position);
//            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
//                if (listener != null) {
//                    DrinkComponent drinkComponent = drinkComponents.get(position);
//                    String[] enumsAsString = drinkComponent.getEnumValuesAsStringArray();
//                    String nameDefault = drinkComponentsDefaultAsString.get(position);
//                    listener.onItemLongClicked(enumsAsString, nameDefault);
//                    return true;
//                }
//            }
            return false;
        }
    }

    class ViewHolderIncrementable extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {

        private View viewBorder;
        private TextView tvBorderTitle;
        private TextView tvName;
        private ImageView ivAdd;
        private TextView tvQuantity;
        private ImageView ivMinus;

        public ViewHolderIncrementable(@NonNull View itemView) {
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
            updateScreen(drinkComponent, drinkComponentDefaultAsString);

            ivMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((Incrementable) drinkComponent).onDecrement();

                    updateScreen(drinkComponent, drinkComponentDefaultAsString);
                }
            });

            ivAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((Incrementable) drinkComponent).onIncrement();

                    updateScreen(drinkComponent, drinkComponentDefaultAsString);
                }
            });
        }

        private void updateScreen(DrinkComponent drinkComponent, String drinkComponentDefaultAsString) {
            Incrementable incrementable = (Incrementable) drinkComponent;
            int quantity = incrementable.getQuantity();
            String quantityAsString = Integer.toString(quantity);

            tvBorderTitle.setText(drinkComponent.getClassAsString());
            tvQuantity.setText(quantityAsString);

            boolean init = quantity < 0;
            boolean quantityIsZero = quantity == 0;
            if (init || quantityIsZero) {
                Log.e(TAG, "init || quantityIsZero (invisible)");
                tvName.setText(drinkComponent.getTextInit());

                tvBorderTitle.setVisibility(View.INVISIBLE);
                ivMinus.setVisibility(View.INVISIBLE);
                tvQuantity.setVisibility(View.INVISIBLE);

                viewBorder.setBackgroundResource(BACKGROUND_BORDER_INIT);
            } else {
                Log.e(TAG, "else (visible)");
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
                tvBorderTitle.setTextColor(Color.parseColor(COLOR_DEFAULT));

                viewBorder.setBackgroundResource(BACKGROUND_BORDER_DEFAULT);
            } else {
                tvBorderTitle.setTextColor(Color.parseColor(COLOR_CUSTOMIZED));

                viewBorder.setBackgroundResource(BACKGROUND_BORDER_CUSTOMIZED);
            }
        }

        @Override
        public void onClick(View view) {
            indexSelected = getAdapterPosition(); // gets item position
            viewHolderSelected = ViewHolderIncrementable.this;
            Log.i(TAG, "item in RV clicked! position: " + indexSelected);
            if (indexSelected != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                handleClickForViewHolderIncrementable();
            }
        }

        @Override
        public boolean onLongClick(View view) {
            int position = getAdapterPosition(); // gets item position
            Log.i(TAG, "item in RV long-clicked! position: " + position);
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

    protected void handleClickForViewHolderIncrementable() {
        Log.i(TAG, "handleClickForViewHolderIncrementable()");

        // intentionally doing nothing (CustomizeInnerAdapter overrides this).
    }

    private void handleClickForViewHolderSimpleSelection() {
        Log.i(TAG, "handleClickForViewHolderSimpleSelection()");

        if (listener == null) {
            Log.e(TAG, "listener == null");
            return;
        }

        String[] names = drinkComponents.get(indexSelected).getEnumValuesAsStringArray();
        String nameDefault = drinkComponentsDefaultAsString.get(indexSelected);
        listener.onItemClicked(names, nameDefault);
    }

    private void handleClickForViewHolderGranularSelection() {
        Log.i(TAG, "handleClickForViewHolderGranularSelection()");

        if (listener == null) {
            Log.e(TAG, "listener == null");
            return;
        }

        DrinkComponent drinkComponentSelected = drinkComponents.get(indexSelected);
        String drinkComponentDefaultAsStringSelected = drinkComponentsDefaultAsString.get(indexSelected);

        if (drinkComponentSelected.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING)) {
            Log.i(TAG, "drinkComponentSelected.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING)");

            String[] enumValues = drinkComponentSelected.getEnumValuesAsStringArray();
            if (enumValues.length == 1) {
                Log.i(TAG, "enumValues.length == 1");

                drinkComponentSelected.setTypeByString(enumValues[0]);
                ((Granular) drinkComponentSelected).setAmount(Granular.Amount.MEDIUM);
                updateScreen(drinkComponentSelected, drinkComponentDefaultAsStringSelected);
            } else {
                Log.i(TAG, "enumValues.length != 1");

                List<String> enumValuesFiltered = findEnumValuesNotInsideDrink(enumValues);

                listener.onItemClicked(enumValuesFiltered.toArray(new String[0]), drinkComponentDefaultAsStringSelected);
            }
        } else {
            Log.i(TAG, "NOT drinkComponentSelected.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING)");

            String[] names = new String[Granular.Amount.values().length];
            String nameDefault = drinkComponentsDefaultAsString.get(indexSelected);
            for (int i = 0; i < Granular.Amount.values().length; i++) {
                names[i] = Granular.Amount.values()[i].name();
            }

            listener.onItemClicked(names, nameDefault);
        }
    }

    protected List<String> findEnumValuesNotInsideDrink(String[] enumValues) {
        Log.i(TAG, "findEnumValuesNotInsideDrink()");

        List<String> enumValuesFiltered = new ArrayList<>();
        for (String enumValueAsString : enumValues) {
            Log.i(TAG, "enumValueAsString: " + enumValueAsString);
            boolean isInsideDrink = false;

            for (DrinkComponent drinkComponent : drinkComponents) {
                Log.i(TAG, "drinkComponent CLASS: " + drinkComponent.getClassAsString() + ", TYPE: " + drinkComponent.getTypeAsString());
                if (enumValueAsString.equals(drinkComponent.getTypeAsString())) {
                    isInsideDrink = true;
                }
            }

            if (!isInsideDrink) {
                enumValuesFiltered.add(enumValueAsString);
            }
        }
        return enumValuesFiltered;
    }
}
