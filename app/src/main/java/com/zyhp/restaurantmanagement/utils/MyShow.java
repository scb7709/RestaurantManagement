package com.zyhp.restaurantmanagement.utils;

import android.content.Context;
import android.widget.Toast;

import com.zyhp.restaurantmanagement.activity.OrderDetialsActivity;

/**
 * Created by Administrator on 2018/7/3.
 */

public class MyShow {

    public  static  void  myToash(Context context,String content){
        Toast.makeText(context,content,Toast.LENGTH_LONG).show();

    }
}
