package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.category_to_menuitem.category;

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
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.category_to_menuitem.topic.MenuItemAdapter;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.category_to_menuitem.topic.TopicAsNestedListActivity;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.menuitem_to_cart.menuitem.MenuItemActivity;
import com.jackingaming.vesselforcheesemobileapp.models.menu.Menu;
import com.jackingaming.vesselforcheesemobileapp.models.menu.hierarchy.Section;
import com.jackingaming.vesselforcheesemobileapp.models.menu.hierarchy.Topic;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class TopicToMenuItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = TopicToMenuItemAdapter.class.getSimpleName();

    public interface TopicToMenuItemAdapterListener {
        void onItemClicked(View view, Topic topicSelected);

        void onItemLongClicked(View view, Topic topicSelected);
    }

    private List<Topic> topics;
    private TopicToMenuItemAdapterListener listener;

    public TopicToMenuItemAdapter(List<Topic> topics, TopicToMenuItemAdapterListener listener) {
        this.topics = topics;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder()");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_topic_to_menu_item, parent, false);
        return new ViewHolderTopicToMenuItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder()");
        Topic topic = topics.get(position);
        ViewHolderTopicToMenuItem viewHolderTopicToMenuItem = (ViewHolderTopicToMenuItem) holder;
        viewHolderTopicToMenuItem.bind(topic);
    }

    @Override
    public int getItemCount() {
        Log.i(TAG, "onItemCount() topics.size(): " + topics.size());
        return topics.size();
    }

    class ViewHolderTopicToMenuItem extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {
        private TextView tvName;
        private TextView tvSeeAll;
        private RecyclerView rvMenuItem;

        public ViewHolderTopicToMenuItem(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvSeeAll = itemView.findViewById(R.id.tv_see_all);
            rvMenuItem = itemView.findViewById(R.id.rv_menu_item);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void bind(Topic topic) {
            List<MenuItem> menuItemsFromTopic = new ArrayList<>();
            List<Section> sections = topic.getSections();
            for (Section section : sections) {
                menuItemsFromTopic.addAll(
                        section.getMenuItems()
                );
            }

            tvName.setText(topic.getName());
            tvSeeAll.setText("See all " + menuItemsFromTopic.size());
            tvSeeAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // TODO:
                    if (topic.getName().equals(Menu.OILEETO)) {
                        Log.i(TAG, "topic.getName().equals(Menu.OILEETO) ---> launch SectionAsGridActivity");

                        Section sectionSelected = topic.getSections().get(0);
                        Intent intent = new Intent(view.getContext(), SectionAsGridActivity.class);
                        intent.putExtra(SectionAsGridActivity.EXTRA_SECTION_SELECTED, sectionSelected);
                        view.getContext().startActivity(intent);
                    } else {
                        Log.i(TAG, "NOT topic.getName().equals(Menu.OILEETO) ---> launch TopicActivity");

                        Intent intent = new Intent(view.getContext(), TopicAsNestedListActivity.class);
                        intent.putExtra(TopicAsNestedListActivity.EXTRA_TOPIC_SELECTED, topic);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        view.getContext().startActivity(intent);
                    }
                }
            });

            MenuItemAdapter adapter = new MenuItemAdapter(menuItemsFromTopic, new MenuItemAdapter.MenuItemAdapterListener() {
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
                    Topic topicSelected = topics.get(position);
                    listener.onItemClicked(view, topicSelected);
                }
            }
        }

        @Override
        public boolean onLongClick(View view) {
            int position = getAdapterPosition(); // gets item position
            Log.i(TAG, "item in RV long-clicked! position: " + position);
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                if (listener != null) {
                    Topic topicSelected = topics.get(position);
                    listener.onItemLongClicked(view, topicSelected);
                    return true;
                }
            }
            return false;
        }
    }
}
