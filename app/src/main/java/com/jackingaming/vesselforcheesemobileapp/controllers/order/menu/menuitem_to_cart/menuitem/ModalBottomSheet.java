package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem_to_cart.menuitem;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.jackingaming.vesselforcheesemobileapp.R;

public class ModalBottomSheet extends BottomSheetDialogFragment {
    public static final String TAG = ModalBottomSheet.class.getSimpleName();
    public static final String REQUEST_KEY = "com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem_to_cart.menuitem.Key";
    public static final String KEY_RESULT = "com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem_to_cart.menuitem.Result";

    private static final String ARG_NAMES = "com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem_to_cart.menuitem.Names";
    private static final String ARG_NAME_DEFAULT = "com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem_to_cart.menuitem.NameDefault";

    private String[] names;
    private String nameDefault;

    public static ModalBottomSheet newInstance(String[] names, String nameDefault) {
        ModalBottomSheet modalBottomSheet = new ModalBottomSheet();
        Bundle args = new Bundle();
        args.putStringArray(ARG_NAMES, names);
        args.putString(ARG_NAME_DEFAULT, nameDefault);
        ModalBottomSheet fragment = new ModalBottomSheet();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate()");
        if (getArguments() != null) {
            names = getArguments().getStringArray(ARG_NAMES);
            nameDefault = getArguments().getString(ARG_NAME_DEFAULT);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView()");
        return inflater.inflate(R.layout.bottom_sheet_content, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "onViewCreated()");
        RecyclerView rvContent = view.findViewById(R.id.rv_content);
        NamesAdapter adapter = new NamesAdapter(names, nameDefault, new NamesAdapter.NamesAdapterListener() {
            @Override
            public void onItemClicked(int position, View view) {
                Toast.makeText(getContext(), "onItemClicked() position: " + position, Toast.LENGTH_SHORT).show();

                Bundle result = new Bundle();
                result.putString(KEY_RESULT, names[position]);
                getParentFragmentManager().setFragmentResult(REQUEST_KEY, result);

                dismiss();
            }

            @Override
            public void onItemLongClicked(int position, View view) {
                Toast.makeText(getContext(), "onItemLongClicked() position: " + position, Toast.LENGTH_SHORT).show();
            }
        });
        rvContent.setAdapter(adapter);
        rvContent.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onCancel(@NonNull DialogInterface dialog) {
        super.onCancel(dialog);
        Log.i(TAG, "onCancel()");
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);
        Log.i(TAG, "onDismiss()");
    }
}
