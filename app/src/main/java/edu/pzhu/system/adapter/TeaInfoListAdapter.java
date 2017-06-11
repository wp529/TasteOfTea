package edu.pzhu.system.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import edu.pzhu.system.R;
import edu.pzhu.system.model.teainfo.TeaInfoBean;

public class TeaInfoListAdapter extends RecyclerView.Adapter<TeaInfoListAdapter.TeaInfoViewHolder> {
    //获取到的数据
    private List<TeaInfoBean> list;
    private LayoutInflater inflater;
    private onTeaInfoItemClikeListener listener;
    private Context context;

    public TeaInfoListAdapter(Context context, ArrayList<TeaInfoBean> list) {
        this.list = list;
        this.context = context;
        this.inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        /*list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            TeaInfoBean bean = new TeaInfoBean();
            list.add(bean);
        }*/
    }

    @Override
    public TeaInfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.tea_info_list_item, parent, false);
        TeaInfoViewHolder viewHolder = new TeaInfoViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TeaInfoViewHolder holder, final int position) {
        Picasso.with(context).load(list.get(position).getDatas().getLists().get(position).getCover())
                .fit()
                .placeholder(R.drawable.login_bg)
                .error(R.drawable.login_bg)
                .into(holder.ivTeaInfoPic);
        holder.tvTeaInfoTitle.setText(list.get(position).getDatas().getLists().get(position).getTitle());
        holder.tvTeaInfoContent.setText(list.get(position).getDatas().getLists().get(position).getDiscribe());
        holder.tvTeaInfoTime.setText(list.get(position).getDatas().getLists().get(position).getCreate_time());
            holder.llTeaInfoRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.ItemCliked(position);
                    }
                }
            });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class TeaInfoViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_tea_info_pic)
        ImageView ivTeaInfoPic;
        @Bind(R.id.tv_tea_info_title)
        TextView tvTeaInfoTitle;
        @Bind(R.id.tv_tea_info_content)
        TextView tvTeaInfoContent;
        @Bind(R.id.tv_tea_info_time)
        TextView tvTeaInfoTime;
        @Bind(R.id.ll_tea_info_root)
        LinearLayout llTeaInfoRoot;
        public TeaInfoViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }

    public void setOnTeaInfoItemClikeListener(onTeaInfoItemClikeListener listener) {
        this.listener = listener;
    }

    public interface onTeaInfoItemClikeListener {
        void ItemCliked(int teaNumber);
    }

}
