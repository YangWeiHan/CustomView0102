package com.example.mryang.customview0102.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/*
* 椭圆
* */
public class CustomViewEllipse extends View {
    public CustomViewEllipse(Context context,AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //先写画布
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);//抗锯齿
        //设置颜色
        paint.setColor(Color.RED);
        //定义一个 矩形
        RectF rectF = new RectF(100,100,500,800);
        rectF.set(100,50,400,130);
        //椭圆
        canvas.drawOval(rectF,paint);

    }
}
