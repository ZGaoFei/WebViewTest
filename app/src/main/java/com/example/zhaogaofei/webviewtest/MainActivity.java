package com.example.zhaogaofei.webviewtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.zhaogaofei.webviewtest.activity.BaseUseActivity;
import com.example.zhaogaofei.webviewtest.activity.JSWithWebViewActivity;
import com.example.zhaogaofei.webviewtest.activity.JavaWithJSActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        Button one = (Button) findViewById(R.id.button_main_one);
        one.setOnClickListener(this);
        Button two = (Button) findViewById(R.id.button_main_two);
        two.setOnClickListener(this);
        Button three = (Button) findViewById(R.id.button_main_three);
        three.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_main_one:
                skipPage(BaseUseActivity.class);
                break;
            case R.id.button_main_two:
                skipPage(JSWithWebViewActivity.class);
                break;
            case R.id.button_main_three:
                skipPage(JavaWithJSActivity.class);
                break;
        }
    }

    private void skipPage(Class cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }
}
