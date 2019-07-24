package com.aigoule.starapp.api;
import androidx.annotation.NonNull;
import com.aigoule.starapp.model.BaseModel;
import com.aigoule.starapp.utils.LogUtil;
import com.google.gson.JsonParseException;
import org.json.JSONException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;
import javax.net.ssl.SSLHandshakeException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class HttpCallback<T extends BaseModel> implements Callback<T> {
    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
        if (call.isCanceled()) {
            return;
        }
        if (response.isSuccessful()) {
            T model = response.body();
            if (model == null) {
                return;
            }
                try {
                    onSuccess(model);
                } catch (Exception e) {
                    e.printStackTrace();
                }

        } else {
            onFailure(call, new IOException("Unexpected code " + response.code()));
        }
    }



    @Override
    public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
        t.printStackTrace();
        if (call.isCanceled()) {
            return;
        }
        LogUtil.e("=======Throwable.======="+t.toString());
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

    public abstract void onSuccess(T data) ;

    public abstract void onFailure(int msgCode, String errorMsg);
}
