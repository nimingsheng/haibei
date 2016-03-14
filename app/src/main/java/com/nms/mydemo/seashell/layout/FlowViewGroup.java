package com.nms.mydemo.seashell.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by my on 2016/3/7.
 */
public class FlowViewGroup extends ViewGroup{
    private int defWith;
    private int defHeight;

    public FlowViewGroup(Context context) {
        this(context, null);
    }

    public FlowViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlowViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        if (widthMode == MeasureSpec.AT_MOST){
            defWith = 150;
        }else {
            defWith = width;
        }
        if (heightMode == MeasureSpec.AT_MOST){
            defHeight = 120;
        }else {
            defHeight = height;
        }
        setMeasuredDimension(defWith, defHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int parrentWidth = getMeasuredWidth();
        int childCount = getChildCount();
        int startLenth = 0;
        int endLenth = 0;
        int endLenth1 = 0;
        int endLenth2 = 0;
        for (int i =1;i<childCount+1;i++){
            View view = getChildAt(i-1);
            int childWidth = view.getMeasuredWidth();
            int childHeight = view.getMeasuredHeight();
            endLenth = 10+childWidth+endLenth;
            startLenth = endLenth - childWidth;
            if (endLenth <= parrentWidth){
                view.layout(startLenth,10,endLenth,10+childHeight);
            }else if (endLenth>parrentWidth&&endLenth<=parrentWidth*2){
                endLenth1 = 10 +childWidth +endLenth1;
                startLenth = endLenth1 - childWidth;
                view.layout(startLenth,20+childHeight,endLenth1,20+childHeight*2);
            }else if (endLenth>parrentWidth*2&&endLenth<=parrentWidth*3){
                endLenth2 = 10 +childWidth +endLenth2;
                startLenth = endLenth2 - childWidth;
                view.layout(startLenth,30+childHeight*2,endLenth2,30+childHeight*3);
            }
        }
    }
}
