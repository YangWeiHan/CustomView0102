package com.example.mryang.customview0102.indicator.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mryang.customview0102.R;
import com.example.mryang.customview0102.indicator.adapter.IndicatorAdpater;
import com.example.mryang.customview0102.indicator.customview.CustomViewIndica;
import com.example.mryang.customview0102.indicator.fragment.FragmentOne;
import com.example.mryang.customview0102.indicator.fragment.FragmentThree;
import com.example.mryang.customview0102.indicator.fragment.FragmentTwo;

import java.util.ArrayList;

public class IndicatorActivity extends AppCompatActivity {
    private ViewPager vp_container;
    private CustomViewIndica ci_indica;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicator);
        vp_container = findViewById(R.id.vp_container);
        ci_indica = findViewById(R.id.ci_indica);

        FragmentManager manager = getSupportFragmentManager();
        //集合
        ArrayList<Fragment> fragments = new ArrayList<>();
        FragmentOne fragmentOne = new FragmentOne();
        FragmentTwo fragmentTwo = new FragmentTwo();
        FragmentThree fragmentThree = new FragmentThree();
        fragments.add(fragmentOne);
        fragments.add(fragmentTwo);
        fragments.add(fragmentThree);
        //设置适配器
        IndicatorAdpater adpater = new IndicatorAdpater(manager,fragments);
        vp_container.setAdapter(adpater);
        //在自定义View中传入总页面数
        int count = adpater.getCount();
        ci_indica.getCount(count);
        //当前选中的页面
        vp_container.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                ci_indica.getPagerCount(i);

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
