package com.zyhp.restaurantmanagement.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.activity.MainActivity;
import com.zyhp.restaurantmanagement.activity.OrderDetialsActivity;
import com.zyhp.restaurantmanagement.activity.SearchActivity;
import com.zyhp.restaurantmanagement.adapter.OrderAdapter;
import com.zyhp.restaurantmanagement.entity.Order;
import com.zyhp.restaurantmanagement.utils.GetString;
import com.zyhp.restaurantmanagement.utils.MyDate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/22.
 * <p>
 * 、
 * 首页订单界面
 */

public class OrderFragment extends Fragment implements  View.OnClickListener{
    ListView fragment_order_listview;

    View fragment_order_allorder_view, fragment_order_pendingorder_view;

    TextView fragment_order_pendingorder_count;

    List<Object> orderList;
    List<Object> orderListwait;
    OrderAdapter orderAdapter;
    LayoutInflater layoutInflater;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //找控件
        findView(view);
        layoutInflater=LayoutInflater.from(getActivity());
        //初始化数据源
        orderList = new ArrayList<>();
        orderListwait=new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            //String time = MyDate.getNowTime();
            Order order=null;
            switch (i % 4) {
                case 0:
                    order = new Order(i, MyDate.getNowTime() + i, MyDate.getOrderTime(), i, "已接单", GetString.createRandom(false, 8), GetString.createRandom(true, 2));

                    break;
                case 1:
                    order = new Order(i, MyDate.getNowTime() + i, MyDate.getOrderTime(), i, "待接单", GetString.createRandom(false, 8), GetString.createRandom(true, 2));
                    orderListwait.add(order);
                    break;
                case 2:
                    order = new Order(i, MyDate.getNowTime() + i, MyDate.getOrderTime(), i, "已完成", GetString.createRandom(false, 8), GetString.createRandom(true, 2));

                    break;
                case 3:
                    order = new Order(i, MyDate.getNowTime() + i, MyDate.getOrderTime(), i, "已取消", GetString.createRandom(false, 8), GetString.createRandom(true, 2));

                    break;

            }
            orderList.add(order);
        }

        orderAdapter=new OrderAdapter(orderList, layoutInflater);
        fragment_order_listview.setAdapter(orderAdapter);
    }





    private void findView(View view) {
        fragment_order_listview = (ListView) view.findViewById(R.id.fragment_order_listview);
        fragment_order_allorder_view = view.findViewById(R.id.fragment_order_allorder_view);
        fragment_order_pendingorder_view = view.findViewById(R.id.fragment_order_pendingorder_view);
        fragment_order_pendingorder_count = (TextView) view.findViewById(R.id.fragment_order_pendingorder_count);
        view.findViewById(R.id.fragment_order_allorder).setOnClickListener(this);
        view.findViewById(R.id.fragment_order_pendingorder).setOnClickListener(this);
        getActivity().findViewById(R.id.activity_headtitle_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(),SearchActivity.class);
                intent.putExtra("flag","order");
                intent.putExtra("time","今日订单");
                intent.putExtra("data", (Serializable) orderList);
                startActivity(intent);

            }
        });
        fragment_order_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getActivity(), OrderDetialsActivity.class);
                if(position==0){
                    intent.putExtra("order",(Order)orderList.get(i));
                }else {
                    intent.putExtra("order",(Order)orderListwait.get(i));
                }
                startActivity(intent);

            }
        });
    }
int  position;


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fragment_order_allorder:
                if (position != 0) {
                    position = 0;
                    fragment_order_allorder_view.setBackgroundResource(R.color.appcolorred);
                    fragment_order_pendingorder_view.setBackgroundResource(R.color.gray2);

                    orderAdapter=new OrderAdapter(orderList, layoutInflater);
                    fragment_order_listview.setAdapter(orderAdapter);
                    fragment_order_allorder_view.setBackgroundResource(R.color.appcolorred);
                    fragment_order_pendingorder_view.setBackgroundResource(R.color.white);
                    // fragment_order_allorder_view.
                }
                break;
            case R.id.fragment_order_pendingorder:
                if (position != 1) {
                    position = 1;
                    fragment_order_allorder_view.setBackgroundResource(R.color.white);
                    fragment_order_pendingorder_view.setBackgroundResource(R.color.appcolorred);
                    orderAdapter=new OrderAdapter(orderListwait, layoutInflater);
                    fragment_order_listview.setAdapter(orderAdapter);

                }
                break;
        }



    }
}
