package com.zyhp.restaurantmanagement.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;

/**
 * Created by Administrator on 2018/7/6.
 */

public class StaffSetActivity extends BaseActivity implements View.OnClickListener {
    private TextView view_publictitle_title;

    private RelativeLayout view_publictitle_back;
    Activity activity;
    ListView activity_staffset_listview ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staffset);
        activity = this;
        findView();
    }

    void findView() {
        view_publictitle_title = (TextView) findViewById(R.id.view_publictitle_title);
        view_publictitle_title.setText("员工管理");
        view_publictitle_back = (RelativeLayout) findViewById(R.id.view_publictitle_back);
        view_publictitle_back.setOnClickListener(this);

        activity_staffset_listview = (ListView) findViewById(R.id.activity_staffset_listview);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.view_publictitle_back:
                finish();
                break;
        }
    }

}
