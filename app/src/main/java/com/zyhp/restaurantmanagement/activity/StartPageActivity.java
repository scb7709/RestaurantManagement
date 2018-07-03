package com.zyhp.restaurantmanagement.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;

import com.zyhp.restaurantmanagement.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2018/6/22.
 */

public class StartPageActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startpage);
        new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                startActivity(new Intent(StartPageActivity.this, LoginActivity.class));
                finish();
            }
        }.sendEmptyMessageDelayed(0, 2000);
    }

}
