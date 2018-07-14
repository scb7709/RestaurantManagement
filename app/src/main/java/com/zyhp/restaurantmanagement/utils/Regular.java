package com.zyhp.restaurantmanagement.utils;

import android.text.TextUtils;

/**
 * Created by Administrator on 2018/7/9.
 */

public class Regular {

    /**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

    /**
     * 正则表达式：验证邮箱
     */
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    /**
     * 正则表达式：验证QQ
     */
    public static final String REGEX_QQ = "^[1-9][0-9]{4,14}$";

    /**
     * 正则表达式：验证全数字
     */
    public static final String REGEX_PositiveInteger = "^[0-9]+$";
    //手机号判断
    public static boolean isMobile(String mobiles) {
        if (TextUtils.isEmpty(mobiles)) return false;
        else return mobiles.matches(REGEX_MOBILE);
    }
    //邮箱判断
    public static boolean isEmail(String email) {
        if (TextUtils.isEmpty(email)) return false;
        else return email.matches(REGEX_EMAIL);
    }
    //QQ判断
    public static boolean isQQ(String QQ) {
        if (TextUtils.isEmpty(QQ)) return false;
        else return QQ.matches(REGEX_QQ);
    }

    //正整数
    public static boolean isPositiveInteger(String PositiveInteger) {
        if (TextUtils.isEmpty(PositiveInteger)) return false;
        else return PositiveInteger.matches(REGEX_PositiveInteger);
    }
}
