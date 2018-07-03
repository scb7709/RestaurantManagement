package com.zyhp.restaurantmanagement.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.entity.Order;

import java.util.List;

/**
 * Created by Administrator on 2018/7/2.
 */


public class OrderAdapter extends BaseAdapter {
    List<Order> orderList;
    LayoutInflater layoutInflater;

    public OrderAdapter() {
    }

    public OrderAdapter(List<Order> orderList, LayoutInflater layoutInflater) {
        this.orderList = orderList;
        this.layoutInflater = layoutInflater;
    }

    @Override
    public int getCount() {
        return orderList.size();
    }

    @Override
    public Order getItem(int i) {
        return orderList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        OrderViewHolder orderViewHolder;
        if(view==null){
            orderViewHolder=new OrderViewHolder();
            view=layoutInflater.inflate(R.layout.listview_item_order,null);
            orderViewHolder.listview_item_ordernumber=(TextView)view.findViewById(R.id.listview_item_ordernumber);
            orderViewHolder.listview_item_ordertime=(TextView)view.findViewById(R.id.listview_item_ordertime);
            orderViewHolder.listview_item_tablenumber=(TextView)view.findViewById(R.id.listview_item_tablenumber);

            orderViewHolder.listview_item_orderstate=(TextView)view.findViewById(R.id.listview_item_orderstate);

            orderViewHolder.listview_item_name=(TextView)view.findViewById(R.id.listview_item_name);
            orderViewHolder.listview_item_money=(TextView)view.findViewById(R.id.listview_item_money);
            view.setTag(orderViewHolder);
        }else {
            orderViewHolder=(OrderViewHolder) view.getTag();
        }

        Order order = getItem(i);
        orderViewHolder.listview_item_ordernumber.setText(order.getOrder_id());
        orderViewHolder.listview_item_ordertime.setText(order.getTime());
        orderViewHolder.listview_item_tablenumber.setText(order.getTableNumber()+"");
        orderViewHolder.listview_item_orderstate.setText(order.getState());
        orderViewHolder.listview_item_name.setText(order.getName());
        orderViewHolder.listview_item_money.setText(order.getMoney());

        return view;
    }


    class OrderViewHolder {
        TextView listview_item_ordernumber, listview_item_ordertime, listview_item_tablenumber, listview_item_orderstate,listview_item_name, listview_item_money;

    }
}
