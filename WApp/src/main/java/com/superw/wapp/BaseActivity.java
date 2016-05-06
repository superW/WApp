package com.superw.wapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by wangyc-e on 2016/5/3. */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(getLocalClassName());
    }
}
