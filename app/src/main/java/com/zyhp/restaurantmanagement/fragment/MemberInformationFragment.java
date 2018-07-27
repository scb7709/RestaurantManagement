package com.zyhp.restaurantmanagement.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.activity.FoodDetialsActivity;
import com.zyhp.restaurantmanagement.activity.SearchActivity;
import com.zyhp.restaurantmanagement.adapter.FoodAdapter;
import com.zyhp.restaurantmanagement.adapter.FoodClassifyAdapter;
import com.zyhp.restaurantmanagement.entity.Food;
import com.zyhp.restaurantmanagement.entity.FoodClassify;
import com.zyhp.restaurantmanagement.utils.GetOrderList;
import com.zyhp.restaurantmanagement.utils.ImageUtil;
import com.zyhp.restaurantmanagement.utils.MyShow;
import com.zyhp.restaurantmanagement.utils.NumberValidationUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/22.
 */

public class MemberInformationFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_memberinformation, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findView(view);
        setListView();
    }

    private void setListView() {


    }


    private void findView(View view) {



    }

}
