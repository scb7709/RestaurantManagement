package com.zyhp.restaurantmanagement.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.entity.Order;

/**
 * Created by Administrator on 2018/7/2.
 */

public class OrderDetialsActivity extends BaseActivity implements View.OnClickListener {

    private TextView view_publictitle_title;

    private RelativeLayout view_publictitle_back;
    Intent intent;
    Order order;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderdetails);
        intent = getIntent();
        order = (Order)intent.getSerializableExtra("order");
        findView();
    }

    void findView() {
        view_publictitle_title = (TextView) findViewById(R.id.view_publictitle_title);
        view_publictitle_title.setText("订单详情");
        view_publictitle_back = (RelativeLayout) findViewById(R.id.view_publictitle_back);
        view_publictitle_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.view_publictitle_back:
                finish();
                break;
            case 0:

                break;

        }
    }
}
