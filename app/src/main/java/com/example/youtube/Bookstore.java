package com.example.youtube;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Bookstore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookstore);
        getSupportActionBar().hide();

        LinearLayout historybar = findViewById(R.id.historyBar);
        ImageView homepage = findViewById(R.id.hp_homePage);
        ImageView subsImageView = findViewById(R.id.subsImageView);


        homepage.setOnClickListener(new View.OnClickListener() {
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

        historybar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Bookstore.this, "Hello Ma men", Toast.LENGTH_SHORT).show();
            }
        });
    }

}