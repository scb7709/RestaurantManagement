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


public class FoodCladdifyAdapter extends BaseAdapter {
    List<FoodClassify> foodClassifyList;
    LayoutInflater layoutInflater;

    public FoodCladdifyAdapter() {
    }

    public FoodCladdifyAdapter(List<FoodClassify> foodClassifyList, LayoutInflater layoutInflater) {
        this.foodClassifyList = foodClassifyList;
        this.layoutInflater = layoutInflater;
    }

    @Override
    public int getCount() {
        return foodClassifyList.size();
    }

    @Override
    public FoodClassify getItem(int i) {
        return foodClassifyList.get(i);
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
            view = layoutInflater.inflate(R.layout.listview_item_foodmaterial_classify, null);
            orderViewHolder.listview_item_foodmaterial_classify_text = (TextView) view.findViewById(R.id.listview_item_foodmaterial_classify_text);


            view.setTag(orderViewHolder);
        } else {
            orderViewHolder = (OrderViewHolder) view.getTag();
        }

        FoodClassify foodClassify = getItem(i);
        orderViewHolder.listview_item_foodmaterial_classify_text.setText(foodClassify.getFoodclassify_name());


        return view;
    }


    class OrderViewHolder {

        TextView listview_item_foodmaterial_classify_text;

    }
}
