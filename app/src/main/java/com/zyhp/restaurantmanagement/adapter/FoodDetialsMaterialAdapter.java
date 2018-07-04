package com.zyhp.restaurantmanagement.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.entity.Food;
import com.zyhp.restaurantmanagement.entity.Foodmaterial;

import java.util.List;

/**
 * Created by Administrator on 2018/7/2.
 */


public class FoodDetialsMaterialAdapter extends BaseAdapter {
    List<Foodmaterial> foodmaterials;
    LayoutInflater layoutInflater;

    public FoodDetialsMaterialAdapter() {
    }

    public FoodDetialsMaterialAdapter(List<Foodmaterial> foodmaterials, LayoutInflater layoutInflater) {
        this.foodmaterials = foodmaterials;
        this.layoutInflater = layoutInflater;
    }

    @Override
    public int getCount() {
        return foodmaterials.size();
    }

    @Override
    public Foodmaterial getItem(int i) {
        return foodmaterials.get(i);
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
            view=layoutInflater.inflate(R.layout.listview_item_fooddetialsmaterial,null);
            orderViewHolder.listview_item_fooddetialsmaterial_name=(TextView)view.findViewById(R.id.listview_item_fooddetialsmaterial_name);
            orderViewHolder.listview_item_fooddetialsmaterial_num=(TextView)view.findViewById(R.id.listview_item_fooddetialsmaterial_num);


            view.setTag(orderViewHolder);
        }else {
            orderViewHolder=(OrderViewHolder) view.getTag();
        }

        Foodmaterial foodmaterial = getItem(i);
        orderViewHolder.listview_item_fooddetialsmaterial_name.setText(foodmaterial.getFoodmaterial_name());
        orderViewHolder.listview_item_fooddetialsmaterial_num.setText("x"+foodmaterial.getFoodmaterial_num());



        return view;
    }


    class OrderViewHolder {

        TextView  listview_item_fooddetialsmaterial_name,listview_item_fooddetialsmaterial_num;

    }
}
