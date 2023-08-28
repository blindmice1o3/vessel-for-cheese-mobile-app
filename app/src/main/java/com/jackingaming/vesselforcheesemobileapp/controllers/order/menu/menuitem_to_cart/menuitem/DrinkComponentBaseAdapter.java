package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem_to_cart.menuitem;

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
import com.jackingaming.vesselforcheesemobileapp.models.components.Granular;
import com.jackingaming.vesselforcheesemobileapp.models.components.GranularTwoOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.Incrementable;
import com.jackingaming.vesselforcheesemobileapp.models.components.MixedType;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponentWithDefaultAsString;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.mixed_type.fruits.base.Fruits;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.mixed_type.fruits.derived.FruitInclusion;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.mixed_type.fruits.derived.StrawberryPuree;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.mixed_type.powders.base.Powders;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.mixed_type.powders.derived.ChocolateMaltPowder;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.add_ins.mixed_type.powders.derived.VanillaBeanPowder;

import java.util.ArrayList;
import java.util.List;

public abstract class DrinkComponentBaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = DrinkComponentBaseAdapter.class.getSimpleName();

    protected static final int VIEW_TYPE_INCREMENTABLE_SELECTION = 0;
    protected static final int VIEW_TYPE_GRANULAR_SELECTION = 1;
    protected static final int VIEW_TYPE_MIXED_TYPE_SELECTION = 2;
    protected static final int VIEW_TYPE_SIMPLE_SELECTION = 3;

    private static final String COLOR_DEFAULT = "#1B455F";
    private static final String COLOR_CUSTOMIZED = "#AAFF00";
    private static final int BACKGROUND_BORDER_INIT = R.drawable.border_drink_component_null;
    private static final int BACKGROUND_BORDER_DEFAULT = R.drawable.border_drink_component_default;
    private static final int BACKGROUND_BORDER_CUSTOMIZED = R.drawable.border_drink_component_customized;

    public interface DrinkComponentBaseAdapterListener {
        void onItemClicked(String[] names, String nameDefault);

        void onItemLongClicked(String[] names, String nameDefault);
    }

    protected List<DrinkComponentWithDefaultAsString> drinkComponents;
    protected List<DrinkComponent> drinkComponentsStandardRecipe;
    protected DrinkComponentBaseAdapterListener listener;

    protected int indexSelected = -1;
    protected RecyclerView.ViewHolder viewHolderSelected;

    public DrinkComponentBaseAdapter() {

    }

    public DrinkComponentBaseAdapter(List<DrinkComponentWithDefaultAsString> drinkComponents,
                                     List<DrinkComponent> drinkComponentsStandardRecipe,
                                     DrinkComponentBaseAdapterListener listener) {
        this.drinkComponents = drinkComponents;
        this.drinkComponentsStandardRecipe = drinkComponentsStandardRecipe;
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        DrinkComponent drinkComponent = drinkComponents.get(position).getDrinkComponent();
        if (drinkComponent instanceof Incrementable) {
            return VIEW_TYPE_INCREMENTABLE_SELECTION;
        } else if (drinkComponent instanceof Granular) {
            return VIEW_TYPE_GRANULAR_SELECTION;
        } else if (drinkComponent instanceof MixedType) {
            return VIEW_TYPE_MIXED_TYPE_SELECTION;
        } else {
            return VIEW_TYPE_SIMPLE_SELECTION;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_INCREMENTABLE_SELECTION) {
            View viewIncrementable = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_incrementable, parent, false);
            return new ViewHolderIncrementableSelection(viewIncrementable);
        } else if (viewType == VIEW_TYPE_GRANULAR_SELECTION) {
            View viewGranularSelection = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_granular_selection, parent, false);
            return new ViewHolderGranularSelection(viewGranularSelection);
        } else if (viewType == VIEW_TYPE_MIXED_TYPE_SELECTION) {
            View viewMixedTypeSelection = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_mixed_type_selection, parent, false);
            return new ViewHolderMixedTypeSelection(viewMixedTypeSelection);
        } else {
            View viewSimpleSelection = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_simple_selection, parent, false);
            return new ViewHolderSimpleSelection(viewSimpleSelection);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsString = drinkComponents.get(position);
        if (holder instanceof ViewHolderIncrementableSelection) {
            ((ViewHolderIncrementableSelection) holder).bind(drinkComponentWithDefaultAsString);
        } else if (holder instanceof ViewHolderGranularSelection) {
            ((ViewHolderGranularSelection) holder).bind(drinkComponentWithDefaultAsString);
        } else if (holder instanceof ViewHolderMixedTypeSelection) {
            ((ViewHolderMixedTypeSelection) holder).bind(drinkComponentWithDefaultAsString);
        } else {
            ((ViewHolderSimpleSelection) holder).bind(drinkComponentWithDefaultAsString);
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

        DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsString = drinkComponents.get(indexSelected);
        DrinkComponent drinkComponentSelected = drinkComponentWithDefaultAsString.getDrinkComponent();
        String drinkComponentDefaultAsStringSelected = drinkComponentWithDefaultAsString.getDrinkComponentDefaultAsString();
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
                handleSelectionOfDefaultForStandardRecipe(drinkComponentSelected,
                        drinkComponentDefaultAsStringSelected, name);
            } else {
                handleSelectionOfNonDefaultForStandardRecipe(drinkComponentSelected,
                        drinkComponentDefaultAsStringSelected, name);
            }
        } else {
            // Non-Standard (Allowables)
            if (typeSelectedIsDefault) {
                handleSelectionOfDefaultForAllowable(drinkComponentSelected,
                        drinkComponentDefaultAsStringSelected, name);
            } else {
                handleSelectionOfNonDefaultForAllowable(drinkComponentSelected,
                        drinkComponentDefaultAsStringSelected, name);
            }
        }

        // Tear-down steps.
        indexSelected = -1;
        viewHolderSelected = null;
    }

    protected abstract void handleSelectionOfDefaultForStandardRecipe(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected, String name);

    protected abstract void handleSelectionOfNonDefaultForStandardRecipe(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected, String name);

    protected abstract void handleSelectionOfDefaultForAllowable(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected, String name);

    protected abstract void handleSelectionOfNonDefaultForAllowable(DrinkComponent drinkComponentSelected, String drinkComponentDefaultAsStringSelected, String name);

    class ViewHolderMixedTypeSelection extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {

        private View viewBorder;
        private TextView tvBorderTitle;
        private TextView tvName;
        private ImageView ivDropDownImage;

        public ViewHolderMixedTypeSelection(@NonNull View itemView) {
            super(itemView);
            viewBorder = itemView.findViewById(R.id.view_border);
            tvBorderTitle = itemView.findViewById(R.id.tv_border_title);
            tvName = itemView.findViewById(R.id.tv_name);
            ivDropDownImage = itemView.findViewById(R.id.iv_drop_down_image);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void bind(DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsString) {
            updateScreen(drinkComponentWithDefaultAsString);
        }

        public void updateScreen(DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsString) {
            DrinkComponent drinkComponent = drinkComponentWithDefaultAsString.getDrinkComponent();
            String drinkComponentDefaultAsString = drinkComponentWithDefaultAsString.getDrinkComponentDefaultAsString();

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
            viewHolderSelected = ViewHolderMixedTypeSelection.this;
            Log.i(TAG, "item in RV clicked! position: " + indexSelected);
            if (indexSelected != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                handleClickForViewHolderMixedTypeSelection();
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

        public void bind(DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsString) {
            updateScreen(drinkComponentWithDefaultAsString);
        }

        public void updateScreen(DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsString) {
            DrinkComponent drinkComponent = drinkComponentWithDefaultAsString.getDrinkComponent();
            String drinkComponentDefaultAsString = drinkComponentWithDefaultAsString.getDrinkComponentDefaultAsString();

            tvBorderTitle.setText(drinkComponent.getClassAsString());

            String typeAsString = drinkComponent.getTypeAsString();
            boolean init = typeAsString.equals(DrinkComponent.NULL_TYPE_AS_STRING);
            if (init) {
                tvName.setText(drinkComponent.getTextInit());
                ivDropDownImage.setImageResource(R.drawable.ic_menu_add);

                tvBorderTitle.setVisibility(View.INVISIBLE);

                viewBorder.setBackgroundResource(BACKGROUND_BORDER_INIT);
            } else {
                if (drinkComponent instanceof GranularTwoOptions) {
                    Log.i(TAG, "drinkComponent instanceof GranularTwoOptions");

                    String text = null;
                    GranularTwoOptions.Option option = ((GranularTwoOptions) drinkComponent).getOption();
                    if (option.name().equals(GranularTwoOptions.Option.STANDARD.name())) {
                        text = "Add " + drinkComponent.getTypeAsString();
                    } else {
                        text = drinkComponent.getTypeAsString();
                    }

                    tvName.setText(text);
                    ivDropDownImage.setImageResource(R.drawable.ic_menu_arrow_down);

                    tvBorderTitle.setVisibility(View.VISIBLE);

                    boolean defaultSelected =
                            (option.name().equals(drinkComponentDefaultAsString)) ? true : false;
                    updateBorderColor(defaultSelected);
                } else {
                    Log.i(TAG, "drinkComponent NOT instanceof GranularTwoOptions");

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

    class ViewHolderIncrementableSelection extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {

        private View viewBorder;
        private TextView tvBorderTitle;
        private TextView tvName;
        private ImageView ivAdd;
        private TextView tvQuantity;
        private ImageView ivMinus;

        public ViewHolderIncrementableSelection(@NonNull View itemView) {
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

        public void bind(DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsString) {
            updateScreen(drinkComponentWithDefaultAsString);

            ivMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DrinkComponent drinkComponent = drinkComponentWithDefaultAsString.getDrinkComponent();

                    ((Incrementable) drinkComponent).onDecrement();

                    updateScreen(drinkComponentWithDefaultAsString);
                }
            });

            ivAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DrinkComponent drinkComponent = drinkComponentWithDefaultAsString.getDrinkComponent();

                    ((Incrementable) drinkComponent).onIncrement();

                    updateScreen(drinkComponentWithDefaultAsString);
                }
            });
        }

        private void updateScreen(DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsString) {
            DrinkComponent drinkComponent = drinkComponentWithDefaultAsString.getDrinkComponent();
            String drinkComponentDefaultAsString = drinkComponentWithDefaultAsString.getDrinkComponentDefaultAsString();

            Incrementable incrementable = (Incrementable) drinkComponent;
            int quantity = incrementable.getQuantity();
            String quantityAsString = Integer.toString(quantity);

            tvBorderTitle.setText(drinkComponent.getClassAsString());
            tvQuantity.setText(quantityAsString);

            boolean init = drinkComponent.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING);
            boolean quantityLessThanOne = quantity < 1;
            if (init || quantityLessThanOne) {
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
            viewHolderSelected = ViewHolderIncrementableSelection.this;
            Log.i(TAG, "item in RV clicked! position: " + indexSelected);
            if (indexSelected != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                handleClickForViewHolderIncrementableSelection();
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

        public void bind(DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsString) {
            updateScreen(drinkComponentWithDefaultAsString);
        }

        public void updateScreen(DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsString) {
            DrinkComponent drinkComponent = drinkComponentWithDefaultAsString.getDrinkComponent();
            String drinkComponentDefaultAsString = drinkComponentWithDefaultAsString.getDrinkComponentDefaultAsString();

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

    private void handleClickForViewHolderMixedTypeSelection() {
        Log.i(TAG, "handleClickForViewHolderMixedTypeSelection()");

        if (listener == null) {
            Log.e(TAG, "listener == null");
            return;
        }

        DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsString = drinkComponents.get(indexSelected);
        DrinkComponent drinkComponentSelected = drinkComponentWithDefaultAsString.getDrinkComponent();
        String drinkComponentDefaultAsStringSelected = drinkComponentWithDefaultAsString.getDrinkComponentDefaultAsString();

        // FIND DRINK COMPONENTS THAT ARE [not inside] THE DRINK
        List<String> drinkComponentsAsStringNotInsideDrink = new ArrayList<>();
        if (drinkComponentSelected instanceof Powders) {
            Log.i(TAG, "(drinkComponentSelected instanceof Powders");

            // INCREMENTABLE
            List<String> vanillaBeanPowderAsStringNotInsideDrink = findEnumValuesNotInsideDrink(
                    VanillaBeanPowder.getEnumValuesAsStringForMixedType().toArray(new String[0])
            );
            drinkComponentsAsStringNotInsideDrink.addAll(vanillaBeanPowderAsStringNotInsideDrink);
            // GRANULAR
            List<String> chocolateMaltPowderAsStringNotInsideDrink = findEnumValuesNotInsideDrink(
                    ChocolateMaltPowder.getEnumValuesAsStringForMixedType().toArray(new String[0])
            );
            drinkComponentsAsStringNotInsideDrink.addAll(chocolateMaltPowderAsStringNotInsideDrink);
        }
        // FRUITS
        else if (drinkComponentSelected instanceof Fruits) {
            Log.i(TAG, "(drinkComponentSelected instanceof Fruits");

            // INCREMENTABLE
            List<String> fruitInclusionAsStringNotInsideDrink = findEnumValuesNotInsideDrink(
                    FruitInclusion.getEnumValuesAsStringForMixedType().toArray(new String[0])
            );
            drinkComponentsAsStringNotInsideDrink.addAll(fruitInclusionAsStringNotInsideDrink);
            // GRANULAR
            List<String> strawberryPureeAsStringNotInsideDrink = findEnumValuesNotInsideDrink(
                    StrawberryPuree.getEnumValuesAsStringForMixedType().toArray(new String[0])
            );
            drinkComponentsAsStringNotInsideDrink.addAll(strawberryPureeAsStringNotInsideDrink);
        } else {
            Log.e(TAG, "drinkComponentSelected NOT instanceof Powders nor Fruits");
        }

        listener.onItemClicked(
                drinkComponentsAsStringNotInsideDrink.toArray(new String[0]),
                drinkComponentDefaultAsStringSelected
        );
    }

    private void handleClickForViewHolderGranularSelection() {
        Log.i(TAG, "handleClickForViewHolderGranularSelection()");

        if (listener == null) {
            Log.e(TAG, "listener == null");
            return;
        }

        DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsString = drinkComponents.get(indexSelected);
        DrinkComponent drinkComponentSelected = drinkComponentWithDefaultAsString.getDrinkComponent();
        String drinkComponentDefaultAsStringSelected = drinkComponentWithDefaultAsString.getDrinkComponentDefaultAsString();

        boolean init = drinkComponentSelected.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING);
        if (init) {
            Log.i(TAG, "drinkComponentSelected.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING)");

            String[] enumValuesAsString = drinkComponentSelected.getEnumValuesAsStringArray();
            List<String> enumValuesNotInsideDrink = findEnumValuesNotInsideDrink(enumValuesAsString);

            if (enumValuesNotInsideDrink.size() == 1) {
                Log.i(TAG, "enumValuesNotInsideDrink.size() == 1");

                drinkComponentSelected.setTypeByString(enumValuesNotInsideDrink.get(0));
                ((Granular) drinkComponentSelected).setAmount(Granular.Amount.MEDIUM);
                notifyItemChanged(indexSelected);
            } else {
                Log.i(TAG, "enumValuesNotInsideDrink.size() != 1");

                listener.onItemClicked(
                        enumValuesNotInsideDrink.toArray(new String[0]),
                        drinkComponentDefaultAsStringSelected
                );
            }
        } else {
            Log.i(TAG, "NOT drinkComponentSelected.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING)");

            String[] names = null;
            String nameDefault = null;
            if (drinkComponentSelected instanceof GranularTwoOptions) {
                names = new String[GranularTwoOptions.Option.values().length];
                nameDefault = drinkComponentDefaultAsStringSelected;

                for (int i = 0; i < GranularTwoOptions.Option.values().length; i++) {
                    names[i] = GranularTwoOptions.Option.values()[i].name();
                }
            } else {
                names = new String[Granular.Amount.values().length];
                nameDefault = drinkComponentDefaultAsStringSelected;

                for (int i = 0; i < Granular.Amount.values().length; i++) {
                    names[i] = Granular.Amount.values()[i].name();
                }
            }

            listener.onItemClicked(names, nameDefault);
        }
    }

    protected void handleClickForViewHolderIncrementableSelection() {
        Log.i(TAG, "handleClickForViewHolderIncrementableSelection()");

        if (listener == null) {
            Log.e(TAG, "listener == null");
            return;
        }

        DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsString = drinkComponents.get(indexSelected);
        DrinkComponent drinkComponentSelected = drinkComponentWithDefaultAsString.getDrinkComponent();
        String drinkComponentDefaultAsStringSelected = drinkComponentWithDefaultAsString.getDrinkComponentDefaultAsString();

        boolean init = drinkComponentSelected.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING);
        if (init) {
            Log.i(TAG, "drinkComponentSelected.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING)");

            String[] enumValues = drinkComponentSelected.getEnumValuesAsStringArray();
            List<String> enumValuesNotInsideDrink = findEnumValuesNotInsideDrink(enumValues);

            if (enumValuesNotInsideDrink.size() == 1) {
                Log.i(TAG, "enumValuesNotInsideDrink.size() == 1");

                drinkComponentSelected.setTypeByString(enumValuesNotInsideDrink.get(0));
                ((Incrementable) drinkComponentSelected).setQuantity(1);
                notifyItemChanged(indexSelected);
            } else {
                Log.i(TAG, "enumValuesNotInsideDrink.size() != 1");

                listener.onItemClicked(
                        enumValuesNotInsideDrink.toArray(new String[0]),
                        drinkComponentDefaultAsStringSelected
                );
            }
        } else {
            Log.i(TAG, "NOT drinkComponentSelected.getTypeAsString().equals(DrinkComponent.NULL_TYPE_AS_STRING)");

            boolean quantityLessThanOne = ((Incrementable) drinkComponentSelected).getQuantity() < 1;
            if (quantityLessThanOne) {
                ((Incrementable) drinkComponentSelected).setQuantity(1);
                notifyItemChanged(indexSelected);
            }
        }
    }

    private void handleClickForViewHolderSimpleSelection() {
        Log.i(TAG, "handleClickForViewHolderSimpleSelection()");

        if (listener == null) {
            Log.e(TAG, "listener == null");
            return;
        }

        String[] names = drinkComponents.get(indexSelected).getDrinkComponent().getEnumValuesAsStringArray();
        String nameDefault = drinkComponents.get(indexSelected).getDrinkComponentDefaultAsString();

        listener.onItemClicked(names, nameDefault);
    }

    protected List<String> findEnumValuesNotInsideDrink(String[] enumValues) {
        Log.i(TAG, "findEnumValuesNotInsideDrink()");

        List<String> enumValuesFiltered = new ArrayList<>();
        for (String enumValueAsString : enumValues) {
            Log.i(TAG, "enumValueAsString: " + enumValueAsString);
            boolean isInsideDrink = false;

            for (DrinkComponentWithDefaultAsString drinkComponentWithDefaultAsString : drinkComponents) {
                DrinkComponent drinkComponent = drinkComponentWithDefaultAsString.getDrinkComponent();
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
