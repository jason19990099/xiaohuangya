package com.aigoule.starapp.adapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.aigoule.starapp.R;
import com.aigoule.starapp.event.GoWhereEvent;
import com.aigoule.starapp.model.FirstpageModel;
import com.aigoule.starapp.utils.LogUtil;
import com.squareup.picasso.Picasso;
import org.greenrobot.eventbus.EventBus;
import java.util.List;

public class ListAllAdapter extends BaseAdapter {
    private List<FirstpageModel.DataBean> data ;
    private Context context;
    private LayoutInflater layoutInflater;
    private boolean open;

    public ListAllAdapter(List<FirstpageModel.DataBean> data,Context context,boolean open){
        this.open=open;
        this.data=data;
        this.context=context;
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
            view = layoutInflater.inflate(R.layout.adapter_home_all, parent, false);
            holder = new ViewHolder();
            holder.iv_home=view.findViewById(R.id.iv_home);
            holder.iv_more=view.findViewById(R.id.iv_more);
            holder.tv_title=view.findViewById(R.id.tv_title);
            holder.gv_home=view.findViewById(R.id.gv_home);
            holder.rl_line=view.findViewById(R.id.rl_line);
            view.setTag(holder);
        }else{
            holder = (ViewHolder)view.getTag();
        }

        if (!data.get(position).getIcon_image().equals(""))
            Picasso.get().load(data.get(position).getIcon_image())
                    .placeholder(R.mipmap.ic_yellow)
                    .error(R.mipmap.ic_yellow)
                    .config(Bitmap.Config.RGB_565)
                    .fit()
                    .centerCrop()
                    .into(holder.iv_home);

        holder.tv_title.setText(data.get(position).getTitle());

        holder.iv_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky(new GoWhereEvent(1));
            }
        });

         holder.gv_home.setNumColumns(data.get(position).getLine());

        if (data.get(position).getPart()==1){
            holder.rl_line.setVisibility(View.GONE);
            ThemeGradviewAdapter adapter = new ThemeGradviewAdapter(data.get(position).getList(),context);
            holder.gv_home.setAdapter(adapter);
        } else if (data.get(position).getPart()==2){
            holder.rl_line.setVisibility(View.GONE);
            ThemeGradviewAdapter2 adapter = new ThemeGradviewAdapter2(data.get(position).getList(), context,open);
            holder.gv_home.setAdapter(adapter);
        }else if (data.get(position).getPart()==3){
            holder.rl_line.setVisibility(View.VISIBLE);
            GradviewAdapter3 adapter = new GradviewAdapter3(data.get(position).getList(), context);
            holder.gv_home.setAdapter(adapter);
        }else {
            holder.rl_line.setVisibility(View.VISIBLE);
            GradviewAdapter2 adapter = new GradviewAdapter2(data.get(position).getList(), context);
            holder.gv_home.setAdapter(adapter);
        }
        holder.gv_home.setFocusable(false);
        return view;
    }

    private class ViewHolder {
        private ImageView iv_home;
        private TextView iv_more;
        private TextView tv_title;
        private com.aigoule.starapp.views.MyGridView gv_home;
        private RelativeLayout rl_line;
    }


}
