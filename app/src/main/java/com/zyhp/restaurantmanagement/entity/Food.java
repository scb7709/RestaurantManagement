package com.zyhp.restaurantmanagement.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/3.
 */

public class Food implements Serializable{
    private String food_id;
    private int food_classifyId;
    private String food_image;
    private String food_name;
    private String food_money;
    private String food_num;




    public int getFood_classifyId() {
        return food_classifyId;
    }

    public void setFood_classifyId(int food_classifyId) {
        this.food_classifyId = food_classifyId;
    }

    public Food(int food_classifyId, String food_name, String food_money) {
        this.food_classifyId = food_classifyId;
        this.food_name = food_name;
        this.food_money = food_money;
    }

    public Food(String food_name, String food_money, String food_num) {
        this.food_name = food_name;
        this.food_money = food_money;
        this.food_num = food_num;
    }

    public String getFood_money() {
        return food_money;
    }

    public void setFood_money(String food_money) {
        this.food_money = food_money;
    }

    public String getFood_id() {
        return food_id;
    }

    public void setFood_id(String food_id) {
        this.food_id = food_id;
    }

    public String getFood_image() {
        return food_image;
    }

    public void setFood_image(String food_image) {
        this.food_image = food_image;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_num() {
        return food_num;
    }

    public void setFood_num(String food_num) {
        this.food_num = food_num;
    }
}
