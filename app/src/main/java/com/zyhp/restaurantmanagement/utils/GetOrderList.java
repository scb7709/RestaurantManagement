package com.zyhp.restaurantmanagement.utils;

import com.zyhp.restaurantmanagement.entity.Food;
import com.zyhp.restaurantmanagement.entity.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */

public class GetOrderList {
    public static List<Object> getOrderList(){



        ArrayList  foodList = new ArrayList<>();
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

        return foodList;
    }
}
