package com.example.mryang.customview0102.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.mryang.customview0102.R;
import com.example.mryang.customview0102.indicator.activity.IndicatorActivity;
import com.example.mryang.customview0102.indicator.adapter.IndicatorAdpater;
import com.example.mryang.customview0102.lottery.LotteryActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomViewActivity extends AppCompatActivity {
    @BindView(R.id.cw_cricle)
    Button cwCricle;
    @BindView(R.id.cw_rectangle)
    Button cwRectangle;
    @BindView(R.id.cw_triangle)
    Button cwTriangle;
    @BindView(R.id.cw_sector)
    Button cwSector;
    @BindView(R.id.cw_ellipse)
    Button cwEllipse;
    @BindView(R.id.cw_curve)
    Button cwCurve;
    @BindView(R.id.cw_cylindricalgraph)
    Button cwCylindricalgraph;
    @BindView(R.id.cw_lottery)
    Button cwLottery;
    @BindView(R.id.cw_indicator)
    Button cwIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        ButterKnife.bind(this);



    }

    @OnClick({R.id.cw_cricle, R.id.cw_rectangle,R.id.cw_triangle,R.id.cw_sector,
            R.id.cw_ellipse,R.id.cw_curve,R.id.cw_cylindricalgraph,R.id.cw_lottery,R.id.cw_indicator})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cw_cricle:
                startActivity(new Intent(CustomViewActivity.this,CircleActivity.class));
                break;
            case R.id.cw_rectangle:
                startActivity(new Intent(CustomViewActivity.this,RectangleActivity.class));
                break;
            case R.id.cw_triangle:
                startActivity(new Intent(CustomViewActivity.this,TriangleActivity.class));
                break;
            case R.id.cw_sector:
                startActivity(new Intent(CustomViewActivity.this,SectorActivity.class));
                break;
            case R.id.cw_ellipse:
                startActivity(new Intent(CustomViewActivity.this,EllipseActivity.class));
                break;
            case R.id.cw_curve:
                startActivity(new Intent(CustomViewActivity.this,CurveActivity.class));
                break;
            case R.id.cw_cylindricalgraph:
                startActivity(new Intent(CustomViewActivity.this,CylindricalGraphActivity.class));
                break;
            case R.id.cw_lottery:
                startActivity(new Intent(CustomViewActivity.this,LotteryActivity.class));
                break;
            case R.id.cw_indicator:
                startActivity(new Intent(CustomViewActivity.this,IndicatorActivity.class));
                break;
        }
    }
}
