package com.zyhp.restaurantmanagement.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.adapter.ActivityAdapter;
import com.zyhp.restaurantmanagement.entity.Myactivity;
import com.zyhp.restaurantmanagement.utils.MyShow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/6.
 */

public class CompletePayActivity extends BaseActivity  implements View.OnClickListener{
    private TextView view_publictitle_title,activity_completepay_name,activity_completepay_price;

    private RelativeLayout view_publictitle_back;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completepay);
        findView();
    }

    void findView() {
        view_publictitle_title = (TextView) findViewById(R.id.view_publictitle_title);
        view_publictitle_title.setText("支付订单");
        view_publictitle_back = (RelativeLayout) findViewById(R.id.view_publictitle_back);
        view_publictitle_back.setOnClickListener(this);
        Intent intent=getIntent();
        activity_completepay_name = (TextView) findViewById(R.id.activity_completepay_name);
        activity_completepay_price = (TextView) findViewById(R.id.activity_completepay_price);
        activity_completepay_name.setText(intent.getStringExtra("name"));
        activity_completepay_price.setText(intent.getStringExtra("totalPrice"));
        findViewById(R.id.activity_pay_commit).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.view_publictitle_back:
                finish();
                break;
            case R.id.activity_pay_commit:
                MyShow.myToash(CompletePayActivity.this,"购买成功");
                setResult(0);
                finish();
                break;

        }
    }
}
