package com.zyhp.restaurantmanagement.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.entity.Member;
import com.zyhp.restaurantmanagement.entity.Order;

import java.util.List;

/**
 * Created by Administrator on 2018/7/2.
 */


public class RecordsofconsumptionAdapter extends BaseAdapter {
    List<Member> memberList;
    LayoutInflater layoutInflater;

    public RecordsofconsumptionAdapter() {
    }

    public RecordsofconsumptionAdapter(List<Member> memberList, LayoutInflater layoutInflater) {
        this.memberList = memberList;
        this.layoutInflater = layoutInflater;
    }

    public List<Member> getList() {

        return memberList;
    }

    @Override
    public int getCount() {
        return memberList.size();
    }

    @Override
    public Member getItem(int i) {
        return memberList.get(i);
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
            view = layoutInflater.inflate(R.layout.listview_item_order, null);
            orderViewHolder.listview_item_ordernumber = (TextView) view.findViewById(R.id.listview_item_ordernumber);
            orderViewHolder.listview_item_ordertime = (TextView) view.findViewById(R.id.listview_item_ordertime);
            orderViewHolder.listview_item_tablenumber = (TextView) view.findViewById(R.id.listview_item_tablenumber);

            orderViewHolder.listview_item_orderstate = (TextView) view.findViewById(R.id.listview_item_orderstate);

            orderViewHolder.listview_item_name = (TextView) view.findViewById(R.id.listview_item_name);
            orderViewHolder.listview_item_money = (TextView) view.findViewById(R.id.listview_item_money);
            view.setTag(orderViewHolder);
        } else {
            orderViewHolder = (OrderViewHolder) view.getTag();
        }

        Member member = getItem(i);
        orderViewHolder.listview_item_ordernumber.setTextderti(order.getOrder_id());

        return view;
    }


    class OrderViewHolder {
        TextView listview_item_ordernumber, listview_item_ordertime, listview_item_tablenumber, listview_item_orderstate, listview_item_name, listview_item_money;

    }
}
