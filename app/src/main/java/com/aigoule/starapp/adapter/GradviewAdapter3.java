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
import android.widget.Toast;
import com.aigoule.starapp.R;
import com.aigoule.starapp.event.playerEvent;
import com.aigoule.starapp.model.FirstpageModel;
import com.squareup.picasso.Picasso;
import org.greenrobot.eventbus.EventBus;
import java.util.List;

public class GradviewAdapter3 extends BaseAdapter {
    private List<FirstpageModel.DataBean.ListBean> data ;
    private LayoutInflater layoutInflater;
    private Context context;

    public GradviewAdapter3(List<FirstpageModel.DataBean.ListBean> data, Context context){
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
            view = layoutInflater.inflate(R.layout.item_video2, parent, false);
            holder = new ViewHolder();
            holder.tv_video=view.findViewById(R.id.tv_video);
            holder.iv_video=view.findViewById(R.id.iv_video);
            holder.ll_video=view.findViewById(R.id.ll_video);
            holder.tv_wuma=view.findViewById(R.id.tv_wuma);
            view.setTag(holder);
        }else{
            holder = (ViewHolder)view.getTag();
        }
        holder.tv_video.setText(data.get(position).getName());

        if (!data.get(position).getImage().equals(""))
        Picasso.get().load(data.get(position).getImage())
                .placeholder(R.mipmap.ic_yellow)
                .error(R.mipmap.ic_yellow)
                .config(Bitmap.Config.RGB_565)
                .fit()
                .centerCrop()
                .into(holder.iv_video);
        if (null!=data.get(position).getHas_code())
        holder.tv_wuma.setText(data.get(position).getHas_code());

        holder.ll_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (null==data.get(position).getVideo_id()||data.get(position).getVideo_id().equals("") ||null==data.get(position).getName()){
                        Toast.makeText(context,"播放链接没办法播放",Toast.LENGTH_LONG).show();
                        return;
                    }
                    playerEvent  playerEvent=new playerEvent(data.get(position).getVideo_id(),data.get(position).getName());
                    EventBus.getDefault().postSticky(playerEvent);
            }
        });

            return view;
    }

    private class ViewHolder {
        private TextView tv_video,tv_wuma;
        private ImageView iv_video;
        private LinearLayout ll_video;
    }
}
