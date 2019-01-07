package com.example.mryang.customview0102.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.example.mryang.customview0102.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CylindricalGraphActivity extends AppCompatActivity {

    @BindView(R.id.Edit_one)
    EditText EditOne;
    @BindView(R.id.Edit_two)
    EditText EditTwo;
    @BindView(R.id.Edit_three)
    EditText EditThree;
    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cylindrical_graph);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        //当点击按钮以后 要获得三个数据
        //定义一个集合把这3 个值放里面之后把它传到展示页面
        ArrayList<Integer> list = new ArrayList<>();
        //获得三个输入框的值
        int inputchart_one = Integer.parseInt(EditOne.getText().toString());
        int inputchart_two = Integer.parseInt(EditTwo.getText().toString());
        int inputchart_three = Integer.parseInt(EditThree.getText().toString());
        //把三个值传进集合里
        list.add(inputchart_one);
        list.add(inputchart_two);
        list.add(inputchart_three);

        Intent intent = new Intent(CylindricalGraphActivity.this,ShowActivity.class);
        //把集合传过去
        intent.putIntegerArrayListExtra("list",list);
        startActivity(intent);
    }
}
