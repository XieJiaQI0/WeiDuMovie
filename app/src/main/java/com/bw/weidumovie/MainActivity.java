package com.bw.weidumovie;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bw.weidumovie.activity.GuideActivity;

public class MainActivity extends AppCompatActivity {

    private int time = 2;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                if (time <= 0) {
                    Intent intent = new Intent(MainActivity.this, GuideActivity.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(R.anim.act_in, R.anim.act_out);
                    return;
                } else {
                    time--;
                    handler.sendEmptyMessageDelayed(0, 1000);
                }

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler.sendEmptyMessageDelayed(0, 1000);
    }
}
