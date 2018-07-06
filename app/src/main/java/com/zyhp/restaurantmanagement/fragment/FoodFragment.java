package com.zyhp.restaurantmanagement.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/6/22.
 */
import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.activity.FoodDetialsActivity;
import com.zyhp.restaurantmanagement.activity.SearchActivity;
import com.zyhp.restaurantmanagement.adapter.FoodAdapter;
import com.zyhp.restaurantmanagement.adapter.FoodClassifyAdapter;
import com.zyhp.restaurantmanagement.entity.Food;
import com.zyhp.restaurantmanagement.entity.FoodClassify;
import com.zyhp.restaurantmanagement.utils.GetOrderList;
import com.zyhp.restaurantmanagement.utils.ImageUtil;
import com.zyhp.restaurantmanagement.utils.MyShow;
import com.zyhp.restaurantmanagement.utils.NumberValidationUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FoodFragment extends Fragment {

    ListView fragment_food_classify, fragment_food_food;


    TextView fragment_food_classifyname, fragment_food_nothing;


    ImageView fragment_food_add;

    FoodAdapter foodAdapter;
    List<FoodClassify> classifylist;
    List<String> spinnerlist;
    List<Object> foodList;
    List<Object> tempfoodlist;
    LayoutInflater layoutInflater;
    FoodClassifyAdapter classifyAdapter;
    private PopupWindow popupWindow;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findView(view);
        setListView();
    }

    private void setListView() {
        tempfoodlist = new ArrayList<>();
        classifylist = new ArrayList<>();
        spinnerlist = new ArrayList<>();
        spinnerlist.add("主食");
        spinnerlist.add("炒菜");
        spinnerlist.add("汤菜");
        spinnerlist.add("火锅");
        spinnerlist.add("烤鱼");

        spinnerlist.add("特色");
        spinnerlist.add("热销");
        spinnerlist.add("优惠");
        spinnerlist.add("饮品");



        classifylist.add(new FoodClassify(0, "主食"));
        classifylist.add(new FoodClassify(1, "炒菜"));
        classifylist.add(new FoodClassify(2, "汤菜"));
        classifylist.add(new FoodClassify(3, "火锅"));
        classifylist.add(new FoodClassify(4, "烤鱼"));
        classifylist.add(new FoodClassify(5, "特色"));
        classifylist.add(new FoodClassify(6, "热销"));
        classifylist.add(new FoodClassify(7, "优惠"));
        classifylist.add(new FoodClassify(8, "饮品"));

        foodList = GetOrderList.getOrderList();

       /*
        for(int i=0;i<100;i++){
            int temp=i%6;
            Food food;
            switch (temp){
                case 0 :
                    food=new Food(temp,"主食"+i, GetString.createRandom(true,2));
                    break;
                case 1 :

                    break;
                case 2 :

                    break;
                case 3 :

                    break;
                case 4 :

                    break;

            }

        }*/

        // fragment_foodmaterial_classify.addFooterView(footView);//添加尾部
        //fragment_foodmaterial_classify.setSelector(R.color.redlow);
        classifyAdapter = new FoodClassifyAdapter(classifylist, layoutInflater);
        fragment_food_classify.setAdapter(classifyAdapter);


        tempfoodlist.add(new Food(0, "米饭", "5"));
        tempfoodlist.add(new Food(0, "馒头", "5"));
        tempfoodlist.add(new Food(0, "包子", "5"));
        tempfoodlist.add(new Food(0, "面条", "6"));
        tempfoodlist.add(new Food(0, "拉面", "7"));
        tempfoodlist.add(new Food(0, "刀削面", "10"));
        tempfoodlist.add(new Food(0, "意大利面", "10"));
        tempfoodlist.add(new Food(0, "西班牙打卤面", "10"));
        tempfoodlist.add(new Food(0, "炸酱面", "10"));


        foodAdapter = new FoodAdapter(tempfoodlist, layoutInflater);
        fragment_food_food.setAdapter(foodAdapter);


        setListViewListener();


    }

    int current_classify_possition;//当前选中的分类

    private void setListViewListener() {
        fragment_food_classify.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                current_classify_possition = i;

                if (i < classifylist.size()) {
                    tempfoodlist.clear();
                    classifyAdapter.changeSelected(i);//刷新
                    FoodClassify foodClassify = classifylist.get(i);
                    fragment_food_classifyname.setText(foodClassify.getFoodclassify_name());
                    for (Object object : foodList) {
                        Food food = (Food) object;
                        if (food.getFood_classifyId() == foodClassify.getFoodclassify_id()) {
                            tempfoodlist.add(food);
                        }
                    }
                    if (tempfoodlist.size() > 0) {
                        fragment_food_food.setVisibility(View.VISIBLE);
                        fragment_food_nothing.setVisibility(View.GONE);
                        foodAdapter = new FoodAdapter(tempfoodlist, layoutInflater);
                        fragment_food_food.setAdapter(foodAdapter);
                    } else {
                        fragment_food_food.setVisibility(View.GONE);
                        fragment_food_nothing.setVisibility(View.VISIBLE);

                    }

                } else {
                    addPop(view, false);

                }

            }
        });

        fragment_food_food.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), FoodDetialsActivity.class);

                intent.putExtra("food", (Food) (tempfoodlist.get(i)));
                startActivity(intent);

            }
        });


    }

    private void findView(View view) {
        layoutInflater = LayoutInflater.from(getActivity());
        fragment_food_classify = (ListView) view.findViewById(R.id.fragment_food_classify);
        fragment_food_food = (ListView) view.findViewById(R.id.fragment_food_food);
        fragment_food_classifyname = (TextView) view.findViewById(R.id.fragment_food_classifyname);
        fragment_food_nothing = (TextView) view.findViewById(R.id.fragment_food_nothing);
        fragment_food_add = (ImageView) view.findViewById(R.id.fragment_food_add);

        fragment_food_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPop(view, true);
            }
        });
        getActivity().findViewById(R.id.activity_headtitle_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);

                intent.putExtra("flag", "food");
                intent.putExtra("data", (Serializable) foodList);
                startActivity(intent);

            }
        });

    }

    //添加  flag为true 表示添加菜品 false 添加分类
    EditText dialog_addfood_foodname, dialog_addfood_foodmoney;

    private void addPop(View v, final boolean flag) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_addfood, null);
        if (flag) {
            popupWindow = new PopupWindow(view, ImageUtil.dp2px(getActivity(), 300), ImageUtil.dp2px(getActivity(), 310), true);

        } else {
            popupWindow = new PopupWindow(view, ImageUtil.dp2px(getActivity(), 300), ImageUtil.dp2px(getActivity(), 230), true);

        }


        Button cancle = (Button) view.findViewById(R.id.dialog_addfood_cancle);
        Button ok = (Button) view.findViewById(R.id.dialog_addfood_ok);
        TextView dialog_addfood_title = (TextView) view.findViewById(R.id.dialog_addfood_title);
        dialog_addfood_foodname = (EditText) view.findViewById(R.id.dialog_addfood_foodname);
        dialog_addfood_foodmoney = (EditText) view.findViewById(R.id.dialog_addfood_foodmoney);
        LinearLayout dialog_addfood_spinnerlayout = (LinearLayout) view.findViewById(R.id.dialog_addfood_spinnerlayout);

        final Spinner dialog_addfood_spinner = (Spinner) view.findViewById(R.id.dialog_addfood_spinner);
        if (!flag) {
            dialog_addfood_title.setText("添加菜品分类");
            dialog_addfood_foodname.setHint("输入菜品分类名称");
            dialog_addfood_spinnerlayout.setVisibility(View.GONE);
            dialog_addfood_foodmoney.setVisibility(View.GONE);
        } else {
            dialog_addfood_title.setText("添加菜品");
            dialog_addfood_foodname.setHint("输入菜品名称");
            dialog_addfood_spinnerlayout.setVisibility(View.VISIBLE);
            dialog_addfood_foodmoney.setVisibility(View.VISIBLE);

            ArrayAdapter adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, spinnerlist);
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
                String name = dialog_addfood_foodname.getText().toString();
                if (name.length() > 0) {
                    if (!flag) {

                        int size = classifylist.size();
                        classifylist.add(new FoodClassify(size, name));
                        spinnerlist.add(name);
                        classifyAdapter = new FoodClassifyAdapter(classifylist, layoutInflater);
                        fragment_food_classify.setAdapter(classifyAdapter);

                    } else {

                        String foodmoney = dialog_addfood_foodmoney.getText().toString();
                        if (foodmoney.length() > 0) {
                            if (NumberValidationUtils.isRealNumber(foodmoney)) {
                                int spinnerchoiseposition = dialog_addfood_spinner.getSelectedItemPosition();
                                Food addfood = new Food(spinnerchoiseposition, name, foodmoney);
                                foodList.add(addfood);
                                if (tempfoodlist.size() > 0) {

                                    Food food = (Food) tempfoodlist.get(0);
                                    if (food.getFood_classifyId() == spinnerchoiseposition) {//说明添加的是正在显示的
                                        tempfoodlist.add(addfood);
                                        foodAdapter.notifyDataSetChanged();
                                    }
                                }

                            } else {
                                MyShow.myToash(getActivity(), "价格输入错误");
                            }
                        } else {
                            MyShow.myToash(getActivity(), "价格不能为空");
                        }

                    }

                    popupWindow.dismiss();
                } else {

                    MyShow.myToash(getActivity(), "名称不能为空");
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
}
