package com.example.mryang.customview0102.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class CustomViewCurve extends View {
/*
* 曲线
* */
    public CustomViewCurve(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        //设置画笔颜色
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(20);//线条宽度

        paint.setStyle(Paint.Style.STROKE);//设置空心
        Path path = new Path();//动态绘制
        path.moveTo(80,50);//这里是其实位置
        path.quadTo(150,250,400,80);//它经过哪些点
        canvas.drawPath(path,paint);


    }
}
