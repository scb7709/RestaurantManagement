package com.zyhp.restaurantmanagement.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.activity.StaffDetialsActivity;
import com.zyhp.restaurantmanagement.entity.Myactivity;
import com.zyhp.restaurantmanagement.entity.Staff;
import com.zyhp.restaurantmanagement.myview.CircleImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/2.
 */


public class ActivityAdapter extends BaseAdapter {
    List<Myactivity> myactivities;
    LayoutInflater layoutInflater;
    public ActivityAdapter() {
    }

    public ActivityAdapter(List<Myactivity> myactivities, Activity activity) {
        this.myactivities = myactivities;

        this.layoutInflater = LayoutInflater.from(activity);

    }

    public List<Myactivity> getList() {

        return myactivities;
    }

    @Override
    public int getCount() {
        return myactivities.size();
    }

    @Override
    public Myactivity getItem(int i) {
        return myactivities.get(i);
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
            view = layoutInflater.inflate(R.layout.listview_item_activity, null);

            orderViewHolder.listview_item_activity_number = (TextView) view.findViewById(R.id.listview_item_activity_number);
            orderViewHolder.listview_item_activity_type = (TextView) view.findViewById(R.id.listview_item_activity_type);
            orderViewHolder.listview_item_activity_limit = (TextView) view.findViewById(R.id.listview_item_activity_limit);
            orderViewHolder.listview_item_date = (TextView) view.findViewById(R.id.listview_item_date);
            orderViewHolder.listview_item_activity_state = (TextView) view.findViewById(R.id.listview_item_activity_state);


            view.setTag(orderViewHolder);
        } else {
            orderViewHolder = (OrderViewHolder) view.getTag();
        }

        final Myactivity myactivity =  getItem(i);
        orderViewHolder.listview_item_activity_number.setText(myactivity.getNumber());
        orderViewHolder.listview_item_activity_type.setText(myactivity.getType());
        orderViewHolder.listview_item_activity_limit.setText(myactivity.getLimit());
        orderViewHolder.listview_item_date.setText(myactivity.getDate());
        orderViewHolder.listview_item_activity_state.setText(myactivity.getState());

        return view;
    }


    class OrderViewHolder {

        TextView listview_item_activity_number, listview_item_activity_type,
                listview_item_activity_limit,listview_item_date,listview_item_activity_state;


    }
}
