package edu.pzhu.system.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import edu.pzhu.system.R;
import edu.pzhu.system.model.selectresult.SelectResultBean;

public class SelectResultAdapter extends RecyclerView.Adapter<SelectResultAdapter.SelectResultViewHolder> {

    //获取到的数据
    private ArrayList<SelectResultBean.DatasEntity.ListsEntity> list;
    private LayoutInflater inflater;
    private Context context;

    public SelectResultAdapter(Context context, ArrayList<SelectResultBean.DatasEntity.ListsEntity> list) {
        this.context = context;
        this.list = list;
        this.inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public SelectResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.select_result_item, parent, false);
        SelectResultViewHolder viewHolder = new SelectResultViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SelectResultViewHolder holder, final int position) {
        if(position == 0){
            holder.ivInfoStatus.setImageResource(R.drawable.first);
        }else{
            holder.ivInfoStatus.setScaleType(ImageView.ScaleType.FIT_XY);
            holder.ivInfoStatus.setImageResource(R.drawable.other);
        }
        holder.tvInfoTime.setText(list.get(position).getCreate_time());
        holder.tvInfoHandle.setText(list.get(position).getString());
        if(list.get(position).getType().equals("1")){//浇水
            holder.tvInfoIcon.setImageResource(R.drawable.info_water);
        }else if(list.get(position).getType().equals("2")){//施肥
            holder.tvInfoIcon.setImageResource(R.drawable.info_fertilization);
        }else if(list.get(position).getType().equals("3")){//修剪
            holder.tvInfoIcon.setImageResource(R.drawable.info_prune);
        }else if(list.get(position).getType().equals("4")){//摘茶
            holder.tvInfoIcon.setImageResource(R.drawable.info_pick);
        }else if(list.get(position).getType().equals("5")){//施药
            holder.tvInfoIcon.setImageResource(R.drawable.info_pesticide);
        }else if(list.get(position).getType().equals("6")){//制茶
            holder.tvInfoIcon.setImageResource(R.drawable.info_fire);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class SelectResultViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_info_time)
        TextView tvInfoTime;
        @Bind(R.id.iv_info_status)
        ImageView ivInfoStatus;
        @Bind(R.id.tv_info_handle)
        TextView tvInfoHandle;
        @Bind(R.id.tv_info_icon)
        ImageView tvInfoIcon;

        public SelectResultViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }

}
