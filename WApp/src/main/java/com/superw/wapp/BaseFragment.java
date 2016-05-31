package com.superw.wapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wangyc-e on 2016/5/19.
 */
public abstract class BaseFragment extends Fragment {

    private View mView;

    public abstract int getLayoutId();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(getLayoutId(), container, false);
        return mView;
    }


    public <T> T getView(int id) {
        View view = mView.findViewById(id);
        return (T) view;
    }

}
