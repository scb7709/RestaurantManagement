package com.zyhp.restaurantmanagement.entity;

/**
 * Created by Administrator on 2018/7/3.
 */

public class FoodClassify {
   private int foodclassify_id;
    private String  foodclassify_name;

    public FoodClassify(int foodclassify_id, String foodclassify_name) {
        this.foodclassify_id = foodclassify_id;
        this.foodclassify_name = foodclassify_name;
    }

    public int getFoodclassify_id() {
        return foodclassify_id;
    }

    public void setFoodclassify_id(int foodclassify_id) {
        this.foodclassify_id = foodclassify_id;
    }

    public String getFoodclassify_name() {
        return foodclassify_name;
    }

    public void setFoodclassify_name(String foodclassify_name) {
        this.foodclassify_name = foodclassify_name;
    }
}
