package com.example.mryang.customview0102.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class CustomCylindricalgraph extends View {
     private Paint paint;
     //得到展示页面传来的值以后  把它存到单前页面的一个数组里
     private int[] top;
     //为什么设置为top
    /*
    * 如果300 为总体的高度  输入100时那么柱形图的高度就应给是100
    * 但是这100 是怎么来的呢 如果从X轴到矩形顶部为200的时候矩形高度为100
    * 那么这200 怎么来  总体300-输入框的值100 = 200
    * */
    public CustomCylindricalgraph(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();

        paint.setStrokeWidth(10);//线条宽度(粗细)
        paint.setStyle(Paint.Style.FILL);//实心
    }


    //得到数据
    public void setData(int[] num){
        int First  = num[0];
        int Second = num[1];
        int Third  = num[2];
        //存入当前页面的数组
        top = new int[]{First,Second,Third};

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置三个矩形
        //第一个  数据+画笔
        paint.setColor(Color.RED);
        canvas.drawRect(60,300-top[0],170,300,paint);
        paint.setColor(Color.YELLOW);
        canvas.drawRect(200,300-top[1],310,300,paint);
        paint.setColor(Color.GREEN);
        canvas.drawRect(340,300-top[2],450,300,paint);
        //设置两个坐标轴
        paint.setColor(Color.DKGRAY);
        //這兩個坐標軸就是兩條綫  线  drawLine
        //X  轴
        canvas.drawLine(10,300,500,300,paint);
        //Y  轴
        canvas.drawLine(10,10,10,300,paint);
    }
}
