package com.zyhp.restaurantmanagement.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.adapter.FoodAdapter;
import com.zyhp.restaurantmanagement.adapter.OrderAdapter;
import com.zyhp.restaurantmanagement.entity.Food;
import com.zyhp.restaurantmanagement.entity.Order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/2.
 */

public class SearchActivity extends BaseActivity implements View.OnClickListener {
    private TextView view_publictitle_title,activity_search_nothing;

    private RelativeLayout view_publictitle_back;
    Intent intent;
    String flag;

    EditText activity_search_edittext;
    ListView activity_search_listview;

    BaseAdapter baseAdapter;
    List<Object> objects;
    List<Object> tempobjects;
    LayoutInflater layoutInflater;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        intent = getIntent();
        flag = intent.getStringExtra("flag");
        findView();
    }

    void findView() {
        layoutInflater = LayoutInflater.from(this);
        view_publictitle_title = (TextView) findViewById(R.id.view_publictitle_title);
        activity_search_nothing= (TextView) findViewById(R.id.activity_search_nothing);
        view_publictitle_back = (RelativeLayout) findViewById(R.id.view_publictitle_back);
        view_publictitle_back.setOnClickListener(this);
        activity_search_edittext = (EditText) findViewById(R.id.activity_search_edittext);
        activity_search_listview = (ListView) findViewById(R.id.activity_search_listview);
        ///objects=new ArrayList<>();
        tempobjects = new ArrayList<>();
        objects = (List<Object>) intent.getSerializableExtra("data");
        switch (flag) {
            case "order":
                view_publictitle_title.setText("我的订单");
                baseAdapter = new OrderAdapter(objects, layoutInflater);
                activity_search_edittext.setHint("输入关键字搜索(单号、昵称)");
                break;
            case "food":
                activity_search_edittext.setHint("输入关键字搜索(菜品名称、价格)");
                view_publictitle_title.setText("菜品搜索");
                baseAdapter = new FoodAdapter(objects, layoutInflater);
                break;
        }
        activity_search_listview.setAdapter(baseAdapter);
        setEditTextListener();
        setListViewListener();
    }


    public void setEditTextListener() {
        activity_search_edittext.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                tempobjects.clear();
                // TODO Auto-generated method stub
                String contentString = activity_search_edittext.getText().toString();

                switch (flag) {
                    case "order":

                        if (contentString.length() > 0) {
                            for (Object object : objects) {
                                Order order = (Order) object;
                                if (order.getOrder_id().contains(contentString)
                                        || order.getName().contains(contentString)) {
                                    tempobjects.add(order);
                                }
                            }
                            if (tempobjects.size() > 0) {
                                activity_search_nothing.setVisibility(View.GONE);
                                OrderAdapter orderAdapter = new OrderAdapter(tempobjects, layoutInflater);
                                activity_search_listview.setAdapter(orderAdapter);
                            }else {
                                activity_search_nothing.setVisibility(View.VISIBLE);

                            }
                        } else {
                            activity_search_nothing.setVisibility(View.GONE);
                            baseAdapter = new OrderAdapter(objects, layoutInflater);
                            activity_search_listview.setAdapter(baseAdapter);
                        }

                        break;

                    case "food":
                        if (contentString.length() > 0) {
                            for (Object object : objects) {
                                Food food = (Food) object;
                                if (food.getFood_name().contains(contentString)||food.getFood_money().contains(contentString)) {
                                    tempobjects.add(food);
                                }
                            }
                            if (tempobjects.size() > 0) {
                                activity_search_nothing.setVisibility(View.GONE);
                                FoodAdapter foodAdapter = new FoodAdapter(tempobjects, layoutInflater);
                                activity_search_listview.setAdapter(foodAdapter);
                            }else {
                                activity_search_nothing.setVisibility(View.VISIBLE);
                            }
                        } else {
                            activity_search_nothing.setVisibility(View.GONE);
                            baseAdapter = new FoodAdapter(objects, layoutInflater);
                            activity_search_listview.setAdapter(baseAdapter);
                        }


                        break;

                }


            }
        });

    }

    public void setListViewListener() {
        activity_search_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                switch (flag) {
                    case "order":

                        intent.setClass(SearchActivity.this, OrderDetialsActivity.class);
                        intent.putExtra("order", (Order) ((OrderAdapter) baseAdapter).getList().get(i));
                        startActivity(intent);

                        break;

                    case "food":
                        intent.setClass(SearchActivity.this, FoodDetialsActivity.class);

                        intent.putExtra("food", (Food) ((FoodAdapter) baseAdapter).getList().get(i));
                        startActivity(intent);

                        break;
                }

            }
        });
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
