package com.zyhp.restaurantmanagement.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/27.
 */

public class Member implements Serializable{
    private int id;//id
    private String number;//会员编号
    private String name;//会员名称
    private String head;//会员头像
    private String sex;//会员性别
    private String birthday;//会员生日
    private String integral;//会员积分
    private String money;//会员账户余额
    private String jointime;//会员入会时间

    public Member( String name, String number,String integral, String money) {
        this.number = number;
        this.name = name;
        this.integral = integral;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getJointime() {
        return jointime;
    }

    public void setJointime(String jointime) {
        this.jointime = jointime;
    }
}
