package com.example.mac.weexlean.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXSDKInstance;

/**
 * Created by： lgz
 * Time： 2019/4/1
 * Desc：
 */

public abstract class BaseActivity extends Activity implements IWXRenderListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLayout();
        initWeex();
        initView();
        initData();

    }

    public abstract void initLayout();
    public void initWeex(){

    }
    public abstract void initView();
    public abstract void initData();

    @Override
    public void onViewCreated(WXSDKInstance instance, View view) {

    }

    @Override
    public void onRenderSuccess(WXSDKInstance instance, int width, int height) {

    }

    @Override
    public void onRefreshSuccess(WXSDKInstance instance, int width, int height) {

    }

    @Override
    public void onException(WXSDKInstance instance, String errCode, String msg) {

    }
}
