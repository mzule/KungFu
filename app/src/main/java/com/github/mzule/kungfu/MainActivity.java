package com.github.mzule.kungfu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.github.mzule.kungfu.autovalue.UserActivity;
import com.github.mzule.kungfu.banner.BannerActivity;
import com.github.mzule.kungfu.classloader.ClassLoaderActivity;
import com.github.mzule.kungfu.deeplink.DeepLinkActivity;
import com.github.mzule.kungfu.design.AppBarActivity;
import com.github.mzule.kungfu.design.CoordinatorActivity;
import com.github.mzule.kungfu.imageprocess.ColorFilterActivity;
import com.github.mzule.kungfu.nuwa.NuwaActivity;
import com.github.mzule.kungfu.palette.PaletteActivity;
import com.github.mzule.kungfu.rxjava.RxImageActivity;
import com.github.mzule.kungfu.transition.ViewTransitionActivity;
import com.github.mzule.kungfu.xmlpull.XmlPullActivity;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout container = (LinearLayout) findViewById(R.id.container);

        Class[] classes = new Class[]{
                PaletteActivity.class,
                ClassLoaderActivity.class,
                XmlPullActivity.class,
                NuwaActivity.class,
                DeepLinkActivity.class,
                UserActivity.class,
                RxImageActivity.class,
                ColorFilterActivity.class,
                CoordinatorActivity.class,
                BannerActivity.class,
                AppBarActivity.class,
                ViewTransitionActivity.class,
        };
        for (final Class cls : classes) {
            Button button = new Button(this);
            container.addView(button, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            button.setText(cls.getSimpleName());
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, cls));
                }
            });
        }
    }
}
