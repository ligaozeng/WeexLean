package com.example.mac.weexlean.weex.adapter;

import android.text.TextUtils;

import com.taobao.weex.adapter.IWXHttpAdapter;
import com.taobao.weex.common.WXRequest;
import com.taobao.weex.common.WXResponse;

/**
 * Created by： lgz
 * Time： 2019/3/29
 * Desc：
 */

public class WXHpptAdapter implements IWXHttpAdapter {

    @Override
    public void sendRequest(WXRequest request, OnHttpListener listener) {
//        if (listener != null) {
//            listener.onHttpStart();
//            WXResponse response = this.getResponseByPackageApp(request);
//            if (TextUtils.equals("200", response.statusCode)) {
//                response.extendParams.put("cacheType", "zcache");
//                listener.onHttpFinish(response);
//            } else {
//
//                Request.Builder builder = new Request.Builder()
//                        .url(request.url);
//
//                //添加header
//                addHeader(builder, request.paramMap);
//
//                if (request.method == null) {
//                    request.method = "GET";
//                }
//                request.method = request.method.toUpperCase();
//
//                if (request.body == null) {
//                    request.body = "";
//                }
//                Request okRequest;
//                switch (request.method) {
//                    case "POST":
//                    case "PUT":
//                    case "PATCH":
//                        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
//                        if (request.paramMap != null) {
//                            String type = request.paramMap.get("Content-Type");
//                            if (type != null) {
//                                mediaType = MediaType.parse(type);
//                            }
//                        }
//                        RequestBody requestBody = RequestBody.create(mediaType, request.body);
//                        okRequest = builder.method(request.method, requestBody).build();
//                        requestNet(okRequest, mOkHttpClient, listener);
//
//                        break;
//                    default:
//                        okRequest = builder.method(request.method, null).build();
//                        requestNet(okRequest, mOkHttpClient, listener);
//                        break;
//                }
//            }
//
//        }
    }

}
