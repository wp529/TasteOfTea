package edu.pzhu.system.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.pzhu.system.MyApplication;
import edu.pzhu.system.R;
import edu.pzhu.system.adapter.ManageAdapter;
import edu.pzhu.system.base.BaseFragment;
import edu.pzhu.system.model.manager.ManagerBean;
import edu.pzhu.system.presenter.ManagerPresenter;
import edu.pzhu.system.view.AddTeaBatchActivity;
import edu.pzhu.system.view.ManageActivity;

public class ManagerFragment extends BaseFragment<ManagerBean> {
    private View rootView;
    private RecyclerView managerList;
    private ManagerPresenter presenter;
    ArrayList<ManagerBean.DatasEntity.ListsEntity> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            View view = inflater.inflate(R.layout.fragment_manager, null);
            managerList = (RecyclerView) view.findViewById(R.id.rv_manager_list);
            ImageView add = (ImageView) view.findViewById(R.id.iv_top_add);
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getActivity(),AddTeaBatchActivity.class));
                }
            });

            /*managerList.setLayoutManager(new LinearLayoutManager(getActivity()));
            ManageAdapter adapter = new ManageAdapter(getActivity(),null);
            adapter.setOnCouldClickItemClikedListener(new ManageAdapter.onCouldClickItemClikedListener() {
                @Override
                public void ItemCliked(String teaNumber) {
                    Intent intent = new Intent(getActivity(),ManageActivity.class);
                    intent.putExtra("tea_number",teaNumber);
                    startActivity(intent);
                }
            });
            managerList.setAdapter(adapter);*/

            rootView = view;
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }


    @Override
    public void loadDataSuccess(ManagerBean data, int requestCode) {
        Log.e("============",requestCode+"");
        list.clear();
        ArrayList<ManagerBean.DatasEntity.ListsEntity> lists = data.getDatas().getLists();
        //Log.e("===========",lists.size()+"");
        for(int i=0;i<lists.size();i++){
            list.add(lists.get(i));
        }
        managerList.setLayoutManager(new LinearLayoutManager(getActivity()));
        ManageAdapter adapter = new ManageAdapter(getActivity(),list);
        managerList.setAdapter(adapter);
        adapter.setOnCouldClickItemClikedListener(new ManageAdapter.onCouldClickItemClikedListener() {
            @Override
            public void ItemCliked(String teaNumber) {
                Intent intent = new Intent(getActivity(),ManageActivity.class);
                intent.putExtra("tea_number",teaNumber);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        presenter = new ManagerPresenter(this);
            /*Map<String, String> params = new HashMap<>();
            params.put("username", loginUsername);
            params.put("password", loginPassword);
            presenter.getManageListData(params);*/
        Map<String,String> map = new HashMap<>();
        map.put("mid", MyApplication.MID);
        map.put("page","0");
        map.put("perpage","20");
        presenter.getManageListData(map);
        super.onResume();
    }
}
