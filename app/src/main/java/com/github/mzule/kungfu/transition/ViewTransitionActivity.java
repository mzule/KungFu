package com.github.mzule.kungfu.transition;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

import com.github.mzule.kungfu.R;

/**
 * Created by CaoDongping on 8/1/16.
 */
public class ViewTransitionActivity extends Activity {

    private ViewGroup root;
    private View textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_transition);
        root = (ViewGroup) findViewById(R.id.container);
        textView = findViewById(R.id.textView);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void doAnimate(View v) {
        TransitionManager.beginDelayedTransition(root);
        textView.setSelected(!textView.isSelected());
        textView.setVisibility(textView.isSelected() ? View.VISIBLE : View.GONE);
    }
}
