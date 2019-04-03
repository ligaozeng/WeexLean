package com.example.mac.weexlean.weex.adapter;

import android.text.TextUtils;

import com.taobao.weex.adapter.IWXHttpAdapter;
import com.taobao.weex.common.WXRequest;
import com.taobao.weex.common.WXResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.http.HttpMethod;

/**
 * Created by： lgz
 * Time： 2019/3/29
 * Desc：
 */

public class WXHpptAdapter implements IWXHttpAdapter {

    @Override
    public void sendRequest(WXRequest request, final OnHttpListener listener) {
        OkHttpClient client = new OkHttpClient.Builder()
//                .addNetworkInterceptor(new WeexOkhttp3Interceptor())
                .connectTimeout(request.timeoutMs, TimeUnit.MILLISECONDS)
                .readTimeout(request.timeoutMs, TimeUnit.MILLISECONDS)
                .build();

        String method = request.method == null ? "GET" : request.method.toUpperCase();
        String requestBodyString = request.body == null ? "{}" : request.body;
        RequestBody body = HttpMethod.requiresRequestBody(method) ? RequestBody.create(MediaType.parse("application/json"), requestBodyString) : null;

        Request.Builder requestBuilder = new Request.Builder()
                .url(request.url)
                .method(method, body);

        for (Map.Entry<String, String> param : request.paramMap.entrySet()) {
            requestBuilder.addHeader(param.getKey(), param.getValue());
        }

        client.newCall(requestBuilder.build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                WXResponse wxResponse = new WXResponse();
                wxResponse.errorMsg = e.getMessage();
                wxResponse.errorCode = "-1";
                wxResponse.statusCode = "-1";
                listener.onHttpFinish(wxResponse);
            }

            @Override
            public void onResponse(Call call, Response response) {
                WXResponse wxResponse = new WXResponse();
                byte[] responseBody = new byte[0];
                try {
                    responseBody = response.body().bytes();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                wxResponse.data = new String(responseBody);
                wxResponse.statusCode = String.valueOf(response.code());
                wxResponse.originalData = responseBody;
                wxResponse.extendParams = new HashMap<>();
                for (Map.Entry<String, List<String>> entry : response.headers().toMultimap().entrySet()) {
                    wxResponse.extendParams.put(entry.getKey(), entry.getValue());
                }

                if (response.code() < 200 || response.code() > 299) {
                    wxResponse.errorMsg = response.message();
                }

                listener.onHttpFinish(wxResponse);
            }
        });
    }

}
