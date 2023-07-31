package com.example.youtube;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class LibraryFragment extends Fragment {

    private List<likesvideo> videoList2, videoList3;
    private List<BookStore_video> videoList;
    private Bookstore_past_Adapter adapter;
    private bookstore_videoAdapter adapter1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_bookstore, container, false);


        LinearLayout historyBar = view.findViewById(R.id.historyBar);
        LinearLayout playlistbar = view.findViewById(R.id.playlistbar);
        LinearLayout yourVideos = view.findViewById(R.id.yourVideos);
        LinearLayout download = view.findViewById(R.id.download);
        LinearLayout filmbar = view.findViewById(R.id.filmbar);
        LinearLayout patato = view.findViewById(R.id.patato);

        historyBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "HistoryBar", Toast.LENGTH_SHORT).show();
            }
        });

        playlistbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Playlistbar", Toast.LENGTH_SHORT).show();
            }
        });

        yourVideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Your Videos", Toast.LENGTH_SHORT).show();
            }
        });

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Downloads", Toast.LENGTH_SHORT).show();
            }
        });

        filmbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "FilmBar", Toast.LENGTH_SHORT).show();
            }
        });

        patato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Your Clips", Toast.LENGTH_SHORT).show();
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


        RecyclerView recyclerView = view.findViewById(R.id.recycleviewpast);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Bookstore_past_Adapter(videoList, getActivity());
        recyclerView.setAdapter(adapter);

        RecyclerView recyclerView2 = view.findViewById(R.id.recycleviewplaylist);
        GridLayoutManager layoutManager2 = new GridLayoutManager(getActivity(), 1);
        recyclerView2.setLayoutManager(layoutManager2);
        adapter1 = new bookstore_videoAdapter(videoList2, videoList3, getActivity());
        recyclerView2.setAdapter(adapter1);

        return view;
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
