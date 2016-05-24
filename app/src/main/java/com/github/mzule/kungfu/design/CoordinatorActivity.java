package com.github.mzule.kungfu.design;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.github.mzule.kungfu.R;

/**
 * Created by CaoDongping on 5/24/16.
 */
public class CoordinatorActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);

        findViewById(R.id.floatButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "This is snack", Snackbar.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.textButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "This is snack ha ha", Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}
