package com.zyhp.restaurantmanagement.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.myview.CircleImageView;
import com.zyhp.restaurantmanagement.utils.DiskBitmap;
import com.zyhp.restaurantmanagement.utils.GetChoiceDialog;
import com.zyhp.restaurantmanagement.utils.GetDialog;
import com.zyhp.restaurantmanagement.utils.MyShow;
import com.zyhp.restaurantmanagement.utils.Regular;
import com.zyhp.restaurantmanagement.utils.ShareUitls;

/**
 * Created by Administrator on 2018/7/6.
 */

public class StoreSetActivity extends BaseActivity implements View.OnClickListener {

    private TextView view_publictitle_title;

    private RelativeLayout view_publictitle_back;

    CircleImageView activity_storeset_logo;
    TextView activity_storeset_storename, activity_storeset_address,
            activity_storeset_email, activity_storeset_phone,
            activity_storeset_QQ;
    LinearLayout activity_accountset_takeout_layout, activity_accountset_takeout_1, activity_accountset_takeout_2;
    Activity activity;
    CheckBox checkBoxs[];//存放外卖平台的数组

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storeset);
        activity = this;
        findView();
    }

    void findView() {
        view_publictitle_title = (TextView) findViewById(R.id.view_publictitle_title);
        view_publictitle_title.setText("店铺设置");
        view_publictitle_back = (RelativeLayout) findViewById(R.id.view_publictitle_back);
        view_publictitle_back.setOnClickListener(this);

        activity_storeset_logo = (CircleImageView) findViewById(R.id.activity_storeset_logo);
        String storelogo_url = ShareUitls.getString(activity, "storelogo_url", "");
        if (storelogo_url != null && storelogo_url.length() > 0) {
            activity_storeset_logo.setImageBitmap(DiskBitmap.getDiskBitmap(storelogo_url, activity));
        } else {
            activity_storeset_logo.setImageResource(R.mipmap.reba);
        }


        activity_storeset_storename = (TextView) findViewById(R.id.activity_storeset_storename);
        activity_storeset_address = (TextView) findViewById(R.id.activity_storeset_address);
        activity_storeset_email = (TextView) findViewById(R.id.activity_storeset_email);
        activity_storeset_phone = (TextView) findViewById(R.id.activity_storeset_phone);
        activity_storeset_QQ = (TextView) findViewById(R.id.activity_storeset_QQ);
        activity_accountset_takeout_layout = (LinearLayout) findViewById(R.id.activity_accountset_takeout_layout);
        activity_accountset_takeout_1 = (LinearLayout) findViewById(R.id.activity_accountset_takeout_1);
        activity_accountset_takeout_2 = (LinearLayout) findViewById(R.id.activity_accountset_takeout_2);

        findViewById(R.id.view_publictitle_back).setOnClickListener(this);
        activity_storeset_logo.setOnClickListener(this);
        findViewById(R.id.activity_storeset_storename_layout).setOnClickListener(this);
        findViewById(R.id.activity_storeset_address_layout).setOnClickListener(this);
        findViewById(R.id.activity_storeset_phone_layout).setOnClickListener(this);
        findViewById(R.id.activity_storeset_emali_layout).setOnClickListener(this);
        findViewById(R.id.activity_storeset_QQ_layout).setOnClickListener(this);
        activity_accountset_takeout_layout.setOnClickListener(this);
        checkBoxs = new CheckBox[4];
        checkBoxs[0] = (CheckBox) findViewById(R.id.activity_accountset_takeout_meituan);
        checkBoxs[1] = (CheckBox) findViewById(R.id.activity_accountset_takeout_baidu);
        checkBoxs[2] = (CheckBox) findViewById(R.id.activity_accountset_takeout_koubei);
        checkBoxs[3] = (CheckBox) findViewById(R.id.activity_accountset_takeout_elema);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.view_publictitle_back:
                finish();
                break;


            case R.id.activity_storeset_logo:
                //   Log.i("activit", "vactivity_accountset_headimage");
                GetChoiceDialog.getChoiceDialog(this, "店铺logo更换", new String[]{"相册选图", "打开相机"}, new GetChoiceDialog.GetChoiceDialogInterface() {
                    @Override
                    public void onClick(int which) {
                        if (which == 0) {
                            Intent intent = new Intent(Intent.ACTION_PICK);
                            intent.setType("image/*");
                            startActivityForResult(intent, 0);
                        } else {
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(intent, 1);
                        }

                    }
                });
                break;
            case R.id.activity_storeset_storename_layout:
                GetDialog.getEditTextDialog(activity, view, "更改店铺名称", "请输入店铺名称", new GetDialog.GetEditTextDialogInterface() {
                    @Override
                    public void getText(String text) {
                        activity_storeset_storename.setText(text);
                        MyShow.myToash(activity, "修改成功");

                    }
                });
                break;
            case R.id.activity_storeset_address_layout:
                GetDialog.getEditTextDialog(activity, view, "更改店铺地址", "请输入店铺地址", new GetDialog.GetEditTextDialogInterface() {
                    @Override
                    public void getText(String text) {
                        activity_storeset_storename.setText(text);
                        MyShow.myToash(activity, "修改成功");

                    }
                });
                break;
            case R.id.activity_storeset_phone_layout:
                GetDialog.getEditTextDialog(activity, view, "更改电话号码", "请输入电话号码", new GetDialog.GetEditTextDialogInterface() {
                    @Override
                    public void getText(String text) {
                        if (Regular.isMobile(text)) {
                            activity_storeset_phone.setText(text);
                            MyShow.myToash(activity, "修改成功");
                        } else {
                            MyShow.myToash(activity, "手机号格式错误");
                        }
                    }
                });

                break;
            case R.id.activity_storeset_emali_layout:

                GetDialog.getEditTextDialog(this, view, "更改邮箱地址", "请输入邮箱地址", new GetDialog.GetEditTextDialogInterface() {
                    @Override
                    public void getText(String text) {
                        if (Regular.isEmail(text)) {
                            activity_storeset_email.setText(text);
                            MyShow.myToash(activity, "修改成功");
                        } else {
                            MyShow.myToash(activity, "邮箱格式错误");
                        }
                    }
                });
                break;
            case R.id.activity_storeset_QQ_layout:
                GetDialog.getEditTextDialog(this, view, "更改邮箱地址", "请输入邮箱地址", new GetDialog.GetEditTextDialogInterface() {
                    @Override
                    public void getText(String text) {
                        if (Regular.isQQ(text)) {
                            activity_storeset_email.setText(text);
                            MyShow.myToash(activity, "修改成功");
                        } else {
                            MyShow.myToash(activity, "QQ号格式错误");
                        }
                    }
                });
                break;
            case R.id.activity_accountset_takeout_layout:

                GetDialog.getCheckBoxDialog(activity, view, new GetDialog.GeCheckBoxDialogInterface() {
                    @Override
                    public void getCheckBox(boolean[] booleens) {
                        for (int i = 0; i < 4; i++) {
                            checkBoxs[i].setChecked(booleens[i]);
                            if (booleens[i]) {
                                checkBoxs[i].setVisibility(View.VISIBLE);
                            } else {
                                checkBoxs[i].setVisibility(View.GONE);
                            }
                        }
                        if(!booleens[0]&&!booleens[1]){
                            activity_accountset_takeout_1.setVisibility(View.GONE);
                        }else {
                            activity_accountset_takeout_1.setVisibility(View.VISIBLE);
                        }
                    }
                });


                break;

        }
    }


    public void onActivityResult(int req, int res, Intent data) {
        switch (req) {
            /**
             * 拍照的请求标志
             */
            case 1:
                if (res == RESULT_OK) {
                    try {
                        Bitmap bit = (Bitmap) data.getExtras().get("data");
                        activity_storeset_logo.setImageBitmap(bit);
                        ShareUitls.putString(activity, "storelogo_url", DiskBitmap.saveMyBitmap(bit));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {

                }

                break;
            /**
             * 从相册中选取图片的请求标志
             */

            case 0:
                if (res == RESULT_OK) {
                    Uri selectedImage = data.getData();
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};
                    Cursor cursor = getContentResolver().query(selectedImage,
                            filePathColumn, null, null, null);
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    //picturePath就是图片在储存卡所在的位置
                    String picturePath = cursor.getString(columnIndex);
                    cursor.close();//必须关闭
                    Bitmap bit = BitmapFactory.decodeFile(picturePath);
                    activity_storeset_logo.setImageBitmap(bit);
                    ShareUitls.putString(activity, "storelogo_url", picturePath);

                }
                break;

            default:
                break;
        }
    }
}
