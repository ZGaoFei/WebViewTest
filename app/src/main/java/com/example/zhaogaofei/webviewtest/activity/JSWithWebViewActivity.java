package com.example.zhaogaofei.webviewtest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhaogaofei.webviewtest.R;

/**
 * JS调用Java代码
 */
public class JSWithWebViewActivity extends AppCompatActivity {
    private static final String LOCAL_URL = "file:///android_asset/WithJava.html";

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jswith_web_view);

        initView();
    }

    private void initView() {
        TextView textView = (TextView) findViewById(R.id.tv_with_java);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl(LOCAL_URL);
            }
        });

        webView = (WebView) findViewById(R.id.web_view_with_java);

        setWebView();
    }

    private void setWebView() {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.addJavascriptInterface(this, "android");
    }

    @JavascriptInterface
    public void toastMessage(String message) {
        Toast.makeText(getApplicationContext(), "通过Native传递的Toast:"+message, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void toastMessage() {
        Toast.makeText(getApplicationContext(), "通过Native传递的Toast:参数为空", Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void toast() {
        Toast.makeText(getApplicationContext(), "通过Native传递的Toast:多个方法调用", Toast.LENGTH_SHORT).show();
    }
}
