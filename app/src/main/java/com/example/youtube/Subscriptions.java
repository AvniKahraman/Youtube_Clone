    package com.example.youtube;

    import androidx.appcompat.app.AppCompatActivity;
    import androidx.recyclerview.widget.GridLayoutManager;
    import androidx.recyclerview.widget.LinearLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;

    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.ImageView;
    import android.widget.LinearLayout;

    import com.google.gson.Gson;
    import com.google.gson.reflect.TypeToken;

    import java.lang.reflect.Type;
    import java.util.ArrayList;
    import java.util.List;

    public class Subscriptions extends AppCompatActivity {

        Subscriptions subs;
        private  List<subs_channel> videoList2;
        private List<subsVideo> videoList;



        SubsVideoAdapter adapter;
        subsAdapter adapter1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_subscriptions);

            ImageView homeImageView = findViewById(R.id.hp_homePage);


            homeImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Subscriptions.this, MainActivity.class);
                        startActivity(intent);
                    }
                });

            videoList = new ArrayList<>();



            // ActionBar'ı gizle
            if (getSupportActionBar() != null) {
                getSupportActionBar().hide();
            }



            String json = "[\n" +
                    "  {\n" +
                    "    \"id\": \"1\",\n" +
                    "    \"thumbnail\": \"https://i.ytimg.com/vi/eOKrWpaG5kk/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLACNn_vLR2jnr2hPPk2Lpm1hcHvdg\",\n" +
                    "    \"channel_image\": \"https://yt3.googleusercontent.com/ytc/AGIKgqN1F5HXRCFl48NA5bwfOJsdLakGKcwyJrcZ31fkGQ=s88-c-k-c0x00ffffff-no-rj-mo\",\n" +
                    "    \"video_title\": \"Survival Of The Thickest | Official Trailer | Netflix\",\n" +
                    "    \"views\": \"144 B görüntüleme\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": \"2\",\n" +
                    "    \"thumbnail\": \"https://i.ytimg.com/vi/5agNtt0DtL0/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLByrFYPOmeAshVv31e5b5-_ChoJ7Q\",\n" +
                    "    \"channel_image\": \"https://yt3.ggpht.com/QMgD-AL-noOFuYObY4khETLrHZiU1V6mBMARiZa6EYL1d0D7vo2CViqvWX_hn90nb0E8cx3kjQ=s48-c-k-c0x00ffffff-no-rj\",\n" +
                    "    \"video_title\": \"Kayıp Denizaltı Gizemi | Derindeki Gizem\",\n" +
                    "    \"views\": \"52 B görüntüleme\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": \"3\",\n" +
                    "    \"thumbnail\": \"https://i.ytimg.com/vi/FYcptmGFF6E/hq720.jpg?sqp=-oaymwEcCOgCEMoBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLB2UktDviTQe5rR2-jYo-WZKrQw6A\",\n" +
                    "    \"channel_image\": \"https://yt3.ggpht.com/FgOab_l7ofOLZjoNWYw-bfAbgRXPDd4oVeAwtDnB98AAR2IDwPfBiqPiX5OPC5z3EG5hCsKEgmM=s48-c-k-c0x00ffffff-no-rj\",\n" +
                    "    \"video_title\": \"Mesut Süre İle İlişki Testi | #13 Dilan Bayır Polat & Fazlı Polat\",\n" +
                    "    \"views\": \"2,4 Mn görüntüleme\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": \"4\",\n" +
                    "    \"thumbnail\": \"https://i.ytimg.com/vi/gy1B3agGNxw/hq720.jpg?sqp=-oaymwE2COgCEMoBSFXyq4qpAygIARUAAIhCGAFwAcABBvABAfgBvgeAAtAFigIMCAAQARg4IDYofzAP&rs=AOn4CLCvmDhZt19TBBrZ8sc2-BI9u6ezYg\",\n" +
                    "    \"channel_image\": \"https://yt3.ggpht.com/ytc/AGIKgqNqhtcKenlUQ500vTEDWgH2ej_MT7MZfO09MVJQhg=s48-c-k-c0x00ffffff-no-rj\",\n" +
                    "    \"video_title\": \"Epic Sax Guy [Original] [HD]\",\n" +
                    "    \"views\": \"85 Mn görüntüleme\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": \"5\",\n" +
                    "    \"thumbnail\": \"https://i.ytimg.com/vi/Z8eXaXoUJRQ/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLAG22yKPLpArsQvfHXlqaoS5FXy_A\",\n" +
                    "    \"channel_image\": \"https://yt3.ggpht.com/lwPYJMKoTNR2hs_hrXRFcTy0aQteNHEJnGwyfp0cwvjhJVZW6HWa6CTm_Bf99Y71U2V_FZMZenQ=s48-c-k-c0x00ffffff-no-nd-rj\",\n" +
                    "    \"video_title\": \"Selena Gomez - Slow Down (Official)\",\n" +
                    "    \"views\": \"411 Mn görüntüleme\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": \"6\",\n" +
                    "    \"thumbnail\": \"https://i.ytimg.com/vi/ZEmITxF4OVo/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDxU7M1aeAmNFGypgQWWWwVcDhppg\",\n" +
                    "    \"channel_image\": \"https://yt3.ggpht.com/ytc/AGIKgqM6LL7VphGww0IIZsBxXUmNK_GdNoX6IeFfBb8Z=s48-c-k-c0x00ffffff-no-rj\",\n" +
                    "    \"video_title\": \"Turkish street food, BEST in the WORLD?\",\n" +
                    "    \"views\": \"185 B görüntüleme  2 hafta önce\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": \"7\",\n" +
                    "    \"thumbnail\": \"https://i.ytimg.com/vi/2nCs6ve4zw4/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLAE8UnIUC5LfoF7BjZDQsMsBk-lgw\",\n" +
                    "    \"channel_image\": \"https://yt3.ggpht.com/gBc1Jr4U2SRTOToaaVFdvUbqxcI8L6eQciewD9UD9uKTxJDoGMmlDbhLjm_d3-e__iap4ov5gxc=s48-c-k-c0x00ffffff-no-rj\",\n" +
                    "    \"video_title\": \"SAVUNMASIZ ASTRAL! | Goose Goose Duck\",\n" +
                    "    \"views\": \"9,6 B görüntüleme  17 saat önce\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": \"8\",\n" +
                    "    \"thumbnail\": \"https://i.ytimg.com/vi/942WjgyhF1s/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLBrV_OEHYObSayOv2G0K9mNQr5JPg\",\n" +
                    "    \"channel_image\": \"https://yt3.ggpht.com/niNLmP3Zy1ea_DizNDv7x8eWak6nNKt6t46R6w6ZtkRzEMsnMLRugloSLYHq519cGdu3bz_tKg=s48-c-k-c0x00ffffff-no-rj\",\n" +
                    "    \"video_title\": \"Leyla ile Mecnun 5. Bölüm\",\n" +
                    "    \"views\": \"105 B görüntüleme  2 ay önce\"\n" +
                    "  },\n" +
                    "]";

            String json2 = "[\n" +
                    "  {\n" +
                    "    \"id\": \"1\",\n" +
                    "    \"channel_subs\": \"https://yt3.googleusercontent.com/ixRLR3PzS9EXSZMThJ592UriyT5T8D0zYMw3ckuOglR62jym8EYWmp2lDBpeDi-DfyqDV6hych0=s176-c-k-c0x00ffffff-no-rj\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": \"2\",\n" +
                    "    \"channel_subs\": \"https://yt3.googleusercontent.com/ytc/AGIKgqN1F5HXRCFl48NA5bwfOJsdLakGKcwyJrcZ31fkGQ=s88-c-k-c0x00ffffff-no-rj-mo\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": \"3\",\n" +
                    "    \"channel_subs\": \"https://yt3.ggpht.com/gBc1Jr4U2SRTOToaaVFdvUbqxcI8L6eQciewD9UD9uKTxJDoGMmlDbhLjm_d3-e__iap4ov5gxc=s48-c-k-c0x00ffffff-no-rj\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": \"4\",\n" +
                    "    \"channel_subs\": \"https://yt3.ggpht.com/ytc/AGIKgqO1WJO2Y4SHbpqszoQ1Vz3Re6KFgI0b8eUKK--f6A=s68-c-k-c0x00ffffff-no-rj\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": \"9\",\n" +
                    "    \"channel_subs\": \"https://yt3.ggpht.com/Y9ChdQ3aURwGsAYEQsDGfSpyLmPz55Dvk46UkencQzU3QGF0FA6pWl8ddX5iTfpXfY6GBPb6EA=s68-c-k-c0x00ffffff-no-rj\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": \"5\",\n" +
                    "    \"channel_subs\": \"https://yt3.ggpht.com/sjw3p8Guc0-L8yYpDvvsOCSgzwvZ5FPHrkRqVLMx2Hk1aSN0AZQMF4IRqkaunho80CkfY7cCHl4=s68-c-k-c0x00ffffff-no-rj\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": \"6\",\n" +
                    "    \"channel_subs\": \"https://yt3.ggpht.com/WMHxmJ-ZFQTIV9HU6fbLYiDX0mqKy40GAey0yrBxVQCrvQegf2gWNto9pxlbHQdXfPTgjUp0=s68-c-k-c0x00ffffff-no-rj\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": \"7\",\n" +
                    "    \"channel_subs\": \"https://yt3.ggpht.com/5otgPapAigujfiDJfAI5SX1AmcKKZ-KBiXywcuGQw_xyGV0R0zH1_SNBSjYyjWIobY0f9cAF=s68-c-k-c0x00ffffff-no-rj-mo\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": \"8\",\n" +
                    "    \"channel_subs\": \"https://yt3.ggpht.com/FgOab_l7ofOLZjoNWYw-bfAbgRXPDd4oVeAwtDnB98AAR2IDwPfBiqPiX5OPC5z3EG5hCsKEgmM=s48-c-k-c0x00ffffff-no-rj\"\n" +
                    "  }\n" +
                    "]";



            System.out.println(videoList2);
            videoList2 = parseChannelJson(json2);
            videoList = parseJson(json);

            // RecyclerView ve VideoAdapter ayarlarını yap

            RecyclerView recyclerView1 = findViewById(R.id.recycleViewSubs);
            GridLayoutManager layoutManager1 = new GridLayoutManager(this, 9); // İki sütunlu bir düzen kullanılacak
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