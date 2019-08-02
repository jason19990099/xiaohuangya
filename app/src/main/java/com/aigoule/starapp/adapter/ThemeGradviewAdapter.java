package com.aigoule.starapp.adapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aigoule.starapp.R;
import com.aigoule.starapp.event.GoWhereEvent;
import com.aigoule.starapp.event.SecondEvent;
import com.aigoule.starapp.model.FirstpageModel;
import com.aigoule.starapp.model.MainTheme;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class ThemeGradviewAdapter extends BaseAdapter {
    private List<FirstpageModel.DataBean.ListBean> data;
    private LayoutInflater layoutInflater;
    public ThemeGradviewAdapter(List<FirstpageModel.DataBean.ListBean> data,Context context){
        this.data=data;
        layoutInflater = LayoutInflater.from(context);

    }
    @Override
    public int getCount() {
        return null==data?0:data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.adaper_them, parent, false);
            holder = new ViewHolder();
            holder.tv_theme=view.findViewById(R.id.tv_theme);
            holder.iv_pic=view.findViewById(R.id.iv_pic);
            holder.ll_adapter=view.findViewById(R.id.ll_adapter);
            view.setTag(holder);

        }else{
            holder = (ViewHolder)view.getTag();
        }
        holder.tv_theme.setText(data.get(position).getName());
        Picasso.get().load(data.get(position).getImage())
                .placeholder(R.mipmap.ic_yellow)
                .error(R.mipmap.ic_yellow)
                .config(Bitmap.Config.RGB_565)
                .fit()
                .centerCrop()
                .into(holder.iv_pic);
        holder.ll_adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky(new GoWhereEvent(1));
            }
        });

        return view;
    }

    private class ViewHolder {
        private TextView tv_theme;
        private ImageView iv_pic;
        private LinearLayout ll_adapter;
    }
}
