package com.example.mryang.customview0102.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.mryang.customview0102.R;

//继承  View
public class CustomViewCircle extends View {
    private int mColor;
    private int mRadius;

    //重写里面的方法
    //Context上下文和AttributeSet属性集
    public CustomViewCircle(Context context,@Nullable AttributeSet attrs) {
        super(context, attrs);
        //自定义属性集的获取
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.CustomViewCircle);
        //拆解出所有的自定义属性
        int count = attributes.getIndexCount();
        //遍歷所有
        for (int i = 0; i <count ; i++) {
            //得到所有的索引
            int index = attributes.getIndex(i);
            switch (index){
                case R.styleable.CustomViewCircle_mColor:
                    mColor = attributes.getColor(index, Color.GRAY);
                    break;
                case R.styleable.CustomViewCircle_mRadius:
                    mRadius = attributes.getInt(index, 50);
            }
        }

    }
    //绘制
    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        //设置画笔
        //ANTI_ALIAS_FLAG  动态开关抗锯齿  就是表面是不是圆的
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        //设置颜色
        paint.setColor(mColor);

        //画一个圆
        canvas.drawCircle(200,200,mRadius,paint);

    //在对应的  布局文件中加上此自定义布局   全包名+类名
    }
}
