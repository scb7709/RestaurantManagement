package com.zyhp.restaurantmanagement.activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.entity.Member;
import com.zyhp.restaurantmanagement.fragment.ConsumptionRecordsFragment;
import com.zyhp.restaurantmanagement.fragment.IncomeFragment;
import com.zyhp.restaurantmanagement.fragment.MemberInformationFragment;
import com.zyhp.restaurantmanagement.fragment.OrderFragment;
import com.zyhp.restaurantmanagement.myview.CircleImageView;
import com.zyhp.restaurantmanagement.utils.DiskBitmap;
import com.zyhp.restaurantmanagement.utils.GetChoiceDialog;
import com.zyhp.restaurantmanagement.utils.GetDialog;
import com.zyhp.restaurantmanagement.utils.MyShow;
import com.zyhp.restaurantmanagement.utils.Regular;
import com.zyhp.restaurantmanagement.utils.ShareUitls;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memberdetails);
        activity = MemberDetialsActivity.this;

        findView();
    }

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

            }

            @Override
            public void onPageSelected(int position) {
                Log.i("onPageSelected1",""+Position);
                if (Position != 0) {
                    Position = 0;
                    int red = Color.parseColor("#EE0000");
                    activity_menberdetials_information.setTextColor(red);
                } else {
                    Position = 1;
                    int black = Color.parseColor("#000000");
                    activity_menberdetials_consumptionrecords.setTextColor(black);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        activity_menberdetials_RadioGroup.check(R.id.activity_menberdetials_information);
        activity_menberdetials_RadioGroup.setOnCheckedChangeListener(this);

    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.activity_menberdetials_information:
                Log.i("onPageSelected2",""+Position);
                if (Position != 0) {
                    Position = 0;
                    activity_menberdetials_ViewPager.setCurrentItem(0);
                }
                break;
            case R.id.activity_menberdetials_consumptionrecords:
                Log.i("onPageSelected3",""+Position);
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
