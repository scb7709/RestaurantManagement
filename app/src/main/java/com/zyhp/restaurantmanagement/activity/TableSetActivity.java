package com.zyhp.restaurantmanagement.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.adapter.TableSetAdapter;
import com.zyhp.restaurantmanagement.utils.GetDialog;
import com.zyhp.restaurantmanagement.utils.MyShow;
import com.zyhp.restaurantmanagement.utils.Regular;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/6.
 */

public class TableSetActivity extends BaseActivity implements View.OnClickListener {

    GridView activity_tableset_gridlayout;
    private TextView view_publictitle_title;

    private RelativeLayout view_publictitle_back;
    Activity activity;

    TableSetAdapter tableSetAdapter;
    List<String> stringList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tableset);
        activity = this;
        findView();
    }

    void findView() {
        view_publictitle_title = (TextView) findViewById(R.id.view_publictitle_title);
        view_publictitle_title.setText("桌位管理");
        view_publictitle_back = (RelativeLayout) findViewById(R.id.view_publictitle_back);
        view_publictitle_back.setOnClickListener(this);
        activity_tableset_gridlayout = (GridView) findViewById(R.id.activity_tableset_gridlayout);
        findViewById(R.id.activity_tableset_addlayout).setOnClickListener(this);
        stringList = new ArrayList<>();

        for (int i = 0; i < 90; i++) {
            stringList.add(i + "");
        }
        tableSetAdapter = new TableSetAdapter(stringList, LayoutInflater.from(this));
        activity_tableset_gridlayout.setAdapter(tableSetAdapter);
        activity_tableset_gridlayout.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                GetDialog.IsOperation(activity, "删除桌位", "确定删除"+stringList.get(i)+"号桌位吗?", new GetDialog.IsOperationInterface() {
                    @Override
                    public void isOperation() {
                        stringList.remove(i);
                        tableSetAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.view_publictitle_back:
                finish();
                break;
            case R.id.activity_tableset_addlayout:
                GetDialog.getEditTextDialog(activity, view, "新增桌位", "请输入桌位号", new GetDialog.GetEditTextDialogInterface() {
                    @Override
                    public void getText(String text) {
                        if (Regular.isPositiveInteger(text)) {
                            if(!stringList.contains(text)){
                                if(Integer.parseInt(text)<100){
                                    stringList.add(text);
                                    tableSetAdapter.notifyDataSetChanged();
                                    MyShow.myToash(activity, "新增成功成功");
                                }else {
                                    MyShow.myToash(activity, "桌位号不能超过100");
                                }

                            }else {
                                MyShow.myToash(activity, "桌位号已存在");
                            }


                        }else {
                            MyShow.myToash(activity, "桌位号只能输入正整数");
                        }

                    }
                });


                break;
        }
    }
}
