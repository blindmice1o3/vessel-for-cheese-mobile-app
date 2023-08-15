package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.category_to_menuitem.topic;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.category_to_menuitem.section.SectionAsGridActivity;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem_to_cart.menuitem.MenuItemActivity;
import com.jackingaming.vesselforcheesemobileapp.models.menu.hierarchy.Section;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.MenuItem;

import java.util.List;

public class SectionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = SectionAdapter.class.getSimpleName();

    public interface SectionAdapterListener {
        void onItemClicked(View view, Section sectionSelected);

        void onItemLongClicked(View view, Section sectionSelected);
    }

    private List<Section> sections;
    private SectionAdapterListener listener;

    public SectionAdapter(List<Section> sections, SectionAdapterListener listener) {
        this.sections = sections;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder()");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_section, parent, false);
        return new ViewHolderSection(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder()");
        Section section = sections.get(position);
        ViewHolderSection viewHolderSection = (ViewHolderSection) holder;
        viewHolderSection.bind(section);
    }

    @Override
    public int getItemCount() {
        Log.i(TAG, "onItemCount() sections.size(): " + sections.size());
        return sections.size();
    }

    class ViewHolderSection extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {
        private TextView tvName;
        private TextView tvSeeAll;
        private RecyclerView rvMenuItem;

        public ViewHolderSection(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvSeeAll = itemView.findViewById(R.id.tv_see_all);
            rvMenuItem = itemView.findViewById(R.id.rv_menu_item);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void bind(Section section) {
            List<MenuItem> menuItems = section.getMenuItems();

            tvName.setText(section.getName());
            tvSeeAll.setText("See all " + menuItems.size());
            tvSeeAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), SectionAsGridActivity.class);
                    intent.putExtra(SectionAsGridActivity.EXTRA_SECTION_SELECTED, section);
                    view.getContext().startActivity(intent);
                }
            });

            MenuItemAdapter adapter = new MenuItemAdapter(menuItems, new MenuItemAdapter.MenuItemAdapterListener() {
                @Override
                public void onItemClicked(View view, MenuItem menuItemSelected) {
                    Log.i(TAG, "onItemClicked(View, MenuItem) menuItemSelected: " + menuItemSelected.getName());
                    Intent intent = new Intent(view.getContext(), MenuItemActivity.class);
                    intent.putExtra(MenuItemActivity.EXTRA_MENU_ITEM_SELECTED, menuItemSelected);
                    view.getContext().startActivity(intent);
                }

                @Override
                public void onItemLongClicked(View view, MenuItem menuItemSelected) {
                    Log.i(TAG, "onItemLongClicked(View, MenuItem) menuItemSelected: " + menuItemSelected.getName());
                    // TODO:
                }
            });

            rvMenuItem.setAdapter(adapter);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rvMenuItem.getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            rvMenuItem.setLayoutManager(linearLayoutManager);
            rvMenuItem.setNestedScrollingEnabled(false);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition(); // gets item position
            Log.i(TAG, "item in RV clicked! position: " + position);
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                if (listener != null) {
                    Section sectionSelected = sections.get(position);
                    listener.onItemClicked(view, sectionSelected);
                }
            }
        }

        @Override
        public boolean onLongClick(View view) {
            int position = getAdapterPosition(); // gets item position
            Log.i(TAG, "item in RV long-clicked! position: " + position);
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                if (listener != null) {
                    Section sectionSelected = sections.get(position);
                    listener.onItemLongClicked(view, sectionSelected);
                    return true;
                }
            }
            return false;
        }
    }
}
