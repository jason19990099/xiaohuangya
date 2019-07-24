package com.aigoule.starapp.api;

import android.text.TextUtils;
import com.aigoule.starapp.model.BaseModel;
import com.aigoule.starapp.utils.JsonUtil;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;

import javax.net.ssl.SSLHandshakeException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 描述：接口数据返回是一个形如[{...},{...}]的json数组, 解析成对应的list
 * 由于接口设计问题, 请求不正确时返回的json时{code=1,msg=3001}形式json对象
 */

public abstract class ArrayCallback<T> implements Callback<JsonElement> {
    @Override
    public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
        if (call.isCanceled()) {
            return;
        }
        if (response.isSuccessful()) {
            JsonElement element = response.body();
            if (element == null) {
                return;
            }
            if (element.isJsonObject()) {
                BaseModel model = JsonUtil.fromJson(element, BaseModel.class);
                if (!TextUtils.isEmpty(model.getMsg())) {
                    onApiFailure(model);
                }
            } else if (element.isJsonArray()) {
                T data = JsonUtil.fromJson(element, getType());
                onSuccess(data);
            }
        } else {
            onFailure(call, new IOException("Unexpected code " + response.code()));
        }
    }

    private void onApiFailure(BaseModel model) {
        int msgCode = model.getCode();
        String msg=model.getMsg();
        onFailure(msgCode, msg);
    }

    @Override
    public void onFailure(Call<JsonElement> call, Throwable t) {
        if (call.isCanceled()) {
            return;
        }
        if (t instanceof JSONException || t instanceof JsonParseException || t instanceof ParseException) {
            onFailure(10011, "JSONException");
        } else if (t instanceof ConnectException) {
            onFailure(10012,"ConnectException");
        } else if (t instanceof SSLHandshakeException) {
            onFailure(10013, "SSLHandshakeException");
        } else if (t instanceof UnknownHostException) {
            onFailure(10014, "UnknownHostException");
        } else if (t instanceof SocketTimeoutException) {
            onFailure(10015, "SocketTimeoutException");
        } else {
            onFailure(10016, "UNkown");
        }
    }

    public abstract void onSuccess(T data);

    public abstract void onFailure(int msgCode, String errorMsg);

    private Type getType() {
        ParameterizedType parameterizedType = (ParameterizedType) (this.getClass().getGenericSuperclass());
        if (parameterizedType.getActualTypeArguments().length > 0) {
            return (parameterizedType).getActualTypeArguments()[0];
        }
        return Object.class;
    }
}
