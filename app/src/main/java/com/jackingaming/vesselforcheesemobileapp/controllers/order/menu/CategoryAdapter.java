package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu;

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
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.category_to_menuitem.category.CategoryAsNestedListActivity;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.category_to_menuitem.section.SectionAsGridActivity;
import com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.category_to_menuitem.topic.TopicAsNestedListActivity;
import com.jackingaming.vesselforcheesemobileapp.models.menu.Menu;
import com.jackingaming.vesselforcheesemobileapp.models.menu.hierarchy.Category;
import com.jackingaming.vesselforcheesemobileapp.models.menu.hierarchy.Section;
import com.jackingaming.vesselforcheesemobileapp.models.menu.hierarchy.Topic;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.MenuItem;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = CategoryAdapter.class.getSimpleName();

    public interface CategoryAdapterListener {
        void onItemClicked(View view, Category categorySelected);

        void onItemLongClicked(View view, Category categorySelected);
    }

    private List<Category> categories;
    private CategoryAdapterListener listener;

    public CategoryAdapter(List<Category> categories, CategoryAdapterListener listener) {
        this.categories = categories;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder()");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_category, parent, false);
        return new ViewHolderCategory(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder()");
        Category category = categories.get(position);
        ViewHolderCategory viewHolderCategory = (ViewHolderCategory) holder;
        viewHolderCategory.bind(category);
    }

    @Override
    public int getItemCount() {
        Log.i(TAG, "onItemCount() categories.size(): " + categories.size());
        return categories.size();
    }

    class ViewHolderCategory extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {
        private TextView tvName;
        private TextView tvSeeAll;
        private RecyclerView rvTopic;

        public ViewHolderCategory(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvSeeAll = itemView.findViewById(R.id.tv_see_all);
            rvTopic = itemView.findViewById(R.id.rv_topic);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void bind(Category category) {
            int sizeOfList = 0;
            List<Topic> topics = category.getTopics();
            for (Topic topic : topics) {
                List<Section> sections = topic.getSections();
                for (Section section : sections) {
                    List<MenuItem> menuItems = section.getMenuItems();

                    sizeOfList += menuItems.size();
                }
            }
            Log.e(TAG, "number of MenuItem from Category: " + sizeOfList);

            tvName.setText(category.getName());
            tvSeeAll.setText("See all " + sizeOfList);
            tvSeeAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), CategoryAsNestedListActivity.class);
                    intent.putExtra(CategoryAsNestedListActivity.EXTRA_CATEGORY_SELECTED, category);
                    view.getContext().startActivity(intent);
                }
            });

            TopicAdapter adapter = new TopicAdapter(topics, new TopicAdapter.TopicAdapterListener() {
                @Override
                public void onItemClicked(View view, Topic topicSelected) {
                    Log.i(TAG, "onItemClicked(View, Topic) topicSelected: " + topicSelected.getName());

                    // TODO:
                    if (topicSelected.getName().equals(Menu.OILEETO)) {
                        Log.i(TAG, "topicSelected.getName().equals(Menu.OILEETO) ---> launch SectionAsGridActivity");

                        Section sectionSelected = topicSelected.getSections().get(0);
                        Intent intent = new Intent(view.getContext(), SectionAsGridActivity.class);
                        intent.putExtra(SectionAsGridActivity.EXTRA_SECTION_SELECTED, sectionSelected);
                        view.getContext().startActivity(intent);
                    } else {
                        Log.i(TAG, "NOT topicSelected.getName().equals(Menu.OILEETO) ---> launch TopicActivity");

                        Intent intent = new Intent(view.getContext(), TopicAsNestedListActivity.class);
                        intent.putExtra(TopicAsNestedListActivity.EXTRA_TOPIC_SELECTED, topicSelected);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        view.getContext().startActivity(intent);
                    }
                }

                @Override
                public void onItemLongClicked(View view, Topic topicSelected) {
                    Log.i(TAG, "onItemLongClicked(View, Topic) topicSelected: " + topicSelected.getName());
                    // TODO:
                }
            });
            rvTopic.setAdapter(adapter);
            rvTopic.setLayoutManager(new LinearLayoutManager(rvTopic.getContext()));
            rvTopic.setNestedScrollingEnabled(false);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition(); // gets item position
            Log.i(TAG, "item in RV clicked! position: " + position);
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                if (listener != null) {
                    Category categorySelected = categories.get(position);
                    listener.onItemClicked(view, categorySelected);
                }
            }
        }

        @Override
        public boolean onLongClick(View view) {
            int position = getAdapterPosition(); // gets item position
            Log.i(TAG, "item in RV long-clicked! position: " + position);
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                if (listener != null) {
                    Category categorySelected = categories.get(position);
                    listener.onItemLongClicked(view, categorySelected);
                    return true;
                }
            }
            return false;
        }
    }
}
