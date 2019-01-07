package com.example.mryang.customview0102.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.mryang.customview0102.R;

public class CustomViewSector extends View {


    private int color;
    private int startAngle;
    private int sweepAngle;

    public CustomViewSector(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomViewSector);

        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount ; i++) {
            int index = typedArray.getIndex(i);
            switch (index){
                case R.styleable.CustomViewSector_sColor:
                    color = typedArray.getColor(index, Color.GRAY);
                    break;
                case R.styleable.CustomViewSector_startAngle:
                    startAngle = typedArray.getInt(index, 50);
                    break;
                case R.styleable.CustomViewSector_sweepAngle:
                    sweepAngle = typedArray.getInt(index, 50);
                    break;
            }
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        //设置画笔  无抗锯齿
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);
        /*
        * RectF   就是 固定一个矩形  设置它的大小
        * */
        RectF rectF = new RectF(100,100,500,500);
        /*
        * startAngle  圆弧起始角度
        * sweepAngle  圆弧扫过的角度 从起始角度到结束的角度
        *             他是按照顺时针方向去旋转
        * useCenter   如果为TURE 圆心包括在内
        * */
        canvas.drawArc(rectF,startAngle,sweepAngle,true,paint);
    }
}
