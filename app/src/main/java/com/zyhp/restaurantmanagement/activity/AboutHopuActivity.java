package com.zyhp.restaurantmanagement.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zyhp.restaurantmanagement.R;

/**
 * Created by Administrator on 2018/7/6.
 */

public class AboutHopuActivity extends BaseActivity implements View.OnClickListener {
    private TextView view_publictitle_title;

    private RelativeLayout view_publictitle_back;
    WebView activity_abouthopu_webview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abouthopu);

        findView();
    }

    void findView() {
        view_publictitle_title = (TextView) findViewById(R.id.view_publictitle_title);
        view_publictitle_title.setText("厚溥官网");
        view_publictitle_back = (RelativeLayout) findViewById(R.id.view_publictitle_back);
        view_publictitle_back.setOnClickListener(this);
        activity_abouthopu_webview = (WebView) findViewById(R.id.activity_abouthopu_webview);

        activity_abouthopu_webview.loadUrl("http://www.myhopu.com/html/gyhp/hpjj");
        //加载页面居中显示
       /* WebSettings settings = webView.getSettings();
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);*/
//支持javascript
        activity_abouthopu_webview.getSettings().setJavaScriptEnabled(true);
// 设置可以支持缩放
        activity_abouthopu_webview.getSettings().setSupportZoom(true);
// 设置出现缩放工具
        activity_abouthopu_webview.getSettings().setBuiltInZoomControls(true);
//扩大比例的缩放
        activity_abouthopu_webview.getSettings().setUseWideViewPort(true);
//自适应屏幕

      /*  1.NARROW_COLUMNS：可能的话使所有列的宽度不超过屏幕宽度

        2.NORMAL：正常显示不做任何渲染

        3.SINGLE_COLUMN：把所有内容放大webview等宽的一列中

        用SINGLE_COLUMN类型可以设置页面居中显示，页面可以放大缩小，但这种方法不怎么好，有时候会让你的页面布局走样而且我测了一下，只能显示中间那一块，超出屏幕的部分都不能显示。
  */
        activity_abouthopu_webview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        activity_abouthopu_webview.getSettings().setLoadWithOverviewMode(true);
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
