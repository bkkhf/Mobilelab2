package com.example.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Fullimage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullimage);

        // get intent data
//        Intent i = getIntent();
//
//        // Selected image id
//        int position = i.getExtras().getInt("id");
//        ImageAdapter imageAdapter = new ImageAdapter(this);
//
//        ImageView imageView = (ImageView) findViewById(R.id.full_image_view);
//        imageView.setImageResource(imageAdapter.mThumbIds[position]);
    }
}
