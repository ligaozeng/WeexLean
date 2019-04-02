package com.example.mac.weexlean.weex.adapter;

import android.widget.ImageView;

import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.IWXImgLoaderAdapter;
import com.taobao.weex.common.WXImageStrategy;
import com.taobao.weex.dom.WXImageQuality;

/**
 * Created by： lgz
 * Time： 2019/3/29
 * Desc：
 */

public class WXImageAdapter implements IWXImgLoaderAdapter {

    @Override
    public void setImage(final String url, final ImageView view, WXImageQuality quality, WXImageStrategy strategy) {

        WXSDKManager.getInstance().postOnUiThread(new Runnable() {

            @Override
            public void run() {
//                if(view==null||view.getLayoutParams()==null){
//                    return;
//                }
//                if (TextUtils.isEmpty(url)) {
//                    view.setImageBitmap(null);
//                    return;
//                }
//                String temp = url;
//                if (url.startsWith("//")) {
//                    temp = "http:" + url;
//                }
//                if (view.getLayoutParams().width <= 0 || view.getLayoutParams().height <= 0) {
//                    return;
//                }
//                Picasso.with(WXEnvironment.getApplication())
//                        .load(temp)
//                        .into(view);
            }
        },0);
    }

}
