package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.components.drinks.espresso_options.EspressoOptions;

public class QuantifiableArrayAdapter extends ArrayAdapter<EspressoOptions.Shot> {
    public QuantifiableArrayAdapter(@NonNull Context context, int resource, @NonNull EspressoOptions.Shot[] shots) {
        super(context, 0, shots);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        EspressoOptions.Shot shot = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_item_quantifiable, parent, false);
        }

        TextView tvName = convertView.findViewById(R.id.tv_name);
        tvName.setText(EspressoOptions.Shot.class.getSimpleName());

        ImageButton imageButtonStart = convertView.findViewById(R.id.imagebutton_start);
        imageButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "start button", Toast.LENGTH_SHORT).show();
            }
        });

        TextView tvQuantity = convertView.findViewById(R.id.tv_quantity);
        tvQuantity.setText(shot.name());

        ImageButton imageButtonEnd = convertView.findViewById(R.id.imagebutton_end);
        imageButtonEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "end button", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }
}
