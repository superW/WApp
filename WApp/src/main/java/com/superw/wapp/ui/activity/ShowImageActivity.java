package com.superw.wapp.ui.activity;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.superw.wapp.R;
import com.superw.wapp.helper.transformer.ZoomOutPageTransformer;
import com.superw.wapp.view.swipeback.SwipeBackActivity;

public class ShowImageActivity extends SwipeBackActivity {

    private ViewPager viewPager;
    private int[] ress = {R.mipmap.a1, R.mipmap.a2, R.mipmap.a3,
            R.mipmap.a4, R.mipmap.a5, R.mipmap.a6, R.mipmap.a7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);

        setTitle(getLocalClassName());

        viewPager = (ViewPager) findViewById(R.id.vpShowImage);
        viewPager.setAdapter(new MyPagerAdapter());

        //设置切换动画
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
//        viewPager.setPageMargin(getResources().getDimensionPixelOffset(R.dimen.viewpager_margin));
        viewPager.setOffscreenPageLimit(ress.length);
    }


    private class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return ress.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = new ImageView(ShowImageActivity.this);
            imageView.setImageResource(ress[position]);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }

}
