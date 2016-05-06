package com.superw.wapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.superw.wapp.BaseActivity;
import com.superw.wapp.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnSettingActivity = (Button) findViewById(R.id.btnSettingActivity);
        btnSettingActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SettingActivity.class));
            }
        });
        Button btnShowImageActivity = (Button) findViewById(R.id.btnShowImageActivity);
        btnShowImageActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ShowImageActivity.class));
            }
        });



    }
}
