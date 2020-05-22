package com.coderpig.vegetableshop;

import androidx.core.widget.ListViewCompat;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.*;
public class ListViewPlusActivity extends ListView {
    public ListViewPlusActivity(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        /*获得新高度*/
        int newHeightSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, newHeightSpec);
    }
}