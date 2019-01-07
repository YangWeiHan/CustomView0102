package com.example.mryang.customview0102.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class CostomViewTriangle extends View {
    public CostomViewTriangle(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        //在画三角形的时候  要实例化路径 路径是PATH
        Path path = new Path();
        path.moveTo(200,200);
        path.lineTo(100,300);
        path.lineTo(300,300);
        path.close();//关闭(封闭)
        canvas.drawPath(path,paint);
    }
}
