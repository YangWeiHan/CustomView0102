package com.example.secondweekpractice.data.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.secondweekpractice.ui.fragment.MainFragment;
import com.example.secondweekpractice.ui.fragment.NewsFragment;

public class FragmentAdapter extends FragmentPagerAdapter {

    //设置数据  展示几个Fragment
    private String[] list = new String[]{
      "数据展示","我的页面"
    };
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
               return new NewsFragment();

            case 1:
                return new MainFragment();

            default:
                return new Fragment();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list[position];
    }

    @Override
    public int getCount() {
        return list.length;
    }
}
