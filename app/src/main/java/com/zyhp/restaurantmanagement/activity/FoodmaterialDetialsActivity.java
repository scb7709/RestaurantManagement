package com.zyhp.restaurantmanagement.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.adapter.FoodDetialsMaterialAdapter;
import com.zyhp.restaurantmanagement.entity.Food;
import com.zyhp.restaurantmanagement.entity.Foodmaterial;
import com.zyhp.restaurantmanagement.utils.GetString;
import com.zyhp.restaurantmanagement.utils.MyShow;
import com.zyhp.restaurantmanagement.utils.Regular;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/4.
 */

public class FoodmaterialDetialsActivity extends BaseActivity implements View.OnClickListener {

    private TextView view_publictitle_title, activity_foodmateraildetials_name,
            activity_foodmateraildetials_unitPrice, activity_foodmateraildetials_unit,
            activity_foodmateraildetials_stock, activity_foodmateraildetials_unit1,
            activity_foodmateraildetials_purchase_unitPrice, activity_foodmateraildetials_purchase_unit,
            activity_foodmateraildetials_purchase_total;

    private LinearLayout activity_foodmateraildetials_purchase_layout;

    EditText activity_foodmateraildetials_purchase_edit;
    ImageView activity_foodmateraildetials_add, activity_foodmateraildetials_purchase_cancel, activity_foodmateraildetials_purchase_add;
    Button activity_foodmateraildetials_purchase_submit;

    private RelativeLayout view_publictitle_back;
    Foodmaterial foodmaterial;
    int unitPrice;//单价
    int totalPrice;//总价
    int totalStock;//总库存（原来的+新买的）
    Activity activity;
Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodmateraildetials);
        intent=getIntent();
        foodmaterial = (Foodmaterial) intent.getSerializableExtra("foodmaterial");
        unitPrice = (int) (Math.random() * 20 + 1);//随机生成单价
        activity = FoodmaterialDetialsActivity.this;
        findView();
    }

    void findView() {
        view_publictitle_title = (TextView) findViewById(R.id.view_publictitle_title);
        view_publictitle_title.setText("食材详情");
        view_publictitle_back = (RelativeLayout) findViewById(R.id.view_publictitle_back);
        view_publictitle_back.setOnClickListener(this);
        activity_foodmateraildetials_name = (TextView) findViewById(R.id.activity_foodmateraildetials_name);
        activity_foodmateraildetials_unitPrice = (TextView) findViewById(R.id.activity_foodmateraildetials_unitPrice);
        activity_foodmateraildetials_unit = (TextView) findViewById(R.id.activity_foodmateraildetials_unit);
        activity_foodmateraildetials_stock = (TextView) findViewById(R.id.activity_foodmateraildetials_stock);
        activity_foodmateraildetials_unit1 = (TextView) findViewById(R.id.activity_foodmateraildetials_unit1);
        activity_foodmateraildetials_purchase_layout = (LinearLayout) findViewById(R.id.activity_foodmateraildetials_purchase_layout);
        activity_foodmateraildetials_unitPrice.setText(unitPrice + "");
        activity_foodmateraildetials_name.setText(foodmaterial.getFoodmaterial_name());
        activity_foodmateraildetials_unit.setText("元/" + foodmaterial.getFoodmaterial_unit() + "");
        activity_foodmateraildetials_stock.setText(foodmaterial.getFoodmaterial_stock() + "");
        totalStock=Integer.parseInt(foodmaterial.getFoodmaterial_stock());
        activity_foodmateraildetials_unit1.setText(foodmaterial.getFoodmaterial_unit() + "");
        activity_foodmateraildetials_purchase_cancel = (ImageView) findViewById(R.id.activity_foodmateraildetials_purchase_cancel);
        activity_foodmateraildetials_purchase_edit = (EditText) findViewById(R.id.activity_foodmateraildetials_purchase_edit);

        activity_foodmateraildetials_purchase_add = (ImageView) findViewById(R.id.activity_foodmateraildetials_purchase_add);
        activity_foodmateraildetials_add = (ImageView) findViewById(R.id.activity_foodmateraildetials_add);
        activity_foodmateraildetials_purchase_unitPrice = (TextView) findViewById(R.id.activity_foodmateraildetials_purchase_unitPrice);
        activity_foodmateraildetials_purchase_unit = (TextView) findViewById(R.id.activity_foodmateraildetials_purchase_unit);
        activity_foodmateraildetials_purchase_total = (TextView) findViewById(R.id.activity_foodmateraildetials_purchase_total);
        activity_foodmateraildetials_purchase_submit = (Button) findViewById(R.id.activity_foodmateraildetials_purchase_submit);
        activity_foodmateraildetials_purchase_unitPrice.setText(unitPrice + "");
        activity_foodmateraildetials_purchase_unit.setText("元/" + foodmaterial.getFoodmaterial_unit() + "");

        activity_foodmateraildetials_purchase_add.setOnClickListener(this);
        activity_foodmateraildetials_add.setOnClickListener(this);
        activity_foodmateraildetials_purchase_submit.setOnClickListener(this);
        activity_foodmateraildetials_purchase_cancel.setOnClickListener(this);
        activity_foodmateraildetials_purchase_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                String number = activity_foodmateraildetials_purchase_edit.getText().toString();
                if (number.length() > 0) {
                    if (!Regular.isPositiveInteger(number)) {
                        MyShow.myToash(activity, "输入购买数量不合法");
                    } else {
                        totalPrice = Integer.parseInt(number) * unitPrice + 5;
                        activity_foodmateraildetials_purchase_total.setText(totalPrice + "");
                        Log.i("totalPrice", totalPrice + "  " + unitPrice);
                    }
                } else {
                    activity_foodmateraildetials_purchase_total.setText("0");
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

            case R.id.activity_foodmateraildetials_add:
                activity_foodmateraildetials_purchase_layout.setVisibility(View.VISIBLE);
                break;
            case R.id.activity_foodmateraildetials_purchase_add:
                String number = activity_foodmateraildetials_purchase_edit.getText().toString();
                if (number.length() > 0) {
                    if (!Regular.isPositiveInteger(number)) {
                        //activity_foodmateraildetials_purchase_edit.setText("1");
                        MyShow.myToash(activity, "输入购买数量不合法");
                    } else {
                        activity_foodmateraildetials_purchase_edit.setText((Integer.parseInt(number) + 1) + "");
                        totalPrice = (Integer.parseInt(number) + 1) * unitPrice + 5;
                        Log.i("totalPrice", totalPrice + "  " + unitPrice);
                        activity_foodmateraildetials_purchase_total.setText(totalPrice + "");
                    }
                } else {
                    activity_foodmateraildetials_purchase_edit.setText("1");
                    totalPrice = unitPrice + 5;
                    activity_foodmateraildetials_purchase_total.setText(totalPrice + "");
                }


                break;
            case R.id.activity_foodmateraildetials_purchase_cancel:
                cancleAdd();
                break;
            case R.id.activity_foodmateraildetials_purchase_submit:
                String number2 = activity_foodmateraildetials_purchase_edit.getText().toString();
                if (number2.length() > 0) {
                    if (!Regular.isPositiveInteger(number2)) {
                        MyShow.myToash(activity, "输入购买数量不合法");
                    } else {
                        totalPrice = Integer.parseInt(number2) * unitPrice+5;
                        totalStock=Integer.parseInt(number2)+totalStock;
                        startActivityForResult(new Intent(activity, CompletePayActivity.class).putExtra("totalPrice", totalPrice + "").putExtra("name", foodmaterial.getFoodmaterial_name() + ""), 0);
                        cancleAdd();
                    }
                } else {
                    MyShow.myToash(activity, "请输入购买数量");
                }
                break;
        }
    }

    private void cancleAdd() {
        activity_foodmateraildetials_purchase_edit.setText("");
        activity_foodmateraildetials_purchase_layout.setVisibility(View.GONE);
        activity_foodmateraildetials_purchase_total.setText("0");
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==resultCode&&requestCode==0){
            activity_foodmateraildetials_stock.setText(totalStock+ "");
            Intent intent = new Intent();
            intent.putExtra("totalStock",""+totalStock);
            setResult(0, intent);

        }
    }
}
