package com.aigoule.starapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aigoule.starapp.R;
import com.aigoule.starapp.api.HttpCallback;
import com.aigoule.starapp.api.HttpRequest;
import com.aigoule.starapp.model.PlayRecordsModel;
import com.aigoule.starapp.model.UpdataModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FictionFragment extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_text)
    TextView tvText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fiction, null);
        unbinder = ButterKnife.bind(this, view);
        getFictiondetail("7");
        return view;
    }

    private void getFictiondetail(String id) {
        HttpRequest.getInstance().getFictionDetail(FictionFragment.this,id,
                new HttpCallback<PlayRecordsModel>() {
                    @Override
                    public void onSuccess(PlayRecordsModel data) {

                    }

                    @Override
                    public void onFailure(int msgCode, String errorMsg) {
                        Toast.makeText(getActivity(), errorMsg, Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
