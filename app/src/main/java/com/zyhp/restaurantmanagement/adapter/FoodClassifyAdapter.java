package com.zyhp.restaurantmanagement.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.entity.Food;
import com.zyhp.restaurantmanagement.entity.FoodClassify;

import java.util.List;

/**
 * Created by Administrator on 2018/7/2.
 */


public class FoodClassifyAdapter extends BaseAdapter {
    List<FoodClassify> foodClassifyList;
    LayoutInflater layoutInflater;

    public FoodClassifyAdapter() {
    }

    public FoodClassifyAdapter(List<FoodClassify> foodClassifyList, LayoutInflater layoutInflater) {
        this.foodClassifyList = foodClassifyList;
        this.layoutInflater = layoutInflater;
    }

    int mSelect = 0;   //选中项


    public void changeSelected(int positon) { //刷新方法
        if (positon != mSelect) {
            mSelect = positon;
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return foodClassifyList.size() + 1;
    }

    @Override
    public FoodClassify getItem(int i) {
        if (i < foodClassifyList.size()) {
            return foodClassifyList.get(i);
        }
        return null;

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
            if (i < foodClassifyList.size()) {
                view = layoutInflater.inflate(R.layout.listview_item_foodmaterial_classify, null);
                orderViewHolder.listview_item_foodmaterial_classify_text = (TextView) view.findViewById(R.id.listview_item_foodmaterial_classify_text);
            } else {
                view = layoutInflater.inflate(R.layout.listview_item_foodmaterial_classify_foot, null);
            }

            view.setTag(orderViewHolder);
        } else {
            orderViewHolder = (OrderViewHolder) view.getTag();
        }
        if (i < foodClassifyList.size()) {
            if (mSelect == i) {
                view.setBackgroundResource(R.color.redlow);  //选中项背景
            } else {
                view.setBackgroundResource(R.color.lowwhite);  //其他项背景
            }

            FoodClassify foodClassify = getItem(i);
            orderViewHolder.listview_item_foodmaterial_classify_text.setText(foodClassify.getFoodclassify_name());
        }

        return view;
    }


    class OrderViewHolder {

        TextView listview_item_foodmaterial_classify_text;

    }
}
