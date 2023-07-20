package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.customize;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.DrinkComponentBaseAdapter;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.ModalBottomSheet;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.menu.Menu;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.Drink;
import com.jackingaming.vesselforcheesemobileapp.views.CircularBorderedImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomizeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = CustomizeAdapter.class.getSimpleName();
    public static final int VIEW_TYPE_TOP_BANNER = 0;
    public static final int VIEW_TYPE_DRINK_COMPONENT_GROUP = 1;
    public static final int VIEW_TYPE_DONE_CUSTOMIZING_BUTTON = 2;
    public static final String IDENTIFIER_TOP_BANNER = "top-banner";
    public static final String IDENTIFIER_DONE_CUSTOMIZING_BUTTON = "done-customizing-button";

    private AppCompatActivity activity;
    private Drink drink;

    private List<DrinkComponent> drinkComponentsStandardRecipe;
    private List<DrinkComponentDetails> dataProcessed = new ArrayList<>();

    private Map<String, DrinkComponentBaseAdapter> adapterSelected = new HashMap<>();
    private String keyGroupSelected;

    public CustomizeAdapter(AppCompatActivity activity, Drink drink) {
        this.activity = activity;
        this.drink = drink;

        Map<String, List<DrinkComponent>> drinkComponentGroups = drink.getDrinkComponents();
        Map<String, List<String>> drinkComponentGroupsDefaultAsString = drink.getDrinkComponentsDefaultAsString();
        drinkComponentsStandardRecipe = drink.getDrinkComponentsStandardRecipe();

        for (int i = 0; i < Menu.DRINK_COMPONENTS_KEYS.size(); i++) {
            String key = Menu.DRINK_COMPONENTS_KEYS.get(i);
            Log.d(TAG, i + ": " + Menu.DRINK_COMPONENTS_KEYS.get(i));
            if (drinkComponentGroups.containsKey(key)) {
                List<String> typesDefault = drinkComponentGroupsDefaultAsString.get(key);
                List<DrinkComponent> types = drinkComponentGroups.get(key);

                dataProcessed.add(new DrinkComponentDetails(key, typesDefault, types));
            }
        }
        // Add DUMMY DrinkComponentDetails to the START of list
        dataProcessed.add(0, new DrinkComponentDetails(IDENTIFIER_TOP_BANNER, null, null));
        // Add DUMMY DrinkComponentDetails to the END of list
        dataProcessed.add(dataProcessed.size(), new DrinkComponentDetails(IDENTIFIER_DONE_CUSTOMIZING_BUTTON, null, null));
    }

    @Override
    public int getItemViewType(int position) {
        DrinkComponentDetails drinkComponentDetails = dataProcessed.get(position);

        if (drinkComponentDetails.getKeyGroup().equals(IDENTIFIER_TOP_BANNER)) {
            return VIEW_TYPE_TOP_BANNER;
        } else if (drinkComponentDetails.getKeyGroup().equals(IDENTIFIER_DONE_CUSTOMIZING_BUTTON)) {
            return VIEW_TYPE_DONE_CUSTOMIZING_BUTTON;
        } else {
            return VIEW_TYPE_DRINK_COMPONENT_GROUP;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_TOP_BANNER:
                View viewTopBanner = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_customize_topbanner, parent, false);
                return new TopBannerViewHolder(viewTopBanner);
            case VIEW_TYPE_DRINK_COMPONENT_GROUP:
                View viewDrinkComponentGroup = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_customize_drinkcomponentgroup, parent, false);
                return new DrinkComponentGroupViewHolder(viewDrinkComponentGroup);
            case VIEW_TYPE_DONE_CUSTOMIZING_BUTTON:
                View viewDoneCustomizingButton = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_customize_donecustomizingbutton, parent, false);
                return new DoneCustomizingButtonViewHolder(viewDoneCustomizingButton);
            default:
                Log.e(TAG, "onCreateViewHolder() switch(viewType) default case");
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_customize_drinkcomponentgroup, parent, false);
                return new DrinkComponentGroupViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TopBannerViewHolder) {
            ((TopBannerViewHolder) holder).bind(drink);
        } else if (holder instanceof DrinkComponentGroupViewHolder) {
            String keyGroup = dataProcessed.get(position).getKeyGroup();
            List<String> drinkComponentsDefault = dataProcessed.get(position).getDrinkComponentsDefault();
            List<DrinkComponent> drinkComponents = dataProcessed.get(position).getDrinkComponents();

            ((DrinkComponentGroupViewHolder) holder).bind(
                    keyGroup,
                    drinkComponents,
                    drinkComponentsDefault);
        } else if (holder instanceof DoneCustomizingButtonViewHolder) {
            ((DoneCustomizingButtonViewHolder) holder).bind();
        } else {
            Log.e(TAG, "onBindViewHolder() else-clause");
        }
    }

    @Override
    public int getItemCount() {
        return dataProcessed.size();
    }

    class DrinkComponentGroupViewHolder extends RecyclerView.ViewHolder {

        private TextView tvClassNameDrinkComponent;
        private RecyclerView rvCustomize;

        public DrinkComponentGroupViewHolder(@NonNull View itemView) {
            super(itemView);
            tvClassNameDrinkComponent = itemView.findViewById(R.id.tv_class_name_drink_component);
            rvCustomize = itemView.findViewById(R.id.rv_customize);
        }

        public void bind(String keyGroup, List<DrinkComponent> drinkComponents, List<String> drinkComponentsDefault) {
            tvClassNameDrinkComponent.setText((keyGroup));

            CustomizeInnerAdapter adapter = new CustomizeInnerAdapter(
                    drinkComponents,
                    drinkComponentsDefault,
                    drinkComponentsStandardRecipe,
                    new DrinkComponentBaseAdapter.DrinkComponentBaseAdapterListener() {
                        @Override
                        public void onItemClicked(String[] names, String nameDefault) {
                            Log.i(TAG, "onItemClicked(String[] names, String nameDefault)");

                            keyGroupSelected = keyGroup;

                            ModalBottomSheet.newInstance(names, nameDefault).show(activity.getSupportFragmentManager(), ModalBottomSheet.TAG);
                        }

                        @Override
                        public void onItemLongClicked(String[] names, String nameDefault) {
                            Log.i(TAG, "onItemLongClicked(String[] names, String nameDefault)");
                        }
                    });
            adapterSelected.put(keyGroup, adapter);

            rvCustomize.setAdapter(adapter);
            rvCustomize.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
            activity.getSupportFragmentManager().setFragmentResultListener(ModalBottomSheet.REQUEST_KEY, activity, new FragmentResultListener() {
                @Override
                public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                    if (requestKey.equals(ModalBottomSheet.REQUEST_KEY)) {
                        String name = result.getString(ModalBottomSheet.KEY_RESULT);

                        adapterSelected.get(keyGroupSelected).updateDrinkComponentByString(name);
                    }
                }
            });
        }
    }

    class TopBannerViewHolder extends RecyclerView.ViewHolder {

        private CircularBorderedImageView ivThumbnail;
        private TextView tvName;
        private TextView tvSize;

        public TopBannerViewHolder(@NonNull View itemView) {
            super(itemView);
            ivThumbnail = itemView.findViewById(R.id.iv_thumbnail);
            tvName = itemView.findViewById(R.id.tv_name);
            tvSize = itemView.findViewById(R.id.tv_size);
        }

        public void bind(Drink drink) {
            // TODO: instead of hard-coded datasource for ivThumbnail, use from Drink.

            tvName.setText(drink.getName());

            String templateString = "%s %d fl oz";
            tvSize.setText(
                    String.format(templateString,
                            drink.getDrinkSize().getUserFriendlyName(),
                            drink.getDrinkSize().getSizeInFlOz())
            );
        }
    }

    class DoneCustomizingButtonViewHolder extends RecyclerView.ViewHolder {

        private Button buttonDoneCustomizing;

        public DoneCustomizingButtonViewHolder(@NonNull View itemView) {
            super(itemView);
            buttonDoneCustomizing = itemView.findViewById(R.id.button_done_customizing);
            buttonDoneCustomizing.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i(TAG, "buttonDoneCustomizing clicked");

                    Intent result = new Intent();
                    result.putExtra(((CustomizeActivity) activity).RESULT_KEY, drink);
                    ((CustomizeActivity) activity).setResult(((CustomizeActivity) activity).RESULT_OK, result);
                    ((CustomizeActivity) activity).finish();
                }
            });
        }

        public void bind() {
            // intentionally blank
        }
    }
}
