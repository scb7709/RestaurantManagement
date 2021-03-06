package com.zyhp.restaurantmanagement.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/4.
 */

public class Foodmaterial implements Serializable{
    private int foodmaterial_id;
    private int foodmaterialclasdify_id;//分类ID
    private String foodmaterial_name;//名字
    private String Foodmaterial_money;//单价
    private String foodmaterial_num;//数量

    private String unitPrice;//单价
    private String foodmaterial_unit;//单位
    private String foodmaterial_stock;//库存

    public int getFoodmaterialclasdify_id() {
        return foodmaterialclasdify_id;
    }

    public void setFoodmaterialclasdify_id(int foodmaterialclasdify_id) {
        this.foodmaterialclasdify_id = foodmaterialclasdify_id;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Foodmaterial(String foodmaterial_name, String foodmaterial_num, String foodmaterial_unit) {
        this.foodmaterial_name = foodmaterial_name;
        this.foodmaterial_num = foodmaterial_num;
        this.foodmaterial_unit = foodmaterial_unit;
    }

    public Foodmaterial(int foodmaterialclasdify_id, String foodmaterial_name, String foodmaterial_stock, String foodmaterial_unit) {
        this.foodmaterialclasdify_id = foodmaterialclasdify_id;
        this.foodmaterial_name = foodmaterial_name;
        this.foodmaterial_stock = foodmaterial_stock;
        this.foodmaterial_unit = foodmaterial_unit;
    }

    public int getFoodmaterial_id() {
        return foodmaterial_id;
    }

    public void setFoodmaterial_id(int foodmaterial_id) {
        this.foodmaterial_id = foodmaterial_id;
    }

    public String getFoodmaterial_name() {
        return foodmaterial_name;
    }

    public void setFoodmaterial_name(String foodmaterial_name) {
        this.foodmaterial_name = foodmaterial_name;
    }

    public String getFoodmaterial_money() {
        return Foodmaterial_money;
    }

    public void setFoodmaterial_money(String foodmaterial_money) {
        Foodmaterial_money = foodmaterial_money;
    }

    public String getFoodmaterial_num() {
        return foodmaterial_num;
    }

    public void setFoodmaterial_num(String foodmaterial_num) {
        this.foodmaterial_num = foodmaterial_num;
    }

    public String getFoodmaterial_unit() {
        return foodmaterial_unit;
    }

    public void setFoodmaterial_unit(String foodmaterial_unit) {
        this.foodmaterial_unit = foodmaterial_unit;
    }

    public String getFoodmaterial_stock() {
        return foodmaterial_stock;
    }

    public void setFoodmaterial_stock(String foodmaterial_stock) {
        this.foodmaterial_stock = foodmaterial_stock;
    }
}
