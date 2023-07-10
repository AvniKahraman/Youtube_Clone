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

public class Bookstore_past_Adapter extends RecyclerView.Adapter<Bookstore_past_Adapter.ViewHolder> {

    private List<BookStore_video> videoList1;
    private Context context;

    public Bookstore_past_Adapter(List<BookStore_video> videoList, Context context) {
        this.videoList1 = videoList;
        this.context = context;
    }
    @NonNull
    @Override
    public Bookstore_past_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookstore_pong, parent, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layoutParams);
        Bookstore_past_Adapter.ViewHolder viewHolder = new Bookstore_past_Adapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BookStore_video video = videoList1.get(position);
        if (video != null) {
            holder.video_title.setText(video.getVideo_title());
            holder.bookvideo.setText(video.getVideo_title());
            Picasso.get().load(video.getBookstorethumbnail()).into(holder.bookstorethumbnail);
        }

    }



    @Override
    public int getItemCount() {
        return videoList1.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView bookstorethumbnail;
        public TextView video_title, bookvideo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bookstorethumbnail = itemView.findViewById(R.id.bookstorethumbnail);
            bookvideo = itemView.findViewById(R.id.bookvideo);
            video_title = itemView.findViewById(R.id.video_title);

        }
    }
}
