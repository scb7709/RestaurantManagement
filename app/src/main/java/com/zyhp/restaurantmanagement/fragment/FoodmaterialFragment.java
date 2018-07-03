package com.zyhp.restaurantmanagement.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/6/22.
 */
import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.adapter.FoodAdapter;
import com.zyhp.restaurantmanagement.adapter.FoodCladdifyAdapter;
import com.zyhp.restaurantmanagement.entity.Food;
import com.zyhp.restaurantmanagement.entity.FoodClassify;
import com.zyhp.restaurantmanagement.utils.GetString;

import java.util.ArrayList;
import java.util.List;

public class FoodmaterialFragment extends Fragment {

    ListView fragment_foodmaterial_classify, fragment_foodmaterial_food;
    TextView fragment_foodmaterial_classifyname;
    ImageView fragment_foodmaterial_add;
    FoodAdapter foodAdapter;
    List<FoodClassify> classifylist;
    List<Food> foodList;
    List<Food> tempfoodlist;
    View footView;
    LayoutInflater layoutInflater;
    FoodCladdifyAdapter foodCladdifyAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_foodmaterial, container, false);
        footView = inflater.inflate(R.layout.listview_item_foodmaterial_classify_foot, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findView(view);
        setListView();
    }

    private void setListView() {
        tempfoodlist = new ArrayList<>();
        classifylist = new ArrayList<>();
        classifylist.add(new FoodClassify(0, "主食"));
        classifylist.add(new FoodClassify(1, "炒菜"));
        classifylist.add(new FoodClassify(2, "汤菜"));
        classifylist.add(new FoodClassify(3, "火锅"));
        classifylist.add(new FoodClassify(4, "烤鱼"));

        foodList = new ArrayList<>();
        foodList.add(new Food(0, "米饭", "5"));
        foodList.add(new Food(0, "面条", "6"));
        foodList.add(new Food(0, "拉面", "7"));
        foodList.add(new Food(0, "刀削面", "10"));

        foodList.add(new Food(1, "小炒肉", "5"));
        foodList.add(new Food(1, "炒木耳", "6"));
        foodList.add(new Food(1, "炒青椒", "7"));
        foodList.add(new Food(1, "炒黄瓜", "10"));
        foodList.add(new Food(1, "炒土豆丝", "7"));
        foodList.add(new Food(1, "炒茄子", "10"));


        foodList.add(new Food(2, "黄瓜汤", "5"));
        foodList.add(new Food(2, "萝卜汤", "6"));
        foodList.add(new Food(2, "豆腐鱼汤", "7"));
        foodList.add(new Food(2, "西红柿鸡蛋汤", "11"));
        foodList.add(new Food(2, "酸菜米豆汤", "11"));

        foodList.add(new Food(3, "鱼火锅", "25"));
        foodList.add(new Food(3, "排骨火锅", "78"));
        foodList.add(new Food(3, "猪蹄火锅", "45"));
        foodList.add(new Food(3, "清汤锅", "45"));
        foodList.add(new Food(3, "野生菌火锅", "45"));


        foodList.add(new Food(4, "炭烤草鱼", "50"));
        foodList.add(new Food(4, "炭烤鲢鱼", "60"));
        foodList.add(new Food(4, "红烧鲤鱼", "70"));
        foodList.add(new Food(4, "烤江团鱼", "100"));

       /*
        for(int i=0;i<100;i++){
            int temp=i%6;
            Food food;
            switch (temp){
                case 0 :
                    food=new Food(temp,"主食"+i, GetString.createRandom(true,2));
                    break;
                case 1 :

                    break;
                case 2 :

                    break;
                case 3 :

                    break;
                case 4 :

                    break;

            }

        }*/

        fragment_foodmaterial_classify.addFooterView(footView);//添加尾部
        fragment_foodmaterial_classify.setSelector(R.color.redlow);
        foodCladdifyAdapter = new FoodCladdifyAdapter(classifylist, layoutInflater);
        fragment_foodmaterial_classify.setAdapter(foodCladdifyAdapter);


        tempfoodlist.add(new Food(0, "米饭", "5"));
        tempfoodlist.add(new Food(0, "面条", "6"));
        tempfoodlist.add(new Food(0, "拉面", "7"));
        tempfoodlist.add(new Food(0, "刀削面", "10"));
        foodAdapter = new FoodAdapter(tempfoodlist, layoutInflater);
        fragment_foodmaterial_food.setAdapter(foodAdapter);


        fragment_foodmaterial_classify.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tempfoodlist.clear();

                if (i < classifylist.size() - 1) {
                    FoodClassify foodClassify = classifylist.get(i);
                    fragment_foodmaterial_classifyname.setText(foodClassify.getFoodclassify_name());
                    for (Food food : foodList) {
                        if (food.getFood_classifyId() == foodClassify.getFoodclassify_id()) {
                            tempfoodlist.add(food);
                        }
                    }
                    if (tempfoodlist.size() > 0) {
                        foodAdapter = new FoodAdapter(tempfoodlist, layoutInflater);
                        fragment_foodmaterial_food.setAdapter(foodAdapter);
                    }

                } else {


                }

            }
        });


    }

    private void findView(View view) {
        layoutInflater = LayoutInflater.from(getActivity());
        fragment_foodmaterial_classify = (ListView) view.findViewById(R.id.fragment_foodmaterial_classify);
        fragment_foodmaterial_food = (ListView) view.findViewById(R.id.fragment_foodmaterial_food);
        fragment_foodmaterial_classifyname = (TextView) view.findViewById(R.id.fragment_foodmaterial_classifyname);
        fragment_foodmaterial_add = (ImageView) view.findViewById(R.id.fragment_foodmaterial_add);

        fragment_foodmaterial_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

}
