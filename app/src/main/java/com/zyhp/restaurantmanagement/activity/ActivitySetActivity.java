package com.zyhp.restaurantmanagement.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.adapter.ActivityAdapter;
import com.zyhp.restaurantmanagement.entity.Myactivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/6.
 */

public class ActivitySetActivity extends BaseActivity  implements View.OnClickListener{
    private TextView view_publictitle_title;

    private RelativeLayout view_publictitle_back;

    ListView activity_activityset_listview;
    ActivityAdapter activityAdapter;
    List<Myactivity> myactivities;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activityset);
        findView();
    }

    void findView() {
        view_publictitle_title = (TextView) findViewById(R.id.view_publictitle_title);
        view_publictitle_title.setText("活动设置");
        view_publictitle_back = (RelativeLayout) findViewById(R.id.view_publictitle_back);
        view_publictitle_back.setOnClickListener(this);

        activity_activityset_listview= (ListView) findViewById(R.id.activity_activityset_listview);
        myactivities=new ArrayList<>();
        //String type, String number, String limit, String date, String state
        myactivities.add(new Myactivity("满减券","5","消费满98元可用","2018.1.1-2018.12.30","正在进行"));
        myactivities.add(new Myactivity("满减券","10","消费满158元可用","2018.1.1-2018.12.30","已下线"));
        myactivities.add(new Myactivity("满减券","20","消费满259元可用","2018.1.1-2018.12.30","正在进行"));
        myactivities.add(new Myactivity("折扣券","9.8折","消费满128元可用","2018.1.1-2018.12.30","正在进行"));
        myactivities.add(new Myactivity("满减券","8.0折","消费满198元可用","2018.1.1-2018.12.30","已下线"));
        activityAdapter=new ActivityAdapter(myactivities, this);
        activity_activityset_listview.setAdapter(activityAdapter);
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
