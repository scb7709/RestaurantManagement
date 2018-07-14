package com.zyhp.restaurantmanagement.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.adapter.FoodAdapter;
import com.zyhp.restaurantmanagement.adapter.FoodClassifyAdapter;
import com.zyhp.restaurantmanagement.adapter.FoodmaterialAdapter;
import com.zyhp.restaurantmanagement.adapter.FoodmaterialClassifyAdapter;
import com.zyhp.restaurantmanagement.entity.Food;
import com.zyhp.restaurantmanagement.entity.FoodClassify;
import com.zyhp.restaurantmanagement.entity.Foodmaterial;
import com.zyhp.restaurantmanagement.entity.FoodmaterialClassify;
import com.zyhp.restaurantmanagement.utils.GetOrderList;
import com.zyhp.restaurantmanagement.utils.ImageUtil;
import com.zyhp.restaurantmanagement.utils.MyShow;
import com.zyhp.restaurantmanagement.utils.NumberValidationUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/6.
 */

public class FoodmatearialSetActivity extends BaseActivity implements View.OnClickListener {

    private TextView view_publictitle_title;

    private RelativeLayout view_publictitle_back;


    ListView activity_foodmaterial_classify, activity_foodmaterial_foodmaterial;




    TextView activity_foodmaterial_classifyname, activity_foodmaterial_nothing;




    ImageView activity_foodmaterial_add;


    FoodmaterialAdapter foodmaterialAdapter;
    List<FoodmaterialClassify> classifylist;
    List<String> spinnerlist;
    List<Object> foodmaterialList;
    List<Object> tempfoodmateriallist;
    LayoutInflater layoutInflater;
    FoodmaterialClassifyAdapter foodmaterialClassifyAdapter;
    private PopupWindow popupWindow;

    Activity activity;

    String classfly []=new String[]{"调料","蔬菜","水果","肉类","海鲜","牛奶乳品","速冻","粮油",};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodmaterailsset);
        activity = FoodmatearialSetActivity.this;
        findView();
        setListView();
    }

    void findView() {
        view_publictitle_title = (TextView) findViewById(R.id.view_publictitle_title);
        view_publictitle_title.setText("食材管理");
        view_publictitle_back = (RelativeLayout) findViewById(R.id.view_publictitle_back);
        view_publictitle_back.setOnClickListener(this);

        layoutInflater = LayoutInflater.from(activity);
        activity_foodmaterial_classify = (ListView) findViewById(R.id.activity_foodmaterial_classify);
        activity_foodmaterial_foodmaterial = (ListView) findViewById(R.id.activity_foodmaterial_foodmaterial);
        activity_foodmaterial_classifyname = (TextView) findViewById(R.id.activity_foodmaterial_classifyname);
        activity_foodmaterial_nothing = (TextView) findViewById(R.id.activity_foodmaterial_nothing);
        activity_foodmaterial_add = (ImageView) findViewById(R.id.activity_foodmaterial_add);

        activity_foodmaterial_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPop(view, true);
            }
        });
    /*    findViewById(R.id.activity_headtitle_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, SearchActivity.class);

                intent.putExtra("flag", "foodmaterial");
                intent.putExtra("data", (Serializable) foodmaterialList);
                startActivity(intent);

            }
        });*/

    }


    //添加  flag为true 表示添加菜品 false 添加分类
    EditText dialog_addfoodmaterial_foodmaterialname, dialog_addfoodmaterial_foodmaterialunit;

    private void addPop(View v, final boolean flag) {
        View view = LayoutInflater.from(activity).inflate(R.layout.dialog_addfood, null);
        if (flag) {
            popupWindow = new PopupWindow(view, ImageUtil.dp2px(activity, 300), ImageUtil.dp2px(activity, 310), true);

        } else {
            popupWindow = new PopupWindow(view, ImageUtil.dp2px(activity, 300), ImageUtil.dp2px(activity, 230), true);

        }


        Button cancle = (Button) view.findViewById(R.id.dialog_addfood_cancle);
        Button ok = (Button) view.findViewById(R.id.dialog_addfood_ok);
        TextView dialog_addfood_title = (TextView) view.findViewById(R.id.dialog_addfood_title);
        dialog_addfoodmaterial_foodmaterialname = (EditText) view.findViewById(R.id.dialog_addfood_foodname);
        dialog_addfoodmaterial_foodmaterialunit = (EditText) view.findViewById(R.id.dialog_addfood_foodmoney);

        LinearLayout dialog_addmaterialfood_spinnerlayout = (LinearLayout) view.findViewById(R.id.dialog_addfood_spinnerlayout);

        final Spinner dialog_addfood_spinner = (Spinner) view.findViewById(R.id.dialog_addfood_spinner);
        if (!flag) {
            dialog_addfood_title.setText("添加食材分类");
            dialog_addfoodmaterial_foodmaterialname.setHint("输入食材分类名称");
            dialog_addmaterialfood_spinnerlayout.setVisibility(View.GONE);
            dialog_addfoodmaterial_foodmaterialunit.setVisibility(View.GONE);

        } else {
            dialog_addfood_title.setText("添加食材");
            dialog_addfoodmaterial_foodmaterialname.setHint("输入食材名称");
            dialog_addmaterialfood_spinnerlayout.setVisibility(View.VISIBLE);
            dialog_addfoodmaterial_foodmaterialunit.setVisibility(View.VISIBLE);
            dialog_addfoodmaterial_foodmaterialunit.setHint("请输入食材单位");
            ArrayAdapter adapter = new ArrayAdapter<>(activity, android.R.layout.simple_spinner_item, spinnerlist);
            //为适配器设置下拉列表下拉时的菜单样式。
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //默认选中
            dialog_addfood_spinner.setSelection(current_classify_possition, true);
            //将适配器添加到下拉列表上
            dialog_addfood_spinner.setAdapter(adapter);

        }


        cancle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name = dialog_addfoodmaterial_foodmaterialname.getText().toString();
                if (name.length() > 0) {
                    if (!flag) {

                        int size = classifylist.size();
                        classifylist.add(new FoodmaterialClassify(size, name));
                        spinnerlist.add(name);
                        foodmaterialClassifyAdapter = new FoodmaterialClassifyAdapter(classifylist, layoutInflater);
                        activity_foodmaterial_classify.setAdapter(foodmaterialClassifyAdapter);

                    } else {
                        String unit = dialog_addfoodmaterial_foodmaterialunit.getText().toString();
                        if (unit.length() > 0) {
                            int spinnerchoiseposition = dialog_addfood_spinner.getSelectedItemPosition();
                            Foodmaterial foodmaterial = new Foodmaterial(spinnerchoiseposition, name, "0", unit );


                            foodmaterialList.add(foodmaterial);
                            if (tempfoodmateriallist.size() > 0) {
                                Foodmaterial foodmaterial1 = (Foodmaterial) tempfoodmateriallist.get(0);
                                if (foodmaterial1.getFoodmaterialclasdify_id()== spinnerchoiseposition) {//说明添加的是正在显示的
                                    tempfoodmateriallist.add(foodmaterial);
                                    foodmaterialAdapter.notifyDataSetChanged();
                                }
                            }

                        } else MyShow.myToash(activity, "单位不能为空");


                    }


                } else {

                    MyShow.myToash(activity, "名称不能为空");
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

    private void setListView() {
        tempfoodmateriallist = new ArrayList<>();
        classifylist = new ArrayList<>();
        spinnerlist = new ArrayList<>();
        for(int i=0;i<classfly.length;i++){
            String str=classfly[i];
            spinnerlist.add("str");
            classifylist.add(new FoodmaterialClassify(i, str));
        }





        foodmaterialList = GetOrderList.getFoodmaterialList();
        foodmaterialClassifyAdapter = new FoodmaterialClassifyAdapter(classifylist, layoutInflater);
        activity_foodmaterial_classify.setAdapter(foodmaterialClassifyAdapter);


        tempfoodmateriallist.add(new Foodmaterial(0,"盐","30","袋"));
        tempfoodmateriallist.add(new Foodmaterial(0,"味精","20","袋"));
        tempfoodmateriallist.add(new Foodmaterial(0,"鸡精","10","袋"));
        tempfoodmateriallist.add(new Foodmaterial(0,"酱油","10","瓶"));
        tempfoodmateriallist.add(new Foodmaterial(0,"醋","10","瓶"));
        tempfoodmateriallist.add(new Foodmaterial(0,"白糖","30","袋"));
        tempfoodmateriallist.add(new Foodmaterial(0,"冰糖","5","斤"));
        tempfoodmateriallist.add(new Foodmaterial(0,"蜂蜜","10","罐"));
        tempfoodmateriallist.add(new Foodmaterial(0,"花椒","30","克"));
        tempfoodmateriallist.add(new Foodmaterial(0,"胡椒","30","克"));


        foodmaterialAdapter = new FoodmaterialAdapter(tempfoodmateriallist, layoutInflater);
        activity_foodmaterial_foodmaterial.setAdapter(foodmaterialAdapter);


        setListViewListener();


    }

    int current_classify_possition;//当前选中的分类
    int choice_foodmaterial_possition;//选中的食材位置

    private void setListViewListener() {
        activity_foodmaterial_classify.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                current_classify_possition = i;

                if (i < classifylist.size()) {
                    tempfoodmateriallist.clear();
                    foodmaterialClassifyAdapter.changeSelected(i);//刷新
                    FoodmaterialClassify foodClassify = classifylist.get(i);
                    activity_foodmaterial_classifyname.setText(foodClassify.getFoodclassify_name());
                    for (Object object : foodmaterialList) {
                        Foodmaterial foodmaterial = (Foodmaterial) object;
                        if (foodmaterial.getFoodmaterialclasdify_id() == foodClassify.getFoodclassify_id()) {
                            tempfoodmateriallist.add(foodmaterial);
                        }
                    }
                    if (tempfoodmateriallist.size() > 0) {
                        activity_foodmaterial_foodmaterial.setVisibility(View.VISIBLE);
                        activity_foodmaterial_nothing.setVisibility(View.GONE);
                        foodmaterialAdapter = new FoodmaterialAdapter(tempfoodmateriallist, layoutInflater);
                        activity_foodmaterial_foodmaterial.setAdapter(foodmaterialAdapter);
                    } else {
                        activity_foodmaterial_foodmaterial.setVisibility(View.GONE);
                        activity_foodmaterial_nothing.setVisibility(View.VISIBLE);

                    }

                } else {
                    addPop(view, false);

                }

            }
        });

        activity_foodmaterial_foodmaterial.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                choice_foodmaterial_possition=i;//查看了第I的食材的详情
                Intent intent = new Intent();
                intent.setClass(activity, FoodmaterialDetialsActivity.class);
                intent.putExtra("foodmaterial", (Foodmaterial) (tempfoodmateriallist.get(i)));
                startActivityForResult(intent,0);

            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("requestCode",requestCode+" "+resultCode+(data==null));
        if(requestCode==resultCode&&requestCode==0&&data!=null){
            Log.i("requestCode",requestCode+" "+resultCode);
            String  totalStock=data.getStringExtra("totalStock");
            ((Foodmaterial) (tempfoodmateriallist.get(choice_foodmaterial_possition))).setFoodmaterial_stock(totalStock);
            foodmaterialAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.view_publictitle_back:
                finish();
                break;
            case 0:

                break;

        }
    }
}
