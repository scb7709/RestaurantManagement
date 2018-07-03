package com.zyhp.restaurantmanagement.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.entity.Food;
import com.zyhp.restaurantmanagement.entity.Order;

import java.util.List;

/**
 * Created by Administrator on 2018/7/2.
 */


public class OrderFoodAdapter extends BaseAdapter {
    List<Food> foodList;
    LayoutInflater layoutInflater;

    public OrderFoodAdapter() {
    }

    public OrderFoodAdapter(List<Food> foodList, LayoutInflater layoutInflater) {
        this.foodList = foodList;
        this.layoutInflater = layoutInflater;
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Food getItem(int i) {
        return foodList.get(i);
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
            view=layoutInflater.inflate(R.layout.listview_item_orderfood,null);
            orderViewHolder.listview_item_orderfood_foodimage=(ImageView)view.findViewById(R.id. listview_item_orderfood_foodimage);
            orderViewHolder.listview_item_orderfood_foodnumber=(TextView)view.findViewById(R.id.listview_item_orderfood_foodnumber);
            orderViewHolder.listview_item_orderfood_foodmoney=(TextView)view.findViewById(R.id.listview_item_orderfood_foodmoney);
            orderViewHolder.listview_item_orderfood_foodname=(TextView)view.findViewById(R.id.listview_item_orderfood_foodname);

            view.setTag(orderViewHolder);
        }else {
            orderViewHolder=(OrderViewHolder) view.getTag();
        }

        Food food = getItem(i);
        orderViewHolder.listview_item_orderfood_foodnumber.setText("x"+food.getFood_num());
        orderViewHolder.listview_item_orderfood_foodmoney.setText("￥"+food.getFood_money());
        orderViewHolder.listview_item_orderfood_foodname.setText(food.getFood_name()+"");
       // orderViewHolder.listview_item_orderfood_foodimage.setText(order.getState());


        return view;
    }


    class OrderViewHolder {
        ImageView listview_item_orderfood_foodimage;
        TextView  listview_item_orderfood_foodnumber,listview_item_orderfood_foodmoney, listview_item_orderfood_foodname;

    }
}
