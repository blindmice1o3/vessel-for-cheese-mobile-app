package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem_to_cart.menuitem;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.jackingaming.vesselforcheesemobileapp.R;

public class ChangedUserCustomizationsDialogFragment extends DialogFragment {
    public static final String TAG = ChangedUserCustomizationsDialogFragment.class.getSimpleName();
//    private static final String ARG_TITLE = "com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem_to_cart.menuitem.title";
//    private static final String ARG_MESSAGE = "com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem_to_cart.menuitem.message";

    public ChangedUserCustomizationsDialogFragment() {
    }

    public static ChangedUserCustomizationsDialogFragment newInstance() {
        ChangedUserCustomizationsDialogFragment fragment = new ChangedUserCustomizationsDialogFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_TITLE, title);
//        args.putString(ARG_MESSAGE, message);
//        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new AlertDialog.Builder(getContext())
                .setTitle(R.string.dialog_title_drink_size_changed)
                .setMessage(R.string.dialog_message_drink_size_changed)
                .setPositiveButton(R.string.dialog_positive_button_drink_size_changed, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (dialogInterface != null && ((Dialog) dialogInterface).isShowing()) {
                            dialogInterface.dismiss();
                        }
                    }
                })
                .create();
    }
}
