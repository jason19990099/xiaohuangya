package com.aigoule.starapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aigoule.starapp.R;
import com.aigoule.starapp.model.FictionModel;
import com.aigoule.starapp.utils.LogUtil;

public class FictionAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private FictionModel data;

    public FictionAdapter(Context context, FictionModel data){
         this.data=data;
        layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return null==data?0:data.getData().getList().size();
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
            view = layoutInflater.inflate(R.layout.adapter_fiction, parent, false);
            holder = new ViewHolder();
            holder.tv_fictionname=view.findViewById(R.id.tv_fictionname);
            holder.ll_fiction=view.findViewById(R.id.ll_fiction);

            view.setTag(holder);
        }else{
            holder = (ViewHolder)view.getTag();
        }

        holder.tv_fictionname.setText(data.getData().getList().get(position).getTitle());
        holder.ll_fiction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }

    private class ViewHolder {
        private TextView tv_fictionname;
        private LinearLayout ll_fiction;

    }
}
