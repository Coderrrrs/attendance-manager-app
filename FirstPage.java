package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FirstPage extends AppCompatActivity {

    ImageView img,img2,img3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        img = findViewById(R.id.imageView11);
        img3 = findViewById(R.id.imageView12);
        img2 = findViewById(R.id.imageView15);

//        img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent iNext;
//                iNext = new Intent(FirstPage.this,MapsActivity.class);
//                startActivity(iNext);
//            }
//        });
    }
}