package com.example.rookieofart;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PieceDetail extends AppCompatActivity{
    private TextView title;
    private TextView artist;
//    private TextView contact;
    private ImageView image;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.piece_detail);

        Intent intent = getIntent();
        int position = intent.getIntExtra("time", 0 );

//        int source = 0;
        ArtInfo artInfo = Singleton.getInstance().artInfos.get(position);

        title = (TextView) findViewById(R.id.title_tv);
        title.setText(artInfo.title);

        artist = (TextView) findViewById(R.id.artist_tv);
        artist.setText(artInfo.artist);

//        contact = (TextView) findViewById(R.id.contac_tv);
//        contact.setText(artInfo.contact);

        image = (ImageView) findViewById(R.id.detail_iv);
        image.setImageDrawable(artInfo.content);

    }
}
