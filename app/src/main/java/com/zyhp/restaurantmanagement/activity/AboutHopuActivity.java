package com.zyhp.restaurantmanagement.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
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
        activity_abouthopu_webview.getSettings().setSupportZoom(true);
        activity_abouthopu_webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
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
