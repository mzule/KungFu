package com.github.mzule.kungfu;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.github.mzule.kungfu.palette.PaletteActivity;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void palette(View v) {
        startActivity(PaletteActivity.makeIntent(this));
    }
}
