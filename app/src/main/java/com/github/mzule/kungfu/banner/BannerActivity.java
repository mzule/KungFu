package com.github.mzule.kungfu.banner;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mzule.kungfu.R;

/**
 * Created by CaoDongping on 5/25/16.
 */
public class BannerActivity extends FragmentActivity {
    private static final int BANNER_SIZE = 7;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return BANNER_SIZE + 2;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                TextView textView = new TextView(getApplicationContext());
                textView.setGravity(Gravity.CENTER);
                String text = String.valueOf(position - 1);
                if (position == 0) {
                    text = String.valueOf(BANNER_SIZE - 1);
                } else if (position == BANNER_SIZE + 1) {
                    text = "0";
                }
                textView.setText(text);
                textView.setTextColor(Color.BLACK);
                container.addView(textView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                return textView;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }

            @Override
            public void finishUpdate(ViewGroup container) {
                int currentItem = viewPager.getCurrentItem();
                if (currentItem == 0) {
                    viewPager.setCurrentItem(BANNER_SIZE, false);
                } else if (currentItem == BANNER_SIZE + 1) {
                    viewPager.setCurrentItem(1, false);
                }
            }
        });
        viewPager.setCurrentItem(1);
    }
}
