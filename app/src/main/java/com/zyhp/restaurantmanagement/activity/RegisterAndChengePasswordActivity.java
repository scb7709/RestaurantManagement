package com.zyhp.restaurantmanagement.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.utils.MyShow;
import com.zyhp.restaurantmanagement.utils.Regular;

/**
 * Created by Administrator on 2018/6/22.
 */

public class RegisterAndChengePasswordActivity extends BaseActivity implements View.OnClickListener {

    private TextView view_publictitle_title;

    private RelativeLayout view_publictitle_back;
    String flag = "";
    EditText activity_registerandchengepassword_phone, activity_registerandchengepassword_verifycode, activity_registerandchengepassword_pwd,
            activity_registerandchengepassword_pwd_again;
    Button activity_registerandchengepassword_getverifycode;
    Activity activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerandchengepassword);
        activity = RegisterAndChengePasswordActivity.this;
        flag = getIntent().getStringExtra("flag");
        findView();
    }

    void findView() {
        view_publictitle_title = (TextView) findViewById(R.id.view_publictitle_title);
        view_publictitle_back = (RelativeLayout) findViewById(R.id.view_publictitle_back);
        view_publictitle_back.setOnClickListener(this);
        activity_registerandchengepassword_phone = (EditText) findViewById(R.id.activity_registerandchengepassword_phone);
        activity_registerandchengepassword_verifycode = (EditText) findViewById(R.id.activity_registerandchengepassword_verifycode);
        activity_registerandchengepassword_pwd = (EditText) findViewById(R.id.activity_registerandchengepassword_pwd);
        activity_registerandchengepassword_pwd_again = (EditText) findViewById(R.id.activity_registerandchengepassword_pwd_again);

        activity_registerandchengepassword_getverifycode = (Button) findViewById(R.id.activity_registerandchengepassword_getverifycode);
        activity_registerandchengepassword_getverifycode.setOnClickListener(this);
        findViewById(R.id.activity_registerandchengepassword_ok).setOnClickListener(this);
        switch (flag) {
            case "register":
                view_publictitle_title.setText("用户注册");
                activity_registerandchengepassword_pwd.setHint("请输入密码");
                activity_registerandchengepassword_pwd_again.setHint("确认密码");
                break;
            case "chenegepassword":
                view_publictitle_title.setText("更改密码");
                activity_registerandchengepassword_pwd.setHint("请输入新密码");
                activity_registerandchengepassword_pwd_again.setHint("确认新密码");
                break;

        }

    }


    @Override
    public void onClick(View view) {
        String phone;
        switch (view.getId()) {
            case R.id.view_publictitle_back:
                time.cancel();
                finish();
                break;

            case R.id.activity_registerandchengepassword_getverifycode:
                phone = activity_registerandchengepassword_phone.getText().toString();
                if (phone.length() == 0) {
                    MyShow.myToash(activity, "手机号不能为空");
                } else {
                    if (phone.length() != 11) {
                        MyShow.myToash(activity, "手机号必须11位");
                    } else {
                        if (!Regular.isMobile(phone)) {
                            MyShow.myToash(activity, "手机号格式错误");
                        } else {
                            activity_registerandchengepassword_getverifycode.setClickable(false);
                            time.start();
                            getverifycode();
                        }
                    }
                }
                break;

            case R.id.activity_registerandchengepassword_ok:

                phone = activity_registerandchengepassword_phone.getText().toString();
                String verifycode = activity_registerandchengepassword_verifycode.getText().toString();
                String password1 = activity_registerandchengepassword_pwd.getText().toString();
                String password2 = activity_registerandchengepassword_pwd_again.getText().toString();
                if (phone.length() == 0) {
                    MyShow.myToash(activity, "手机号不能为空");
                } else {
                    if (phone.length() != 11) {
                        MyShow.myToash(activity, "手机号必须11位");
                    } else {
                        if (!Regular.isMobile(phone)) {
                            MyShow.myToash(activity, "手机号格式错误");
                        } else {
                            if (verifycode.length() == 0) {
                                MyShow.myToash(activity, "验证码不能为空");
                            } else {
                                if(password1.length()>0&&password2.length()>0){
                                    if(password1.equals(password2)){

                                        if (true) {//验证码正确性检验
                                            time.cancel();
                                            switch (flag) {
                                                case "register":
                                                    startActivity(new Intent(activity, MainActivity.class));
                                                    finish();
                                                    break;
                                                case "chenegepassword":
                                                    startActivity(new Intent(activity, LoginActivity.class));
                                                    finish();
                                                    break;

                                            }
                                        }
                                    }else {
                                        MyShow.myToash(activity, "密码不一致");
                                    }

                                }else {
                                    MyShow.myToash(activity, "密码不能为空");
                                }

                            }
                        }
                    }
                }


                break;

        }
    }

    private void getverifycode() {

    }

    TimeCount time = new TimeCount(60000, 1000);

    class TimeCount extends CountDownTimer {
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);//参数依次为总时长,和计时的时间间隔
        }

        @Override
        public void onFinish() {//计时完毕时触发
            activity_registerandchengepassword_getverifycode.setText("重获验证码");
            activity_registerandchengepassword_getverifycode.setClickable(true);
            activity_registerandchengepassword_getverifycode.setTextColor(Color.parseColor("#ffad00"));
        }

        @Override
        public void onTick(long millisUntilFinished) {//计时过程显示
            activity_registerandchengepassword_getverifycode.setText("重获验证码(" + (millisUntilFinished / 1000) + ")");
            activity_registerandchengepassword_getverifycode.setTextColor(Color.GRAY);

        }
    }
}
