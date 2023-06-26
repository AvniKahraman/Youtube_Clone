package com.example.youtube;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Video> videoList;
    RecyclerView.Adapter recyclerViewadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoList = new ArrayList<>();

        // ActionBar'ı gizle
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // JSON verilerini oku
        String json = "[\n" +
                "  {\n" +
                "    \"id\": \"1\",\n" +
                "    \"photo_url\": \"https://i.ytimg.com/vi/LaWewSJNghc/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLBzNlhFLeZH8x4R8VX-1CUffAxapA\",\n" +
                "    \"channel_image\": \"https://yt3.googleusercontent.com/ytc/AGIKgqN1F5HXRCFl48NA5bwfOJsdLakGKcwyJrcZ31fkGQ=s88-c-k-c0x00ffffff-no-rj-mo\",\n" +
                "    \"video_title\": \"Survival Of The Thickest | Official Trailer | Netflix\",\n" +
                "    \"views\": \"144 B görüntüleme \"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"2\",\n" +
                "    \"photo_url\": \"https://i.ytimg.com/vi/5agNtt0DtL0/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLByrFYPOmeAshVv31e5b5-_ChoJ7Q\",\n" +
                "    \"channel_image\": \"https://example.com/channel_image.jpg\",\n" +
                "    \"video_title\": \"Video 2\",\n" +
                "    \"views\": \"2000\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"3\",\n" +
                "    \"photo_url\": \"https://i.ytimg.com/vi/gY4FIkKGz6M/qdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDRYBoq-8uxjADdwcVFVh3_sGNpOw\",\n" +
                "    \"channel_image\": \"https://example.com/channel_image.jpg\",\n" +
                "    \"video_title\": \"Video 3\",\n" +
                "    \"views\": \"3000\"\n" +
                "  }\n" +
                "]";

        videoList = parseJson(json);

        // RecyclerView ve VideoAdapter ayarlarını yap
        RecyclerView recyclerView = findViewById(R.id.videoRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        VideoAdapter adapter = new VideoAdapter(videoList, MainActivity.this);
        recyclerView.setAdapter(adapter);
    }

    private List<Video> parseJson(String json) {
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Video>>() {}.getType();
        return gson.fromJson(json, listType);
    }
}
