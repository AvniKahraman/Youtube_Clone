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


public class bookstore_videoAdapter  extends RecyclerView.Adapter<bookstore_videoAdapter.ViewHolder> {
    private List<likesvideo> videoList1;
    private Context context;

    public bookstore_videoAdapter(List<likesvideo> videoList, Context context) {
        this.videoList1 = videoList;
        this.context = context;
    }


    @NonNull
    @Override
    public bookstore_videoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.likes, parent, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layoutParams);
        bookstore_videoAdapter.ViewHolder viewHolder = new bookstore_videoAdapter.ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull bookstore_videoAdapter.ViewHolder holder, int position) {
        likesvideo video = videoList1.get(position);
        if (video != null) {
            Picasso.get().load(video.getLikesimage()).into(holder.likesimage);
        }




    }

    @Override
    public int getItemCount() {
        return videoList1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView likesimage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            likesimage = itemView.findViewById(R.id.likesimage);

        }
    }
}
