package com.superw.wapp.ui.activity;

import android.os.Bundle;

import com.superw.wapp.R;
import com.superw.wapp.view.swipeback.SwipeBackActivity;

public class SettingActivity extends SwipeBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }
}
