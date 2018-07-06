package com.zyhp.restaurantmanagement.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.myview.CircleImageView;
import com.zyhp.restaurantmanagement.utils.DiskBitmap;
import com.zyhp.restaurantmanagement.utils.GetChoiceDialog;
import com.zyhp.restaurantmanagement.utils.GetEditTextDialog;
import com.zyhp.restaurantmanagement.utils.MyShow;
import com.zyhp.restaurantmanagement.utils.ShareUitls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * Created by Administrator on 2018/7/6.
 */

public class AccountSetActivity extends BaseActivity implements View.OnClickListener {
    CircleImageView activity_accountset_headimage;
    TextView activity_accountset_email, activity_accountset_phonenumber;


    private TextView view_publictitle_title;

    private RelativeLayout view_publictitle_back;
    String  head_url;
    AccountSetActivity accountSetActivity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountset);
        accountSetActivity=this;

        findView();
    }

    void findView() {
        view_publictitle_title = (TextView) findViewById(R.id.view_publictitle_title);
        view_publictitle_title.setText("账户设置");
        view_publictitle_back = (RelativeLayout) findViewById(R.id.view_publictitle_back);
        view_publictitle_back.setOnClickListener(this);
        activity_accountset_email = (TextView) findViewById(R.id.activity_accountset_email);
        activity_accountset_phonenumber = (TextView) findViewById(R.id.activity_accountset_phonenumber);
        activity_accountset_headimage = (CircleImageView) findViewById(R.id.activity_accountset_headimage);
        head_url=ShareUitls.getString(accountSetActivity,"head_url","");
        if(head_url!=null&&head_url.length()>0){
            activity_accountset_headimage.setImageBitmap(DiskBitmap.getDiskBitmap(head_url,accountSetActivity));
        }
        findViewById(R.id.view_publictitle_back).setOnClickListener(this);
        activity_accountset_headimage.setOnClickListener(this);
        findViewById(R.id.activity_accountset_phonenumber_layout).setOnClickListener(this);
        findViewById(R.id.activity_accountset_emali_layout).setOnClickListener(this);
        findViewById(R.id.activity_accountset_exitlogin).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.view_publictitle_back:
                finish();
                break;
            case R.id.activity_accountset_headimage:
             //   Log.i("activit", "vactivity_accountset_headimage");
                GetChoiceDialog.getChoiceDialog(this, "选择图片", new String[]{"相册选图", "打开相机"}, new GetChoiceDialog.GetChoiceDialogInterface() {
                    @Override
                    public void onClick(int which) {
                        if (which == 0) {
                            Intent intent = new Intent(Intent.ACTION_PICK);
                            intent.setType("image/*");
                            startActivityForResult(intent, 0);
                        } else {

                            head_url = Environment.getExternalStorageDirectory().getPath()+ "/hopu/image" ;// 获取SD卡路径
                            File file=new File(head_url);
                            if (!file.exists()) {
                                try {
                                    file.createNewFile();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            head_url = head_url + "temp.png";// 指定路径
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);// 启动系统相机
                            Uri photoUri = Uri.fromFile(new File(head_url)); // 传递路径
                            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);// 更改系统默认存储路径
                            startActivityForResult(intent, 1);



               /*             Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                           // String f = System.currentTimeMillis()+".jpg";
                         //   Uri fileUri = Uri.fromFile(new File(Environment.getExternalStoragePublicDirectory("").getPath()+f));
                          //  head_url=fileUri.getPath();
                          //  intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                            startActivityForResult(intent, 1);*/
                        }

                    }
                });
                break;
            case R.id.activity_accountset_phonenumber_layout:

                GetEditTextDialog.getEditTextDialog(this, view, "更改电话号码", "请输入电话号码", new GetEditTextDialog.GetEditTextDialogInterface() {
                    @Override
                    public void getText(String text) {
                        if(GetEditTextDialog.isMobile(text)){
                            activity_accountset_phonenumber.setText(text);
                            MyShow.myToash(AccountSetActivity.this,"修改成功");
                        }else {
                            MyShow.myToash(AccountSetActivity.this,"手机号格式错误");
                        }
                    }
                });

                break;
            case R.id.activity_accountset_emali_layout:

                GetEditTextDialog.getEditTextDialog(this, view, "更改邮箱地址", "请输入邮箱地址", new GetEditTextDialog.GetEditTextDialogInterface() {
                    @Override
                    public void getText(String text) {
                        if(GetEditTextDialog.isEmail(text)){
                            activity_accountset_phonenumber.setText(text);
                            MyShow.myToash(AccountSetActivity.this,"修改成功");
                        }else {
                            MyShow.myToash(AccountSetActivity.this,"邮箱格式错误");
                        }
                    }
                });
                break;
            case R.id.activity_accountset_exitlogin:
                MainActivity.activity.finish();
                startActivity(new Intent(AccountSetActivity.this, LoginActivity.class));
                finish();
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

                    FileInputStream fis = null;
                    try {
                        fis = new FileInputStream(head_url); // 根据路径获取数据
                        Bitmap bitmap = BitmapFactory.decodeStream(fis);
                        activity_accountset_headimage.setImageBitmap(bitmap);// 显示图片
                        ShareUitls.putString(AccountSetActivity.this,"head_url", head_url);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            fis.close();// 关闭流
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                  /*  try {


                            Bitmap bit = (Bitmap) data.getExtras().get("data");
                        activity_accountset_headimage.setImageBitmap(bit);
                        ShareUitls.putString(AccountSetActivity.this,"head_url", DiskBitmap.saveMyBitmap(bit));
                       ;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }*/
                } else {

                }

                break;
            /**
             * 从相册中选取图片的请求标志
             */

            case 0:
                if (res == RESULT_OK) {
                    try {
                        Uri uri = data.getData();

                        Bitmap bit = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
                        activity_accountset_headimage.setImageBitmap(bit);
                        ShareUitls.putString(AccountSetActivity.this,"head_url", uri.getPath());
                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                } else {

                }

                break;

            default:
                break;
        }
    }
}
