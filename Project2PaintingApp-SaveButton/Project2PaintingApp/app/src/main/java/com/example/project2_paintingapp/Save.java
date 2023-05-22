package com.example.project2_paintingapp;

import static com.example.project2_paintingapp.Display.colorList;
import static com.example.project2_paintingapp.Display.current_brush;
import static com.example.project2_paintingapp.Display.pathlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import static com.example.project2_paintingapp.Canvas.paint_brush;
import static com.example.project2_paintingapp.Canvas.path;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;

public class Save extends AppCompatActivity {

    Button saveimage;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save);

        saveimage =  (Button)findViewById(R.id.savegallery);

        ActivityCompat.requestPermissions(Save.this,new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        ActivityCompat.requestPermissions(Save.this,new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},1);

        saveimage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                saveToGallery();
            }
        });
    }

    private void saveToGallery(){
        BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = bitmapDrawable.getBitmap();

        FileOutputStream outputStream = null;
        File file = Environment.getExternalStorageDirectory();
        File dir = new File(file.getAbsolutePath() + "/MyPics");
        dir.mkdirs();

        String filename = String.format("%d.png",System.currentTimeMillis());
        File outFile = new File(dir,filename);
        try {
            outputStream = new FileOutputStream(outFile);
        }catch (Exception e){
            e.printStackTrace();
        }
        bitmap.compress(Bitmap.CompressFormat.PNG,100,outputStream);
        try{
            outputStream.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void goNext(View view)
    {
        Intent i = new Intent(Save.this, Home.class);
        startActivity(i);
    }

    public void onClick(View view) {
    }
}