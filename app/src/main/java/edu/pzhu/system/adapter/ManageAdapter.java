package edu.pzhu.system.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import edu.pzhu.system.R;
import edu.pzhu.system.model.manager.ManagerBean;

public class ManageAdapter extends RecyclerView.Adapter<ManageAdapter.ManageViewHolder> {
    //获取到的数据
    private List<ManagerBean.DatasEntity.ListsEntity> list;
    private LayoutInflater inflater;
    private onCouldClickItemClikedListener listener;
    private Context context;

    public ManageAdapter(Context context, ArrayList<ManagerBean.DatasEntity.ListsEntity> list) {
        this.list = list;
        this.context = context;
        this.inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ManageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.manage_list_item, parent, false);
        ManageViewHolder viewHolder = new ManageViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ManageViewHolder holder, final int position) {
        holder.tvTeaNumber.setText(list.get(position).getNumber_sn());
        holder.tvTeaTime.setText(list.get(position).getCreate_time());
        if("0".equals(list.get(position).getStatus())){
            holder.tvTeaStatus.setText(list.get(position).getString());
            holder.rlManageListRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener!=null){
                        listener.ItemCliked(list.get(position).getNumber_sn());
                    }
                }
            });
        }else if("1".equals(list.get(position).getStatus())){
            holder.tvTeaStatus.setText(list.get(position).getString());
        }
        /*holder.tvTeaStatus.setText(list.get(position).getStatus());
        if("进行中".equals(list.get(position).getStatus())){
            holder.rlManageListRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        listener.ItemCliked(list.get(position).getNumber());
                    }
                }
            });
        }*/
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ManageViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_tea_number)
        TextView tvTeaNumber;
        @Bind(R.id.tv_tea_time)
        TextView tvTeaTime;
        @Bind(R.id.tv_tea_status)
        TextView tvTeaStatus;
        @Bind(R.id.rl_manage_list_root)
        RelativeLayout rlManageListRoot;

        public ManageViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }

    public void setOnCouldClickItemClikedListener(onCouldClickItemClikedListener listener){
        this.listener = listener;
    }

    public interface onCouldClickItemClikedListener{
        void ItemCliked(String teaNumber);
    }
}
