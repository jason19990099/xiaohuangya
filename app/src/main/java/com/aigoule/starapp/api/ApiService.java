package com.aigoule.starapp.api;
import com.aigoule.starapp.model.AllpicModel;
import com.aigoule.starapp.model.AllthemeVideoModel;
import com.aigoule.starapp.model.AllvideoThemeModel;
import com.aigoule.starapp.model.AllvidesModel;
import com.aigoule.starapp.model.BannerModel;
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
import com.aigoule.starapp.model.ThemeDetailModel;
import com.aigoule.starapp.model.UpdataModel;
import com.aigoule.starapp.model.VideoclassdataModel;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiService {
    /**
     * 获取轮播图
     */
    @GET("/home/ad")
    Call<BannerModel> getBanner();

    /**
     * 获上侧四个主题
     */
    @GET("/home/rightFour")
    Call<MainTheme> getMainTheme();

    /**
     *  获取最新视频
     */
    @GET("/video/new")
    Call<NewVideosModel> getNewVideos();

    /**
     * 所有的视频分类
     */
    @GET("/video/allVodClass")
    Call<AllvidesModel> getAllvideos();

    /**
     *  获取最热视频
     */
    @GET("/video/hot")
    Call<NewVideosModel> getHotVideos();

    /**
     *  获取首页小说的8条数据
     */
    @GET("/fiction/homeShow")
    Call<FictionModel> getFiction();

    /**
     *  获取video的相关推荐
     */
    @GET("/video/videoRecommend")
    Call<ClassDataModel> getClassDate();

    /**
     * 首页的8个图片
     */
    @GET("/picture/homeShow")
    Call<Fpicmodel> getPicFisrt();


    /**
     * 某个视频的分类
     */
    @GET("/video/classData")
    Call<VideoclassdataModel> getVideoclassdata(@Query("cid") String cid);

    /**
     * 图片的所有分类
     */
    @GET("/picture/allPictureClass")
    Call<AllpicModel> getPicClass();

    /**
     * 某个图片分类的数据
     */
    @GET("/picture/classData")
    Call<PicModel> getOnePicClass(@Query("id") String id);

    /**
     *  某个图片的分类
     */
    @GET("/picture/detail")
    Call<PicdetailModel> getPicdetail(@Query("id") String id);

    /**
     * 登陸
     */
    @POST("/user/login")
    Call<LoginModel> login(@Body RequestBody  body);

    /**
     * 注冊
     */
    @POST("/user/register")
    Call<RegistMosdel> regist(@Body RequestBody  body);


    /**
     *  请求播放信息
     */
    @POST("/video/playDetail")
    Call<PlaydetailModel> getPlayDetail(@Body RequestBody  body);

    /**
     * 修改用戶数据
     */
    @POST("/user/update")
    Call<UpdataModel> update(@Body RequestBody  body);

    /**
     * 播放记录
     */
    @POST("/user/history")
    Call<PlayRecordsModel> userHistory(@Body RequestBody  body);

    /**
     * 小说详情
     */
    @POST("fiction/detail")
    Call<PlayRecordsModel> getFictiondetail(@Body RequestBody  body);


    /**
     * 邀请记录
     */
    @POST("user/invitationList")
    Call<InvitationListModel> getInvitationList(@Body RequestBody  body);

    /**
     * 全部专题
     */
    @GET("theme/allTheme")
    Call<AllvideoThemeModel> getAllTheme();

    /**
     * 专题详情
     */
    @GET("theme/themeDetail/{theme_id}")
    Call<ThemeDetailModel> getThemeDetail(@Path("theme_id") int id);


    /**
     * 专题全部
     */
    @GET("theme/themeMore/{theme_id}")
    Call<AllthemeVideoModel> getThemeAllDetail(@Path("theme_id") String id);


    /**
     * 获取彩票链接
     */
    @GET("lottery_link")
    Call<LotteryLinkModel> getLotterylinl();


    /**
     * 获取首页全部的信息
     */
    @GET("home/all")
    Call<FirstpageModel> getHomeall();



}
