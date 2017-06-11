package edu.pzhu.system.presenter;

import java.util.Map;

import edu.pzhu.system.base.BasePresenter;
import edu.pzhu.system.base.IBaseView;
import edu.pzhu.system.model.teainfodetail.TeaInfoDetailBean;
import edu.pzhu.system.model.teainfodetail.TeaInfoDetailModel;

/**
 * Created by Administrator on 2017/5/13.
 */
public class TeaInfoDetailPresenter extends BasePresenter<TeaInfoDetailBean> {

    private final TeaInfoDetailModel teaInfoDetailModel;

    /**
     * 构造方法
     *
     * @param view 具体业务的接口对象
     */
    public TeaInfoDetailPresenter(IBaseView view) {
        super(view);
        teaInfoDetailModel = new TeaInfoDetailModel();
    }

    public void getTeaInfoDetail(Map<String, String> params) {
        teaInfoDetailModel.requestData(this, 1, params);
    }
}
