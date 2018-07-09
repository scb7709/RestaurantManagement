package com.zyhp.restaurantmanagement.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.entity.Food;

import java.util.List;

/**
 * Created by Administrator on 2018/7/2.
 */


public class TableSetAdapter extends BaseAdapter {
    List<String> stringList;
    LayoutInflater layoutInflater;

    public TableSetAdapter() {
    }

    public TableSetAdapter(List<String> stringList, LayoutInflater layoutInflater) {
        this.stringList = stringList;
        this.layoutInflater = layoutInflater;
    }

    public List<String> getList() {

        return stringList;
    }

    @Override
    public int getCount() {
        return stringList.size();
    }

    @Override
    public String getItem(int i) {
        return stringList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        OrderViewHolder orderViewHolder;
        if (view == null) {
            orderViewHolder = new OrderViewHolder();
            view = layoutInflater.inflate(R.layout.gridview_item_tableset, null);
            orderViewHolder.gridview_item_bigtext = (TextView) view.findViewById(R.id.gridview_item_bigtext);
            orderViewHolder.gridview_item_smalltext = (TextView) view.findViewById(R.id.gridview_item_smalltext);
            view.setTag(orderViewHolder);
        } else {
            orderViewHolder = (OrderViewHolder) view.getTag();
        }

        String table = getItem(i);
        orderViewHolder.gridview_item_bigtext.setText(table);
        orderViewHolder.gridview_item_smalltext.setText(table+"号桌");


        return view;
    }


    class OrderViewHolder {
        TextView gridview_item_bigtext, gridview_item_smalltext;

    }
}
