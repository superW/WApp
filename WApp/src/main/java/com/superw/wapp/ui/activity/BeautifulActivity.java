package com.superw.wapp.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.superw.wapp.R;
import com.superw.wapp.view.swipeback.SwipeBackActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Call;
import okhttp3.Response;

public class BeautifulActivity extends SwipeBackActivity {

    private ImageView ivShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beautiful);
        initView();


        OkHttpUtils.post().url("http").build().execute(new Callback() {
            @Override
            public Object parseNetworkResponse(Response response) throws Exception {

                return null;
            }

            @Override
            public void onError(Call call, Exception e) {

            }

            @Override
            public void onResponse(Object response) {

            }
        });

    }

    private void initView() {
        ivShow = (ImageView) findViewById(R.id.ivShow);
    }
}
