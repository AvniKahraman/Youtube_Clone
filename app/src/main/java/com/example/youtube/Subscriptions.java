package com.example.youtube;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Subscriptions extends AppCompatActivity {

    private List<subs_channel> videoList2;
    private List<subsVideo> videoList;

    SubsVideoAdapter adapter;
    subsAdapter adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscriptions);

        ImageView homeImageView = findViewById(R.id.hp_homePage);
        ImageView bookstore = findViewById(R.id.bookstore);

        bookstore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Subscriptions.this, Bookstore.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        homeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Subscriptions.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right);
            }
        });

        videoList = new ArrayList<>();

        // ActionBar'ı gizle
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        String json = "[\n" +
                // ... (Your video JSON data here)
                "]";

        String json2 = "[\n" +
                // ... (Your channel JSON data here)
                "]";

        videoList2 = parseChannelJson(json2);
        videoList = parseJson(json);

        // RecyclerView ve VideoAdapter ayarlarını yap
        RecyclerView recyclerView1 = findViewById(R.id.recycleViewSubs);
        GridLayoutManager layoutManager1 = new GridLayoutManager(this, 3); // 3 sütunlu bir düzen kullanılacak
        recyclerView1.setLayoutManager(layoutManager1);
        adapter1 = new subsAdapter(videoList2, Subscriptions.this);
        recyclerView1.setAdapter(adapter1);
        recyclerView1.setNestedScrollingEnabled(false); // Dikey kaydırmayı devre dışı bırakma

        RecyclerView recyclerView = findViewById(R.id.videoRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new SubsVideoAdapter(videoList, Subscriptions.this);
        recyclerView.setAdapter(adapter);
    }

    private List<subs_channel> parseChannelJson(String json2) {
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<subs_channel>>() {}.getType();
        return gson.fromJson(json2, listType);
    }

    private List<subsVideo> parseJson(String json) {
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<subsVideo>>() {}.getType();
        return gson.fromJson(json, listType);
    }
}
