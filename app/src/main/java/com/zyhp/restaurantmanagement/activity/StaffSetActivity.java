package com.zyhp.restaurantmanagement.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.adapter.StaffAdapter;
import com.zyhp.restaurantmanagement.entity.Staff;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/6.
 */

public class StaffSetActivity extends BaseActivity implements View.OnClickListener {
    private TextView view_publictitle_title,activity_staffset_nothing;

    private RelativeLayout view_publictitle_back;
    Activity activity;
    ListView activity_staffset_listview;
    List<Staff> staffList,tempobjects;
    StaffAdapter staffAdapter;
EditText activity_staffset_serachedittext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staffset);
        activity = this;
        findView();
    }

    void findView() {
        view_publictitle_title = (TextView) findViewById(R.id.view_publictitle_title);
        view_publictitle_title.setText("员工管理");
        view_publictitle_back = (RelativeLayout) findViewById(R.id.view_publictitle_back);
        view_publictitle_back.setOnClickListener(this);
        activity_staffset_nothing= (TextView) findViewById(R.id.activity_staffset_nothing);
        activity_staffset_listview = (ListView) findViewById(R.id.activity_staffset_listview);
        staffList = new ArrayList<>();
        //String name, int age, String phone, String email, String address, String department, String position
        Staff staff = null;
        String[] department = {"厨房", "保洁", "收银", "保安"};//部门
        // String [] position;//职位
        List<String[]> position = new ArrayList<>();
        position.add(new String[]{"主厨", "切菜员", "洗菜员", "传菜员"});
        position.add(new String[]{"厨房保洁", "餐厅保洁", "厕所保洁", "厕所保洁"});
        position.add(new String[]{"收银员", "收银助理", "收银助理", "收银助理"});
        position.add(new String[]{"保安队长", "保安员", "保安员", "保安员"});

        for (int i = 0; i < 80; i++) {
            int temp = i % 8;
            if (i < 20) {
                staff = new Staff("201807"+i,"张三" + i, 20 + (i / 3), "1850015068" + temp, "7709678198@163.com", "遵义市朝阳区北苑家园", "厨房", position.get(0)[(int) (Math.random() * 4)]);

            } else if (i < 40) {
                staff = new Staff("201807"+i,"李四" + i, 20 + (i / 3), "1850015068" + temp, "7709678198@163.com", "遵义市朝阳区北苑家园", "保洁", position.get(1)[(int) (Math.random() * 4)]);


            } else if (i < 60) {
                staff = new Staff("201807"+i,"王五" + i, 20 + (i / 3), "1850015068" + temp, "7709678198@163.com", "遵义市朝阳区北苑家园", "收银", position.get(2)[(int) (Math.random() * 4)]);

            } else {
                staff = new Staff("201807"+i,"张六" + i, 20 + (i / 3), "1850015068" + temp, "7709678198@163.com", "遵义市朝阳区北苑家园", "保安", position.get(3)[(int) (Math.random() * 4)]);

            }
            staffList.add(staff);


        }
        staffAdapter = new StaffAdapter(staffList, this);
        activity_staffset_listview.setAdapter(staffAdapter);
    }

    public void setEditTextListener() {
        activity_staffset_serachedittext=(EditText)findViewById(R.id.activity_staffset_serachedittext) ;
        tempobjects=new ArrayList<>();
        activity_staffset_serachedittext.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                tempobjects.clear();
                // TODO Auto-generated method stub
                String contentString = activity_staffset_serachedittext.getText().toString();
                if (contentString.length() > 0) {
                    for (Staff staff : staffList) {

                        if (staff.getDepartment().contains(contentString)
                                || staff.getName().contains(contentString)) {
                            tempobjects.add(staff);
                        }
                    }
                    if (tempobjects.size() > 0) {
                        staffAdapter = new StaffAdapter(tempobjects, activity);
                        activity_staffset_listview.setAdapter(staffAdapter);
                        activity_staffset_nothing.setVisibility(View.GONE);
                    }else {
                        activity_staffset_nothing.setVisibility(View.VISIBLE);

                    }
                } else {
                    activity_staffset_nothing.setVisibility(View.GONE);
                    staffAdapter = new StaffAdapter(staffList, activity);
                    activity_staffset_listview.setAdapter(staffAdapter);
                }

                }



        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.view_publictitle_back:
                finish();
                break;
        }
    }

}
