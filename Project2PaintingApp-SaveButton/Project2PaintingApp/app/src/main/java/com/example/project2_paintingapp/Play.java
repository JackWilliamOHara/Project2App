package com.example.project2_paintingapp;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class Play extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);
    }

        public void goTop(View view)
        {
            Intent i = new Intent(Play.this, Can1.class);
            startActivity(i);
        }

        public void goMid(View view)
        {
            Intent i = new Intent(Play.this, Can2.class);
            startActivity(i);
        }

        public void goBottom(View view)
        {
            Intent i = new Intent(Play.this, Can3.class);
            startActivity(i);
        }

}
