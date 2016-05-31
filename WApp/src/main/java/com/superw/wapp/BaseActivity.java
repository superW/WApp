package com.superw.wapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyc-e on 2016/5/3. */
public class BaseActivity extends AppCompatActivity {

    private static List<Activity> activities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(getLocalClassName());

        add(this);


    }

    @Override
    protected void onDestroy() {
        remove(this);
        super.onDestroy();
    }

    protected void add(Activity activity) {
        if (!activities.contains(activity)) {
            activities.add(activity);
        }
    }

    protected void remove(Activity activity) {
        if (activities.contains(activity)) {
            activities.remove(activity);
        }
    }

    protected List<Activity> getAll(){
        return activities;
    }

    protected int size() {
        return activities.size();
    }

    /** 退出操作 */
    protected void exit(){
        for(Activity activity : activities){
            activity.finish();
        }
    }

    protected <T extends View>T findView(int id) {
        View v = super.findViewById(id);
        return (T) v;
    }
}
