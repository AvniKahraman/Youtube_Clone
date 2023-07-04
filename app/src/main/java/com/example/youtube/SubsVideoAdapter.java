package com.example.youtube;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class SubsVideoAdapter extends RecyclerView.Adapter<SubsVideoAdapter.ViewHolder> {

    private List<subsVideo> videoList1;
    private Context context;

    public SubsVideoAdapter(List<subsVideo> videoList, Context context) {
        this.videoList1 = videoList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layoutParams);
        VideoAdapter.ViewHolder viewHolder = new VideoAdapter.ViewHolder(view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        subsVideo video = videoList1.get(position);
        if (video != null) {
            holder.video_title.setText(video.getVideo_title());
            holder.views.setText(video.getViews());
            Picasso.get().load(video.getChannel_image()).into(holder.channel_image);
            Picasso.get().load(video.getThumbnail()).into(holder.thumbnailImageView);
        }
    }

    @Override
    public int getItemCount() {
        return videoList1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumbnailImageView, channel_image;
        public TextView video_title, views;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbnailImageView = itemView.findViewById(R.id.videothumbnail);
            channel_image = itemView.findViewById(R.id.channel_image);
            video_title = itemView.findViewById(R.id.video_title);
            views = itemView.findViewById(R.id.views);
        }
    }
}
