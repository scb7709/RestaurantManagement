package com.zyhp.restaurantmanagement.activity;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.utils.FileViewer;
import com.zyhp.restaurantmanagement.utils.MyShow;

import java.io.File;

/**
 * Created by Administrator on 2018/7/6.
 */

public class AboutUsSetActivity extends BaseActivity implements View.OnClickListener{
    private TextView view_publictitle_title,activity_houpu_versioncode
            ,activity_abouthoupu_cache;

    private RelativeLayout view_publictitle_back;
    private long IMAGEcache;//图片缓存大小
    private String SDPATH;//SD卡根目录
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        SDPATH = Environment.getExternalStorageDirectory().getAbsolutePath();
        IMAGEcache = FileViewer.getFolderSize(new File(SDPATH + "/houpu/image"));
        findView();
    }

    void findView() {
        view_publictitle_title = (TextView) findViewById(R.id.view_publictitle_title);
        view_publictitle_title.setText("关于");
        view_publictitle_back = (RelativeLayout) findViewById(R.id.view_publictitle_back);
        view_publictitle_back.setOnClickListener(this);
        activity_houpu_versioncode = (TextView) findViewById(R.id.activity_houpu_versioncode);
        activity_abouthoupu_cache = (TextView) findViewById(R.id.activity_abouthoupu_cache);
        activity_houpu_versioncode.setText("当前版本：3.0.0");
        activity_abouthoupu_cache.setText(IMAGEcache+"mb");
        findViewById(R.id.activity_abouthoupu_update).setOnClickListener(this);
        findViewById(R.id.activity_abouthoupu_clearcache).setOnClickListener(this);
        findViewById(R.id.activity_abouthoupu_aboutus).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.view_publictitle_back:
                finish();
                break;
            case R.id.activity_abouthoupu_update:
                MyShow.myToash(AboutUsSetActivity.this,"已是最新版本");
                break;
            case R.id.activity_abouthoupu_clearcache:
                FileViewer.deleteFolderFile(SDPATH + "/houpu/image", true);
                activity_abouthoupu_cache.setText(0+"mb");
                break;
            case R.id.activity_abouthoupu_aboutus:

                break;
        }
    }
}
