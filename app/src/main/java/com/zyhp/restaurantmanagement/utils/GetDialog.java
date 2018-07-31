package com.zyhp.restaurantmanagement.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.adapter.FoodClassifyAdapter;
import com.zyhp.restaurantmanagement.entity.Food;
import com.zyhp.restaurantmanagement.entity.FoodClassify;
import com.zyhp.restaurantmanagement.entity.Income;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Administrator on 2018/7/6.
 */

public class GetDialog {




    public interface GetEditTextDialogInterface {
        void getText(String text);
    }
    static PopupWindow popupWindow;
    public static void getEditTextDialog(final Activity activity,View v, String title, String hint,final GetEditTextDialogInterface getEditTextDialogInterface) {

        View view = LayoutInflater.from(activity).inflate(R.layout.dialog_getedittext, null);
         popupWindow = new PopupWindow(view, ImageUtil.dp2px(activity, 300), ImageUtil.dp2px(activity, 230), true);
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

    public interface GeCheckBoxDialogInterface {
        void getCheckBox(boolean [] booleens);
    }
    public static void getCheckBoxDialog(final Activity activity,View v, final GeCheckBoxDialogInterface geCheckBoxDialogInterface) {

        View view = LayoutInflater.from(activity).inflate(R.layout.dialog_addtakeout, null);
        popupWindow = new PopupWindow(view, ImageUtil.dp2px(activity, 300), ImageUtil.dp2px(activity, 300), true);
        Button dialog_getedittext_cancle = (Button) view.findViewById(R.id.dialog_addtakeout_cancle);
        Button dialog_getedittext_ok = (Button) view.findViewById(R.id.dialog_addtakeout_ok);

       final CheckBox dialog_addtakeout_baidu = (CheckBox) view.findViewById(R.id.dialog_addtakeout_baidu);
        final  CheckBox dialog_addtakeout_meituan = (CheckBox) view.findViewById(R.id.dialog_addtakeout_meituan);
        final CheckBox dialog_addtakeout_elema = (CheckBox) view.findViewById(R.id.dialog_addtakeout_elema);
        final  CheckBox dialog_addtakeout_koubei = (CheckBox) view.findViewById(R.id.dialog_addtakeout_koubei);




        dialog_getedittext_cancle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        dialog_getedittext_ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            boolean [] booleens={dialog_addtakeout_meituan.isChecked(),dialog_addtakeout_baidu.isChecked(),
                    dialog_addtakeout_koubei.isChecked(),dialog_addtakeout_elema.isChecked()};

                geCheckBoxDialogInterface.getCheckBox(booleens);
                popupWindow.dismiss();
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

    public interface IsOperationInterface {
        void isOperation();
    }

    public static void IsOperation(final Activity activity,String title, String suretext,final IsOperationInterface isOperationInterface) {
        Dialog dialog=new AlertDialog.Builder(activity)
                .setTitle(title)
                .setMessage(suretext)
//相当于点击确认按钮
                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        isOperationInterface.isOperation();


                    }
                })
//相当于点击取消按钮
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create();
        dialog.show();
    }

  public interface GetTimeDialogInterface{
        void  getTimeDialogInterface( int year, int monthOfYear, int dayOfMonth);
   }

    public  static  void getTimeDialog(Activity activity,String minTime,Calendar calendar,final  GetTimeDialogInterface getTimeDialogInterface){
        int style= AlertDialog.THEME_HOLO_LIGHT;
        DatePickerDialog datePickerDialog=    new DatePickerDialog(activity,style,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        getTimeDialogInterface.getTimeDialogInterface( year,  monthOfYear,  dayOfMonth);
                    }
                },
                calendar.get(Calendar.YEAR),  calendar.get(Calendar.MONTH),  calendar.get(Calendar.DATE));

        DatePicker datePicker = datePickerDialog.getDatePicker();
        datePickerDialog.setTitle("选择查询日期");
        try {
            //设置最小日期
            datePicker.setMinDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(minTime).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        } //设置最大日期
        datePicker.setMaxDate(System.currentTimeMillis());
        datePickerDialog.show();

    }
}
