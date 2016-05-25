package com.github.mzule.kungfu.design;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.github.mzule.kungfu.R;

/**
 * Created by CaoDongping on 5/25/16.
 */
public class AppBarActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appbar);
    }
}
