package com.aigoule.starapp.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.aigoule.starapp.R;
import com.aigoule.starapp.model.AllvidesModel;
import java.util.List;

public class Titlethemadapter extends  RecyclerView.Adapter<Titlethemadapter.MyHolder> {
    private Context contaxt;
    private List<AllvidesModel.DataBean> data;

    public Titlethemadapter(Context context, List<AllvidesModel.DataBean> data){
        this.contaxt = context;
        this.data=data;
    }
    @NonNull
    @Override
    public Titlethemadapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(contaxt).inflate(R.layout.item_tv,parent,false);
        return  new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.textView.setText(data.get(position).getName());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (data.get(position).isIfSelect()){
                    data.get(position).setIfSelect(false);
                }else{
                    data.get(position).setIfSelect(true);
                }

                for (int i=0;i<data.size();i++){
                    if (data.get(position).isIfSelect()){
                        holder.textView.setTextColor(contaxt.getColor(R.color.rb_yellow));
                    }else{
                        holder.textView.setTextColor(contaxt.getColor(R.color.rb_gray));
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return null==data?0:data.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView textView;
        private MyHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_theme);
        }
    }


}
