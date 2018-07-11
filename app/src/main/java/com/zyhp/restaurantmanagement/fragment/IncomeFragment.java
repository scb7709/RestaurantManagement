package com.zyhp.restaurantmanagement.fragment;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.activity.SearchActivity;

import com.zyhp.restaurantmanagement.entity.Income;
import com.zyhp.restaurantmanagement.entity.Order;
import com.zyhp.restaurantmanagement.myview.ChartView;

import com.zyhp.restaurantmanagement.utils.GetString;
import com.zyhp.restaurantmanagement.utils.MyDate;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


/**
 * Created by Administrator on 2018/7/5.
 */

public class IncomeFragment extends Fragment implements View.OnClickListener {
    TextView fragment_income_turnovers, fragment_income_foodcount, fragment_income_ordercount, fragment_income_date;
    LinearLayout fragment_income_orderlayout;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    private ChartView fragment_income_chartview_day,fragment_income_chartview_month;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_income, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findView(view);
    }

    private void findView(View view) {
        fragment_income_turnovers = (TextView) view.findViewById(R.id.fragment_income_turnovers);
        fragment_income_foodcount = (TextView) view.findViewById(R.id.fragment_income_foodcount);
        fragment_income_ordercount = (TextView) view.findViewById(R.id.fragment_income_ordercount);
        fragment_income_date = (TextView) view.findViewById(R.id.fragment_income_date);
        fragment_income_date.setOnClickListener(this);
        fragment_income_orderlayout = (LinearLayout) view.findViewById(R.id.fragment_income_orderlayout);
        fragment_income_orderlayout.setOnClickListener(this);
        fragment_income_chartview_day = (ChartView) view.findViewById(R.id.fragment_income_chartview_day);
        fragment_income_chartview_month = (ChartView) view.findViewById(R.id.fragment_income_chartview_month);

        Date date = new Date();
        Income income = new Income(dateFormat.format(date), "59324.2", "520", "1200");
        setIncomeData(income);


       // incomeList = new ArrayList<>();






        makeLine();
    }

    private void setIncomeData(Income income) {
        fragment_income_date.setText(income.getDate());
        fragment_income_turnovers.setText(income.getTurnovers());
        fragment_income_foodcount.setText(income.getFoodcount());
        fragment_income_ordercount.setText(income.getOrdercount());

    }


    private void makeLine() {
        Calendar cale =  Calendar.getInstance();
        //int year = cale.get(Calendar.YEAR);
        int month = cale.get(Calendar.MONTH) + 1;
        int day = cale.get(Calendar.DATE);


        //x轴坐标对应的数据
        List<String> xValue_day = new ArrayList<>();
        //y轴坐标对应的数据
        List<Integer> yValue_day = new ArrayList<>();
        //折线对应的数据
        Map<String, Integer> value_day = new HashMap<>();
        for (int i = 1; i<= day; i++) {
            xValue_day.add(i+ "号");
            value_day.put(i + "号", new Random().nextInt(9000)+1000);//60--240
        }
        for (int i = 1; i <=10; i++) {
            yValue_day.add(i * 1000);
        }
        fragment_income_chartview_day.setValue(value_day, xValue_day, yValue_day);


       /* //x轴坐标对应的数据
         List<String> xValue_month = new ArrayList<>();
        //y轴坐标对应的数据
         List<Integer> yValue_month = new ArrayList<>();
        //折线对应的数据
         Map<String, Integer> value_month = new HashMap<>();
        for (int i = 1; i<= month; i++) {
            xValue_month.add(i+ "月");
            value_month.put(i + "月", new Random().nextInt(90000)+10000);//60--240
        }
        for (int i = 1; i <=5; i++) {
            yValue_month.add(i * 20000);
        }
        fragment_income_chartview_month.setValue(value_month, xValue_month, yValue_month);*/
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_income_date:
                //int style=DatePickerDialog.THEME_DEVICE_DEFAULT_DARK;
                //int style=DatePickerDialog.BUTTON_NEGATIVE;
                 int style= AlertDialog.THEME_HOLO_LIGHT;
              //  int style=DatePickerDialog.THEME_DEVICE_DEFAULT_DARK;
              //  int style=DatePickerDialog.THEME_DEVICE_DEFAULT_DARK;
              //  int style=DatePickerDialog.THEME_DEVICE_DEFAULT_DARK;


                DatePickerDialog datePickerDialog=    new DatePickerDialog(getActivity(),style,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(year, monthOfYear, dayOfMonth);
                                Income income = new Income(dateFormat.format(calendar.getTime()), GetString.createRandom(true, 5), GetString.createRandom(true, 3), GetString.createRandom(true, 4));
                                setIncomeData(income);
                            }
                        },
                        2018, 6, 11);

                DatePicker datePicker = datePickerDialog.getDatePicker();
                datePickerDialog.setTitle("选择查询日期");
                try {
                    //设置最小日期
                    datePicker.setMinDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2000-01-01 00:00:00").getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                } //设置最大日期
                datePicker.setMaxDate(System.currentTimeMillis());
                datePickerDialog.show();
                break;
            case R.id.fragment_income_orderlayout:
                List orderList= new ArrayList<>();
                for (int i = 0; i < 100; i++) {
                    Order order=null;
                    switch (i % 4) {
                        case 0:
                            order = new Order(i, MyDate.getNowTime() + i, MyDate.getOrderTime(), i, "已接单", GetString.createRandom(false, 8), GetString.createRandom(true, 2));
                            break;
                        case 1:
                            order = new Order(i, MyDate.getNowTime() + i, MyDate.getOrderTime(), i, "待接单", GetString.createRandom(false, 8), GetString.createRandom(true, 2));
                            break;
                        case 2:
                            order = new Order(i, MyDate.getNowTime() + i, MyDate.getOrderTime(), i, "已完成", GetString.createRandom(false, 8), GetString.createRandom(true, 2));
                            break;
                        case 3:
                            order = new Order(i, MyDate.getNowTime() + i, MyDate.getOrderTime(), i, "已取消", GetString.createRandom(false, 8), GetString.createRandom(true, 2));
                            break;

                    }
                    orderList.add(order);
                }

                Intent intent =new Intent(getActivity(),SearchActivity.class);

                intent.putExtra("flag","order");
                intent.putExtra("data", (Serializable) orderList);
                startActivity(intent);
                break;

        }
    }
}
