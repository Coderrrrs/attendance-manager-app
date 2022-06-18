package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Flash_screen extends AppCompatActivity {
    Intent iHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                iHome = new Intent(Flash_screen.this,MainActivity.class);
                startActivity(iHome);
                finish();
            }
        },2000);
    }
}