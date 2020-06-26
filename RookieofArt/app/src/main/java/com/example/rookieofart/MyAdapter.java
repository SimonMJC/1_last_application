package com.example.rookieofart;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//RecyclerView Adapter class
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<ArtInfo> itemList;
    private Context context;
    private View.OnClickListener onClickItem;

    public ImageView imageView;

   public MyAdapter (Context context, ArrayList<ArtInfo> itemList, View.OnClickListener onClickItem){
       this.context = context;
       this.itemList = itemList;
       this.onClickItem = onClickItem;
   }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_iv, parent, false);
        imageView = (ImageView) view;
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       holder.imageView.setImageDrawable(itemList.get(position).content);
//    holder.textview.setText(item);
//    holder.textview.setTag(item);
//    holder.textview.setOnClickListener(onClickItem);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
//        public TextView textview;


        public ImageView imageView;
        public ViewHolder(View itemView){
            super(itemView);
            imageView = (ImageView) itemView;
            imageView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    //event

//                    Log.v("Test", itemList.get(getAdapterPosition()).artist);
//                    Log.v("Test", itemList.get(getAdapterPosition()).title);
                    Intent intent = new Intent(context, PieceDetail.class);

                    intent.putExtra("time",getAdapterPosition());
                    context.startActivity(intent);
//                    Toast.makeText(context)
                }
            });
        }
    }
}
