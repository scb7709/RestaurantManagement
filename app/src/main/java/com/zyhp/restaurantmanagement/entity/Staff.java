package com.zyhp.restaurantmanagement.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/9.
 */

public class Staff implements Serializable{
   private int  id;
    private  String name;//姓名
    private  String birthday;//年龄

    private String phone;//电话号码
    private  String email;//邮箱
    private  String address;//住址
    private  String headurl;//头像
    private  String worknumber;//工号
    private String  department;//部门
    private String position;//职位
    private   String hiredate;//入职时间


    public Staff(String worknumber ,String name, String birthday, String phone, String email, String address, String department, String position) {
        this.worknumber = worknumber;
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.department = department;
        this.position = position;
    }
    @Override

    public boolean equals(Object obj) {

        if(obj==null){

            return false;

        }

        if(this==obj){

            return true;

        }

        if(obj instanceof Staff){

            Staff staff=(Staff)obj;

            return staff.worknumber.equals(this.worknumber);

        }

        return false;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHeadurl() {
        return headurl;
    }

    public void setHeadurl(String headurl) {
        this.headurl = headurl;
    }

    public String getWorknumber() {
        return worknumber;
    }

    public void setWorknumber(String worknumber) {
        this.worknumber = worknumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }
}
