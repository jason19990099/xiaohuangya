package com.aigoule.starapp.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.aigoule.starapp.R;
import com.aigoule.starapp.model.PicdetailModel;
import com.squareup.picasso.Picasso;


public class PicdetailAdapter extends BaseAdapter {
    private Context context;
    private PicdetailModel.DataBean data;
    private LayoutInflater layoutInflater;

    public PicdetailAdapter(Context context,PicdetailModel.DataBean data){
        this.context=context;
        this.data=data;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.getImage_list().size();
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
            view = layoutInflater.inflate(R.layout.layout_pic, parent, false);
            holder = new ViewHolder();
            holder.iv_pic=view.findViewById(R.id.iv_pic);
            view.setTag(holder);
        }else{
            holder = (ViewHolder)view.getTag();
        }

        Picasso.get().load(data.getImage_list().get(position))
                .placeholder(R.mipmap.ic_yellow)
                .error(R.mipmap.ic_yellow)
                .config(Bitmap.Config.RGB_565)
                .fit()
                .centerCrop()
                .into(holder.iv_pic);


        return view;
    }

    private class ViewHolder {

        private ImageView iv_pic;

    }
}
