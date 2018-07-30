package com.zyhp.restaurantmanagement.entity;

/**
 * Created by Administrator on 2018/7/30.
 */

public class ConsumptionRecords {
    private int id;
    private String time;
    private String type;
    private String money;
    private String remarks;

    public ConsumptionRecords(String time, String type, String money, String remarks) {
        this.time = time;
        this.type = type;
        this.money = money;
        this.remarks = remarks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
