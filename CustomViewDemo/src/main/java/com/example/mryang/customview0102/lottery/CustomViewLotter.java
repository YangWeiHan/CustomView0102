package com.example.mryang.customview0102.lottery;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mryang.customview0102.R;

import java.nio.Buffer;

public class CustomViewLotter extends LinearLayout implements View.OnClickListener {


    private View rootView;
    private Button btn_del,btn_add;
    private TextView tv_number;

    public CustomViewLotter(Context context, AttributeSet attrs) {
        super(context, attrs);
        rootView = LayoutInflater.from(context).inflate(R.layout.toggle_button_view, this);
        btn_add = rootView.findViewById(R.id.btn_add);
        btn_del = rootView.findViewById(R.id.btn_delete);
        tv_number = rootView.findViewById(R.id.tv_number);
        btn_del.setOnClickListener(this);
        btn_add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String textViewNum = tv_number.getText().toString();
        int num = Integer.parseInt(textViewNum);
        switch (v.getId()){
            case R.id.btn_add:
                num+=2;
                break;
            case R.id.btn_delete:
                num--;
                break;
        }
        tv_number.setText(num+"");

    }
}
