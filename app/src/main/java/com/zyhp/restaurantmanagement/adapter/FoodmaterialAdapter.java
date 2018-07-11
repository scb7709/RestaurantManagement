package com.zyhp.restaurantmanagement.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.entity.Food;
import com.zyhp.restaurantmanagement.entity.Foodmaterial;

import java.util.List;

/**
 * Created by Administrator on 2018/7/2.
 */


public class FoodmaterialAdapter extends BaseAdapter {
    List<Object> foodmaterialList;
    LayoutInflater layoutInflater;

    public FoodmaterialAdapter() {
    }

    public FoodmaterialAdapter(List<Object> foodmaterialList, LayoutInflater layoutInflater) {
        this.foodmaterialList = foodmaterialList;
        this.layoutInflater = layoutInflater;
    }

    public List<Object> getList() {

        return foodmaterialList;
    }

    @Override
    public int getCount() {
        return foodmaterialList.size();
    }

    @Override
    public Object getItem(int i) {
        return foodmaterialList.get(i);
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
            view = layoutInflater.inflate(R.layout.listview_item_foodmaterial, null);
            orderViewHolder.listview_item_foodmaterial_name = (TextView) view.findViewById(R.id.listview_item_foodmaterial_name);
            orderViewHolder.listview_item_foodmaterial_stock = (TextView) view.findViewById(R.id.listview_item_foodmaterial_stock);
            orderViewHolder.listview_item_foodmaterial_unit = (TextView) view.findViewById(R.id.listview_item_foodmaterial_unit);

            view.setTag(orderViewHolder);
        } else {
            orderViewHolder = (OrderViewHolder) view.getTag();
        }

        Foodmaterial foodmaterial = (Foodmaterial) getItem(i);
        orderViewHolder.listview_item_foodmaterial_name.setText(foodmaterial.getFoodmaterial_name());
        orderViewHolder.listview_item_foodmaterial_stock.setText(foodmaterial.getFoodmaterial_stock());

        orderViewHolder.listview_item_foodmaterial_unit.setText(foodmaterial.getFoodmaterial_unit());
        return view;
    }


    class OrderViewHolder {
        TextView listview_item_foodmaterial_name, listview_item_foodmaterial_stock,listview_item_foodmaterial_unit;

    }
}
