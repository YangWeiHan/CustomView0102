package com.example.mryang.customview0102.indicator.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
//继承  View
public class CustomViewIndica extends View {

    //定义半径
    int mRadius = 30;
    //定义间距
    int mDistance = 20;
    //定义圆的总数
    int mTatolCount ;
    //画笔  空心圆
    private Paint stokePaint;
    //画笔  实心圆
    private Paint fillPaint;
    //判断在第几个页面
    int pagerCount;

    public CustomViewIndica(Context context) {
        super(context);
    }

    public CustomViewIndica(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        setMeasuredDimension(getFinalWidthMeasure(widthMeasureSpec),getFinalHeightMeasure(heightMeasureSpec));

    }



    private int getFinalHeightMeasure(int heightMeasureSpec) {
        int mode = MeasureSpec.getMode(heightMeasureSpec);
        int size = MeasureSpec.getSize(heightMeasureSpec);
        int finalHight = 0 ;
        switch (mode){
            case MeasureSpec.EXACTLY:
                finalHight = size;
                break;
            case MeasureSpec.AT_MOST:
                finalHight = getPaddingTop()+getPaddingBottom()+2*mRadius;
        }
        return finalHight;
    }

    private int getFinalWidthMeasure(int widthMeasureSpec) {
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        int size = MeasureSpec.getSize(widthMeasureSpec);
        int finalWidth = 0;
        switch (mode){
            case MeasureSpec.EXACTLY:
                finalWidth = size;
                break;
            case MeasureSpec.AT_MOST:
                finalWidth = getPaddingLeft()+mRadius+(mTatolCount-1)*(2*mRadius+mDistance)+mRadius+getPaddingRight();
                break;
        }
        return finalWidth;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画两组  一组空心  一组实心
        //空心圆
        stokePaint = new Paint();
        stokePaint.setStyle(Paint.Style.STROKE);
        stokePaint.setColor(Color.GREEN);
        //实心圆
        fillPaint = new Paint();
        fillPaint.setStyle(Paint.Style.FILL);
        fillPaint.setColor(Color.BLACK);

        //画圆  i 的索引要从1  开始
        //循环圆的个数
        for (int i = 1; i <=mTatolCount ; i++) {
            //计算公式：getPaddingLeft+R+（圆个数-1）*（2R+间距）
            //计算X轴坐标  Y 轴的坐标是不变的
            //画一个空心圆
        canvas.drawCircle(getPaddingLeft() + mRadius + (i - 1) * (2 * mRadius + mDistance),
                getPaddingTop() + mRadius,
                mRadius,
                stokePaint);
        }
        //画一个实心圆
        canvas.drawCircle(getPaddingLeft() + mRadius + (pagerCount) * (2 * mRadius + mDistance),
                getPaddingTop() + mRadius,
                mRadius,
                fillPaint);
    }
    //获取总数
    public void getCount(int mTatolCount){
        this.mTatolCount = mTatolCount;
    }
    //获取当前到底是哪个被选中，获取页面下标
    public void getPagerCount(int pagerCount) {
        this.pagerCount = pagerCount;
        //重绘方法
        invalidate();
    }

}
