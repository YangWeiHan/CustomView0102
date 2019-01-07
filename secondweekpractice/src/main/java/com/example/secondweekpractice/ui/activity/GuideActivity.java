package com.example.secondweekpractice.ui.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.czp.library.ArcProgress;
import com.czp.library.OnTextCenter;
import com.example.secondweekpractice.R;

public class GuideActivity extends AppCompatActivity {
    private TextView textView;
    private ArcProgress mProgress;
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            ArcProgress progressBar = (ArcProgress)msg.obj;
            progressBar.setProgress(msg.what);
            return true;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        textView = findViewById(R.id.textView_tex);
        ObjectAnimator translationY = ObjectAnimator.ofFloat(textView, "translationY", 0, 200, 0, 200, 0, 200);

        translationY.setDuration(3000);
        translationY.setRepeatCount(-1);
        translationY.start();

        //找控件
        mProgress = findViewById(R.id.myProgress);
        //默认实现的类
        mProgress.setOnCenterDraw(new OnTextCenter(Color.BLUE, 50));

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <=100 ; i++) {
                    //判断结束
                    if (isFinishing()){
                        break;
                    }
                    //系统停滞时间  300毫秒
                    SystemClock.sleep(50);
                    handler.sendMessage(handler.obtainMessage(i, mProgress));
                    if (i == 100){
                        startActivity(new Intent(GuideActivity.this,ShowActivity.class));
                    }
                }

            }
        }).start();
    }
}
