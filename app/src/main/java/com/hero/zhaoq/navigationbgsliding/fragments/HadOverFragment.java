package com.hero.zhaoq.navigationbgsliding.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hero.zhaoq.navigationbgsliding.R;

public class HadOverFragment extends BaseFragment {

    public HadOverFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_had_over, container, false);
    }


    @Override
    public String getFragmentTitle() {
        return "已关闭";
    }
}
