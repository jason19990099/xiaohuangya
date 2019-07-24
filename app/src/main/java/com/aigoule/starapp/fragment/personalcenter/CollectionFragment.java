package com.aigoule.starapp.fragment.personalcenter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aigoule.starapp.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * 收藏記錄
 */
public class CollectionFragment extends Fragment {
    Unbinder unbinder;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personset, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

}
