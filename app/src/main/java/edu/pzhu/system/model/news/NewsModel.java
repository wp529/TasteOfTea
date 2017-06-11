package edu.pzhu.system.model.news;


import java.util.Map;
import edu.pzhu.system.base.BaseModel;
import edu.pzhu.system.base.BaseSubscriber;
import edu.pzhu.system.base.IBasePresenter;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class NewsModel extends BaseModel<News> {

    @Override
    public void requestData(IBasePresenter<News> callBack, int requestCode, Map<String, String> params) {
        service.getNews(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<>(callBack, requestCode));

    }
}
