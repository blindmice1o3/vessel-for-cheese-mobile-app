package com.jackingaming.vesselforcheesemobileapp.controllers.order.menu.hierarchy.category;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jackingaming.vesselforcheesemobileapp.R;
import com.jackingaming.vesselforcheesemobileapp.models.menu.hierarchy.Topic;
import com.jackingaming.vesselforcheesemobileapp.views.CircularBorderedImageView;

import java.util.List;

public class TopicAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = TopicAdapter.class.getSimpleName();

    public interface TopicAdapterListener {
        void onItemClicked(View view, Topic topicSelected);

        void onItemLongClicked(View view, Topic topicSelected);
    }

    private List<Topic> topics;
    private TopicAdapterListener listener;

    public TopicAdapter(List<Topic> topics, TopicAdapterListener listener) {
        this.topics = topics;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder()");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_topic, parent, false);
        return new ViewHolderTopic(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder()");
        Topic topic = topics.get(position);
        ViewHolderTopic viewHolderTopic = (ViewHolderTopic) holder;
        viewHolderTopic.bind(topic);
    }

    @Override
    public int getItemCount() {
        Log.i(TAG, "onItemCount() topics.size(): " + topics.size());
        return topics.size();
    }

    class ViewHolderTopic extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {
        private CircularBorderedImageView ivThumbnail;
        private TextView tvName;

        public ViewHolderTopic(@NonNull View itemView) {
            super(itemView);
            ivThumbnail = itemView.findViewById(R.id.iv_thumbnail);
            tvName = itemView.findViewById(R.id.tv_name);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void bind(Topic topic) {
            ivThumbnail.setImageResource(topic.getIdImage());
            tvName.setText(topic.getName());
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
