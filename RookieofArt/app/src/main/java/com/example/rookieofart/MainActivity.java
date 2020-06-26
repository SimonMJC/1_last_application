package com.example.rookieofart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listview;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //광고창 배너 클릭 시 해당 링크로 이동
        final ImageView newsImageView1 = findViewById(R.id.news1);
        newsImageView1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.artsum.co.kr/contest_detail.php?num=1699"));
                startActivity(intent);
            }
        });

               //setting Activity로 이동
        ImageButton setting = (ImageButton) findViewById(R.id.setting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BioProfile.class);
                startActivity(intent);
            }
        });
        //사진 recyclerView 함수 호출
        init();
    }

    private void init() {
        listview = findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        listview.setLayoutManager(layoutManager);

        ArrayList<Integer> itemList = new ArrayList<>();
        itemList.addAll(Arrays.asList(
                R.drawable.car,
                R.drawable.guitar,
                R.drawable.vio,
                R.drawable.walk));

    //ArrayList<BitmapDrawable> il = new ArrayList<>();
        Bitmap bitmap;
        BitmapFactory.Options option = new BitmapFactory.Options();
        option.inSampleSize = 4;

//ArtInfo 클래스를 불러 배열에 담은 뒤 액티비티 상 이미지를 띄울 수 있게 반복
        ArrayList<ArtInfo> artInfos = new ArrayList<>();
        for (int i = 0; i < itemList.size(); i++) {

            ArtInfo artInfo = new ArtInfo("Title:" + i, "Artist" + i,
                    new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), itemList.get(i), option)));

            artInfos.add(artInfo);
        }
        //Singleton의 artinfo에 artInfo
        Singleton.getInstance().artInfos = artInfos;


//        itemList.add(R.drawable.car_pic);
        adapter = new MyAdapter(this, artInfos, onClickItem);
        listview.setAdapter(adapter);

        MyListDecoration decoration = new MyListDecoration();
        listview.addItemDecoration(decoration);
    }

    private View.OnClickListener onClickItem = new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {
//            String string = (String) v.getTag();
//            Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent()
        }
    };
    }

