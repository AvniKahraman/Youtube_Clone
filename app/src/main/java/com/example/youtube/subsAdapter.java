package com.example.youtube;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class subsAdapter extends RecyclerView.Adapter<subsAdapter.ViewHolder> {

    private List<subs_channel> videoList1;
    private Context context;

    public subsAdapter(List<subs_channel> videoList, Context context) {
        this.videoList1 = videoList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subscribepong, parent, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layoutParams);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        subs_channel video = videoList1.get(position);
        if (video.getChannel_subs()  != null) {
            Picasso.get().load(video.getChannel_subs()).into(holder.chanel_subs);
        }
    }

    @Override
    public int getItemCount() {
        return videoList1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public CircleImageView chanel_subs;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            chanel_subs = itemView.findViewById(R.id.chanel_subs);
        }
    }
}
