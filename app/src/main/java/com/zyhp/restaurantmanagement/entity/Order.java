package com.zyhp.restaurantmanagement.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/2.
 */

public class Order  implements Serializable{
    public Order() {
    }

    public Order(int id, String order_id, String time, int tableNumber, String state, String name, String money) {
        this.id = id;
        this.order_id = order_id;
        this.time = time;
        this.tableNumber = tableNumber;
        this.state = state;
        this.name = name;
        this.money = money;
    }

    private  int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    private  String order_id;
    private   String time;
    private   int tableNumber;
    private    String state;
    private   String name;
    private   String money;
}
