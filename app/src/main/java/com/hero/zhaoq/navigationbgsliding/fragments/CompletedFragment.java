package com.hero.zhaoq.navigationbgsliding.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hero.zhaoq.navigationbgsliding.R;


public class CompletedFragment extends BaseFragment {

    public CompletedFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_completed, container, false);
    }


    @Override
    public String getFragmentTitle() {
        return "已完成";
    }
}
