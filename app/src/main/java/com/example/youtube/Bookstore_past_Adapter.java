package com.example.youtube;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Bookstore_past_Adapter extends RecyclerView.Adapter<Bookstore_past_Adapter.ViewHolder>  {

    private List<subs_channel> videoList1;
    private Context context;


    public Bookstore_past_Adapter(List<subs_channel> videoList, Context context) {
        this.videoList1 = videoList;
        this.context = context;
    }

    @NonNull
    @Override
    public Bookstore_past_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subscribepong, parent, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layoutParams);
        subsAdapter.ViewHolder viewHolder = new subsAdapter.ViewHolder(view);
       return null;

    }

    @Override
    public void onBindViewHolder(@NonNull Bookstore_past_Adapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
