package com.zyhp.restaurantmanagement.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.entity.Member;
import com.zyhp.restaurantmanagement.fragment.ConsumptionRecordsFragment;

import com.zyhp.restaurantmanagement.fragment.MemberInformationFragment;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2018/7/6.
 */

public class MemberDetialsActivity extends BaseActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    TextView activity_menberdetials_name, activity_menberdetials_money, activity_menberdetials_integral;


    private TextView view_publictitle_title;
    private RelativeLayout view_publictitle_back;
    MemberDetialsActivity activity;
    ViewPager activity_menberdetials_ViewPager;
    List<Fragment> fragmentList;
    ViewPagerOrderAdapter viewPagerOrderAdapter;
    private int Position;

    RadioGroup activity_menberdetials_RadioGroup;
    RadioButton activity_menberdetials_information, activity_menberdetials_consumptionrecords;
    boolean isOnclick;//用来判断是否是点击切换的 如果是就不触发 viewpage的 切换监听代码
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memberdetails);
        activity = MemberDetialsActivity.this;

        findView();
    }

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    void findView() {

        view_publictitle_title = (TextView) findViewById(R.id.view_publictitle_title);
        view_publictitle_title.setText("会员详情");
        view_publictitle_back = (RelativeLayout) findViewById(R.id.view_publictitle_back);
        view_publictitle_back.setOnClickListener(this);
        activity_menberdetials_RadioGroup = (RadioGroup) findViewById(R.id.activity_menberdetials_RadioGroup);
        activity_menberdetials_information = (RadioButton) findViewById(R.id.activity_menberdetials_information);
        activity_menberdetials_consumptionrecords = (RadioButton) findViewById(R.id.activity_menberdetials_consumptionrecords);
        activity_menberdetials_ViewPager = (ViewPager) findViewById(R.id.activity_menberdetials_ViewPager);
        activity_menberdetials_name = (TextView) findViewById(R.id.activity_menberdetials_name);
        activity_menberdetials_money = (TextView) findViewById(R.id.activity_menberdetials_money);
        activity_menberdetials_integral = (TextView) findViewById(R.id.activity_menberdetials_integral);
        Member member = (Member) getIntent().getSerializableExtra("member");
        activity_menberdetials_name.setText(member.getName());
        activity_menberdetials_money.setText(member.getMoney());
        activity_menberdetials_integral.setText(member.getIntegral());


        fragmentList = new ArrayList<>();
        fragmentList.add(new MemberInformationFragment());
        fragmentList.add(new ConsumptionRecordsFragment());
        viewPagerOrderAdapter = new ViewPagerOrderAdapter();
        activity_menberdetials_ViewPager.setAdapter(viewPagerOrderAdapter);
        activity_menberdetials_ViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                isOnclick=false;
            }

            @Override
            public void onPageSelected(int position) {
                if(!isOnclick) {
                    if (position == 0) {
                        Position = 0;
                        activity_menberdetials_RadioGroup.check(R.id.activity_menberdetials_information);
                    } else {
                        Position = 1;
                        activity_menberdetials_RadioGroup.check(R.id.activity_menberdetials_consumptionrecords);
                    }
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        activity_menberdetials_RadioGroup.check(R.id.activity_menberdetials_information);
        activity_menberdetials_RadioGroup.setOnCheckedChangeListener(this);

    }


    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkedId) {
        isOnclick=true;
        switch (checkedId) {

            case R.id.activity_menberdetials_information:
                if (Position != 0) {
                    Position = 0;
                    activity_menberdetials_ViewPager.setCurrentItem(0);
                }
                break;
            case R.id.activity_menberdetials_consumptionrecords:
                if (Position != 1) {
                    Position = 1;
                    activity_menberdetials_ViewPager.setCurrentItem(1);
                }
                break;
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.view_publictitle_back:
                finish();
                break;
        }
    }


    private class ViewPagerOrderAdapter extends FragmentPagerAdapter {
        public ViewPagerOrderAdapter() {
            super(getSupportFragmentManager());
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }


    }
}
