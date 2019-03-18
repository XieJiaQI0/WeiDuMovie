package com.bw.weidumovie.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.bw.weidumovie.R;
import com.bw.weidumovie.bean.RmdyBean;
import com.facebook.drawee.view.SimpleDraweeView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1607c王晴
 * date 2019/3/15
 * Describe:
 */
public class RmdyAdapter extends RecyclerView.Adapter<RmdyAdapter.ViewHolder> {
    private Context context;
    private List<RmdyBean.ResultBean> list;

    public RmdyAdapter(Context context, List<RmdyBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.rmdy_item, null, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.rmdy_img.setImageURI(Uri.parse(list.get(i).getImageUrl()));
        viewHolder.rmdy_name.setText(list.get(i).getName());
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView rmdy_img;
        private final TextView rmdy_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rmdy_img = itemView.findViewById(R.id.rmdy_img);
            rmdy_name = itemView.findViewById(R.id.rmdy_name);
        }
    }
}
