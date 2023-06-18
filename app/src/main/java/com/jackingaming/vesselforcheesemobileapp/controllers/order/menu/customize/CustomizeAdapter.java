package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.customize;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.ModalBottomSheet;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem.WhatsIncludedAdapter;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.DrinkComponent;
import com.jackingaming.vesselforcheesemobileapp.models.menu.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomizeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = CustomizeAdapter.class.getSimpleName();

    private AppCompatActivity activity;
    private Map<String, List<DrinkComponent>> drinkComponents;
    private Map<String, List<String>> drinkComponentsDefault;
    private List<Pair<List<String>, List<DrinkComponent>>> dataProcessed = new ArrayList<>();

    public CustomizeAdapter(AppCompatActivity activity, Map<String, List<DrinkComponent>> drinkComponents, Map<String, List<String>> drinkComponentsDefault) {
        this.activity = activity;
        this.drinkComponents = drinkComponents;
        this.drinkComponentsDefault = drinkComponentsDefault;

        for (int i = 0; i < Menu.DRINK_COMPONENTS_KEYS.size(); i++) {
            String key = Menu.DRINK_COMPONENTS_KEYS.get(i);
            Log.d(TAG, i + ": " + Menu.DRINK_COMPONENTS_KEYS.get(i));
            if (drinkComponents.containsKey(key)) {
                List<String> typeDefault = drinkComponentsDefault.get(key);
                List<DrinkComponent> type = drinkComponents.get(key);

                dataProcessed.add(new Pair(typeDefault, type));
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
        List<String> drinkComponentsDefault = dataProcessed.get(position).first;
        List<DrinkComponent> drinkComponents = dataProcessed.get(position).second;

        ((DrinkComponentGroupViewHolder) holder).bind(
                "Hard-coded title " + position,
                drinkComponents,
                drinkComponentsDefault);
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "dataProcessed.size(): " + dataProcessed.size());
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

        public void bind(String nameGroup, List<DrinkComponent> drinkComponents, List<String> drinkComponentsDefault) {
            tvClassNameDrinkComponent.setText((nameGroup));

            WhatsIncludedAdapter adapter = new WhatsIncludedAdapter(drinkComponents, drinkComponentsDefault, new WhatsIncludedAdapter.WhatsIncludedAdapterListener() {
                @Override
                public void onItemClicked(String[] names, String nameDefault) {
                    Log.i(TAG, "onItemClicked(String[] names, String nameDefault)");

                    ModalBottomSheet.newInstance(names, nameDefault).show(activity.getSupportFragmentManager(), ModalBottomSheet.TAG);
                }

                @Override
                public void onItemLongClicked(String[] names, String nameDefault) {
                    Log.i(TAG, "onItemLongClicked(String[] names, String nameDefault)");
                }
            });
            rvCustomize.setAdapter(adapter);
            rvCustomize.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
            activity.getSupportFragmentManager().setFragmentResultListener(ModalBottomSheet.REQUEST_KEY, activity, new FragmentResultListener() {
                @Override
                public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                    if (requestKey.equals(ModalBottomSheet.REQUEST_KEY)) {
                        String name = result.getString(ModalBottomSheet.KEY_RESULT);

                        adapter.updateDrinkComponentByString(name);
                    }
                }
            });
        }
    }
}
