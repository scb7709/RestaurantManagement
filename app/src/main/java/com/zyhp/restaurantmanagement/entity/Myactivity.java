package com.zyhp.restaurantmanagement.entity;

/**
 * Created by Administrator on 2018/7/10.
 */

public class Myactivity {
    private int id;//ID
    private String type;//优惠类型
    private String number;//优惠数据
    private  String limit;//限制条件
    private String date;//活动期限
    private String state;//活动状态

    public Myactivity(String type, String number, String limit, String date, String state) {
        this.type = type;
        this.number = number;
        this.limit = limit;
        this.date = date;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
