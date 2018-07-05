package com.zyhp.restaurantmanagement.entity;

/**
 * Created by Administrator on 2018/7/5.
 */

public class Income {
    private String turnovers;//营业额
    private String ordercount;//订单数
    private String foodcount;//菜品销量
    private String date;//日期
    private String X;//画折线图时 用来表示X轴的坐标

    public Income(String turnovers) {
        this.turnovers = turnovers;

    }


    public Income(String date, String turnovers, String ordercount, String foodcount) {
        this.turnovers = turnovers;
        this.ordercount = ordercount;
        this.foodcount = foodcount;
        this.date = date;
    }

    public String getTurnovers() {
        return turnovers;
    }

    public void setTurnovers(String turnovers) {
        this.turnovers = turnovers;
    }

    public String getOrdercount() {
        return ordercount;
    }

    public void setOrdercount(String ordercount) {
        this.ordercount = ordercount;
    }

    public String getFoodcount() {
        return foodcount;
    }

    public void setFoodcount(String foodcount) {
        this.foodcount = foodcount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
