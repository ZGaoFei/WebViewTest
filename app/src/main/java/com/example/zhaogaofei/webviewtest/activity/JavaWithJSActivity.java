package com.example.zhaogaofei.webviewtest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhaogaofei.webviewtest.R;

/**
 * JAVA调用JS的代码
 */
public class JavaWithJSActivity extends AppCompatActivity {
    private static final String LOCAL_URL = "file:///android_asset/WithJs.html";

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_with_js);

        initView();
    }

    private void initView() {
        TextView textView = (TextView) findViewById(R.id.tv_with_js);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl("javascript:sum(3,8)");
            }
        });
        TextView tvGet = (TextView) findViewById(R.id.tv_get_with_js);
        tvGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getResult();
            }
        });

        webView = (WebView) findViewById(R.id.web_view_with_js);

        setWebView();
        webView.loadUrl(LOCAL_URL);
    }

    private void setWebView() {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.addJavascriptInterface(this, "android");
    }

    // 4.4之前获取调用JS的结果，是需要再调用Java的方法传递回来
    @JavascriptInterface
    public void getResult(String result) {
        Toast.makeText(getApplicationContext(), "结果为" + result, Toast.LENGTH_SHORT).show();
    }

    // 4.4之后获取JS的结果，限制版本必须大于19
    public void getResult() {
        webView.evaluateJavascript("returnSum()", new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String s) {
                Toast.makeText(getApplicationContext(), "结果为:" + s, Toast.LENGTH_SHORT).show();// 获取不到结果
            }
        });
    }
}
