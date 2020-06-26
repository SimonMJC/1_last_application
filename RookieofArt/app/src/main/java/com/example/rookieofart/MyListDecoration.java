package com.example.rookieofart;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyListDecoration extends RecyclerView.ItemDecoration {
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
 //아이템 간의 간격 조정 
        if (parent.getChildAdapterPosition(view)!=parent.getAdapter().getItemCount()-1){
            outRect.right = 30;
        }
    }
}
