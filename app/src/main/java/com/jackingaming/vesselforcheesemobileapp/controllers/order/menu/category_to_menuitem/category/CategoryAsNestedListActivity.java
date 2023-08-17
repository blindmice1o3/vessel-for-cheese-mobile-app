package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.category_to_menuitem.category;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.menu.hierarchy.Category;
import com.jackingaming.vesselforcheesemobileapp.models.menu.hierarchy.Section;
import com.jackingaming.vesselforcheesemobileapp.models.menu.hierarchy.Topic;
import com.jackingaming.vesselforcheesemobileapp.models.menu_items.MenuItem;

import java.util.List;

public class CategoryAsNestedListActivity extends AppCompatActivity {
    public static final String TAG = CategoryAsNestedListActivity.class.getSimpleName();
    public static final String EXTRA_CATEGORY_SELECTED = "com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.category_to_menuitem.category.categorySelected";

    public void initHeightAppBarLayoutAsQuarterScreen(AppBarLayout appBarLayout) {
        float heightDp = getResources().getDisplayMetrics().heightPixels / 4;
        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams();
        lp.height = (int) heightDp;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate()");
        setContentView(R.layout.activity_category_as_nested_list);

        Category categorySelected = (Category) getIntent().getSerializableExtra(EXTRA_CATEGORY_SELECTED);

        AppBarLayout appBarLayout = findViewById(R.id.app_bar_layout);
        initHeightAppBarLayoutAsQuarterScreen(appBarLayout);

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar_layout);
        String nameTopicSelected = categorySelected.getName();

        int sizeOfList = 0;
        List<Topic> topics = categorySelected.getTopics();
        for (Topic topic : topics) {
            List<Section> sections = topic.getSections();
            for (Section section : sections) {
                List<MenuItem> menuItems = section.getMenuItems();

                sizeOfList += menuItems.size();
            }
        }
        Log.e(TAG, "number of MenuItem from Category: " + sizeOfList);
        String formatStringTitle = "%s (%d)";
        String title = String.format(formatStringTitle,
                nameTopicSelected, sizeOfList);
        collapsingToolbarLayout.setTitle(title);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView rvTopic = findViewById(R.id.rv_topic);
        TopicToMenuItemAdapter adapter = new TopicToMenuItemAdapter(topics, new TopicToMenuItemAdapter.TopicToMenuItemAdapterListener() {
            @Override
            public void onItemClicked(View view, Topic topicSelected) {
                Log.i(TAG, "onItemClicked(View, Topic) topicSelected: " + topicSelected.getName());
                // TODO:
            }

            @Override
            public void onItemLongClicked(View view, Topic topicSelected) {
                Log.i(TAG, "onItemLongClicked(View, Topic) topicSelected: " + topicSelected.getName());
                // TODO:
            }
        });
        rvTopic.setAdapter(adapter);
        rvTopic.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rvTopic.addItemDecoration(itemDecoration);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull android.view.MenuItem item) {
        Log.i(TAG, "onOptionsItemSelected()");
        if (item.getItemId() == android.R.id.home) {
            Log.i(TAG, "up button (android.R.id.home) was pressed");

            finish();
            return true;
        } else {
            Log.i(TAG, "else-clause");
            return super.onOptionsItemSelected(item);
        }
    }
}