package com.aigoule.starapp.adapter;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.aigoule.starapp.R;
import com.aigoule.starapp.activity.VideoAllActivitry;
import com.aigoule.starapp.model.AllvideoThemeModel;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 *   专题视频list的适配器
 */
public class ThemeVideoListAdapter extends BaseAdapter {
    private List<AllvideoThemeModel.DataBean> data;
    private LayoutInflater layoutInflater;
    private Context context;
    public ThemeVideoListAdapter(List<AllvideoThemeModel.DataBean> data, Context context){
        this.context=context;
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
            view = layoutInflater.inflate(R.layout.adapter_themecideos, parent, false);
            holder = new ViewHolder();
            holder.tv_name=view.findViewById(R.id.tv_name);
            holder.iv_pic=view.findViewById(R.id.iv_pic);
            holder.tv_more=view.findViewById(R.id.tv_more);
            holder.gv_video=view.findViewById(R.id.gv_video);
            view.setTag(holder);
        }else{
            holder = (ViewHolder)view.getTag();
        }

        holder.tv_name.setText(data.get(position).getTitle());
        Picasso.get().load(data.get(position).getLogo())
                .placeholder(R.mipmap.ic_yellow)
                .error(R.mipmap.ic_yellow)
                .config(Bitmap.Config.RGB_565)
                .fit()
                .centerCrop()
                .into(holder.iv_pic);
        holder.tv_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, VideoAllActivitry.class);
                intent.putExtra("themeType",data.get(position).getMore());
                context.startActivity(intent);
            }
        });


        ThematicVideoAdapter adapter=new  ThematicVideoAdapter(data.get(position).getList(),context);
        holder.gv_video.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return view;
    }

    private class ViewHolder {
        private TextView tv_name;
        private TextView tv_more;
        private ImageView iv_pic;
        private com.aigoule.starapp.views.MyGridView gv_video;
    }
}
