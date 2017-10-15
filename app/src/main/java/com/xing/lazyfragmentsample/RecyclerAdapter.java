package com.xing.lazyfragmentsample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

    private List<CoderBean> dataList;

    public RecyclerAdapter(Context context, List<CoderBean> list) {
        this.context = context;
        dataList = list;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_recycler, null);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CoderBean coderBean = dataList.get(position);
        List<String> images = coderBean.getImages();
        if (images != null) {
            String url = images.get(0);
            Glide.with(context).load(url).into(((ItemViewHolder) holder).imageView);
        }
        ((ItemViewHolder) holder).textView.setText(coderBean.getDesc());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        TextView textView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_image);
            textView = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

}