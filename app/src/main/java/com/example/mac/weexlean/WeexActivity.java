package com.example.mac.weexlean;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by： lgz
 * Time： 2019/3/29
 * Desc：
 */

public class WeexActivity extends Activity  implements IWXRenderListener {
    private static final String TAG = "WeexActivity";
    protected WXSDKInstance mInstance;
    private String mUrl;// "http://your_current_IP:12580/examples/build/index.js";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createWeexInstance();
        mInstance.onActivityCreate();
        mUrl = getIntent().getStringExtra("weexUrl");

        mInstance.renderByUrl(
                getPageName(),
                mUrl,
                null,
                null,
                -1,
                -1,
                WXRenderStrategy.APPEND_ASYNC
        );
//        renderPageByURL(mUrl);
    }

    protected void destoryWeexInstance() {
        if (mInstance != null) {
            mInstance.registerRenderListener(null);
            mInstance.destroy();
            mInstance = null;
        }
    }

    protected void createWeexInstance() {
        destoryWeexInstance();
        mInstance = new WXSDKInstance(this);
        mInstance.registerRenderListener(this);
    }

    protected void renderPageByURL(String url) {
        renderPageByURL(url, null);
    }

    protected void renderPageByURL(String url, String jsonInitData) {
//        AssertUtil.throwIfNull(mContainer, new RuntimeException("Can't render page, container is null"));
        Map<String, Object> options = new HashMap<>();
        options.put(WXSDKInstance.BUNDLE_URL, url);
        mInstance.renderByUrl(
                getPageName(),
                url,
                options,
                jsonInitData,
                -1,
                -1,
                WXRenderStrategy.APPEND_ASYNC);
    }

    protected String getPageName() {
        return TAG;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mInstance != null) {
            mInstance.onActivityStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mInstance != null) {
            mInstance.onActivityResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mInstance != null) {
            mInstance.onActivityPause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mInstance != null) {
            mInstance.onActivityStop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mInstance != null) {
            mInstance.onActivityDestroy();
        }
    }

    @Override
    public void onViewCreated(WXSDKInstance wxsdkInstance, View view) {
        Log.e(TAG, "onViewCreated");
        setContentView(view);
    }

    @Override
    public void onRefreshSuccess(WXSDKInstance wxsdkInstance, int width, int height) {
        Log.e(TAG, "onRefreshSuccess");
    }

    @Override
    public void onRenderSuccess(WXSDKInstance instance, int width, int height) {
        Log.e(TAG, "onRenderSuccess");
    }

    @Override
    public void onException(WXSDKInstance instance, String errCode, String msg) {
        Log.e(TAG, "onException："+errCode);
        Log.e(TAG, msg);

    }

}
