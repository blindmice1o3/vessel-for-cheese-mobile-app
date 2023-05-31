package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.jackingaming.vesselforcheesemobileapp.R;

public class ModalBottomSheet extends BottomSheetDialogFragment {
    public static final String TAG = ModalBottomSheet.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView()");
        return inflater.inflate(R.layout.bottom_sheet_content, container, false);
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
