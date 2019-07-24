package com.aigoule.starapp.fragment;

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

public class FourthFragment extends Fragment {
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_four, null);
        unbinder = ButterKnife.bind(this, view);



        return view;
    }
}
