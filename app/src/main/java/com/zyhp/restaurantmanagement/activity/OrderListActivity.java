package com.zyhp.restaurantmanagement.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.adapter.OrderFoodAdapter;
import com.zyhp.restaurantmanagement.entity.Food;
import com.zyhp.restaurantmanagement.entity.Order;
import com.zyhp.restaurantmanagement.utils.MyShow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/2.
 */

public class OrderListActivity extends BaseActivity implements View.OnClickListener {

    private TextView view_publictitle_title;

    private RelativeLayout view_publictitle_back;
    Intent intent;
    Order order;
    ListView activity_orderdetails;
    List<Food> foodList;
    OrderFoodAdapter orderFoodAdapter;
    TextView listview_item_ordernumber, listview_item_ordertime, listview_item_tablenumber, listview_item_orderstate, listview_item_name, listview_item_money;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderdetails);
        intent = getIntent();
        order = (Order) intent.getSerializableExtra("order");
        findView();
    }

    void findView() {
        view_publictitle_title = (TextView) findViewById(R.id.view_publictitle_title);
        view_publictitle_title.setText("订单详情");
        view_publictitle_back = (RelativeLayout) findViewById(R.id.view_publictitle_back);
        view_publictitle_back.setOnClickListener(this);

        activity_orderdetails = (ListView) findViewById(R.id.activity_orderdetails);
        listview_item_ordernumber = (TextView) findViewById(R.id.listview_item_ordernumber);
        listview_item_ordertime = (TextView) findViewById(R.id.listview_item_ordertime);
        listview_item_tablenumber = (TextView) findViewById(R.id.listview_item_tablenumber);

        listview_item_orderstate = (TextView) findViewById(R.id.listview_item_orderstate);

        listview_item_name = (TextView) findViewById(R.id.listview_item_name);
        listview_item_money = (TextView) findViewById(R.id.listview_item_money);


        listview_item_ordernumber.setText(order.getOrder_id());
        listview_item_ordertime.setText(order.getTime());
        listview_item_tablenumber.setText(order.getTableNumber() + "");

        listview_item_name.setText(order.getName());
        listview_item_money.setText(order.getMoney());

        if(order.getState().equals("待接单")){
            listview_item_orderstate.setText("点击接单");
            listview_item_orderstate.setTextColor(Color.RED);
            listview_item_orderstate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listview_item_orderstate.setText("已接单");
                    listview_item_orderstate.setTextColor(getResources().getColor(R.color.black));
                    MyShow.myToash(OrderListActivity.this,"已接单");
                }
            });
        }else {
            listview_item_orderstate.setText(order.getState());

        }
        foodList=new ArrayList<>();

        foodList.add(new Food("宫保鸡丁","20","2"));
        foodList.add(new Food("鱼香肉丝","18","2"));
        foodList.add(new Food("地三鲜","12","3"));
        foodList.add(new Food("水煮牛肉","30","2"));
        foodList.add(new Food("豆腐鱼汤","20","1"));

        orderFoodAdapter=new OrderFoodAdapter(foodList, LayoutInflater.from(this));
        activity_orderdetails.setAdapter(orderFoodAdapter);
        activity_orderdetails.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent();
                intent.setClass(OrderListActivity.this, FoodDetialsActivity.class);

                intent.putExtra("food", foodList.get(i));
                startActivity(intent);
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
