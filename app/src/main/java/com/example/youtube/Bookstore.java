package com.example.youtube;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Bookstore extends AppCompatActivity {

    private List<BookStore_video> videoList;
    private Bookstore_past_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookstore);

        // ActionBar'ı gizle
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        videoList = new ArrayList<>();

        String json = "[\n" +
                "  {\n" +
                "    \"id\": \"1\",\n" +
                "    \"bookstorethumbnail\": \"https://i.ytimg.com/vi/X8bod1bqOHg/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDlyPC1x1sZQuMfaCQxjQRETUiF4w\",\n" +
                "    \"video_title\": \"18 Bin Kilometrede 1998 Model Fiat Tempra\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"1\",\n" +
                "    \"bookstorethumbnail\": \"https://i.ytimg.com/vi/X8bod1bqOHg/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDlyPC1x1sZQuMfaCQxjQRETUiF4w\",\n" +
                "    \"video_title\": \"18 Bin Kilometrede 1998 Model Fiat Tempra\"\n" +
                "  }\n" +
                "]";


        videoList = parseJson(json);
        adapter = new Bookstore_past_Adapter(videoList, this);

        RecyclerView recyclerView = findViewById(R.id.recycleviewpast);
        GridLayoutManager layoutManager1 = new GridLayoutManager(this, 16); // İki sütunlu bir düzen kullanılacak
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
    }

    private List<BookStore_video> parseJson(String json) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<BookStore_video>>(){}.getType();
        return gson.fromJson(json, listType);
    }
}
