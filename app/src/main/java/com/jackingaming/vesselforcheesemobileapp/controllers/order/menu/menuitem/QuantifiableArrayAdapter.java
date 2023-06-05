package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
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
    public static final String TAG = QuantifiableArrayAdapter.class.getSimpleName();

    public QuantifiableArrayAdapter(@NonNull Context context, int resource, @NonNull EspressoOptions.Shot[] shots) {
        super(context, 0, shots);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_item_quantifiable, parent, false);
        }
        EspressoOptions.Shot shot = getItem(position);

        TextView tvName = convertView.findViewById(R.id.tv_name);
        tvName.setText(EspressoOptions.Shot.class.getSimpleName());

        TextView tvQuantity = convertView.findViewById(R.id.tv_quantity);
        tvQuantity.setText(shot.name());

        ImageButton imageButtonStart = convertView.findViewById(R.id.imagebutton_start);
        imageButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "start button", Toast.LENGTH_SHORT).show();
                TextView tvQuantity = ((Activity) view.getContext()).findViewById(R.id.tv_quantity);
                String nameShot = tvQuantity.getText().toString();
                int sizeEnumValues = EspressoOptions.Shot.values().length;
                for (int i = 0; i < sizeEnumValues; i++) {
                    if (nameShot.equals(EspressoOptions.Shot.values()[i].name())) {
                        int indexDesired = --i;
                        if (indexDesired < 0) {
                            indexDesired = sizeEnumValues - 1;
                        }
                        EspressoOptions.Shot shotDesired = EspressoOptions.Shot.values()[indexDesired];
                        tvQuantity.setText(shotDesired.name());
                        return;
                    }
                }
            }
        });

        ImageButton imageButtonEnd = convertView.findViewById(R.id.imagebutton_end);
        imageButtonEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "end button", Toast.LENGTH_SHORT).show();
                TextView tvQuantity = ((Activity) view.getContext()).findViewById(R.id.tv_quantity);
                String nameShot = tvQuantity.getText().toString();
                int sizeEnumValues = EspressoOptions.Shot.values().length;
                for (int i = 0; i < sizeEnumValues; i++) {
                    if (nameShot.equals(EspressoOptions.Shot.values()[i].name())) {
                        int indexDesired = ++i;
                        if (indexDesired >= sizeEnumValues) {
                            indexDesired = 0;
                        }
                        EspressoOptions.Shot shotDesired = EspressoOptions.Shot.values()[indexDesired];
                        tvQuantity.setText(shotDesired.name());
                        return;
                    }
                }
            }
        });

        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_spinner_dropdown_item, parent, false);
        }
        EspressoOptions.Shot shot = getItem(position);

        TextView tvName = convertView.findViewById(android.R.id.text1);
        tvName.setText(shot.name());

        return convertView;
    }
}
