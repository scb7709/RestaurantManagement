package com.zyhp.restaurantmanagement.utils;

import android.app.Activity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.adapter.FoodClassifyAdapter;
import com.zyhp.restaurantmanagement.entity.Food;
import com.zyhp.restaurantmanagement.entity.FoodClassify;

/**
 * Created by Administrator on 2018/7/6.
 */

public class GetEditTextDialog {

    /**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

    /**
     * 正则表达式：验证邮箱
     */
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    public interface GetEditTextDialogInterface {
        void getText(String text);
    }

    public static void getEditTextDialog(final Activity activity,View v, String title, String hint,final GetEditTextDialogInterface getEditTextDialogInterface) {

        View view = LayoutInflater.from(activity).inflate(R.layout.dialog_getedittext, null);
        final PopupWindow popupWindow = new PopupWindow(view, ImageUtil.dp2px(activity, 300), ImageUtil.dp2px(activity, 230), true);


        Button dialog_getedittext_cancle = (Button) view.findViewById(R.id.dialog_getedittext_cancle);
        Button dialog_getedittext_ok = (Button) view.findViewById(R.id.dialog_getedittext_ok);
        TextView dialog_getedittext_title = (TextView) view.findViewById(R.id.dialog_getedittext_title);
        final EditText dialog_getedittext_edittext1 = (EditText) view.findViewById(R.id.dialog_getedittext_edittext1);
        dialog_getedittext_title.setText(title);
        dialog_getedittext_edittext1.setHint(hint);
        dialog_getedittext_cancle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        dialog_getedittext_ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String string = dialog_getedittext_edittext1.getText().toString();
                if (string.length() > 0) {
                    getEditTextDialogInterface.getText(string);
                    popupWindow.dismiss();
                } else {

                    MyShow.myToash(activity, "输入不能为空");
                }


            }
        });
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return false;
            }
        });


        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);


    }


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

}
