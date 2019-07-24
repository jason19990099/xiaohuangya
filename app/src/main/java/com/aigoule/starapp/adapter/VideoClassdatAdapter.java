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
import com.aigoule.starapp.event.playerEvent;
import com.aigoule.starapp.model.VideoclassdataModel;
import com.squareup.picasso.Picasso;
import org.greenrobot.eventbus.EventBus;

/**
 *  获取某一类视频
 */
public class VideoClassdatAdapter extends BaseAdapter {
    private Context context;
    private VideoclassdataModel.DataBean data;
    private LayoutInflater layoutInflater;

    public VideoClassdatAdapter(Context context,VideoclassdataModel.DataBean data){
        this.context=context;
        this.data=data;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return null==data.getList()?0:data.getList().size();
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
            view = layoutInflater.inflate(R.layout.item_video, parent, false);
            holder = new ViewHolder();
            holder.tv_video=view.findViewById(R.id.tv_video);
            holder.iv_video=view.findViewById(R.id.iv_video);
            holder.ll_video=view.findViewById(R.id.ll_video);
            view.setTag(holder);

        }else{
            holder = (ViewHolder)view.getTag();
        }
        holder.tv_video.setText(data.getList().get(position).getName());
        Picasso.get().load(data.getList().get(position).getImage())
                .placeholder(R.mipmap.ic_yellow)
                .error(R.mipmap.ic_yellow)
                .config(Bitmap.Config.RGB_565)
                .fit()
                .centerCrop()
                .into(holder.iv_video);
        holder.ll_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerEvent playerEvent=new playerEvent(data.getList().get(position).getVideo_id(),data.getList().get(position).getName());
                EventBus.getDefault().postSticky(playerEvent);
            }
        });

        return view;
    }


    private class ViewHolder {
        private TextView tv_video;
        private ImageView iv_video;
        private LinearLayout ll_video;
    }
}
