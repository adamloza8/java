package com.example.srawa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;

public class SplashActivity extends AppCompatActivity {

   public static ArrayList<Modelclass> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();

        list.add(new Modelclass("pytanie","a","b","c","d","a"));
        list.add(new Modelclass("pytanie","a","b","c","d","b"));
        list.add(new Modelclass("pytanie","a","b","c","d","c"));
        list.add(new Modelclass("pytanie","a","b","c","d","d"));
        list.add(new Modelclass("pytanie","a","b","c","d","a"));
        list.add(new Modelclass("pytanie","a","b","c","d","b"));
        list.add(new Modelclass("pytanie","a","b","c","d","c"));
        list.add(new Modelclass("pytanie","a","b","c","d","d"));
        list.add(new Modelclass("pytanie","a","b","c","d","a"));
        list.add(new Modelclass("pytanie","a","b","c","d","b"));
        list.add(new Modelclass("pytanie","a","b","c","d","c"));



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        }, 1500);

    }
}