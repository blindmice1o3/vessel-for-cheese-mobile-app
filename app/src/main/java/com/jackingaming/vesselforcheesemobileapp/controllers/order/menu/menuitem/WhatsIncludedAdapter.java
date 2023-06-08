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
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.EspressoOptions;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.milk_options.MilkOptions;

import java.util.List;

public class WhatsIncludedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = WhatsIncludedAdapter.class.getSimpleName();

    private static final int VIEW_TYPE_ERROR = -1;

    private static final int VIEW_TYPE_MILK_BASE = 0;
    private static final int VIEW_TYPE_TEMPERATURE = 1;
    private static final int VIEW_TYPE_MILK_FOAM = 2;
    private static final int VIEW_TYPE_CAPPUCCINO_FOAM = 3;

    private static final int VIEW_TYPE_SHOT = 4;
    private static final int VIEW_TYPE_AFFOGATO_SHOT = 5;
    private static final int VIEW_TYPE_ROAST_OPTIONS = 6;
    private static final int VIEW_TYPE_PREP_OPTIONS = 7;
    private static final int VIEW_TYPE_PULL_OPTIONS = 8;
    private static final int VIEW_TYPE_SIZE_OPTIONS = 9;

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
        if (drinkComponent instanceof MilkOptions) {
            Log.i(TAG, "drinkComponent instanceof MilkOptions");

            MilkOptions milkOptions = (MilkOptions) drinkComponent;
            if (milkOptions.getMilkBase() != null) {
                return VIEW_TYPE_MILK_BASE;
            } else if (milkOptions.getTemperature() != null) {
                return VIEW_TYPE_TEMPERATURE;
            } else if (milkOptions.getMilkFoam() != null) {
                return VIEW_TYPE_MILK_FOAM;
            } else if (milkOptions.getCappuccinoFoam() != null) {
                return VIEW_TYPE_CAPPUCCINO_FOAM;
            } else {
                Log.e(TAG, "MilkOptions else-clause");
                return VIEW_TYPE_ERROR;
            }
        } else if (drinkComponent instanceof EspressoOptions) {
            Log.i(TAG, "drinkComponent instanceof EspressoOptions");

            EspressoOptions espressoOptions = (EspressoOptions) drinkComponent;
            if (espressoOptions.getShot() != null) {
                return VIEW_TYPE_SHOT;
            } else if (espressoOptions.getAffogatoShot() != null) {
                return VIEW_TYPE_AFFOGATO_SHOT;
            } else if (espressoOptions.getRoastOptions() != null) {
                return VIEW_TYPE_ROAST_OPTIONS;
            } else if (espressoOptions.getPrepOptions() != null) {
                return VIEW_TYPE_PREP_OPTIONS;
            } else if (espressoOptions.getPullOptions() != null) {
                return VIEW_TYPE_PULL_OPTIONS;
            } else if (espressoOptions.getSizeOptions() != null) {
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
            case VIEW_TYPE_SHOT:
            case VIEW_TYPE_AFFOGATO_SHOT:
                View viewIncrementalDrinkComponent = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_drink_component_incremental, parent, false);
                return new DrinkComponentIncrementalViewHolder(viewIncrementalDrinkComponent);
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
        } else if (holder instanceof DrinkComponentIncrementalViewHolder) {
            ((DrinkComponentIncrementalViewHolder) holder).bind(viewType, drinkComponent);
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
            int imageResource = R.drawable.ic_coins_s;

            int numberOfEnums = 0;
            switch (viewType) {
                case VIEW_TYPE_MILK_BASE:
                    titleBorder = MilkOptions.MilkBase.class.getSimpleName();
                    name = ((MilkOptions) drinkComponent).getMilkBase().name();

                    numberOfEnums = MilkOptions.MilkBase.values().length;
                    enumsAsString = new String[numberOfEnums];
                    for (int i = 0; i < numberOfEnums; i++) {
                        enumsAsString[i] = MilkOptions.MilkBase.values()[i].name();
                    }
                    break;
                case VIEW_TYPE_TEMPERATURE:
                    titleBorder = MilkOptions.Temperature.class.getSimpleName();
                    name = ((MilkOptions) drinkComponent).getTemperature().name();

                    numberOfEnums = MilkOptions.Temperature.values().length;
                    enumsAsString = new String[numberOfEnums];
                    for (int i = 0; i < numberOfEnums; i++) {
                        enumsAsString[i] = MilkOptions.Temperature.values()[i].name();
                    }
                    break;
                case VIEW_TYPE_MILK_FOAM:
                    titleBorder = MilkOptions.MilkFoam.class.getSimpleName();
                    name = ((MilkOptions) drinkComponent).getMilkFoam().name();

                    numberOfEnums = MilkOptions.MilkFoam.values().length;
                    enumsAsString = new String[numberOfEnums];
                    for (int i = 0; i < numberOfEnums; i++) {
                        enumsAsString[i] = MilkOptions.MilkFoam.values()[i].name();
                    }
                    break;
                case VIEW_TYPE_CAPPUCCINO_FOAM:
                    titleBorder = MilkOptions.CappuccinoFoam.class.getSimpleName();
                    name = ((MilkOptions) drinkComponent).getCappuccinoFoam().name();

                    numberOfEnums = MilkOptions.CappuccinoFoam.values().length;
                    enumsAsString = new String[numberOfEnums];
                    for (int i = 0; i < numberOfEnums; i++) {
                        enumsAsString[i] = MilkOptions.CappuccinoFoam.values()[i].name();
                    }
                    break;
                case VIEW_TYPE_SHOT:
                    titleBorder = EspressoOptions.Shot.class.getSimpleName();
                    name = ((EspressoOptions) drinkComponent).getShot().name();

                    numberOfEnums = EspressoOptions.Shot.values().length;
                    enumsAsString = new String[numberOfEnums];
                    for (int i = 0; i < numberOfEnums; i++) {
                        enumsAsString[i] = EspressoOptions.Shot.values()[i].name();
                    }
                    break;
                case VIEW_TYPE_AFFOGATO_SHOT:
                    titleBorder = EspressoOptions.AffogatoShot.class.getSimpleName();
                    name = ((EspressoOptions) drinkComponent).getAffogatoShot().name();

                    numberOfEnums = EspressoOptions.AffogatoShot.values().length;
                    enumsAsString = new String[numberOfEnums];
                    for (int i = 0; i < numberOfEnums; i++) {
                        enumsAsString[i] = EspressoOptions.AffogatoShot.values()[i].name();
                    }
                    break;
                case VIEW_TYPE_ROAST_OPTIONS:
                    titleBorder = EspressoOptions.RoastOptions.class.getSimpleName();
                    name = ((EspressoOptions) drinkComponent).getRoastOptions().name();

                    numberOfEnums = EspressoOptions.RoastOptions.values().length;
                    enumsAsString = new String[numberOfEnums];
                    for (int i = 0; i < numberOfEnums; i++) {
                        enumsAsString[i] = EspressoOptions.RoastOptions.values()[i].name();
                    }
                    break;
                case VIEW_TYPE_PREP_OPTIONS:
                    titleBorder = EspressoOptions.PrepOptions.class.getSimpleName();
                    name = ((EspressoOptions) drinkComponent).getPrepOptions().name();

                    numberOfEnums = EspressoOptions.PrepOptions.values().length;
                    enumsAsString = new String[numberOfEnums];
                    for (int i = 0; i < numberOfEnums; i++) {
                        enumsAsString[i] = EspressoOptions.PrepOptions.values()[i].name();
                    }
                    break;
                case VIEW_TYPE_PULL_OPTIONS:
                    titleBorder = EspressoOptions.PullOptions.class.getSimpleName();
                    name = ((EspressoOptions) drinkComponent).getPullOptions().name();

                    numberOfEnums = EspressoOptions.PullOptions.values().length;
                    enumsAsString = new String[numberOfEnums];
                    for (int i = 0; i < numberOfEnums; i++) {
                        enumsAsString[i] = EspressoOptions.PullOptions.values()[i].name();
                    }
                    break;
                case VIEW_TYPE_SIZE_OPTIONS:
                    titleBorder = EspressoOptions.SizeOptions.class.getSimpleName();
                    name = ((EspressoOptions) drinkComponent).getSizeOptions().name();

                    numberOfEnums = EspressoOptions.SizeOptions.values().length;
                    enumsAsString = new String[numberOfEnums];
                    for (int i = 0; i < numberOfEnums; i++) {
                        enumsAsString[i] = EspressoOptions.SizeOptions.values()[i].name();
                    }
                    break;
                default:
                    titleBorder = "error";
                    name = "default";
                    enumsAsString = new String[]{""};
                    Log.e(TAG, "DrinkComponentViewHolder.bind() switch(viewType) default block");
                    break;
            }
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

    class DrinkComponentIncrementalViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {

        //        private TextView tvBorderTitle;
//        private TextView tvName;
//        private ImageView ivDecrement;
//        private TextView tvValue;
//        private ImageView ivIncrement;
        private TextView tvBorderTitle;
        private TextView tvName;
        private ImageView ivDropDownImage;

        private String[] enumsAsString;

        public DrinkComponentIncrementalViewHolder(@NonNull View itemView) {
            super(itemView);
            // TODO:
            tvBorderTitle = itemView.findViewById(R.id.tv_border_title);
            tvName = itemView.findViewById(R.id.tv_name);
            ivDropDownImage = itemView.findViewById(R.id.iv_drop_down_image);
//            tvBorderTitle = ;
//            tvName = ;
//            ivDecrement = ;
//            tvValue = ;
//            ivIncrement = ;
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void bind(int viewType, DrinkComponent drinkComponent) {
            String titleBorder = null;
            String name = null;
            int imageResource = R.drawable.ic_coins_s;

            int numberOfEnums = 0;
            switch (viewType) {
                case VIEW_TYPE_MILK_BASE:
                    titleBorder = MilkOptions.MilkBase.class.getSimpleName();
                    name = ((MilkOptions) drinkComponent).getMilkBase().name();

                    numberOfEnums = MilkOptions.MilkBase.values().length;
                    enumsAsString = new String[numberOfEnums];
                    for (int i = 0; i < numberOfEnums; i++) {
                        enumsAsString[i] = MilkOptions.MilkBase.values()[i].name();
                    }
                    break;
                case VIEW_TYPE_TEMPERATURE:
                    titleBorder = MilkOptions.Temperature.class.getSimpleName();
                    name = ((MilkOptions) drinkComponent).getTemperature().name();

                    numberOfEnums = MilkOptions.Temperature.values().length;
                    enumsAsString = new String[numberOfEnums];
                    for (int i = 0; i < numberOfEnums; i++) {
                        enumsAsString[i] = MilkOptions.Temperature.values()[i].name();
                    }
                    break;
                case VIEW_TYPE_MILK_FOAM:
                    titleBorder = MilkOptions.MilkFoam.class.getSimpleName();
                    name = ((MilkOptions) drinkComponent).getMilkFoam().name();

                    numberOfEnums = MilkOptions.MilkFoam.values().length;
                    enumsAsString = new String[numberOfEnums];
                    for (int i = 0; i < numberOfEnums; i++) {
                        enumsAsString[i] = MilkOptions.MilkFoam.values()[i].name();
                    }
                    break;
                case VIEW_TYPE_CAPPUCCINO_FOAM:
                    titleBorder = MilkOptions.CappuccinoFoam.class.getSimpleName();
                    name = ((MilkOptions) drinkComponent).getCappuccinoFoam().name();

                    numberOfEnums = MilkOptions.CappuccinoFoam.values().length;
                    enumsAsString = new String[numberOfEnums];
                    for (int i = 0; i < numberOfEnums; i++) {
                        enumsAsString[i] = MilkOptions.CappuccinoFoam.values()[i].name();
                    }
                    break;
                case VIEW_TYPE_SHOT:
                    titleBorder = EspressoOptions.Shot.class.getSimpleName();
                    name = ((EspressoOptions) drinkComponent).getShot().name();

                    numberOfEnums = EspressoOptions.Shot.values().length;
                    enumsAsString = new String[numberOfEnums];
                    for (int i = 0; i < numberOfEnums; i++) {
                        enumsAsString[i] = EspressoOptions.Shot.values()[i].name();
                    }
                    break;
                case VIEW_TYPE_AFFOGATO_SHOT:
                    titleBorder = EspressoOptions.AffogatoShot.class.getSimpleName();
                    name = ((EspressoOptions) drinkComponent).getAffogatoShot().name();

                    numberOfEnums = EspressoOptions.AffogatoShot.values().length;
                    enumsAsString = new String[numberOfEnums];
                    for (int i = 0; i < numberOfEnums; i++) {
                        enumsAsString[i] = EspressoOptions.AffogatoShot.values()[i].name();
                    }
                    break;
                case VIEW_TYPE_ROAST_OPTIONS:
                    titleBorder = EspressoOptions.RoastOptions.class.getSimpleName();
                    name = ((EspressoOptions) drinkComponent).getRoastOptions().name();

                    numberOfEnums = EspressoOptions.RoastOptions.values().length;
                    enumsAsString = new String[numberOfEnums];
                    for (int i = 0; i < numberOfEnums; i++) {
                        enumsAsString[i] = EspressoOptions.RoastOptions.values()[i].name();
                    }
                    break;
                case VIEW_TYPE_PREP_OPTIONS:
                    titleBorder = EspressoOptions.PrepOptions.class.getSimpleName();
                    name = ((EspressoOptions) drinkComponent).getPrepOptions().name();

                    numberOfEnums = EspressoOptions.PrepOptions.values().length;
                    enumsAsString = new String[numberOfEnums];
                    for (int i = 0; i < numberOfEnums; i++) {
                        enumsAsString[i] = EspressoOptions.PrepOptions.values()[i].name();
                    }
                    break;
                case VIEW_TYPE_PULL_OPTIONS:
                    titleBorder = EspressoOptions.PullOptions.class.getSimpleName();
                    name = ((EspressoOptions) drinkComponent).getPullOptions().name();

                    numberOfEnums = EspressoOptions.PullOptions.values().length;
                    enumsAsString = new String[numberOfEnums];
                    for (int i = 0; i < numberOfEnums; i++) {
                        enumsAsString[i] = EspressoOptions.PullOptions.values()[i].name();
                    }
                    break;
                case VIEW_TYPE_SIZE_OPTIONS:
                    titleBorder = EspressoOptions.SizeOptions.class.getSimpleName();
                    name = ((EspressoOptions) drinkComponent).getSizeOptions().name();

                    numberOfEnums = EspressoOptions.SizeOptions.values().length;
                    enumsAsString = new String[numberOfEnums];
                    for (int i = 0; i < numberOfEnums; i++) {
                        enumsAsString[i] = EspressoOptions.SizeOptions.values()[i].name();
                    }
                    break;
                default:
                    titleBorder = "error";
                    name = "default";
                    enumsAsString = new String[]{""};
                    Log.e(TAG, "DrinkComponentViewHolder.bind() switch(viewType) default block");
                    break;
            }
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
}
