package com.example.zhaogaofei.webviewtest.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.zhaogaofei.webviewtest.R;

public class BaseUseActivity extends AppCompatActivity {
    private static final String URL = "http://www.baidu.com";
    private static final String LOCAL_URL = "file:///android_asset/Test.html";

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_use);

        initView();
    }

    private void initView() {
        TextView tvNet = (TextView) findViewById(R.id.tv_net_base_use);
        tvNet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webViewSettings();
                webView.loadUrl(URL);
            }
        });

        TextView tvLocal = (TextView) findViewById(R.id.tv_local_base_use);
        tvLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl(LOCAL_URL);
            }
        });

        webView = (WebView) findViewById(R.id.web_view_base_use);

        setWebView();
    }

    private void setWebView() {
        webView.setWebViewClient(new WebViewClient());

        // 如果webView中需要用户手动输入用户名、密码或其他，则webview必须设置支持获取手势焦点
        webView.requestFocusFromTouch();
    }

    private void webViewSettings() {
        WebSettings settings = webView.getSettings();
        // 设置自适应屏幕
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);

        // 开启javascript支持
        settings.setJavaScriptEnabled(true);
        // 设置可以支持缩放
        settings.setSupportZoom(true);
        // 设置出现缩放工具
        settings.setBuiltInZoomControls(true);
    }
}
