package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem;

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
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.AffogatoShot;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.EspressoOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.PrepOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.PullOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.RoastOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.Shot;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.SizeOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.CappuccinoFoam;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.MilkBase;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.MilkFoam;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.MilkOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.Temperature;

import java.util.List;

public class WhatsIncludedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = WhatsIncludedAdapter.class.getSimpleName();

    private static final int VIEW_TYPE_ERROR = -1;
    private static final int VIEW_TYPE_INCREMENTABLE = 0;

    private static final int VIEW_TYPE_MILK_BASE = 1;
    private static final int VIEW_TYPE_TEMPERATURE = 2;
    private static final int VIEW_TYPE_MILK_FOAM = 3;
    private static final int VIEW_TYPE_CAPPUCCINO_FOAM = 4;

    private static final int VIEW_TYPE_SHOT = 5;
    private static final int VIEW_TYPE_AFFOGATO_SHOT = 6;
    private static final int VIEW_TYPE_ROAST_OPTIONS = 7;
    private static final int VIEW_TYPE_PREP_OPTIONS = 8;
    private static final int VIEW_TYPE_PULL_OPTIONS = 9;
    private static final int VIEW_TYPE_SIZE_OPTIONS = 10;

    public interface WhatsIncludedAdapterListener {
        void onItemClicked(String[] names, TextView textView);

        void onItemLongClicked(String[] names, TextView textView);
    }

    private List<DrinkComponent> drinkComponents;
    private WhatsIncludedAdapterListener listener;

    public WhatsIncludedAdapter(List<DrinkComponent> drinkComponents, WhatsIncludedAdapterListener listener) {
        this.drinkComponents = drinkComponents;
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        Log.i(TAG, "getItemViewType()");
        DrinkComponent drinkComponent = drinkComponents.get(position);

        if (drinkComponent instanceof Incrementable) {
            return VIEW_TYPE_INCREMENTABLE;
        }

        // --------------------------------------------------------------------

        if (drinkComponent instanceof MilkOptions) {
            Log.i(TAG, "drinkComponent instanceof MilkOptions");

            MilkOptions milkOptions = (MilkOptions) drinkComponent;
            if (milkOptions instanceof MilkBase) {
                return VIEW_TYPE_MILK_BASE;
            } else if (milkOptions instanceof Temperature) {
                return VIEW_TYPE_TEMPERATURE;
            } else if (milkOptions instanceof MilkFoam) {
                return VIEW_TYPE_MILK_FOAM;
            } else if (milkOptions instanceof CappuccinoFoam) {
                return VIEW_TYPE_CAPPUCCINO_FOAM;
            } else {
                Log.e(TAG, "MilkOptions else-clause");
                return VIEW_TYPE_ERROR;
            }
        } else if (drinkComponent instanceof EspressoOptions) {
            Log.i(TAG, "drinkComponent instanceof EspressoOptions");

            EspressoOptions espressoOptions = (EspressoOptions) drinkComponent;
            // TODO: remove Shot and AffogatoShot (taken care of by Incrementable)
            if (espressoOptions instanceof Shot) {
                return VIEW_TYPE_SHOT;
            } else if (espressoOptions instanceof AffogatoShot) {
                return VIEW_TYPE_AFFOGATO_SHOT;
            } else if (espressoOptions instanceof RoastOptions) {
                return VIEW_TYPE_ROAST_OPTIONS;
            } else if (espressoOptions instanceof PrepOptions) {
                return VIEW_TYPE_PREP_OPTIONS;
            } else if (espressoOptions instanceof PullOptions) {
                return VIEW_TYPE_PULL_OPTIONS;
            } else if (espressoOptions instanceof SizeOptions) {
                return VIEW_TYPE_SIZE_OPTIONS;
            } else {
                Log.e(TAG, "EspressoOptions else-clause");
                return VIEW_TYPE_ERROR;
            }
        } else {
            Log.e(TAG, "else-clause identifying specific type of DrinkComponent");
            return VIEW_TYPE_ERROR;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder()");

        switch (viewType) {
            case VIEW_TYPE_INCREMENTABLE:
                View viewIncrementableDrinkComponent = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_drink_component_incrementable, parent, false);
                return new DrinkComponentIncrementableViewHolder(viewIncrementableDrinkComponent);
            case VIEW_TYPE_MILK_BASE:
            case VIEW_TYPE_TEMPERATURE:
            case VIEW_TYPE_MILK_FOAM:
            case VIEW_TYPE_CAPPUCCINO_FOAM:
            case VIEW_TYPE_ROAST_OPTIONS:
            case VIEW_TYPE_PREP_OPTIONS:
            case VIEW_TYPE_PULL_OPTIONS:
            case VIEW_TYPE_SIZE_OPTIONS:
                View viewDrinkComponent = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_drink_component, parent, false);
                return new DrinkComponentViewHolder(viewDrinkComponent);
            // TODO: taken care of by Incrementable
//            case VIEW_TYPE_SHOT:
//            case VIEW_TYPE_AFFOGATO_SHOT:
            default:
                Log.e(TAG, "switch(viewType) default block");
                View viewDefault = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_drink_component, parent, false);
                return new DrinkComponentViewHolder(viewDefault);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder()");

        int viewType = holder.getItemViewType();
        DrinkComponent drinkComponent = drinkComponents.get(position);
        if (holder instanceof DrinkComponentViewHolder) {
            ((DrinkComponentViewHolder) holder).bind(viewType, drinkComponent);
        } else if (holder instanceof DrinkComponentIncrementableViewHolder) {
            ((DrinkComponentIncrementableViewHolder) holder).bind(viewType, drinkComponent);
        } else {
            Log.e(TAG, "else-clause identifying specific type of ViewHolder");
        }
    }

    @Override
    public int getItemCount() {
        Log.i(TAG, "getItemCount()");
        return drinkComponents.size();
    }

    class DrinkComponentViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {

        private TextView tvBorderTitle;
        private TextView tvName;
        private ImageView ivDropDownImage;

        private String[] enumsAsString;

        public DrinkComponentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBorderTitle = itemView.findViewById(R.id.tv_border_title);
            tvName = itemView.findViewById(R.id.tv_name);
            ivDropDownImage = itemView.findViewById(R.id.iv_drop_down_image);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void bind(int viewType, DrinkComponent drinkComponent) {
            String titleBorder = null;
            String name = null;
            switch (viewType) {
                case VIEW_TYPE_MILK_BASE:
                    titleBorder = MilkBase.class.getSimpleName();
                    name = ((MilkBase) drinkComponent).getType().name();
                    break;
                case VIEW_TYPE_TEMPERATURE:
                    titleBorder = Temperature.class.getSimpleName();
                    name = ((Temperature) drinkComponent).getType().name();
                    break;
                case VIEW_TYPE_MILK_FOAM:
                    titleBorder = MilkFoam.class.getSimpleName();
                    name = ((MilkFoam) drinkComponent).getType().name();
                    break;
                case VIEW_TYPE_CAPPUCCINO_FOAM:
                    titleBorder = CappuccinoFoam.class.getSimpleName();
                    name = ((CappuccinoFoam) drinkComponent).getType().name();
                    break;
                case VIEW_TYPE_SHOT:
                    titleBorder = Shot.class.getSimpleName();
                    name = ((Shot) drinkComponent).getType().name();
                    break;
                case VIEW_TYPE_AFFOGATO_SHOT:
                    titleBorder = AffogatoShot.class.getSimpleName();
                    name = ((AffogatoShot) drinkComponent).getType().name();
                    break;
                case VIEW_TYPE_ROAST_OPTIONS:
                    titleBorder = RoastOptions.class.getSimpleName();
                    name = ((RoastOptions) drinkComponent).getType().name();
                    break;
                case VIEW_TYPE_PREP_OPTIONS:
                    titleBorder = PrepOptions.class.getSimpleName();
                    name = ((PrepOptions) drinkComponent).getType().name();
                    break;
                case VIEW_TYPE_PULL_OPTIONS:
                    titleBorder = PullOptions.class.getSimpleName();
                    name = ((PullOptions) drinkComponent).getType().name();
                    break;
                case VIEW_TYPE_SIZE_OPTIONS:
                    titleBorder = SizeOptions.class.getSimpleName();
                    name = ((SizeOptions) drinkComponent).getType().name();
                    break;
                default:
                    titleBorder = "error";
                    name = "default";
                    Log.e(TAG, "DrinkComponentViewHolder.bind() switch(viewType) default block");
                    break;
            }
            int imageResource = R.drawable.ic_coins_s;
            enumsAsString = drinkComponent.getEnumValuesAsStringArray();

            tvBorderTitle.setText(titleBorder);
            tvName.setText(name);
            ivDropDownImage.setImageResource(imageResource);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition(); // gets item position
            Log.i(TAG, "item in RV clicked! position: " + position);
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                if (listener != null) {
                    listener.onItemClicked(enumsAsString, view.findViewById(R.id.tv_name));
                }
            }
        }

        @Override
        public boolean onLongClick(View view) {
            int position = getAdapterPosition(); // gets item position
            Log.i(TAG, "item in RV long-clicked! position: " + position);
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                if (listener != null) {
                    listener.onItemLongClicked(enumsAsString, view.findViewById(R.id.tv_name));
                    return true;
                }
            }
            return false;
        }
    }

    class DrinkComponentIncrementableViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {

        private TextView tvBorderTitle;
        private TextView tvName;
        private ImageView ivAdd;
        private TextView tvQuantity;
        private ImageView ivMinus;

        private String[] enumsAsString;

        public DrinkComponentIncrementableViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBorderTitle = itemView.findViewById(R.id.tv_border_title);
            tvName = itemView.findViewById(R.id.tv_name);
            ivMinus = itemView.findViewById(R.id.iv_minus);
            tvQuantity = itemView.findViewById(R.id.tv_quantity);
            ivAdd = itemView.findViewById(R.id.iv_add);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void bind(int viewType, DrinkComponent drinkComponent) {
            String titleBorder = null;
            String name = null;
            if (drinkComponent instanceof Shot) {
                titleBorder = Shot.class.getSimpleName();
                name = ((Shot) drinkComponent).getType().name();
            } else if (drinkComponent instanceof AffogatoShot) {
                titleBorder = AffogatoShot.class.getSimpleName();
                name = ((AffogatoShot) drinkComponent).getType().name();
            }

            Incrementable incrementable = (Incrementable) drinkComponent;
            int quantity = incrementable.getQuantity();
            enumsAsString = drinkComponent.getEnumValuesAsStringArray();

            tvBorderTitle.setText(titleBorder);
            tvName.setText(name);
            ivMinus.setImageResource(R.drawable.ic_menu_minus);
            ivMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    incrementable.onDecrement();
                    tvQuantity.setText(Integer.toString(incrementable.getQuantity()));

                    if (drinkComponent instanceof Shot) {
                        tvName.setText(((Shot) drinkComponent).getType().name());
                    } else if (drinkComponent instanceof AffogatoShot) {
                        tvName.setText(((AffogatoShot) drinkComponent).getType().name());
                    }
                }
            });
            tvQuantity.setText(Integer.toString(quantity));
            ivAdd.setImageResource(R.drawable.ic_menu_add);
            ivAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    incrementable.onIncrement();
                    tvQuantity.setText(Integer.toString(incrementable.getQuantity()));

                    if (drinkComponent instanceof Shot) {
                        tvName.setText(((Shot) drinkComponent).getType().name());
                    } else if (drinkComponent instanceof AffogatoShot) {
                        tvName.setText(((AffogatoShot) drinkComponent).getType().name());
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
