package com.zyhp.restaurantmanagement.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.utils.MyShow;
import com.zyhp.restaurantmanagement.utils.ShareUitls;

/**
 * Created by Administrator on 2018/6/22.
 */

public class LoginActivity extends BaseActivity {
    TextView activity_login_register_text, activity_login_forgetPwd;
    EditText activity_login_phone, activity_login_password;
    Button activity_login_login_go;
    Activity activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        activity = this;
        initializecontrol();
    }

    public void initializecontrol() {
        activity_login_register_text = (TextView) findViewById(R.id.activity_login_register_text);
        activity_login_forgetPwd = (TextView) findViewById(R.id.activity_login_forgetPwd);
        activity_login_phone = (EditText) findViewById(R.id.activity_login_phone);
        activity_login_password = (EditText) findViewById(R.id.activity_login_password);
        activity_login_login_go = (Button) findViewById(R.id.activity_login_login_go);
        activity_login_forgetPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterAndChengePasswordActivity.class).putExtra("flag","chenegepassword"));
            }
        });
        activity_login_register_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterAndChengePasswordActivity.class).putExtra("flag","register"));
            }
        });
        activity_login_login_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });


    }

    public void login() {
        String login_phone = activity_login_phone.getText().toString();
        String login_password = activity_login_password.getText().toString();
        if (login_phone.length() > 0 && login_password.length() > 0) {
            ShareUitls.putString(activity, "login_phone", login_phone);//本地储存账户信息
            ShareUitls.putString(activity, "login_password", login_password);//本地储存账户信息
            startActivity(new Intent(activity, MainActivity.class));
            finish();
        } else {
            MyShow.myToash(activity, "账户和密码不能为空");
        }

    }
}
