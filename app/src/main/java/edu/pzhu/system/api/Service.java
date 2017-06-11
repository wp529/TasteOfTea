package edu.pzhu.system.api;


import java.util.Map;
import edu.pzhu.system.model.handleresult.HandleResultBean;
import edu.pzhu.system.model.login.LoginBean;
import edu.pzhu.system.model.manager.ManagerBean;
import edu.pzhu.system.model.news.News;
import edu.pzhu.system.model.selectresult.SelectResultBean;
import edu.pzhu.system.model.teabatch.TeaBatchBean;
import edu.pzhu.system.model.teainfo.TeaInfoBean;
import edu.pzhu.system.model.teainfodetail.TeaInfoDetailBean;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * retrofit设置api
 */
public interface Service {

    @GET("sems/newslist.php")
    Observable<News> getNews(@QueryMap(encoded = true) Map<String, String> params);

    @FormUrlEncoded
    @POST("AppApi/Member/login")
    Observable<LoginBean> getLoginStatus(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("AppApi/Tea/getList")
    Observable<ManagerBean> getManagerList(@FieldMap Map<String, String> params);

    @GET("sems/newslist.php")
    Observable<HandleResultBean> waterTea(@QueryMap(encoded = true) Map<String, String> params);

    @GET("sems/newslist.php")
    Observable<HandleResultBean> fertilizeTea(@QueryMap(encoded = true) Map<String, String> params);

    @GET("sems/newslist.php")
    Observable<HandleResultBean> cutTea(@QueryMap(encoded = true) Map<String, String> params);

    @GET("sems/newslist.php")
    Observable<HandleResultBean> pickTea(@QueryMap(encoded = true) Map<String, String> params);

    @GET("sems/newslist.php")
    Observable<HandleResultBean> applyTea(@QueryMap(encoded = true) Map<String, String> params);

    @GET("sems/newslist.php")
    Observable<HandleResultBean> makeTea(@QueryMap(encoded = true) Map<String, String> params);

    @FormUrlEncoded
    @POST("AppApi/Tea/addOne")
    Observable<TeaBatchBean> addTeaBatch(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("AppApi/Information/getList")
    Observable<TeaInfoBean> getTeaInfoList(@FieldMap Map<String, String> params);

    @GET("sems/newslist.php")
    Observable<TeaInfoDetailBean> getTeaInfoDetail(@QueryMap(encoded = true) Map<String, String> params);

    @FormUrlEncoded
    @POST("AppApi/Tea/getDetails")
    Observable<SelectResultBean> getSelectResult(@FieldMap Map<String, String> params);
}
