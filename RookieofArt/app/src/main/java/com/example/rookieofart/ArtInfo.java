package com.example.rookieofart;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

import androidx.appcompat.app.AppCompatActivity;

public class ArtInfo {
    String title;
    String artist;
    BitmapDrawable content;

    public ArtInfo(String title, String artist, BitmapDrawable content){
        this.artist = artist;
        this.title = title;
        this.content = content;
    }
}
