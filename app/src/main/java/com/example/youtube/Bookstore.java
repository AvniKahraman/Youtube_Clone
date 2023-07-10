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


        videoList = parseJson(json);
        adapter = new Bookstore_past_Adapter(videoList, this);

        RecyclerView recyclerView1 = findViewById(R.id.recycleviewpast);
        GridLayoutManager layoutManager1 = new GridLayoutManager(this, 8); // İki sütunlu bir düzen kullanılacak
        recyclerView1.setLayoutManager(layoutManager1);
        adapter = new Bookstore_past_Adapter(videoList,Bookstore.this);
        recyclerView1.setAdapter(adapter);
        recyclerView1.setNestedScrollingEnabled(false); // Dikey kaydırmayı devre dışı bırakma
    }

    private List<BookStore_video> parseJson(String json) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<BookStore_video>>(){}.getType();
        return gson.fromJson(json, listType);
    }
}
