package com.example.youtube;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Video> videoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ActionBar'ı gizle
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // JSON verilerini oku
        String json = "[\n" +
                "  {\n" +
                "    \"id\": \"1\",\n" +
                "    \"photo_url\": \"https://i.ytimg.com/vi/CpEOSsNvYiE/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLAuVauTV5K_8CTrSHfA-wuHY79DwQ\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"2\",\n" +
                "    \"photo_url\": \"https://i.ytimg.com/vi/5agNtt0DtL0/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLByrFYPOmeAshVv31e5b5-_ChoJ7Q\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"3\",\n" +
                "    \"photo_url\": \"https://i.ytimg.com/vi/gY4FIkKGz6M/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDRYBoq-8uxjADdwcVFVh3_sGNpOw\"\n" +
                "  }\n" +
                "]";



        videoList = parseJson(json);

        // RecyclerView ve VideoAdapter ayarlarını yap
        RecyclerView recyclerView = findViewById(R.id.videoRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        VideoAdapter adapter = new VideoAdapter(videoList);
        recyclerView.setAdapter(adapter);
    }

    private List<Video> parseJson(String json) {
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Video>>() {}.getType();
        return gson.fromJson(json, listType);
    }
}
