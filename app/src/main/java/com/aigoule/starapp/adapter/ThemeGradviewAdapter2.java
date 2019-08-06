package com.aigoule.starapp.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.aigoule.starapp.R;
import com.aigoule.starapp.event.GoWhereEvent;
import com.aigoule.starapp.event.OpenEvent;
import com.aigoule.starapp.model.FirstpageModel;
import org.greenrobot.eventbus.EventBus;
import java.util.List;



public class ThemeGradviewAdapter2 extends BaseAdapter {
    private List<FirstpageModel.DataBean.ListBean> data;
    private LayoutInflater layoutInflater;
    private boolean open;
    public ThemeGradviewAdapter2(List<FirstpageModel.DataBean.ListBean> data, Context context,boolean open){
        this.data=data;
        layoutInflater = LayoutInflater.from(context);
        this.open =open;
    }

    @Override
    public int getCount() {
       if(open){
           return  data.size();
       }else{
           if (data.size()>=6){
               return  6;
           }else {
               return data.size();
           }


       }

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
            view = layoutInflater.inflate(R.layout.adaper_them2, parent, false);
            holder = new ViewHolder();
            holder.tv_theme=view.findViewById(R.id.tv_theme);
            holder.ll_adapter=view.findViewById(R.id.ll_adapter);
            view.setTag(holder);
        }else{
            holder = (ViewHolder)view.getTag();
        }

        if (open){
            if (position==data.size()-1){
                holder.tv_theme.setText("收起");
            }else{
                holder.tv_theme.setText(data.get(position).getName());
            }

        }else {
            if (position==5){
                holder.tv_theme.setText("展开");
            }else {
                holder.tv_theme.setText(data.get(position).getName());
            }
        }

        holder.ll_adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (open){
                    if (position==data.size()-1){
                        open=false;
                        EventBus.getDefault().postSticky(new OpenEvent(open));
                    }else{
                        EventBus.getDefault().postSticky(new GoWhereEvent(1));
                    }

                }else{
                    if (position==5){
                        //发消息展开
                        open=true;
                        EventBus.getDefault().postSticky(new OpenEvent(open));
                    }else{
                        EventBus.getDefault().postSticky(new GoWhereEvent(1));
                    }

                }

            }
        });

        return view;
    }

    private class ViewHolder {
        private TextView tv_theme;
        private LinearLayout ll_adapter;
    }
}
