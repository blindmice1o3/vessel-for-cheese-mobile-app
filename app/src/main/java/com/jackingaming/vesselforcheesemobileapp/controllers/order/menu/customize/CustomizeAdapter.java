package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.customize;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.ModalBottomSheet;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.WhatsIncludedAdapter;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.menu.Menu;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.drinks.Drink;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomizeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = CustomizeAdapter.class.getSimpleName();

    private AppCompatActivity activity;
    private Drink drink;

    private List<DrinkComponent> drinkComponentsStandardRecipe;
    private List<DrinkComponentDetails> dataProcessed = new ArrayList<>();
    // TODO: track indexSelected
    private Map<String, WhatsIncludedAdapter> adapterSelected = new HashMap<>();
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
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_customize, parent, false);
        return new DrinkComponentGroupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        String keyGroup = dataProcessed.get(position).getKeyGroup();
        List<String> drinkComponentsDefault = dataProcessed.get(position).getDrinkComponentsDefault();
        List<DrinkComponent> drinkComponents = dataProcessed.get(position).getDrinkComponents();

        ((DrinkComponentGroupViewHolder) holder).bind(
                keyGroup,
                drinkComponents,
                drinkComponentsDefault);
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

            WhatsIncludedAdapter adapter = new WhatsIncludedAdapter(
                    drinkComponents,
                    drinkComponentsDefault,
                    drinkComponentsStandardRecipe,
                    new WhatsIncludedAdapter.WhatsIncludedAdapterListener() {
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
}
