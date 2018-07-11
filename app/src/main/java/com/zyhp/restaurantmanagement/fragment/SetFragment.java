package com.zyhp.restaurantmanagement.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.activity.AboutUsSetActivity;
import com.zyhp.restaurantmanagement.activity.AccountSetActivity;
import com.zyhp.restaurantmanagement.activity.ActivitySetActivity;
import com.zyhp.restaurantmanagement.activity.FoodmatearialSetActivity;
import com.zyhp.restaurantmanagement.activity.StaffSetActivity;
import com.zyhp.restaurantmanagement.activity.StoreSetActivity;
import com.zyhp.restaurantmanagement.activity.TableSetActivity;
import com.zyhp.restaurantmanagement.myview.CircleImageView;
import com.zyhp.restaurantmanagement.utils.DiskBitmap;
import com.zyhp.restaurantmanagement.utils.ShareUitls;

/**
 * Created by Administrator on 2018/6/22.
 */

public class SetFragment extends android.support.v4.app.Fragment implements View.OnClickListener {

    Activity activity;
    String head_url;
    CircleImageView fragment_set_headimage;
    TextView fragment_set_account ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_set, container, false);


        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        activity = getActivity();
        fragment_set_headimage = (CircleImageView) view.findViewById(R.id.fragment_set_headimage);
        fragment_set_account=(TextView) view.findViewById(R.id.fragment_set_account);
        String account=ShareUitls.getString(activity, "login_phone", "");
        if(account.length()>0){
            fragment_set_account.setText(account);
        }
        view.findViewById(R.id.fragment_set_accountset).setOnClickListener(this);
        view.findViewById(R.id.fragment_set_storeset).setOnClickListener(this);
        view.findViewById(R.id.fragment_set_tableset).setOnClickListener(this);
        view.findViewById(R.id.fragment_set_staffset).setOnClickListener(this);
        view.findViewById(R.id.fragment_set_foodmaterialset).setOnClickListener(this);
        view.findViewById(R.id.fragment_set_activityset).setOnClickListener(this);
        view.findViewById(R.id.fragment_set_aboutus).setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        head_url = ShareUitls.getString(activity, "head_url", "");
        if (head_url != null && head_url.length() > 0) {
            fragment_set_headimage.setImageBitmap(DiskBitmap.getDiskBitmap(head_url, activity));
        }
    }

    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.fragment_set_accountset:
                intent.setClass(activity, AccountSetActivity.class);
                break;
            case R.id.fragment_set_storeset:
                intent.setClass(activity, StoreSetActivity.class);
                break;
            case R.id.fragment_set_tableset:
                intent.setClass(activity, TableSetActivity.class);
                break;
            case R.id.fragment_set_staffset:
                intent.setClass(activity, StaffSetActivity.class);
                break;
            case R.id.fragment_set_foodmaterialset:
                intent.setClass(activity, FoodmatearialSetActivity.class);
                break;
            case R.id.fragment_set_activityset:
                intent.setClass(activity, ActivitySetActivity.class);
                break;
            case R.id.fragment_set_aboutus:
                intent.setClass(activity, AboutUsSetActivity.class);
                break;


        }
        startActivity(intent);

    }
}
