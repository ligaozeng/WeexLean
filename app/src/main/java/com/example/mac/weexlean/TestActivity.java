package com.example.mac.weexlean;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;
import com.taobao.weex.utils.WXFileUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by： lgz
 * Time： 2019/3/29
 * Desc：
 */

public class TestActivity extends Activity  {

    private Button btn1,btn2;
    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        btn1 = findViewById(R.id.test_btn1);
        btn2 = findViewById(R.id.test_btn2);
        imageView = findViewById(R.id.test_image);
        textView = findViewById(R.id.test_text);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setVisibility(View.INVISIBLE);
                imageView.setVisibility(View.VISIBLE);
                String url = "https://img-my.csdn.net/uploads/201407/26/1406383275_3977.jpg";
                Glide.with(TestActivity.this)
                        .load(url)
                        .centerCrop()
                        .placeholder(R.drawable.loding)
                        .crossFade()
                        .into(imageView);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.INVISIBLE);
                String url = "http://www.baidu.com";
                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder().url(url).method("GET",null).build();
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, final IOException e) {runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(e.toString());
                        }
                    });
                    }

                    @Override
                    public void onResponse(Call call, final Response response) throws IOException {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                textView.setText(response.toString());
                            }
                        });
                    }
                });

            }
        });


        btn1.performClick();

    }


}
