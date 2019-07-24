package com.aigoule.starapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.aigoule.starapp.R;
import com.aigoule.starapp.adapter.ThemeVideoListAdapter;
import com.aigoule.starapp.api.HttpCallback;
import com.aigoule.starapp.api.HttpRequest;
import com.aigoule.starapp.model.AllvideoThemeModel;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ThematicVideoFragment extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.lv_videotheme)
    ListView lvVideotheme;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thematicvideo, null);
        unbinder = ButterKnife.bind(this, view);
        getAllTheme();
        return view;
    }

    private void getAllTheme() {
        HttpRequest.getInstance().getALLtheme(ThematicVideoFragment.this, new HttpCallback<AllvideoThemeModel>() {
            @Override
            public void onSuccess(AllvideoThemeModel data) {
                ThemeVideoListAdapter adapter = new ThemeVideoListAdapter(data.getData(), getActivity());
                lvVideotheme.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(int msgCode, String errorMsg) {

            }
        });
    }


}
