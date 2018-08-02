package com.zyhp.restaurantmanagement.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.adapter.StaffAdapter;
import com.zyhp.restaurantmanagement.entity.Foodmaterial;
import com.zyhp.restaurantmanagement.entity.Income;
import com.zyhp.restaurantmanagement.entity.Staff;
import com.zyhp.restaurantmanagement.utils.GetDialog;
import com.zyhp.restaurantmanagement.utils.GetString;
import com.zyhp.restaurantmanagement.utils.MyShow;
import com.zyhp.restaurantmanagement.utils.Regular;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2018/7/6.
 */

public class StaffSetActivity extends BaseActivity implements View.OnClickListener {
    private TextView view_publictitle_title, activity_staffset_nothing;

    private RelativeLayout view_publictitle_back, view_publictitle_right;
    private Button view_publictitle_righticon, activity_staffset_addstaff_commit;
    Activity activity;
    ListView activity_staffset_listview;
    List<Staff> staffList, tempobjects;
    StaffAdapter staffAdapter;
    EditText activity_staffset_serachedittext;
    LinearLayout activity_staffset_layout;
    TextView activity_staffset_addstaff_birthday;
    EditText activity_staffset_addstaff_name, activity_staffset_addstaff_phone, activity_staffset_addstaff_email, activity_staffset_addstaff_address,
            activity_staffset_addstaff_department, activity_staffset_addstaff_position;
    Staff ONLICK_POSITION;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            ONLICK_POSITION = (Staff) msg.obj;
        }
    };

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
        view_publictitle_right = (RelativeLayout) findViewById(R.id.view_publictitle_right);
        view_publictitle_right.setOnClickListener(this);
        view_publictitle_right.setBackgroundResource(R.drawable.staff_add_shape);
        view_publictitle_right.setVisibility(View.VISIBLE);
        view_publictitle_righticon = (Button) findViewById(R.id.view_publictitle_righticon);
        view_publictitle_righticon.setBackgroundResource(R.mipmap.pic_add);
        activity_staffset_nothing = (TextView) findViewById(R.id.activity_staffset_nothing);
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
                staff = new Staff("201807" + i, "张六" + i, "1988-01-02", "1850015068" + temp, "7709678198@163.com", "遵义市朝阳区北苑家园", "保安", position.get(3)[(int) (Math.random() * 4)]);


            } else if (i < 40) {
                staff = new Staff("201807" + i, "李四" + i, "1988-01-02", "1850015068" + temp, "7709678198@163.com", "遵义市朝阳区北苑家园", "保洁", position.get(1)[(int) (Math.random() * 4)]);


            } else if (i < 60) {
                staff = new Staff("201807" + i, "张三" + i, "1988-01-02", "1850015068" + temp, "7709678198@163.com", "遵义市朝阳区北苑家园", "厨房", position.get(0)[(int) (Math.random() * 4)]);


            } else {
                staff = new Staff("201807" + i, "王五" + i, "1988-01-02", "1850015068" + temp, "7709678198@163.com", "遵义市朝阳区北苑家园", "收银", position.get(2)[(int) (Math.random() * 4)]);

            }
            staffList.add(staff);


        }
        staffAdapter = new StaffAdapter(staffList, this, handler);
        activity_staffset_listview.setAdapter(staffAdapter);
        setEditTextListener();

        activity_staffset_layout = (LinearLayout) findViewById(R.id.activity_staffset_layout);
        activity_staffset_addstaff_commit = (Button) findViewById(R.id.activity_staffset_addstaff_commit);
        activity_staffset_addstaff_commit.setOnClickListener(this);
        activity_staffset_addstaff_birthday = (TextView) findViewById(R.id.activity_staffset_addstaff_birthday);
        activity_staffset_addstaff_birthday.setOnClickListener(this);

        activity_staffset_addstaff_name = (EditText) findViewById(R.id.activity_staffset_addstaff_name);
        activity_staffset_addstaff_phone = (EditText) findViewById(R.id.activity_staffset_addstaff_phone);
        activity_staffset_addstaff_email = (EditText) findViewById(R.id.activity_staffset_addstaff_email);
        activity_staffset_addstaff_address = (EditText) findViewById(R.id.activity_staffset_addstaff_address);
        activity_staffset_addstaff_department = (EditText) findViewById(R.id.activity_staffset_addstaff_department);
        activity_staffset_addstaff_position = (EditText) findViewById(R.id.activity_staffset_addstaff_position);


    }

    public void setEditTextListener() {
        activity_staffset_serachedittext = (EditText) findViewById(R.id.activity_staffset_serachedittext);
        tempobjects = new ArrayList<>();
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
                        staffAdapter = new StaffAdapter(tempobjects, activity, handler);
                        activity_staffset_listview.setAdapter(staffAdapter);
                        activity_staffset_nothing.setVisibility(View.GONE);
                    } else {
                        activity_staffset_nothing.setVisibility(View.VISIBLE);

                    }
                } else {
                    activity_staffset_nothing.setVisibility(View.GONE);
                    staffAdapter = new StaffAdapter(staffList, activity, handler);
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
            case R.id.view_publictitle_right:
                if(activity_staffset_layout.getVisibility()==View.VISIBLE){
                    activity_staffset_layout.setVisibility(View.GONE);
                    view_publictitle_righticon.setBackgroundResource(R.mipmap.icon_close);
                }else if (activity_staffset_layout.getVisibility()==View.GONE) {
                    activity_staffset_layout.setVisibility(View.VISIBLE);
                    view_publictitle_righticon.setBackgroundResource(R.mipmap.pic_add);
                }
                break;

            case R.id.activity_staffset_addstaff_birthday:
                GetDialog.getTimeDialog(activity, "1930-01-01 00:00:00", Calendar.getInstance(), new GetDialog.GetTimeDialogInterface() {
                    @Override
                    public void getTimeDialogInterface(int year, int monthOfYear, int dayOfMonth) {
                        activity_staffset_addstaff_birthday.setText(year + "-" + monthOfYear + "-" + dayOfMonth);
                    }
                });
                break;
            case R.id.activity_staffset_addstaff_commit:
                String name = activity_staffset_addstaff_name.getText().toString();
                if (name.length() <= 0) {
                    MyShow.myToash(activity, "名称不能为空");
                    break;
                }
                String birthday = activity_staffset_addstaff_birthday.getText().toString();
                if (birthday.length() <= 0) {
                    MyShow.myToash(activity, "请选择出生日期");
                    break;
                }
                String phone = activity_staffset_addstaff_phone.getText().toString();
                if (phone.length() <= 0) {
                    MyShow.myToash(activity, "电话不能为空");
                    break;
                }
                if (!Regular.isMobile(phone)) {
                    MyShow.myToash(activity, "电话号码格式不对");
                    break;
                }
                String email = activity_staffset_addstaff_email.getText().toString();
                if (email.length() <= 0) {
                    MyShow.myToash(activity, "邮件不能为空");
                    break;
                }
                if (!Regular.isEmail(email)) {
                    MyShow.myToash(activity, "邮箱地址格式不对");
                    break;
                }
                String address = activity_staffset_addstaff_address.getText().toString();
                if (address.length() <= 0) {
                    MyShow.myToash(activity, "住址不能为空");
                    break;
                }
                String department = activity_staffset_addstaff_department.getText().toString();
                if (department.length() <= 0) {
                    MyShow.myToash(activity, "部门不能为空");
                    break;
                }
                String position = activity_staffset_addstaff_position.getText().toString();
                if (position.length() <= 0) {
                    MyShow.myToash(activity, "职位不能为空");
                    break;
                }

                Staff staff = new Staff("201807" + staffList.size(), name, birthday, phone, email, address, department, position);
                staffList.add(staff);
                Collections.sort(staffList, new Comparator<Staff>() {
                    @Override
                    public int compare(Staff staff, Staff t1) {
                        int Department = staff.getDepartment().compareTo(t1.getDepartment());
                        if(Department!=0){
                            return Department;//按照部门重新排序

                        }else {
                            return staff.getName().compareTo(t1.getName());//部门相同的情况下 按名字在排序

                        }
                    }
                });
                 staffAdapter = new StaffAdapter(staffList, this,handler);
                activity_staffset_listview.setAdapter(staffAdapter);

                activity_staffset_layout.setVisibility(View.VISIBLE);
                view_publictitle_righticon.setBackgroundResource(R.mipmap.pic_add);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("requestCode", requestCode + " " + resultCode + (data == null));
        if (requestCode == resultCode && requestCode == 0 && data != null) {
            activity_staffset_serachedittext.setText("");
            staffList.remove(ONLICK_POSITION);
            MyShow.myToash(activity, "删除成功");
            staffAdapter = new StaffAdapter(staffList, this, handler);
            activity_staffset_listview.setAdapter(staffAdapter);
        }
    }
}
