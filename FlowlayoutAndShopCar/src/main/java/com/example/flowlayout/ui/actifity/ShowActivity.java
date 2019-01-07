package com.example.flowlayout.ui.actifity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.flowlayout.R;
import com.example.flowlayout.di.WeekFlowLayout;

import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShowActivity extends AppCompatActivity {

    @BindView(R.id.main_edit)
    EditText mainEdit;
    @BindView(R.id.btn_search)
    Button btnSearch;
    @BindView(R.id.Historical_record)
    Button HistoricalRecord;
    @BindView(R.id.flowLayout)
    WeekFlowLayout flowLayout;
    @BindView(R.id.clean_all)
    Button cleanAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_search, R.id.Historical_record, R.id.clean_all})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_search:
                //获取随机数
                UUID uuid = UUID.randomUUID();
                //定义一个控件 存放输入框的值
                final TextView textView = new TextView(ShowActivity.this);
                //获取输入框的值
                textView.setText(mainEdit.getText().toString());
                //设置字体颜色
                textView.setTextColor(Color.DKGRAY);
                //设置背景色
                textView.setBackgroundResource(R.color.colorAccent);
                textView.setTextSize(35);
                //添加
                flowLayout.addView(textView);
                //给textView  设置点击事件
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String uuid = String.valueOf(v.getTag());
                        Toast.makeText(ShowActivity.this,""+textView.getText().toString(),Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.Historical_record:
                break;
            case R.id.clean_all:
                flowLayout.removeAllViews();
                break;
        }
    }
}
