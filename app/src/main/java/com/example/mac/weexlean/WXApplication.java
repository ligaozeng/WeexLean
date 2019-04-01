package com.example.mac.weexlean;

import android.app.Application;

import com.example.mac.weexlean.weex.adapter.WXHpptAdapter;
import com.example.mac.weexlean.weex.adapter.WXImageAdapter;
import com.taobao.weex.InitConfig;
import com.taobao.weex.WXSDKEngine;

/**
 * Created by： lgz
 * Time： 2019/3/29
 * Desc：
 */

public class WXApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // weex
        InitConfig config = (new InitConfig.Builder())
                .setImgAdapter(new WXImageAdapter())
                .setHttpAdapter(new WXHpptAdapter())
                .build();
        WXSDKEngine.initialize(this, config);
    }

}
