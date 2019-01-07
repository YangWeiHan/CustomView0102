package com.example.mryang.customview0102.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CustomViewRectangle extends View {


    public CustomViewRectangle(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //画笔
        Paint paint = new Paint();
        //STROKE 和 FILL_AND_STROKE  空心 实心
        paint.setStyle(Paint.Style.FILL_AND_STROKE);//边线
        paint.setStrokeWidth(20);//线条的宽度
        canvas.drawRect(100,100,500,500,paint);
    }
}
