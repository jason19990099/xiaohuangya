package com.aigoule.starapp.api;
import android.content.Context;
import android.util.Base64;

import androidx.collection.ArrayMap;
import com.aigoule.starapp.model.AllpicModel;
import com.aigoule.starapp.model.AllthemeVideoModel;
import com.aigoule.starapp.model.AllvideoThemeModel;
import com.aigoule.starapp.model.AllvidesModel;
import com.aigoule.starapp.model.BannerModel;
import com.aigoule.starapp.model.Body;
import com.aigoule.starapp.model.ClassDataModel;
import com.aigoule.starapp.model.FictionModel;
import com.aigoule.starapp.model.FirstpageModel;
import com.aigoule.starapp.model.Fpicmodel;
import com.aigoule.starapp.model.InvitationListModel;
import com.aigoule.starapp.model.LoginModel;
import com.aigoule.starapp.model.LotteryLinkModel;
import com.aigoule.starapp.model.MainTheme;
import com.aigoule.starapp.model.NewVideosModel;
import com.aigoule.starapp.model.PicModel;
import com.aigoule.starapp.model.PicdetailModel;
import com.aigoule.starapp.model.PlayRecordsModel;
import com.aigoule.starapp.model.PlaydetailModel;
import com.aigoule.starapp.model.RegistMosdel;
import com.aigoule.starapp.model.SearchModel;
import com.aigoule.starapp.model.ThemeDetailModel;
import com.aigoule.starapp.model.UpdataModel;
import com.aigoule.starapp.model.VideoclassdataModel;
import com.aigoule.starapp.utils.JsonUtil;
import com.aigoule.starapp.utils.LogUtil;
import com.aigoule.starapp.utils.MD5;
import com.aigoule.starapp.utils.SharePreferencesUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import io.reactivex.annotations.Nullable;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;


/**
 * 描述：网络请求类，将网络请求的方法放到此处统一管理  单例
 * 每个请求方法都传了tag标签,Activity和Fragment中请传this,方便生命周期管理.
 */

public class HttpRequest {
    private ApiService mService = ApiClient.getInstance().mApiService;
    private static ArrayMap<Object, List<Call>> mCallMap = new ArrayMap<>();
    private Gson gson=new Gson();
    private String jason_web_token="";

    private static class SingletonHolder {
        private static HttpRequest instance = new HttpRequest();
    }

    public static HttpRequest getInstance() {
        return SingletonHolder.instance;
    }

    private synchronized void putCall(Object tag, Call call) {
        if (tag == null) {
            return;
        }
        List<Call> callList = mCallMap.get(tag);
        if (callList == null) {
            callList = Collections.synchronizedList(new ArrayList<>());
        }
        callList.add(call);
        mCallMap.put(tag, callList);
    }

    public synchronized void cancel(Object tag) {
        if (tag == null) {
            return;
        }
        List<Call> callList = mCallMap.get(tag);
        if (callList == null || callList.size() == 0) {
            return;
        }
        for (Call call : callList) {
            if (!call.isCanceled()) {
                call.cancel();
            }
        }
        mCallMap.remove(tag);
    }

    /**
     * 退出登录的时间设置
     */
    public void setOid()  {
        jason_web_token="";
    }

    /**
     * 登录时间设置jason_web_token
     * @param id
     */
    public void setOid(String id)  {
        String key="123456999";
        Body body=new Body();
        body.setExp(String.valueOf(System.currentTimeMillis()+60));
        body.setId(id);
        String bodys=gson.toJson(body);
        String jason = "";
        try{
            jason =android.util.Base64.encodeToString(bodys.getBytes("utf-8"), Base64.NO_WRAP);
        }catch (Exception e){
            e.printStackTrace();
        }
        String jasons=key+jason;
        String sign = MD5.MD5Encode(jasons,"utf8").toLowerCase();

        jason_web_token=key+"."+jason+"."+sign;
    }


    public String getOid()  {
        return  jason_web_token;
    }




    private class RequestBodyBuilder {
        Map<String, Object> params;
        private RequestBodyBuilder() {
            params = new HashMap<>();
        }
        private RequestBodyBuilder addParam(String key, Object value) {
            params.put(key, value);
            return this;
        }
        private RequestBody build() {
            return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JsonUtil.toJson(params));
        }
    }


    /**
     *   获取banner广告图
     */
    public void getBanner(Object tag, Callback<BannerModel> callback) {
        Call<BannerModel> call = mService.getBanner();
        putCall(tag, call);
        call.enqueue(callback);
    }


    /**
     * 上侧四个主题
     */
    public void getMainTheme(Object tag, Callback<MainTheme> callback) {
        Call<MainTheme> call = mService.getMainTheme();
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 获取最新视频
     */
    public void getNewvideos(Object tag, Callback<NewVideosModel> callback) {
        Call<NewVideosModel> call = mService.getNewVideos();
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 获取最新视频
     */
    public void getAllvideos(Object tag, Callback<AllvidesModel> callback) {
        Call<AllvidesModel> call = mService.getAllvideos();
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 获取最新视频
     */
    public void getHotvideos(Object tag, Callback<NewVideosModel> callback) {
        Call<NewVideosModel> call = mService.getHotVideos();
        putCall(tag, call);
        call.enqueue(callback);
    }
    /**
     * 获取首页小说的8条数据
     */
    public void getFiction(Object tag, Callback<FictionModel> callback) {
        Call<FictionModel> call = mService.getFiction();
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 获取每个视频相关的
     */
    public void getClassData(Object tag, Callback<ClassDataModel> callback) {
        Call<ClassDataModel> call = mService.getClassDate();
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 获取首页的8个图片
     */
    public void getHomepic(Object tag, Callback<Fpicmodel> callback) {
        Call<Fpicmodel> call = mService.getPicFisrt();
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 获得某个视频分类的数据
     */
    public void getVideoclassdata(Object tag,String cid, Callback<VideoclassdataModel> callback) {
        Call<VideoclassdataModel> call = mService.getVideoclassdata(cid);
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     *  获得图片的所有分类
     */
    public void getPicClass(Object tag, Callback<AllpicModel> callback) {
        Call<AllpicModel> call = mService.getPicClass();
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 获得某个图片的一个分类
     * @param tag
     * @param id
     * @param callback
     */
    public void getOnePic(Object tag, String id, Callback<PicModel> callback) {
        Call<PicModel> call = mService.getOnePicClass(id);
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 获取某个图片的详情
     */
    public void getPicdetail(Object tag, String id, Callback<PicdetailModel> callback) {
        Call<PicdetailModel> call = mService.getPicdetail(id);
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 登录
     * @param tag
     * @param username
     * @param password
     * @param callback
     */
        public void login(Object tag, String username, String password, HttpCallback<LoginModel> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam("name", username)
                .addParam("password", password)
                .build();
        Call<LoginModel> call = mService.login(body);
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 用户注册
     */
    public void registe(Object tag, @Nullable String name, String email, String password, String password_confirm,
                         HttpCallback<RegistMosdel> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam("name", name)
                .addParam("email", email)
                .addParam("password", password)
                .addParam("password_confirm", password_confirm)
                .build();
        Call<RegistMosdel> call = mService.regist(body);
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     *  获取播放的具体信息
     */
    public void getPlayDetail(Object tag, String play, String user_id,String phone_id,
                        HttpCallback<PlaydetailModel> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam("play", play)
                .addParam("user_id", user_id)
                .addParam("phone_id", phone_id)
                .build();
        Call<PlaydetailModel> call = mService.getPlayDetail(body);
        putCall(tag, call);
        call.enqueue(callback);
    }



    /**
     * 个人设置
     */
    public void Update(Object tag, String psw, String phone,String qq,String email, HttpCallback<UpdataModel> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam("Bearer", getOid())
                .addParam("password", psw)
                .addParam("phone", phone)
                .addParam("qq", qq)
                .addParam("email", email)
                .build();
        Call<UpdataModel> call = mService.update(body);
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 播放记录
     */
    public void getUserHistory(Object tag, String page, HttpCallback<PlayRecordsModel> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam("Bearer", getOid())
                .addParam("page", page)
                .build();
        Call<PlayRecordsModel> call = mService.userHistory(body);
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 获取小说详情
     */
    public void getFictionDetail(Object tag, String id, HttpCallback<PlayRecordsModel> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam("Bearer", getOid())
                .addParam("id", id)
                .build();
        Call<PlayRecordsModel> call = mService.getFictiondetail(body);
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 获取邀请记录
     */
    public void getInvitationList(Object tag, HttpCallback<InvitationListModel> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam("Bearer", getOid())
                .build();
        Call<InvitationListModel> call = mService.getInvitationList(body);
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     *  获取所有专题
     */
    public void getALLtheme(Object tag, HttpCallback<AllvideoThemeModel> callback) {
        Call<AllvideoThemeModel> call = mService.getAllTheme();
        putCall(tag, call);
        call.enqueue(callback);
    }


    /**
     *  获取专题详情
     */
    public void getThemeDetail(Object tag,int theme_id, HttpCallback<ThemeDetailModel> callback) {
        Call<ThemeDetailModel> call = mService.getThemeDetail(theme_id);
        putCall(tag, call);
        call.enqueue(callback);
    }



    /**
     *  获取全部专题详情
     */
    public void getALLThemeDetail(Object tag,String theme_id, HttpCallback<AllthemeVideoModel> callback) {
        Call<AllthemeVideoModel> call = mService.getThemeAllDetail(theme_id);
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 获取彩票链接
     */
    public void getLotteryLinlk(Object tag, HttpCallback<LotteryLinkModel> callback) {
        Call<LotteryLinkModel> call = mService.getLotterylinl();
        putCall(tag, call);
        call.enqueue(callback);
    }


    /**
     * 获取首页全部信息
     */
    public void getFirstAllmessage(Object tag, HttpCallback<FirstpageModel> callback) {
        Call<FirstpageModel> call = mService.getHomeall();
        putCall(tag, call);
        call.enqueue(callback);
    }


    /**
     *  搜索视频
     */
    public void search(Object tag,String wd, HttpCallback<SearchModel> callback) {
        Call<SearchModel> call = mService.search(wd);
        putCall(tag, call);
        call.enqueue(callback);
    }
}
