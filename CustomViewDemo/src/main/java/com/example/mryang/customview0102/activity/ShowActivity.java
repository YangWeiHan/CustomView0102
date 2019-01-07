package com.example.mryang.customview0102.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mryang.customview0102.R;
import com.example.mryang.customview0102.customview.CustomCylindricalgraph;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        //跳转成功
        Intent intent = getIntent();
        //获取到传过来的值
        ArrayList<Integer> list = intent.getIntegerArrayListExtra("list");
        //得到传过来的值
        int First_Value  = list.get(0);
        int Second_Value  = list.get(1);
        int Third_Values = list.get(2);
        //设置一个数组把值放进去
        int[] num = new int[]{First_Value,Second_Value,Third_Values};
        //得到布局中的那个自定义View
        CustomCylindricalgraph cylindricalgraph = findViewById(R.id.Cylindricalgraph);

        cylindricalgraph.setData(num);
    }
}
