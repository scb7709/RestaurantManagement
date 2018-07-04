package com.zyhp.restaurantmanagement.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.adapter.FoodDetialsMaterialAdapter;
import com.zyhp.restaurantmanagement.entity.Food;
import com.zyhp.restaurantmanagement.entity.Foodmaterial;
import com.zyhp.restaurantmanagement.utils.GetString;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/4.
 */

public class FoodDetialsActivity extends BaseActivity implements View.OnClickListener{

    private TextView view_publictitle_title,activity_fooddetials_name,activity_fooddetials_money,activity_fooddetials_todaySalesvolume,activity_fooddetials_totalSalesvolume,activity_fooddetials_salesvolumeRanking;
    private ListView activity_fooddetials_foodmaterial;

    private RelativeLayout view_publictitle_back;
    Food food;
    List<Foodmaterial> foodmaterials;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fooddetials);
        food=(Food)getIntent().getSerializableExtra("food");

        findView();
    }

    void findView() {
        view_publictitle_title = (TextView) findViewById(R.id.view_publictitle_title);
        view_publictitle_title.setText("菜品详情");
        view_publictitle_back = (RelativeLayout) findViewById(R.id.view_publictitle_back);
        view_publictitle_back.setOnClickListener(this);


        activity_fooddetials_name = (TextView) findViewById(R.id.activity_fooddetials_name);
        activity_fooddetials_money = (TextView) findViewById(R.id.activity_fooddetials_money);
        activity_fooddetials_todaySalesvolume = (TextView) findViewById(R.id.activity_fooddetials_todaySalesvolume);
        activity_fooddetials_totalSalesvolume = (TextView) findViewById(R.id.activity_fooddetials_totalSalesvolume);
        activity_fooddetials_salesvolumeRanking = (TextView) findViewById(R.id.activity_fooddetials_salesvolumeRanking);
        activity_fooddetials_foodmaterial = (ListView) findViewById(R.id.activity_fooddetials_foodmaterial);

        if(food!=null){
            activity_fooddetials_name.setText(food.getFood_name());
            activity_fooddetials_money.setText(food.getFood_money()+"元/份");
            activity_fooddetials_todaySalesvolume.setText(GetString.createRandom(true,2)+"份");
            activity_fooddetials_totalSalesvolume.setText(GetString.createRandom(true,2)+"份");
            activity_fooddetials_salesvolumeRanking.setText(GetString.createRandom(true,2));

        }
        foodmaterials=new ArrayList<>();
        foodmaterials.add(new Foodmaterial("青椒","2","份"));
        foodmaterials.add(new Foodmaterial("鲜肉片","3","份"));
        foodmaterials.add(new Foodmaterial("大蒜","2","份"));
        foodmaterials.add(new Foodmaterial("大葱","2","份"));
        foodmaterials.add(new Foodmaterial("花椒","2","份"));
        foodmaterials.add(new Foodmaterial("豆芽","1","份"));
        foodmaterials.add(new Foodmaterial("薯条","2","份"));

        FoodDetialsMaterialAdapter foodDetialsMaterialAdapter=new FoodDetialsMaterialAdapter(foodmaterials, LayoutInflater.from(this));
        activity_fooddetials_foodmaterial.setAdapter(foodDetialsMaterialAdapter);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.view_publictitle_back:
                finish();
                break;
            case 0:

                break;
        }
    }
}
