package com.zyhp.restaurantmanagement.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;

/**
 * Created by Administrator on 2018/6/22.
 */

public class LoginActivity extends BaseActivity {
    TextView activity_login_register_text, activity_login_forgetPwd;
    EditText activity_login_phone, activity_login_password;
    Button activity_login_login_go;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
                startActivity(new Intent(LoginActivity.this, ForgetPasswordActivity.class));
            }
        });
        activity_login_register_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
        activity_login_login_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            }
        });


    }
}
