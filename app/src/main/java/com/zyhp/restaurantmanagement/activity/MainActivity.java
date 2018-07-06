package com.zyhp.restaurantmanagement.activity;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.fragment.FoodFragment;
import com.zyhp.restaurantmanagement.fragment.IncomeFragment;

import com.zyhp.restaurantmanagement.fragment.OrderFragment;
import com.zyhp.restaurantmanagement.fragment.SetFragment;


public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener{
    public  static  Activity  activity;
    private FragmentManager fragmentManager;

    RadioGroup activity_main_tabs;
    private int position;
    TextView activity_headtitle_title ;
    RelativeLayout activity_headtitle_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity=this;
        activity_main_tabs=(RadioGroup) findViewById(R.id.activity_main_tabs);
        activity_headtitle_icon=(RelativeLayout) findViewById(R.id.activity_headtitle_icon);
        activity_headtitle_title=(TextView)findViewById(R.id.activity_headtitle_title);

        fragmentManager = getSupportFragmentManager();
        activity_main_tabs.check(R.id.activity_main_order);
        activity_main_tabs.setOnCheckedChangeListener(this);
        changeFragment(new OrderFragment(), "OrderFragment");


    }



    private void changeFragment(Fragment fragment, String tag) {
        //1.获取事务对象
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //2.切换内容的显示
        transaction.replace(R.id.activity_main_framelayout, fragment, tag);
		//3.提交事务
        transaction.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.activity_main_order:
                if (position != 0) {
                    position = 0;
                    activity_headtitle_title.setText("今日订单");
                    activity_headtitle_icon.setVisibility(View.VISIBLE);
                    changeFragment(new OrderFragment(), "OrderFragment");
                }
                break;
            case R.id.activity_main_food:
                if (position != 1) {
                    position = 1;
                    activity_headtitle_title.setText("菜品管理");
                    activity_headtitle_icon.setVisibility(View.VISIBLE);
                    changeFragment(new FoodFragment(), "FoodFragment");
                }
                break;
            case R.id.activity_main_income:
                if (position != 2) {
                    position = 2;
                    activity_headtitle_title.setText("营业情况");
                    activity_headtitle_icon.setVisibility(View.INVISIBLE);
                    changeFragment(new IncomeFragment(), "IncomeFragment");
                }
                break;
            case R.id.activity_main_set:
                if (position != 3) {
                    position = 3;
                    activity_headtitle_title.setText("设置");
                    activity_headtitle_icon.setVisibility(View.INVISIBLE);
                    changeFragment(new SetFragment(), "SetFragment");
                }
                break;
        }
    }
}
