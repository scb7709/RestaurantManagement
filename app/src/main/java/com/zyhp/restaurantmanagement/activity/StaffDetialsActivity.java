package com.zyhp.restaurantmanagement.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.adapter.FoodDetialsMaterialAdapter;
import com.zyhp.restaurantmanagement.entity.Food;
import com.zyhp.restaurantmanagement.entity.Foodmaterial;
import com.zyhp.restaurantmanagement.entity.Staff;
import com.zyhp.restaurantmanagement.utils.GetString;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/4.
 */

public class StaffDetialsActivity extends BaseActivity implements View.OnClickListener {

    private TextView view_publictitle_title, activity_staffdetials_name, activity_staffdetials_department,
            activity_staffdetials_position, activity_staffdetials_phone,
            activity_staffdetials_email, activity_staffdetials_address;


    private RelativeLayout view_publictitle_back,activity_staffdetials_phone_layout;
    Staff staff;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staffdetials);
        staff = (Staff) getIntent().getSerializableExtra("staff");

        findView();
    }

    void findView() {
        view_publictitle_title = (TextView) findViewById(R.id.view_publictitle_title);
        view_publictitle_title.setText("员工资料");
        view_publictitle_back = (RelativeLayout) findViewById(R.id.view_publictitle_back);
        view_publictitle_back.setOnClickListener(this);
        activity_staffdetials_phone_layout = (RelativeLayout) findViewById(R.id.activity_staffdetials_phone_layout);
        activity_staffdetials_phone_layout.setOnClickListener(this);
        activity_staffdetials_name = (TextView) findViewById(R.id.activity_staffdetials_name);
        activity_staffdetials_department = (TextView) findViewById(R.id.activity_staffdetials_department);
        activity_staffdetials_position = (TextView) findViewById(R.id.activity_staffdetials_position);
        activity_staffdetials_phone = (TextView) findViewById(R.id.activity_staffdetials_phone);
        activity_staffdetials_email = (TextView) findViewById(R.id.activity_staffdetials_email);
        activity_staffdetials_address = (TextView) findViewById(R.id.activity_staffdetials_address);

        if (staff != null) {
            activity_staffdetials_name.setText(staff.getName());
            activity_staffdetials_department.setText(staff.getDepartment());
            activity_staffdetials_position.setText(staff.getPosition());
            activity_staffdetials_phone.setText(staff.getPhone());
            activity_staffdetials_email.setText(staff.getEmail());
            activity_staffdetials_address.setText(staff.getAddress());

        }

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.view_publictitle_back:
                finish();
                break;
            case R.id.activity_staffdetials_phone_layout:
                Intent dialIntent = new Intent( Intent.ACTION_CALL,Uri.parse("tel:"+ staff.getPhone()));
                startActivity(dialIntent);
                break;
        }
    }
}
