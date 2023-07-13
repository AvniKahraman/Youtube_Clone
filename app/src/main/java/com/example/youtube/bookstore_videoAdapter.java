package com.example.youtube;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class bookstore_videoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<likesvideo> videoList1;
    private List<likesvideo> videoList2;
    private Context context;

    public bookstore_videoAdapter(List<likesvideo> videoList1, List<likesvideo> videoList2, Context context) {
        this.videoList1 = videoList1;
        this.videoList2 = videoList2;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2; // 0 or 1 based on position to determine different view types
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (viewType == 0) {
            View view = inflater.inflate(R.layout.likes, parent, false);
            return new ViewHolder1(view);
        } else {
            View view = inflater.inflate(R.layout.playlist1, parent, false);
            return new ViewHolder2(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);

        if (viewType == 0) {
            ViewHolder1 viewHolder1 = (ViewHolder1) holder;
            if (position / 2 < videoList1.size()) {
                likesvideo video = videoList1.get(position / 2);
                Picasso.get().load(video.getLikesimage()).into(viewHolder1.likesimage);
            }
        } else {
            ViewHolder2 viewHolder2 = (ViewHolder2) holder;
            if (position / 2 < videoList2.size()) {
                likesvideo video = videoList2.get(position / 2);
                Picasso.get().load(video.getTamam()).into(viewHolder2.tamam);
            }
        }
    }

    @Override
    public int getItemCount() {
        return (videoList1.size() + videoList2.size()) * 2;
    }

    public static class ViewHolder1 extends RecyclerView.ViewHolder {
        public ImageView likesimage;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            likesimage = itemView.findViewById(R.id.likesimage);
        }
    }

    public static class ViewHolder2 extends RecyclerView.ViewHolder {
        public ImageView tamam;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            tamam = itemView.findViewById(R.id.tamam);
        }
    }
}
