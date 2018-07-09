package com.zyhp.restaurantmanagement.utils;

import android.content.Context;
import android.content.SharedPreferences;


import java.io.File;

/**
缓存
 */
public class ShareUitls {


    public static void putString(Context c, String key, String msg) {
        SharedPreferences sp = c.getSharedPreferences("string.xml", Context.MODE_PRIVATE);
        SharedPreferences.Editor e = sp.edit();
        e.putString(key, msg);
        e.commit();
    }

    public static String getString(Context c, String key, String d) {
        SharedPreferences sp = c.getSharedPreferences("string.xml", Context.MODE_PRIVATE);
        return sp.getString(key, d);
    }


    private static void deleteFilesByDirectory(File directory) {
        if (directory != null && directory.exists() && directory.isDirectory()) {

            for (File fi : directory.listFiles()) {
                if (fi.isDirectory()) {
                    deleteFilesByDirectory(fi);
                } else {
                    fi.delete();
                }
            }
        }

    }
}
