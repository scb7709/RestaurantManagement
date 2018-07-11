package com.zyhp.restaurantmanagement.entity;

/**
 * Created by Administrator on 2018/7/3.
 */

public class FoodmaterialClassify {
   private int foodmaterialclassify_id;//id
    private String  foodmaterialclassify_name;//分类名称

    public FoodmaterialClassify(int foodmaterialclassify_id, String foodmaterialclassify_name) {
        this.foodmaterialclassify_id = foodmaterialclassify_id;
        this.foodmaterialclassify_name = foodmaterialclassify_name;
    }

    public int getFoodclassify_id() {
        return foodmaterialclassify_id;
    }

    public void setFoodclassify_id(int foodmaterialclassify_id) {
        this.foodmaterialclassify_id = foodmaterialclassify_id;
    }

    public String getFoodclassify_name() {
        return foodmaterialclassify_name;
    }

    public void setFoodclassify_name(String foodclassify_name) {
        this.foodmaterialclassify_name = foodclassify_name;
    }
}
