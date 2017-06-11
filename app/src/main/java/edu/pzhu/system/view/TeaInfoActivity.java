package edu.pzhu.system.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import edu.pzhu.system.R;
import edu.pzhu.system.adapter.TeaInfoListAdapter;
import edu.pzhu.system.base.BaseActivity;
import edu.pzhu.system.model.teainfo.TeaInfoBean;
import edu.pzhu.system.presenter.TeaInfoListPresenter;

public class TeaInfoActivity extends BaseActivity<TeaInfoBean> {
    @Bind(R.id.rv_tea_info_list)
    RecyclerView rvTeaInfoList;
    private TeaInfoListPresenter presenter;
    ArrayList<TeaInfoBean> teaInfoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tea_info);
        presenter = new TeaInfoListPresenter(this);
        Map<String,String> tepMap = new HashMap<>();
        tepMap.put("Page","0");
        tepMap.put("Perpage","20");
        presenter.getTeaInfoList(tepMap);
        ButterKnife.bind(this);
    }


    @Override
    public void loadDataSuccess(TeaInfoBean data, int requestCode) {
        //Log.e("=============",data.getCode()+"");
        teaInfoList.add(data);
        setAdapter(data);
    }

    private void setAdapter(final TeaInfoBean data) {
        rvTeaInfoList.setLayoutManager(new LinearLayoutManager(this));
        TeaInfoListAdapter adapter = new TeaInfoListAdapter(this,teaInfoList);
        adapter.setOnTeaInfoItemClikeListener(new TeaInfoListAdapter.onTeaInfoItemClikeListener() {
            @Override
            public void ItemCliked(int teaNumber) {
                Intent intent = new Intent(TeaInfoActivity.this,TeaInfoDetailActivity.class);
                Bundle bundle = new Bundle();
                //bundle.putSerializable("teaInfoBean",data);
                bundle.putString("discribe",data.getDatas().getLists().get(teaNumber).getDiscribe());
                bundle.putString("webUrl",teaInfoList.get(teaNumber).getDatas().getLists().get(teaNumber).getWeb_url());
                bundle.putString("time",data.getDatas().getLists().get(teaNumber).getCreate_time());
                bundle.putString("cover",data.getDatas().getLists().get(teaNumber).getCover());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        rvTeaInfoList.setAdapter(adapter);
    }
}
