package com.hero.zhaoq.navigationbgsliding.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hero.zhaoq.navigationbgsliding.R;

public class OnDoingFragment extends BaseFragment {

    public OnDoingFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_on_doing, container, false);
    }

    @Override
    public String getFragmentTitle() {
        return "进行时";
    }
}
