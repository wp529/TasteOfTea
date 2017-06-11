package edu.pzhu.system.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.pzhu.system.R;
import edu.pzhu.system.adapter.SelectResultAdapter;
import edu.pzhu.system.adapter.TeaInfoListAdapter;
import edu.pzhu.system.api.ApiManager;
import edu.pzhu.system.base.BaseActivity;
import edu.pzhu.system.model.selectresult.SelectResultBean;
import edu.pzhu.system.presenter.SelectResultPresenter;

public class SelectResultActivity extends BaseActivity<SelectResultBean> {

    @Bind(R.id.select_result_top_back)
    ImageView selectResultTopBack;
    @Bind(R.id.tv_select_result_name)
    TextView tvSelectResultName;
    @Bind(R.id.tv_select_result_address)
    TextView tvSelectResultAddress;
    @Bind(R.id.tv_select_result_time)
    TextView tvSelectResultTime;
    @Bind(R.id.tv_select_result_price)
    TextView tvSelectResultPrice;
    @Bind(R.id.tv_select_result_location)
    TextView tvSelectResultLocation;
    @Bind(R.id.tv_select_result_people)
    TextView tvSelectResultPeople;
    @Bind(R.id.iv_select_result_pic)
    ImageView ivSelectResultPic;
    @Bind(R.id.rv_select_result_list)
    RecyclerView rvSelectResultList;
    @Bind(R.id.tv_select_result_look_location)
    TextView tvSelectResultLookLocation;
    ArrayList<SelectResultBean.DatasEntity.ListsEntity> list = new ArrayList<>();

    private String longtitude;
    private String latitude;
    private String teaPark;
    private String location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_result);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();
        String number_sn = bundle.getString("number_sn");
        SelectResultPresenter presenter = new SelectResultPresenter(this);
        Map<String, String> map = new HashMap<>();
        map.put("number_sn", number_sn);
        presenter.getSelectResult(map);
        setLisener();
    }

    private void setLisener() {
        selectResultTopBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @OnClick(R.id.tv_select_result_look_location)
    public void click(View v) {
        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra("la", latitude);
        intent.putExtra("lo", longtitude);
        intent.putExtra("park", teaPark);
        intent.putExtra("location", location);
        startActivity(intent);
    }

    @Override
    public void loadDataSuccess(SelectResultBean data, int requestCode) {
        //Log.e("===========",data.getCode()+"");
        SelectResultBean.DatasEntity.InfoEntity info = data.getDatas().getInfo();
        tvSelectResultName.setText(info.getName());
        tvSelectResultAddress.setText(info.getIntroduce_place());
        tvSelectResultTime.setText(info.getCreate_time());
        tvSelectResultPrice.setText(info.getPrice());
        tvSelectResultLocation.setText(info.getLocation());
        tvSelectResultPeople.setText(info.getTea_park());
        longtitude = info.getLongtitude();
        latitude = info.getLatitude();
        teaPark = info.getTea_park();
        location = info.getLocation();
        List<SelectResultBean.DatasEntity.ListsEntity> lists = data.getDatas().getLists();
        for (int i = 0; i < lists.size(); i++) {
            list.add(lists.get(i));
        }
        rvSelectResultList.setLayoutManager(new LinearLayoutManager(this));
        SelectResultAdapter adapter = new SelectResultAdapter(this, list);
        rvSelectResultList.setAdapter(adapter);
    }
}


























