package com.aigoule.starapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.aigoule.starapp.R;
import com.aigoule.starapp.activity.MainActivity;
import com.aigoule.starapp.activity.PersonalvideoActivity;
import com.aigoule.starapp.model.AllvideoThemeModel;
import com.squareup.picasso.Picasso;

import java.util.List;


public class ThematicVideoAdapter extends BaseAdapter {
    private  List<AllvideoThemeModel.DataBean.ListBean> list;
    private LayoutInflater layoutInflater;
    private Context context;

    public ThematicVideoAdapter(List<AllvideoThemeModel.DataBean.ListBean> list, Context context){
        this.context=context;
        this.list=list;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return null==list?0:list.size();
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
            view = layoutInflater.inflate(R.layout.adaper_videothem, parent, false);
            holder = new ViewHolder();
            holder.tv_name=view.findViewById(R.id.tv_theme);
            holder.iv_pic=view.findViewById(R.id.iv_pic);
            holder.ll_adapter=view.findViewById(R.id.ll_adapter);
            view.setTag(holder);
        }else{
            holder = (ViewHolder)view.getTag();
        }

        if (null!=list.get(position).getTitle())
        holder.tv_name.setText(list.get(position).getTitle());
        Picasso.get().load(list.get(position).getPicture())
                .placeholder(R.mipmap.ic_yellow)
                .error(R.mipmap.ic_yellow)
                .config(Bitmap.Config.RGB_565)
                .fit()
                .centerCrop()
                .into(holder.iv_pic);

        holder.ll_adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, PersonalvideoActivity.class);
                intent.putExtra("video_id",list.get(position).getTheme_id());
                context.startActivity(intent);
            }
        });

        return view;
    }


    private class ViewHolder {
        private TextView tv_name;
        private ImageView iv_pic;
        private LinearLayout ll_adapter;
    }




}
