package com.example.secondweekpractice.ui.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.secondweekpractice.R;

public class TitleBar extends LinearLayout {
    private Context mContext;
    public TitleBar(Context context) {
        super(context);
        mContext = context;
        init();
    }



    public TitleBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }
    private void init() {
        View view =View.inflate(mContext, R.layout.titlebar_layout,null);
        final EditText editText = view.findViewById(R.id.search_edit);
        view.findViewById(R.id.search_image).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onButtonClickLinster != null){
                    onButtonClickLinster.onButtonClick(editText.getText().toString());
                }
            }
        });
        addView(view);
    }
    //接口
    OnButtonClickLinster onButtonClickLinster;

    public void setOnButtonClickLinster(OnButtonClickLinster onButtonClickLinster) {
        this.onButtonClickLinster = onButtonClickLinster;
    }

    public interface OnButtonClickLinster{
        void onButtonClick(String str);
    }

}
