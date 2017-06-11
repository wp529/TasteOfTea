package edu.pzhu.system.presenter;

import java.util.Map;

import edu.pzhu.system.base.BasePresenter;
import edu.pzhu.system.base.IBaseView;
import edu.pzhu.system.model.teainfo.TeaInfoBean;
import edu.pzhu.system.model.teainfo.TeaInfoModel;

/**
 * Created by Administrator on 2017/5/13.
 */
public class TeaInfoListPresenter extends BasePresenter<TeaInfoBean> {

    private final TeaInfoModel teaInfoModel;

    /**
     * 构造方法
     *
     * @param view 具体业务的接口对象
     */
    public TeaInfoListPresenter(IBaseView view) {
        super(view);
        teaInfoModel = new TeaInfoModel();
    }

    public void getTeaInfoList(Map<String, String> params) {
        teaInfoModel.requestData(this, 1, params);
    }
}
