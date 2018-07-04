package com.zyhp.restaurantmanagement.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.entity.Food;
import com.zyhp.restaurantmanagement.entity.Order;

import java.util.List;

/**
 * Created by Administrator on 2018/7/2.
 */


public class FoodAdapter extends BaseAdapter {
    List<Object> foodList;
    LayoutInflater layoutInflater;

    public FoodAdapter() {
    }

    public FoodAdapter(List<Object> foodList, LayoutInflater layoutInflater) {
        this.foodList = foodList;
        this.layoutInflater = layoutInflater;
    }

    public List<Object> getList() {

        return foodList;
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int i) {
        return foodList.get(i);
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
            view = layoutInflater.inflate(R.layout.listview_item_foodmaterial_food, null);
            orderViewHolder.listview_item_foodmaterial_food_foodname = (TextView) view.findViewById(R.id.listview_item_foodmaterial_food_foodname);
            orderViewHolder.listview_item_foodmaterial_food_foodmoney = (TextView) view.findViewById(R.id.listview_item_foodmaterial_food_foodmoney);
            view.setTag(orderViewHolder);
        } else {
            orderViewHolder = (OrderViewHolder) view.getTag();
        }

        Food food = (Food) getItem(i);
        orderViewHolder.listview_item_foodmaterial_food_foodname.setText(food.getFood_name());
        orderViewHolder.listview_item_foodmaterial_food_foodmoney.setText("￥"+food.getFood_money());


        return view;
    }


    class OrderViewHolder {
        TextView listview_item_foodmaterial_food_foodname, listview_item_foodmaterial_food_foodmoney;

    }
}
