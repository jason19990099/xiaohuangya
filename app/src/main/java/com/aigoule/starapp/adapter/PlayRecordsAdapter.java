package com.aigoule.starapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aigoule.starapp.R;
import com.aigoule.starapp.event.playerEvent;
import com.aigoule.starapp.model.PlayRecordsModel;

import org.greenrobot.eventbus.EventBus;

public class PlayRecordsAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private PlayRecordsModel playRecordsModel;

    public PlayRecordsAdapter(Context context,PlayRecordsModel playRecordsModel){
        layoutInflater = LayoutInflater.from(context);
        this.playRecordsModel=playRecordsModel;
    }

    @Override
    public int getCount() {
        return null==playRecordsModel?0:playRecordsModel.getData().getData().size();
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
            view = layoutInflater.inflate(R.layout.adapter_platrecords, parent, false);
            holder = new ViewHolder();
            holder.tv_id=view.findViewById(R.id.tv_id);
            holder.ll_play=view.findViewById(R.id.ll_play);
            holder.tv_name=view.findViewById(R.id.tv_name);
            view.setTag(holder);

        }else{
            holder = (ViewHolder)view.getTag();
        }
        holder.tv_id.setText(String.valueOf(playRecordsModel.getData().getData().get(position).getId()));
        holder.tv_name.setText(playRecordsModel.getData().getData().get(position).getName());
        holder.ll_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerEvent playerEvent=new playerEvent(playRecordsModel.getData().getData().get(position).getUrl(),playRecordsModel.getData().getData().get(position).getName());
                EventBus.getDefault().postSticky(playerEvent);
            }
        });
        return view;
    }

    private class ViewHolder {
        private TextView tv_id;
        private TextView tv_name;
        private LinearLayout ll_play;
    }
}
