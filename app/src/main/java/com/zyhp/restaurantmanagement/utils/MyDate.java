package com.zyhp.restaurantmanagement.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/7/2.
 */

public class MyDate {

    public static String getNowTime() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHms");
        /**获取当前时间*/
        Date curDate = new Date(System.currentTimeMillis());
        String dataStrNew = sdf.format(curDate);

        return  dataStrNew;
    }
    public static String getIncomeTime() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date curDate = new Date(System.currentTimeMillis());
        String dataStrNew = sdf.format(curDate);

        return  dataStrNew;
    }

    public static String getOrderTime() {

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd HH:mm");
        /**获取当前时间*/
        Date curDate = new Date(System.currentTimeMillis());
        String dataStrNew = sdf.format(curDate);

        return  dataStrNew;
    }
}
