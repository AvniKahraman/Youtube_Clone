package com.example.youtube;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Bookstore extends AppCompatActivity {


    private List<likesvideo> videoList2, videoList3;
    private List<BookStore_video> videoList;
    private Bookstore_past_Adapter adapter;
    private bookstore_videoAdapter adapter1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookstore);

        // ActionBar'ı gizle
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        LinearLayout historyBar = findViewById(R.id.historyBar);
        LinearLayout playlistbar = findViewById(R.id.playlistbar);
        LinearLayout yourVideos = findViewById(R.id.yourVideos);
        LinearLayout download= findViewById(R.id.download);
        LinearLayout filmbar = findViewById(R.id.filmbar);
        LinearLayout patato = findViewById(R.id.patato);
        ImageView subsImageView = findViewById(R.id.subsImageView);
        ImageView hp_homePage = findViewById(R.id.hp_homePage);



        hp_homePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bookstore.this,MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });

        subsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bookstore.this,Subscriptions.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right);

            }
        });

        historyBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Bookstore.this, "HistoryBar", Toast.LENGTH_SHORT).show();
            }
        });

        playlistbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Bookstore.this, "Playlistbar", Toast.LENGTH_SHORT).show();
            }
        });

        yourVideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Bookstore.this, "Your Videos", Toast.LENGTH_SHORT).show();
            }
        });

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Bookstore.this, "Downloads", Toast.LENGTH_SHORT).show();
            }
        });

        filmbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Bookstore.this, "FilmBar", Toast.LENGTH_SHORT).show();
            }
        });

        patato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Bookstore.this, "Your Clips", Toast.LENGTH_SHORT).show();
            }
        });

        videoList = new ArrayList<>();

        String json = "[\n" +
                "  {\n" +
                "    \"id\": \"1\",\n" +
                "    \"bookstorethumbnail\": \"https://i.ytimg.com/vi/X8bod1bqOHg/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDlyPC1x1sZQuMfaCQxjQRETUiF4w\",\n" +
                "    \"video_title\": \"18 Bin Kilometrede 1998 Model Fiat Tempra\",\n" + // Burada bir virgül eklendi
                "    \"bookvideo\": \"jaho\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"2\",\n" +
                "    \"bookstorethumbnail\": \"https://i.ytimg.com/vi/JlvY3-3Gork/hqdefault.jpg?sqp=-oaymwE2CNACELwBSFXyq4qpAygIARUAAIhCGAFwAcABBvABAfgB_gmAAtAFigIMCAAQARhlIE8oRzAP&rs=AOn4CLBqpNSiWgcGapGKq8njI6ScVKsiZA\",\n" +
                "    \"video_title\": \"#ZaferMeclise mülteciler evine! | Prof. Dr. Ümit Özdağ | Zafer Partisi\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"3\",\n" +
                "    \"bookstorethumbnail\": \"https://i.ytimg.com/vi/l-IAz-s0rno/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLC9Jnb3mjw_0mwllgZHBbZwiaXOjQ\",\n" +
                "    \"video_title\": \"DÜNYAYI ŞAŞIRTAN TÜRK PİLOT! \uD83D\uDE31- ARMA 3 w/@CaglarArtsLtd @Burhi\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"4\",\n" +
                "    \"bookstorethumbnail\": \"https://i.ytimg.com/vi/xNbge2jXUBk/hq720.jpg?sqp=-oaymwEcCOgCEMoBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLD38Z4trpg7yN_9dIhXJhNLQOd4oA\",\n" +
                "    \"video_title\": \"EXTRACTION 2 - ELEŞTİREL PARODİ\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"5\",\n" +
                "    \"bookstorethumbnail\": \"https://i.ytimg.com/vi/Z8eXaXoUJRQ/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLAG22yKPLpArsQvfHXlqaoS5FXy_A\",\n" +
                "    \"video_title\": \"Selena Gomez - Slow Down (Official)\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"6\",\n" +
                "    \"bookstorethumbnail\": \"https://i.ytimg.com/vi/fwfFSYH1330/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLD53TBPRKIjOBlfQinUr_I37gtAXQ\",\n" +
                "    \"video_title\": \"NİNJANIN HÜNERLERİ! | Goose Goose Duck [YOUTUBE ÖZEL]\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"7\",\n" +
                "    \"bookstorethumbnail\": \"https://i.ytimg.com/vi/2nCs6ve4zw4/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLAE8UnIUC5LfoF7BjZDQsMsBk-lgw\",\n" +
                "    \"video_title\": \"SAVUNMASIZ ASTRAL! | Goose Goose Duck\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"8\",\n" +
                "    \"bookstorethumbnail\": \"https://i.ytimg.com/vi/942WjgyhF1s/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLBrV_OEHYObSayOv2G0K9mNQr5JPg\",\n" +
                "    \"video_title\": \"Leyla ile Mecnun 5. Bölüm\"\n" +
                "  }\n" +
                "]";


        String json2 = "[\n" +
                "  {\n" +
                "    \"id\": \"8\",\n" +
                "    \"likesimage\": \"https://i.ytimg.com/vi/942WjgyhF1s/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLBrV_OEHYObSayOv2G0K9mNQr5JPg\"\n" +
                "  }\n" +
                "]";


        String json3 = "[\n" +
                "  {\n" +
                "    \"id\": \"8\",\n" +
                "    \"tamam\": \"https://i.ytimg.com/vi/942WjgyhF1s/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLBrV_OEHYObSayOv2G0K9mNQr5JPg\"\n" +
                "  }\n" +
                "]";


        videoList = parseJson(json);
        videoList2 = parseChannelJson(json2);
        videoList3 = parseChannel(json3);
        adapter = new Bookstore_past_Adapter(videoList, this);

        RecyclerView recyclerView1 = findViewById(R.id.recycleviewpast);
        GridLayoutManager layoutManager1 = new GridLayoutManager(this, 1); // 1 sütunlu bir düzen kullanılacak
        layoutManager1.setOrientation(GridLayoutManager.HORIZONTAL); // Yatay yönde sıralama yapılmasını sağlar
        recyclerView1.setLayoutManager(layoutManager1);
        adapter = new Bookstore_past_Adapter(videoList, Bookstore.this);
        recyclerView1.setAdapter(adapter);
        recyclerView1.setNestedScrollingEnabled(false); // Dikey kaydırmayı devre dışı bırakma



        RecyclerView recyclerView = findViewById(R.id.recycleviewplaylist);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView1.setLayoutManager(layoutManager);
        adapter = new Bookstore_past_Adapter(videoList, this);
        recyclerView.setAdapter(adapter1);
        recyclerView.setNestedScrollingEnabled(false);



        RecyclerView recyclerView2 = findViewById(R.id.recycleviewplaylist);
        GridLayoutManager layoutManager2 = new GridLayoutManager(this, 1);
        recyclerView2.setLayoutManager(layoutManager2);
        adapter1 = new bookstore_videoAdapter(videoList2, videoList3, this);
        recyclerView2.setAdapter(adapter1);
        recyclerView2.setNestedScrollingEnabled(false);





    }
    private List<likesvideo> parseChannel(String json3) {
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<likesvideo>>() {}.getType();
        return gson.fromJson(json3, listType);
    }

    private List<likesvideo> parseChannelJson(String json2) {
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<likesvideo>>() {}.getType();
        return gson.fromJson(json2, listType);
    }


    private List<BookStore_video> parseJson(String json) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<BookStore_video>>(){}.getType();
        return gson.fromJson(json, listType);
    }
}
