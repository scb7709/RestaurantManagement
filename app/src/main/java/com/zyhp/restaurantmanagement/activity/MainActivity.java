package com.zyhp.restaurantmanagement.activity;


import android.app.Activity;
import android.content.Intent;
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
import com.zyhp.restaurantmanagement.fragment.FoodmaterialFragment;
import com.zyhp.restaurantmanagement.fragment.MyselfFragment;
import com.zyhp.restaurantmanagement.fragment.OrderFragment;
import com.zyhp.restaurantmanagement.fragment.VarietyofdishesFragment;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener{
    private FragmentManager fragmentManager;

    RadioGroup activity_main_tabs;
    private int position;
    TextView activity_headtitle_title ;
    RelativeLayout activity_headtitle_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                    activity_headtitle_title.setText("订单");
                    activity_headtitle_icon.setVisibility(View.VISIBLE);
                    changeFragment(new OrderFragment(), "OrderFragment");
                }
                break;
            case R.id.activity_main_varietyofdishes:
                if (position != 1) {
                    position = 1;
                    activity_headtitle_title.setText("食材");
                    activity_headtitle_icon.setVisibility(View.VISIBLE);

                    changeFragment(new VarietyofdishesFragment(), "VarietyofdishesFragment");
                }
                break;
            case R.id.activity_main_foodmaterial:
                if (position != 2) {
                    position = 2;
                    activity_headtitle_title.setText("菜品");
                    activity_headtitle_icon.setVisibility(View.VISIBLE);
                    changeFragment(new FoodmaterialFragment(), "FoodmaterialFragment");
                }
                break;
            case R.id.activity_main_my:
                if (position != 3) {
                    position = 3;
                    activity_headtitle_title.setText("我");
                    activity_headtitle_icon.setVisibility(View.INVISIBLE);
                    changeFragment(new MyselfFragment(), "MyselfFragment");
                }
                break;
        }
    }
}
