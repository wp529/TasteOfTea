package edu.pzhu.system.api;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import edu.pzhu.system.MyApplication;
import edu.pzhu.system.utils.NetUtil;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 管理所有的网络请求
 */
public class ApiManager {
    /*private static final String BASE_URL = "http://192.168.155.3/";

    private static Retrofit retrofit = new Retrofit.Builder().
            baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();

    private static final Service service = retrofit.create(Service.class);
    */
    /**
     * 这下面写具体的请求
     * 例如
     *//*
    public static Observable<News> getNewsData(Map<String,String> params) {
        return service.getNews(params);
    }

    public static Observable<Course> getCourseData(Map<String,String> params) {
        return service.getCourse(params);
    }*/

    //地址
    public static final String BASE_URL = "http://192.168.253.16/thinkcmff_tea/";

    private static OkHttpClient mOkHttpClient;
    private Retrofit retrofit;

    public static ApiManager builder() {
        return new ApiManager();
    }

    public Service getService() {
        return retrofit.create(Service.class);
    }

    private ApiManager() {
        initOkHttpClient();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private void initOkHttpClient() {
        if (mOkHttpClient == null) {
            synchronized (ApiManager.class) {
                if (mOkHttpClient == null) {
                    // 指定缓存路径,缓存大小32Mb
                    /*Cache cache = new Cache(new File(MyApplication.getContext().getCacheDir(), "HttpCache"),
                            1024 * 1024 * 32);*/
                    mOkHttpClient = new OkHttpClient.Builder()
                            /*.cache(cache)*/
                            /*.addInterceptor(mRewriteCacheControlInterceptor)
                            .addNetworkInterceptor(mRewriteCacheControlInterceptor)*/
                            .retryOnConnectionFailure(true)
                            .connectTimeout(15, TimeUnit.SECONDS)
                            .readTimeout(15,TimeUnit.SECONDS)
                            .build();
                }
            }
        }
    }

    // 云端响应头拦截器，用来配置缓存策略
    /*private Interceptor mRewriteCacheControlInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!NetUtil.isNetworkConnected()) {
                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
            }
            Response originalResponse = chain.proceed(request);
            if (NetUtil.isNetworkConnected()) {
                //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
                String cacheControl = request.cacheControl().toString();
                return originalResponse.newBuilder().header("Cache-Control", cacheControl)
                        .removeHeader("Pragma").build();
            } else {
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, no-cache, max-stale=" + CACHE_STALE_LONG)
                        .removeHeader("Pragma").build();
            }
        }
    };*/
}
