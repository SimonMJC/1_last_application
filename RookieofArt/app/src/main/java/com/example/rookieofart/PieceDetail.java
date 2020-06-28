package com.example.rookieofart;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
        image = (ImageView) findViewById(R.id.detail_iv);
        image.setImageDrawable(artInfo.content);

    }
}
