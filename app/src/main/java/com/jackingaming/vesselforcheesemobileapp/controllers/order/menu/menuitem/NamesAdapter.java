package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NamesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = NamesAdapter.class.getSimpleName();

    public interface NamesAdapterListener {
        void onItemClicked(int position, View view);

        void onItemLongClicked(int position, View view);
    }

    private String[] names;
    private NamesAdapterListener listener;

    public NamesAdapter(String[] names, NamesAdapterListener listener) {
        this.names = names;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_spinner_dropdown_item, parent, false);
        return new NameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((NameViewHolder) holder).bind(names[position]);
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    class NameViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {
        private TextView tvName;

        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(android.R.id.text1);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void bind(String name) {
            tvName.setText(name);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition(); // gets item position
            Log.i(TAG, "item in RV clicked! position: " + position);
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                if (listener != null) {
                    listener.onItemClicked(position, view);
                }
            }
        }

        @Override
        public boolean onLongClick(View view) {
            int position = getAdapterPosition(); // gets item position
            Log.i(TAG, "item in RV long-clicked! position: " + position);
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                if (listener != null) {
                    listener.onItemLongClicked(position, view);
                    return true;
                }
            }
            return false;
        }
    }
}
