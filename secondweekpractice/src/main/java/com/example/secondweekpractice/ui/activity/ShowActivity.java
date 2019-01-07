package com.example.secondweekpractice.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.secondweekpractice.R;
import com.example.secondweekpractice.data.adapter.FragmentAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowActivity extends AppCompatActivity {

    @BindView(R.id.vp_contains)
    ViewPager vpContains;
    @BindView(R.id.tab_contains)
    TabLayout tabContains;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ButterKnife.bind(this);

        vpContains.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        tabContains.setupWithViewPager(vpContains);
    }
}
