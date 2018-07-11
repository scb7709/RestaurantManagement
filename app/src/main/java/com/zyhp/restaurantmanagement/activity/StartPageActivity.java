package com.zyhp.restaurantmanagement.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.utils.ShareUitls;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2018/6/22.
 */

public class StartPageActivity extends Activity {
    Activity activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startpage);
        activity = this;
        new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
//检查本地保存的账户信息
                String login_phone = ShareUitls.getString(activity, "login_phone", "");
                String login_password = ShareUitls.getString(activity, "login_password", "");

                if (login_phone.length() > 0 && login_password.length() > 0) {
                    login();

                } else {
                    startActivity(new Intent(activity, LoginActivity.class));
                }
                finish();
            }
        }.sendEmptyMessageDelayed(0, 2000);
    }

    public void login() {
        startActivity(new Intent(activity, MainActivity.class));
    }
}
