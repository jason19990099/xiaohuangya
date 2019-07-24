package com.aigoule.starapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.aigoule.starapp.R;
import com.aigoule.starapp.adapter.PicClassdatAdapter;
import com.aigoule.starapp.api.HttpCallback;
import com.aigoule.starapp.api.HttpRequest;
import com.aigoule.starapp.model.AllpicModel;
import com.aigoule.starapp.model.PicModel;
import com.aigoule.starapp.utils.LogUtil;
import com.aigoule.starapp.views.MyGridView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ThirdFragment extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.rg_pic)
    RadioGroup rgPic;
    @BindView(R.id.gv_classdata)
    MyGridView gvClassdata;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, null);
        unbinder = ButterKnife.bind(this, view);
        getAllpicClass();
        return view;
    }

    /**
     * 获取全部分類
     */
    private void getAllpicClass() {
        HttpRequest.getInstance().getPicClass(ThirdFragment.this, new HttpCallback<AllpicModel>() {
            @Override
            public void onSuccess(AllpicModel data) {
                try{
                    getPic(String.valueOf(data.getData().get(0).getUrl()));
                }catch (Exception e){
                    e.printStackTrace();
                }

                int size=data.getData().size();
                for (int i=0;i<size;i++){
                    RadioButton tempButton = new RadioButton(getActivity());
//                    tempButton.setBackgroundResource(null);	// 设置RadioButton的背景图片
                    tempButton.setButtonDrawable(null);			// 设置按钮的样式
                    tempButton.setPadding(40, 0, 0, 0);           		// 设置文字距离按钮四周的距离
                    tempButton.setTextSize(15);
                    tempButton.setText(data.getData().get(i).getName());
                    tempButton.setTextColor(getResources().getColorStateList(R.color.selector_rb_txt_color));
                    rgPic.addView(tempButton, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                }
                rgPic.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        try{
                            int checkedids= rgPic.getCheckedRadioButtonId();
                            LogUtil.e("=========checkedId======"+checkedids);
                            getPic(String.valueOf(data.getData().get(checkedids-1).getUrl()));
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });

            }

            @Override
            public void onFailure(int msgCode, String errorMsg) {

            }
        });
    }


    /**
     * 获取某一类的相关图片
     */
    private void getPic(String id) {
        HttpRequest.getInstance().getOnePic(ThirdFragment.this, id, new HttpCallback<PicModel>() {
            @Override
            public void onSuccess(PicModel data) {
                PicClassdatAdapter adapter = new PicClassdatAdapter(getActivity(), data.getData().getData());
                gvClassdata.setAdapter(adapter);
            }

            @Override
            public void onFailure(int msgCode, String errorMsg) {
            }
        });
    }
}
