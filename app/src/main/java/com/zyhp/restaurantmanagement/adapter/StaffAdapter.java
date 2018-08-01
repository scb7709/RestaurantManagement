package com.zyhp.restaurantmanagement.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.activity.StaffDetialsActivity;
import com.zyhp.restaurantmanagement.entity.Food;
import com.zyhp.restaurantmanagement.entity.Staff;
import com.zyhp.restaurantmanagement.myview.CircleImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/2.
 */


public class StaffAdapter extends BaseAdapter {
    List<Staff> staffList;
    LayoutInflater layoutInflater;
    List<String> departmentlist;
    Activity activity;
    Handler handler;

    public StaffAdapter() {
    }

    public StaffAdapter(List<Staff> staffList, Activity activity, Handler handler) {
        this.staffList = staffList;
        this.activity = activity;
        this.layoutInflater = LayoutInflater.from(activity);
        departmentlist = new ArrayList<>();
        this.handler = handler;
    }

    public List<Staff> getList() {

        return staffList;
    }

    @Override
    public int getCount() {
        return staffList.size();
    }

    @Override
    public Object getItem(int i) {
        return staffList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        OrderViewHolder orderViewHolder;
        if (view == null) {
            orderViewHolder = new OrderViewHolder();
            view = layoutInflater.inflate(R.layout.listview_item_staff, null);
            orderViewHolder.listview_item_staffhead = (CircleImageView) view.findViewById(R.id.listview_item_staffhead);

            orderViewHolder.listview_item_staffname = (TextView) view.findViewById(R.id.listview_item_staffname);
            orderViewHolder.listview_item_staffdepartment = (TextView) view.findViewById(R.id.listview_item_staffdepartment);

            orderViewHolder.listview_item_onclick_layout = (LinearLayout) view.findViewById(R.id.listview_item_onclick_layout);
            view.setTag(orderViewHolder);
        } else {
            orderViewHolder = (OrderViewHolder) view.getTag();
        }

        final Staff staff = (Staff) getItem(i);
        String department = staff.getDepartment();
        if (!departmentlist.contains(department)) {
            departmentlist.add(department);
            departmentlist.add(staff.getWorknumber());
            orderViewHolder.listview_item_staffdepartment.setVisibility(View.VISIBLE);
            orderViewHolder.listview_item_staffdepartment.setText(department);

        } else if (departmentlist.contains(staff.getWorknumber())) {
            orderViewHolder.listview_item_staffdepartment.setText(department);
            orderViewHolder.listview_item_staffdepartment.setVisibility(View.VISIBLE);
        } else {

            orderViewHolder.listview_item_staffdepartment.setVisibility(View.GONE);

        }
        orderViewHolder.listview_item_staffname.setText(staff.getName());
        orderViewHolder.listview_item_onclick_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.startActivityForResult(new Intent(activity, StaffDetialsActivity.class).putExtra("staff", staff), 0);
                Message message = Message.obtain();
                message.obj = staff;
                handler.dispatchMessage(message);//高速Activity 是点击的哪一行
            }
        });
        return view;
    }


    class OrderViewHolder {
        CircleImageView listview_item_staffhead;
        TextView listview_item_staffdepartment, listview_item_staffname;
        LinearLayout listview_item_onclick_layout;
    }
}
